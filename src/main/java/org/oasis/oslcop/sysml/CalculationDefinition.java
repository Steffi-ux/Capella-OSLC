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
import org.oasis.oslcop.sysml.ActionDefinition;
import org.oasis.oslcop.sysml.IBehavior;
import org.oasis.oslcop.sysml.ISysmlClass;
import org.oasis.oslcop.sysml.IFunction;
import org.oasis.oslcop.sysml.SysmlDomainConstants;

import org.oasis.oslcop.sysml.ActionUsage;
import org.oasis.oslcop.sysml.AllocationUsage;
import org.oasis.oslcop.sysml.AnalysisCaseUsage;
import org.oasis.oslcop.sysml.Annotation;
import org.oasis.oslcop.sysml.AttributeUsage;
import org.oasis.oslcop.sysml.CalculationUsage;
import org.oasis.oslcop.sysml.CaseUsage;
import org.oasis.oslcop.sysml.Comment;
import org.oasis.oslcop.sysml.Conjugation;
import org.oasis.oslcop.sysml.ConnectionUsage;
import org.oasis.oslcop.sysml.ConstraintUsage;
import org.oasis.oslcop.sysml.Documentation;
import org.oasis.oslcop.sysml.Element;
import org.oasis.oslcop.sysml.EnumerationUsage;
import org.oasis.oslcop.sysml.Expression;
import org.oasis.oslcop.sysml.Feature;
import org.oasis.oslcop.sysml.FeatureMembership;
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
import org.oasis.oslcop.sysml.ReferenceUsage;
import org.oasis.oslcop.sysml.Relationship;
import org.oasis.oslcop.sysml.RenderingUsage;
import org.oasis.oslcop.sysml.RequirementUsage;
import org.oasis.oslcop.sysml.StateUsage;
import org.oasis.oslcop.sysml.Step;
import org.oasis.oslcop.sysml.Superclassing;
import org.oasis.oslcop.sysml.TextualRepresentation;
import org.oasis.oslcop.sysml.TransitionUsage;
import org.oasis.oslcop.sysml.Usage;
import org.oasis.oslcop.sysml.VariantMembership;
import org.oasis.oslcop.sysml.VerificationCaseUsage;
import org.oasis.oslcop.sysml.ViewUsage;
import org.oasis.oslcop.sysml.ViewpointUsage;
// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(SysmlDomainConstants.CALCULATIONDEFINITION_NAMESPACE)
@OslcName(SysmlDomainConstants.CALCULATIONDEFINITION_LOCALNAME)
@OslcResourceShape(title = "CalculationDefinition Resource Shape", describes = SysmlDomainConstants.CALCULATIONDEFINITION_TYPE)
public class CalculationDefinition
    extends ActionDefinition
    implements ICalculationDefinition, IBehavior, ISysmlClass, IFunction
{
    // Start of user code attributeAnnotation:calculation
    // End of user code
    private Set<Link> calculation = new HashSet<Link>();
    // Start of user code attributeAnnotation:step
    // End of user code
    private Set<Link> step = new HashSet<Link>();
    // Start of user code attributeAnnotation:parameter
    // End of user code
    private Set<Link> parameter = new HashSet<Link>();
    // Start of user code attributeAnnotation:expression
    // End of user code
    private Set<Link> expression = new HashSet<Link>();
    // Start of user code attributeAnnotation:result
    // End of user code
    private Link result;
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public CalculationDefinition()
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public CalculationDefinition(final URI about)
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        SysmlDomainConstants.CALCULATIONDEFINITION_PATH,
        CalculationDefinition.class);
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
            result = result + "{a Local CalculationDefinition Resource} - update CalculationDefinition.toString() to present resource as desired.";
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
    
    public void addCalculation(final Link calculation)
    {
        this.calculation.add(calculation);
    }
    
    public void addStep(final Link step)
    {
        this.step.add(step);
    }
    
    public void addParameter(final Link parameter)
    {
        this.parameter.add(parameter);
    }
    
    public void addExpression(final Link expression)
    {
        this.expression.add(expression);
    }
    
    
    // Start of user code getterAnnotation:calculation
    // End of user code
    @OslcName("calculation")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "calculation")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.CALCULATIONUSAGE_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getCalculation()
    {
        // Start of user code getterInit:calculation
        // End of user code
        return calculation;
    }
    
    // Start of user code getterAnnotation:step
    // End of user code
    @OslcName("step")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "step")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.STEP_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getStep()
    {
        // Start of user code getterInit:step
        // End of user code
        return step;
    }
    
    // Start of user code getterAnnotation:parameter
    // End of user code
    @OslcName("parameter")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "parameter")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.FEATURE_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getParameter()
    {
        // Start of user code getterInit:parameter
        // End of user code
        return parameter;
    }
    
    // Start of user code getterAnnotation:expression
    // End of user code
    @OslcName("expression")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "expression")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.EXPRESSION_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getExpression()
    {
        // Start of user code getterInit:expression
        // End of user code
        return expression;
    }
    
    // Start of user code getterAnnotation:result
    // End of user code
    @OslcName("result")
    @OslcPropertyDefinition(SysmlDomainConstants.SYSML_NAMSPACE + "result")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({SysmlDomainConstants.FEATURE_TYPE})
    @OslcReadOnly(false)
    public Link getResult()
    {
        // Start of user code getterInit:result
        // End of user code
        return result;
    }
    
    
    // Start of user code setterAnnotation:calculation
    // End of user code
    public void setCalculation(final Set<Link> calculation )
    {
        // Start of user code setterInit:calculation
        // End of user code
        this.calculation.clear();
        if (calculation != null)
        {
            this.calculation.addAll(calculation);
        }
    
        // Start of user code setterFinalize:calculation
        // End of user code
    }
    
    // Start of user code setterAnnotation:step
    // End of user code
    public void setStep(final Set<Link> step )
    {
        // Start of user code setterInit:step
        // End of user code
        this.step.clear();
        if (step != null)
        {
            this.step.addAll(step);
        }
    
        // Start of user code setterFinalize:step
        // End of user code
    }
    
    // Start of user code setterAnnotation:parameter
    // End of user code
    public void setParameter(final Set<Link> parameter )
    {
        // Start of user code setterInit:parameter
        // End of user code
        this.parameter.clear();
        if (parameter != null)
        {
            this.parameter.addAll(parameter);
        }
    
        // Start of user code setterFinalize:parameter
        // End of user code
    }
    
    // Start of user code setterAnnotation:expression
    // End of user code
    public void setExpression(final Set<Link> expression )
    {
        // Start of user code setterInit:expression
        // End of user code
        this.expression.clear();
        if (expression != null)
        {
            this.expression.addAll(expression);
        }
    
        // Start of user code setterFinalize:expression
        // End of user code
    }
    
    // Start of user code setterAnnotation:result
    // End of user code
    public void setResult(final Link result )
    {
        // Start of user code setterInit:result
        // End of user code
        this.result = result;
    
        // Start of user code setterFinalize:result
        // End of user code
    }
    
    
}
