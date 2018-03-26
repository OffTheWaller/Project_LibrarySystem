package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Book;
import ui.MainClass;

public class IO {
	//д�ļ�
	public void save(MainClass mainClass) {
		String fileName = "E:\\workspace\\LibrarySystem\\book.txt";
		String allbook = "";
		
		for(int i=0; i<mainClass.booklist.size(); i++) {
			Book book = (Book)mainClass.booklist.get(i);
			String temp = book.getBookname()+","+book.getAuthor()
					+","+book.getPrice()+"\r\n";
			allbook += temp;
		}
		try {
			File file1 = new File(fileName);
			FileWriter fileWriter;
			fileWriter = new FileWriter(file1);
			fileWriter.write(allbook);
			fileWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//���ļ�
	public void load(MainClass mainClass) {
		try {
			String filename = "E:\\workspace\\LibrarySystem\\book.txt";
			File file = new File(filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String temp;
			while((temp = reader.readLine()) != null) {
				
				//split�������ص��ǰ�ָ����ֺ��һ���ַ�������
				String bookname = temp.split(",")[0];
				String author = temp.split(",")[1];
				String pricestr = temp.split(",")[2];
				float price = Float.parseFloat(pricestr);
				Book book = new Book(bookname,author,price);
				mainClass.booklist.add(book);
				mainClass.count++;
			}
			reader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}



















