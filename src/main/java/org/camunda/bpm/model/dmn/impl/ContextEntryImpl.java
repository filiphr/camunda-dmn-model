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

import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.FEEL_ELEMENT_CONTEXT_ENTRY;
import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.FEEL_NS;

import org.camunda.bpm.model.dmn.instance.ContextEntry;
import org.camunda.bpm.model.dmn.instance.Expression;
import org.camunda.bpm.model.dmn.instance.InformationItem;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.camunda.bpm.model.xml.type.child.ChildElement;
import org.camunda.bpm.model.xml.type.child.SequenceBuilder;

public class ContextEntryImpl extends DmnModelElementInstanceImpl implements ContextEntry {

  protected static ChildElement<InformationItem> informationItemChild;
  protected static ChildElement<Expression> expressionChild;

  public ContextEntryImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public InformationItem getInformationItem() {
    return informationItemChild.getChild(this);
  }

  public void setInformationItem(InformationItem informationItem) {
    informationItemChild.setChild(this, informationItem);
  }

  public Expression getExpression() {
    return expressionChild.getChild(this);
  }

  public void setExpression(Expression expression) {
    expressionChild.setChild(this, expression);
  }

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(ContextEntry.class, FEEL_ELEMENT_CONTEXT_ENTRY)
      .namespaceUri(FEEL_NS)
      .instanceProvider(new ModelTypeInstanceProvider<ContextEntry>() {
        public ContextEntry newInstance(ModelTypeInstanceContext instanceContext) {
          return new ContextEntryImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    informationItemChild = sequenceBuilder.element(InformationItem.class)
      .build();

    expressionChild = sequenceBuilder.element(Expression.class)
      .required()
      .build();

    typeBuilder.build();
  }

}
