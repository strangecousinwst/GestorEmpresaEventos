package dto;

import java.math.BigDecimal;
/**
 *
 * @author joao
 */
public class ProcessoDTO {

    private int id;
    private int idServico;
    private int idFuncionario;
    private String descricao;
    private BigDecimal custo;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getIdServico() { return idServico; }

    public void setIdServico(int idServico) { this.idServico = idServico; }

    public int getIdFuncionario() { return idFuncionario; }

    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getCusto() { return custo; }

    public void setCusto(BigDecimal custo) { this.custo = custo; }
}
