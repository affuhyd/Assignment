package main.java.pojo;

public class InsertRecordPOJO {

	private String birthday;
	private String gender;
	private String name;
	private String natid;
	private String salary;
	private String tax;

	public InsertRecordPOJO(String natid, String name, String gender, String salary, String birthday, String tax) {
		this.birthday = birthday;
		this.gender = gender;
		this.name = name;
		this.natid = natid;
		this.salary = salary;
		this.tax = tax;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public String getName() {
		return this.name;
	}

	public String getnatid() {
		return this.natid;
	}

	public String getSalary() {
		return this.salary;
	}

	public String getTax() {
		return this.tax;
	}

}
