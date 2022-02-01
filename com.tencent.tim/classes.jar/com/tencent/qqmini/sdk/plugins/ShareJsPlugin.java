package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class ShareJsPlugin
  extends BaseJsPlugin
{
  private static final int ACTION_SHEET_DEFAULT_TYPE = 0;
  public static final String API_OPEN_QZONE_PUBLISH = "openQzonePublish";
  public static final int ERRCODE_INVITE_CANCEL = 1;
  public static final int ERRCODE_INVITE_REQUIRE = 2;
  public static final String ERRMSG_INVITE_CANCEL = "用户取消";
  public static final String ERRMSG_INVITE_REQUIRE = "分享失败";
  public static final int NEED_HIDE = 0;
  public static final int NEED_SHOW = 1;
  public static final String SHARE_ITEM_QQ = "qq";
  public static final String SHARE_ITEM_QZONE = "qzone";
  public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
  public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
  public static final int SHARE_MENU_STATE_NEED_HIDE = 0;
  public static final int SHARE_MENU_STATE_NEED_SHOW = 1;
  public static final int SHARE_MENU_STATE_UNDEFINED = -1;
  private static final String TAG = "ShareJsPlugin";
  public static final int UNDEFINED = -1;
  private final int ACTION_SHEET_SHARE_PANEL_TYPE = 1;
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  private ShareChatModel getShareChatModel(int paramInt, JSONObject paramJSONObject, ShareState paramShareState)
  {
    if (paramInt == 5)
    {
      paramJSONObject = paramJSONObject.optString("chatDataHash");
      paramShareState = paramShareState.shareChatModel;
      if ((paramShareState != null) && (paramShareState.getEntryHash().equals(paramJSONObject))) {
        return paramShareState;
      }
      QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + paramJSONObject);
    }
    return null;
  }
  
  private EntryModel getShareQQDirectlyModel(int paramInt, JSONObject paramJSONObject, ShareState paramShareState)
  {
    paramShareState = null;
    if (paramInt == 2)
    {
      paramShareState = this.mMiniAppInfo;
      paramJSONObject = paramJSONObject.optString("entryDataHash");
      if ((paramJSONObject != null) && (paramShareState.launchParam.entryModel != null) && (paramJSONObject.equals(paramShareState.launchParam.entryModel.getEntryHash()))) {
        paramShareState = paramShareState.launchParam.entryModel;
      }
    }
    else
    {
      return paramShareState;
    }
    QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, entryDataHash is no match:" + paramJSONObject);
    return null;
  }
  
  private int getShareType(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    do
    {
      do
      {
        return 0;
        if (paramInt == 1) {
          return 1;
        }
      } while (paramInt == 2);
      if (paramInt == 3) {
        return 3;
      }
      if (paramInt == 4) {
        return 4;
      }
    } while ((paramInt == 5) || ((paramInt == 6) && ("shareAppMessageDirectlyToFriendList".equals(paramString))));
    if (MoreItem.isValidExtendedItemId(paramInt)) {
      return 6;
    }
    return -1;
  }
  
  @JsEvent({"hideShareMenu"})
  public void hideShareMenu(RequestEvent paramRequestEvent)
  {
    int i = -1;
    int k = 0;
    for (;;)
    {
      int j;
      int n;
      int m;
      try
      {
        localObject = (JSONArray)new JSONObject(paramRequestEvent.jsonParams).opt("hideShareItems");
        if (localObject != null) {
          break label200;
        }
        j = 0;
        n = 0;
        m = 0;
        i = k;
        k = n;
        localObject = GetShareState.obtain(this.mMiniAppContext);
        if (m == 0) {
          ((ShareState)localObject).withShareQQ = false;
        }
        if (k == 0) {
          ((ShareState)localObject).withShareQzone = false;
        }
        if (j == 0) {
          ((ShareState)localObject).withShareWeChatFriend = false;
        }
        if (i == 0) {
          ((ShareState)localObject).withShareWeChatMoment = false;
        }
        ((ShareState)localObject).withShareOthers = false;
        paramRequestEvent.ok();
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        Object localObject;
        String str;
        boolean bool;
        paramRequestEvent.printStackTrace();
        return;
      }
      if (n < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).getString(n);
        if (str.equalsIgnoreCase("qq")) {
          m = 0;
        }
        if (str.equalsIgnoreCase("qzone")) {
          k = 0;
        }
        if (str.equalsIgnoreCase("wechatFriends")) {
          j = 0;
        }
        bool = str.equalsIgnoreCase("wechatMoment");
        if (bool) {
          i = 0;
        }
        n += 1;
      }
      else
      {
        continue;
        label200:
        n = 0;
        j = -1;
        k = -1;
        m = -1;
      }
    }
  }
  
  @JsEvent({"openQzonePublish"})
  public void openQzonePublish(RequestEvent paramRequestEvent)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openQzonePublish(this.mMiniAppContext, this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.jsonParams, this.mMiniAppInfo)) {
      MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中发表说说", 1);
    }
  }
  
  @JsEvent({"shareAppMessage", "shareAppMessageDirectlyToFriendList"})
  public void shareAppMessage(RequestEvent paramRequestEvent)
  {
    int k;
    int j;
    ShareState localShareState;
    int i;
    label159:
    label214:
    String str1;
    try
    {
      if (!"shareAppMessageDirectly".equals(paramRequestEvent.event)) {
        break label855;
      }
      k = 1;
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      j = ((JSONObject)localObject).optInt("shareTarget", -1);
      int m = getShareType(j, paramRequestEvent.event);
      localShareState = GetShareState.obtain(this.mMiniAppContext);
      EntryModel localEntryModel = getShareQQDirectlyModel(j, (JSONObject)localObject, localShareState);
      ShareChatModel localShareChatModel = getShareChatModel(j, (JSONObject)localObject, localShareState);
      String str2 = ((JSONObject)localObject).optString("shareTemplateId");
      String str3 = ((JSONObject)localObject).optString("shareTemplateData");
      if (!"shareAppMessageDirectly".equals(paramRequestEvent.event))
      {
        i = j;
        if (!"shareAppMessageDirectlyToFriendList".equals(paramRequestEvent.event)) {}
      }
      else
      {
        i = j;
        j = m;
        if (m == -1)
        {
          i = this.mShareProxy.getDefaultShareTarget();
          if (!MoreItem.isValidExtendedItemId(i)) {
            break label862;
          }
          j = 6;
        }
        localShareState.fromShareMenuBtn = j;
      }
      localShareState.shareEvent = paramRequestEvent.event;
      localShareState.shareCallbackId = paramRequestEvent.callbackId;
      if (TextUtils.isEmpty(localShareState.stagingJsonParams)) {
        break label852;
      }
      localObject = new JSONObject(localShareState.stagingJsonParams);
      localShareState.stagingJsonParams = null;
      str1 = ((JSONObject)localObject).optString("path");
      paramRequestEvent = str1;
      if (TextUtils.isEmpty(str1)) {
        paramRequestEvent = ((JSONObject)localObject).optString("query");
      }
      String str4 = ((JSONObject)localObject).optString("title");
      str1 = ((JSONObject)localObject).optString("imageUrl");
      localObject = ((JSONObject)localObject).optString("generalWebpageUrl");
      if (!TextUtils.isEmpty(paramRequestEvent)) {
        break label849;
      }
      if (this.mMiniAppContext.isMiniGame()) {}
      for (paramRequestEvent = "miniGamePath";; paramRequestEvent = this.mApkgInfo.getAppConfigInfo().entryPagePath)
      {
        label297:
        InnerShareData.Builder localBuilder = new InnerShareData.Builder();
        if (k == 0) {
          break label869;
        }
        j = 11;
        label314:
        paramRequestEvent = localBuilder.setShareSource(j).setShareTarget(i).setTitle(this.mMiniAppInfo.name).setSummary(str4).setEntryPath(paramRequestEvent).setWebUrl((String)localObject).setTemplateId(str2).setTemplateData(str3).setEntryModel(localEntryModel).setShareChatModel(localShareChatModel).setWithShareTicket(localShareState.withShareTicket).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess);
        if (localShareState.fromShareMenuBtn != 1) {
          break label542;
        }
        if ((!str1.startsWith("http")) && (!str1.startsWith("https"))) {
          break;
        }
        paramRequestEvent.setSharePicPath(str1).build().shareAppMessage();
        return;
      }
      localObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str1);
      if (!StringUtil.isEmpty((String)localObject))
      {
        paramRequestEvent.setSharePicPath((String)localObject).setIsLocalPic(true).build().shareAppMessage();
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("ShareJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      paramRequestEvent.printStackTrace();
      return;
    }
    GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.1(this, paramRequestEvent));
    return;
    label542:
    if ((localShareState.fromShareMenuBtn == 3) || (localShareState.fromShareMenuBtn == 4))
    {
      paramRequestEvent.setSharePicPath(this.mMiniAppInfo.iconUrl).build().shareAppMessage();
      return;
    }
    Object localObject = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
    if (!URLUtil.isHttpUrl(str1))
    {
      if (!URLUtil.isHttpsUrl(str1)) {
        break label881;
      }
      break label875;
      label614:
      if ((TextUtils.isEmpty(str1)) || (!new File(((MiniAppFileManager)localObject).getAbsolutePath(str1)).exists())) {
        break label887;
      }
    }
    label849:
    label852:
    label855:
    label862:
    label869:
    label875:
    label881:
    label887:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((StringUtil.isEmpty(str1)) || ((!bool1) && (!bool2)))
      {
        if (this.mMiniAppContext.isMiniGame())
        {
          paramRequestEvent.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
          QMLog.e("ShareJsPlugin", "shareAppMessageDirectly fail, [isNetworkImageUrl=" + bool1 + "] [isLocalResourceExists=" + bool2 + "] [imageUrl=" + str1 + "], use default share image");
          return;
        }
        if (GetShareState.obtain(this.mMiniAppContext) != null)
        {
          if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot)
          {
            QMLog.e("ShareJsPlugin", "getScreenshot isGettingScreenShot now, return directly !");
            return;
          }
          GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.2(this, paramRequestEvent));
        }
      }
      else
      {
        if ((str1.startsWith("http")) || (str1.startsWith("https")))
        {
          paramRequestEvent.setSharePicPath(str1).build().shareAppMessage();
          return;
        }
        paramRequestEvent.setSharePicPath(((MiniAppFileManager)localObject).getAbsolutePath(str1)).setIsLocalPic(true).build().shareAppMessage();
        return;
        break label297;
        break label214;
        k = 0;
        break;
      }
      return;
      i = 0;
      j = 0;
      break label159;
      j = 12;
      break label314;
      boolean bool1 = true;
      break label614;
      bool1 = false;
      break label614;
    }
  }
  
  @JsEvent({"shareAppMessageDirectly"})
  public void shareAppMessageDirectly(RequestEvent paramRequestEvent)
  {
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp()))
    {
      shareAppMessage(paramRequestEvent);
      return;
    }
    GetShareState.obtain(this.mMiniAppContext).stagingJsonParams = paramRequestEvent.jsonParams;
    this.mShareProxy.showSharePanel(this.mMiniAppContext);
  }
  
  @JsEvent({"shareAppPictureMessage"})
  public void shareAppPictureMessage(RequestEvent paramRequestEvent)
  {
    int i = 3;
    ShareState localShareState;
    int k;
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      j = ((JSONObject)localObject).optInt("shareTarget", -1);
      if (j != 0) {
        break label469;
      }
      i = 0;
      localShareState = GetShareState.obtain(this.mMiniAppContext);
      k = j;
      if ("shareAppPictureMessageDirectly".equals(paramRequestEvent.event))
      {
        k = i;
        if (i == -1)
        {
          j = this.mShareProxy.getDefaultShareTarget();
          if (!MoreItem.isValidExtendedItemId(j)) {
            break label504;
          }
          k = 6;
        }
        label85:
        localShareState.fromShareMenuBtn = k;
        k = j;
      }
      i = localShareState.fromShareMenuBtn;
      localShareState.shareEvent = paramRequestEvent.event;
      localShareState.shareCallbackId = paramRequestEvent.callbackId;
      paramRequestEvent = ((JSONObject)localObject).optString("title");
      localObject = ((JSONObject)localObject).optString("imageUrl");
      if (URLUtil.isHttpUrl((String)localObject)) {
        break label463;
      }
      if (!URLUtil.isHttpsUrl((String)localObject)) {
        break label512;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      Object localObject;
      label157:
      paramRequestEvent.printStackTrace();
      return;
    }
    String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File(str).exists())) {}
    for (int j = 1;; j = 0)
    {
      paramRequestEvent = new InnerShareData.Builder().setShareSource(11).setShareTarget(k).setTitle(this.mMiniAppInfo.name).setSummary(paramRequestEvent).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setShareInMiniProcess(localShareState.isShareInMiniProcess);
      if (i != 0)
      {
        paramRequestEvent.setSharePicPath((String)localObject).build().shareAppPictureMessage(this.mMiniAppContext);
        return;
      }
      label463:
      label468:
      label469:
      do
      {
        if (MoreItem.isValidExtendedItemId(j))
        {
          i = 6;
          break;
          if ((StringUtil.isEmpty((String)localObject)) || ((i == 0) && (j == 0)))
          {
            if (this.mMiniAppContext.isMiniGame())
            {
              if (this.mMiniAppInfo != null)
              {
                paramRequestEvent.setSharePicPath(this.mMiniAppInfo.iconUrl).build().shareAppPictureMessage(this.mMiniAppContext);
                return;
              }
              QMLog.e("ShareJsPlugin", "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
              return;
            }
            localShareState = GetShareState.obtain(this.mMiniAppContext);
            if (localShareState == null) {
              break label468;
            }
            if (localShareState.isGettingScreenShot)
            {
              QMLog.e("ShareJsPlugin", "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
              return;
            }
            GetScreenshot.obtain(this.mMiniAppContext, new ShareJsPlugin.3(this, paramRequestEvent));
            return;
          }
          if ((i != 0) || (j == 0)) {
            break label468;
          }
          paramRequestEvent.setSharePicPath(str).setIsLocalPic(true).build().shareAppPictureMessage(this.mMiniAppContext);
          return;
        }
        i = -1;
        break;
        i = 1;
        break label157;
        return;
        if (j == 1)
        {
          i = 1;
          break;
        }
        if (j == 2)
        {
          i = 0;
          break;
        }
        if (j == 3) {
          break;
        }
      } while (j != 4);
      i = 4;
      break;
      label504:
      k = 0;
      j = 0;
      break label85;
      label512:
      i = 0;
      break label157;
    }
  }
  
  @JsEvent({"shareAppPictureMessageDirectly"})
  public void shareAppPictureMessageDirectly(RequestEvent paramRequestEvent)
  {
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp()))
    {
      shareAppPictureMessage(paramRequestEvent);
      return;
    }
    this.mShareProxy.showSharePanel(this.mMiniAppContext);
  }
  
  @JsEvent({"shareInvite"})
  public void shareInvite(RequestEvent paramRequestEvent)
  {
    new InnerShareData.Builder().setShareSource(11).setShareTarget(7).setTemplateId("657667B4D8C04B3F84E4AAA3D046A903").setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachedActivity()).setEvent(paramRequestEvent.event).setCallbackId(paramRequestEvent.callbackId).build().shareAppMessage();
  }
  
  @JsEvent({"showActionSheet"})
  public void showActionSheet(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ShareJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"showShareMenu", "showShareMenuWithShareTicket"})
  public void showShareMenu(RequestEvent paramRequestEvent)
  {
    boolean bool3 = false;
    int n;
    Object localObject;
    if ((paramRequestEvent.jsonParams == null) || ("null".equals(paramRequestEvent.jsonParams)) || ("{}".equals(paramRequestEvent.jsonParams)))
    {
      i = 1;
      n = 1;
      k = 1;
      j = 1;
      bool1 = false;
      localObject = GetShareState.obtain(this.mMiniAppContext);
      if (j != 1) {
        break label431;
      }
      bool2 = true;
      label66:
      ((ShareState)localObject).withShareQQ = bool2;
      if (k != 1) {
        break label437;
      }
      bool2 = true;
      label82:
      ((ShareState)localObject).withShareQzone = bool2;
      if (n != 1) {
        break label443;
      }
    }
    label267:
    label283:
    label431:
    label437:
    label443:
    for (bool2 = true;; bool2 = false)
    {
      ((ShareState)localObject).withShareWeChatFriend = bool2;
      bool2 = bool3;
      if (i == 1) {
        bool2 = true;
      }
      ((ShareState)localObject).withShareWeChatMoment = bool2;
      ((ShareState)localObject).withShareOthers = true;
      ((ShareState)localObject).withShareTicket = bool1;
      paramRequestEvent.ok();
      return;
      for (;;)
      {
        int i3;
        for (;;)
        {
          int m;
          try
          {
            localObject = new JSONObject(paramRequestEvent.jsonParams);
            bool2 = ((JSONObject)localObject).optBoolean("withShareTicket", false);
          }
          catch (JSONException localJSONException1)
          {
            String str;
            int i1;
            int i2;
            label341:
            m = -1;
            k = -1;
            j = -1;
            bool1 = false;
            i = -1;
          }
          try
          {
            localObject = (JSONArray)((JSONObject)localObject).opt("showShareItems");
            if (localObject == null)
            {
              i = 1;
              n = 1;
              k = 1;
              j = 1;
              bool1 = bool2;
              break;
            }
            n = 0;
            m = -1;
            i = -1;
            k = -1;
            j = -1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              m = -1;
              k = -1;
              j = -1;
              i = -1;
              bool1 = bool2;
            }
          }
        }
        for (;;)
        {
          try
          {
            if (n < ((JSONArray)localObject).length())
            {
              str = ((JSONArray)localObject).getString(n);
              bool1 = str.equalsIgnoreCase("qq");
              if (!bool1) {
                continue;
              }
              j = 1;
            }
          }
          catch (JSONException localJSONException3)
          {
            bool1 = bool2;
            break label400;
            break;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("qzone");
            if (!bool1) {
              continue;
            }
            k = 1;
          }
          catch (JSONException localJSONException4)
          {
            bool1 = bool2;
            break label400;
            break label267;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("wechatFriends");
            if (!bool1) {
              continue;
            }
            i = 1;
          }
          catch (JSONException localJSONException5)
          {
            bool1 = bool2;
            break label400;
            break label283;
          }
          try
          {
            bool1 = str.equalsIgnoreCase("wechatMoment");
            if (bool1) {
              m = 1;
            }
            n += 1;
          }
          catch (JSONException localJSONException6)
          {
            bool1 = bool2;
            break label400;
            i3 = i;
            break label341;
          }
        }
      }
      i1 = j;
      if (j == -1) {
        i1 = 0;
      }
      i2 = k;
      if (k == -1) {
        i2 = 0;
      }
      if (i != -1) {
        break label504;
      }
      i3 = 0;
      n = i3;
      i = m;
      k = i2;
      j = i1;
      bool1 = bool2;
      if (m != -1) {
        break;
      }
      i = 0;
      n = i3;
      k = i2;
      j = i1;
      bool1 = bool2;
      break;
      localJSONException1.printStackTrace();
      QMLog.e("ShareJsPlugin", localJSONException1.getMessage(), localJSONException1);
      paramRequestEvent.fail();
      n = i;
      i = m;
      break;
      bool2 = false;
      break label66;
      bool2 = false;
      break label82;
    }
  }
  
  @JsEvent({"updateShareMenuShareTicket"})
  public void updateShareMenuShareTicket(RequestEvent paramRequestEvent)
  {
    try
    {
      boolean bool = new JSONObject(paramRequestEvent.jsonParams).optBoolean("withShareTicket", false);
      GetShareState.obtain(this.mMiniAppContext).withShareTicket = bool;
      paramRequestEvent.ok();
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("ShareJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */