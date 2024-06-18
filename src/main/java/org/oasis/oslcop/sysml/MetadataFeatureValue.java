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

package org.oasis.oslcop.sysml;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRdfCollectionType;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;
import org.eclipse.lyo.oslc4j.core.model.ResourceShape;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;

import org.oasis.oslcop.sysml.SysmlDomainConstants;
import org.oasis.oslcop.sysml.FeatureValue;

import org.oasis.oslcop.sysml.SysmlDomainConstants;

import org.oasis.oslcop.sysml.Annotation;
import org.oasis.oslcop.sysml.BindingConnector;
import org.oasis.oslcop.sysml.Comment;
import org.oasis.oslcop.sysml.Documentation;
import org.oasis.oslcop.sysml.Element;
import org.oasis.oslcop.sysml.Expression;
import org.oasis.oslcop.sysml.Feature;
import org.oasis.oslcop.sysml.Membership;
import org.oasis.oslcop.sysml.MetadataFeature;
import org.oasis.oslcop.sysml.Namespace;
import org.eclipse.lyo.oslc.domains.Person;
import org.oasis.oslcop.sysml.Relationship;
import org.oasis.oslcop.sysml.TextualRepresentation;
// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(SysmlDomainConstants.METADATAFEATUREVALUE_NAMESPACE)
@OslcName(SysmlDomainConstants.METADATAFEATUREVALUE_LOCALNAME)
@OslcResourceShape(title = "MetadataFeatureValue Resource Shape", describes = SysmlDomainConstants.METADATAFEATUREVALUE_TYPE)
public class MetadataFeatureValue
    extends FeatureValue
    implements IMetadataFeatureValue
{
    // Start of user code attributeAnnotation:metadataValue_comp
    // End of user code
    private Link metadataValue_comp;
    // Start of user code attributeAnnotation:owningMetadataFeature
    // End of user code
    private Link owningMetadataFeature;
    // Start of user code attributeAnnotation:metadataValue
    // End of user code
    private Link metadataValue;
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public MetadataFeatureValue()
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public MetadataFeatureValue(final URI about)
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        SysmlDomainConstants.METADATAFEATUREVALUE_PATH,
        MetadataFeatureValue.class);
    }
    
    
    public String toString()
    {
        return toString(false);
    }
    
    public String toString(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toString_init
        // End of user code
    
        if (asLocalResource) {
            result = result + "{a Local MetadataFeatureValue Resource} - update MetadataFeatureValue.toString() to present resource as desired.";
            // Start of user code toString_bodyForLocalResource
            // End of user code
        }
        else {
            result = String.valueOf(getAbout());
        }
    
        // Start of user code toString_finalize
        result = getShortTitle();
        // End of user code
    
        return result;
    }
    
    
    // Start of user code getterAnnotation:metadataValue_comp
    // End of user code
    @OslcName("metadataValue_comp")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "metadataValue_comp")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.EXPRESSION_TYPE})
    @OslcReadOnly(false)
    public Link getMetadataValue_comp()
    {
        // Start of user code getterInit:metadataValue_comp
        // End of user code
        return metadataValue_comp;
    }
    
    // Start of user code getterAnnotation:owningMetadataFeature
    // End of user code
    @OslcName("owningMetadataFeature")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "owningMetadataFeature")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.METADATAFEATURE_TYPE})
    @OslcReadOnly(false)
    public Link getOwningMetadataFeature()
    {
        // Start of user code getterInit:owningMetadataFeature
        // End of user code
        return owningMetadataFeature;
    }
    
    // Start of user code getterAnnotation:metadataValue
    // End of user code
    @OslcName("metadataValue")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "metadataValue")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.EXPRESSION_TYPE})
    @OslcReadOnly(false)
    public Link getMetadataValue()
    {
        // Start of user code getterInit:metadataValue
        // End of user code
        return metadataValue;
    }
    
    
    // Start of user code setterAnnotation:metadataValue_comp
    // End of user code
    public void setMetadataValue_comp(final Link metadataValue_comp )
    {
        // Start of user code setterInit:metadataValue_comp
        // End of user code
        this.metadataValue_comp = metadataValue_comp;
    
        // Start of user code setterFinalize:metadataValue_comp
        // End of user code
    }
    
    // Start of user code setterAnnotation:owningMetadataFeature
    // End of user code
    public void setOwningMetadataFeature(final Link owningMetadataFeature )
    {
        // Start of user code setterInit:owningMetadataFeature
        // End of user code
        this.owningMetadataFeature = owningMetadataFeature;
    
        // Start of user code setterFinalize:owningMetadataFeature
        // End of user code
    }
    
    // Start of user code setterAnnotation:metadataValue
    // End of user code
    public void setMetadataValue(final Link metadataValue )
    {
        // Start of user code setterInit:metadataValue
        // End of user code
        this.metadataValue = metadataValue;
    
        // Start of user code setterFinalize:metadataValue
        // End of user code
    }
    
    
}
