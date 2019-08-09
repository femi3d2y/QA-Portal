package com.qa.portal.feedback.rest;

import com.qa.portal.common.security.QaSecurityContext;
import com.qa.portal.feedback.services.CourseEvaluationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseEvaluationController {

    private CourseEvaluationService service;

    private QaSecurityContext qaSecurityContext;

    public CourseEvaluationController(CourseEvaluationService service, QaSecurityContext qaSecurityContext) {
        this.service = service;
        this.qaSecurityContext = qaSecurityContext;
    }
}