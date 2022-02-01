package com.tencent.qqmini.minigame.plugins;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.qqmini.minigame.GameJsService;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class OpenDataJsPlugin
  extends BaseJsPlugin
{
  public static final String API_GET_POTENTIAL_FRIEND_LIST = "getPotentialFriendList";
  public static final String API_GET_USER_INTERACTIVE_STORAGE = "getUserInteractiveStorage";
  public static final String API_MODIFY_FRIEND_INTERACTIVE_STORAGE = "modifyFriendInteractiveStorage";
  public static final String API_ON_INTERACTIVE_STORAGE_MODIFIED = "onInteractiveStorageModified";
  public static final String API_ON_SHARE_MESSAGE_TO_FRIEND = "onShareMessageToFriend";
  public static final String API_SET_MESSAGE_TO_FRIEND_QUERY = "setMessageToFriendQuery";
  public static final String API_SHARE_MESSAGE_TO_FRIEND = "shareMessageToFriend";
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  private static final String TAG = "OpenDataJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  private void getPotentialFriendListImpl(RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo == null)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , no appid");
      paramRequestEvent.fail();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPotentialFriendList(null, str, new OpenDataJsPlugin.6(this, paramRequestEvent));
  }
  
  private void getUserInteractiveStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo == null)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , no appid");
      paramRequestEvent.fail();
      return;
    }
    String str = this.mMiniAppInfo.appId;
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInteractiveStorage(null, str, paramArrayOfString, new OpenDataJsPlugin.7(this, paramRequestEvent));
  }
  
  private void modifyFriendInteractiveStorage(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9)
  {
    if (this.mMiniAppInfo == null)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no appid");
      paramRequestEvent.fail();
      return;
    }
    String str1 = this.mMiniAppInfo.appId;
    String str2 = this.mMiniAppInfo.shareId;
    if (!paramBoolean.booleanValue())
    {
      if (TextUtils.isEmpty(paramString3))
      {
        GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no toUser");
        paramRequestEvent.fail();
      }
    }
    else if (TextUtils.isEmpty(str2))
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , no shareId");
      paramRequestEvent.fail();
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramInt + "");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).modifyFriendInteractiveStorage(null, str1, paramString3, str2, paramInt, paramString2, localHashMap, new OpenDataJsPlugin.8(this, paramRequestEvent, paramString5, paramBoolean, paramString9, paramString8, paramString3, paramString4, paramString6, paramString7, paramString1));
  }
  
  private void shareMessageToFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, RequestEvent paramRequestEvent)
  {
    String str = "";
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    paramString5 = str;
    if (this.mMiniAppInfo != null)
    {
      paramString5 = str;
      if (!TextUtils.isEmpty(this.mMiniAppInfo.friendMessageQuery)) {
        paramString5 = "" + this.mMiniAppInfo.friendMessageQuery;
      }
      localShareState.shareAppid = this.mMiniAppInfo.appId;
    }
    localShareState.shareEvent = paramRequestEvent.event;
    localShareState.shareCallbackId = paramRequestEvent.callbackId;
    localShareState.shareOpenid = paramString1;
    boolean bool1;
    if (TextUtils.isEmpty(paramString5))
    {
      paramString5 = "miniGamePath";
      if ((!URLUtil.isHttpUrl(paramString4)) && (!URLUtil.isHttpsUrl(paramString4))) {
        break label359;
      }
      bool1 = true;
      label137:
      if ((TextUtils.isEmpty(paramString4)) || (!new File(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString4)).exists())) {
        break label365;
      }
    }
    label359:
    label365:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString2 = new ShareChatModel(0, 0L, paramString2);
      paramString1 = new InnerShareData.Builder().setShareSource(11).setShareTarget(5).setTitle(this.mMiniAppInfo.name).setSummary(paramString3).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEntryPath(paramString5).setShareChatModel(paramString2).setWithShareTicket(localShareState.withShareTicket).setRecvOpenId(paramString1).setShareInMiniProcess(localShareState.isShareInMiniProcess);
      if ((!StringUtil.isEmpty(paramString4)) && ((bool1) || (bool2))) {
        break label371;
      }
      paramString1.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
      QMLog.e("OpenDataJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + paramString4 + "], use default share image");
      return;
      break;
      bool1 = false;
      break label137;
    }
    label371:
    if ((paramString4.startsWith("http")) || (paramString4.startsWith("https")))
    {
      paramString1.setSharePicPath(paramString4).build().shareAppMessage();
      return;
    }
    paramString1.setSharePicPath(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString4)).setIsLocalPic(true).build().shareAppMessage();
  }
  
  private void showConfirmModificationModel(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Boolean paramBoolean, RequestEvent paramRequestEvent, String paramString8, String paramString9, int paramInt2)
  {
    String str2 = paramString9 + paramString8;
    if (paramInt2 > 0) {}
    for (String str1 = "确认" + paramString8 + paramString4 + paramInt1 * paramInt2 + paramString9 + "?"; paramBoolean.booleanValue(); str1 = "确认" + paramString8 + paramString4 + paramString9 + "?")
    {
      modifyFriendInteractiveStorage(paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9);
      return;
    }
    showQQCustomModel(str2, str1, "确认" + paramString8, Boolean.valueOf(false), "", new OpenDataJsPlugin.9(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean, paramRequestEvent, paramString8, paramString9), null, new OpenDataJsPlugin.10(this, paramRequestEvent));
  }
  
  private void showQQCustomModel(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppBrandTask.runTaskOnUiThread(new OpenDataJsPlugin.11(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramBoolean, paramString4, paramOnClickListener2, paramOnCancelListener));
  }
  
  @JsEvent({"getFriendCloudStorage"})
  public void getFriendCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getFriendCloudStorage(arrayOfString, paramRequestEvent);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest getFriendCloudStorage error " + paramRequestEvent.getMessage());
      return;
    }
  }
  
  public void getFriendCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getFriendCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataJsPlugin", str);
      this.mChannelProxy.getFriendCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataJsPlugin.3(this, paramRequestEvent));
      return;
    }
  }
  
  @JsEvent({"getGroupCloudStorage"})
  public void getGroupCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("shareTicket");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyList");
      if (localJSONArray != null)
      {
        localObject = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          localObject[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getGroupCloudStorage(str, (String[])localObject, paramRequestEvent);
        return;
        localObject = new String[0];
      }
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + paramRequestEvent.getMessage());
      return;
    }
  }
  
  public void getGroupCloudStorage(String paramString, String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("state", "fail");
        paramRequestEvent.fail(paramString, "当前小程序不是从群分享卡片打开");
        return;
      }
      catch (JSONException paramString)
      {
        GameLog.getInstance().e("OpenDataJsPlugin", "getGroupCloudStorage error " + paramString.getMessage());
        paramRequestEvent.fail();
        return;
      }
    }
    this.mChannelProxy.getGroupCloudStorage(this.mMiniAppInfo.appId, paramString, paramArrayOfString, new OpenDataJsPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"getOpenDataContext"})
  public void getOpenDataContext(RequestEvent paramRequestEvent) {}
  
  @JsEvent({"getPotentialFriendList"})
  public void getPotentialFriendList(RequestEvent paramRequestEvent)
  {
    try
    {
      getPotentialFriendListImpl(paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + localThrowable.getMessage());
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"getUserCloudStorage"})
  public void getUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getUserCloudStorage(arrayOfString, paramRequestEvent);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest getUserCloudStorage error " + paramRequestEvent.getMessage());
      return;
    }
  }
  
  public void getUserCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("getUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataJsPlugin", str);
      if ((paramArrayOfString != null) && (paramRequestEvent.jsService != null)) {
        break;
      }
      return;
    }
    paramRequestEvent = new OpenDataJsPlugin.1(this, paramRequestEvent);
    this.mChannelProxy.getUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, paramRequestEvent);
  }
  
  @JsEvent({"getUserInteractiveStorage"})
  public void getUserInteractiveStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).getJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        getUserInteractiveStorage(arrayOfString, paramRequestEvent);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
      paramRequestEvent.fail();
      return;
    }
  }
  
  @JsEvent({"modifyFriendInteractiveStorage"})
  public void modifyFriendInteractiveStorage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        String str6 = ((JSONObject)localObject1).getString("key");
        int m = ((JSONObject)localObject1).getInt("opNum");
        String str7 = ((JSONObject)localObject1).getString("operation");
        String str8 = ((JSONObject)localObject1).optString("title");
        String str9 = ((JSONObject)localObject1).optString("imageUrl");
        String str10 = ((JSONObject)localObject1).optString("imageUrlId");
        Boolean localBoolean = Boolean.valueOf(((JSONObject)localObject1).optBoolean("quiet"));
        String str1 = "";
        String str2 = "";
        int k = -1;
        String str4 = "";
        String str5 = "";
        localObject1 = ((JSONObject)localObject1).optJSONObject("friendInfo");
        if (localObject1 != null)
        {
          str1 = ((JSONObject)localObject1).getString("openid");
          str2 = ((JSONObject)localObject1).getString("nickname");
        }
        localObject1 = GetGameInfoManager.obtain(this.mMiniAppContext);
        if (localObject1 != null)
        {
          localObject1 = ((GameInfoManager)localObject1).getMiniGamePkg();
          if (localObject1 == null) {
            break label465;
          }
          localObject2 = ((MiniGamePkg)localObject1).mGameConfigJson;
          String str3 = str4;
          localObject1 = str5;
          int j = k;
          if (localObject2 != null)
          {
            localObject2 = ((JSONObject)localObject2).optJSONArray("modifyFriendInteractiveStorageTemplates");
            str3 = str4;
            localObject1 = str5;
            j = k;
            if (localObject2 != null)
            {
              str3 = str4;
              localObject1 = str5;
              j = k;
              if (((JSONArray)localObject2).length() > 0)
              {
                i = 0;
                str3 = str4;
                localObject1 = str5;
                j = k;
                if (i < ((JSONArray)localObject2).length())
                {
                  localObject1 = ((JSONArray)localObject2).getJSONObject(i);
                  if (localObject1 == null) {
                    break label471;
                  }
                  str3 = ((JSONObject)localObject1).optString("key");
                  if ((TextUtils.isEmpty(str3)) || (!str3.equals(str6))) {
                    break label471;
                  }
                  j = ((JSONObject)localObject1).optInt("ratio");
                  str3 = ((JSONObject)localObject1).optString("action");
                  localObject1 = ((JSONObject)localObject1).optString("object");
                }
              }
            }
          }
          if (localBoolean.booleanValue())
          {
            modifyFriendInteractiveStorage(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, paramRequestEvent, str3, (String)localObject1);
            return;
          }
          showConfirmModificationModel(str6, m, str7, str1, str2, str8, str9, str10, localBoolean, paramRequestEvent, str3, (String)localObject1, j);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + localThrowable.getMessage());
        paramRequestEvent.fail();
        return;
      }
      Object localObject1 = null;
      continue;
      label465:
      Object localObject2 = null;
      continue;
      label471:
      i += 1;
    }
  }
  
  @JsEvent({"onMessage"})
  public void onMessage(RequestEvent paramRequestEvent)
  {
    Object localObject;
    if (this.mIsMiniGame) {
      localObject = (GameJsService)paramRequestEvent.jsService;
    }
    while (localObject != null) {
      if (((GameJsService)localObject).getTargetContextType() == 1)
      {
        localObject = this.mMiniAppInfo;
        if ((localObject != null) && (((MiniAppInfo)localObject).whiteList != null) && (((MiniAppInfo)localObject).whiteList.contains("onMessage")))
        {
          paramRequestEvent.jsService.evaluateSubscribeJS("onMessage", paramRequestEvent.jsonParams, 0);
          sendSubscribeEvent("onMessage", paramRequestEvent.jsonParams);
          return;
          localObject = null;
        }
        else
        {
          GameLog.getInstance().e("OpenDataJsPlugin", "开放域调用了未授权的私有API: postMessage -> onMessage");
          GameLog.vconsoleLog("error 开放域调用了未授权的私有API: postMessage");
        }
      }
      else
      {
        paramRequestEvent.jsService.evaluateSubscribeJS("onMessage", paramRequestEvent.jsonParams, 0);
        return;
      }
    }
    GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest onMessage error, not gameJsRuntime!");
  }
  
  @JsEvent({"removeUserCloudStorage"})
  public void removeUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("keyList");
      String[] arrayOfString;
      if (localJSONArray != null)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = ((String)localJSONArray.get(i));
          i += 1;
        }
      }
      for (;;)
      {
        removeUserCloudStorage(arrayOfString, paramRequestEvent);
        return;
        arrayOfString = new String[0];
      }
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest removeUserCloudStorage error " + paramRequestEvent.getMessage());
      return;
    }
  }
  
  public void removeUserCloudStorage(String[] paramArrayOfString, RequestEvent paramRequestEvent)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("removeUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", keys:");
    if (paramArrayOfString != null) {}
    for (String str = Arrays.toString(paramArrayOfString);; str = "")
    {
      localGameLog.i("OpenDataJsPlugin", str);
      this.mChannelProxy.removeUserCloudStorage(this.mMiniAppInfo.appId, paramArrayOfString, new OpenDataJsPlugin.5(this, paramRequestEvent));
      return;
    }
  }
  
  @JsEvent({"setMessageToFriendQuery"})
  public void setMessageToFriendQuery(RequestEvent paramRequestEvent)
  {
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).optInt("shareMessageToFriendScene", -1);
      if (i == -1) {
        paramRequestEvent.fail();
      }
      if (this.mMiniAppInfo != null) {
        this.mMiniAppInfo.friendMessageQuery = ("shareMessageToFriendScene=" + i);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("success", true);
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_SET_MESSAGE_TO_FRIEND_QUERY error " + localThrowable.getMessage());
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setUserCloudStorage"})
  public void setUserCloudStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("KVDataList");
      HashMap localHashMap = new HashMap();
      if (localJSONArray != null)
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localHashMap.put(localJSONObject.get("key").toString(), localJSONObject.get("value").toString());
          i += 1;
        }
      }
      setUserCloudStorage(localHashMap, paramRequestEvent);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest setUserCloudStorage error " + paramRequestEvent.getMessage());
    }
  }
  
  public void setUserCloudStorage(HashMap<String, String> paramHashMap, RequestEvent paramRequestEvent)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage appid:").append(this.mMiniAppInfo.appId).append(", kvData:");
    if (paramHashMap != null) {}
    for (String str = paramHashMap.toString();; str = "")
    {
      localGameLog.i("OpenDataJsPlugin", str);
      this.mChannelProxy.setUserCloudStorage(this.mMiniAppInfo.appId, paramHashMap, new OpenDataJsPlugin.4(this, paramRequestEvent));
      return;
    }
  }
  
  @JsEvent({"shareMessageToFriend"})
  public void shareMessageToFriend(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("friendInfo");
      shareMessageToFriend(localJSONObject2.getString("openid"), localJSONObject2.getString("nickname"), localJSONObject1.optString("title"), localJSONObject1.optString("imageUrl"), localJSONObject1.optString("imageUrlId"), paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_SHARE_MESSAGE_TO_FRIEND error " + localThrowable.getMessage());
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */