package com.entity;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSave {
	public static void main(String... a) {
		
		//get the configuration object - read the cfg file
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		/*
		 * Don't use the ServiceRegistryBuilder - its @Deprecated
		 * Instead use - StandardServiceRegistryBuilder() 		 */
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
								.applySettings(config.getProperties()).build();
		
		SessionFactory factory = config.buildSessionFactory(registry);
		
		Session session = factory.openSession();
		
		/*
		 * Now, create the Hibernate Mapping file (hbm.xml files)
		 * I am not using - annotations here - this is an old way
		 */
		
		
		
		Player p1 = new Player();
		p1.setTid(1);
		p1.setPid(1);
		p1.setName("Kohli");
		p1.setAge(25);
		
		Player p2 = new Player();
		p2.setTid(1);
		p2.setPid(2);
		p2.setName("Dhoni");
		p2.setAge(33);
		
		Player p3 = new Player();
		p3.setTid(1);
		p3.setPid(3);
		p3.setName("Yuvraj");
		p3.setAge(33);
		
		//List<Player> players = new ArrayList<Player>();
		Set<Player> players = new HashSet<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		
		Team iteam = new Team();
		iteam.setTid(1);
		iteam.setTname("India");
		iteam.setPlayers(players);
		
		Transaction tx = session.beginTransaction();
		session.save(iteam);
		session.flush();
		
		tx.commit();
		session.close();
		factory.close();
		
		
		
	}
}
