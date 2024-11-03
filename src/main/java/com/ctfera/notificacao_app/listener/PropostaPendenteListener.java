package com.ctfera.notificacao_app.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}") //Annotation para criar Listener, definindo a queue
    public void propostaPendente(){

    }
}
