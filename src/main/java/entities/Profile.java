package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Profile {
	
	@Id
	private String username;
	private String name;
	private String forename;
	private String gitname;
	private String workSamples;
	private String introText;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_belonging", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "groupname") })
	private List<Group> groupBelonging;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "admin_of_groups", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "groupname") })
	private List<Group> adminOfGroups;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_application", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "groupname") })
	private List<Group> groupApplication;
	
	public Profile(String username, String name, String forename) {
		this.username = username;
		this.name = name;
		this.forename = forename;
		this.gitname = "";
		this.workSamples = "";
		this.introText = "";
	}
	
	
	

}
