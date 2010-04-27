/**
 * palava - a java-php-bridge
 * Copyright (C) 2007-2010  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
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
