package com.tencent.biz.webviewplugin;

import affz;
import afjy;
import ahvn;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.gameparty.PromptDialogActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ssu;

public class GamePartyPlugin
  extends WebViewPlugin
{
  private GamePartyBroadcastReceiver a;
  private Client.b remoteRespObserver = new ssu(this);
  
  public GamePartyPlugin()
  {
    this.mPluginNameSpace = "gameTeam";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("gameTeam".equals(paramString2))
    {
      int i;
      Object localObject1;
      if ("sendTeamInvite".equals(paramString3))
      {
        if (paramVarArgs.length > 0) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = paramString2.getInt("toSessionType");
          paramJsBridgeListener = paramString2.getString("toUin");
          paramString1 = paramString2.optString("troopUin");
          Object localObject2 = paramString2.getJSONObject("arkInfo");
          paramString2 = ((JSONObject)localObject2).getString("appName");
          paramString3 = ((JSONObject)localObject2).getString("appVersion");
          paramVarArgs = ((JSONObject)localObject2).getString("appDesc");
          localObject1 = ((JSONObject)localObject2).getString("appView");
          String str1 = ((JSONObject)localObject2).getString("appPrompt");
          String str2 = ((JSONObject)localObject2).getJSONObject("appMeta").toString();
          String str3 = ((JSONObject)localObject2).getString("config");
          localObject2 = ((JSONObject)localObject2).getString("appCompat");
          Activity localActivity = this.mRuntime.getActivity();
          if (localActivity != null)
          {
            Intent localIntent = new Intent(localActivity, DirectForwardActivity.class);
            localIntent.putExtra("forward_type", 27);
            localIntent.putExtra("uinType", ahvn.hU(i));
            localIntent.putExtra("toUin", paramJsBridgeListener);
            localIntent.putExtra("troopUin", paramString1);
            localIntent.putExtra("forward_ark_app_direct", true);
            localIntent.putExtra("forward_ark_app_name", paramString2);
            localIntent.putExtra("forward_ark_app_view", (String)localObject1);
            localIntent.putExtra("forward_ark_app_desc", paramVarArgs);
            localIntent.putExtra("forward_ark_app_ver", paramString3);
            localIntent.putExtra("forward_ark_app_prompt", str1);
            localIntent.putExtra("forward_ark_app_meta", str2);
            localIntent.putExtra("forward_ark_app_config", str3);
            localIntent.putExtra("forward_ark_app_compat", (String)localObject2);
            localIntent.putExtra("openerProc", MobileQQ.sMobileQQ.getQQProcessName());
            localActivity.startActivity(localIntent);
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("launchApp".equals(paramString3))
      {
        if (paramVarArgs.length > 0) {}
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString3.getString("appID");
          paramString1 = paramString3.getString("packageName");
          paramString2 = paramString3.getString("paramsStr");
          paramString3 = paramString3.optString("flags");
          paramVarArgs = this.mRuntime.getActivity();
          if (paramVarArgs != null)
          {
            localObject1 = new Intent(paramVarArgs, PromptDialogActivity.class);
            ((Intent)localObject1).putExtra("direct_start", true);
            ((Intent)localObject1).putExtra("appid", paramJsBridgeListener);
            ((Intent)localObject1).putExtra("packageName", paramString1);
            ((Intent)localObject1).putExtra("paramsStr", paramString2);
            ((Intent)localObject1).putExtra("flags", paramString3);
            paramVarArgs.startActivity((Intent)localObject1);
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("getUserInfo".equals(paramString3))
      {
        if (paramVarArgs.length > 0) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.getJSONArray("member_list");
          i = 0;
          while (i < paramJsBridgeListener.length())
          {
            paramString2 = paramJsBridgeListener.getJSONObject(i);
            paramString2.put("sessionType", ahvn.hU(paramString2.getInt("sessionType")));
            i += 1;
          }
          paramString1 = paramString1.getString("callback");
          paramString2 = new Bundle();
          paramString2.putString("member_list", paramJsBridgeListener.toString());
          paramJsBridgeListener = affz.a("batchGetUserInfo", paramString1, this.remoteRespObserver.key, paramString2);
          afjy.a().cq(paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("onload".equals(paramString3))
      {
        if (this.a == null)
        {
          this.a = new GamePartyBroadcastReceiver();
          paramJsBridgeListener = new IntentFilter();
          paramJsBridgeListener.addAction("android.intent.action.gameparty.notify");
          paramJsBridgeListener.addAction("android.intent.action.gameparty.refresh");
          paramString1 = this.mRuntime.getActivity();
          if (paramString1 != null) {
            paramString1.registerReceiver(this.a, paramJsBridgeListener);
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    afjy.a().a(this.remoteRespObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    afjy.a().b(this.remoteRespObserver);
    if (this.a != null)
    {
      Activity localActivity = this.mRuntime.getActivity();
      if (localActivity != null) {
        localActivity.unregisterReceiver(this.a);
      }
      this.a = null;
    }
  }
  
  public class GamePartyBroadcastReceiver
    extends BroadcastReceiver
  {
    public GamePartyBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.gameparty.notify"))
      {
        paramContext = paramIntent.getStringExtra("uin");
        paramIntent = paramIntent.getStringExtra("teamId");
        GamePartyPlugin.this.callJs("getTeamInfo", new String[] { "'" + paramContext + "'", "'" + paramIntent + "'" });
      }
      while (!paramContext.equals("android.intent.action.gameparty.refresh")) {
        return;
      }
      paramContext = paramIntent.getStringExtra("uin");
      long l = paramIntent.getLongExtra("teamId", 0L);
      GamePartyPlugin.this.callJs("refreshAudioStatus", new String[] { "'" + paramContext + "'", "'" + l + "'" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.GamePartyPlugin
 * JD-Core Version:    0.7.0.1
 */