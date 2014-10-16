package ar.com.generico.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import ar.com.generico.entidades.Usuario;
import ar.com.generico.entidades.util.HibernateUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -2407336120228611918L;

	private String username;
	private String password;

	/**
	 * Validar usuarios.
	 */
	public String authenticate() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		//Creo una nueva session
		Session sessionBBDD = HibernateUtil.getSession();
		// Criterio de busqueda
		Criteria usuarioCriteria = sessionBBDD.createCriteria(Usuario.class);
		// Filtro de nombre
		SimpleExpression usuarioRestrictions = Restrictions.eq("usuario", this.username);
		usuarioCriteria.add(usuarioRestrictions);
		// Busco al usuario
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = usuarioCriteria.list();
		// Valido q exista el usuario
		for (Usuario usuario : usuarios) {
			if (this.password.equals(usuario.getPassword())) {
				if (usuario.getActivo().booleanValue()) {
						session.put("usuario", usuario);
						return SUCCESS;
				}
			}
		}

		// No coincide use/pass o usuario inactivo
		addActionError(getText("error.login"));
		return ERROR;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
}