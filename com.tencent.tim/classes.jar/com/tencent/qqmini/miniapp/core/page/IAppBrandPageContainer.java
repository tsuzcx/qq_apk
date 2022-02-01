package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IAppBrandPageContainer
  extends IPage
{
  public abstract void cleanup(boolean paramBoolean);
  
  public abstract View getContentView();
  
  public abstract void launch(String paramString1, String paramString2);
  
  public abstract boolean navigateBack(int paramInt1, int paramInt2);
  
  public abstract void navigateTo(String paramString, int paramInt);
  
  public abstract void onAttachedToActivity(Activity paramActivity);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStop();
  
  public abstract void redirectTo(String paramString, int paramInt);
  
  public abstract void setFromReload(boolean paramBoolean);
  
  public abstract void setMiniAppInfo(MiniAppInfo paramMiniAppInfo);
  
  public abstract void switchTab(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */