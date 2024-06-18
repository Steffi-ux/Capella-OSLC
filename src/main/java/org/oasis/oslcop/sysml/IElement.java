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

import org.oasis.oslcop.sysml.SysmlDomainConstants;
import org.oasis.oslcop.sysml.SysmlDomainConstants;

import org.oasis.oslcop.sysml.IAnnotation;
import org.oasis.oslcop.sysml.IComment;
import org.oasis.oslcop.sysml.IDocumentation;
import org.oasis.oslcop.sysml.IElement;
import org.oasis.oslcop.sysml.IMembership;
import org.oasis.oslcop.sysml.INamespace;
import org.eclipse.lyo.oslc.domains.IPerson;
import org.oasis.oslcop.sysml.IRelationship;
import org.oasis.oslcop.sysml.ITextualRepresentation;
// Start of user code imports
// End of user code

@OslcNamespace(SysmlDomainConstants.ELEMENT_NAMESPACE)
@OslcName(SysmlDomainConstants.ELEMENT_LOCALNAME)
@OslcResourceShape(title = "Element Resource Shape", describes = SysmlDomainConstants.ELEMENT_TYPE)
public interface IElement
{

    public void addAliasId(final String aliasId );
    public void addOwnedRelationship_comp(final Link ownedRelationship_comp );
    public void addOwnedElement(final Link ownedElement );
    public void addDocumentation_comp(final Link documentation_comp );
    public void addOwnedAnnotation_comp(final Link ownedAnnotation_comp );
    public void addDocumentationComment(final Link documentationComment );
    public void addOwnedTextualRepresentation(final Link ownedTextualRepresentation );
    public void addOwnedRelationship(final Link ownedRelationship );
    public void addDocumentation(final Link documentation );
    public void addOwnedAnnotation(final Link ownedAnnotation );

    @OslcName("identifier")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "identifier")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getSysmlIdentifier();

    @OslcName("name")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "name")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getName();

    @OslcName("qualifiedName")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "qualifiedName")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getQualifiedName();

    @OslcName("aliasId")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "aliasId")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public Set<String> getAliasId();

    @OslcName("humanId")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "humanId")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getHumanId();

    @OslcName("owningMembership")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "owningMembership")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.MEMBERSHIP_TYPE})
    @OslcReadOnly(false)
    public Link getOwningMembership();

    @OslcName("ownedRelationship_comp")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "ownedRelationship_comp")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.RELATIONSHIP_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getOwnedRelationship_comp();

    @OslcName("owningRelationship")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "owningRelationship")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.RELATIONSHIP_TYPE})
    @OslcReadOnly(false)
    public Link getOwningRelationship();

    @OslcName("owningNamespace")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "owningNamespace")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.NAMESPACE_TYPE})
    @OslcReadOnly(false)
    public Link getOwningNamespace();

    @OslcName("owner")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "owner")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.ELEMENT_TYPE})
    @OslcReadOnly(false)
    public Link getOwner();

    @OslcName("ownedElement")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "ownedElement")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.ELEMENT_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getOwnedElement();

    @OslcName("documentation_comp")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "documentation_comp")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.DOCUMENTATION_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getDocumentation_comp();

    @OslcName("ownedAnnotation_comp")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "ownedAnnotation_comp")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.ANNOTATION_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getOwnedAnnotation_comp();

    @OslcName("documentationComment")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "documentationComment")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.COMMENT_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getDocumentationComment();

    @OslcName("ownedTextualRepresentation")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "ownedTextualRepresentation")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.TEXTUALREPRESENTATION_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getOwnedTextualRepresentation();

    @OslcName("ownedRelationship")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "ownedRelationship")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.RELATIONSHIP_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getOwnedRelationship();

    @OslcName("documentation")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "documentation")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.DOCUMENTATION_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getDocumentation();

    @OslcName("ownedAnnotation")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "ownedAnnotation")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.ANNOTATION_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getOwnedAnnotation();


    public void setSysmlIdentifier(final String identifier );
    public void setName(final String name );
    public void setQualifiedName(final String qualifiedName );
    public void setAliasId(final Set<String> aliasId );
    public void setHumanId(final String humanId );
    public void setOwningMembership(final Link owningMembership );
    public void setOwnedRelationship_comp(final Set<Link> ownedRelationship_comp );
    public void setOwningRelationship(final Link owningRelationship );
    public void setOwningNamespace(final Link owningNamespace );
    public void setOwner(final Link owner );
    public void setOwnedElement(final Set<Link> ownedElement );
    public void setDocumentation_comp(final Set<Link> documentation_comp );
    public void setOwnedAnnotation_comp(final Set<Link> ownedAnnotation_comp );
    public void setDocumentationComment(final Set<Link> documentationComment );
    public void setOwnedTextualRepresentation(final Set<Link> ownedTextualRepresentation );
    public void setOwnedRelationship(final Set<Link> ownedRelationship );
    public void setDocumentation(final Set<Link> documentation );
    public void setOwnedAnnotation(final Set<Link> ownedAnnotation );
}
