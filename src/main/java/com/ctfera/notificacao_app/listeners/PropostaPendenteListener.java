package com.ctfera.notificacao_app.listeners;

import com.ctfera.notificacao_app.constante.MensagemConstante;
import com.ctfera.notificacao_app.domain.Proposta;
import com.ctfera.notificacao_app.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;


    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}") //Annotation para criar Listener, definindo a queue
    public void propostaPendente(Proposta proposta){
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);

    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta){
        String nome = proposta.getUsuario().getNome();
    }
}
