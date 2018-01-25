package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class MyGroup {
	
	@Id
	private String groupname;
	private boolean isOpen;
	private int minMember;
	private int maxMember;
	@ManyToMany(mappedBy = "groupBelonging")
	private List<Profile> member;
	@ManyToMany(mappedBy = "adminOfGroups")
	private List<Profile> admins;
	@ManyToOne
	@JoinColumn(name = "founder")
	private Profile founder;
	@ManyToMany(mappedBy = "groupApplication")
	private List<Profile> waitinglist;
	
	public MyGroup(String groupname, boolean isOpen, int minMember, int maxMember, Profile founder) {		
		this.groupname = groupname;
		this.isOpen = isOpen;
		this.minMember = minMember;
		this.maxMember = maxMember;
		this.founder = founder;
		
		List<Profile> init = new ArrayList();
		init.add(this.founder);
		
		this.waitinglist = new ArrayList();
		this.member = init;
		this.admins = init;

	}
	
	public MyGroup() {
		
	}
	
}
