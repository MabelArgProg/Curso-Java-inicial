package clase5;

public class DescuentoPorcentaje extends Descuento{

	public DescuentoPorcentaje(float valor) {
		super(valor);
	}

	@Override
	public float valorFinal(float valorInicial) {
		return valorInicial - (valorInicial * super.getValorDesc());
	}

}
