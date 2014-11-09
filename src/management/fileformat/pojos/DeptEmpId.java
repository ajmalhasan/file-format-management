package management.fileformat.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DeptEmpId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DeptEmpId implements java.io.Serializable {

	// Fields

	private Integer empNo;
	private String deptNo;

	// Constructors

	/** default constructor */
	public DeptEmpId() {
	}

	/** full constructor */
	public DeptEmpId(Integer empNo, String deptNo) {
		this.empNo = empNo;
		this.deptNo = deptNo;
	}

	// Property accessors

	@Column(name = "emp_no", nullable = false)
	public Integer getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	@Column(name = "dept_no", nullable = false, length = 4)
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DeptEmpId))
			return false;
		DeptEmpId castOther = (DeptEmpId) other;

		return ((this.getEmpNo() == castOther.getEmpNo()) || (this.getEmpNo() != null
				&& castOther.getEmpNo() != null && this.getEmpNo().equals(
				castOther.getEmpNo())))
				&& ((this.getDeptNo() == castOther.getDeptNo()) || (this
						.getDeptNo() != null
						&& castOther.getDeptNo() != null && this.getDeptNo()
						.equals(castOther.getDeptNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEmpNo() == null ? 0 : this.getEmpNo().hashCode());
		result = 37 * result
				+ (getDeptNo() == null ? 0 : this.getDeptNo().hashCode());
		return result;
	}

}