package org.datatransferproject.starter.extensions.transfer.fabrikam;

import ezvcard.VCard;
import ezvcard.io.json.JCardWriter;
import ezvcard.property.StructuredName;
import org.datatransferproject.spi.transfer.provider.ExportResult;
import org.datatransferproject.spi.transfer.provider.Exporter;
import org.datatransferproject.spi.transfer.types.ExportInformation;
import org.datatransferproject.types.transfer.auth.TokenAuthData;
import org.datatransferproject.types.transfer.models.contacts.ContactsModelWrapper;

import java.io.StringWriter;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
public class FabrikamExporter implements Exporter<TokenAuthData, ContactsModelWrapper> {

    @Override
    public ExportResult<ContactsModelWrapper> export(UUID jobId, TokenAuthData authData, Optional<ExportInformation> exportInformation) throws Exception {

        StringWriter stringWriter = new StringWriter();
        try (JCardWriter writer = new JCardWriter(stringWriter)) {
            VCard card = new VCard();
            StructuredName structuredName = new StructuredName();
            structuredName.setFamily("Doe");
            structuredName.setGiven("Jane");
            card.setStructuredName(structuredName);
            writer.write(card);
            System.out.println(String.format("Fabrikam: Exporting contact for %s %s", structuredName.getGiven(), structuredName.getFamily()));
        }

        ContactsModelWrapper wrapper = new ContactsModelWrapper(stringWriter.toString());
        return new ExportResult<>(ExportResult.ResultType.END, wrapper);
    }
}
