package com.nos.interview.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("dev")
public class BaseControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    protected HttpHeaders httpHeaders = new HttpHeaders();

    public BaseControllerTest() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    public byte[] getContent(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);

        return objectMapper.writeValueAsBytes(object);
    }

    public MockHttpServletRequestBuilder request(HttpMethod method, String url, Object object) throws JsonProcessingException {
        MockHttpServletRequestBuilder requestBuilder = null;

        if(HttpMethod.POST.equals(method)) {
            requestBuilder = post(url);
        } else if(HttpMethod.PUT.equals(method)) {
            requestBuilder = put(url);
        } else if(HttpMethod.DELETE.equals(method)) {
            requestBuilder = delete(url);
        }

        return requestBuilder
                .headers(httpHeaders)
                .content(this.getContent(object));
    }
}
