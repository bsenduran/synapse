/*
* Copyright 2004,2005 The Apache Software Foundation.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.synapse.mediators;

import org.apache.synapse.config.xml.Constants;
import org.apache.synapse.Util;
import org.apache.synapse.SynapseContext;
import org.apache.axiom.om.xpath.AXIOMXPath;

import javax.xml.namespace.QName;

/**
 * A mediator property is a name-value or name-expression pair which could be supplied
 * for certain mediators. If expressions are supplied they are evaluated at the runtime
 * against the current message into literal String values.
 */
public class MediatorProperty {

    public static final QName PROPERTY_Q  = new QName(Constants.SYNAPSE_NAMESPACE, "property");
    public static final QName ATT_NAME_Q  = new QName(Constants.NULL_NAMESPACE, "name");
    public static final QName ATT_VALUE_Q = new QName(Constants.NULL_NAMESPACE, "value");
    public static final QName ATT_EXPR_Q  = new QName(Constants.NULL_NAMESPACE, "expression");

    private String name;
    private String value;
    private AXIOMXPath expression;

    public MediatorProperty() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AXIOMXPath getExpression() {
        return expression;
    }

    public void setExpression(AXIOMXPath expression) {
        this.expression = expression;
    }

    public String getEvaluatedExpression(SynapseContext synCtx) {
        return Util.getStringValue(expression, synCtx);
    }

}