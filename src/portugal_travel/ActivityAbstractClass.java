package portugal_travel;
//import java.util.Iterator;

public abstract class ActivityAbstractClass implements Activity{
	protected String author;
	protected String name;
	protected String city;
	protected String address;
	protected String description;
	
	public ActivityAbstractClass(String author, String name, String address,
			String description) {
		this.author = author;
		this.name = name;
		this.address = address;
		this.description = description;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	
	public String getAuthor() {
		return author;
	}
	
}
