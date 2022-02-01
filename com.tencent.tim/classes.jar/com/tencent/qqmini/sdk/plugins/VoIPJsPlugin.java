package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.IdResult;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xd32.XmitInfo;

@JsPlugin
public class VoIPJsPlugin
  extends BaseJsPlugin
{
  private static final String API_EXIT_VOIP_CHAT = "exitVoIPChat";
  private static final String API_JOIN_VOIP_CHAT = "joinVoIPChat";
  private static final String API_ON_VOIP_CHAT_INTERRUPTED = "onVoIPChatInterrupted";
  private static final String API_ON_VOIP_CHAT_MEMBER_CHANGED = "onVoIPChatMembersChanged";
  private static final String API_ON_VOIP_CHAT_SPEAKERS_CHANGED = "onVoIPChatSpeakersChanged";
  private static final String API_UPDATE_VOIP_CHAT_MUTE_CONFIG = "updateVoIPChatMuteConfig";
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
  
  @JsEvent({"exitVoIPChat"})
  public String exitVoIPChat(RequestEvent paramRequestEvent)
  {
    VoIPManager.getInstance().exitRoom();
    JSONObject localJSONObject = new JSONObject();
    paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString());
    return "";
  }
  
  @JsEvent({"joinVoIPChat"})
  public String joinVoIPChat(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = parseRoomConfig(paramRequestEvent.jsonParams);
      if (localObject == null)
      {
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "param error").toString());
        return "";
      }
      if (!isRoomConfigValid((VoIPManager.RoomConfig)localObject))
      {
        QMLog.e("[mini] VoIPJsPlugin", "isRoomConfigValid false");
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", -5);
          paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "invalid parameters").toString());
          return "";
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
          }
        }
      }
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("errCode", -1000);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, "internal error").toString());
        for (;;)
        {
          return "";
          String str = localJSONObject.groupId;
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.getMiniAppInfo().appId, str, new VoIPJsPlugin.2(this, paramRequestEvent, localJSONObject));
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] VoIPJsPlugin", "joinVoIPChat internal error", localThrowable);
      localJSONObject = new JSONObject();
    }
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
      localJSONObject.put("errMsg", "进入后台或关闭");
      sendSubscribeEvent("onVoIPChatInterrupted", localJSONObject.toString());
      VoIPManager.getInstance().exitRoom();
      VoIPManager.getInstance().setEventListener(null);
      super.onPause();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  @JsEvent({"updateVoIPChatMuteConfig"})
  public String updateVoIPChatMuteConfig(RequestEvent paramRequestEvent)
  {
    VoIPManager.RoomConfig localRoomConfig = parseRoomConfig(paramRequestEvent.jsonParams);
    JSONObject localJSONObject = new JSONObject();
    if ((localRoomConfig != null) && (localRoomConfig.muteConfig != null)) {
      VoIPManager.getInstance().updateMuteConfig(localRoomConfig.muteConfig, new VoIPJsPlugin.1(this, localJSONObject, paramRequestEvent));
    }
    for (;;)
    {
      return "";
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, "参数错误").toString());
      QMLog.e("[mini] VoIPJsPlugin", "参数错误 " + paramRequestEvent.jsonParams);
    }
  }
  
  public static class JSONParser<T>
  {
    public T parse(String paramString, Class<T> paramClass)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          QMLog.e("[mini] VoIPJsPlugin", "JSON is empty");
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
            QMLog.e("[mini] VoIPJsPlugin", "JSONParser error! failed parse to " + paramClass, paramString);
            return null;
          }
          paramClass = paramClass;
          QMLog.e("[mini] VoIPJsPlugin", "JSONParser error! not a valid JSON " + paramString, paramClass);
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
          QMLog.e("[mini] VoIPJsPlugin", "JsonORM error! failed parse to " + paramClass, paramJSONObject);
        }
      }
      for (;;)
      {
        return null;
        QMLog.e("[mini] VoIPJsPlugin", "JSON obj is empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */