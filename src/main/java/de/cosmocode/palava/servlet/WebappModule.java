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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.inject.multibindings.Multibinder;
import com.google.inject.servlet.ServletModule;

/**
 * A module which allows easy configuration of different webapps
 * within a servlet container.
 * 
 * @author Tobias Sarnowski
 * @author Willi Schoenborn
 */
public abstract class WebappModule extends ServletModule {

    /**
     * Adds the webapp specified by the given location and context.
     * 
     * @param location the war file location
     * @param context the webapp context
     * @throws IllegalArgumentException if the given location can not be transformed into a url
     */
    protected final void addWebapp(File location, String context) {
        try {
            addWebapp(location.toURI().toURL(), context);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Adds the webapp specified by the given location and context.
     * 
     * @param location the war file location
     * @param context the webapp context
     */
    protected final void addWebapp(URL location, String context) {
        addWebapp(location.toExternalForm(), context);
    }

    /**
     * Adds the webapp specified by the given location and context.
     * 
     * @param location the war file location
     * @param context the webapp context
     */
    protected final void addWebapp(String location, String context) {
        Multibinder.newSetBinder(binder(), Webapp.class).addBinding().toInstance(new Webapp(location, context));
    }
}
