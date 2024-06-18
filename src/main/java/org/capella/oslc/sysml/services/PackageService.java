// Start of user code Copyright
/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Simple
 *
 * This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
 */
// End of user code

package org.capella.oslc.sysml.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import org.capella.oslc.sysml.SysmlServerManager;
import org.capella.oslc.sysml.SysmlServerConstants;
import org.oasis.oslcop.sysml.SysmlDomainConstants;
import org.capella.oslc.sysml.servlet.ServiceProviderCatalogSingleton;
import org.oasis.oslcop.sysml.SysmlPackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@Path("projects/{projectId}/packages")
@Api(value = "Web Service for {" + SysmlDomainConstants.PACKAGE_LOCALNAME + "}")
public class PackageService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    private static final Logger log = LoggerFactory.getLogger(PackageService.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public PackageService()
    {
        super();
    }

    private void addCORSHeaders (final HttpServletResponse httpServletResponse) {
        //UI preview can be blocked by CORS policy.
        //add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @GET
    @Path("{id}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @ApiOperation(
        value = "GET for resources of type {'" + SysmlDomainConstants.PACKAGE_LOCALNAME + "'}",
        notes = "GET for resources of type {'" + "<a href=\"" + SysmlDomainConstants.PACKAGE_TYPE + "\">" + SysmlDomainConstants.PACKAGE_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + SysmlDomainConstants.PACKAGE_PATH + "\">" + SysmlDomainConstants.PACKAGE_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public SysmlPackage getSysmlPackage(
                @PathParam("projectId") final String projectId, @PathParam("id") final String id
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final SysmlPackage aSysmlPackage = SysmlServerManager.getSysmlPackage(httpServletRequest, projectId, id);

        if (aSysmlPackage != null) {
            // Start of user code getSysmlPackage
            // End of user code
            httpServletResponse.setHeader("ETag", SysmlServerManager.getETagFromSysmlPackage(aSysmlPackage));
            httpServletResponse.addHeader(SysmlServerConstants.HDR_OSLC_VERSION, SysmlServerConstants.OSLC_VERSION_V2);
            return aSysmlPackage;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.TEXT_HTML })
    @ApiOperation(
        value = "GET for resources of type {'" + SysmlDomainConstants.PACKAGE_LOCALNAME + "'}",
        notes = "GET for resources of type {'" + "<a href=\"" + SysmlDomainConstants.PACKAGE_TYPE + "\">" + SysmlDomainConstants.PACKAGE_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + SysmlDomainConstants.PACKAGE_PATH + "\">" + SysmlDomainConstants.PACKAGE_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public void getSysmlPackageAsHtml(
        @PathParam("projectId") final String projectId, @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getSysmlPackageAsHtml_init
        // End of user code

        final SysmlPackage aSysmlPackage = SysmlServerManager.getSysmlPackage(httpServletRequest, projectId, id);

        if (aSysmlPackage != null) {
            httpServletRequest.setAttribute("aSysmlPackage", aSysmlPackage);
            // Start of user code getSysmlPackageAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/org/capella/oslc/sysml/sysmlpackage.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    @ApiOperation(
        value = "GET for resources of type {'" + SysmlDomainConstants.PACKAGE_LOCALNAME + "'}",
        notes = "GET for resources of type {'" + "<a href=\"" + SysmlDomainConstants.PACKAGE_TYPE + "\">" + SysmlDomainConstants.PACKAGE_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + SysmlDomainConstants.PACKAGE_PATH + "\">" + SysmlDomainConstants.PACKAGE_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Compact getSysmlPackageCompact(
        @PathParam("projectId") final String projectId, @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getSysmlPackageCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final SysmlPackage aSysmlPackage = SysmlServerManager.getSysmlPackage(httpServletRequest, projectId, id);

        if (aSysmlPackage != null) {
            final Compact compact = new Compact();

            compact.setAbout(aSysmlPackage.getAbout());
            compact.setTitle(aSysmlPackage.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aSysmlPackage.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aSysmlPackage.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(SysmlServerConstants.HDR_OSLC_VERSION, SysmlServerConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getSysmlPackageAsHtmlSmallPreview(
        @PathParam("projectId") final String projectId, @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getSysmlPackageAsHtmlSmallPreview_init
        // End of user code

        final SysmlPackage aSysmlPackage = SysmlServerManager.getSysmlPackage(httpServletRequest, projectId, id);

        if (aSysmlPackage != null) {
            httpServletRequest.setAttribute("aSysmlPackage", aSysmlPackage);
            // Start of user code getSysmlPackageAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/org/capella/oslc/sysml/sysmlpackagesmallpreview.jsp");
            httpServletResponse.addHeader(SysmlServerConstants.HDR_OSLC_VERSION, SysmlServerConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getSysmlPackageAsHtmlLargePreview(
        @PathParam("projectId") final String projectId, @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getSysmlPackageAsHtmlLargePreview_init
        // End of user code

        final SysmlPackage aSysmlPackage = SysmlServerManager.getSysmlPackage(httpServletRequest, projectId, id);

        if (aSysmlPackage != null) {
            httpServletRequest.setAttribute("aSysmlPackage", aSysmlPackage);
            // Start of user code getSysmlPackageAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/org/capella/oslc/sysml/sysmlpackagelargepreview.jsp");
            httpServletResponse.addHeader(SysmlServerConstants.HDR_OSLC_VERSION, SysmlServerConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
}
