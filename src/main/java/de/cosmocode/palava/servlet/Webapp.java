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

import com.google.common.base.Preconditions;

/**
 * Small value object for location and context mapping.
 * 
 * @author Tobias Sarnowski
 * @author Willi Schoenborn 
 */
public final class Webapp {

    private final String location;
    private final String context;

    Webapp(String location, String context) {
        this.location = Preconditions.checkNotNull(location, "Location");
        this.context = Preconditions.checkNotNull(context, "Context");
    }

    public String getLocation() {
        return location;
    }

    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return String.format("Webapp [context=%s, location=%s]", context, location);
    }
    
}
