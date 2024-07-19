package com.backennd.school.Controllers;

import com.backennd.school.Entity.SchoolEntity;
import com.backennd.school.Services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/school")
public class SchoolController {

    @Autowired
    private SchoolServices schoolServices;

    @GetMapping
    public List<SchoolEntity> getSchools(){
        return this.schoolServices.getSchool();
    }

    @PostMapping
    public String postSchool(@RequestBody SchoolEntity schoolEntity){
        return this.schoolServices.postSchool(schoolEntity);
    }

    @PutMapping
    public String updateSchool(@PathVariable int id,SchoolEntity schoolEntity){
        return this.schoolServices.updateSchool(id,schoolEntity);
    }

    @DeleteMapping
    public String deleteSchool(@PathVariable int id){
        return this.schoolServices.deleteSchool(id);
    }


}
