<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<%--
 Copyright (c) 2020 Contributors to the Eclipse Foundation
 
 See the NOTICE file(s) distributed with this work for additional
 information regarding copyright ownership.
 
 This program and the accompanying materials are made available under the
 terms of the Eclipse Distribution License 1.0 which is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 SPDX-License-Identifier: BSD-3-Simple

 This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
--%>

<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="org.eclipse.lyo.oslc4j.core.model.AbstractResource"%>
<%@page import="org.oasis.oslcop.sysml.Relationship"%>

<%@ page contentType="application/json" language="java" pageEncoding="UTF-8" %>

{
<%
  String selectionUri = (String) request.getAttribute("selectionUri");
  List<Relationship> resources = (List<Relationship>) request.getAttribute("resources");
  String terms = (String) request.getAttribute("terms");
%>
"oslc:results": [
<% int i = 0; for (Relationship r : resources) { %>
  <% if (i > 0) { %>,<% } %>
  {
    "oslc:label" : "<%= r.toString() %>",
    "rdf:resource" : "<%= r.getAbout() %>"
  }
<% i++; } %>
]
}
