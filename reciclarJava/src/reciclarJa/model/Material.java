package reciclarJa.model;

public class Material {
	private String material;
	private float preco;

	public Material(String material, float preco) {

		this.material = material;
		this.preco = preco;
	}

	public Material(String material) {
		super();
		this.material = material;
	}

	public String getMateral() {
		return material;
	}

	public void setMateral(String materal) {
		this.material = materal;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void visualizar() {

		System.out.println("O material " + this.material);
		System.out.println("O preço do material(por kg) é de: " + this.preco);

	}
}
