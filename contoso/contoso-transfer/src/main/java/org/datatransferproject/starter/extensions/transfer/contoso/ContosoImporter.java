package org.datatransferproject.starter.extensions.transfer.contoso;

import ezvcard.VCard;
import ezvcard.io.json.JCardReader;
import ezvcard.property.StructuredName;
import org.datatransferproject.spi.transfer.provider.ImportResult;
import org.datatransferproject.spi.transfer.provider.Importer;
import org.datatransferproject.types.transfer.auth.TokenAuthData;
import org.datatransferproject.types.transfer.models.contacts.ContactsModelWrapper;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class ContosoImporter implements Importer<TokenAuthData, ContactsModelWrapper> {

    @Override
    public ImportResult importItem(UUID jobId, TokenAuthData authData, ContactsModelWrapper wrapper) throws Exception {
        try (JCardReader reader = new JCardReader(wrapper.getVCards())) {
            List<VCard> cards = reader.readAll();
            for (VCard card : cards) {
                StructuredName structuredName = card.getStructuredName();
                System.out.println(String.format("Contoso: Importing contact for %s %s", structuredName.getGiven(), structuredName.getFamily()));
            }
        }
        return ImportResult.OK;
    }
}
