package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import additions.Rules;
import lombok.Data;

@Data
@Entity
public class Group {
	
	@Id
	private String name;
	private boolean isOpen;
	private int minMember;
	private int maxMember;
	@OneToMany(mappedBy = "name", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Profile> member;
	@OneToMany(mappedBy = "name", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Profile> admins;
	private Profile founder;
	@OneToMany(mappedBy = "name", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Profile> waitinglist;
	private Rules rules;
	
	public Group(String name, boolean isOpen, int minMember, int maxMember, Profile founder) {		
		this.name = name;
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
	
}
