package lib.bo;

public class Reader_BO {

	private int id;
	private String name;
	private String degree;
	private String phone;
	private String doi;
	private String dor;
	private String bookname;


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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public Reader_BO(String name, String degree, String phone, String doi, String dor, String bookname) {
		super();
		this.name = name;
		this.degree = degree;
		this.phone = phone;
		this.doi = doi;
		this.dor = dor;
		this.bookname = bookname;
	}


	public Reader_BO() {
		super();
	}


	@Override
	public String toString() {
		return "Reader_BO [id=" + id + ", name=" + name + ", degree=" + degree + ", phone=" + phone + ", doi=" + doi
				+ ", dor=" + dor + ", bookname=" + bookname + "]";
	}
}