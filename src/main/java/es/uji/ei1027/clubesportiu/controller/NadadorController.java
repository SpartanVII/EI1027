package es.uji.ei1027.clubesportiu.controller;

import es.uji.ei1027.clubesportiu.dao.NadadorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nadador")
public class NadadorController {

    private NadadorDAO nadadorDao;

    @Autowired
    public void setNadadorDao(NadadorDAO nadadorDao) {
        this.nadadorDao=nadadorDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    @RequestMapping("/list")
    public String listNadadors(Model model) {
        model.addAttribute("nadadors", nadadorDao.getNadadors());
        return "nadador/list";
    }


}
