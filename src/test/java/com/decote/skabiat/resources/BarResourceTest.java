package com.decote.skabiat.resources;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.decote.skabiat.resources.BarResource;

public class BarResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(BarResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
//    @Test
//    PUBLIC VOID TESTGETIT() {
//        FINAL STRING RESPONSEMSG = TARGET().PATH("API/BAR").REQUEST().GET(STRING.CLASS);
//
//        ASSERTEQUALS("HELLO, HEROKU!", RESPONSEMSG);
//    }
}
