package com.tencent.mm.sdk.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.token.qk;
import com.tencent.token.qt;
import java.util.HashMap;
import java.util.Map;

public final class MMPluginOAuth
{
  public String a;
  public String b;
  
  public static class Receiver
    extends BroadcastReceiver
  {
    private static final Map<String, MMPluginOAuth> a = new HashMap();
    private final MMPluginOAuth b = null;
    
    public Receiver()
    {
      this((byte)0);
    }
    
    private Receiver(byte paramByte) {}
    
    public static void a(String paramString)
    {
      a.remove(paramString);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      qk.c("MicroMsg.SDK.MMPluginOAuth", "receive oauth result");
      String str = paramIntent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN");
      paramIntent = paramIntent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN");
      paramContext = this.b;
      if (paramContext == null)
      {
        paramContext = (MMPluginOAuth)a.get(str);
        if (paramContext == null)
        {
          qk.a("MicroMsg.SDK.MMPluginOAuth", "oauth unregistered, request token = ".concat(String.valueOf(str)));
          return;
        }
        a(paramContext.b);
      }
      new Handler().post(new qt(this, paramContext, paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth
 * JD-Core Version:    0.7.0.1
 */