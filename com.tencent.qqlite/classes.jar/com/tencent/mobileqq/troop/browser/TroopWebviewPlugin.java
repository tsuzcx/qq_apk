package com.tencent.mobileqq.troop.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopSearchLogicActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "3.5.0.660";
  public static final String b = "Troop";
  public static final String c = "searchTroop";
  public static final String d = "showTroopProfile";
  public static final String e = "getBkn";
  public static final String f = "getVersion";
  public static final String g = "isNetworkConnected";
  public static final String h = "openUrl";
  public static final String i = "didModifyGroupTags";
  public static final String j = "openTroopProfileEdit";
  public static final String k = "setWebDataCache";
  public static final String l = "getWebDataCache";
  
  private String a()
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateActivity)) {
      return "";
    }
    return ((TroopCreateActivity)localActivity).f();
  }
  
  private void a()
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateBaseActivity)) {
      return;
    }
    ((TroopCreateBaseActivity)localActivity).x();
  }
  
  private void b()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof TroopCreateActivity)) {
      ((TroopCreateActivity)localActivity).finish();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof QQBrowserActivity)) {}
    for (;;)
    {
      return;
      localObject = (QQBrowserActivity)localObject;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("type");
        String str2 = paramString.optString("wording", "");
        paramString.optString("callback", "");
        boolean bool1 = paramString.optBoolean("show", true);
        boolean bool2 = paramString.optBoolean("disabled", false);
        ((QQBrowserActivity)localObject).a(str1, str2, bool1, paramString.optBoolean("showImg", true), bool2, null);
        if (QLog.isColorLevel())
        {
          QLog.d("CreateTroop-SetTitleButton", 2, "wording: " + str2 + " show: " + bool1);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void e(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof TroopCreateMapViewSupportActivity)) {
      return;
    }
    localObject = (TroopCreateMapViewSupportActivity)localObject;
    try
    {
      paramString = new JSONObject(paramString);
      ((TroopCreateMapViewSupportActivity)localObject).a(paramString.getBoolean("show"), paramString.optBoolean("justUpdateLocation", false), paramString.optString("callback", ""));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void f(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof TroopCreateBaseActivity)) {
      return;
    }
    localObject = (TroopCreateBaseActivity)localObject;
    try
    {
      paramString = new JSONObject(paramString);
      ((TroopCreateBaseActivity)localObject).c(paramString.optString("title", ""), paramString.optString("wording", ""), paramString.optString("callback", ""));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void g(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateActivity)) {
      return;
    }
    ((TroopCreateActivity)localActivity).a(paramString);
  }
  
  private void h(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void i(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      Intent localIntent = null;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localIntent = new Intent(localActivity, SelectMemberActivity.class);
        localIntent.putExtra("param_groupcode", paramString);
        localIntent.putExtra("param_type", 1);
        localIntent.putExtra("param_subtype", 0);
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_title", this.mRuntime.a().getString(2131363103));
        localIntent.putExtra("param_done_button_wording", this.mRuntime.a().getString(2131362802));
        localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.a().getString(2131363561));
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_exit_animation", 1);
        localIntent.putExtra("param_max", 10);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(2130968585, 2130968586);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localIntent;
        }
      }
    }
  }
  
  private void j(String paramString)
  {
    int m = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("troopUin", "");
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONObject localJSONObject;
          boolean bool = localJSONObject.optBoolean("closeCurPage", false);
          m = bool;
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = TroopInfoActivity.a(paramString, 9);
            paramString.putString("troop_info_title", localActivity.getString(2131362324));
            TroopInfoActivity.a(localActivity, paramString, 5);
          }
          if (m == 0) {
            break;
          }
          localActivity.finish();
          return;
        }
        catch (JSONException localJSONException2)
        {
          break label97;
        }
        localJSONException1 = localJSONException1;
        paramString = "";
      }
      label97:
      localJSONException1.printStackTrace();
    }
  }
  
  private void k(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopLocationModifyActivity)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("location", "");
      ((TroopLocationModifyActivity)localActivity).a(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void l(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateMapViewSupportActivity)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("callback", "");
      ((TroopCreateMapViewSupportActivity)localActivity).e(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void m(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateMapViewSupportActivity)) {
      return;
    }
    try
    {
      boolean bool = new JSONObject(paramString).optBoolean("show", false);
      ((TroopCreateMapViewSupportActivity)localActivity).b(bool);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void n(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateActivity)) {
      return;
    }
    ((TroopCreateActivity)localActivity).b(paramString);
  }
  
  public int a()
  {
    return -1;
  }
  
  public void a(String paramString)
  {
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        bool1 = paramString.getBoolean("show");
        if (!bool1) {
          bool1 = true;
        }
      }
      catch (JSONException paramString)
      {
        bool1 = false;
      }
      try
      {
        bool2 = paramString.getBoolean("astrict");
        paramString = this.mRuntime.a();
        if ((paramString instanceof TroopCreateActivity)) {
          break;
        }
        return;
      }
      catch (JSONException paramString)
      {
        Intent localIntent;
        break label54;
      }
      bool1 = false;
      continue;
      label54:
      paramString.printStackTrace();
      bool2 = false;
    }
    paramString = (TroopCreateActivity)paramString;
    localIntent = new Intent(paramString, TroopCreateAvatarActivity.class);
    localIntent.putExtra("isShowCommit", bool1);
    localIntent.putExtra("isAstrict", bool2);
    paramString.startActivityForResult(localIntent, 43);
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 56	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7: astore_3
    //   8: new 77	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 79	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc_w 269
    //   21: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: ldc_w 271
    //   30: invokevirtual 143	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   33: istore_2
    //   34: aload 4
    //   36: bipush 13
    //   38: invokestatic 227	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   41: astore_1
    //   42: aload_1
    //   43: ldc_w 271
    //   46: iload_2
    //   47: invokevirtual 275	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 278	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   55: iload_2
    //   56: ifeq +7 -> 63
    //   59: aload_3
    //   60: invokevirtual 240	android/app/Activity:finish	()V
    //   63: return
    //   64: astore_1
    //   65: return
    //   66: astore_1
    //   67: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	TroopWebviewPlugin
    //   0	68	1	paramString	String
    //   33	23	2	bool	boolean
    //   7	53	3	localActivity	Activity
    //   24	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	64	org/json/JSONException
    //   17	55	66	org/json/JSONException
    //   59	63	66	org/json/JSONException
  }
  
  public void c(String paramString)
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("Troop")) {
      return false;
    }
    if (paramString3.equals("setTitleButton")) {
      d(paramVarArgs[0]);
    }
    for (;;)
    {
      return true;
      if (paramString3.equals("showSoftKeyboard"))
      {
        a();
      }
      else if (paramString3.equals("setLocationMap"))
      {
        e(paramVarArgs[0]);
      }
      else if (paramString3.equals("showCreateTroopMsgBox"))
      {
        f(paramVarArgs[0]);
      }
      else if (paramString3.equals("commitGroupInfo"))
      {
        g(paramVarArgs[0]);
      }
      else if (paramString3.equals("shareGroup"))
      {
        h(paramVarArgs[0]);
      }
      else if (paramString3.equals("inviteMemberToGroup"))
      {
        i(paramVarArgs[0]);
      }
      else if (paramString3.equals("enterGroupInfoCard"))
      {
        j(paramVarArgs[0]);
      }
      else if (paramString3.equals("modifyTroopLocation"))
      {
        k(paramVarArgs[0]);
      }
      else if (paramString3.equals("finishCreateGroup"))
      {
        b();
      }
      else if (paramString3.equals("displayMapView"))
      {
        m(paramVarArgs[0]);
      }
      else if (paramString3.equals("getMapViewHeight"))
      {
        l(paramVarArgs[0]);
      }
      else if (paramString3.equals("showGroupHeadEditView"))
      {
        a(paramVarArgs[0]);
      }
      else if (paramString3.equals("searchTroop"))
      {
        paramJsBridgeListener = this.mRuntime.a();
        paramString1 = new Intent(paramJsBridgeListener, TroopSearchLogicActivity.class);
        paramString1.putExtra("type", 2);
        paramString1.putExtra("key_words", paramVarArgs[0]);
        paramJsBridgeListener.startActivity(paramString1);
      }
      else if (!paramString3.equals("didModifyGroupTags"))
      {
        if (paramString3.equals("openTroopProfileEdit"))
        {
          b(paramVarArgs[0]);
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
          paramJsBridgeListener.a("3.5.0.660");
        }
        else if (paramString3.equals("isNetworkConnected"))
        {
          paramJsBridgeListener.a(Boolean.valueOf(APNUtil.d(CommonDataAdapter.a().a())));
        }
        else if (paramString3.equals("openUrl"))
        {
          c(paramVarArgs[0]);
        }
        else if (paramString3.equals("setWebDataCache"))
        {
          n(paramVarArgs[0]);
        }
        else
        {
          if (!paramString3.equals("getWebDataCache")) {
            break;
          }
          paramJsBridgeListener.a(a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */