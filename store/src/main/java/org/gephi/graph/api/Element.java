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
package org.gephi.graph.api;

import java.util.Set;

/**
 * An element is a node or an edge.
 */
public interface Element extends ElementProperties {

    /**
     * Returns the identifier.
     *
     * @return identifier
     */
    public Object getId();

    /**
     * Returns the label.
     *
     * @return label
     */
    public String getLabel();

    /**
     * Gets the attribute for the given key.
     *
     * @param key column's key
     * @return attribute value, or null
     */
    public Object getAttribute(String key);

    /**
     * Gets the attribute for the given column.
     *
     * @param column column
     * @return attribute value, or null
     */
    public Object getAttribute(Column column);

    /**
     * Gets the attribute for the given key and timestamp.
     *
     * @param key column's key
     * @param timestamp timestamp
     * @return attribute value, or null
     */
    public Object getAttribute(String key, double timestamp);

    /**
     * Gets the attribute for the given column and timestamp.
     *
     * @param column column
     * @param timestamp timestamp
     * @return attribute value, or null
     */
    public Object getAttribute(Column column, double timestamp);

    /**
     * Gets the attribute for the given key and graph view.
     *
     * @param key column's key
     * @param view graph view
     * @return attribute value, or null
     */
    public Object getAttribute(String key, GraphView view);

    /**
     * Gets the attribute for the given column and graph view.
     *
     * @param column column
     * @param view graph view
     * @return attribute value, or null
     */
    public Object getAttribute(Column column, GraphView view);

    /**
     * Returns all the attribute values in an array.
     * <p>
     * Some attribute values may be null.
     *
     * @return attribute values array
     */
    public Object[] getAttributes();

    /**
     * Returns the column identifier keys.
     *
     * @return attribute keys
     */
    public Set<String> getAttributeKeys();

    /**
     * Returns the columns.
     *
     * @return attribute columns
     */
    public ColumnIterable getAttributeColumns();

    /**
     * Returns the location of this element in the store.
     *
     * @return store id
     */
    public int getStoreId();

    /**
     * Removes the attribute at the given key.
     *
     * @param key key
     * @return value being removed, or null
     */
    public Object removeAttribute(String key);

    /**
     * Removes the attribute at the given column.
     *
     * @param column column
     * @return value being removed, or null
     */
    public Object removeAttribute(Column column);

    /**
     * Removes the attribute at the given key and timestamp.
     *
     * @param key key
     * @param timestamp double timestamp
     * @return value being removed, or null
     */
    public Object removeAttribute(String key, double timestamp);

    /**
     * Removes the attribute at the given column and timestamp.
     *
     * @param column column
     * @param timestamp timestamp
     * @return value being removed, or null
     */
    public Object removeAttribute(Column column, double timestamp);

    /**
     * Sets the label.
     *
     * @param label label
     */
    public void setLabel(String label);

    /**
     * Sets the attribute with the given key and value.
     *
     * @param key column's key
     * @param value value to set
     */
    public void setAttribute(String key, Object value);

    /**
     * Sets the attribute with the given column and value.
     *
     * @param column column
     * @param value value to set
     */
    public void setAttribute(Column column, Object value);

    /**
     * Sets the attribute at the given key and timestamp.
     *
     * @param key column's key
     * @param value value to set
     * @param timestamp timestamp
     */
    public void setAttribute(String key, Object value, double timestamp);

    /**
     * Sets the attribute at the given column and timestamp.
     *
     * @param column column
     * @param value value to set
     * @param timestamp timestamp
     */
    public void setAttribute(Column column, Object value, double timestamp);

    /**
     * Adds a timestamp.
     *
     * @param timestamp timestamp to add
     * @return true if the timestamp has been added, false if it existed already
     */
    public boolean addTimestamp(double timestamp);

    /**
     * Removes a timestamp.
     *
     * @param timestamp timestamp to remove
     * @return true if the timestamp has been removed, false if it didn't exist
     */
    public boolean removeTimestamp(double timestamp);

    /**
     * Returns true if this element has the given timestamp.
     *
     * @param timestamp timestamp
     * @return true if this element has the timestamp, false otherwise
     */
    public boolean hasTimestamp(double timestamp);

    /**
     * Returns all the timestamps this element belong to.
     *
     * @return timestamp array
     */
    public double[] getTimestamps();

    /**
     * Clears all attribute values.
     */
    public void clearAttributes();
}
