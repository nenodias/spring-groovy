package io.github.nenodias.springgroovy.controllers;

import io.github.nenodias.springgroovy.container.ScriptingContainer;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/groovy")
public class GroovyController {
    
    private static final Logger LOGGER = Logger.getLogger(GroovyController.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private ScriptingContainer groovy;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        try{
            groovy.put("jdbc", jdbcTemplate);
            List<Map<String, Object>> retorno = (List) groovy.run(getClass().getResource("/groovy/info.groovy"));
            if(retorno != null && !retorno.isEmpty()){
                Map<String, Object> hash = retorno.get(0);
                System.out.println(hash.keySet());
                System.out.println(hash);
                System.out.println(retorno.get(0).getClass());
            }else{
                System.out.println(retorno);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            LOGGER.error(ex.getMessage(), ex);
        }
        return new ModelAndView("info");
    }

}