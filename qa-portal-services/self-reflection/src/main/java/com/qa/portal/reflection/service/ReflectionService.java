package com.qa.portal.reflection.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qa.portal.reflection.dto.CohortSummaryDto;
import com.qa.portal.reflection.dto.ReflectionDto;

@Service
public class ReflectionService {

    private GetSelfReflectionOperation getSelfReflectionOperation;

    private GetSelfReflectionsForUserOperation getSelfReflectionsForUserOperation;

    private CreateSelfReflectionOperation createSelfReflectionOperation;

    private UpdateSelfReflectionOperation updateSelfReflectionOperation;

    private GetCohortSummaryOperation getCohortSummaryOperation;

    public ReflectionService(GetSelfReflectionOperation getSelfReflectionOperation,
            GetSelfReflectionsForUserOperation getSelfReflectionsForUserOperation,
            CreateSelfReflectionOperation createSelfReflectionOperation,
            UpdateSelfReflectionOperation updateSelfReflectionOperation,
            GetCohortSummaryOperation getCohortSummaryOperation) {
        this.getSelfReflectionOperation = getSelfReflectionOperation;
        this.getSelfReflectionsForUserOperation = getSelfReflectionsForUserOperation;
        this.createSelfReflectionOperation = createSelfReflectionOperation;
        this.updateSelfReflectionOperation = updateSelfReflectionOperation;
        this.getCohortSummaryOperation = getCohortSummaryOperation;
    }

    @Transactional
    public Set<ReflectionDto> getSelfReflectionsForTrainee(String userName) {
        return this.getSelfReflectionsForUserOperation.getSelfReflectionsForTrainee(userName);
    }

    @Transactional
    public Set<ReflectionDto> getSelfReflectionsForTrainer(String userName) {
        return this.getSelfReflectionsForUserOperation.getSelfReflectionsForTrainer(userName);
    }

    @Transactional
    public Set<ReflectionDto> getSelfReflectionsForTrainee(Integer userId) {
        return this.getSelfReflectionsForUserOperation.getSelfReflectionsForUser(userId);
    }

    @Transactional
    public ReflectionDto getSelfReflection(Integer id) {
        return this.getSelfReflectionOperation.getSelfReflectionById(id);
    }

    @Transactional
    public ReflectionDto getSelfReflection(String userId, LocalDate date) {
        return this.getSelfReflectionOperation.getSelfReflectionByUserAndDate(userId, date);
    }

    @Transactional
    public ReflectionDto createSelfReflection(ReflectionDto reflectionDto, String userName) {
        return this.createSelfReflectionOperation.createSelfReflection(reflectionDto, userName);
    }

    @Transactional
    public ReflectionDto updateSelfReflection(ReflectionDto reflectionDto, String userName) {
        return this.updateSelfReflectionOperation.updateSelfReflection(reflectionDto, userName);
    }

    @Transactional
    public List<CohortSummaryDto> getCohortSummaryDto() {
        return this.getCohortSummaryOperation.getCohortSummary();
    }
}
