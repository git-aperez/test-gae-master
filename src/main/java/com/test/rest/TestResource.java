package com.test.rest;

import com.test.dao.TestBeanDAO;
import com.test.data.TestBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces("application/json;charset=utf-8")
@Api(value = "test", description = "Test service")
public class TestResource {

    private TestBeanDAO testBeanDAO;

    public TestResource() {
        this.testBeanDAO = new TestBeanDAO();
    }

    @GET
    @ApiOperation("list books objects")
    public Response list() {
        return Response.ok(this.testBeanDAO.list()).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation("get a book object by id")
    public Response get(@PathParam("id") Long id) {
        TestBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }

    @GET
    @Path("/{filtro}/{valor}")
    @ApiOperation("search book by autor or by nombre")
    public Response list(@PathParam("filtro") String filtro, @PathParam("valor") String valor) {
        return Response.ok(this.testBeanDAO.list(filtro, valor)).build();
    }
    
//    @GET
//    @Path("/a/{autor}")
//    @ApiOperation("search by autor")
//    public Response list(@PathParam("autor") String autor) {
//        return Response.ok(this.testBeanDAO.list(autor)).build();
//    }

//    @GET
//    @Path("/t/{nombre}")
//    @ApiOperation("search by nombre")
//    public Response list(@PathParam("nombre") String nombre) {
//        return Response.ok(this.testBeanDAO.list(nombre)).build();
//    }
    
    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save book object")
    public Response save(TestBean bean) {
        this.testBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("delete book object by id")
    public Response delete(@PathParam("id") Long id) {
        TestBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.testBeanDAO.delete(bean);
        return Response.ok().build();
    }
}
