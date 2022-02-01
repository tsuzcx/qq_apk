package com.tencent.qqmini.sdk.launcher.shell;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

public abstract interface IShareManager
{
  public abstract void newShareInfoRequest(InnerShareData paramInnerShareData);
  
  public abstract void shareAppMessage(InnerShareData paramInnerShareData);
  
  public abstract void shareAppPictureMessage(IMiniAppContext paramIMiniAppContext, InnerShareData paramInnerShareData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IShareManager
 * JD-Core Version:    0.7.0.1
 */