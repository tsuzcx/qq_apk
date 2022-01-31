package com.tencent.mobileqq.pluginsdk;

public class IPluginAdapterProxy
{
  static IPluginAdapterProxy sProxy;
  private IPluginAdapter mPluginAdapter;
  
  private IPluginAdapterProxy(IPluginAdapter paramIPluginAdapter)
  {
    this.mPluginAdapter = paramIPluginAdapter;
  }
  
  public static IPluginAdapterProxy getProxy()
  {
    return sProxy;
  }
  
  public static void setProxy(IPluginAdapter paramIPluginAdapter)
  {
    sProxy = new IPluginAdapterProxy(paramIPluginAdapter);
  }
  
  public boolean isNightMode()
  {
    IPluginAdapter localIPluginAdapter = this.mPluginAdapter;
    if (localIPluginAdapter == null) {
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(1, null)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy
 * JD-Core Version:    0.7.0.1
 */