package br.com.traderhelper.neuraltrainer.controller;

import br.com.traderhelper.neuraltrainer.domain.Dado;
import br.com.traderhelper.neuraltrainer.service.AmostraDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by Michael on 31/05/2017.
 */
@Controller
public class MainController {

    @Autowired
    AmostraDadosService amostraDadosService;

    @RequestMapping(value = "/home")
    public String home(Map<String, Object> model) {
        model.put("message", "Spring Boot");
        return "index";
    }

    /*@GetMapping("/")*/
    @ResponseBody
    @Transactional(readOnly = true)
    @RequestMapping(value = "/dados/buscaDados")
    String buscaDados(@RequestParam String de, @RequestParam String ate, @RequestParam String codigo) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        for (Dado dado : amostraDadosService.buscaDadosNoPeriodo(formato.parse(de), formato.parse(ate), codigo)) {
            sb.append(dado.toString());
        }
        return sb.toString();
    }
}
