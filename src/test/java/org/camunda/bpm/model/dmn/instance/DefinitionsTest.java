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

package org.camunda.bpm.model.dmn.instance;

import java.util.Arrays;
import java.util.Collection;

public class DefinitionsTest extends DmnModelElementInstanceTest {

  public TypeAssumption getTypeAssumption() {
    return new TypeAssumption(DmnElement.class, false);
  }

  public Collection<ChildElementAssumption> getChildElementAssumptions() {
    return Arrays.asList(
      new ChildElementAssumption(Import.class),
      new ChildElementAssumption(ItemDefinition.class),
      new ChildElementAssumption(DrgElement.class),
      new ChildElementAssumption(ElementCollection.class),
      new ChildElementAssumption(BusinessContextElement.class)
    );
  }

  public Collection<AttributeAssumption> getAttributesAssumptions() {
    return Arrays.asList(
      new AttributeAssumption("expressionLanguage", false, false, "http://www.omg.org/spec/FEEL/20140401"),
      new AttributeAssumption("typeLanguage", false, false, "http://www.omg.org/spec/FEEL/20140401"),
      new AttributeAssumption("namespace", false, true)
    );
  }

}
