package org.bng.blog;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import io.quarkus.panache.common.Sort;

import org.bng.data.Blog;

@Path("/blogs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BlogResource {
    @GET
    @Path("/posts")
    public List<Blog> getBlogs() {
        return Blog.listAll(Sort.by("author").ascending());
    }

    @POST
    @Path("/post")
    @Transactional
    public void addBlog(Blog blog) {
        Blog.persist(blog);
    }

}
