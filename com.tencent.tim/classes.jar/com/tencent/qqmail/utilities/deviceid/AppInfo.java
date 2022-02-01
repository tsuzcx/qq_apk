package com.tencent.qqmail.utilities.deviceid;

public class AppInfo
{
  public String appName = "";
  public String packageName = "";
  public int versionCode = 0;
  public String versionName = "";
  
  public String toString()
  {
    return "appname:" + this.appName + ",packagename:" + this.packageName + ",versionname:" + this.versionName + ",versioncode:" + this.versionCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.deviceid.AppInfo
 * JD-Core Version:    0.7.0.1
 */