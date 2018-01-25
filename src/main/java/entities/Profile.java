package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Profile {
	
	@Id
	private String username;
	private String password;
	private String name;
	private String forename;
	private String gitname;
	private String workSamples;
	private String introText;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_belonging", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "groupname") })
	private List<MyGroup> groupBelonging;
	@ManyToMany
	@JoinTable(name = "admin_of_groups", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "groupname") })
	private List<MyGroup> adminOfGroups;
	@ManyToMany
	@JoinTable(name = "group_application", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "groupname") })
	private List<MyGroup> groupApplication;
	@OneToMany(mappedBy = "founder")
	private List<MyGroup> founderOf;
	
	public Profile(String username, String password, String name, String forename) {
		this.username = username;
		this.name = name;
		this.forename = forename;
		this.gitname = "";
		this.workSamples = "";
		this.introText = "";
	}
	public Profile() {
		
	}
	
	public void foundGroup() {
		
	}
	public void leaveGroup() {
		
	}
	public void applyGroup() {
		
	}
	public void joinGroup() {
		
	}
	public void deleteGroup() {
		
	}
	
	

}
