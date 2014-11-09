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
 * Titles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "titles", catalog = "employees")
public class Titles implements java.io.Serializable {

	// Fields

	private TitlesId id;
	private Date toDate;

	// Constructors

	/** default constructor */
	public Titles() {
	}

	/** minimal constructor */
	public Titles(TitlesId id) {
		this.id = id;
	}

	/** full constructor */
	public Titles(TitlesId id, Date toDate) {
		this.id = id;
		this.toDate = toDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "empNo", column = @Column(name = "emp_no", nullable = false)),
			@AttributeOverride(name = "title", column = @Column(name = "title", nullable = false, length = 50)),
			@AttributeOverride(name = "fromDate", column = @Column(name = "from_date", nullable = false, length = 10)) })
	public TitlesId getId() {
		return this.id;
	}

	public void setId(TitlesId id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "to_date", length = 10)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}