package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import com.tencent.qphone.base.util.QLog;

public class PluginTab
  extends PluginActivity
  implements TabHost.TabContentFactory, TabHost.OnTabChangeListener
{
  private TabHost.OnTabChangeListener mOnTabChangeListener;
  private PluginTabHost mPluginTabHost;
  private String mPreTag;
  
  protected final void addTabSpec(TabHost.TabSpec paramTabSpec, String paramString, Intent paramIntent)
  {
    if (this.mPluginTabHost == null) {
      return;
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginTab addTabSpec:" + paramTabSpec.getTag() + ", " + paramString);
    }
    paramTabSpec.setContent(this);
    this.mPluginTabHost.addPluginInfo(paramTabSpec.getTag(), paramString, paramIntent);
    this.mPluginTabHost.addTab(paramTabSpec);
  }
  
  public View createTabContent(String paramString)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginTab createTabContent:" + paramString);
    }
    PluginTabHost.TabSpecPluginInfo localTabSpecPluginInfo = this.mPluginTabHost.getPluginInfo(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    if (localTabSpecPluginInfo != null) {
      paramString = localObject2;
    }
    try
    {
      localObject1 = getBaseContext().getClassLoader();
      paramString = localObject2;
      IPluginActivity localIPluginActivity = (IPluginActivity)((ClassLoader)localObject1).loadClass(localTabSpecPluginInfo.mActivityName).newInstance();
      paramString = localObject2;
      if (DebugHelper.sDebug)
      {
        paramString = localObject2;
        DebugHelper.log("PluginDebug", "PluginTab Activity:" + localIPluginActivity);
      }
      paramString = localObject2;
      localIPluginActivity.IInit(this.mPluginID, this.mApkFilePath, this, (ClassLoader)localObject1, this.mPackageInfo, this.mUseSkinEngine, this.mUseQqResources);
      paramString = localObject2;
      localIPluginActivity.ISetIsTab();
      paramString = localObject2;
      localIPluginActivity.ISetParent(this);
      paramString = localObject2;
      localIPluginActivity.ISetIntent(getIntent());
      paramString = localObject2;
      localIPluginActivity.IOnSetTheme();
      paramString = localObject2;
      localIPluginActivity.IOnCreate(null);
      paramString = localObject2;
      localObject1 = localIPluginActivity.IGetContentView();
      paramString = (String)localObject1;
      localTabSpecPluginInfo.mActivity = localIPluginActivity;
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("PluginDebug", 1, this.mPluginID + " createTabContent fail", localException);
      PluginRuntime.handleCrash(localException, this.mPluginID, this);
    }
    return paramString;
  }
  
  protected IPluginActivity getActivityByTag(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      paramString = this.mPluginTabHost.getPluginInfo(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.mActivity;
      }
    }
    return localObject1;
  }
  
  protected IPluginActivity getCurrentActivity()
  {
    return getActivityByTag(this.mPluginTabHost.getCurrentTabTag());
  }
  
  public PluginTabHost getTabHost()
  {
    return this.mPluginTabHost;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int j = this.mPluginTabHost.getTabCount();
    int i = 0;
    while (i < j)
    {
      paramConfiguration = this.mPluginTabHost.getTabAt(i);
      if (paramConfiguration != null)
      {
        paramConfiguration = this.mPluginTabHost.getPluginInfo(paramConfiguration.getTag());
        if ((paramConfiguration == null) || (paramConfiguration.mActivity == null)) {}
      }
      i += 1;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int j = this.mPluginTabHost.getTabCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.mPluginTabHost.getTabAt(i);
      if (localObject != null)
      {
        localObject = this.mPluginTabHost.getPluginInfo(((TabHost.TabSpec)localObject).getTag());
        if ((localObject != null) && (((PluginTabHost.TabSpecPluginInfo)localObject).mActivity != null)) {
          ((PluginTabHost.TabSpecPluginInfo)localObject).mActivity.IOnDestroy();
        }
      }
      i += 1;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnPause();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnRestart();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnResume();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStop();
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginTab onTabChanged:" + paramString);
    }
    IPluginActivity localIPluginActivity = getActivityByTag(this.mPreTag);
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnPause();
    }
    this.mPreTag = paramString;
    localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnResume();
    }
    if (this.mOnTabChangeListener != null) {
      this.mOnTabChangeListener.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.mOnTabChangeListener = paramOnTabChangeListener;
  }
  
  protected final void setPluginTabHost(PluginTabHost paramPluginTabHost)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginTab setPluginTabHost:" + paramPluginTabHost);
    }
    this.mPluginTabHost = paramPluginTabHost;
    this.mPluginTabHost.setup();
    this.mPluginTabHost.setOnTabChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginTab
 * JD-Core Version:    0.7.0.1
 */