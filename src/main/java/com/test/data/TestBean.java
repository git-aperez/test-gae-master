package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Test data bean
 */
@Entity
@Cache
@ApiModel("Test object")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAnyoPub() {
		return anyoPub;
	}

	public void setAnyoPub(Integer anyoPub) {
		this.anyoPub = anyoPub;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
    
    
}
