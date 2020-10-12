package vo;

public class User {
	private String userName;
	private String password;
	private String chrName;
	private String role;
	
	
	public User(String userName, String password, String chrName, String role) {
		this.userName = userName;
		this.password = password;
		this.chrName = chrName;
		this.role = role;
	}
	/**
	 * @return the userName
	 */
	
	public String getUserName() {
		return userName;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the chrName
	 */
	public String getChrName() {
		return chrName;
	}
	/**
	 * @param chrName the chrName to set
	 */
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	

}
