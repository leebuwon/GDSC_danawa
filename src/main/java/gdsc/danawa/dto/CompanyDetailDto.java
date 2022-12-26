package gdsc.danawa.dto;

import gdsc.danawa.model.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 12월 23일 수정
 * Detail DTO 만들어서 리스트 불러올떄 content빼고 nation과 area 나와야함
 */
@NoArgsConstructor
@Getter
public class CompanyDetailDto {

    private String company_id;
    private String position;
//    private String nation;
//    private String area;
    private int salary;
    private String content;
    private String stack;

    public Company toEntity(){
        return Company.builder()
                .company_id(company_id)
                .position(position)
//                .nation(nation)
//                .area(area)
                .salary(salary)
                .content(content)
                .stack(stack)
                .build();
    }

    @Builder
    public CompanyDetailDto(String company_id, String position, int salary, String content, String stack) {
        this.company_id = company_id;
        this.position = position;
//        this.nation = nation;
//        this.area = area;
        this.salary = salary;
        this.content = content;
        this.stack = stack;
    }
}
