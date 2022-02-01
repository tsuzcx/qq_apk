package com.tencent.mm.sdk.channel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class MMessageAct
{
  public static boolean send(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".wxapi.WXEntryActivity");
    return send(paramContext, paramString1, localStringBuilder.toString(), paramString2, null);
  }
  
  public static boolean send(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".wxapi.WXEntryActivity");
    return send(paramContext, paramString1, localStringBuilder.toString(), paramString2, paramBundle);
  }
  
  public static boolean send(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Intent localIntent;
    if ((paramContext != null) && (paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
    {
      localIntent = new Intent();
      localIntent.setClassName(paramString1, paramString2);
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramString1 = paramContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 553910273);
      localIntent.putExtra("_mmessage_appPackage", paramString1);
      localIntent.putExtra("_mmessage_content", paramString3);
      localIntent.putExtra("_mmessage_checksum", MMessageUtil.a(paramString3, paramString1));
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    try
    {
      paramContext.startActivity(localIntent);
      paramContext = new StringBuilder("send mm message, intent=");
      paramContext.append(localIntent);
      Log.d("MicroMsg.SDK.MMessageAct", paramContext.toString());
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      label152:
      break label152;
    }
    for (paramContext = "send fail, target ActivityNotFound";; paramContext = "send fail, invalid arguments")
    {
      Log.e("MicroMsg.SDK.MMessageAct", paramContext);
      return false;
    }
  }
  
  public static boolean sendToWx(Context paramContext, String paramString)
  {
    return send(paramContext, "com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity", paramString, null);
  }
  
  public static boolean sendToWx(Context paramContext, String paramString, Bundle paramBundle)
  {
    return send(paramContext, "com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity", paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessageAct
 * JD-Core Version:    0.7.0.1
 */