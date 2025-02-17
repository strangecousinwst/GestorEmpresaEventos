package dto;

import java.math.BigDecimal;

/**
 * Processo Data Transfer Object
 * Esta classe permite fazer operações na aplicação baseadas na entidade Processos.
 * 
 * @author joao
 */
public class ProcessoDTO {

    private int id;
    private int idServico;
    private int idFuncionario;
    private String descricao;
    private BigDecimal custo;

    /**
     * Método get genérico para obter ID de um Processo.
     * @return Id de um Processo.
     */
    public int getId() { return id; }

    /**
     * Método set genérico para definir o ID de um Processo.
     * @param id Id de um Processo.
     */
    public void setId(int id) { this.id = id; }

     /**
     * Método get genérico para obter o id do respectivo serviço deste Processo.
     * @return Id do respectivo serviço deste Processo.
     */
    public int getIdServico() { return idServico; }

    /**
     * Método set genérico para definir o id do respectivo serviço deste Processo.
     * @param idServico Id do respectivo serviço deste Processo.
     */
    public void setIdServico(int idServico) { this.idServico = idServico; }

    /**
     * Método get genérico para obter o id do respectivo funcionário deste Processo.
     * @return Id do respectivo funcionário deste Processo.
     */
    public int getIdFuncionario() { return idFuncionario; }

    /**
     * Método set genérico para definir o id do respectivo funcionário deste Processo.
     * @param idFuncionario Id do respectivo funcionário deste Processo.
     */
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    /**
     * Método get genérico para obter a descrição do Processo.
     * @return Descrição do Processo.
     */
    public String getDescricao() { return descricao; }

    /**
     * Método set genérico para definir a descrição do Processo.
     * @param descricao Descrição do Processo.
     */
    public void setDescricao(String descricao) { this.descricao = descricao; }

    /**
     * Método get genérico para obter o custo do Processo.
     * @return Custo do Processo.
     */
    public BigDecimal getCusto() { return custo; }

    /**
     * Método get genérico para definir o custo do Processo.
     * @param custo Custo do Processo.
     */
    public void setCusto(BigDecimal custo) { this.custo = custo; }
}
