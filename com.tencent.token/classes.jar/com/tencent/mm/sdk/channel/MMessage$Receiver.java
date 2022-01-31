package com.tencent.mm.sdk.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class MMessage$Receiver
  extends BroadcastReceiver
{
  public static final Map callbacks = new HashMap();
  private final MMessage.CallBack o;
  
  public MMessage$Receiver()
  {
    this(null);
  }
  
  public MMessage$Receiver(MMessage.CallBack paramCallBack)
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
    Log.d("MicroMsg.SDK.MMessage", "receive intent=" + paramIntent);
    if (this.o != null)
    {
      this.o.handleMessage(paramIntent);
      Log.d("MicroMsg.SDK.MMessage", "mm message self-handled");
    }
    do
    {
      return;
      paramContext = (MMessage.CallBack)callbacks.get(paramIntent.getAction());
    } while (paramContext == null);
    paramContext.handleMessage(paramIntent);
    Log.d("MicroMsg.SDK.MMessage", "mm message handled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessage.Receiver
 * JD-Core Version:    0.7.0.1
 */