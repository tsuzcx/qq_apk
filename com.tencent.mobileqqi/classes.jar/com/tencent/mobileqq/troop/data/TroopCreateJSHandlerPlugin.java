package com.tencent.mobileqq.troop.data;

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
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateJSHandlerPlugin
  extends WebViewPlugin
{
  private static final String a = "Troop";
  
  private void a()
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateBaseActivity)) {
      return;
    }
    ((TroopCreateBaseActivity)localActivity).q();
  }
  
  private void b()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof TroopCreateActivity)) {
      ((TroopCreateActivity)localActivity).finish();
    }
  }
  
  private void b(String paramString)
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
        String str2 = TroopCreateUtils.a(paramString, "wording", "");
        String str3 = TroopCreateUtils.a(paramString, "callback", "");
        boolean bool1 = TroopCreateUtils.a(paramString, "show", true);
        boolean bool2 = TroopCreateUtils.a(paramString, "disabled", false);
        ((QQBrowserActivity)localObject).a(str1, str2, bool1, TroopCreateUtils.a(paramString, "showImg", true), bool2, str3);
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
  
  private void c(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof TroopCreateMapViewSupportActivity)) {
      return;
    }
    localObject = (TroopCreateMapViewSupportActivity)localObject;
    try
    {
      paramString = new JSONObject(paramString);
      ((TroopCreateMapViewSupportActivity)localObject).a(paramString.getBoolean("show"), TroopCreateUtils.a(paramString, "justUpdateLocation", false), TroopCreateUtils.a(paramString, "callback", ""));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof TroopCreateBaseActivity)) {
      return;
    }
    localObject = (TroopCreateBaseActivity)localObject;
    try
    {
      paramString = new JSONObject(paramString);
      ((TroopCreateBaseActivity)localObject).c(TroopCreateUtils.a(paramString, "title", ""), TroopCreateUtils.a(paramString, "wording", ""), TroopCreateUtils.a(paramString, "callback", ""));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateActivity)) {
      return;
    }
    ((TroopCreateActivity)localActivity).a(paramString);
  }
  
  private void f(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void g(String paramString)
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
        localIntent.putExtra("param_title", this.mRuntime.a().getString(2131562252));
        localIntent.putExtra("param_done_button_wording", this.mRuntime.a().getString(2131562539));
        localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.a().getString(2131562550));
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_exit_animation", 1);
        localIntent.putExtra("param_max", 10);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(2130968591, 2130968592);
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
  
  private void h(String paramString)
  {
    int i = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = TroopCreateUtils.a(localJSONObject, "troopUin", "");
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONObject localJSONObject;
          boolean bool = TroopCreateUtils.a(localJSONObject, "closeCurPage", false);
          i = bool;
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = TroopInfoActivity.a(paramString, 9);
            paramString.putString("troop_info_title", localActivity.getString(2131560415));
            TroopInfoActivity.a(localActivity, paramString, 5);
          }
          if (i == 0) {
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
  
  private void i(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopLocationModifyActivity)) {
      return;
    }
    try
    {
      paramString = TroopCreateUtils.a(new JSONObject(paramString), "location", "");
      ((TroopLocationModifyActivity)localActivity).a(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void j(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateMapViewSupportActivity)) {
      return;
    }
    try
    {
      paramString = TroopCreateUtils.a(new JSONObject(paramString), "callback", "");
      ((TroopCreateMapViewSupportActivity)localActivity).d(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void k(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (!(localActivity instanceof TroopCreateMapViewSupportActivity)) {
      return;
    }
    try
    {
      boolean bool = TroopCreateUtils.a(new JSONObject(paramString), "show", false);
      ((TroopCreateMapViewSupportActivity)localActivity).b(bool);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
        break label53;
      }
      bool1 = false;
      continue;
      label53:
      paramString.printStackTrace();
      bool2 = false;
    }
    paramString = (TroopCreateActivity)paramString;
    localIntent = new Intent(paramString, TroopCreateAvatarActivity.class);
    localIntent.putExtra("isShowCommit", bool1);
    localIntent.putExtra("isAstrict", bool2);
    paramString.startActivityForResult(localIntent, 43);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("Troop")) {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    if (paramString3.equals("setTitleButton")) {
      b(paramVarArgs[0]);
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
        c(paramVarArgs[0]);
      }
      else if (paramString3.equals("showCreateTroopMsgBox"))
      {
        d(paramVarArgs[0]);
      }
      else if (paramString3.equals("commitGroupInfo"))
      {
        e(paramVarArgs[0]);
      }
      else if (paramString3.equals("shareGroup"))
      {
        f(paramVarArgs[0]);
      }
      else if (paramString3.equals("inviteMemberToGroup"))
      {
        g(paramVarArgs[0]);
      }
      else if (paramString3.equals("enterGroupInfoCard"))
      {
        h(paramVarArgs[0]);
      }
      else if (paramString3.equals("modifyTroopLocation"))
      {
        i(paramVarArgs[0]);
      }
      else if (paramString3.equals("finishCreateGroup"))
      {
        b();
      }
      else if (paramString3.equals("displayMapView"))
      {
        k(paramVarArgs[0]);
      }
      else if (paramString3.equals("getMapViewHeight"))
      {
        j(paramVarArgs[0]);
      }
      else
      {
        if (!paramString3.equals("showGroupHeadEditView")) {
          break;
        }
        a(paramVarArgs[0]);
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateJSHandlerPlugin
 * JD-Core Version:    0.7.0.1
 */