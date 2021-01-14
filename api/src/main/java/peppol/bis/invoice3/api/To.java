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
package peppol.bis.invoice3.api;

import org.eaxy.Element;
import peppol.bis.invoice3.domain.Invoice;
import peppol.bis.invoice3.validation.NoOpPeppolBilling3Validation;

public class To {
    private final Element xml;
    private final Invoice invoice;

    public To(Element xml, Invoice invoice) {
        this.xml = xml;
        this.invoice = invoice;
    }

    public To log() {
        System.out.println(xml.toIndentedXML());
        return this;
    }

    public Element xml() {
        return xml;
    }

    public To validate() {
        new NoOpPeppolBilling3Validation().isInvoiceValid(this.invoice);
        return this;
    }
}