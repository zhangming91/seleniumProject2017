package AbstractDemo;

public class Dog extends Aminal {
	
	public Dog() {
		super();
		System.out.println("----�����췽��------");
	}
	public void bark() {
		super.bark();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("������");
		
	}

	@Override
	public void eat(String food) {
		System.out.println("����"+food);
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("����˯��");
	}
	

}
