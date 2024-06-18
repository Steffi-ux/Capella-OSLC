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
import org.oasis.oslcop.sysml.CaseUsage;

import org.oasis.oslcop.sysml.SysmlDomainConstants;

import org.oasis.oslcop.sysml.ActionUsage;
import org.oasis.oslcop.sysml.AllocationUsage;
import org.oasis.oslcop.sysml.AnalysisCaseUsage;
import org.oasis.oslcop.sysml.Annotation;
import org.oasis.oslcop.sysml.AttributeUsage;
import org.oasis.oslcop.sysml.Behavior;
import org.oasis.oslcop.sysml.CalculationUsage;
import org.oasis.oslcop.sysml.CaseDefinition;
import org.oasis.oslcop.sysml.CaseUsage;
import org.oasis.oslcop.sysml.Comment;
import org.oasis.oslcop.sysml.Conjugation;
import org.oasis.oslcop.sysml.ConnectionUsage;
import org.oasis.oslcop.sysml.ConstraintUsage;
import org.oasis.oslcop.sysml.Definition;
import org.oasis.oslcop.sysml.Documentation;
import org.oasis.oslcop.sysml.Element;
import org.oasis.oslcop.sysml.EnumerationUsage;
import org.oasis.oslcop.sysml.Feature;
import org.oasis.oslcop.sysml.FeatureMembership;
import org.oasis.oslcop.sysml.FeatureTyping;
import org.oasis.oslcop.sysml.Function;
import org.oasis.oslcop.sysml.Generalization;
import org.oasis.oslcop.sysml.SysmlImport;
import org.oasis.oslcop.sysml.IndividualUsage;
import org.oasis.oslcop.sysml.InterfaceUsage;
import org.oasis.oslcop.sysml.ItemUsage;
import org.oasis.oslcop.sysml.Membership;
import org.oasis.oslcop.sysml.Multiplicity;
import org.oasis.oslcop.sysml.Namespace;
import org.oasis.oslcop.sysml.PartUsage;
import org.eclipse.lyo.oslc.domains.Person;
import org.oasis.oslcop.sysml.PortUsage;
import org.oasis.oslcop.sysml.Redefinition;
import org.oasis.oslcop.sysml.ReferenceUsage;
import org.oasis.oslcop.sysml.Relationship;
import org.oasis.oslcop.sysml.RenderingUsage;
import org.oasis.oslcop.sysml.RequirementUsage;
import org.oasis.oslcop.sysml.StateUsage;
import org.oasis.oslcop.sysml.Subsetting;
import org.oasis.oslcop.sysml.TextualRepresentation;
import org.oasis.oslcop.sysml.TransitionUsage;
import org.oasis.oslcop.sysml.Type;
import org.oasis.oslcop.sysml.TypeFeaturing;
import org.oasis.oslcop.sysml.Usage;
import org.oasis.oslcop.sysml.VariantMembership;
import org.oasis.oslcop.sysml.VerificationCaseDefinition;
import org.oasis.oslcop.sysml.VerificationCaseUsage;
import org.oasis.oslcop.sysml.ViewUsage;
import org.oasis.oslcop.sysml.ViewpointUsage;
// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(SysmlDomainConstants.VERIFICATIONCASEUSAGE_NAMESPACE)
@OslcName(SysmlDomainConstants.VERIFICATIONCASEUSAGE_LOCALNAME)
@OslcResourceShape(title = "VerificationCaseUsage Resource Shape", describes = SysmlDomainConstants.VERIFICATIONCASEUSAGE_TYPE)
public class VerificationCaseUsage
    extends CaseUsage
    implements IVerificationCaseUsage
{
    // Start of user code attributeAnnotation:verificationCaseDefinition
    // End of user code
    private Link verificationCaseDefinition;
    // Start of user code attributeAnnotation:verifiedRequirement
    // End of user code
    private Set<Link> verifiedRequirement = new HashSet<Link>();
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public VerificationCaseUsage()
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public VerificationCaseUsage(final URI about)
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        SysmlDomainConstants.VERIFICATIONCASEUSAGE_PATH,
        VerificationCaseUsage.class);
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
            result = result + "{a Local VerificationCaseUsage Resource} - update VerificationCaseUsage.toString() to present resource as desired.";
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
    
    public void addVerifiedRequirement(final Link verifiedRequirement)
    {
        this.verifiedRequirement.add(verifiedRequirement);
    }
    
    
    // Start of user code getterAnnotation:verificationCaseDefinition
    // End of user code
    @OslcName("verificationCaseDefinition")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "verificationCaseDefinition")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.VERIFICATIONCASEDEFINITION_TYPE})
    @OslcReadOnly(false)
    public Link getVerificationCaseDefinition()
    {
        // Start of user code getterInit:verificationCaseDefinition
        // End of user code
        return verificationCaseDefinition;
    }
    
    // Start of user code getterAnnotation:verifiedRequirement
    // End of user code
    @OslcName("verifiedRequirement")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "verifiedRequirement")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.REQUIREMENTUSAGE_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getVerifiedRequirement()
    {
        // Start of user code getterInit:verifiedRequirement
        // End of user code
        return verifiedRequirement;
    }
    
    
    // Start of user code setterAnnotation:verificationCaseDefinition
    // End of user code
    public void setVerificationCaseDefinition(final Link verificationCaseDefinition )
    {
        // Start of user code setterInit:verificationCaseDefinition
        // End of user code
        this.verificationCaseDefinition = verificationCaseDefinition;
    
        // Start of user code setterFinalize:verificationCaseDefinition
        // End of user code
    }
    
    // Start of user code setterAnnotation:verifiedRequirement
    // End of user code
    public void setVerifiedRequirement(final Set<Link> verifiedRequirement )
    {
        // Start of user code setterInit:verifiedRequirement
        // End of user code
        this.verifiedRequirement.clear();
        if (verifiedRequirement != null)
        {
            this.verifiedRequirement.addAll(verifiedRequirement);
        }
    
        // Start of user code setterFinalize:verifiedRequirement
        // End of user code
    }
    
    
}