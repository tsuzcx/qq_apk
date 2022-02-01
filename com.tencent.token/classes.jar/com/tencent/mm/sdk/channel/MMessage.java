package com.tencent.mm.sdk.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class MMessage
{
  public static void send(Context paramContext, String paramString1, String paramString2)
  {
    send(paramContext, paramString1, "com.tencent.mm.sdk.channel.Intent.ACTION_MESSAGE", paramString2);
  }
  
  public static void send(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    send(paramContext, paramString1, paramString2, paramString3, null);
  }
  
  public static boolean send(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".permission.MM_MESSAGE");
    paramString1 = localStringBuilder.toString();
    paramString2 = new Intent(paramString2);
    if (paramBundle != null) {
      paramString2.putExtras(paramBundle);
    }
    paramBundle = paramContext.getPackageName();
    paramString2.putExtra("_mmessage_sdkVersion", 553910273);
    paramString2.putExtra("_mmessage_appPackage", paramBundle);
    paramString2.putExtra("_mmessage_content", paramString3);
    paramString2.putExtra("_mmessage_checksum", MMessageUtil.a(paramString3, paramBundle));
    paramContext.sendBroadcast(paramString2, paramString1);
    paramContext = new StringBuilder("send mm message, intent=");
    paramContext.append(paramString2);
    paramContext.append(", perm=");
    paramContext.append(paramString1);
    Log.d("MicroMsg.SDK.MMessage", paramContext.toString());
    return true;
  }
  
  public static abstract interface CallBack
  {
    public abstract void handleMessage(Intent paramIntent);
  }
  
  public static final class Receiver
    extends BroadcastReceiver
  {
    public static final Map<String, MMessage.CallBack> callbacks = new HashMap();
    private final MMessage.CallBack o;
    
    public Receiver()
    {
      this(null);
    }
    
    public Receiver(MMessage.CallBack paramCallBack)
    {
      this.o = paramCallBack;
    }
    
    public static void registerCallBack(String paramString, MMessage.CallBack paramCallBack)
    {
      callbacks.put(paramString, paramCallBack);
    }
    
    public static void unregisterCallBack(String paramString)
    {
      callbacks.remove(paramString);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = new StringBuilder("receive intent=");
      paramContext.append(paramIntent);
      Log.d("MicroMsg.SDK.MMessage", paramContext.toString());
      paramContext = this.o;
      if (paramContext != null)
      {
        paramContext.handleMessage(paramIntent);
        Log.d("MicroMsg.SDK.MMessage", "mm message self-handled");
        return;
      }
      paramContext = (MMessage.CallBack)callbacks.get(paramIntent.getAction());
      if (paramContext != null)
      {
        paramContext.handleMessage(paramIntent);
        Log.d("MicroMsg.SDK.MMessage", "mm message handled");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessage
 * JD-Core Version:    0.7.0.1
 */