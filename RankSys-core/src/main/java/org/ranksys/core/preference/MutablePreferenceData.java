/* 
 * Copyright (C) 2015 RankSys http://ranksys.org
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.ranksys.core.preference;

import es.uam.eps.ir.ranksys.core.preference.PreferenceData;
import org.ranksys.core.index.MutableItemIndex;
import org.ranksys.core.index.MutableUserIndex;

/**
 * Mutable preference data. Preferences can be added or removed.
 *
 * @param <U> user type
 * @param <I> item type
 * @author Saúl Vargas (Saul@VargasSandoval.es)
 */
public interface MutablePreferenceData<U, I> extends PreferenceData<U, I>, MutableUserIndex<U>, MutableItemIndex<I> {

    /**
     * Adds preference.
     *
     * @param u     user
     * @param i     item
     * @param v     value
     * @param other additional information (e.g. timestamp, context)
     * @param <O>   type of additional information (e.g. timestamp, context)
     * @return true if preference was added, false otherwise
     */
    <O> boolean addPref(U u, I i, double v, O other);

    /**
     * Removes preference.
     *
     * @param u user
     * @param i item
     * @return true if preference was removed, false otherwise
     */
    boolean removePref(U u, I i);
}
