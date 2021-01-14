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
package peppol.bis.invoice3;

import org.junit.jupiter.api.Test;
import peppol.bis.invoice3.domain.ExampleUsage1;

class InvoiceApiTest {

    @Test
    void name() {
        final String invoiceAsText = InvoiceApi.from(ExampleUsage1.example1())
            .process()
            .validate()
            .log()
            .xml()
            .toIndentedXML();
    }
}