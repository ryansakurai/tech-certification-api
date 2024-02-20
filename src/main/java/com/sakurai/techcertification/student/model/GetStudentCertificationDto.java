package com.sakurai.techcertification.student.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetStudentCertificationDto {

    private UUID id;
    private String technology;

}
