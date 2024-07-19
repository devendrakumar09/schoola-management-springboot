package com.backennd.school.Services;

import com.backennd.school.Entity.SchoolEntity;

import java.util.List;

public interface SchoolServices {

    List<SchoolEntity> getSchool();
    SchoolEntity getById(int id);
    String postSchool(SchoolEntity schoolEntity);
    String updateSchool(int id,SchoolEntity schoolEntity);
    String deleteSchool(int id);
}
