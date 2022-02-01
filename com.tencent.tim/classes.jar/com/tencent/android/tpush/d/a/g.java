package com.tencent.android.tpush.d.a;

import alld;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import org.json.JSONObject;

public class g
  extends c
{
  private String a = null;
  private String b = null;
  private Context c;
  
  public g(Context paramContext)
  {
    this.c = paramContext;
    TLogger.dd("OtherPushXgSysImpl", "OtherPushXgSysImpl");
  }
  
  private void f(Context paramContext)
  {
    JSONObject localJSONObject;
    if (this.b == null)
    {
      this.b = "";
      localJSONObject = g(paramContext);
      if (localJSONObject != null)
      {
        if (!localJSONObject.optString("xg_sys_pkg", "").equals(paramContext.getPackageName())) {
          break label49;
        }
        TLogger.ii("OtherPushXgSysImpl", "Run in sys app, set pushinfo empty");
      }
    }
    return;
    label49:
    this.b = localJSONObject.optString("xg_sys_pushinfo", "");
  }
  
  private JSONObject g(Context paramContext)
  {
    try
    {
      Uri localUri = Uri.parse("content://com.tencent.tpns.syspush.auth");
      paramContext = paramContext.getContentResolver().getType(localUri);
      TLogger.ii("OtherPushXgSysImpl", "sysPushInfo:" + paramContext);
      if (paramContext != null)
      {
        paramContext = new JSONObject(paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.ii("OtherPushXgSysImpl", "get sysPushInfo get throwable");
    }
    return null;
  }
  
  public String a()
  {
    f(this.c);
    return this.b;
  }
  
  public void a(Context paramContext)
  {
    this.a = null;
    PushPreferences.putString(paramContext, "xg_sys_token", "");
    try
    {
      Object localObject = Uri.parse("content://com.tencent.tpns.syspush.auth/register");
      String str = Long.toString(XGApiConfig.getAccessId(paramContext));
      localObject = alld.query(paramContext.getContentResolver(), (Uri)localObject, null, str, null, null);
      if (localObject != null)
      {
        ((Cursor)localObject).moveToFirst();
        this.a = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("xg_sys_token"));
        PushPreferences.putString(paramContext, "xg_sys_token", this.a);
        ((Cursor)localObject).close();
      }
      TLogger.ii("OtherPushXgSysImpl", "registerPush ret otherToken:" + this.a);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("OtherPushXgSysImpl", "registerPush throwable:", paramContext);
    }
  }
  
  public void b(Context paramContext)
  {
    try
    {
      Object localObject = Uri.parse("content://com.tencent.tpns.syspush.auth/unregister");
      String str = Long.toString(XGApiConfig.getAccessId(paramContext));
      localObject = alld.query(paramContext.getContentResolver(), (Uri)localObject, null, str, null, null);
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TLogger.ee("OtherPushXgSysImpl", "unregisterPush throwable:", localThrowable);
      }
    }
    this.a = null;
    PushPreferences.putString(paramContext, "xg_sys_token", "");
  }
  
  public String c(Context paramContext)
  {
    if (i.b(this.a)) {
      this.a = PushPreferences.getString(paramContext, "xg_sys_token", "");
    }
    return this.a;
  }
  
  public boolean d(Context paramContext)
  {
    f(paramContext);
    if (!i.b(this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      TLogger.dd("OtherPushXgSysImpl", "isConfig: " + bool);
      return bool;
    }
  }
  
  public int e(Context paramContext)
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.g
 * JD-Core Version:    0.7.0.1
 */