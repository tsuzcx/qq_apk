package com.tencent.mobileqq.activity.aio.rebuild;

import acfp;
import adqa;
import adqr;
import adqu;
import adrl;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import aqha;
import aqjn.a;
import aqju;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xwl;
import xwm;

public class ArkDebugChatPie$1$1$4
  implements Runnable
{
  public ArkDebugChatPie$1$1$4(xwm paramxwm, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.SQ)) {}
    try
    {
      localObject1 = new JSONObject(new JSONObject(this.SQ).optString("config"));
      Object localObject3;
      if (this.val$mode.equals("input")) {
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (localObject1 != null)
          {
            localObject1 = ((ChatFragment)localObject1).a();
            if (localObject1 != null)
            {
              localObject2 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(xwl.a(this.a.a.this$0), this.val$view, null, false);
              localObject3 = new ArrayList();
              adqa localadqa = new adqa();
              localadqa.appName = xwl.a(this.a.a.this$0);
              localadqa.appPath = ((String)localObject2);
              localadqa.meta = this.aWN;
              localadqa.appView = this.val$view;
              ((List)localObject3).add(localadqa);
              ((BaseChatPie)localObject1).a.R((List)localObject3, 0);
            }
          }
        }
      }
      for (;;)
      {
        return;
        if (this.val$mode.equals("popup"))
        {
          localObject1 = BaseActivity.sTopActivity;
          if (!(localObject1 instanceof FragmentActivity)) {
            continue;
          }
          localObject2 = aqjn.a.a(xwl.a(this.a.a.this$0), this.val$view, "0.0.0.1", this.aWN, adqr.getDensity(), null, null);
          xwl.a(this.a.a.this$0, aqha.a((Context)localObject1, null, (Bundle)localObject2));
          xwl.a(this.a.a.this$0).setNegativeButton(2131721058, null);
          xwl.a(this.a.a.this$0).setPositiveButton(2131721079, null);
          xwl.a(this.a.a.this$0).show();
          return;
        }
        if (this.val$mode.equals("card"))
        {
          localObject3 = new ArkAppMessage();
          ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
          ((ArkAppMessage)localObject3).appName = xwl.a(this.a.a.this$0);
          ((ArkAppMessage)localObject3).appView = this.val$view;
          localObject2 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject3).appName, ((ArkAppMessage)localObject3).appMinVersion);
          if (localObject2 != null)
          {
            ((ArkAppMessage)localObject3).appDesc = ((String)((Map)localObject2).get("desc"));
            ((ArkAppMessage)localObject3).appMinVersion = ((String)((Map)localObject2).get("version"));
          }
          if (TextUtils.isEmpty(((ArkAppMessage)localObject3).appDesc)) {
            ((ArkAppMessage)localObject3).appDesc = ((ArkAppMessage)localObject3).appName;
          }
          ((ArkAppMessage)localObject3).promptText = String.format(acfp.m(2131702796), new Object[] { ((ArkAppMessage)localObject3).appDesc });
          ((ArkAppMessage)localObject3).metaList = this.aWN;
          if (localObject1 != null) {}
        }
        else
        {
          try
          {
            localObject2 = new JSONObject();
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException5)
          {
            try
            {
              xwl.access$400((JSONObject)localObject1);
              ((JSONObject)localObject1).put("type", "card");
              for (;;)
              {
                for (;;)
                {
                  label505:
                  ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
                  localObject1 = this.a.a.this$0.a();
                  if (localObject1 == null) {
                    break;
                  }
                  xwl.a(this.a.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
                  return;
                  if (this.val$mode.equals("fullscreen"))
                  {
                    if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
                      break;
                    }
                    localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
                    adqu.a(null, xwl.a(this.a.a.this$0), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                    ArkFullScreenAppActivity.a((Context)localObject1, xwl.a(this.a.a.this$0), this.val$view, "0.0.0.1", this.aWN, adqr.getDensity(), null, 0);
                    return;
                  }
                  if (!this.val$mode.equals("default")) {
                    break;
                  }
                  localObject3 = new ArkAppMessage();
                  ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
                  ((ArkAppMessage)localObject3).appName = xwl.a(this.a.a.this$0);
                  ((ArkAppMessage)localObject3).appView = this.val$view;
                  localObject2 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject3).appName, ((ArkAppMessage)localObject3).appMinVersion);
                  if (localObject2 != null)
                  {
                    ((ArkAppMessage)localObject3).appDesc = ((String)((Map)localObject2).get("desc"));
                    ((ArkAppMessage)localObject3).appMinVersion = ((String)((Map)localObject2).get("version"));
                  }
                  if (TextUtils.isEmpty(((ArkAppMessage)localObject3).appDesc)) {
                    ((ArkAppMessage)localObject3).appDesc = ((ArkAppMessage)localObject3).appName;
                  }
                  ((ArkAppMessage)localObject3).promptText = String.format(acfp.m(2131702792), new Object[] { ((ArkAppMessage)localObject3).appDesc });
                  ((ArkAppMessage)localObject3).metaList = this.aWN;
                  if (localObject1 != null) {
                    break label900;
                  }
                  try
                  {
                    localObject2 = new JSONObject();
                    localObject1 = localObject2;
                  }
                  catch (JSONException localJSONException3)
                  {
                    try
                    {
                      xwl.access$400((JSONObject)localObject1);
                      ((JSONObject)localObject1).put("type", "normal");
                      for (;;)
                      {
                        label826:
                        ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
                        localObject1 = this.a.a.this$0.a();
                        if (localObject1 == null) {
                          break;
                        }
                        xwl.a(this.a.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
                        return;
                        localJSONException3 = localJSONException3;
                      }
                    }
                    catch (JSONException localJSONException4)
                    {
                      break label826;
                    }
                  }
                }
                localJSONException5 = localJSONException5;
              }
            }
            catch (JSONException localJSONException6)
            {
              break label505;
            }
          }
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      label900:
      for (;;)
      {
        JSONException localJSONException2 = localJSONException6;
        continue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.4
 * JD-Core Version:    0.7.0.1
 */