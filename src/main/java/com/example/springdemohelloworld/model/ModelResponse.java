package com.example.springdemohelloworld.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelResponse {
    private String resResult;
	private String reasonCode;
}
