package com.epam.training;

import java.util.concurrent.locks.ReentrantLock;

public final class Fork extends ReentrantLock {

    /**
     * 
     */
    private static final long serialVersionUID = 1207500220126650233L;
    private final String name;

    public Fork(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
