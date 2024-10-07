package com.sreeperfumeshop;
import java.util.*;

public class Inventory {
	Scanner sc = new Scanner(System.in);
	List<PerfumeShop> list = new ArrayList<>();
    
	//add
    void add(PerfumeShop p) {
        list.add(p);
    }
    
    //show
    void show() {
        for (PerfumeShop p : list) {
            System.out.println(p);
        }
    }
	
	//search
	void search(String name) {
        for (PerfumeShop p : list) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Item Found");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Not Found!");
    }
	
	//remove
	void remove(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                list.remove(i);
                System.out.println("Item Removed");
                return;
            }
        }
        System.out.println("Not Found!");
    }
    
    void update(String name) {
        for (PerfumeShop p : list) {
            if (p.getName().equalsIgnoreCase(name)) {
            	System.out.println("Update  1.Name 2.Tag 3.Price 4.Essence");
                int op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        System.out.println("Enter new name:");
                        p.setName(sc.nextLine());
                        break;
                    
                    case 2:
                        System.out.println("Enter new tag:");
                        p.setProd_tag(sc.nextLine());
                        break;
                    
                    case 3:
                        System.out.println("Enter new price:");
                        p.setPrice(sc.nextDouble());
                        break;
                        
                    case 4:
                        System.out.println("Enter new essence:");
                        p.setEssence(sc.nextLine());
                        break;
                        
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                System.out.println("Updated Successfully!");
                return;
            }
        }
        System.out.println("Item Not Found");
    }
	
}
