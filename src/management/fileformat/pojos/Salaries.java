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
 * Salaries entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "salaries", catalog = "employees")
public class Salaries implements java.io.Serializable {

	// Fields

	private SalariesId id;
	private Integer salary;
	private Date toDate;

	// Constructors

	/** default constructor */
	public Salaries() {
	}

	/** full constructor */
	public Salaries(SalariesId id, Integer salary, Date toDate) {
		this.id = id;
		this.salary = salary;
		this.toDate = toDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "empNo", column = @Column(name = "emp_no", nullable = false)),
			@AttributeOverride(name = "fromDate", column = @Column(name = "from_date", nullable = false, length = 10)) })
	public SalariesId getId() {
		return this.id;
	}

	public void setId(SalariesId id) {
		this.id = id;
	}

	@Column(name = "salary", nullable = false)
	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
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