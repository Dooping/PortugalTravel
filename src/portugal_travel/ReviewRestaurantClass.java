package portugal_travel;

public class ReviewRestaurantClass extends ReviewAbstractClass {
	
	private int food;
	private int ambience;
	
	public ReviewRestaurantClass(String user, int classification, String comment, int food, int ambience) {
		super(user, classification, comment);
		this.food=food;
		this.ambience=ambience;
	}
	
	@Override
	public int getService() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getLocation() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getFood() {
		// TODO Auto-generated method stub
		return food;
	}
	@Override
	public int getAmbience() {
		// TODO Auto-generated method stub
		return ambience;
	}
	@Override
	public void overrideReview(String user, int classification, String comment, int food, int ambience) {
		// TODO Auto-generated method stub
		this.user=user;
		this.classification=classification;
		this.comment=comment;
		this.food=food;
		this.ambience=ambience;
	}

}
