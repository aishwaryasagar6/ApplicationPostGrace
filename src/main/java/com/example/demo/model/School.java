package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "School")
@Entity

public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	//@Column
	//private Long mobileno;
	@Column(name = "email_id")
	private String emailId;
   //	@Column
	//private Long phoneno;
	/*@JsonIgnoreProperties(value = "schooldetails")
	@OneToMany(mappedBy = "schooldetails", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })*/
	// @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//private List<Users> userList = new ArrayList<Users>();
	//public static void main() {
	//	School s=new School();
	//	s.setId((long) 100);
		
		
	//}

}
