package react.project.moosinsa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "react.project.moosinsa.service")
@MapperScan(basePackages = {"react.project.moosinsa.mapper"})
public class DBConfig {
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@1.220.247.78:1522:orcl");
        hikariConfig.setUsername("moosinsa");
        hikariConfig.setPassword("1234");

        hikariConfig.setPoolName("oracle-freebo");
        hikariConfig.setMaximumPoolSize(5);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setMapperLocations(
        		new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*.xml"));
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
}