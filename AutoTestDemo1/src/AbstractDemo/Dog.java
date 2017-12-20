package AbstractDemo;

public class Dog extends Aminal {
	
	public Dog() {
		super();
		System.out.println("----狗构造方法------");
	}
	public void bark() {
		super.bark();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("狗会跑");
		
	}

	@Override
	public void eat(String food) {
		System.out.println("狗吃"+food);
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("狗会睡觉");
	}
	

}
