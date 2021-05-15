package com.br.gabrieldias.desafiohub.exception;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;

}
