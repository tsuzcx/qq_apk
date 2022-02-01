package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;

public abstract interface IAppBrandService
  extends IJsService
{
  public abstract int getStatus();
  
  public abstract void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent);
  
  public abstract void initEmbeddedState(EmbeddedState paramEmbeddedState);
  
  public abstract void setApkgInfo(ApkgInfo paramApkgInfo);
  
  public abstract void setAppBrandEventInterface(ServiceEventListener paramServiceEventListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.IAppBrandService
 * JD-Core Version:    0.7.0.1
 */