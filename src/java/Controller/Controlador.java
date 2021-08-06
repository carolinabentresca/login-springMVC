/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import Entity.usuarios;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author EXO
 */
@Controller
public class Controlador {

    Conexion conexion = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "registrar.htm", method = RequestMethod.GET)
    public ModelAndView Registrar() {
        mv.addObject(new usuarios());
        mv.setViewName("registrar");
        return mv;
    }

    @RequestMapping(value = "registrar.htm", method = RequestMethod.POST)
    public ModelAndView Registrar(usuarios us) {
        String sql = "insert into usuarios(usuario,password)values(?,?)";
        try {
            this.jdbcTemplate.update(sql, us.getUsuario(), us.getPassword());
            return new ModelAndView("redirect:/index.htm");
        } catch (DataAccessException e) {
            e.getMessage();
        }
        return mv;
    }

    @RequestMapping(value = "menuBienvenida.htm", method = RequestMethod.GET)
    public ModelAndView getMenu() {
        mv.setViewName("menuBienvenida");
        return mv;
    }

    @RequestMapping(value = "index.htm", method = RequestMethod.POST)
    public ModelAndView Login(usuarios us) {
        String sql = "select usuario from usuarios where usuario = ? and password = ?";
        try {
            String usuario = this.jdbcTemplate.queryForObject(sql, new Object[]{us.getUsuario(), us.getPassword()}, String.class);
            if (usuario.equals("")) {
                mv.setViewName("index");
            } else {
                mv.setViewName("menuBienvenida");
            }

        } catch (DataAccessException e) {
            e.getMessage();
        }
        return mv;
    }

}
