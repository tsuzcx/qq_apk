package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;

public abstract class WnsConfigProxy
{
  public abstract List<String> getApiReportConfig();
  
  public abstract String getConfig(String paramString1, String paramString2);
  
  public void loadConfigFromServer() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
 * JD-Core Version:    0.7.0.1
 */