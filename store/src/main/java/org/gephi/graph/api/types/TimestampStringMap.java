/*
 * Copyright 2012-2013 Gephi Consortium
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gephi.graph.api.types;

import org.gephi.graph.api.Estimator;
import org.gephi.graph.api.Interval;

/**
 * Sorted map where keys are timestamp and values string values.
 */
public final class TimestampStringMap extends TimestampMap<String> {

    private String[] values;

    /**
     * Default constructor.
     * <p>
     * The map is empty with zero capacity.
     */
    public TimestampStringMap() {
        super();
        values = new String[0];
    }

    /**
     * Constructor with capacity.
     * <p>
     * Using this constructor can improve performances if the number of
     * timestamps is known in advance as it minimizes array resizes.
     *
     * @param capacity timestamp capacity
     */
    public TimestampStringMap(int capacity) {
        super(capacity);
        values = new String[capacity];
    }

    @Override
    public boolean put(double timestamp, String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        final int index = putInner(timestamp);
        if (index < 0) {
            int insertIndex = -index - 1;

            if (size - 1 < values.length) {
                if (insertIndex < size - 1) {
                    System.arraycopy(values, insertIndex, values, insertIndex + 1, size - insertIndex - 1);
                }
                values[insertIndex] = value;
            } else {
                String[] newArray = new String[values.length + 1];
                System.arraycopy(values, 0, newArray, 0, insertIndex);
                System.arraycopy(values, insertIndex, newArray, insertIndex + 1, values.length - insertIndex);
                newArray[insertIndex] = value;
                values = newArray;
            }
            return true;
        } else {
            values[index] = value;
        }
        return false;
    }

    @Override
    public boolean remove(double timestamp) {
        final int removeIndex = removeInner(timestamp);
        if (removeIndex >= 0) {
            if (removeIndex != size) {
                System.arraycopy(values, removeIndex + 1, values, removeIndex, size - removeIndex);
            }
            return true;
        }
        return false;
    }

    @Override
    public String get(double timestamp, String defaultValue) {
        final int index = getIndex(timestamp);
        if (index >= 0) {
            return values[index];
        }
        return defaultValue;
    }

    @Override
    public Object get(Interval interval, Estimator estimator) {
        switch (estimator) {
            case FIRST:
                return getFirst(interval);
            case LAST:
                return getLast(interval);
            default:
                throw new IllegalArgumentException("Unknown estimator.");
        }
    }

    @Override
    public String[] toArray() {
        if (size < values.length - 1) {
            final String[] res = new String[size];
            System.arraycopy(values, 0, res, 0, size);
            return res;
        } else {
            return values;
        }
    }

    @Override
    public Class<String> getTypeClass() {
        return String.class;
    }

    @Override
    public void clear() {
        super.clear();
        values = new String[0];
    }

    @Override
    public boolean isSupported(Estimator estimator) {
        return estimator.is(Estimator.FIRST, Estimator.LAST);
    }

    @Override
    protected Object getValue(int index) {
        return values[index];
    }
}
