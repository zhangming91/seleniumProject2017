package AbstractDemo;

public abstract class Aminal {
	public Aminal() {
		System.out.println("------动物类构造方法----");
	}
	public void bark() {
		System.out.println("----动物会叫----");
	}
	public abstract void run();
	public abstract void eat(String food);
	public abstract void sleep();

}
