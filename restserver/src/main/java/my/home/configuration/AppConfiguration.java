package my.home.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("my.home")
@EnableTransactionManagement
@EnableJpaRepositories("my.home.repository")
@PropertySource("classpath:app.properties")
public class AppConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("datasource.driver"));
        dataSource.setUrl(env.getRequiredProperty("datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("datasource.user"));
        dataSource.setPassword(env.getRequiredProperty("datasource.password"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource){
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("my.home.entity");

        final Properties properties = new Properties();
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        factoryBean.setJpaProperties(properties);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());

        return transactionManager;
    }

}
