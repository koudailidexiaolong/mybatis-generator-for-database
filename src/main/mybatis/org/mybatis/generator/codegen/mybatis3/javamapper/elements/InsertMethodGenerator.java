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
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 全字段插入方法
 * @author julong
 * @date 2023年11月25日 上午9:58:13
 * @desc 
 */
public class InsertMethodGenerator extends AbstractJavaMapperMethodGenerator {

    private boolean isSimple;

    public InsertMethodGenerator(boolean isSimple) {
        super();
        this.isSimple = isSimple;
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Method method = new Method();
        //设置方法类型
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        //设置方法类型
        method.setVisibility(JavaVisibility.PUBLIC);
        //设置方法名
        method.setName(introspectedTable.getInsertStatementId());
        FullyQualifiedJavaType parameterType;
        if (isSimple) {
            parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        } else {
            parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        }

        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        importedTypes.add(parameterType);
        
        //组装参数名
        String paramName = parameterType.getShortNameWithoutTypeArguments();
        String record = FullyQualifiedJavaType.getParameterAlias(paramName);
        
        //设置方法参数
        method.addParameter(new Parameter(parameterType, record)); //$NON-NLS-1$

        //设置方法注释
        context.getCommentGenerator().addGeneralMethodComment(method,introspectedTable);

        //添加方法注解
        addMapperAnnotations(method);

        if (context.getPlugins().clientInsertMethodGenerated(method, interfaze,introspectedTable)) {
            addExtraImports(interfaze);
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

    public void addMapperAnnotations(Method method) {
    }

    public void addExtraImports(Interface interfaze) {
    }
}
