package com.tencent.wework.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.wework.api.model.BaseMessage;

public final class WWAPIImpl
  implements IWWAPI
{
  private static final String TAG = "WWAPI.WWAPIImpl";
  private Context context;
  
  public WWAPIImpl(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.context = paramContext;
  }
  
  public void detach() {}
  
  public int getWWAppSupportAPI()
  {
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.wework", 128);
      if (localPackageInfo == null) {
        return 0;
      }
      int i = localPackageInfo.versionCode;
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public boolean handleIntent(Intent paramIntent, IWWAPIEventHandler paramIWWAPIEventHandler)
  {
    return false;
  }
  
  public boolean isWWAppInstalled()
  {
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.wework", 128);
      return localPackageInfo != null;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isWWAppSupportAPI()
  {
    return getWWAppSupportAPI() >= 100;
  }
  
  public boolean openWWApp()
  {
    try
    {
      this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework"));
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean registerApp(String paramString)
  {
    return true;
  }
  
  public boolean sendMessage(BaseMessage paramBaseMessage)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setClassName("com.tencent.wework", "com.tencent.wework.apihost.WWAPIActivity");
    localIntent.addFlags(268435456);
    try
    {
      localIntent.putExtras(BaseMessage.pack(paramBaseMessage));
      this.context.startActivity(localIntent);
      return true;
    }
    catch (Throwable paramBaseMessage) {}
    return false;
  }
  
  public void unregisterApp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl
 * JD-Core Version:    0.7.0.1
 */