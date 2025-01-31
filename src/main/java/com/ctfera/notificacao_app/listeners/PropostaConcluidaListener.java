package com.ctfera.notificacao_app.listeners;

import com.ctfera.notificacao_app.constante.MensagemConstante;
import com.ctfera.notificacao_app.domain.Proposta;
import com.ctfera.notificacao_app.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class PropostaConcluidaListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    //Listener para file de proposta concluída/aprovada
    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta){
        String nome = proposta.getUsuario().getNome();
        String mensagem = String.format(MensagemConstante.PROPOSTA_APROVADA, nome);
        String telefone = proposta.getUsuario().getTelefone();
        notificacaoSnsService.notificar(telefone, mensagem);
    }
}
