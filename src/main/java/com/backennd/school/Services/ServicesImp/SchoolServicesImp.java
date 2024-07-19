package com.backennd.school.Services.ServicesImp;

import com.backennd.school.Entity.SchoolEntity;
import com.backennd.school.Repository.SchoolRepo;
import com.backennd.school.Services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServicesImp implements SchoolServices {
    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public List<SchoolEntity> getSchool() {
        return schoolRepo.findAll();
    }

    @Override
    public SchoolEntity getById(int id) {
        Optional<SchoolEntity> school = this.schoolRepo.findById(id);
        if (school.isPresent()){
            return school.get();
        }else {
            return null;
        }
    }

    @Override
    public String postSchool(SchoolEntity schoolEntity) {
        SchoolEntity data = schoolEntity;
        this.schoolRepo.save(data);
        return "1 Row Inserted";

    }

    @Override
    public String updateSchool(int id, SchoolEntity schoolEntity) {
        Optional<SchoolEntity> school = this.schoolRepo.findById(id);
        if (school.isPresent()){
            SchoolEntity existSchool = school.get();
            existSchool.setName(schoolEntity.getName());
            existSchool.setAddress(schoolEntity.getAddress());
            existSchool.setEmail(schoolEntity.getEmail());
            existSchool.setState(schoolEntity.getState());
            existSchool.setCity(schoolEntity.getCity());
            existSchool.setContact(schoolEntity.getContact());
            this.schoolRepo.save(existSchool);
            return "1 Row Updated";
        }
    }

    @Override
    public String deleteSchool(int id) {
        Optional<SchoolEntity> school = this.schoolRepo.findById(id);
        if (school.isPresent()){
            this.schoolRepo.deleteById(id);
            return "1 Row Deleted";
        }else {
            return "No Data Found";
        }
    }
}
