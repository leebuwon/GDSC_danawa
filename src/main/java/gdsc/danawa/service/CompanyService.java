package gdsc.danawa.service;

import gdsc.danawa.dto.CompanyDetailDto;
import gdsc.danawa.dto.CompanyDto;
import gdsc.danawa.model.Company;
import gdsc.danawa.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public Long save(CompanyDto companyDto){
        return companyRepository.save(companyDto.toEntity()).getId();
    }

    /**
     * 모든 채용공고 확인하기
     * V1 ( 원본 버전 )
     */
    @Transactional
    public List<CompanyDto> findAll(){
        List<Company> CompanyList = companyRepository.findAll();
        List<CompanyDto> CompanyDtoList = new ArrayList<>();

        for (Company company : CompanyList) {
            CompanyDto companyDto = CompanyDto.builder()
                    .company_id(company.getCompany_id())
                    .position(company.getPosition())
                    .salary(company.getSalary())
                    .content(company.getContent())
                    .stack(company.getStack())
                    .build();
            CompanyDtoList.add(companyDto);
        }
        return CompanyDtoList;
    }

    /**
     * 12 / 24일
     * CompanyDetailDto 으로 반환 ( 하지만 문제가 있음 )
     * nation / area 포함시켜야되는 버전
     */
//    @Transactional
//    public List<CompanyDto> findAll(){
//        List<Company> CompanyList = companyRepository.findAll();
//        List<CompanyDto> CompanyDtoList = new ArrayList<>();
//
//        for (Company company : CompanyList) {
//            CompanyDto companyDto = CompanyDto.builder()
//                    .company_id(company.getCompany_id())
//                    .position(company.getPosition())
//                    .salary(company.getSalary())
//                    .content(company.getContent())
//                    .stack(company.getStack())
//                    .build();
//            CompanyDtoList.add(companyDto);
//        }
//        return CompanyDtoList;
//    }

    /**
     * 채용공고 수정하기
     */
    @Transactional
    public Long update(Long id, CompanyDto companyDto){
        // TODO 수정 진행
        Company entity = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id가 존재하지 않습니다."));

        entity.update(companyDto.getPosition(), companyDto.getSalary(), companyDto.getContent(), companyDto.getStack());
        return companyRepository.save(entity).getId();
    }

    /**
     * 채용공고 삭제하기
     */
    @Transactional
    public Long delete(Long id){
        // TODO 삭제 진행
        Company entity = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id가 존재하지 않습니다."));

        companyRepository.deleteById(id);
        return entity.getId();
    }
}
