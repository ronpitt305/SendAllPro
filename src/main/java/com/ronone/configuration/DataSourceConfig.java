package com.ronone.configuration;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
public class DataSourceConfig
{
  public DataSourceConfig() {}
  
  @Bean
  @Primary
  @ConfigurationProperties(prefix="spring.ds_email")
  public DataSource emailUserDataSource()
  {
    return DataSourceBuilder.create().build();
  }
}
