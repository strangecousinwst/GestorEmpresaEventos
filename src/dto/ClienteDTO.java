package dto;

/**
 *
 * @author joao
 */
public class ClienteDTO {

    private int id;
    private String nome;
    private String email;
    private String telemovel;
    private String localidade;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTelemovel() { return telemovel; }

    public void setTelemovel(String telemovel) { this.telemovel = telemovel; }

    public String getLocalidade() { return localidade; }

    public void setLocalidade(String localidade) { this.localidade = localidade; }

    @Override
    public String toString() { return nome; }
}
