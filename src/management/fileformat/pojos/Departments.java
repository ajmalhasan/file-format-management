package management.fileformat.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Departments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "departments", catalog = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "dept_name"))
public class Departments implements java.io.Serializable {

	// Fields

	private String deptNo;
	private String deptName;

	// Constructors

	/** default constructor */
	public Departments() {
	}

	/** full constructor */
	public Departments(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	// Property accessors
	@Id
	@Column(name = "dept_no", unique = true, nullable = false, length = 4)
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "dept_name", unique = true, nullable = false, length = 40)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}