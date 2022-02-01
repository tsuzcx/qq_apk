package com.tencent.qqmail.popularize;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.popularize.model.PopularizeMoreOperation;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.schema.SchemaUtil;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PopupMenuAdapter;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMPopupWindow.PopupMenuItem;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSApiUitil
{
  public static final String FUNC_APP_INSTALL_JUDGE = "appInstallJudge";
  public static final String FUNC_CLOSE_WEBVIEW = "closeWebView";
  public static final String FUNC_COPY_LINK = "copyLink";
  public static final String FUNC_GET_ADDRESSBOOKCONTACTS = "getAddressBookContacts";
  public static final String FUNC_GET_APP_VERSION = "getAppVersion";
  public static final String FUNC_GET_DEVICE_ID = "getDeviceId";
  public static final String FUNC_GET_EMAIL = "getEmail";
  public static final String FUNC_GET_NET_STATE = "getNetState";
  public static final String FUNC_GET_NICK = "getNick";
  public static final String FUNC_GET_SID = "getSid";
  public static final String FUNC_GET_SYSTEM_VERSION = "getSystemVersion";
  public static final String FUNC_GET_UIN = "getUin";
  public static final String FUNC_GO_TO_URL = "goToUrl";
  public static final String FUNC_LOCAL_LOG = "localLog";
  public static final String FUNC_MORE_OPERATION = "moreOperation";
  public static final String FUNC_OPEN_IN_WECHAT_WEBVIEW = "openInWechatWebView";
  public static final String FUNC_OPEN_WITH_SAFARI = "openWithSafari";
  public static final String FUNC_REFRESH_SKEY = "refreshSkey";
  public static final String FUNC_REFRESH_TOKEN = "refreshToken";
  public static final String FUNC_REFRESH_TOKEN_WITH_UIN = "refreshTokenWithUin";
  public static final String FUNC_SEND_MAIL = "sendmail";
  public static final String FUNC_SHARE_TO_FRIEND = "shareToFriend";
  public static final String FUNC_SHARE_TO_WECHAT_FRIEND = "shareToWechatFriend";
  public static final String FUNC_SHARE_TO_WECHAT_TIMELINE = "shareToWechatTimeLine";
  public static final String FUNC_SHOW_OPTION_MENU = "showOptionMenu";
  private static final String JS_FETCH_QUEUE = "javascript:window.qmailBridge.fetchQueue()";
  private static final String JS_HANDLE_MESSAGE = "javascript:window.qmailBridge.handleMessage(%s)";
  private static final String JS_START_ANIMATION = "javascript:qmailH5AnimationStart()";
  public static final int LOCATION_ACTIONSHEET = 2;
  public static final int LOCATION_CONTENT = 1;
  public static final int LOCATION_NO_CONTENT = -1;
  public static final String POPULARIZE_SENDMAIL_FROM_ACTIONSHEET = "popularize_sendmail_from_actionsheet";
  public static final String POPULARIZE_SENDMAIL_FROM_CONTENT = "popularize_sendmail_from_content";
  private static final String TAG = "JSApiUitil";
  private static final String URL_DISPATCH_MESSAGE = "qqmailapijs://dispatch_message/";
  private static final String URL_PRIVATE_SETRESULT = "qqmailapijs://private/setresult/fetchqueue&";
  private static final String URL_QQMAIL_PREFIX = "qqmailapijs://";
  private static final String[] availableFuncs = { "getSid", "getAppVersion", "getSystemVersion", "appInstallJudge", "goToUrl", "moreOperation", "refreshToken", "refreshSkey", "refreshTokenWithUin", "shareToWechatTimeLine", "shareToWechatFriend", "copyLink", "openWithSafari", "sendmail", "localLog", "closeWebView", "openInWechatWebView", "getNetState", "getAddressBookContacts", "getDeviceId", "shareToFriend", "getEmail", "getNick", "showOptionMenu", "getUin" };
  public static String initJsApiStr = "";
  
  private static void copyLink(Context paramContext, String paramString)
  {
    CommUtils.copyText(paramString);
    QMUIHelper.showToast(paramContext, 2131692337, "");
  }
  
  public static void excuteJavaScript(WebView paramWebView, String paramString)
  {
    if ((paramWebView == null) || (paramString == null) || (paramString.equals("")) || (Build.VERSION.SDK_INT >= 19)) {
      try
      {
        paramWebView.evaluateJavascript(paramString, null);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        paramWebView.loadUrl("javascript:" + paramString);
        return;
      }
    }
    if (paramString.startsWith("javascript:"))
    {
      paramWebView.loadUrl(paramString);
      return;
    }
    paramWebView.loadUrl("javascript:" + paramString);
  }
  
  private static String getAppVersion()
  {
    return AppConfig.getCodeVersionName();
  }
  
  public static String getDeviceId(String paramString)
  {
    return handleJsCallBack(true, CloudProtocolHelper.getDeviceId(), paramString);
  }
  
  private static void getJSApiSendMailContent(String paramString1, String paramString2, String paramString3, JSAPIConentCallback paramJSAPIConentCallback)
  {
    Threads.runInBackground(new JSApiUitil.4(paramString1, paramString2, paramString3, paramJSAPIConentCallback));
  }
  
  public static String getNetState(String paramString)
  {
    String str = "0";
    if (QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance())) {
      if (!QMNetworkUtils.isWifiConnected(QMApplicationContext.sharedInstance())) {
        break label32;
      }
    }
    label32:
    for (str = "2";; str = "1") {
      return handleJsCallBack(true, str, paramString);
    }
  }
  
  private static String getSid()
  {
    String str = null;
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getFirstQQMailAccount();
    if (localQQMailAccount != null) {
      str = localQQMailAccount.getSid();
    }
    return str;
  }
  
  private static String getSystemVersion()
  {
    Object localObject2 = null;
    String str = DeviceUtil.getDeviceInfos().releaseVersion;
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (!str.equals(""))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("systemVersion", str);
        ((JSONObject)localObject1).put("system", "android");
        localObject1 = ((JSONObject)localObject1).toJSONString();
      }
    }
    return localObject1;
  }
  
  private static String getUin()
  {
    String str = null;
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    Account localAccount = localAccountList.getDefaultMailAccount();
    Object localObject = localAccount;
    if (!(localAccount instanceof QQMailAccount)) {
      localObject = localAccountList.getFirstQQMailAccount();
    }
    if (localObject != null) {
      str = ((Account)localObject).getUin();
    }
    return str;
  }
  
  public static String handleApppInstallJudge(String paramString1, String paramString2)
  {
    boolean bool = isApppInstallJudge(paramString1);
    if (bool) {}
    for (paramString1 = "app installed";; paramString1 = "app not install") {
      return handleJsCallBack(bool, paramString1, paramString2);
    }
  }
  
  public static String handleCloseWebView(String paramString)
  {
    return handleJsCallBack(true, "close webView success", paramString);
  }
  
  public static String handleCopyLink(Context paramContext, String paramString1, String paramString2)
  {
    DataCollector.logEvent("Event_Ad_Webview_Content_CopyLink");
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramString1 = JSON.parseObject(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getString("url");
        if (paramString1 != null)
        {
          copyLink(paramContext, paramString1);
          return handleJsCallBack(true, "CopyLink success", paramString2);
        }
      }
    }
    return handleJsCallBack(false, "CopyLink failed", paramString2);
  }
  
  public static String handleGetAppVersion(String paramString)
  {
    String str = getAppVersion();
    if ((str != null) && (!str.equals(""))) {
      return handleJsCallBack(true, str, paramString);
    }
    return handleJsCallBack(false, "get app version error", paramString);
  }
  
  public static String handleGetEmail(String paramString)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localObject == null) {}
    for (localObject = null; (localObject != null) && (!((String)localObject).equals("")); localObject = ((Account)localObject).getEmail()) {
      return handleJsCallBack(true, (String)localObject, paramString);
    }
    return handleJsCallBack(false, "get email error", paramString);
  }
  
  public static String handleGetNick(String paramString)
  {
    String str = AccountManager.shareInstance().getAccountList().getDefaultNickName();
    if ((str != null) && (!str.equals(""))) {
      return handleJsCallBack(true, str, paramString);
    }
    return handleJsCallBack(false, "get nick error", paramString);
  }
  
  public static String handleGetSid(String paramString)
  {
    String str = getSid();
    if ((str != null) && (!str.equals(""))) {
      return handleJsCallBack(true, str, paramString);
    }
    return handleJsCallBack(false, "no qq account", paramString);
  }
  
  public static String handleGetSystemVersion(String paramString)
  {
    String str = getSystemVersion();
    if ((str != null) && (!str.equals(""))) {
      return handleJsCallBack(true, str, paramString);
    }
    return handleJsCallBack(false, "get system version error", paramString);
  }
  
  public static String handleGetUin(String paramString)
  {
    String str = getUin();
    if ((str != null) && (!str.equals(""))) {
      return handleJsCallBack(true, str, paramString);
    }
    return handleJsCallBack(false, "no qq account", paramString);
  }
  
  public static String handleGoToUrl(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = JSON.parseObject(paramString1);
    if (paramString1 != null)
    {
      if (SchemaUtil.handleSchemaAction(paramContext, paramString1.getString("url"), 1, 1)) {
        return handleJsCallBack(true, "go to url success", paramString2);
      }
      return handleJsCallBack(false, "go to url failed", paramString2);
    }
    return handleJsCallBack(false, "go to url failed", paramString2);
  }
  
  public static boolean handleJSRequest(String paramString, JSAPIDelegate paramJSAPIDelegate)
  {
    int i = 0;
    if (paramString.equals("qqmailapijs://dispatch_message/")) {
      paramJSAPIDelegate.executeJavaScript("javascript:window.qmailBridge.fetchQueue()");
    }
    for (;;)
    {
      return true;
      if (paramString.startsWith("qqmailapijs://private/setresult/fetchqueue&")) {}
      try
      {
        paramString = new String(StringExtention.decode(paramString.replace("qqmailapijs://private/setresult/fetchqueue&", "")));
        QMLog.log(4, "JSApiUitil", "decode url " + paramString);
        paramString = JSON.parseArray(paramString);
        if (paramString != null)
        {
          while (i < paramString.size())
          {
            JSONObject localJSONObject = JSON.parseObject(paramString.getString(i));
            if (localJSONObject != null) {
              paramJSAPIDelegate.doTask(localJSONObject.getString("func"), localJSONObject.getString("params"), localJSONObject.getString("callbackId"));
            }
            i += 1;
          }
          return false;
        }
      }
      catch (Exception paramString) {}
    }
    return true;
  }
  
  public static String handleJsCallBack(boolean paramBoolean, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("successOrNot", Boolean.valueOf(paramBoolean));
    if (paramString1 != null)
    {
      localJSONObject.put("params", paramString1);
      if (paramString2 == null) {
        break label69;
      }
    }
    for (;;)
    {
      localJSONObject.put("callbackId", paramString2);
      return String.format("javascript:window.qmailBridge.handleMessage(%s)", new Object[] { localJSONObject.toJSONString() });
      paramString1 = "";
      break;
      label69:
      paramString2 = "";
    }
  }
  
  public static String handleLocalLog(String paramString)
  {
    return handleJsCallBack(true, "local log success", paramString);
  }
  
  public static ArrayList<PopularizeMoreOperation> handleMoreOperation(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = JSON.parseArray(paramString);
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.size())
        {
          Object localObject1 = paramString.getJSONObject(i);
          if (localObject1 != null)
          {
            Object localObject4;
            String str1;
            Object localObject2;
            Object localObject3;
            String str2;
            PopularizeMoreOperation localPopularizeMoreOperation;
            if (((JSONObject)localObject1).containsKey("shareToWechatTimeLine"))
            {
              localObject4 = JSON.parseObject(((JSONObject)localObject1).getString("shareToWechatTimeLine"));
              if (localObject4 != null)
              {
                str1 = ((JSONObject)localObject4).getString("title");
                localObject2 = ((JSONObject)localObject4).getString("imageUrl");
                localObject3 = ((JSONObject)localObject4).getString("abstract");
                str2 = ((JSONObject)localObject4).getString("url");
                localObject4 = ((JSONObject)localObject4).getString("itemName");
                if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
                  PopularizeThumbManager.sharedInstance().loadPopularizeThumb((String)localObject2);
                }
                localPopularizeMoreOperation = new PopularizeMoreOperation();
                localPopularizeMoreOperation.setSharedToWechatTimeline(str1, (String)localObject2, (String)localObject3, str2, (String)localObject4);
                localArrayList.add(localPopularizeMoreOperation);
              }
            }
            if (((JSONObject)localObject1).containsKey("shareToWechatFriend"))
            {
              localObject4 = JSON.parseObject(((JSONObject)localObject1).getString("shareToWechatFriend"));
              if (localObject4 != null)
              {
                str1 = ((JSONObject)localObject4).getString("title");
                localObject2 = ((JSONObject)localObject4).getString("imageUrl");
                localObject3 = ((JSONObject)localObject4).getString("abstract");
                str2 = ((JSONObject)localObject4).getString("url");
                localObject4 = ((JSONObject)localObject4).getString("itemName");
                if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
                  PopularizeThumbManager.sharedInstance().loadPopularizeThumb((String)localObject2);
                }
                localPopularizeMoreOperation = new PopularizeMoreOperation();
                localPopularizeMoreOperation.setSharedToWechatFriend(str1, (String)localObject2, (String)localObject3, str2, (String)localObject4);
                localArrayList.add(localPopularizeMoreOperation);
              }
            }
            if (((JSONObject)localObject1).containsKey("copyLink"))
            {
              localObject2 = JSON.parseObject(((JSONObject)localObject1).getString("copyLink"));
              if (localObject2 != null)
              {
                str1 = ((JSONObject)localObject2).getString("url");
                localObject2 = ((JSONObject)localObject2).getString("itemName");
                localObject3 = new PopularizeMoreOperation();
                ((PopularizeMoreOperation)localObject3).setCopyLink(str1, (String)localObject2);
                localArrayList.add(localObject3);
              }
            }
            if (((JSONObject)localObject1).containsKey("openWithSafari"))
            {
              localObject2 = JSON.parseObject(((JSONObject)localObject1).getString("openWithSafari"));
              if (localObject2 != null)
              {
                str1 = ((JSONObject)localObject2).getString("url");
                localObject2 = ((JSONObject)localObject2).getString("itemName");
                localObject3 = new PopularizeMoreOperation();
                ((PopularizeMoreOperation)localObject3).setOpenWebView(str1, (String)localObject2);
                localArrayList.add(localObject3);
              }
            }
            if (((JSONObject)localObject1).containsKey("sendmail"))
            {
              localObject2 = JSON.parseObject(((JSONObject)localObject1).getString("sendmail"));
              localObject1 = ((JSONObject)localObject2).getString("itemName");
              if (localObject2 != null)
              {
                str1 = ((JSONObject)localObject2).getString("type");
                localObject2 = ((JSONObject)localObject2).getString("content");
                localObject3 = new PopularizeMoreOperation();
                ((PopularizeMoreOperation)localObject3).setSendMail(str1, (String)localObject2, (String)localObject1);
                localArrayList.add(localObject3);
              }
            }
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static String handleOpenWithSafari(Context paramContext, String paramString1, String paramString2)
  {
    DataCollector.logEvent("Event_Ad_Webview_Content_OpenLink");
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramString1 = JSON.parseObject(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getString("url");
        if ((paramString1 != null) && (openWebView(paramContext, paramString1))) {
          return handleJsCallBack(true, "OpenWithSafari success", paramString2);
        }
      }
    }
    return handleJsCallBack(false, "OpenWithSafari failed", paramString2);
  }
  
  public static boolean handleRefreshSkey(String paramString1, String paramString2, JSCallBack paramJSCallBack)
  {
    boolean bool;
    int i;
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramString1 = JSON.parseObject(paramString1);
      if (paramString1 != null)
      {
        String str = paramString1.getString("uin");
        bool = paramString1.getBoolean("reload").booleanValue();
        if (str != null)
        {
          paramString1 = str;
          if (!str.equals("")) {}
        }
        else
        {
          QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getFirstQQMailAccount();
          paramString1 = str;
          if (localQQMailAccount != null) {
            paramString1 = localQQMailAccount.getUin();
          }
        }
        if ((paramString1 != null) && (!paramString1.equals("")))
        {
          paramString1 = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(paramString1);
          if (paramString1 != null)
          {
            paramString1.wtAutoLogin(null);
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramJSCallBack.executeJS(handleJsCallBack(false, "refresh skey no account", paramString2));
      }
      return bool;
      i = 0;
      continue;
      i = 0;
      bool = false;
    }
  }
  
  public static void handleRefreshToken(String paramString, JSCallBack paramJSCallBack)
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getFirstQQMailAccount();
    if (localQQMailAccount != null)
    {
      localQQMailAccount.autoLogin();
      return;
    }
    paramJSCallBack.executeJS(handleJsCallBack(false, "refresh token no account", paramString));
  }
  
  public static void handleRefreshTokenWithUin(String paramString1, String paramString2, JSCallBack paramJSCallBack)
  {
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramString1 = JSON.parseObject(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getString("uin");
        if (paramString1 != null)
        {
          paramString1 = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(paramString1);
          if (paramString1 != null)
          {
            paramString1.autoLogin();
            return;
          }
        }
      }
    }
    paramJSCallBack.executeJS(handleJsCallBack(false, "refresh token with uin no account", paramString2));
  }
  
  public static String handleSelectContacts(long[] paramArrayOfLong, String paramString)
  {
    int i = 0;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      JSONArray localJSONArray = new JSONArray();
      int j = paramArrayOfLong.length;
      while (i < j)
      {
        long l = paramArrayOfLong[i];
        MailContact localMailContact = QMContactManager.sharedInstance().getContactById(l);
        if (localMailContact != null) {
          localJSONArray.add(localMailContact.toContactJson());
        }
        i += 1;
      }
      return handleJsCallBack(true, localJSONArray.toJSONString(), paramString);
    }
    return handleJsCallBack(false, "no contacts", paramString);
  }
  
  public static void handleSendMail(Context paramContext, String paramString1, String paramString2, String paramString3, JSAsyncCallback paramJSAsyncCallback)
  {
    int i;
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      Object localObject = JSON.parseObject(paramString1);
      if (localObject != null)
      {
        paramString1 = ((JSONObject)localObject).getString("type");
        localObject = ((JSONObject)localObject).getString("content");
        Account localAccount = AccountManager.shareInstance().getAccountList().get(0);
        if ((localAccount != null) && (paramString1 != null))
        {
          i = 1;
          getJSApiSendMailContent(paramString1, paramString3, (String)localObject, new JSApiUitil.1(localAccount, paramContext, paramJSAsyncCallback, paramString2));
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramJSAsyncCallback.onError(handleJsCallBack(false, "send mail error", paramString2));
      }
      return;
      i = 0;
    }
  }
  
  public static void handleShareToWx(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, JSAsyncCallback paramJSAsyncCallback)
  {
    String str1;
    String str2;
    if (paramInt1 == 0)
    {
      str1 = "shared to wechat friend success";
      if (paramInt1 != 0) {
        break label133;
      }
      str2 = "can not shared to wechat friend";
    }
    for (;;)
    {
      if ((paramString1 != null) && (!paramString1.equals("")))
      {
        Object localObject = JSON.parseObject(paramString1);
        paramString1 = ((JSONObject)localObject).getString("title");
        String str3 = ((JSONObject)localObject).getString("imageUrl");
        String str4 = ((JSONObject)localObject).getString("abstract");
        localObject = ((JSONObject)localObject).getString("url");
        if ((str3 != null) && (!str3.equals("")))
        {
          PopularizeThumbManager.sharedInstance().loadPopularizeThumbWithCallBack(str3, new JSApiUitil.2(paramContext, paramInt1, (String)localObject, paramString1, str4, str3, paramInt2, paramJSAsyncCallback, str1, paramString2, str2));
          return;
          str1 = "shared to wechat timeline successs";
          break;
          label133:
          str2 = "can not shared to wechat timeline";
          continue;
        }
        if (sharedToWx(paramContext, paramInt1, (String)localObject, paramString1, str4, str3, paramInt2))
        {
          paramJSAsyncCallback.onSuccess(handleJsCallBack(true, str1, paramString2));
          return;
        }
        paramJSAsyncCallback.onError(handleJsCallBack(false, str2, paramString2));
        return;
      }
    }
    paramJSAsyncCallback.onError(handleJsCallBack(false, str2, paramString2));
  }
  
  public static String handleShowOptionMenu(String paramString1, View paramView, String paramString2)
  {
    int i = JSON.parseObject(paramString1).getInteger("type").intValue();
    if (i == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      return handleJsCallBack(true, "show option menu success", paramString2);
      if (i == 0) {
        paramView.setVisibility(0);
      }
    }
  }
  
  public static String handleStartAnimation()
  {
    return "javascript:qmailH5AnimationStart()";
  }
  
  public static void initJsApi(WebView paramWebView)
  {
    if ((initJsApiStr == null) || (initJsApiStr.equals("")))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if ((availableFuncs != null) && (availableFuncs.length > 0))
      {
        String[] arrayOfString = availableFuncs;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localJSONObject2.put(arrayOfString[i], Integer.valueOf(1));
          i += 1;
        }
      }
      localJSONObject1.put("apis", localJSONObject2);
      localJSONObject1.put("ver", AppConfig.getCodeVersionName());
      localJSONObject1.put("os", "android");
      initJsApiStr = "javascript:" + String.format("window[\"__QMB_INFO__\"]=%s;", new Object[] { localJSONObject1.toJSONString() }) + ";window[\"__QMB_INFO_CALL__\"]&&window[\"__QMB_INFO_CALL__\"]();";
    }
    excuteJavaScript(paramWebView, initJsApiStr);
  }
  
  private static boolean isApppInstallJudge(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.equals(""))
      {
        paramString = JSON.parseObject(paramString);
        bool1 = bool2;
        if (paramString != null) {
          bool1 = DeviceUtil.isAppInstalled(paramString.getString("packageName"));
        }
      }
    }
    return bool1;
  }
  
  public static boolean isWhiteList(String paramString)
  {
    boolean bool2 = false;
    paramString = StringExtention.getUrlHost(paramString);
    boolean bool1 = bool2;
    if (paramString != null) {
      if (!paramString.endsWith("qq.com"))
      {
        bool1 = bool2;
        if (!paramString.endsWith("10.6.209.223")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String openInWechatWebView(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramString1 = JSON.parseObject(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getString("url");
        if (paramString1 != null)
        {
          WXEntryActivity.openInWechatWebView(paramContext, paramString1);
          return handleJsCallBack(true, "open in WeChat webView success", paramString2);
        }
      }
    }
    return handleJsCallBack(false, "open in WeChat webView failed", paramString2);
  }
  
  private static boolean openWebView(Context paramContext, String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(paramString);
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramString)
    {
      QMUIHelper.showToast(paramContext, 2131696725, "");
    }
    return false;
  }
  
  private static boolean sharedToWx(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    boolean bool = false;
    if (WXEntryActivity.canShareToWX(paramContext))
    {
      paramContext = new WXWebpageObject();
      paramContext.webpageUrl = paramString1;
      paramContext = new WXMediaMessage(paramContext);
      paramContext.title = paramString2;
      paramContext.description = paramString3;
      paramString1 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(paramString4);
      if (paramString1 != null)
      {
        paramContext.thumbData = WXEntryActivity.bmpToByteArray(paramString1, false);
        QMLog.log(4, "JSApiUitil", "sharedToWx image data " + paramString4);
      }
      QMLog.log(2, "JSApiUitil", "sharedToWx  type " + paramInt1 + ", msg: " + paramContext + ", en: " + paramInt2);
      WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), paramInt1, paramContext, paramInt2);
      bool = true;
    }
    return bool;
  }
  
  public static QMPopupWindow showMoreDialogPopup(Context paramContext, View paramView, ArrayList<PopularizeMoreOperation> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      List localList = QMPopupWindow.praseShareMenuItem(2131886094, paramContext);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        PopularizeMoreOperation localPopularizeMoreOperation = (PopularizeMoreOperation)localIterator.next();
        QMPopupWindow.PopupMenuItem localPopupMenuItem;
        if (localPopularizeMoreOperation.getOperation() == 1)
        {
          localPopupMenuItem = (QMPopupWindow.PopupMenuItem)localList.get(0);
          if ((localPopularizeMoreOperation.getItemName() != null) && (!localPopularizeMoreOperation.getItemName().equals(""))) {
            localPopupMenuItem.setTitle(localPopularizeMoreOperation.getItemName());
          }
          localArrayList.add(localPopupMenuItem);
        }
        else if (localPopularizeMoreOperation.getOperation() == 2)
        {
          localPopupMenuItem = (QMPopupWindow.PopupMenuItem)localList.get(1);
          if ((localPopularizeMoreOperation.getItemName() != null) && (!localPopularizeMoreOperation.getItemName().equals(""))) {
            localPopupMenuItem.setTitle(localPopularizeMoreOperation.getItemName());
          }
          localArrayList.add(localPopupMenuItem);
        }
        else if (localPopularizeMoreOperation.getOperation() == 5)
        {
          localPopupMenuItem = (QMPopupWindow.PopupMenuItem)localList.get(2);
          if ((localPopularizeMoreOperation.getItemName() != null) && (!localPopularizeMoreOperation.getItemName().equals(""))) {
            localPopupMenuItem.setTitle(localPopularizeMoreOperation.getItemName());
          }
          localArrayList.add(localPopupMenuItem);
        }
        else if (localPopularizeMoreOperation.getOperation() == 4)
        {
          localPopupMenuItem = (QMPopupWindow.PopupMenuItem)localList.get(3);
          if ((localPopularizeMoreOperation.getItemName() != null) && (!localPopularizeMoreOperation.getItemName().equals(""))) {
            localPopupMenuItem.setTitle(localPopularizeMoreOperation.getItemName());
          }
          localArrayList.add(localPopupMenuItem);
        }
        else if (localPopularizeMoreOperation.getOperation() == 3)
        {
          localPopupMenuItem = (QMPopupWindow.PopupMenuItem)localList.get(4);
          if ((localPopularizeMoreOperation.getItemName() != null) && (!localPopularizeMoreOperation.getItemName().equals(""))) {
            localPopupMenuItem.setTitle(localPopularizeMoreOperation.getItemName());
          }
          localArrayList.add(localPopupMenuItem);
        }
      }
      paramContext = new JSApiUitil.3(paramContext, paramView, new PopupMenuAdapter(paramContext, localArrayList), paramArrayList, paramString);
      paramContext.showDown();
      return paramContext;
    }
    return null;
  }
  
  static abstract interface JSAPIConentCallback
  {
    public abstract void onError(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
  
  public static abstract interface JSAPIDelegate
  {
    public abstract void doTask(String paramString1, String paramString2, String paramString3);
    
    public abstract void executeJavaScript(String paramString);
  }
  
  public static abstract interface JSAsyncCallback
  {
    public abstract void onError(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
  
  public static abstract interface JSCallBack
  {
    public abstract void executeJS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil
 * JD-Core Version:    0.7.0.1
 */