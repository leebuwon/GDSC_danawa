package gdsc.danawa.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 200)
    public String company_id;

    /**
     * 12월 23일 수정
     * nation / area 추가
     */
    @Column(length = 200)
    public String nation;

    @Column(length = 200)
    public String area;

    @Column(length = 200)
    public String position;

    @Column(length = 100)
    public int salary;

    @Column(length = 200)
    public String content;

    @Column(length = 200)
    public String stack;

    @Builder
    public Company(Long id, String company_id, String nation, String area, String position, int salary, String content, String stack) {
        this.id = id;
        this.company_id = company_id;
        this.nation = nation;
        this.area = area;
        this.position = position;
        this.salary = salary;
        this.content = content;
        this.stack = stack;
    }

    public void update(String position, int salary, String content, String stack){
        this.position = position;
        this.salary = salary;
        this.content = content;
        this.stack = stack;
    }
}