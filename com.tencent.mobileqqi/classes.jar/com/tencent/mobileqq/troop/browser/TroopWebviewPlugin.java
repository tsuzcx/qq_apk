package com.tencent.mobileqq.troop.browser;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.troop.activity.TroopSearchLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "6.0.3.6604";
  public static final String b = "Troop";
  public static final String c = "searchTroop";
  public static final String d = "showTroopProfile";
  public static final String e = "getBkn";
  public static final String f = "getVersion";
  public static final String g = "isNetworkConnected";
  public static final String h = "openUrl";
  public static final String i = "didModifyGroupTags";
  public static final String j = "openTroopProfileEdit";
  
  public int a()
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof QQBrowserActivity)) {
      return -1;
    }
    localObject = ((QQBrowserActivity)localObject).f();
    if (localObject == null) {
      return -1;
    }
    int m = 5381;
    int k = 0;
    int n = ((String)localObject).length();
    while (k < n)
    {
      m += (m << 5) + Character.codePointAt((CharSequence)localObject, k);
      k += 1;
    }
    return 0x7FFFFFFF & m;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 50	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7: astore_3
    //   8: new 72	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 74	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 76
    //   20: invokevirtual 80	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: ldc 82
    //   28: invokevirtual 86	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   31: istore_2
    //   32: aload 4
    //   34: bipush 13
    //   36: invokestatic 91	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   39: astore_1
    //   40: aload_1
    //   41: ldc 82
    //   43: iload_2
    //   44: invokevirtual 97	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   47: aload_3
    //   48: aload_1
    //   49: invokestatic 100	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   52: iload_2
    //   53: ifeq +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 105	android/app/Activity:finish	()V
    //   60: return
    //   61: astore_1
    //   62: return
    //   63: astore_1
    //   64: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TroopWebviewPlugin
    //   0	65	1	paramString	String
    //   31	22	2	bool	boolean
    //   7	50	3	localActivity	Activity
    //   23	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	61	org/json/JSONException
    //   17	52	63	org/json/JSONException
    //   56	60	63	org/json/JSONException
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Activity localActivity;
      return;
    }
    catch (JSONException paramString)
    {
      try
      {
        paramString = paramString.getString("url");
        if (paramString != null)
        {
          localActivity = this.mRuntime.a();
          TroopQQBrowserHelper.a(localActivity, localActivity.getIntent().getExtras(), paramString);
        }
        return;
      }
      catch (JSONException paramString) {}
      paramString = paramString;
      return;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      try
      {
        paramString = paramString.getString("tags");
        if (!(this.mRuntime.a() instanceof TroopTagViewActivity)) {
          return;
        }
        ((TroopTagViewActivity)this.mRuntime.a()).a(paramString);
        return;
      }
      catch (JSONException paramString) {}
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("Troop")) {
      return false;
    }
    if (paramString3.equals("searchTroop"))
    {
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = new Intent(paramJsBridgeListener, TroopSearchLogicActivity.class);
      paramString1.putExtra("type", 2);
      paramString1.putExtra("key_words", paramVarArgs[0]);
      paramJsBridgeListener.startActivity(paramString1);
    }
    for (;;)
    {
      return true;
      if (paramString3.equals("didModifyGroupTags"))
      {
        c(paramVarArgs[0]);
        paramJsBridgeListener.a(Boolean.valueOf(true));
      }
      else if (paramString3.equals("openTroopProfileEdit"))
      {
        a(paramVarArgs[0]);
      }
      else if (paramString3.equals("showTroopProfile"))
      {
        paramJsBridgeListener = this.mRuntime.a();
        paramString1 = new Intent(paramJsBridgeListener, TroopSearchLogicActivity.class);
        paramString1.putExtra("type", 1);
        paramString1.putExtra("key_words", paramVarArgs[0]);
        paramJsBridgeListener.startActivity(paramString1);
      }
      else if (paramString3.equals("getBkn"))
      {
        paramJsBridgeListener.a(Integer.valueOf(a()));
      }
      else if (paramString3.equals("getVersion"))
      {
        paramJsBridgeListener.a("6.0.3.6604");
      }
      else if (paramString3.equals("isNetworkConnected"))
      {
        paramJsBridgeListener.a(Boolean.valueOf(APNUtil.d(CommonDataAdapter.a().a())));
      }
      else
      {
        if (!paramString3.equals("openUrl")) {
          break;
        }
        b(paramVarArgs[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */