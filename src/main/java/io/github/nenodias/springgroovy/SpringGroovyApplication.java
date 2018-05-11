package io.github.nenodias.springgroovy;

import io.github.nenodias.springgroovy.container.ScriptingContainer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringGroovyApplication {

    private static final Logger LOGGER = Logger.getLogger(SpringGroovyApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(SpringGroovyApplication.class, args);
    }
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Bean
    public ScriptingContainer groovyContainer(){
        ScriptingContainer groovy = new ScriptingContainer();
        return groovy;
    }
    
    @Bean
    public SmartInitializingSingleton importProcessor() {
        return () -> {
            final JdbcTemplate jdbc = applicationContext.getBean(JdbcTemplate.class);
            try{
                jdbc.execute("SELECT 1 FROM users");
            }catch(Exception ex){
                LOGGER.error(ex.getMessage());
                jdbc.execute("CREATE TABLE users(id int auto_increment primary key, name varchar(200) not null, email varchar(200) not null, password varchar(200) not null, idade int)");
                jdbc.execute("INSERT INTO users(name, email, password, idade) VALUES('Horácio','horacio@gmail.com','123', 25) ");
            }
            System.out.println("Started");
        };
    }

}
