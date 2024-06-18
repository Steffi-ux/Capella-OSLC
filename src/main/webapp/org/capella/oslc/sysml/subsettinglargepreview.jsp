<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.Link" %>
<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="org.eclipse.lyo.oslc4j.core.model.OslcConstants"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcName"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.net.URI"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>

<%@page import="org.oasis.oslcop.sysml.Subsetting"%>
<%@page import="org.oasis.oslcop.sysml.SysmlDomainConstants"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  Subsetting aSubsetting = (Subsetting) request.getAttribute("aSubsetting");
%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aSubsetting.toString() %></title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
</head>

<body>

<!-- Begin page content -->
<div>
    <% Method method = null; %>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getSubsettedFeature"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getSubsettedFeature() == null) || (aSubsetting.getSubsettedFeature().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/featuretohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getSubsettedFeature().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getSubsettingFeature"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getSubsettingFeature() == null) || (aSubsetting.getSubsettingFeature().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/featuretohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getSubsettingFeature().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwningFeature"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwningFeature() == null) || (aSubsetting.getOwningFeature().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/featuretohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwningFeature().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getGeneral"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getGeneral() == null) || (aSubsetting.getGeneral().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/typetohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getGeneral().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getSpecific"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getSpecific() == null) || (aSubsetting.getSpecific().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/typetohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getSpecific().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwningType"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwningType() == null) || (aSubsetting.getOwningType().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/typetohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwningType().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getRelatedElement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getRelatedElement()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getTarget"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getTarget()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getSource"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getSource()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwningRelatedElement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwningRelatedElement() == null) || (aSubsetting.getOwningRelatedElement().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwningRelatedElement().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedRelatedElement_comp"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedRelatedElement_comp()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedRelatedElement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedRelatedElement()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getIdentifier"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aSubsetting.getIdentifier() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aSubsetting.getIdentifier().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getName"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aSubsetting.getName() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aSubsetting.getName().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getQualifiedName"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aSubsetting.getQualifiedName() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aSubsetting.getQualifiedName().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getAliasId"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        Iterator<String> aliasIdItr = aSubsetting.getAliasId().iterator();
        while(aliasIdItr.hasNext()) {
            out.write("<li>" + aliasIdItr.next().toString() + "</li>");
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getHumanId"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aSubsetting.getHumanId() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aSubsetting.getHumanId().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwningMembership"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwningMembership() == null) || (aSubsetting.getOwningMembership().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/membershiptohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwningMembership().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedRelationship_comp"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedRelationship_comp()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/relationshiptohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwningRelationship"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwningRelationship() == null) || (aSubsetting.getOwningRelationship().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/relationshiptohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwningRelationship().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwningNamespace"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwningNamespace() == null) || (aSubsetting.getOwningNamespace().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/namespacetohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwningNamespace().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwner"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aSubsetting.getOwner() == null) || (aSubsetting.getOwner().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aSubsetting.getOwner().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedElement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedElement()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/elementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getDocumentation_comp"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getDocumentation_comp()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/documentationtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedAnnotation_comp"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedAnnotation_comp()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/annotationtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getDocumentationComment"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getDocumentationComment()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/commenttohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedTextualRepresentation"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedTextualRepresentation()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/textualrepresentationtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedRelationship"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedRelationship()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/relationshiptohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getDocumentation"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getDocumentation()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/documentationtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = Subsetting.class.getMethod("getOwnedAnnotation"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aSubsetting.getOwnedAnnotation()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/org/capella/oslc/sysml/annotationtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
</div>
<%
Map<QName, Object> extendedProperties = aSubsetting.getExtendedProperties();
if (!extendedProperties.isEmpty()) {
%>
    <div>
    <%
    for (Map.Entry<QName, Object> entry : extendedProperties.entrySet()) 
    {
        QName key = entry.getKey();
        Object value = entry.getValue();
    %>
    <dl class="row">
        <dt  class="col-sm-2 text-right"><a href="<%=key.getNamespaceURI() + key.getLocalPart() %>"><%=key.getLocalPart()%></a></dt>
        <dd class="col-sm-9"><%= value.toString()%></dd>
    </dl>
    <%
    }
    %>
    </div>
<%
}
%>
</body>
</html>
