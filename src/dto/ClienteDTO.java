package dto;

/**
 * Cliente Data Transfer Object
 * Esta classe permite fazer operações na aplicação baseadas na entidade Clientes.
 * 
 * @author joao
 */
public class ClienteDTO {

    private int id;
    private String nome;
    private String email;
    private String telemovel;
    private String localidade;

    /**
     * Método get genérico para obter ID de um Cliente.
     * @return Id de um Cliente.
     */
    public int getId() { return id; }

    /**
     * Método set genérico para definir o ID de um Cliente.
     * @param id Id de um Cliente.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Método get genérico para obter o nome de um Cliente.
     * @return Nome de um Cliente.
     */
    public String getNome() { return nome; }

    /**
     * Método set genérico para definir o nome de um Cliente.
     * @param nome Nome de um Cliente.
     */
    public void setNome(String nome) { this.nome = nome; }

    /**
     * Método get genérico para obter o email de um Cliente.
     * @return Email de um Cliente.
     */
    public String getEmail() { return email; }

    /**
     * Método set genérico para definir o email de um Cliente.
     * @param email Email de um Cliente.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Método get genérico para obter o número de telemóvel de um Cliente.
     * @return Número de telemóvel de um Cliente.
     */
    public String getTelemovel() { return telemovel; }

    /**
     * Método set genérico para definir o número de telemóvel de um Cliente.
     * @param telemovel Número de telemóvel de um Cliente.
     */
    public void setTelemovel(String telemovel) { this.telemovel = telemovel; }

    /**
     * Método get genérico para obter a localidade de um Cliente.
     * @return Localidade de um Cliente.
     */
    public String getLocalidade() { return localidade; }

    /**
     * Método set genérico para definir a localidade de um Cliente.
     * @param localidade Localidade de um Cliente.
     */
    public void setLocalidade(String localidade) { this.localidade = localidade; }

    /**
     * Método Override do toString() normal, 
     * utilizado para obter apenas o nome de um Cliente.
     * @return Nome de um Cliente.
     */
    @Override
    public String toString() { return nome; }
}
