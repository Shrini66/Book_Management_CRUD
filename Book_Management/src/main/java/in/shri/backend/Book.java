package in.shri.backend;

public class Book {
    private int id;
    private String name;
    private String edition;
    private float price;

    public Book(int id, String name, String edition, float price) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.price = price;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

    
}
