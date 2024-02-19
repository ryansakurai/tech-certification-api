package com.sakurai.techcertification.certification.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sakurai.techcertification.certification.model.Certification;
import com.sakurai.techcertification.certification.model.SubmitionDto;
import com.sakurai.techcertification.certification.service.CertificationService;

@RestController
@RequestMapping("/certifications")
public class CertificationController {
    
    @Autowired
    private CertificationService certificationService;
    
    @PostMapping()
    public ResponseEntity<Certification> submitAnswers(@RequestBody SubmitionDto submition, UriComponentsBuilder ucb) {
        Certification certification = this.certificationService.submitAnswers(submition);
        URI certificationUri = ucb
        .path("/certifications/{id}")
        .buildAndExpand(certification.getId())
        .toUri();
        return ResponseEntity.created(certificationUri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certification> getCertification(@PathVariable UUID id) {
        // TO BE IMPLEMENTED
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rankings/{quantity}")
    public ResponseEntity<List<Certification>> getRanking(@PathVariable int quantity) {
        List<Certification> ranking = certificationService.getRanking(quantity);
        return ResponseEntity.ok().body(ranking);
    }

}