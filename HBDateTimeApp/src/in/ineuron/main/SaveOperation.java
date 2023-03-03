package in.ineuron.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class SaveOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction = session.beginTransaction();
				if(transaction!=null) {
					
					PersonInfo person = new PersonInfo();
					person.setPname("ravi");
					person.setPaddress("hyd");
					person.setDob(LocalDate.of(1998, 8, 16));
					person.setDom(LocalDateTime.of(1995, 7, 20, 12, 43));
					person.setDoj(LocalTime.of(10, 17));
					session.save(person);
					flag=true;
					
						}
			}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved to database...");
			}else {
				transaction.rollback();
				System.out.println("Object insertion failed...");
			}
				
			HibernateUtil.closeSession(session);
		}

	}

}
