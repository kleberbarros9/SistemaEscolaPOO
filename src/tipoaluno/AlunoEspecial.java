package tipoaluno;

//Classe extendida Aluno especial
public class AlunoEspecial extends Aluno {

	public AlunoEspecial() {
		// TODO Auto-generated constructor stub
	}

	public AlunoEspecial(double f) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void modificarNota(double n1, double n2, double n3, double n4) {
		// TODO Auto-generated method stub
		double media = (((n1 + n2 + n3 + n4) / 4.0 * 1.75f));
		if (media > 10.f)
			media = 10.0f;

		super.media = media;
	}

}