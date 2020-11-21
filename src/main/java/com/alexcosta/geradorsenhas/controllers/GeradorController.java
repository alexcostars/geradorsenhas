package com.alexcosta.geradorsenhas.controllers;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeradorController {
    private final String[] CARACTERES = {"a","b","c","d","e","f","g","1","2","3","4","5","6","7","8","9","0","$","#","&","*","?"};
    private static ArrayList<String> historico = new ArrayList<String>();

    private String gerarSenha() {
        Random rand = new Random();
        String senha = "";
        for(int i = 0; i < 10; i++) {
            String caractere = null;
            do {
                caractere = CARACTERES[rand.nextInt(CARACTERES.length)];
                if(rand.nextInt(2) > 0) {
                    caractere = caractere.toUpperCase();
                }
            } while(senha.contains(caractere));
            senha += caractere;
        }
        return senha;
    }

    @GetMapping("/")
    public String home(Model model) {
        String senha = this.gerarSenha();
        historico.add(0, senha);
        model.addAttribute("senha", senha);
        model.addAttribute("historico", GeradorController.historico);
        return "home";
    }
}
