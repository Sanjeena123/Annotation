package annotationbysir.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_department_info")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    @Column
    private String departName;

   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
