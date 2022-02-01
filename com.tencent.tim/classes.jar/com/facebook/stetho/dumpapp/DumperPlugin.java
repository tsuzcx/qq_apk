package com.facebook.stetho.dumpapp;

public abstract interface DumperPlugin
{
  public abstract void dump(DumperContext paramDumperContext)
    throws DumpException;
  
  public abstract String getName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.DumperPlugin
 * JD-Core Version:    0.7.0.1
 */