package tipoaluno;

//Classe abstrata aluno
public class Aluno {
	double media;
	String tipoAluno;
	String nome;

	//getters e setters
	public double getMedia() {
		return media;
	}

	public void setMedia(double d) {
		this.media = d;
	}

	public String getTipoAluno() {
		return tipoAluno;
	}

	public void setTipoAluno(String tipoAluno) {
		this.tipoAluno = tipoAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//metodo
	public void modificarNota(double n1, double n2, double n3, double n4) {
		this.media = 0.0f;
	}

}