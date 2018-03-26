package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Book;
import tool.IO;
public class MainClass {

	public ArrayList<Book> booklist = new ArrayList<Book>();
	
	public int count = 0;
	
	public MainClass() {
		Scanner scan = new Scanner(System.in);
		
		IO io = new IO();
		io.load(this);
		
		printMenu();
		
		while(true) {
			//��ȡ�û�����
			System.out.println("������Ҫ���еĲ�����");
			int choice = scan.nextInt();
			
			if(choice == 5) {
				
				io.save(this);
				System.out.println("�ɹ��˳�ϵͳ����ӭ�´ι��٣�");
				break;
			}
			
			switch(choice) {
			case 1: addBook();
				break;
			case 2: deleteBook();
				break;
			case 3: changeBook();
				break;
			case 4: findBook();
				break;
			default:
				System.out.println("����Ƿ�");
				printMenu();
				//continue;//���continue��continue��while
			}	
		}
		
		
	}
	
	void printMenu() {
		System.out.println("��ӭ...");
		System.out.println("����ͼ��...1");
		System.out.println("ɾ��ͼ��...2");
		System.out.println("�޸�ͼ��...3");
		System.out.println("��ѯͼ��...4");
		System.out.println("�˳�ϵͳ...5");
	}
	
	void addBook() {
		if(count > booklist.size()-1) {
			System.out.println("��ǰ���У�"+count+"����");
			Scanner scan = new Scanner(System.in);
			System.out.println("�������������");
			String bookname = scan.next();
			System.out.println("���������ߣ�");
			String author = scan.next();
			System.out.println("�����뵥�ۣ�");
			float price = scan.nextFloat();
			Book book = new Book(bookname,author,price);
			booklist.add(book);
			count++;
			System.out.println("���ӳɹ���");
			printAllBook();
		}else {
			System.out.println("ͼ���������");
		}
	}
	
	void deleteBook() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("�����ַ�ʽɾ��ͼ�飺1.���  2.����  3.�������˵�");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("������Ҫɾ���ڼ����飺");
				int id = scan.nextInt();
				id = orderFind(id);
				if(id > -1) {
					booklist.remove(id);
					count--;
					System.out.println("ɾ���ɹ���");
					printAllBook();
				}else {
					System.out.println("�������");
				}
			}else if(choose == 2) {
				System.out.println("������Ҫɾ����������");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1) {
					booklist.remove(id);
					count--;
					System.out.println("ɾ���ɹ���");
					printAllBook();
				}else {
					System.out.println("δ�ҵ���Ҫ��������");
				}
			}else if(choose == 3) {
				printMenu();
				break;
			}else {
				System.out.println("����Ƿ���");
			}
		}
	}
	
	void changeBook() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("�����밴���ַ�ʽ�޸ģ�1.���/ 2.����  / 3.�������˵�");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("������Ҫ�޸ĵ���ţ�");
				int number = scan.nextInt();
				int id = orderFind(number);
				if(id > -1) {
					
					Book book = booklist.get(id);//��������book�������Ҫ�ĵ��Ȿ��
					System.out.println("ԭ����Ϊ��"+book.getBookname());
					System.out.println("������Ҫ�޸ĵ�����Ϊ��");
					String new_name = scan.next();
					System.out.println("���������ߣ�");
					String new_author = scan.next();
					System.out.println("�����뵥�ۣ�");
					float new_price = scan.nextFloat();
					book.setBook(new_name, new_author, new_price);
					System.out.println("�޸ĳɹ���");
					printAllBook();
				}else {
					System.out.println("�������");
				}
			}else if(choose == 2) {
				System.out.println("��������Ҫ�޸ĵ�������");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1) {
					//���ﲢ����new��һ��book������ֻ����һ��book������ArrayList�еĶ�Ӧ��book
					Book book = booklist.get(id);
					System.out.println("������Ҫ�޸ĵ�����Ϊ��");
					String new_name = scan.next();
					System.out.println("���������ߣ�");
					String new_author = scan.next();
					System.out.println("�����뵥�ۣ�");
					float new_price = scan.nextFloat();
					book.setBook(new_name, new_author, new_price);
					System.out.println("�޸ĳɹ���");
					printAllBook();
				}	
			}else if(choose == 3) {
				printMenu();
				break;
			}else {
				System.out.println("����Ƿ���");
			}
		}
	}
	void findBook() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("�����밴���ַ�������ͼ�飺 1.���/ 2.����/ 3.�������˵�");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("������Ҫ���ҵڼ����飺");
				int number = scan.nextInt();
				int id = orderFind(number);
				if(id > -1) {
					Book book = booklist.get(id);
					System.out.println("��Ҫ���ҵ�����Ϊ��"+book.getBookname()
							+"  ���ߣ�"+book.getAuthor()
							+"  ���ۣ�"+book.getPrice()+"Ԫ/��");
				}else {
					System.out.println("�������");
				}
			}else if(choose == 2) {
				System.out.println("��������Ҫ���ҵ�������");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1) {
					Book book = booklist.get(id);
					System.out.println("���ҳɹ��������ҵ���Ϊ��"+(id+1)+"����");
					System.out.println("����Ϊ��"+book.getBookname()
							+"  ���ߣ�"+book.getAuthor()
							+"  ����Ϊ��"+book.getPrice()+"Ԫ/��");
				}
			}else if(choose == 3) {
				printMenu();
				break;
			}else {
				System.out.println("�Ƿ����룡");
			}
		}
	}
	
	void printAllBook() {
		for(int i=0; i<count ; i++) {
			Book book = booklist.get(i);
			System.out.println("��"+(i+1)+"��������"+book.getBookname()+
					"   ���ߣ�"+book.getAuthor()+"   ���ۣ�"+book.getPrice()
					+"Ԫ/��");
		}
	}
	
	int orderFind(int number) {
		if(number<=count) {
			return number-1;
		}else {
			return -1;
		}
	}
	
	int nameFind(String name) {
		int id = -1;
		for(int i=0; i<count; i++) {
			Book book = booklist.get(i);
			if(book.getBookname().equals(name)) {
				id = i;
				break;
			}else if(i<count) {
				continue;
			}else {
				System.out.println("δ�ҵ���Ҫ��������");
				break;
			}
		}
		return id;
	}
	
	public static void main(String[] args) {
		new MainClass();
	}

	
	
	
	
	
	
	
	
}
