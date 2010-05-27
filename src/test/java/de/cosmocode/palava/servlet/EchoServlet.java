/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.palava.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.cosmocode.palava.core.Registry;

/**
 * Test servlet.
 *
 * @author Willi Schoenborn
 */
@Singleton
public final class EchoServlet extends HttpServlet {

    private static final long serialVersionUID = 297208794485911599L;

    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);
    
    @Inject
    public EchoServlet(Registry registry) {
        LOG.info("Injected registry", registry);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOG.info("Incoming request on {}", this);
        final Writer writer = response.getWriter();
        writer.write(Arrays.toString(Object[].class.cast(request.getParameterMap().get("q"))));
        writer.flush();
    }

}
