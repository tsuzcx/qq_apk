package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = PluginConst.AdConst.CodeMsgMap;
  public static final String API_AD_CREATE_BLOCK_AD = "createBlockAd";
  public static final String API_AD_OPERATE_BLOCK_AD = "operateBlockAd";
  public static final String API_AD_UPDATE_BLOCK_AD = "updateBlockAdSize";
  public static final String EVENT_BLOCK_AD_SHOW_DONE = "onBlockAdShowDone";
  public static final String EVENT_BLOCK_AD_STATE_CHANGE = "onBlockAdStateChange";
  private static final Set<String> S_EVENT_MAP = new BlockAdPlugin.1();
  private static final String TAG = "[minigame] BlockAdPlugin";
  
  private void blockErrorStateCallback(JsRuntime paramJsRuntime, int paramInt1, String paramString, int paramInt2)
  {
    if (paramJsRuntime == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("compId", paramInt2);
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt1);
      informJs(paramJsRuntime, localJSONObject, "onBlockAdStateChange");
      return;
    }
    catch (JSONException paramJsRuntime)
    {
      QLog.e("[minigame] BlockAdPlugin", 1, "BlockErrorStateCallback error", paramJsRuntime);
    }
  }
  
  private void informJs(JsRuntime paramJsRuntime, JSONObject paramJSONObject, String paramString)
  {
    if (paramJsRuntime != null) {
      paramJsRuntime.evaluateSubcribeJS(paramString, paramJSONObject.toString(), 0);
    }
  }
  
  private void initAdParam(JsRuntime paramJsRuntime, MiniAppAd.StGetAdReq paramStGetAdReq, BlockAdInfo paramBlockAdInfo)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new BlockAdPlugin.6(this, paramJsRuntime, paramBlockAdInfo));
  }
  
  private void updateBlockSize(JsRuntime paramJsRuntime, String paramString)
  {
    int m = 1;
    int n = 1;
    int k = 1;
    int i1;
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      i1 = paramString.getInt("compId");
      if (paramString.has("left"))
      {
        i = paramString.getInt("left");
        j = 1;
      }
      else if (paramString.has("top"))
      {
        i = paramString.getInt("top");
        j = 2;
      }
    }
    catch (JSONException paramJsRuntime)
    {
      QLog.e("[minigame] BlockAdPlugin", 2, "handle updateBlockAdSize parse json error", paramJsRuntime);
      return;
    }
    if (i < 32)
    {
      blockErrorStateCallback(paramJsRuntime, 1009, (String)AD_ERROR_MSG.get(Integer.valueOf(1009)), i1);
      return;
    }
    if ((j != -1) && ((this.jsPluginEngine.activityContext instanceof GameActivity)))
    {
      paramString = BlockAdManager.getInstance().getBlockAdInfo(i1);
      if (paramString != null) {
        switch (j)
        {
        case 1: 
        case 2: 
          label168:
          while (j == 0)
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            QLog.i("[minigame] BlockAdPlugin", 1, "updateBlockAd no need to resize");
            return;
            if (paramString.getLeft() == i) {
              break label297;
            }
            k = m;
            label200:
            j = k;
            if (k != 0)
            {
              paramString.setLeft(i);
              j = k;
              continue;
              if (paramString.getTop() == i) {
                break label303;
              }
            }
          }
        }
      }
    }
    label289:
    label297:
    label303:
    for (k = n;; k = 0)
    {
      j = k;
      if (k == 0) {
        break label168;
      }
      paramString.setTop(i);
      j = k;
      break label168;
      AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.5(this, i1, paramString, paramString.getLeft(), paramString.getTop(), paramJsRuntime));
      return;
      i = -1;
      j = -1;
      if (j != -1) {
        break;
      }
      return;
      j = k;
      break label168;
      k = 0;
      break label200;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] BlockAdPlugin", 2, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    Activity localActivity = this.jsPluginEngine.appBrandRuntime.activity;
    int i;
    Object localObject;
    String str1;
    if ("createBlockAd".equals(paramString1))
    {
      QLog.i("[minigame] BlockAdPlugin", 2, "receive createBlockAd event");
      if ((this.jsPluginEngine == null) || (TextUtils.isEmpty(paramString2)))
      {
        QLog.i("[minigame] BlockAdPlugin", 2, "handle createBlockAd event, jsPluginEngine == null");
        return "";
      }
      try
      {
        i = new JSONObject(paramString2).getInt("compId");
        localObject = BlockAdManager.getInstance().parseBlockAdInfoFromJson(paramString2);
        if (localObject == null)
        {
          blockErrorStateCallback(paramJsRuntime, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), i);
          return "";
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle createBlockAd,", localJSONException1);
          i = -1;
        }
        str1 = "";
        i = 0;
        if ((this.jsPluginEngine.activityContext instanceof GameActivity))
        {
          str1 = ((GameActivity)this.jsPluginEngine.activityContext).getMiniGameAppId();
          if (!((GameActivity)this.jsPluginEngine.activityContext).getIsOrientationLandscape()) {
            break label300;
          }
          i = 90;
        }
      }
      String str2 = this.jsPluginEngine.activityContext.getCurrentAccountUin();
      String str3 = AdUtils.getSpAdGdtCookie(13);
      initAdParam(paramJsRuntime, AdUtils.createAdRequest(this.jsPluginEngine.activityContext, Long.valueOf(str2).longValue(), ((BlockAdInfo)localObject).getAdUnitId(), str1, 53, 13, i, str3, "", "", "", "", ((BlockAdInfo)localObject).getSize()), (BlockAdInfo)localObject);
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      label300:
      i = 0;
      break;
      if ("operateBlockAd".equals(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("[minigame] BlockAdPlugin", 2, "receive operateBlockAd event");
        }
        if (this.jsPluginEngine == null)
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd event, jsPluginEngine == null");
          return "";
        }
        try
        {
          localObject = new JSONObject(paramString2);
          str1 = ((JSONObject)localObject).getString("type");
          i = ((JSONObject)localObject).getInt("compId");
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd type = " + str1);
          localObject = BlockAdManager.getInstance().getBlockAdInfo(i);
          if (!"show".equals(str1)) {
            break label474;
          }
          if (!(this.jsPluginEngine.activityContext instanceof GameActivity)) {
            continue;
          }
          AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.2(this, (BlockAdInfo)localObject), 300L);
        }
        catch (JSONException localJSONException2)
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd parse json error", localJSONException2);
        }
        continue;
        label474:
        if ("hide".equals(localJSONException2))
        {
          if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
            AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.3(this, (BlockAdInfo)localObject));
          }
        }
        else if ("destroy".equals(localJSONException2))
        {
          if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
            AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.4(this, (BlockAdInfo)localObject));
          }
        }
        else {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd not define type = " + localJSONException2);
        }
      }
      else if ("updateBlockAdSize".equals(paramString1))
      {
        QLog.i("[minigame] BlockAdPlugin", 2, "updateBlockAdSize " + paramString2);
        if ((this.jsPluginEngine == null) || (this.jsPluginEngine.activityContext == null) || (paramJsRuntime == null))
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle updateBlockAdSize event, jsPluginEngine == null");
          return "";
        }
        updateBlockSize(paramJsRuntime, paramString2);
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin
 * JD-Core Version:    0.7.0.1
 */