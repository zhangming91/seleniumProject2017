package AbstractDemo;

public abstract class Aminal {
	public Aminal() {
		System.out.println("------�����๹�췽��----");
	}
	public void bark() {
		System.out.println("----������----");
	}
	public abstract void run();
	public abstract void eat(String food);
	public abstract void sleep();

}
