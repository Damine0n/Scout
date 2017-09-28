/**
 * SecurityWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manh.scope.services.security;

public interface SecurityWebService extends javax.xml.rpc.Service {
    public java.lang.String getSecurityWebServiceHttpSoap11EndpointAddress();

    public com.manh.scope.services.security.SecurityWebServicePortType getSecurityWebServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public com.manh.scope.services.security.SecurityWebServicePortType getSecurityWebServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
