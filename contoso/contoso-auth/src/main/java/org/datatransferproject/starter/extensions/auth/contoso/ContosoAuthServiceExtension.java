package org.datatransferproject.starter.extensions.auth.contoso;

import org.datatransferproject.api.launcher.ExtensionContext;
import org.datatransferproject.spi.api.auth.AuthDataGenerator;
import org.datatransferproject.spi.api.auth.AuthServiceProviderRegistry;
import org.datatransferproject.spi.api.auth.extension.AuthServiceExtension;

import java.util.Collections;
import java.util.List;

/**
 * Required by the API Server SPI to load the extension in the runtime.
 */
public class ContosoAuthServiceExtension implements AuthServiceExtension {
    private static final List<String> TYPES = Collections.singletonList("CONTACTS");

    @Override
    public String getServiceId() {
        return "CONTOSO";
    }

    @Override
    public List<String> getImportTypes() {
        return TYPES;
    }

    @Override
    public List<String> getExportTypes() {
        return TYPES;
    }

    @Override
    public AuthDataGenerator getAuthDataGenerator(String transferDataType, AuthServiceProviderRegistry.AuthMode mode) {
        return new ContosoAuthDataGenerator();
    }

    @Override
    public void initialize(ExtensionContext context) {
        // Invoked once when the extension is loaded by the runtime to perform initialization
    }
}
