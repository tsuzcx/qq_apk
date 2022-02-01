package com.facebook.stetho;

import com.facebook.stetho.dumpapp.DumperPlugin;

public abstract interface DumperPluginsProvider
{
  public abstract Iterable<DumperPlugin> get();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.DumperPluginsProvider
 * JD-Core Version:    0.7.0.1
 */