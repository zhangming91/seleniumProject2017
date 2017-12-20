package FileTestDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "E:\\workspace\\AutoTestDemo1\\src\\FileTestDemo\\confiture.properties";
		Properties ps = new Properties();
		FileInputStream fs = new FileInputStream(path);
		ps.load(fs);
		System.out.println("课程名字："+ps.getProperty("Course"));
		System.out.println("课程时长:"+ps.getProperty("CourseHours"));
	}

}
