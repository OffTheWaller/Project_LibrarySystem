package ui;

import java.util.Scanner;

import model.Book;

public class MainClass {

	public static final int SIZE = 10;
	Book[] booklist = new Book[SIZE];  //注意这里要导包
	
	int count = 0;
	
	public MainClass() {
		Scanner scan = new Scanner(System.in);
		
		printMenu();
		
		while(true) {
			//读取用户输入
			System.out.println("请输入要进行的操作：");
			int choice = scan.nextInt();
			
			if(choice == 5) {
				System.out.println("成功退出系统，欢迎下次光临！");
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
				System.out.println("输入非法");
				printMenu();
				//continue;//这个continue是continue的while
			}	
		}
		
		
	}
	
	void printMenu() {
		System.out.println("欢迎...");
		System.out.println("增加图书...1");
		System.out.println("删除图书...2");
		System.out.println("修改图书...3");
		System.out.println("查询图书...4");
		System.out.println("退出系统...5");
	}
	
	void addBook() {
		if(count < SIZE) {
			System.out.println("当前共有："+count+"本书");
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入添加书名");
			String bookname = scan.next();
			System.out.println("请输入作者：");
			String author = scan.next();
			System.out.println("请输入单价：");
			float price = scan.nextFloat();
			Book book = new Book(bookname,author,price);
			//加入到数组中
			booklist[count] = book;
			count++;
			System.out.println("增加成功！");
			printAllBook();
		}else {
			System.out.println("图书库已满！");
		}
	}
	
	void deleteBook() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("按哪种方式删除图书：1.序号  2.书名  3.返回主菜单");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("请输入要删除第几本书：");
				int id = scan.nextInt();
				id = orderFind(id);
				if(id > -1) {
					for(int i=id; i<count-1; i++) {
						booklist[i] = booklist[i+1];
					}
					count--;
					System.out.println("删除成功！");
					printAllBook();
				}else {
					System.out.println("输入错误！");
				}
			}else if(choose == 2) {
				System.out.println("请输入要删除的书名：");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1) {
					for(int i=id; i<count-1; i++) {
						booklist[i] = booklist[i+1];
					}
					count--;
					System.out.println("删除成功！");
					printAllBook();
				}else {
					System.out.println("未找到您要的书名！");
				}
			}else if(choose == 3) {
				printMenu();
				break;
			}else {
				System.out.println("输入非法！");
			}
		}
	}
	
	void changeBook() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("请输入按哪种方式修改：1.序号/ 2.书名  / 3.返回主菜单");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("请输入要修改的序号：");
				int number = scan.nextInt();
				int id = orderFind(number);
				if(id > -1) {
					System.out.println("原书名为："+booklist[id].getBookname());
					System.out.println("请输入要修改的书名为：");
					String new_name = scan.next();
					System.out.println("请输入作者：");
					String new_author = scan.next();
					System.out.println("请输入单价：");
					float new_price = scan.nextFloat();
					booklist[id].setBook(new_name, new_author, new_price);
					System.out.println("修改成功！");
					printAllBook();
				}else {
					System.out.println("输入错误！");
				}
			}else if(choose == 2) {
				System.out.println("请输入您要修改的书名：");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1) {
					System.out.println("请输入要修改的书名为：");
					String new_name = scan.next();
					System.out.println("请输入作者：");
					String new_author = scan.next();
					System.out.println("请输入单价：");
					float new_price = scan.nextFloat();
					booklist[id].setBook(new_name, new_author, new_price);
					System.out.println("修改成功！");
					printAllBook();
				}	
			}else if(choose == 3) {
				printMenu();
				break;
			}else {
				System.out.println("输入非法！");
			}
		}
	}
	void findBook() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("请输入按哪种方法查找图书： 1.序号/ 2.书名/ 3.返回主菜单");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("请输入要查找第几本书：");
				int number = scan.nextInt();
				int id = orderFind(number);
				if(id > -1) {
					System.out.println("你要查找的书名为："+booklist[id].getBookname()
							+"  作者："+booklist[id].getAuthor()
							+"  单价："+booklist[id].getPrice()+"元/本");
				}else {
					System.out.println("输入错误！");
				}
			}else if(choose == 2) {
				System.out.println("请输入您要查找的书名：");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1) {
					System.out.println("查找成功！您查找的书为第"+(id+1)+"本书");
					System.out.println("书名为："+booklist[id].getBookname()
							+"  作者："+booklist[id].getAuthor()
							+"  单价为："+booklist[id].getPrice()+"元/本");
				}
			}else if(choose == 3) {
				printMenu();
				break;
			}else {
				System.out.println("非法输入！");
			}
		}
	}
	
	void printAllBook() {
		for(int i=0; i<count; i++) {
			System.out.println("第"+(i+1)+"本书名："+booklist[i].getBookname()+
					"   作者："+booklist[i].getAuthor()+"   单价："+booklist[i].getPrice()
					+"元/本");
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
			if(booklist[i].getBookname().equals(name)) {
				id = i;
				break;
			}else if(i<count) {
				continue;
			}else {
				System.out.println("未找到您要的书名！");
				break;
			}
		}
		return id;
	}
	
	public static void main(String[] args) {
		new MainClass();
	}

	
	
	
	
	
	
	
	
}
