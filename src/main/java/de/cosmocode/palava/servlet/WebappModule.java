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

import com.google.inject.Key;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.servlet.ServletModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Tobias Sarnowski
 */
public abstract class WebappModule extends ServletModule {
    private static Logger LOG = LoggerFactory.getLogger(WebappModule.class);

    public void addWebapp(File location, String context) {
        try {
            addWebapp(location.toURI().toURL(), context);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void addWebapp(URL location, String context) {
        addWebapp(location.toExternalForm(), context);
    }

    public void addWebapp(String location, String context) {
        Multibinder.newSetBinder(binder(), Webapp.class).addBinding().toInstance(new Webapp(location, context));
    }
}