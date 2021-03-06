/**
 * Copyright (C) Posten Norge AS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package peppol.bis.invoice3.domain;

import org.eaxy.Node;
import org.eaxy.QualifiedName;
import org.eaxy.Xml;

import static peppol.bis.invoice3.domain.Namespaces.CBC_NS;

public class Amount implements XmlElement {
    private final String amount;
    private final String currencyID;

    public Amount(String amount, String currencyID) {
        this.amount = amount;
        this.currencyID = currencyID;
    }

    @Override
    public Node node() {
        return Xml.el(
            new QualifiedName(CBC_NS, this.name())
            , Xml.text(this.amount)
            , Xml.attr("currencyID", this.currencyID)
        );
    }
}
