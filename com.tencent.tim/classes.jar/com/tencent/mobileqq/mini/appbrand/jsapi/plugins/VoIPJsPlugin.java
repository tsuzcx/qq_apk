package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import android.text.TextUtils;
import asey;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xd32.XmitInfo;

public class VoIPJsPlugin
  extends BaseJsPlugin
{
  private static final String API_EXIT_VOIP_CHAT = "exitVoIPChat";
  private static final String API_JOIN_VOIP_CHAT = "joinVoIPChat";
  private static final String API_ON_VOIP_CHAT_INTERRUPTED = "onVoIPChatInterrupted";
  private static final String API_ON_VOIP_CHAT_MEMBER_CHANGED = "onVoIPChatMembersChanged";
  private static final String API_ON_VOIP_CHAT_SPEAKERS_CHANGED = "onVoIPChatSpeakersChanged";
  private static final String API_UPDATE_VOIP_CHAT_MUTE_CONFIG = "updateVoIPChatMuteConfig";
  private static final Set<String> S_EVENT_MAP = new VoIPJsPlugin.1();
  public static final String TAG = "[mini] VoIPJsPlugin";
  
  private byte[] getSig(String paramString, VoIPManager.RoomConfig paramRoomConfig)
  {
    oidb_0xd32.XmitInfo localXmitInfo = new oidb_0xd32.XmitInfo();
    localXmitInfo.str_appid.set(paramString);
    localXmitInfo.str_groupid.set(paramRoomConfig.groupId);
    localXmitInfo.str_nonce.set(paramRoomConfig.nonceStr);
    localXmitInfo.uint32_timestamp.set(paramRoomConfig.timeStamp);
    localXmitInfo.str_signature.set(paramRoomConfig.signature);
    return localXmitInfo.toByteArray();
  }
  
  private boolean isRoomConfigValid(VoIPManager.RoomConfig paramRoomConfig)
  {
    return (!TextUtils.isEmpty(paramRoomConfig.nonceStr)) && (!TextUtils.isEmpty(paramRoomConfig.groupId)) && (!TextUtils.isEmpty(paramRoomConfig.signature)) && (paramRoomConfig.timeStamp > 0);
  }
  
  private VoIPManager.IdResult parseIdResult(JSONObject paramJSONObject)
  {
    return (VoIPManager.IdResult)new JSONParser().parse(paramJSONObject, VoIPManager.IdResult.class);
  }
  
  private VoIPManager.RoomConfig parseRoomConfig(String paramString)
  {
    return (VoIPManager.RoomConfig)new JSONParser().parse(paramString, VoIPManager.RoomConfig.class);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] VoIPJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    Object localObject1;
    Object localObject2;
    if ("updateVoIPChatMuteConfig".equals(paramString1))
    {
      localObject1 = parseRoomConfig(paramString2);
      localObject2 = new JSONObject();
      if ((localObject1 != null) && (((VoIPManager.RoomConfig)localObject1).muteConfig != null)) {
        VoIPManager.getInstance().updateMuteConfig(((VoIPManager.RoomConfig)localObject1).muteConfig, new VoIPJsPlugin.2(this, (JSONObject)localObject2, paramString2, paramJsRuntime, paramInt, paramString1));
      }
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, (JSONObject)localObject2, acfp.m(2131716880)).toString());
      QLog.e("[mini] VoIPJsPlugin", 1, "参数错误 " + paramString2);
      continue;
      if ("joinVoIPChat".equals(paramString1))
      {
        try
        {
          localObject1 = parseRoomConfig(paramString2);
          if (localObject1 == null)
          {
            paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null, "param error").toString());
            return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
          }
          if (!isRoomConfigValid((VoIPManager.RoomConfig)localObject1))
          {
            QLog.e("[mini] VoIPJsPlugin", 1, "isRoomConfigValid false");
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("errCode", -5);
              paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null, "invalid parameters").toString());
              return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
            }
            catch (JSONException localJSONException1)
            {
              for (;;)
              {
                QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException1);
              }
            }
          }
          try
          {
            JSONObject localJSONObject;
            localJSONObject.put("errCode", -1000);
            paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, localJSONObject, "internal error").toString());
            continue;
            localObject2 = localJSONObject.groupId;
            MiniAppCmdUtil.getInstance().transForRoomId(this.jsPluginEngine.appBrandRuntime.appId, (String)localObject2, new VoIPJsPlugin.3(this, paramJsRuntime, paramInt, paramString1, localJSONObject, paramString2));
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException2);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[mini] VoIPJsPlugin", 1, "joinVoIPChat internal error", localThrowable);
          localJSONObject = new JSONObject();
        }
      }
      else if ("exitVoIPChat".equals(paramString1))
      {
        VoIPManager.getInstance().exitRoom();
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, new JSONObject()).toString());
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    asey.a().fT(BaseApplicationImpl.getContext());
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onPause()
  {
    JSONObject localJSONObject;
    if (VoIPManager.getInstance().isInRoom()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("errCode", 2);
      localJSONObject.put("errMsg", acfp.m(2131716879));
      this.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onVoIPChatInterrupted", localJSONObject.toString(), 0);
      VoIPManager.getInstance().exitRoom();
      VoIPManager.getInstance().setEventListener(null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException);
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public static class JSONParser<T>
  {
    public T parse(String paramString, Class<T> paramClass)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          QLog.e("[mini] VoIPJsPlugin", 1, "JSON is empty");
        }
        catch (JSONException paramClass)
        {
          try
          {
            paramString = JsonORM.parseFrom(localJSONObject, paramClass);
            return paramString;
          }
          catch (Exception paramString)
          {
            QLog.e("[mini] VoIPJsPlugin", 1, "JSONParser error! failed parse to " + paramClass, paramString);
            return null;
          }
          paramClass = paramClass;
          QLog.e("[mini] VoIPJsPlugin", 1, "JSONParser error! not a valid JSON " + paramString, paramClass);
          return null;
        }
      }
      return null;
    }
    
    public T parse(JSONObject paramJSONObject, Class<T> paramClass)
    {
      if (paramJSONObject != null) {
        try
        {
          paramJSONObject = JsonORM.parseFrom(paramJSONObject, paramClass);
          return paramJSONObject;
        }
        catch (Exception paramJSONObject)
        {
          QLog.e("[mini] VoIPJsPlugin", 1, "JsonORM error! failed parse to " + paramClass, paramJSONObject);
        }
      }
      for (;;)
      {
        return null;
        QLog.e("[mini] VoIPJsPlugin", 1, "JSON obj is empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */