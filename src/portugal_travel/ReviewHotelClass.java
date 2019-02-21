package portugal_travel;

public class ReviewHotelClass extends ReviewAbstractClass {
	
	private int service;
	private int location;
	
	public ReviewHotelClass(String user, int classification, String comment, int service, int location) {
		super(user, classification, comment);
		this.service=service;
		this.location=location;
	}
	
	@Override
	public int getService() {
		// TODO Auto-generated method stub
		return service;
	}
	@Override
	public int getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	@Override
	public int getFood() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getAmbience() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void overrideReview(String user, int classification, String comment, int service, int location) {
		// TODO Auto-generated method stub
		this.user=user;
		this.classification=classification;
		this.comment=comment;
		this.service=service;
		this.location=location;
	}

}
