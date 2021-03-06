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
import static org.camunda.bpm.model.dmn.impl.DmnModelConstants.DMN_ELEMENT_INVOCATION;

import java.util.Collection;

import org.camunda.bpm.model.dmn.instance.Binding;
import org.camunda.bpm.model.dmn.instance.Expression;
import org.camunda.bpm.model.dmn.instance.Invocation;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.camunda.bpm.model.xml.type.child.ChildElementCollection;
import org.camunda.bpm.model.xml.type.child.SequenceBuilder;

public class InvocationImpl extends ExpressionImpl implements Invocation {

  protected static ChildElementCollection<Binding> bindingCollection;

  public InvocationImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Collection<Binding> getBindings() {
    return bindingCollection.get(this);
  }

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(Invocation.class, DMN_ELEMENT_INVOCATION)
      .namespaceUri(DMN10_NS)
      .extendsType(Expression.class)
      .instanceProvider(new ModelTypeInstanceProvider<Invocation>() {
        public Invocation newInstance(ModelTypeInstanceContext instanceContext) {
          return new InvocationImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    bindingCollection = sequenceBuilder.elementCollection(Binding.class)
      .build();

    typeBuilder.build();
  }

}
