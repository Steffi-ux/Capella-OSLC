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
 */
// End of user code

package org.capella.oslc.sysml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContextEvent;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcDomainConstants;
import org.capella.oslc.sysml.servlet.ServiceProviderCatalogSingleton;
import org.capella.oslc.sysml.ServiceProviderInfo;
import org.oasis.oslcop.sysml.AcceptActionUsage;
import org.oasis.oslcop.sysml.ActionDefinition;
import org.oasis.oslcop.sysml.ActionUsage;
import org.oasis.oslcop.sysml.AllocationDefinition;
import org.oasis.oslcop.sysml.AllocationUsage;
import org.oasis.oslcop.sysml.AnalysisCaseDefinition;
import org.oasis.oslcop.sysml.AnalysisCaseUsage;
import org.oasis.oslcop.sysml.AnnotatingElement;
import org.oasis.oslcop.sysml.Annotation;
import org.oasis.oslcop.sysml.Association;
import org.oasis.oslcop.sysml.AssociationStructure;
import org.oasis.oslcop.sysml.AttributeDefinition;
import org.oasis.oslcop.sysml.AttributeUsage;
import org.oasis.oslcop.sysml.Behavior;
import org.oasis.oslcop.sysml.BooleanExpression;
import org.oasis.oslcop.sysml.CalculationDefinition;
import org.oasis.oslcop.sysml.CalculationUsage;
import org.oasis.oslcop.sysml.CaseDefinition;
import org.oasis.oslcop.sysml.CaseUsage;
import org.oasis.oslcop.sysml.SysmlClass;
import org.oasis.oslcop.sysml.SysmlDomainConstants;
import org.oasis.oslcop.sysml.Classifier;
import org.oasis.oslcop.sysml.Comment;
import org.oasis.oslcop.sysml.ConjugatedPortDefinition;
import org.oasis.oslcop.sysml.Conjugation;
import org.oasis.oslcop.sysml.ConnectionDefinition;
import org.oasis.oslcop.sysml.ConnectionUsage;
import org.oasis.oslcop.sysml.Connector;
import org.oasis.oslcop.sysml.ConstraintDefinition;
import org.oasis.oslcop.sysml.ConstraintUsage;
import org.oasis.oslcop.sysml.DataType;
import org.oasis.oslcop.sysml.Definition;
import org.oasis.oslcop.sysml.Documentation;
import org.oasis.oslcop.sysml.Element;
import org.oasis.oslcop.sysml.EnumerationDefinition;
import org.oasis.oslcop.sysml.EnumerationUsage;
import org.oasis.oslcop.sysml.Expression;
import org.oasis.oslcop.sysml.Feature;
import org.oasis.oslcop.sysml.FeatureMembership;
import org.oasis.oslcop.sysml.FeatureTyping;
import org.oasis.oslcop.sysml.Function;
import org.oasis.oslcop.sysml.Generalization;
import org.oasis.oslcop.sysml.SysmlImport;
import org.oasis.oslcop.sysml.IndividualDefinition;
import org.oasis.oslcop.sysml.IndividualUsage;
import org.oasis.oslcop.sysml.InterfaceDefinition;
import org.oasis.oslcop.sysml.InterfaceUsage;
import org.oasis.oslcop.sysml.ItemDefinition;
import org.oasis.oslcop.sysml.ItemUsage;
import org.oasis.oslcop.sysml.Membership;
import org.oasis.oslcop.sysml.Multiplicity;
import org.oasis.oslcop.sysml.Namespace;
import org.oasis.oslcop.sysml.SysmlPackage;
import org.oasis.oslcop.sysml.PartDefinition;
import org.oasis.oslcop.sysml.PartUsage;
import org.eclipse.lyo.core.query.ParseException;
import org.eclipse.lyo.core.query.QueryUtils;
import org.eclipse.lyo.core.query.SimpleTerm;
import org.eclipse.lyo.core.query.WhereClause;
import org.eclipse.lyo.oslc.domains.DctermsDomainConstants;
import org.eclipse.lyo.oslc.domains.FoafDomainConstants;
import org.eclipse.lyo.oslc.domains.Person;
import org.oasis.oslcop.sysml.PortConjugation;
import org.oasis.oslcop.sysml.PortDefinition;
import org.oasis.oslcop.sysml.PortUsage;
import org.oasis.oslcop.sysml.Predicate;
import org.oasis.oslcop.sysml.Redefinition;
import org.oasis.oslcop.sysml.ReferenceUsage;
import org.oasis.oslcop.sysml.Relationship;
import org.oasis.oslcop.sysml.RenderingDefinition;
import org.oasis.oslcop.sysml.RenderingUsage;
import org.oasis.oslcop.sysml.RequirementDefinition;
import org.oasis.oslcop.sysml.RequirementUsage;
import org.eclipse.lyo.oslc.domains.am.Oslc_amDomainConstants;
import org.eclipse.lyo.oslc.domains.am.Resource;
import org.eclipse.lyo.oslc.domains.jazz_am.Jazz_amDomainConstants;
import org.oasis.oslcop.sysml.StateUsage;
import org.oasis.oslcop.sysml.Step;
import org.oasis.oslcop.sysml.Structure;
import org.oasis.oslcop.sysml.Subsetting;
import org.oasis.oslcop.sysml.Succession;
import org.oasis.oslcop.sysml.Superclassing;
import org.oasis.oslcop.sysml.TextualRepresentation;
import org.oasis.oslcop.sysml.TransitionUsage;
import org.oasis.oslcop.sysml.Type;
import org.oasis.oslcop.sysml.TypeFeaturing;
import org.oasis.oslcop.sysml.Usage;
import org.oasis.oslcop.sysml.VariantMembership;
import org.oasis.oslcop.sysml.VerificationCaseDefinition;
import org.oasis.oslcop.sysml.VerificationCaseUsage;
import org.oasis.oslcop.sysml.ViewDefinition;
import org.oasis.oslcop.sysml.ViewUsage;
import org.oasis.oslcop.sysml.ViewpointDefinition;
import org.oasis.oslcop.sysml.ViewpointUsage;



// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class SysmlServerManager {

    private static final Logger log = LoggerFactory.getLogger(SysmlServerManager.class);

    
    // Start of user code class_attributes
    // End of user code
    
    
    // Start of user code class_methods
    // End of user code

    public static void contextInitializeServletListener(final ServletContextEvent servletContextEvent)
    {
        
        // Start of user code contextInitializeServletListener
        // TODO Implement code to establish connection to data backbone etc ...
        // End of user code
        
    }

    public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) 
    {
        
        // Start of user code contextDestroyed
        // TODO Implement code to shutdown connections to data backbone etc...
        // End of user code
    }

    public static ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        ServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "ServiceProviderInfo[] getServiceProviderInfos(...)"
        serviceProviderInfos = CapellaClient.getProjects().toArray(new ServiceProviderInfo[0]);
        // End of user code
        return serviceProviderInfos;
    }

    public static List<Subsetting> querySubsettings(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<Subsetting> resources = null;
        
        
        // Start of user code querySubsettings
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }
    public static List<Subsetting> SubsettingSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<Subsetting> resources = null;
        
        
        // Start of user code SubsettingSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }



    public static List<Element> queryElements(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<Element> resources = null;
        
        
        // Start of user code queryElements
        resources = CapellaClient.getProjectElements(projectId,page,limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<Element> ElementSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<Element> resources = null;
        
        
        // Start of user code ElementSelector
        resources = CapellaClient.selectProjectElements(projectId,terms);
        // End of user code
        return resources;
    }



    public static List<SysmlClass> querySysmlClasss(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<SysmlClass> resources = null;
        
        
        // Start of user code querySysmlClasss
        resources = CapellaClient.getProjectSysmlClasses(projectId,page,limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<SysmlClass> SysmlClassSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<SysmlClass> resources = null;
        
        
        // Start of user code SysmlClassSelector
        resources = CapellaClient.selectProjectSysmlClasses(projectId,terms);
        // End of user code
        return resources;
    }



    public static List<Relationship> queryRelationships(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<Relationship> resources = null;
        
        
        // Start of user code queryRelationships
        resources = CapellaClient.getProjectRelationships(projectId,page,limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<Relationship> RelationshipSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<Relationship> resources = null;
        
        
        // Start of user code RelationshipSelector
        resources = CapellaClient.selectProjectRelationships(projectId,terms);
        // End of user code
        return resources;
    }



    public static List<Generalization> queryGeneralizations(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<Generalization> resources = null;
        
        
        // Start of user code queryGeneralizations
        resources = CapellaClient.getProjectGeneralizations(projectId,page,limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<Generalization> GeneralizationSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<Generalization> resources = null;
        
        
        // Start of user code GeneralizationSelector
        resources = CapellaClient.selectProjectGeneralizations(projectId, terms);
        // End of user code
        return resources;
    }



    public static List<Feature> queryFeatures(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<Feature> resources = null;
        
        
        // Start of user code queryFeatures
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }
    public static List<Feature> FeatureSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<Feature> resources = null;
        
        
        // Start of user code FeatureSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }



    public static List<FeatureMembership> queryFeatureMemberships(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<FeatureMembership> resources = null;
        
        
        // Start of user code queryFeatureMemberships
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }
    public static List<FeatureMembership> FeatureMembershipSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<FeatureMembership> resources = null;
        
        
        // Start of user code FeatureMembershipSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }



    public static List<FeatureTyping> queryFeatureTypings(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<FeatureTyping> resources = null;
        
        
        // Start of user code queryFeatureTypings
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }
    public static List<FeatureTyping> FeatureTypingSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<FeatureTyping> resources = null;
        
        
        // Start of user code FeatureTypingSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }



    public static List<PortUsage> queryPortUsages(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<PortUsage> resources = null;
        
        
        // Start of user code queryPortUsages
        resources = CapellaClient.getPortUsages(projectId, page, limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<PortUsage> PortUsageSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<PortUsage> resources = null;
        
        
        // Start of user code PortUsageSelector
        resources = CapellaClient.selectPortUsages(projectId, terms);
        // End of user code
        return resources;
    }



    public static List<AttributeUsage> queryAttributeUsages(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<AttributeUsage> resources = null;
        
        
        // Start of user code queryAttributeUsages
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }
    public static List<AttributeUsage> AttributeUsageSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<AttributeUsage> resources = null;
        
        
        // Start of user code AttributeUsageSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }



    public static List<PartUsage> queryPartUsages(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<PartUsage> resources = null;
        
        
        // Start of user code queryPartUsages
        // TODO Implement code to return a set of resources.
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }
    public static List<PartUsage> PartUsageSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<PartUsage> resources = null;
        
        
        // Start of user code PartUsageSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // An empty List should imply that no resources where found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return resources;
    }



    public static List<SysmlPackage> querySysmlPackages(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<SysmlPackage> resources = null;
        

        // Start of user code querySysmlPackages      
        resources = CapellaClient.getSysmlPackages(projectId, page, limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<SysmlPackage> SysmlPackageSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<SysmlPackage> resources = null;
        
        
        // Start of user code SysmlPackageSelector
        resources = CapellaClient.selectSysmlPackages(projectId, terms);
        // End of user code
        return resources;
    }



    public static List<Connector> queryConnectors(HttpServletRequest httpServletRequest, final String projectId, String where, String prefix, int page, int limit)
    {
        List<Connector> resources = null;
        
        
        // Start of user code queryConnectors
        resources = CapellaClient.getConnectors(projectId, page, limit, where, prefix);
        // End of user code
        return resources;
    }
    public static List<Connector> ConnectorSelector(HttpServletRequest httpServletRequest, final String projectId, String terms)   
    {
        List<Connector> resources = null;
        
        
        // Start of user code ConnectorSelector
        resources = CapellaClient.selectConnectors(projectId, terms);
        // End of user code
        return resources;
    }




    public static Subsetting getSubsetting(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        Subsetting aResource = null;
        
        
        // Start of user code getSubsetting
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static Element getElement(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        Element aResource = null;
        
        
        // Start of user code getElement
        aResource = CapellaClient.getElementById(projectId,id);
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static SysmlClass getSysmlClass(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        SysmlClass aResource = null;
        
        
        // Start of user code getSysmlClass
        // End of user code
        return aResource;
    }


    public static Relationship getRelationship(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        Relationship aResource = null;
        
        
        // Start of user code getRelationship
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static Generalization getGeneralization(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        Generalization aResource = null;
        
        
        // Start of user code getGeneralization
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static Feature getFeature(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        Feature aResource = null;
        
        
        // Start of user code getFeature
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static FeatureMembership getFeatureMembership(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        FeatureMembership aResource = null;
        
        
        // Start of user code getFeatureMembership
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static FeatureTyping getFeatureTyping(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        FeatureTyping aResource = null;
        
        
        // Start of user code getFeatureTyping
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static PortUsage getPortUsage(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        PortUsage aResource = null;
        
        
        // Start of user code getPortUsage
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static AttributeUsage getAttributeUsage(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        AttributeUsage aResource = null;
        
        
        // Start of user code getAttributeUsage
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static PartUsage getPartUsage(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        PartUsage aResource = null;
        
        
        // Start of user code getPartUsage
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static SysmlPackage getSysmlPackage(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        SysmlPackage aResource = null;
        
        
        // Start of user code getSysmlPackage
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }


    public static Connector getConnector(HttpServletRequest httpServletRequest, final String projectId, final String id)
    {
        Connector aResource = null;
        
        
        // Start of user code getConnector
        // TODO Implement code to return a resource
        // return 'null' if the resource was not found.
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return aResource;
    }



    public static String getETagFromAttributeUsage(final AttributeUsage aResource)
    {
        String eTag = null;
        // Start of user code getETagFromAttributeUsage
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromSysmlClass(final SysmlClass aResource)
    {
        String eTag = null;
        // Start of user code getETagFromSysmlClass
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromConnector(final Connector aResource)
    {
        String eTag = null;
        // Start of user code getETagFromConnector
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromElement(final Element aResource)
    {
        String eTag = null;
        // Start of user code getETagFromElement
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromFeature(final Feature aResource)
    {
        String eTag = null;
        // Start of user code getETagFromFeature
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromFeatureMembership(final FeatureMembership aResource)
    {
        String eTag = null;
        // Start of user code getETagFromFeatureMembership
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromFeatureTyping(final FeatureTyping aResource)
    {
        String eTag = null;
        // Start of user code getETagFromFeatureTyping
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromGeneralization(final Generalization aResource)
    {
        String eTag = null;
        // Start of user code getETagFromGeneralization
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromSysmlPackage(final SysmlPackage aResource)
    {
        String eTag = null;
        // Start of user code getETagFromSysmlPackage
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromPartUsage(final PartUsage aResource)
    {
        String eTag = null;
        // Start of user code getETagFromPartUsage
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromPortUsage(final PortUsage aResource)
    {
        String eTag = null;
        // Start of user code getETagFromPortUsage
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromRelationship(final Relationship aResource)
    {
        String eTag = null;
        // Start of user code getETagFromRelationship
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }
    public static String getETagFromSubsetting(final Subsetting aResource)
    {
        String eTag = null;
        // Start of user code getETagFromSubsetting
        // TODO Implement code to return an ETag for a particular resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return eTag;
    }

}
