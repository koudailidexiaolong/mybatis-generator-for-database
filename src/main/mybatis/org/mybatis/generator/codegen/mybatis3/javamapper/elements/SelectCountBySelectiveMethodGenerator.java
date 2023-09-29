/**
 *    Copyright 2006-2017 the original author or authors.
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
package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;

/**
 * 根据条件查询总数
 * 
 * @author julong
 * @date 2021年11月1日 下午8:20:09
 * @desc
 */
public class SelectCountBySelectiveMethodGenerator extends AbstractJavaMapperMethodGenerator {

    public SelectCountBySelectiveMethodGenerator() {
		super();
		// TODO 自定义查询总数的方法
	}

	@Override
    public void addInterfaceElements(Interface interfaze) {

		Method method = new Method();

        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName(introspectedTable.getSelectCountBySelectiveStatementId());

        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();

        
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        importedTypes.add(parameterType);
        //组装参数名
        String paramName = parameterType.getShortNameWithoutTypeArguments();
        String record = FullyQualifiedJavaType.getParameterAlias(paramName);
        method.addParameter(new Parameter(parameterType, record)); //$NON-NLS-1$

        context.getCommentGenerator().addGeneralMethodComment(method,introspectedTable);

        addMapperAnnotations(interfaze, method);
        
        if (context.getPlugins().clientSelectCountBySelectiveMethodGenerated(method, interfaze, introspectedTable)) {
            addExtraImports(interfaze);
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
    }

    public void addExtraImports(Interface interfaze) {
    }
}
