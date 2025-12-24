package com.testing.component.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.testing.component.dao.ApplicationDao;

import java.util.List;

public class ApplicationService {

    private ApplicationDao applicationDao;

    @Autowired
    public void setApplicationDao(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    public double addGradeResultsForSingleClass(List<Double> numbers) {
        return applicationDao.addGradeResultsForSingleClass(numbers);
    }

    public double findGradePointAverage (List<Double> grades ) {
        return applicationDao.findGradePointAverage(grades);
    }

    public Object checkNull(Object obj) {
        return applicationDao.checkNull(obj);
    }

}
