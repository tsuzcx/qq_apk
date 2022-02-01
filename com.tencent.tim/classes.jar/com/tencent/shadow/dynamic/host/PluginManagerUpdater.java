package com.tencent.shadow.dynamic.host;

import java.io.File;
import java.util.concurrent.Future;

public abstract interface PluginManagerUpdater
{
  public abstract File getLatest();
  
  public abstract Future isAvailable(File paramFile);
  
  public abstract Future update();
  
  public abstract boolean wasUpdating();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PluginManagerUpdater
 * JD-Core Version:    0.7.0.1
 */