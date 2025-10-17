package org.serratec.serratecmusic.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {

    private Integer status;
    private String mensagem;
    private LocalDateTime dataHora;
    private List<String> erros;

    public ErroResposta() {}

    public ErroResposta(Integer status, String mensagem, LocalDateTime dataHora, List<String> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
        this.erros = erros;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}