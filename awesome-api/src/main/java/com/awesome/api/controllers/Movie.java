package com.awesome.api.controllers;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.awesome.api.models.CreateMovie;
import com.awesome.api.models.GetMovie;
import com.awesome.api.models.UpdateMovie;
import com.awesome.api.transformers.CreateMovieToGetMovie;
import com.awesome.api.transformers.UpdateMovieToGetMovie;

@Path("/movie")
public class Movie {

	private static Map<String, GetMovie> movies = new Hashtable<String, GetMovie>();

	@GET
	@Path("/{movieId}")
	@Produces(MediaType.APPLICATION_JSON)
	public GetMovie getMovie(@PathParam("movieId") String movieId) {
		return movies.get(movieId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<GetMovie> getMovies() {
		return movies.values();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMovie(@Context UriInfo uriInfo, CreateMovie movieToCreate) {
		GetMovie newMovie = CreateMovieToGetMovie.transform(movieToCreate);
		movies.put(newMovie.id, newMovie);
		String location = String.format("%s/%s", uriInfo.getAbsolutePath().toString(), newMovie.id);
		return Response.status(Status.CREATED).header("Location", location).entity(newMovie.id).build();
	}

	@DELETE
	@Path("/{movieId}")
	public Response deleteMovie(@PathParam("movieId") String movieId) {
		movies.remove(movieId);
		return Response.status(Status.OK).build();
	}

	@PUT
	@Path("/{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMovie(@PathParam("movieId") String movieId, UpdateMovie updatedMovie) {
		GetMovie getMovie = UpdateMovieToGetMovie.transform(updatedMovie);
		movies.put(movieId, getMovie);
		return Response.status(Status.OK).build();
	}
}