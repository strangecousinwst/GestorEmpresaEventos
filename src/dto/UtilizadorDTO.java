package dto;

import enums.TipoUtilizador;
import java.util.Objects;

/**
 * Utilizador Data Transfer Object
 * Esta classe permite fazer operações na aplicação baseadas na entidade Utilizadores.
 * 
 * @author joao
 */
public class UtilizadorDTO {
	
	private int id;
	private String nome;
    private String email;
    private String password;
    private TipoUtilizador tipoUtilizador;
    
    /**
     * Método get genérico para obter ID de um Utlizador.
     * @return Id de um Utilizador.
     */
    public int getId() { return id; }

    /**
     * Método set genérico para definir o ID de um Utilizador.
     * @param id Id de um Utilizador.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Método get genérico para obter o nome de um Utilizador.
     * @return Nome de um Utilizador.
     */
    public String getNome() { return nome; }

    /**
     * Método set genérico para definir o nome de um Utilizador.
     * @param nome Nome de um Utilizador.
     */
    public void setNome(String nome) { this.nome = nome; }

    /**
     * Método get genérico para obter o email de um Utilizador.
     * @return Email de um Utilizador.
     */
    public String getEmail() { return email; }

    /**
     * Método set genérico para definir o email de um Utilizador.
     * @param email Email de um Utilizador.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Método get genérico para obter a password de um Utilizador.
     * @return Password de um Utilizador.
     */
    public String getPassword() { return password; }

    /**
     * Método set genérico para definir a password de um Utilizador.
     * @param password Password de um Utilizador.
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Método get genérico para obter o tipo de Utilizador.
     * @return Tipo de Utilizador.
     */
    public TipoUtilizador getTipoUtilizador() { return tipoUtilizador; }

    /**
     * Método set genérico para definir o tipo de Utilizador.
     * @param tipoUtilizador Tipo de Utilizador.
     */
    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) { this.tipoUtilizador = tipoUtilizador; }

    /**
     * Método Override do toString() normal, 
     * utilizado para obter apenas o nome de um Utilizador.
     * @return Nome de um Utilizador.
     */
    @Override
    public String toString() { return nome; }

    /**
     * Método utilizado verificar se 2 objetos são o mesmo.
     * @param obj Objeto Utilizador.
     * @return Verdadeiro se for igual, Falso se for diferente.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final UtilizadorDTO other = (UtilizadorDTO) obj;
        if (this.id != other.id) { return false; }
        if (!Objects.equals(this.nome, other.nome)) { return false; }
        if (!Objects.equals(this.email, other.email)) { return false; }
        if (!Objects.equals(this.password, other.password)) { return false; }
        return this.tipoUtilizador == other.tipoUtilizador;
    }
}