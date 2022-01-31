package com.tencent.mm.sdk.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class MMPluginOAuth$Receiver
  extends BroadcastReceiver
{
  private static final Map ah = new HashMap();
  private final MMPluginOAuth bK;
  
  public MMPluginOAuth$Receiver()
  {
    this(null);
  }
  
  public MMPluginOAuth$Receiver(MMPluginOAuth paramMMPluginOAuth)
  {
    this.bK = paramMMPluginOAuth;
  }
  
  public static void register(String paramString, MMPluginOAuth paramMMPluginOAuth)
  {
    ah.put(paramString, paramMMPluginOAuth);
  }
  
  public static void unregister(String paramString)
  {
    ah.remove(paramString);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("MicroMsg.SDK.MMPluginOAuth", "receive oauth result");
    String str = paramIntent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN");
    paramIntent = paramIntent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN");
    if (this.bK != null) {
      paramContext = this.bK;
    }
    for (;;)
    {
      new Handler().post(new MMPluginOAuth.Receiver.1(this, paramContext, paramIntent));
      return;
      paramContext = (MMPluginOAuth)ah.get(str);
      if (paramContext == null)
      {
        Log.e("MicroMsg.SDK.MMPluginOAuth", "oauth unregistered, request token = " + str);
        return;
      }
      unregister(MMPluginOAuth.a(paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth.Receiver
 * JD-Core Version:    0.7.0.1
 */