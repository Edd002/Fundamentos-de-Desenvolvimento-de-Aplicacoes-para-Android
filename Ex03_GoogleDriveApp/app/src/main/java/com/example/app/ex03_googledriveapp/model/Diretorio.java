package com.example.app.ex03_googledriveapp.model;

public class Diretorio {

    private String dirName;
    private String dirModDescription;
    boolean isDir;

    public Diretorio() {
    }

    public Diretorio(String dirName, String dirModDescription, boolean isDir) {
        this.dirName = dirName;
        this.dirModDescription = dirModDescription;
        this.isDir = isDir;
    }

    public String getDirName() {
        return dirName;
    }
    public void setDirName(String dirName) {
        this.dirName = dirName;
    }
    public String getDirModDescription() {
        return dirModDescription;
    }
    public void setDirModDescription(String dirModDescription) {
        this.dirModDescription = dirModDescription;
    }
    public boolean isDir() {
        return isDir;
    }
    public void setDir(boolean dir) {
        isDir = dir;
    }
}
