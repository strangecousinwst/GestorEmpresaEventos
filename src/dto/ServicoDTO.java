package dto;

import enums.EstadoServico;
import java.math.BigDecimal;

/**
 * Servico Data Transfer Object
 * Esta classe permite fazer operações na aplicação baseadas na entidade Serviços.
 * 
 * @author joao
 */
public class ServicoDTO {

    private int id;
    private int idCliente;
    private String descricao;
    private EstadoServico estadoServico;
    private BigDecimal preco;

    /**
     * Método get genérico para obter ID de um Serviço.
     * @return Id de um Serviço.
     */
    public int getId() { return id; }

    /**
     * Método set genérico para definir ID de um Serviço.
     * @param id Id de um Serviço.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Método get genérico para obter o id do respectivo cliente deste Serviço.
     * @return Id do respectivo cliente deste Serviço.
     */
    public int getIdCliente() { return idCliente; }

    /**
     * Método set genérico para definir o id do respectivo cliente deste Serviço.
     * @param idCliente Id do respectivo cliente deste Serviço.
     */
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    /**
     * Método get genérico para obter a descrição deste Serviço.
     * @return Descrição deste Serviço.
     */
    public String getDescricao() { return descricao; }

    /**
     * Método set genérico para definir a descrição deste Serviço.
     * @param descricao Descrição deste Serviço.
     */
    public void setDescricao(String descricao) { this.descricao = descricao; }

    /**
     * Método get genérico para obter o estado deste Serviço.
     * @return Estado do Serviço.
     */
    public EstadoServico getEstadoServico() { return estadoServico; }

    /**
     * Método set genérico para definir o estado deste Serviço.
     * @param estadoServico Estado do Serviço.
     */
    public void setEstadoServico(EstadoServico estadoServico) { this.estadoServico = estadoServico; }

    /**
     * Método get genérico para obter o preço deste Serviço.
     * @return Preço do Serviço.
     */
    public BigDecimal getPreco() { return preco; }

    /**
     * Método set genérico para definir o preço deste Serviço.
     * @param preco Preço do Serviço.
     */
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    /**
     * Método Override do toString() normal, 
     * utilizado para obter apenas a descrição do Serviço.
     * @return Descrição de um serviço.
     */
    @Override
    public String toString() { return descricao; }
}
