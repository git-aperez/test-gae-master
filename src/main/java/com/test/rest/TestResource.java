package com.test.rest;

import com.test.dao.TestBeanDAO;
import com.test.data.TestBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces("application/json;charset=utf-8")
@Api(value = "Libros", description = "Servicio de libros")
public class TestResource {

    private TestBeanDAO testBeanDAO;

    public TestResource() {
        this.testBeanDAO = new TestBeanDAO();
    }

    @GET
    @ApiOperation(value = "Devuelve la lista de libros", notes = "Devuelve una lista completa de libros con todos los campos de la tabla.", response = TestBean.class, responseContainer = "List")
    @ApiResponses(value = { 
	    @ApiResponse(code = 200, message = "Busqueda exitosa de los libros"),
	    @ApiResponse(code = 404, message = "Libro no encontrado"),
	    @ApiResponse(code = 500, message = "Internal server error")
    })
    public Response list() {
        return Response.ok(this.testBeanDAO.list()).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Devuelve un libro concreto", notes = "Devuelve el nombre y el autor de un libro concreto.", response = TestBean.class)
    @ApiResponses(value = { 
    	    @ApiResponse(code = 200, message = "Busqueda exitosa del libro"),
    	    @ApiResponse(code = 404, message = "Libro no encontrado"),
    	    @ApiResponse(code = 500, message = "Internal server error")
        })
    public Response get(@ApiParam(name = "id", value = "Identificador del libro", required = true) @PathParam("id") Long id) {
        TestBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }

    @GET
    @Path("/{filtro}/{valor}")
    @ApiOperation(value = "Busca libros por nombre o por autor", notes = "Devuelve una lista de libros cuya busqueda ha sido filtrada por el nombre o por el autor.", response = TestBean.class)
    @ApiResponses(value = { 
    	    @ApiResponse(code = 200, message = "Busqueda exitosa del libro"),
    	    @ApiResponse(code = 404, message = "Libro no encontrado"),
    	    @ApiResponse(code = 500, message = "Internal server error")
        })
    public Response list(@ApiParam(name = "filtro", value = "Campo por el que se filtra la busqueda del libro, puede ser el nombre o el autor", required = true) @PathParam("filtro") String filtro, 
    		@ApiParam(name = "valor", value = "Valor que se utiliza para la el filtro de la busqueda del libro", required = true) @PathParam("valor") String valor) {
        return Response.ok(this.testBeanDAO.list(filtro, valor)).build();
    }
    
    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation(value = "Graba un libro concreto", notes = "Graba en la BBDD un libro con el nombre, el autor, el anyo de publicacion y el genero.", response = TestBean.class)
    @ApiResponses(value = { 
    	    @ApiResponse(code = 200, message = "Grabado exitoso del libro"),
    	    @ApiResponse(code = 404, message = "Libro no encontrado"),
    	    @ApiResponse(code = 500, message = "Internal server error")
        })
    public Response save(TestBean bean) {
        this.testBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Elimina un libro concreto", notes = "Elimina un libro concreto de la BBDD.", response = TestBean.class)
    @ApiResponses(value = { 
    	    @ApiResponse(code = 200, message = "Eliminacion exitosa del libro"),
    	    @ApiResponse(code = 404, message = "Libro no encontrado"),
    	    @ApiResponse(code = 500, message = "Internal server error")
        })
    public Response delete(@ApiParam(name = "id", value = "Identificador del libro", required = true) @PathParam("id") Long id) {
        TestBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.testBeanDAO.delete(bean);
        return Response.ok().build();
    }
}
