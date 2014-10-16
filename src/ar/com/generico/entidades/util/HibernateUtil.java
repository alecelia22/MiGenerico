package ar.com.generico.entidades.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

	private static final SessionFactory factory;

	static {
		try {
			// Creacion del Seesion Factory
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Fallo la creación del SessionFactory: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Crea una nueva session.
	 * @return Session nueva
	 */
	public static final Session getSession() {
		return factory.openSession();
	}
}
