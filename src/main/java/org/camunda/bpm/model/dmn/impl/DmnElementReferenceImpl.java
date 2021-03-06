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
import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.DMN_ATTRIBUTE_HREF;
import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.DMN_ELEMENT_REFERENCE;

import org.camunda.bpm.model.dmn.instance.DmnElementReference;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.camunda.bpm.model.xml.type.attribute.Attribute;

public class DmnElementReferenceImpl extends DmnModelElementInstanceImpl implements DmnElementReference {

  protected static Attribute<String> hrefAttribute;

  public DmnElementReferenceImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getHref() {
    return hrefAttribute.getValue(this);
  }

  public void setHref(String href) {
    hrefAttribute.setValue(this, href);
  }

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(DmnElementReference.class, DMN_ELEMENT_REFERENCE)
      .namespaceUri(DMN10_NS)
      .instanceProvider(new ModelTypeInstanceProvider<DmnElementReference>() {
        public DmnElementReference newInstance(ModelTypeInstanceContext instanceContext) {
          return new DmnElementReferenceImpl(instanceContext);
        }
      });

    hrefAttribute = typeBuilder.stringAttribute(DMN_ATTRIBUTE_HREF)
      .required()
      .build();

    typeBuilder.build();
  }

}
