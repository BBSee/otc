package com.otc.platform.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Created by zhangzp on 2018/8/27.
 */
@Configuration
public class MyBatisConfig {
  private static final String MAPPER_LOCATION = "classpath:com/otc/**/*Mapper.xml";

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());
    sqlSessionFactoryBean.setMapperLocations(
        new PathMatchingResourcePatternResolver()
            .getResources(MAPPER_LOCATION));
    return sqlSessionFactoryBean.getObject();
  }

}
