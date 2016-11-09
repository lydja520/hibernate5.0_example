import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by ydc on 16-11-8.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    static {
        //当配置文件名为hibernate.cfg.xml且文件在classpath下时，configure()方法无需参数
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // 出现异常需要销毁StandardServiceRegistry注册表
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
