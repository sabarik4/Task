package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Item;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		while(choice < 5) {
			System.out.println("Enter\n1 - INSERT\n2 - UPDATE\n3 - DELETE\n4 - VIEW\n5 - EXIT");
			choice = Integer.parseInt(bufferedreader.readLine());
			if(choice == 1) {
				Item item = new Item();
				System.out.print("Enter product Id :");
				item.setId(Integer.parseInt(bufferedreader.readLine()));
				System.out.print("Enter product Name :");
				item.setName(bufferedreader.readLine());
				System.out.print("Enter price :");
				item.setPrice(Double.parseDouble(bufferedreader.readLine()));
				System.out.print("Enter quantity :");
				item.setQunatity(Integer.parseInt(bufferedreader.readLine()));
				System.out.print("Enter Manufacturing Date :");
				item.setManufacturingDate(bufferedreader.readLine());
				session.beginTransaction();
				session.save(item);
				session.getTransaction().commit();
			}
			else if(choice == 2) {
				session.beginTransaction();
				System.out.print("Enter product Id :");
				Integer id = Integer.parseInt(bufferedreader.readLine());
				System.out.print("Enter price to update :");
				Double price = Double.parseDouble(bufferedreader.readLine());
				Item itemUpdate = session.get(Item.class, id);
				itemUpdate.setPrice(price);
				session.update(itemUpdate);
				session.getTransaction().commit();
		}
			else if(choice == 3) {
				session.beginTransaction();
				System.out.print("Enter Id to delete :");
				Integer id = Integer.parseInt(bufferedreader.readLine());
				Item itemDelete = new Item();
				itemDelete.setId(id);
				session.delete(itemDelete);
				session.getTransaction().commit();
			}
			else if(choice == 4) {
				Query query = session.createQuery("from Item");
				List<Item> itemView = query.getResultList();
				for(Item each:itemView) {
					System.out.println(each);
				}
			}
	}

}
}