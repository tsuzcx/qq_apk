package com.tencent.qqmini.sdk.core;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.manager.ApkgLoader;
import com.tencent.qqmini.sdk.core.manager.impl.InternalBaselibLoader;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.util.HashMap;
import java.util.Map;

@MiniKeep
public class MiniAppEnv
  implements IMiniAppEnv
{
  private static final String TAG = "MiniAppEnv";
  protected ApkgLoader mApkgLoader = ApkgLoader.g();
  private Map<String, AuthState> mAuthStateMap = new HashMap();
  protected Context mContext;
  private LoginInfo mLoginInfo = new LoginInfo();
  private String mMenuStyle = "light";
  protected BaselibLoader sBaselibLoader = new InternalBaselibLoader();
  
  public static MiniAppEnv g()
  {
    return (MiniAppEnv)AppLoaderFactory.g().getMiniAppEnv();
  }
  
  public ApkgLoader getApkgLoader()
  {
    return this.mApkgLoader;
  }
  
  public AuthState getAuthSate(String paramString)
  {
    if (this.mAuthStateMap.containsKey(paramString)) {
      return (AuthState)this.mAuthStateMap.get(paramString);
    }
    synchronized (this.mAuthStateMap)
    {
      AuthState localAuthState = (AuthState)this.mAuthStateMap.get(paramString);
      Object localObject = localAuthState;
      if (localAuthState == null)
      {
        localObject = LoginManager.getInstance().getAccount();
        localObject = new AuthState(getContext(), paramString, (String)localObject);
        this.mAuthStateMap.put(paramString, localObject);
      }
      return localObject;
    }
  }
  
  public BaselibLoader getBaselibLoader()
  {
    if (AppLoaderFactory.g().getBaselibLoader() != null) {
      return AppLoaderFactory.g().getBaselibLoader();
    }
    return this.sBaselibLoader;
  }
  
  public Context getContext()
  {
    if (this.mContext == null) {
      throw new RuntimeException("Should call init() first!");
    }
    return this.mContext;
  }
  
  public LoginInfo getLoginInfo()
  {
    return this.mLoginInfo;
  }
  
  public String getMenuStyle()
  {
    return this.mMenuStyle;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setApkgLoader(ApkgLoader paramApkgLoader)
  {
    this.mApkgLoader = paramApkgLoader;
  }
  
  @Deprecated
  public void setBaselibLoader(BaselibLoader paramBaselibLoader)
  {
    this.sBaselibLoader = paramBaselibLoader;
  }
  
  public void setLoginInfo(LoginInfo paramLoginInfo)
  {
    this.mLoginInfo = paramLoginInfo;
  }
  
  public void setMenuStyle(String paramString)
  {
    this.mMenuStyle = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.MiniAppEnv
 * JD-Core Version:    0.7.0.1
 */