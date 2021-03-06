/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.tomitribe.tribestream.registryng.test.mock;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import static org.junit.Assert.assertEquals;

@Path("mock/oauth2")
public class OAuth2Mock {
    @POST
    @Path("token")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String token(final MultivaluedMap<String, String> form) {
        assertEquals("password", form.get("grant_type").iterator().next());
        assertEquals("testuser", form.get("username").iterator().next());
        assertEquals("testpassword", form.get("password").iterator().next());
        assertEquals("client", form.get("client_id").iterator().next());
        assertEquals("client secret", form.get("client_secret").iterator().next());
        return "{\"access_token\":\"awesome-token\",\"token_type\":\"bearer\"}";
    }
}
