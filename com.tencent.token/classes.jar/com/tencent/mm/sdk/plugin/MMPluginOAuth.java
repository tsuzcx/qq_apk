package com.tencent.mm.sdk.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class MMPluginOAuth
{
  private final IResult bG;
  private String bH;
  private String bI;
  private Handler handler;
  private final Context q;
  
  public MMPluginOAuth(Context paramContext, IResult paramIResult)
  {
    this.q = paramContext;
    this.bG = paramIResult;
  }
  
  public String getAccessToken()
  {
    return this.bH;
  }
  
  public String getRequestToken()
  {
    return this.bI;
  }
  
  public void start()
  {
    start(null);
  }
  
  public boolean start(Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler();
    }
    this.handler = localHandler;
    paramHandler = this.q.getContentResolver().query(MMPluginProviderConstants.OAuth.CONTENT_URI, null, null, new String[] { this.q.getPackageName(), "request_token" }, null);
    if (paramHandler != null)
    {
      if ((paramHandler.moveToFirst()) && (paramHandler.getColumnCount() >= 2))
      {
        this.bI = paramHandler.getString(0);
        this.bH = paramHandler.getString(1);
      }
      paramHandler.close();
    }
    paramHandler = new StringBuilder("request token = ");
    paramHandler.append(this.bI);
    Log.i("MicroMsg.SDK.MMPluginOAuth", paramHandler.toString());
    if (this.bI == null)
    {
      Log.e("MicroMsg.SDK.MMPluginOAuth", "request token failed");
      return false;
    }
    if (this.bH != null)
    {
      this.handler.post(new MMPluginOAuth.1(this));
      return true;
    }
    Log.d("MicroMsg.SDK.MMPluginOAuth", "begin to show user oauth page");
    paramHandler = new Intent();
    paramHandler.setClassName("com.tencent.mm", "com.tencent.mm.plugin.PluginOAuthUI");
    paramHandler.putExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN", this.bI);
    paramHandler.putExtra("com.tencent.mm.sdk.plugin.Intent.PACKAGE", this.q.getPackageName());
    int i;
    if (this.q.getPackageManager().resolveActivity(paramHandler, 65536) == null)
    {
      Log.e("MicroMsg.SDK.MMPluginOAuth", "show oauth page failed, activity not found");
      i = 0;
    }
    else
    {
      if (!(this.q instanceof Activity)) {
        paramHandler.setFlags(268435456);
      }
      this.q.startActivity(paramHandler);
      i = 1;
    }
    if (i != 0)
    {
      Receiver.register(this.bI, this);
      return true;
    }
    return false;
  }
  
  public static abstract interface IResult
  {
    public abstract void onResult(MMPluginOAuth paramMMPluginOAuth);
    
    public abstract void onSessionTimeOut();
  }
  
  public static class Receiver
    extends BroadcastReceiver
  {
    private static final Map<String, MMPluginOAuth> ah = new HashMap();
    private final MMPluginOAuth bK;
    
    public Receiver()
    {
      this(null);
    }
    
    public Receiver(MMPluginOAuth paramMMPluginOAuth)
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
      paramContext = this.bK;
      if (paramContext == null)
      {
        paramContext = (MMPluginOAuth)ah.get(str);
        if (paramContext == null)
        {
          paramContext = new StringBuilder("oauth unregistered, request token = ");
          paramContext.append(str);
          Log.e("MicroMsg.SDK.MMPluginOAuth", paramContext.toString());
          return;
        }
        unregister(MMPluginOAuth.a(paramContext));
      }
      new Handler().post(new MMPluginOAuth.Receiver.1(this, paramContext, paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth
 * JD-Core Version:    0.7.0.1
 */