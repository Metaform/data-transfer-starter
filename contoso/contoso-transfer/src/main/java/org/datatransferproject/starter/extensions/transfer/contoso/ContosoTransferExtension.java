package org.datatransferproject.starter.extensions.transfer.contoso;

import org.datatransferproject.api.launcher.ExtensionContext;
import org.datatransferproject.spi.transfer.extension.TransferExtension;
import org.datatransferproject.spi.transfer.provider.Exporter;
import org.datatransferproject.spi.transfer.provider.Importer;

/**
 * Required by the Transfer SPI to load the extension in the runtime.
 */
public class ContosoTransferExtension implements TransferExtension {

    @Override
    public String getServiceId() {
        return "CONTOSO";
    }

    @Override
    public Exporter<?, ?> getExporter(String transferDataType) {
        return new ContosoExporter();
    }

    @Override
    public Importer<?, ?> getImporter(String transferDataType) {
        return new ContosoImporter();
    }

    @Override
    public void initialize(ExtensionContext context) {
        // Invoked once when the extension is loaded by the runtime to perform initialization
    }
}
