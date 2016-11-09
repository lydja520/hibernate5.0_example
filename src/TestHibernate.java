import bean.Department;
import bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by ydc on 16-11-6.
 */
public class TestHibernate {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Department dept = new Department();
        dept.setName("开发部");
        session.save(dept);

        User user1 = new User();
        user1.setName("张三");
        user1.setPwd("123456");
        user1.setBrithday(new Date());
        user1.setDept(dept);
        session.save(user1);

        User user2 = new User();
        user2.setName("李四");
        user2.setPwd("123456");
        user2.setBrithday(new Date());
        user2.setDept(dept);
        session.save(user2);

        transaction.commit();
        sessionFactory.close();
    }

}
