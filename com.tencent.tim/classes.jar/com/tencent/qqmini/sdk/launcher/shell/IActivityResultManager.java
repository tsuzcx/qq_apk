package com.tencent.qqmini.sdk.launcher.shell;

public abstract interface IActivityResultManager
{
  public abstract void addActivityResultListener(IActivityResultListener paramIActivityResultListener);
  
  public abstract void addRequestPermissionResultListener(IRequestPermissionsResultListener paramIRequestPermissionsResultListener);
  
  public abstract void removeActivityResultListener(IActivityResultListener paramIActivityResultListener);
  
  public abstract void removeRequestPermissionResultListener(IRequestPermissionsResultListener paramIRequestPermissionsResultListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager
 * JD-Core Version:    0.7.0.1
 */