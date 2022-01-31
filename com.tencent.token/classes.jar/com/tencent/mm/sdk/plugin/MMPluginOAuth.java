package com.tencent.mm.sdk.plugin;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPluginOAuth
{
  private final MMPluginOAuth.IResult bG;
  private String bH;
  private String bI;
  private Handler handler;
  private final Context q;
  
  public MMPluginOAuth(Context paramContext, MMPluginOAuth.IResult paramIResult)
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
    Log.i("MicroMsg.SDK.MMPluginOAuth", "request token = " + this.bI);
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
    if (this.q.getPackageManager().resolveActivity(paramHandler, 65536) == null) {
      Log.e("MicroMsg.SDK.MMPluginOAuth", "show oauth page failed, activity not found");
    }
    for (int i = 0; i != 0; i = 1)
    {
      MMPluginOAuth.Receiver.register(this.bI, this);
      return true;
      if (!(this.q instanceof Activity)) {
        paramHandler.setFlags(268435456);
      }
      this.q.startActivity(paramHandler);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth
 * JD-Core Version:    0.7.0.1
 */