package it.uniroma3.siw.spring.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Credentials {
	
	public static final String DEFAULT_ROLE = "DEFAULT";
	public static final String ADMIN_ROLE = "ADMIN";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Allievo allievo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Credentials() {}
	
	public Credentials(String username, String password, String role, User user) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Allievo getAllievo() {
//		return allievo;
//	}
//
//	public void setAllievo(Allievo allievo) {
//		this.allievo = allievo;
//	}

	public void setUser(User user) {
		this.user = user;
		
	}
	public User getUser() {
		return this.user;
	}
}
