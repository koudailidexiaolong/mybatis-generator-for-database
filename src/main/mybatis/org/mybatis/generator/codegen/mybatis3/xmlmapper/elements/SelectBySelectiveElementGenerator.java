/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import java.sql.Types;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.internal.DefaultCommentGenerator;


/**
 * 全字段查询方法
 * @author julong
 * @date 2021年10月25日 下午1:28:55
 * @desc 
 */
public class SelectBySelectiveElementGenerator extends AbstractXmlElementGenerator {

	
    public SelectBySelectiveElementGenerator() {
        super();
    }

    
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute("id", introspectedTable.getSelectBySelectiveStatementId())); //$NON-NLS-1$
        if (introspectedTable.getRules().generateResultMapWithBLOBs()) {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getResultMapWithBLOBsId()));
        } else {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getBaseResultMapId()));
        }

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
      
        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
        		parameterType.getFullyQualifiedName()));
        //添加注释
        context.getCommentGenerator().addComment(answer);
        //获取系统配置
        DefaultCommentGenerator defaultCommentGenerator = (DefaultCommentGenerator) context.getCommentGenerator();
        //查询sql
        StringBuilder sb = new StringBuilder();
        sb.append("select "); //$NON-NLS-1$

//        if (stringHasValue(introspectedTable.getSelectBySelectiveStatementId())) {
//            sb.append('\'');
//            sb.append(introspectedTable.getSelectBySelectiveStatementId());
//            sb.append("' as QUERYID,"); //$NON-NLS-1$
//        }
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getBaseColumnListElement());
        if (introspectedTable.hasBLOBColumns()) {
            answer.addElement(new TextElement(",")); //$NON-NLS-1$
            answer.addElement(getBlobColumnListElement());
        }

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));
        //条件查询
        XmlElement dynamicElement = new XmlElement("where"); //$NON-NLS-1$
		answer.addElement(dynamicElement);
        
		for (IntrospectedColumn introspectedColumn : ListUtilities.removeGeneratedAlwaysColumns(introspectedTable.getAllColumns())) {
			sb.setLength(0);
			XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
			if(introspectedColumn.getJdbcType() != Types.VARCHAR && introspectedColumn.getJdbcType() != Types.CHAR && introspectedColumn.getJdbcType() != Types.NVARCHAR
					 && introspectedColumn.getJdbcType() != Types.NCHAR){
				sb.append(introspectedColumn.getJavaProperty());
				sb.append(" != null "); //$NON-NLS-1$
			}else{
				sb.append(introspectedColumn.getJavaProperty());
				sb.append(" != null "); //$NON-NLS-1$
                //阻止 追加
                if(defaultCommentGenerator.isSuppressXMLMethodEmptyString() == false){
                    sb.append(" and "); //$NON-NLS-1$
                    sb.append(introspectedColumn.getJavaProperty());
                    sb.append(" != '' "); //$NON-NLS-1$
                }

			}
			isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
			dynamicElement.addElement(isNotNullElement);

			sb.setLength(0);
			sb.append(" AND ");
			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(" = "); //$NON-NLS-1$
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
		

			isNotNullElement.addElement(new TextElement(sb.toString()));
		}

        if (context.getPlugins().sqlMapSelectBySelectiveElementGenerated(answer,introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
