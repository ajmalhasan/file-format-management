package management.fileformat.pojos;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DeptEmp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dept_emp", catalog = "employees")
public class DeptEmp implements java.io.Serializable {

	// Fields

	private DeptEmpId id;
	private Date fromDate;
	private Date toDate;

	// Constructors

	/** default constructor */
	public DeptEmp() {
	}

	/** full constructor */
	public DeptEmp(DeptEmpId id, Date fromDate, Date toDate) {
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "empNo", column = @Column(name = "emp_no", nullable = false)),
			@AttributeOverride(name = "deptNo", column = @Column(name = "dept_no", nullable = false, length = 4)) })
	public DeptEmpId getId() {
		return this.id;
	}

	public void setId(DeptEmpId id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "from_date", nullable = false, length = 10)
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "to_date", nullable = false, length = 10)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}