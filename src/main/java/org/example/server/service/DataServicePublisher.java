package org.example.server.service;

// https://jakarta.ee/specifications/xml-web-services/4.0/apidocs/jakarta.xml.ws/jakarta/xml/ws/endpoint
import jakarta.xml.ws.Endpoint;
import org.example.server.utils.Constants;


public class DataServicePublisher {

    public void publish() {
        Endpoint.publish(Constants.BASE_URL, new DataServiceImpl());
    }
}
