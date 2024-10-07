package com.sreeperfumeshop;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory inv = new Inventory();
		Scanner sc = new Scanner(System.in);
		String option;
		
		do {
            System.out.println("1. Add 2. Display 3. Search 4. Remove 5. Update 6. Exit");
            option = sc.nextLine();
            
            switch (option) {
                case "1":
                	System.out.println("Add");
                    PerfumeShop p = new PerfumeShop();
                    System.out.println("Name:");
                    p.setName(sc.nextLine());
                    System.out.println("Product tag:");
                    p.setProd_tag(sc.nextLine());
                    System.out.println("Price:");
                    p.setPrice(sc.nextDouble());
                    System.out.println("Essence:");
                    p.setEssence(sc.nextLine());
                    sc.nextLine();
                    inv.add(p);
                    break;
                    
                case "2":
                    inv.show();
                    break;
                    
                case "3":
                	 System.out.println("Search");
                     System.out.println("Enter the product name: ");
                    String searchName = sc.nextLine();
                    inv.search(searchName);
                    break;
                    
                case "4":
                	 System.out.println("Remove");
                     System.out.println("Enter the product name: ");
                    String removeName = sc.nextLine();
                    inv.remove(removeName);
                    break;
                    
                case "5":
                    System.out.println("Update");
                    System.out.println("Enter the product name: ");
                    String updateName = sc.nextLine();
                    inv.update(updateName);
                    break;
                    
                case "6":
                    System.out.println("Exit!");
                    break;
                    
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!option.equals("6"));
		sc.close();
	}
}
