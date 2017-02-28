package com.spd.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Sasha on 27.02.2017.
 */
public class CustomFileFilter implements FilenameFilter {
    private String extension;

    public CustomFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File file, String name) {
        return name.toUpperCase().endsWith("." + extension.toUpperCase());
    }
}
