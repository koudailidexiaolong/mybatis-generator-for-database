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

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.internal.DefaultCommentGenerator;


/**
 * 条件查询总数
 * @author julong
 * @date 2021年10月25日 下午1:29:04
 * @desc 
 */
public class SelectCountBySelectiveElementGenerator extends AbstractXmlElementGenerator {

    public SelectCountBySelectiveElementGenerator() {
        super();
    }
    
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute("id", introspectedTable.getSelectCountBySelectiveStatementId())); //$NON-NLS-1$
   
        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        
        answer.addAttribute(new Attribute("parameterType",parameterType.getFullyQualifiedName())); //$NON-NLS-1$
        answer.addAttribute(new Attribute("resultType","java.lang.Integer")); //$NON-NLS-1$
        context.getCommentGenerator().addComment(answer);
        //获取系统配置
        DefaultCommentGenerator defaultCommentGenerator = (DefaultCommentGenerator) context.getCommentGenerator();
        StringBuilder sb = new StringBuilder();
        sb.append("select "); //$NON-NLS-1$

//        if (stringHasValue(introspectedTable.getSelectByPrimaryKeyQueryId())) {
//            sb.append('\'');
//            sb.append(introspectedTable.getSelectByPrimaryKeyQueryId());
//            sb.append("' as QUERYID,"); //$NON-NLS-1$
//        }
        answer.addElement(new TextElement(sb.toString()));
//        answer.addElement(getBaseColumnListElement());
//        if (introspectedTable.hasBLOBColumns()) {
//            answer.addElement(new TextElement(",")); //$NON-NLS-1$
//            answer.addElement(getBlobColumnListElement());
//        }
        answer.addElement(new TextElement(" count(*) ")); //$NON-NLS-1$
        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));

        //条件查询
        XmlElement dynamicElement = new XmlElement("where"); //$NON-NLS-1$
		answer.addElement(dynamicElement);
	    Set<Integer> sets = new HashSet<Integer>();
        sets.add(Types.BIGINT);
        sets.add(Types.BIT);
        sets.add(Types.DATE);
        sets.add(Types.DECIMAL);
        sets.add(Types.BOOLEAN);
        sets.add(Types.TINYINT);
        sets.add(Types.DOUBLE);
        sets.add(Types.FLOAT);
        sets.add(Types.INTEGER);
        sets.add(Types.NUMERIC);
        sets.add(Types.TIME);
        sets.add(Types.TIMESTAMP);
        sets.add(Types.TIMESTAMP_WITH_TIMEZONE);
        sets.add(Types.TIME_WITH_TIMEZONE);
		for (IntrospectedColumn introspectedColumn : ListUtilities.removeGeneratedAlwaysColumns(introspectedTable.getAllColumns())) {
			sb.setLength(0);
			XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
			if(sets.contains(introspectedColumn.getJdbcType())){
				sb.append(introspectedColumn.getJavaProperty());
				sb.append(" != null "); //$NON-NLS-1$
			}else{
                sb.append(introspectedColumn.getJavaProperty());
                sb.append(" != null "); //$NON-NLS-1$
                //阻止 追加
//                if(defaultCommentGenerator.isSuppressXMLMethodEmptyString() == false){
                    sb.append(" and "); //$NON-NLS-1$
                    sb.append(introspectedColumn.getJavaProperty());
                    sb.append(" != '' "); //$NON-NLS-1$
//                }
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
        if (context.getPlugins().sqlMapSelectCountBySelectiveElementGenerated(answer,introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
