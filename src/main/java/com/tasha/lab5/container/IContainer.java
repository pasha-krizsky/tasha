package com.tasha.lab5.container;

import com.tasha.lab5.data.Element;

/** An interface for all containers */
public interface IContainer {

    /**
     * Add new data to container
     * @param path - path to file with new data
     */
    void importData(String path);

    /**
     * Save current data from container to file
     * @param path - path to file
     */
    void saveData(String path);

    /**
     * Remove first object from container
     */
    void removeFirst();

    /**
     * Remove all objects which are greater than given element
     * @param element - element to compare with
     */
    void removeGreater(Element element);
}
