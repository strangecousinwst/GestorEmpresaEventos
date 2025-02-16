package dto;

import enums.EstadoServico;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author joao
 */

public class ServicoDTO {

    private int id;
    private int idCliente;
    private String descricao;
    private EstadoServico estadoServico;
    private BigDecimal preco;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }

    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public EstadoServico getEstadoServico() { return estadoServico; }

    public void setEstadoServico(EstadoServico estadoServico) { this.estadoServico = estadoServico; }

    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    @Override
    public String toString() { return descricao; }
}
