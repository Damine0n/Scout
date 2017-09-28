package com.manh.scope.services.security;

public class SecurityWebServicePortTypeProxy implements com.manh.scope.services.security.SecurityWebServicePortType {
  private String _endpoint = null;
  private com.manh.scope.services.security.SecurityWebServicePortType securityWebServicePortType = null;
  
  public SecurityWebServicePortTypeProxy() {
    _initSecurityWebServicePortTypeProxy();
  }
  
  public SecurityWebServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSecurityWebServicePortTypeProxy();
  }
  
  private void _initSecurityWebServicePortTypeProxy() {
    try {
      securityWebServicePortType = (new com.manh.scope.services.security.SecurityWebServiceLocator()).getSecurityWebServiceHttpSoap11Endpoint();
      if (securityWebServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)securityWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)securityWebServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (securityWebServicePortType != null)
      ((javax.xml.rpc.Stub)securityWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.manh.scope.services.security.SecurityWebServicePortType getSecurityWebServicePortType() {
    if (securityWebServicePortType == null)
      _initSecurityWebServicePortTypeProxy();
    return securityWebServicePortType;
  }
  
  
}