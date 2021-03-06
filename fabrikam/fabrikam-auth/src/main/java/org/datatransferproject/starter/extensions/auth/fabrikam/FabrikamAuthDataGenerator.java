/*
 * Copyright 2018 The Data Transfer Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.datatransferproject.starter.extensions.auth.fabrikam;

import org.datatransferproject.spi.api.auth.AuthDataGenerator;
import org.datatransferproject.spi.api.types.AuthFlowConfiguration;
import org.datatransferproject.types.transfer.auth.AuthData;
import org.datatransferproject.types.transfer.auth.TokenAuthData;

import static org.datatransferproject.types.common.PortabilityCommon.AuthProtocol;
import static org.datatransferproject.types.common.PortabilityCommon.AuthProtocol.OAUTH_2;

/**
 * Generates authentication data for Fabrikam.
 *
 *
 * Since the demo does not authenticate against a live service, the OAuth url is set set directly to the callback address.
 */
public class FabrikamAuthDataGenerator implements AuthDataGenerator {
    private static final AuthProtocol AUTH_PROTOCOL = OAUTH_2;

    @Override
    public AuthFlowConfiguration generateConfiguration(String callbackBaseUrl, String id) {
        // Normally the auth URL would be the URL of the OAuth provider. Since the demo Fabrikam extension does not use a real OAuth service, the configuration informs the UI
        // it should simply redirect to the OAuth callback URL with a dummy token
        String authUrl = callbackBaseUrl + "?code=123";
        return new AuthFlowConfiguration(authUrl, AUTH_PROTOCOL, getTokenUrl());
    }

    @Override
    public AuthData generateAuthData(String callbackBaseUrl, String authCode, String id, AuthData initialAuthData, String extra) {
        // create a simulated token; since this is a demo extension that does not perform an actual import, OAuth is bypassed.
        return new TokenAuthData("123");
    }
}
