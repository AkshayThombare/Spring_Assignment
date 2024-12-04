package devby.at.model;



import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Table(name="emp")
@Entity
@SQLDelete(sql="UPDATE WORLD.EMP SET STATUS='deleted' where ENO=?")
@Where(clause="STATUS <> 'deleted'")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eno;
@Column(length=20)
private String ename;
@Column(length=20)
private String job;
@Column(length=20)
private Double sal;
private Integer deptno=10;
private String status="active";
@Transient
private String vFlag="no";
}