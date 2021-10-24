/*
 *  Copyright 2009 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * 
 * @author Jeff Butler
 * 多条件查询
 */
public class SelectBySelectiveElementGenerator extends AbstractXmlElementGenerator {

    public SelectBySelectiveElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$
//        System.out.println("introspectedTable.getSelectBySelectiveStatementId():"+introspectedTable.getSelectBySelectiveStatementId());
        answer.addAttribute(new Attribute("id", introspectedTable.getSelectBySelectiveStatementId())); //$NON-NLS-1$

        //校验是否存在大字段
        if (introspectedTable.getRules().generateResultMapWithBLOBs()) {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getResultMapWithBLOBsId()));
        } else {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getBaseResultMapId()));
        }
        
        String parameterType;

        if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
            parameterType = introspectedTable.getRecordWithBLOBsType();
        } else {
            parameterType = introspectedTable.getBaseRecordType();
        }

        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
                parameterType));

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("select "); //$NON-NLS-1$

        if (stringHasValue(introspectedTable.getSelectByPrimaryKeyQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByPrimaryKeyQueryId());
            sb.append("' as QUERYID,"); //$NON-NLS-1$
        }
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

        XmlElement dynamicElement = new XmlElement("where"); //$NON-NLS-1$
        answer.addElement(dynamicElement);
        //循环所有的列
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            if(introspectedColumn.getJdbcType() == 91 || introspectedColumn.getJdbcType() == 92 || introspectedColumn.getJdbcType() == 93){
            	 sb.append(introspectedColumn.getJavaProperty());
                 sb.append(" != null "); //$NON-NLS-1$
            }else{
            	 sb.append(introspectedColumn.getJavaProperty());
                 sb.append(" != null and "); //$NON-NLS-1$
                 sb.append(introspectedColumn.getJavaProperty());
                 sb.append(" != ''"); //$NON-NLS-1$
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

//        boolean and = false;
//        for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
//            sb.setLength(0);
//            if (and) {
//                sb.append("  and "); //$NON-NLS-1$
//            } else {
//                sb.append("where "); //$NON-NLS-1$
//                and = true;
//            }
//
//            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
//            sb.append(" = "); //$NON-NLS-1$
//            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
//            answer.addElement(new TextElement(sb.toString()));
//        }

        if (context.getPlugins().sqlMapSelectBySelectiveElementGenerated(answer,introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
