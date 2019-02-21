package portugal_travel;

public class UserClass implements User{
	
	public UserClass(String username, String name, String address, String email, int type, int nr) {
		this.username=username;
		this.name = name;
		this.type = type;
		if (type==3) this.password = "author"+nr;
		else this.password = "advisor"+nr;
		this.address=address;
		this.email=email;
	}
	private String username;
	private String name;
	private int type;
	private String password;
	private String address;
	private String email;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}
	@Override
	public boolean login(String password) {
		// TODO Auto-generated method stub
		if (this.password.equals(password)) return true;
		return false;
	}
	
	public String toString() {
		return username;
	}
	
	public int compareTo(User o2) {			
		return toString().compareTo(o2.toString());
	}
}
