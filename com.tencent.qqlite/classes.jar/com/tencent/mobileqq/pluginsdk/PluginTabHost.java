package com.tencent.mobileqq.pluginsdk;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PluginTabHost
  extends TabHost
{
  private final Map<String, TabSpecPluginInfo> mPluginInfos = new HashMap();
  private final List<TabSpecWrapper> mTabSpecs = new ArrayList();
  
  public PluginTabHost(Context paramContext)
  {
    super(paramContext);
  }
  
  public PluginTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  void addPluginInfo(String paramString1, String paramString2, Intent paramIntent)
  {
    paramString2 = new TabSpecPluginInfo(paramString1, paramString2, paramIntent);
    this.mPluginInfos.put(paramString1, paramString2);
  }
  
  public void addTab(TabHost.TabSpec paramTabSpec)
  {
    super.addTab(paramTabSpec);
    if (paramTabSpec != null) {
      this.mTabSpecs.add(new TabSpecWrapper(paramTabSpec.getTag(), paramTabSpec));
    }
  }
  
  public void clearAllTabs()
  {
    super.clearAllTabs();
    this.mTabSpecs.clear();
    this.mPluginInfos.clear();
  }
  
  public TabSpecPluginInfo getPluginInfo(String paramString)
  {
    return (TabSpecPluginInfo)this.mPluginInfos.get(paramString);
  }
  
  public TabHost.TabSpec getTabAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mTabSpecs.size())) {
      return null;
    }
    return ((TabSpecWrapper)this.mTabSpecs.get(paramInt)).mTabSpec;
  }
  
  public int getTabCount()
  {
    return this.mTabSpecs.size();
  }
  
  public void setup(LocalActivityManager paramLocalActivityManager) {}
  
  protected static class TabSpecPluginInfo
  {
    public IPluginActivity mActivity;
    public String mActivityName;
    public Intent mIntent;
    public String mTag;
    
    protected TabSpecPluginInfo(String paramString1, String paramString2, Intent paramIntent)
    {
      this.mTag = paramString1;
      this.mIntent = paramIntent;
      this.mActivityName = paramString2;
    }
  }
  
  static class TabSpecWrapper
  {
    public TabHost.TabSpec mTabSpec;
    public String mTag;
    
    TabSpecWrapper(String paramString, TabHost.TabSpec paramTabSpec)
    {
      this.mTag = paramString;
      this.mTabSpec = paramTabSpec;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginTabHost
 * JD-Core Version:    0.7.0.1
 */