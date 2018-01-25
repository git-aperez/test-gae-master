package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@Cache
@ApiModel("Objeto libro")
public class TestBean {

    @Id
    private Long id;

    private String data;
    @Index
    private String nombre;
    @Index
    private String autor;
    private Integer anyoPub;
    private String genero;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @ApiModelProperty(value = "Identificador del libro", dataType = "Long")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty(value = "Titulo del libro", dataType = "String")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ApiModelProperty(value = "Autor del libro", dataType = "String")
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@ApiModelProperty(value = "Anyo de publicacion del libro", dataType = "Integer")
	public Integer getAnyoPub() {
		return anyoPub;
	}

	public void setAnyoPub(Integer anyoPub) {
		this.anyoPub = anyoPub;
	}

	@ApiModelProperty(value = "Genero del libro", dataType = "String")
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
