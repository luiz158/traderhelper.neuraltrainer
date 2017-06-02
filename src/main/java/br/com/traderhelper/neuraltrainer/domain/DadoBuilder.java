package br.com.traderhelper.neuraltrainer.domain;

import br.com.traderhelper.neuraltrainer.entity.Acao;
import br.com.traderhelper.neuraltrainer.entity.Cotacao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Michael Sta. Helena on 01/06/2017.
 */
public final class DadoBuilder {
    //ACAO_ID
    private long idAcao;
    //CODNEG
    private String codAcao;
    //DATAPG
    private Date data;
    //PREULT - PREÇO DO ÚLTIMO NEGÓCIO DO PAPEL-MERCADO NO PREGÃO (FECHAMENTO)
    private BigDecimal fechamento;
    //PREABE - PREÇO DE ABERTURA DO PAPEL-MERCADO NO PREGÃO
    private BigDecimal abertura;
    //PREMIN - PREÇO MÍNIMO DO PAPEL MERCADO NO PREGÃO
    private BigDecimal minima;
    //PREMED - PREÇO MÉDIO DO PAPEL MERCADO NO PREGÃO
    private BigDecimal media;
    //PREMAX - PREÇO MÁXIMO DO PAPEL-MERCADO NO PREGÃO
    private BigDecimal maxima;
    //VOLTOT - VOLUME TOTAL DE TÍTULOS NEGOCIADOS NESTE PAPEL MERCADO
    private BigDecimal volume;
    //TOTNEG - NEG. - NÚMERO DE NEGÓCIOS EFETUADOS COM O PAPEL MERCADO NO PREGÃO
    private BigInteger negocios;
    //QUATOT - QUANTIDADE TOTAL DE TÍTULOS NEGOCIADOS NESTE PAPEL MERCADO
    private BigInteger quantidade;

    public DadoBuilder() {
    }

    public DadoBuilder(Acao acao, Cotacao cotacao) {
        comIdAcao(acao.getId());
        comCodAcao(acao.getCodigoPapel());
        comData(cotacao.getDataPregao());
        comFechamento(cotacao.getPrecoUltimoNegocio());
        comAbertura(cotacao.getPrecoAbertura());
        comMinima(cotacao.getPrecoMinimo());
        comMedia(cotacao.getPrecoMedio());
        comMaxima(cotacao.getPrecoMaximo());
        comVolume(cotacao.getVolumeTitulosNegociados());
        comNegocios(cotacao.getTotalNegociosEfetuados());
        comQuantidade(cotacao.getTotalTitulosNegociados());
    }

    public static DadoBuilder aDado() {
        return new DadoBuilder();
    }

    public DadoBuilder comIdAcao(long idAcao) {
        this.idAcao = idAcao;
        return this;
    }

    public DadoBuilder comCodAcao(String codAcao) {
        this.codAcao = codAcao;
        return this;
    }

    public DadoBuilder comData(Date data) {
        this.data = data;
        return this;
    }

    public DadoBuilder comFechamento(BigDecimal fechamento) {
        this.fechamento = fechamento;
        return this;
    }

    public DadoBuilder comAbertura(BigDecimal abertura) {
        this.abertura = abertura;
        return this;
    }

    public DadoBuilder comMinima(BigDecimal minima) {
        this.minima = minima;
        return this;
    }

    public DadoBuilder comMedia(BigDecimal media) {
        this.media = media;
        return this;
    }

    public DadoBuilder comMaxima(BigDecimal maxima) {
        this.maxima = maxima;
        return this;
    }

    public DadoBuilder comVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    public DadoBuilder comNegocios(BigInteger negocios) {
        this.negocios = negocios;
        return this;
    }

    public DadoBuilder comQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Dado build() {
        Dado dado = new Dado();
        dado.setIdAcao(idAcao);
        dado.setCodAcao(codAcao);
        dado.setData(data);
        dado.setFechamento(fechamento);
        dado.setAbertura(abertura);
        dado.setMinima(minima);
        dado.setMedia(media);
        dado.setMaxima(maxima);
        dado.setVolume(volume);
        dado.setNegocios(negocios);
        dado.setQuantidade(quantidade);
        return dado;
    }
}
