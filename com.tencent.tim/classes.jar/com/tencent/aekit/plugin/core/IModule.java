package com.tencent.aekit.plugin.core;

public abstract interface IModule
{
  public abstract String getModuleName();
  
  public abstract String getModuleType();
  
  public abstract boolean onModuleInstall(String paramString1, String paramString2);
  
  public abstract void onModuleUninstall();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.IModule
 * JD-Core Version:    0.7.0.1
 */