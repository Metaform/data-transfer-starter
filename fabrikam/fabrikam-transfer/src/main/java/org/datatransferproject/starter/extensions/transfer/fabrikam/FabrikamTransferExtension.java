package org.datatransferproject.starter.extensions.transfer.fabrikam;

import org.datatransferproject.api.launcher.ExtensionContext;
import org.datatransferproject.spi.transfer.extension.TransferExtension;
import org.datatransferproject.spi.transfer.provider.Exporter;
import org.datatransferproject.spi.transfer.provider.Importer;

/**
 * Required by the Transfer SPI to load the extension in the runtime.
 */
public class FabrikamTransferExtension implements TransferExtension {

    @Override
    public String getServiceId() {
        return "FABRIKAM";
    }

    @Override
    public Exporter<?, ?> getExporter(String transferDataType) {
        return new FabrikamExporter();
    }

    @Override
    public Importer<?, ?> getImporter(String transferDataType) {
        return new FabrikamImporter();
    }

    @Override
    public void initialize(ExtensionContext context) {
        // Invoked once when the extension is loaded by the runtime to perform initialization
    }
}
