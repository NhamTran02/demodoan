package com.example.demodoan.dto;

import com.example.demodoan.model.Chapter;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Long id;

    @NotBlank(message = "title kh đc trống")
    private String title;

    @NotBlank(message = "videoUrl kh đc trống")
    private String videoUrl;

    @NotNull(message = "chapter ID is required")
    private Long chapter;
}
