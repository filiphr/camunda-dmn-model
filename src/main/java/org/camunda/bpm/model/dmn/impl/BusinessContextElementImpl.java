/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.model.dmn.impl;

import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.DMN10_NS;
import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.DMN_ATTRIBUTE_URI;
import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.DMN_ELEMENT_BUSINESS_CONTEXT_ELEMENT;

import org.camunda.bpm.model.dmn.instance.BusinessContextElement;
import org.camunda.bpm.model.dmn.instance.DmnElement;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.attribute.Attribute;

public abstract class BusinessContextElementImpl extends DmnElementImpl implements BusinessContextElement {

  protected static Attribute<String> uriAttribute;

  public BusinessContextElementImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getUri() {
    return uriAttribute.getValue(this);
  }

  public void setUri(String uri) {
    uriAttribute.setValue(this, uri);
  }

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(BusinessContextElement.class, DMN_ELEMENT_BUSINESS_CONTEXT_ELEMENT)
      .namespaceUri(DMN10_NS)
      .extendsType(DmnElement.class)
      .abstractType();

    uriAttribute = typeBuilder.stringAttribute(DMN_ATTRIBUTE_URI)
      .build();

    typeBuilder.build();
  }

}
