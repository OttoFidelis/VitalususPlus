package com.vitalususPlus.VitalususPlus.controller;

import com.vitalususPlus.VitalususPlus.model.Admin;
import com.vitalususPlus.VitalususPlus.model.Treinador;
import com.vitalususPlus.VitalususPlus.model.Usuario;
import com.vitalususPlus.VitalususPlus.repository.AdminRepository;
import com.vitalususPlus.VitalususPlus.repository.TreinadorRepository;
import com.vitalususPlus.VitalususPlus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//localhost:8080/Vitalusus-2h/Clientes/listaClientes --> -->
//--> --> endereço para adiantar para quem for entrar na página para ver se tá tudo certo na parte web ;)

//Começo da classe
@Controller
//código que define os endereços das páginas, as "/" GetMappings vem depois disso. Exemplo "/Vitalusus-2h/Clientes/ListaClientes"
@RequestMapping("/Vitalusus-2h/Clientes")
public class UsuarioController {

    //negócio que liga dá acesso ao repository do usuário
    @Autowired
    private UsuarioRepository usuarioRepository;

    //negócio que liga dá acesso ao repository do treinador
    @Autowired
    private TreinadorRepository treinadorRepository;

    //negócio que liga dá acesso ao repository do administrador
    @Autowired
    private AdminRepository adminRepositoryy;

    //código que cria a localiação da página index
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //código que cria a localiação da página cadastrar
    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "CADASTRAR";
    }

    //código que coloca os registros digitados pelo usuário ao cadastrar no banco de dados
    @PostMapping("/cadastrar")
    public String enviarCadastro(Usuario usuario, Treinador treinador, Admin admin){
        usuario.setStatusUsuario("ativo");
        usuarioRepository.save(usuario);
        return "redirect:/Vitalusus-2h/Clientes/clienteSucesso";
    }

    //código que cria a localiação da página clienteSucesso
    @GetMapping("/clienteSucesso")
    public String clienteSucesso(){
        return "clienteSucesso";
    }

    //código que cria a localiação da página listaCLientes
    @GetMapping("/listaClientes")
    public ModelAndView usuarios(){
        ModelAndView mv = new ModelAndView("clientes");
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios",usuarios);
        return mv;
    }

    //código que cria a localiação da página login
    @GetMapping("/login")
    public String showFormLogin(){
        return "login";
    }
    //código que verifica se o login e senha que o usuário digitou são válidos
    @PostMapping("/login")
    public String efetuarLogin(@ModelAttribute Usuario usuario){
        String page = "redirect:/Vitalusus-2h/Clientes/login";

        Usuario usuarioDb = usuarioRepository.findByLogin(usuario.getEmail(), usuario.getSenha());
        if (usuarioDb !=null && usuario.getSenha().equals(usuarioDb.getSenha())&&usuario.getEmail().equals(usuario.getEmail())){
            page = "redirect:/Vitalusus-2h/Clientes/HomeTreinador";
        }
        return page;
    }

    //código que cria a localiação da página homeTreinaodor
    @RequestMapping("/HomeTreinador")
    public ModelAndView usuariodetalhes(Usuario usuario){
        ModelAndView mv = new ModelAndView("HomeTreinador");
        mv.addObject("usuario",usuario);
        return mv;
    }
    //código que cria a localiação da página configT
    @GetMapping("/configT")
    public String config(){
        return "configT";
    }

}



