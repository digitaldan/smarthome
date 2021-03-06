/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.io.rest.core.internal;

import org.eclipse.smarthome.io.rest.core.JSONResponse;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Extension of the default OSGi bundle activator
 *
 * @author Kai Kreuzer - Initial contribution and API
 */
public class RESTCoreActivator implements BundleActivator {

    private static BundleContext context;
    private ServiceRegistration<JSONResponse.ExceptionMapper> mExcMapper;

    /**
     * Called whenever the OSGi framework starts our bundle
     */
    @Override
    public void start(BundleContext bc) throws Exception {
        context = bc;
        mExcMapper = bc.registerService(JSONResponse.ExceptionMapper.class, new JSONResponse.ExceptionMapper(), null);
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        context = null;
        mExcMapper.unregister();
    }

    public static BundleContext getBundleContext() {
        return context;
    }

}
