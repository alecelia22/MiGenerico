package ar.com.generico.action;

import java.math.BigDecimal;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import ar.com.generico.entidades.Socio;
import ar.com.generico.entidades.util.HibernateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrarImportesAction extends ActionSupport {

	private static final long serialVersionUID = 8156408033321384683L;
	
	private String nombreCompleto;
	private Long dni;
	private BigDecimal puntos;
	private String monto;

	/**
	 * Busco un socio por su numero de DNI
	 */
	public String buscarSocio() {
		//Creo una nueva session
		Session session = HibernateUtil.getSession();
		// Criterio de busqueda
		Criteria socioCriteria = session.createCriteria(Socio.class);
		// Filtro de nombre
		SimpleExpression socioRestrictions = Restrictions.eq("dni", this.dni);
		socioCriteria.add(socioRestrictions);
		// Recupero los socios
		Socio socio = (Socio) socioCriteria.uniqueResult();
		if (socio != null)  {
			this.nombreCompleto = socio.getApellido() + ", " + socio.getNombre();
		}

		return SUCCESS;
	}

	/**
	 * Le sumo los puntos al socio.
	 */
	public String sumarPuntos() {
		// Creo una nueva session e inicio la transaccion
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// Criterio de busqueda
		Criteria socioCriteria = session.createCriteria(Socio.class);
		// Filtro de nombre
		SimpleExpression socioRestrictions = Restrictions.eq("dni", this.dni);
		socioCriteria.add(socioRestrictions);
		// Recupero al socio
		Socio socio = (Socio) socioCriteria.uniqueResult();
		this.puntos = socio.getPuntos().add(new BigDecimal(this.monto.replace(".", "").replace(",", ".")));
		socio.setPuntos(this.puntos);
		// Actualizo los puntos
		session.update(socio);

		session.getTransaction().commit();
		return SUCCESS;
	}

	/**
	 * Solo salgo a la pantalla desde el menu. 
	 */
	public String inicioSumar() {
		return SUCCESS;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public BigDecimal getPuntos() {
		return puntos;
	}

	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}
}
