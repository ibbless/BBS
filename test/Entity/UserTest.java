package Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry regestry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(regestry);
		Session session = sf.getCurrentSession();
		SchemaExport export = new SchemaExport(cfg);
		
		export.create(true, true);
	}
}
