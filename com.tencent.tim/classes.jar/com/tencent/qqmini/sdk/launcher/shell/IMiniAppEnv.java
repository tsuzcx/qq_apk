package com.tencent.qqmini.sdk.launcher.shell;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;

public abstract interface IMiniAppEnv
{
  public abstract BaselibLoader getBaselibLoader();
  
  public abstract Context getContext();
  
  public abstract LoginInfo getLoginInfo();
  
  public abstract String getMenuStyle();
  
  public abstract void init(Context paramContext);
  
  public abstract void setLoginInfo(LoginInfo paramLoginInfo);
  
  public abstract void setMenuStyle(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
 * JD-Core Version:    0.7.0.1
 */