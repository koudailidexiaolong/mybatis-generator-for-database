/**
 *    Copyright 2006-2018 the original author or authors.
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
package org.mybatis.generator.config;

/**
 * This class holds constants for all properties recognized by the different
 * configuration elements. This helps document and maintain the different
 * properties, and helps to avoid spelling errors.
 * 
 * @author Jeff Butler
 * 
 */
public class PropertyRegistry {
    public static final String ANY_ENABLE_SUB_PACKAGES = "enableSubPackages"; //$NON-NLS-1$

    /**
     * recognized by table and java model generator
     */
    public static final String ANY_ROOT_CLASS = "rootClass"; //$NON-NLS-1$
    public static final String ANY_IMMUTABLE = "immutable"; //$NON-NLS-1$
    public static final String ANY_CONSTRUCTOR_BASED = "constructorBased"; //$NON-NLS-1$

    /**
     * recognized by table and java client generator
     */
    public static final String ANY_ROOT_INTERFACE = "rootInterface"; //$NON-NLS-1$

    public static final String TABLE_USE_COLUMN_INDEXES = "useColumnIndexes"; //$NON-NLS-1$
    public static final String TABLE_USE_ACTUAL_COLUMN_NAMES = "useActualColumnNames"; //$NON-NLS-1$
    
    /**
     * xml文件中是否判断空字符串
     * @author julong
     * @date 2021年10月26日 上午11:01:36
     */
    public static final String XML_MAPPER_APPEND_EMPTY_STRING = "XmlMapperAppendEmptyString"; //$NON-NLS-1$

    
    
    public static final String TABLE_USE_COMPOUND_PROPERTY_NAMES = "useCompoundPropertyNames"; //$NON-NLS-1$
    public static final String TABLE_IGNORE_QUALIFIERS_AT_RUNTIME = "ignoreQualifiersAtRuntime"; //$NON-NLS-1$
    public static final String TABLE_RUNTIME_CATALOG = "runtimeCatalog"; //$NON-NLS-1$
    public static final String TABLE_RUNTIME_SCHEMA = "runtimeSchema"; //$NON-NLS-1$
    public static final String TABLE_RUNTIME_TABLE_NAME = "runtimeTableName"; //$NON-NLS-1$
    public static final String TABLE_MODEL_ONLY = "modelOnly"; //$NON-NLS-1$
    public static final String TABLE_SELECT_ALL_ORDER_BY_CLAUSE = "selectAllOrderByClause"; //$NON-NLS-1$

    public static final String CONTEXT_BEGINNING_DELIMITER = "beginningDelimiter"; //$NON-NLS-1$
    public static final String CONTEXT_ENDING_DELIMITER = "endingDelimiter"; //$NON-NLS-1$
    public static final String CONTEXT_AUTO_DELIMIT_KEYWORDS = "autoDelimitKeywords"; //$NON-NLS-1$
    /**
     * 文件编码
     * @author julong
     * @date 2021年10月25日 下午8:24:40
     */
    public static final String CONTEXT_JAVA_FILE_ENCODING = "javaFileEncoding"; //$NON-NLS-1$
    public static final String CONTEXT_JAVA_FORMATTER = "javaFormatter"; //$NON-NLS-1$
    public static final String CONTEXT_XML_FORMATTER = "xmlFormatter"; //$NON-NLS-1$

    public static final String CLIENT_USE_LEGACY_BUILDER = "useLegacyBuilder"; //$NON-NLS-1$
    
    public static final String DAO_EXAMPLE_METHOD_VISIBILITY = "exampleMethodVisibility"; //$NON-NLS-1$
    public static final String DAO_METHOD_NAME_CALCULATOR = "methodNameCalculator"; //$NON-NLS-1$

    public static final String TYPE_RESOLVER_FORCE_BIG_DECIMALS = "forceBigDecimals"; //$NON-NLS-1$
    public static final String TYPE_RESOLVER_USE_JSR310_TYPES = "useJSR310Types"; //$NON-NLS-1$
    
    /**
     * trimStrings 方法
     * @author julong
     * @date 2021年10月24日 下午6:59:40
     */
    public static final String MODEL_GENERATOR_TRIM_STRINGS = "trimStrings"; //$NON-NLS-1$

    /**
     * 增加字段描述注释
     * @author julong
     * @date 2021年10月25日 下午12:22:46
     */
    public static final String COMMENT_GENERATOR_ADD_REMARK_COMMENTS = "addRemarkComments"; //$NON-NLS-1$
    
    /**
     * 格式化日期注释 可以通过配置文件配置
     * @author julong
     * @date 2021年10月25日 下午12:21:47
     */
    public static final String COMMENT_GENERATOR_DATE_FORMAT = "dateFormat"; //$NON-NLS-1$
    
    /**
     * 时间注释
     * @author julong
     * @date 2021年10月21日 下午1:25:42
     */
    public static final String COMMENT_GENERATOR_SUPPRESS_DATE = "suppressDate"; //$NON-NLS-1$
   
    
    /**
     * 所有的注释
     * @author julong
     * @date 2021年10月21日 下午1:24:18
     */
    public static final String COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS = "suppressAllComments"; //$NON-NLS-1$
    
    
    /**
     * xml文件中注释
     * @author julong
     * @date 2021年10月21日 下午1:23:52
     */
    public static final String COMMENT_GENERATOR_SUPPRESS_XML_COMMENTS = "suppressXMLComments"; //$NON-NLS-1$
    
    /**
     * 生成详细描述
     * @author julong
     * @date 2021年10月21日 下午1:23:30
     */
    public static final String COMMENT_GENERATOR_SUPPRESS_DEFAULT_DESCRIPTION = "suppressDefaultDescription"; //$NON-NLS-1$
   
    
    /**
     * 生成的方法默认注释
     * @author julong
     * @date 2021年10月21日 下午1:23:14
     */
    public static final String COMMENT_GENERATOR_SUPPRESS_METHOD_COMMENTS = "suppressMethodComments"; //$NON-NLS-1$

    /**
     * xmlsql文件中if条件是否增加 空字符串判断
     * @author julong
     * @date 2021年10月21日 下午1:23:14
     */
    public static final String COMMENT_GENERATOR_SUPPRESS_XML_METHOD_EMPTY_STRING = "suppressXMLMethodEmptyString"; //$NON-NLS-1$

    
}
