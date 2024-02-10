package com.sakurai.techcertificationsystem.modules.questions.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicAlternativeDto {

    private UUID id;
    private String description;

}
