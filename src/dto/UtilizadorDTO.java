package dto;

import enums.TipoUtilizador;
/**
 *
 * @author efapro01.24
 */
public class UtilizadorDTO {
	
	private int id;
	private String nome;
    private String email;
    private String password;
    private TipoUtilizador tipoUtilizador;
    
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

    public TipoUtilizador getTipoUtilizador() { return tipoUtilizador; }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) { this.tipoUtilizador = tipoUtilizador; }
}