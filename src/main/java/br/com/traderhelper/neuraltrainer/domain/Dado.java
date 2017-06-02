package br.com.traderhelper.neuraltrainer.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Michael Sta. Helena on 01/06/2017.
 */
public class Dado {

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

    public long getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(long idAcao) {
        this.idAcao = idAcao;
    }

    public String getCodAcao() {
        return codAcao;
    }

    public void setCodAcao(String codAcao) {
        this.codAcao = codAcao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getFechamento() {
        return fechamento;
    }

    public void setFechamento(BigDecimal fechamento) {
        this.fechamento = fechamento;
    }

    public BigDecimal getAbertura() {
        return abertura;
    }

    public void setAbertura(BigDecimal abertura) {
        this.abertura = abertura;
    }

    public BigDecimal getMinima() {
        return minima;
    }

    public void setMinima(BigDecimal minima) {
        this.minima = minima;
    }

    public BigDecimal getMedia() {
        return media;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    public BigDecimal getMaxima() {
        return maxima;
    }

    public void setMaxima(BigDecimal maxima) {
        this.maxima = maxima;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigInteger getNegocios() {
        return negocios;
    }

    public void setNegocios(BigInteger negocios) {
        this.negocios = negocios;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Dado{" +
                "idAcao=" + idAcao +
                ", codAcao='" + codAcao + "'" +
                ", data=" + data +
                ", fechamento=" + fechamento +
                ", abertura=" + abertura +
                ", minima=" + minima +
                ", media=" + media +
                ", maxima=" + maxima +
                ", volume=" + volume +
                ", negocios=" + negocios +
                ", quantidade=" + quantidade +
                "}";
    }
}
