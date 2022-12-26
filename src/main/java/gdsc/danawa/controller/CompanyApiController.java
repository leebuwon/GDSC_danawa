package gdsc.danawa.controller;

import gdsc.danawa.dto.CompanyDetailDto;
import gdsc.danawa.dto.CompanyDto;
import gdsc.danawa.model.Company;
import gdsc.danawa.repository.CompanyRepository;
import gdsc.danawa.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CompanyApiController {

    private final CompanyRepository companyRepository;
    private final CompanyService companyService;

    @PostMapping("/addCompany")
    public CompanyDto addJobOpening(@RequestBody CompanyDto companyDto){
        log.info("공고 등록");
        companyService.save(companyDto);
        return companyDto;
    }

    @PatchMapping("/modifyCompany/{id}")
    public CompanyDto updateJobOpening(@PathVariable Long id, @RequestBody CompanyDto companyDto){
        log.info("공고 수정");
        companyService.update(id, companyDto);
        return companyDto;
    }

    @DeleteMapping("/deleteCompany/{id}")
    public String deleteJobOpening(@PathVariable Long id){
        log.info("DB에서 삭제하였습니다.");
        companyService.delete(id);
        return "DB에서 삭제하였습니다.";
    }

    @GetMapping("/findCompany")
    public List<CompanyDto> findJobOpening(){
        log.info("모든 공고 찾기");
        return companyService.findAll();
    }
}
