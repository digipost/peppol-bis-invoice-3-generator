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
package peppol.bis.invoice3.validate;

import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.state.EValidity;
import com.helger.schematron.schxslt.xslt2.SchematronResourceSchXslt_XSLT2;
import com.helger.schematron.validator.SchematronValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatePeppolBilling3SchematronTest {

    private ClassPathResource schemaResource;

    @BeforeEach
    void setUp() {
        schemaResource = new ClassPathResource("sch_3.0.9/PEPPOL-EN16931-UBL.sch");
    }

    @Test
    void validate_schematron_Peppol_BIS_billing3() {
        final boolean schematron = SchematronValidator.isValidSchematron(schemaResource);

        assertTrue(schematron);
    }

    @Test
    void read_and_compile_schematron_PeppolBIS_billing3_with_XsltJava() throws Exception {
        final SchematronResourceSchXslt_XSLT2 res = SchematronResourceSchXslt_XSLT2.fromFile(schemaResource.getAsFile());

        assertTrue(res.isValidSchematron());

        final ClassPathResource aXMLResource = new ClassPathResource("/Norwegian-example-1.xml");
        final Document document = res.applySchematronValidation(aXMLResource);

        System.out.println (com.helger.xml.serialize.write.XMLWriter.getNodeAsString (document));

        final EValidity schematronValidity = res.getSchematronValidity(aXMLResource);

        assertThat(schematronValidity, equalTo(EValidity.VALID));
    }
}
