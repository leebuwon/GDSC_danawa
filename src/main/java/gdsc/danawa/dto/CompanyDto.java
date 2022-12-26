package gdsc.danawa.dto;

import gdsc.danawa.model.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompanyDto {

    private String company_id;
    private String position;
    private int salary;
    private String content;
    private String stack;

    public Company toEntity(){
        return Company.builder()
                .company_id(company_id)
                .position(position)
                .salary(salary)
                .content(content)
                .stack(stack)
                .build();
    }

    @Builder
    public CompanyDto(String company_id, String position, int salary, String content, String stack) {
        this.company_id = company_id;
        this.position = position;
        this.salary = salary;
        this.content = content;
        this.stack = stack;
    }
}
