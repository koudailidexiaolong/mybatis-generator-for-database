# mybatis-generator-for-database
mybatis-generator-for-database xml生成工具

基于源码版本 1.3.2 

### 2021-10-24

修改点：

 	1. 增加xml和java类中生成的注释 
 	2. 增加get、set 方法生成基于数据库字段中文描述注释
 	3. 增加通用查询方法 selectBySelective 
 	4. 增加xml中 String 类型字段 字符串判断是否为空问题





#### 1. 增加xml和java类中生成的注释 

```xml

<commentGenerator>
    <!-- 是否所有的注释生成 
   <property name="suppressAllComments" value="true" />-->
    <!-- 注释是否增加日期 
   <property name="suppressDate" value="true" />-->
    <!-- 是否生成默认注释  
   <property name="suppressDefaultDesc" value="true" />-->
    以下两个为自定义属性配置
    <!-- XML注释  是否不生成  false 为 生成 true 为 跳过不生成-->
    <property name="suppressXMLComments" value="true" />
    <!-- 生成的方法中是否不增加 注释  -->
    <property name="suppressMethodComments" value="true" />
</commentGenerator>
```



#### 2. 增加get、set 方法生成基于数据库字段中文描述注释

```java
	/**
     * 用户登录名
     * This field corresponds to the database column system_user.user_id
     *
     * @author julong 2021-10-24 06:02:43
     */
    private String userId;
 	/**
     * 用户登录名
     * 
     * This method returns the value of the database column system_user.user_id
     *
     * @return the value of system_user.user_id
     *
     * @author julong 2021-10-24 06:02:43
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户登录名
     * 
     * This method sets the value of the database column system_user.user_id
     *
     * @param userId the value for system_user.user_id
     *
     * @author julong 2021-10-24 06:02:43
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
```



#### 3. 增加通用查询方法 selectBySelective

默认的配置文件中只有 以下方法

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.julong.market.dao.SystemUserInfoMapper" >
  <resultMap id="BaseResultMap" type="com.julong.market.dao.entity.SystemUserInfo" >
    <id column="user_id" property="userId" jdbcType="VARCHAR" />
    <result column="user_reserve_c" property="userReserveC" jdbcType="VARCHAR" />
  </resultMap>
  <sql id="Base_Column_List" >
    user_id,  user_reserve_c
  </sql>
  <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.String" >
    select 
    <include refid="Base_Column_List" />
    from system_user
    where user_id = #{userId,jdbcType=VARCHAR}
  </select>
  <delete id="deleteByPrimaryKey" parameterType="java.lang.String" >
    delete from system_user
    where user_id = #{userId,jdbcType=VARCHAR}
  </delete>
  <insert id="insert" parameterType="com.julong.market.dao.entity.SystemUserInfo" >
    insert into system_user (user_id, user_reserve_c
      )
    values (#{userId,jdbcType=VARCHAR},  #{userReserveC,jdbcType=VARCHAR}
      )
  </insert>
  <insert id="insertSelective" parameterType="com.julong.market.dao.entity.SystemUserInfo" >
    insert into system_user
    <trim prefix="(" suffix=")" suffixOverrides="," >
      <if test="userId != null and userId != '' " >
        user_id,
      </if>
      <if test="userReserveC != null and userReserveC != '' " >
        user_reserve_c,
      </if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
      <if test="userId != null and userId != '' " >
        #{userId,jdbcType=VARCHAR},
      </if>
      <if test="userReserveC != null and userReserveC != '' " >
        #{userReserveC,jdbcType=VARCHAR},
      </if>
    </trim>
  </insert>
  <update id="updateByPrimaryKeySelective" parameterType="com.julong.market.dao.entity.SystemUserInfo" >
    update system_user
    <set >
      <if test="userReserveC != null and userReserveC != ''" >
        user_reserve_c = #{userReserveC,jdbcType=VARCHAR},
      </if>
    </set>
    where user_id = #{userId,jdbcType=VARCHAR}
  </update>
  <update id="updateByPrimaryKey" parameterType="com.julong.market.dao.entity.SystemUserInfo" >
    update system_user user_reserve_c = #{userReserveC,jdbcType=VARCHAR}
    where user_id = #{userId,jdbcType=VARCHAR}
  </update>
    
    <!-- 此方法 为增加的方法 -->
  <select id="selectBySelective" resultMap="BaseResultMap" parameterType="com.julong.market.dao.entity.SystemUserInfo" >
    select 
    <include refid="Base_Column_List" />
    from system_user
    <where >
      <if test="userId != null and userId != ''" >
         AND user_id = #{userId,jdbcType=VARCHAR}
      </if>
      <if test="userReserveC != null and userReserveC != ''" >
         AND user_reserve_c = #{userReserveC,jdbcType=VARCHAR}
      </if>
    </where>
  </select>
</mapper>

```



#### 4.增加xml中 String 类型字段 字符串判断是否为空问题

```xml
默认生成的xml 
<if test="userReserveC != null" >
    AND user_reserve_c = #{userReserveC,jdbcType=VARCHAR}
</if>
修改后生成的xml
<if test="userReserveC != null and userReserveC != ''" >
    AND user_reserve_c = #{userReserveC,jdbcType=VARCHAR}
</if>
```

