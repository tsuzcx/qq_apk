package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.demoji.DEmojiPluginProxyActivity;
import cooperation.demoji.DEmojiPluginProxyActivityforlowsystem;
import cooperation.demoji.DemojiPluginSplashDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "emoji";
  public static String KEY_CALLABCKID = "callbackid";
  public static String KEY_DEMOJI_MAKE_ID;
  public static String KEY_DEMOJI_MAKE_RESULT;
  public static final String KEY_EMOJIMALL_CLOSE_BACK = "back_from_emojimall";
  public static final String KEY_EMOJIMALL_DETAIL_ID = "emojimall_detail_id";
  public static final String KEY_EMOJIMALL_QFACE = "emojimall_qFace";
  public static final String KEY_EMOJIMALL_SID = "emojimall_sid";
  public static final String KEY_EMOJIMALL_SRC_FROM = "emojimall_src";
  protected static final String KEY_MALL_NEW_TIMESTAMP = "emomall_new_time";
  protected static final String KEY_PAGE_OPEN_TIME = "openpagetime";
  public static final String OBJECT_NAME = "_qqJSBridge_";
  public static final int REQUEST_CODE_QFACE = 201;
  public static final int RESULT_QFACE_LOSSY = 102;
  public static final int RESULT_QFACE_PATH_ERROR = 101;
  public static String TAG = "EmojiJsPlugin";
  private Vector mDownloadingFunctions = new Vector();
  protected int mEmomallNewTimeFlag = -1;
  protected String mSelfUin;
  private String mSid = "";
  protected int mSrcFromType = 1;
  private WebView mWebView;
  private EmojiJsPlugin.MakeDynamicEmojiInfo makeInfo;
  private QQProgressDialog progressDialog;
  
  static
  {
    KEY_DEMOJI_MAKE_RESULT = "makeresultcode";
    KEY_DEMOJI_MAKE_ID = "qFace_material_id";
  }
  
  private void buyEmoji(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString3 = this.mRuntime.a();
    if (paramString3 != null)
    {
      showProgressDialog();
      paramString2 = (TicketManager)paramString3.getManager(2);
      paramString3 = paramString3.getAccount();
      if ((paramString2 != null) && (paramString3 != null))
      {
        paramString2 = paramString2.getSkey(paramString3);
        dismissProgressDialog();
        if (TextUtils.isEmpty(paramString2)) {
          break label86;
        }
        if (!NetworkUtil.e(this.mRuntime.a().getApplicationContext())) {
          onPayResultCallback("net unsupport", 4, 0, -1, -1, -1, paramString1);
        }
      }
    }
    label86:
    while (!QLog.isColorLevel())
    {
      return;
      onPayResultCallback("skey null", 8, 0, -1, -1, -1, paramString1);
      return;
    }
    QLog.e(TAG, 2, "buyEmoji, AppInterface null.");
  }
  
  private void clearDownloadingObservers()
  {
    synchronized (this.mDownloadingFunctions)
    {
      this.mDownloadingFunctions.clear();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "clearDownloadingObservers clear all:");
      }
      return;
    }
  }
  
  private void closePage(int paramInt)
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().finish();
    }
  }
  
  private void dismissProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new EmojiJsPlugin.11(this));
  }
  
  private void getNetwork(String paramString)
  {
    int i = NetworkUtil.a(this.mRuntime.a().getApplicationContext());
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", i);
      localJSONObject1.put("data", localJSONObject2);
      onAppResponse(paramString, localJSONObject1.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void getPerformance(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("clickStart", this.startOpenPageTime);
      localJSONObject2.put("pageStart", this.onPageStartedTime);
      localJSONObject2.put("pageFinish", this.onPageFinishedTime);
      localJSONObject1.put("data", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getPerformance resp to js:" + localJSONObject1.toString());
      }
      onAppResponse(paramString, localJSONObject1.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void getSessionKey(String paramString1, String paramString2)
  {
    int i = -1;
    Object localObject2 = this.mRuntime.a();
    Object localObject1;
    if (localObject2 != null)
    {
      showProgressDialog();
      localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
      localObject2 = ((AppInterface)localObject2).getAccount();
      if ((localObject1 != null) && (localObject2 != null))
      {
        if (!"sid".equals(paramString1)) {
          break label175;
        }
        localObject1 = ((TicketManager)localObject1).getSid((String)localObject2);
        dismissProgressDialog();
        paramString1 = "getsession sid ok";
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label324;
        }
        paramString1 = "getsession sid error";
      }
    }
    for (;;)
    {
      localObject2 = new JSONObject();
      label175:
      do
      {
        try
        {
          ((JSONObject)localObject2).put("result", i);
          ((JSONObject)localObject2).put("message", paramString1);
          ((JSONObject)localObject2).put("data", localObject1);
          onAppResponse(paramString2, ((JSONObject)localObject2).toString());
          return;
        }
        catch (JSONException paramString1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e(TAG, 2, "getSessionKey, sid, onAppResponse exception: " + paramString1.getMessage());
          return;
        }
      } while (!"skey".equals(paramString1));
      localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
      dismissProgressDialog();
      paramString1 = "getsession skey ok";
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString1 = "getsession skey error";
      }
      for (;;)
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("result", i);
          ((JSONObject)localObject2).put("message", paramString1);
          ((JSONObject)localObject2).put("data", localObject1);
          onAppResponse(paramString2, ((JSONObject)localObject2).toString());
          return;
        }
        catch (JSONException paramString1) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(TAG, 2, "getSessionKey, skey, onAppResponse exception: " + paramString1.getMessage());
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(TAG, 2, "getSessionKey, AppInterface null.");
        return;
        i = 0;
      }
      label324:
      i = 0;
    }
  }
  
  private void launchDEmojiApk(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("resource_file_path", EmosmUtils.getQFaceMaterialFolderPath(Integer.toString(paramInt), true));
    localIntent.putExtra("qFace-save-folder", AppConstants.aJ);
    localIntent.putExtra("logindata-ha3", paramArrayOfByte);
    localIntent.putExtra("logindata-sid", paramString);
    localIntent.putExtra("logindata-uni", this.mSelfUin);
    localIntent.putExtra("resource-id", Integer.toString(paramInt));
    paramString = new DemojiPluginSplashDialog(this.mRuntime.a());
    paramArrayOfByte = new IPluginManager.PluginParams(0);
    paramArrayOfByte.jdField_b_of_type_JavaLangString = "DEmoji.apk";
    paramArrayOfByte.d = "DEmoji";
    paramArrayOfByte.jdField_a_of_type_JavaLangString = this.mSelfUin;
    paramArrayOfByte.e = "com.tencent.qqpicshow.ui.activity.CameraActivity";
    if (Build.VERSION.SDK_INT > 8) {}
    for (paramArrayOfByte.jdField_a_of_type_JavaLangClass = DEmojiPluginProxyActivity.class;; paramArrayOfByte.jdField_a_of_type_JavaLangClass = DEmojiPluginProxyActivityforlowsystem.class)
    {
      paramArrayOfByte.jdField_a_of_type_AndroidContentIntent = localIntent;
      paramArrayOfByte.jdField_b_of_type_Int = 201;
      paramArrayOfByte.jdField_a_of_type_AndroidAppDialog = paramString;
      paramArrayOfByte.c = 20000;
      paramArrayOfByte.jdField_a_of_type_Boolean = false;
      paramArrayOfByte.f = BaseApplicationImpl.getContext().getString(2131559334);
      IPluginManager.a(this.mRuntime.a(), paramArrayOfByte);
      return;
    }
  }
  
  private void makeDynamicEmoji(String paramString, int paramInt)
  {
    this.makeInfo = new EmojiJsPlugin.MakeDynamicEmojiInfo(this, paramString, paramInt);
    if (((this.mRuntime.a() instanceof QQBrowserActivity)) && (((QQBrowserActivity)this.mRuntime.a()).isResume()))
    {
      Object localObject = this.mRuntime.a();
      if (localObject != null)
      {
        showProgressDialog();
        paramString = (TicketManager)((AppInterface)localObject).getManager(2);
        localObject = ((AppInterface)localObject).getAccount();
        if ((paramString != null) && (localObject != null))
        {
          String str = paramString.getA2((String)localObject);
          this.mSid = paramString.getSid((String)localObject);
          dismissProgressDialog();
          if ((str == null) || (str.length() <= 0) || (TextUtils.isEmpty(this.mSid))) {
            break label158;
          }
          if (this.makeInfo != null)
          {
            paramString = HexUtil.a(str);
            launchDEmojiApk(this.makeInfo.emoPackId, this.mSid, paramString);
          }
        }
      }
    }
    label158:
    do
    {
      do
      {
        return;
        paramString = DialogUtil.a(this.mRuntime.a(), 230).a(this.mRuntime.a().getString(2131562233)).b(this.mRuntime.a().getString(2131562068)).a(this.mRuntime.a().getString(2131562539), new EmojiJsPlugin.8(this));
        paramString.setOnDismissListener(new EmojiJsPlugin.9(this));
        paramString.setCanceledOnTouchOutside(false);
        paramString.show();
        return;
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "makeDynamicEmoji, AppInterface null.");
      return;
      respMakeDynamicEmoji(4, Integer.toString(paramInt));
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "makeDynamicEmoji -> isVisiable:false");
  }
  
  private void onPayResultCallback(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("result", paramInt1);
      localJSONObject1.put("message", paramString1);
      localJSONObject2.put("realSaveNum", paramInt2);
      localJSONObject2.put("payChannel", paramInt3);
      localJSONObject2.put("payState", paramInt4);
      localJSONObject2.put("provideState", paramInt5);
      localJSONObject1.put("data", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "queryEmojiInfo resp to js:" + localJSONObject1.toString());
      }
      onAppResponse(paramString2, localJSONObject1.toString());
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void openPage(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = this.mRuntime.a();
        if (localObject != null)
        {
          showProgressDialog();
          paramString1 = (TicketManager)((AppInterface)localObject).getManager(2);
          localObject = ((AppInterface)localObject).getAccount();
          if ((paramString1 == null) || (localObject == null)) {
            break label100;
          }
          paramString1 = paramString1.getSkey((String)localObject);
          dismissProgressDialog();
          if (TextUtils.isEmpty(paramString1)) {
            break label83;
          }
          openSubPage(paramString2, paramString3);
        }
      }
      label83:
      label100:
      while (!QLog.isColorLevel())
      {
        do
        {
          Object localObject;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.w(TAG, 2, "Open page failed, skey null");
          return;
        } while (!QLog.isColorLevel());
        QLog.w(TAG, 2, "Open page failed, ticketmanager or uin null");
        return;
      }
      QLog.w(TAG, 2, "Open page failed, pageUrl null");
      return;
    }
    openSubPage(paramString2, paramString3);
  }
  
  private void openSubPage(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = getInfoIntent().getExtras().getString("key_emojimall_detail_chat_uin");
    int i = getInfoIntent().getExtras().getInt("key_emojimall_detail_chat_type");
    Intent localIntent = new Intent();
    localIntent.putExtra("emojimall_src", this.mSrcFromType);
    localIntent.putExtra("selfuin", this.mSelfUin);
    localIntent.putExtra("pageUrl", paramString1);
    localIntent.putExtra("pageTitle", paramString2);
    localIntent.putExtra("key_emojimall_detail_chat_uin", str);
    localIntent.putExtra("key_emojimall_detail_chat_type", i);
    localIntent.putExtra("openpagetime", System.currentTimeMillis());
    localIntent.putExtra("emojimall_sid", this.mSid);
    localIntent.putExtra("emomall_new_time", this.mEmomallNewTimeFlag);
    localIntent.putExtra("reqType", 6);
    VasWebviewUtil.a(this.mRuntime.a(), null, 8L, localIntent, false, -1);
  }
  
  private void queryEmojiInfo(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString2);
    localBundle.putInt("businessType", paramInt);
    paramString1 = DataFactory.makeIPCRequestPacket("queryEmojiInfo", paramString1, this.mOnRemoteResp.key, localBundle);
    WebIPCOperator.getInstance().sendServiceIpcReq(paramString1);
  }
  
  private void queryEmojiInfos(String paramString)
  {
    paramString = DataFactory.makeIPCRequestPacket("queryEmojiInfos", paramString, this.mOnRemoteResp.key, new Bundle());
    WebIPCOperator.getInstance().sendServiceIpcReq(paramString);
  }
  
  private void respMakeDynamicEmoji(int paramInt, String paramString)
  {
    if (((paramString == null) || (this.makeInfo == null) || (!paramString.equals(Integer.toString(this.makeInfo.emoPackId)))) && (paramInt != 4)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("result", paramInt);
      onAppResponse(this.makeInfo.callbackid, paramString.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void sendEmojiToFriend(int paramInt)
  {
    try
    {
      Object localObject = getInfoIntent().getExtras().getString("key_emojimall_detail_chat_uin");
      int i = getInfoIntent().getExtras().getInt("key_emojimall_detail_chat_type");
      ReportController.a(null, "CliOper", "", "", "ep_mall", "Clk_send_detail", 0, 0, "", "", "", paramInt + "");
      if (((this.mSrcFromType == 1) || (this.mSrcFromType == 8)) && (localObject != null))
      {
        localBundle = new Bundle();
        localBundle.putString("uin", (String)localObject);
        localBundle.putInt("uintype", i);
        localBundle.putInt("FORWARD_EMOPGK_ID", paramInt);
        localBundle.putBoolean("isBack2Root", true);
        localObject = new Intent(this.mRuntime.a().getApplicationContext(), ChatActivity.class);
        this.mRuntime.a().getSharedPreferences("mobileQQi", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtras(localBundle);
        this.mRuntime.a().startActivity((Intent)localObject);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 14);
      localBundle.putInt("FORWARD_EMOPGK_ID", paramInt);
      localObject = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtras(localBundle);
      this.mRuntime.a().startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, localException.getMessage());
      }
    }
  }
  
  private void showMsgBox(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = paramString4.split("\t");
    if (paramString4.length >= 1)
    {
      paramString2 = DialogUtil.a(this.mRuntime.a(), 230).a(paramString3).b(paramString2).a(paramString4[0], new EmojiJsPlugin.1(this, paramString1));
      if (paramString4.length >= 2) {
        paramString2.b(paramString4[1], new EmojiJsPlugin.2(this, paramString1));
      }
      if (paramString4.length >= 3) {
        paramString2.c(paramString4[2], new EmojiJsPlugin.3(this, paramString1));
      }
      paramString2.setCanceledOnTouchOutside(false);
      paramString2.setOnKeyListener(new EmojiJsPlugin.4(this, paramString2, paramString1));
      paramString2.show();
    }
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new EmojiJsPlugin.10(this));
  }
  
  private void startDownloadEmoji(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (NetworkUtil.e(this.mRuntime.a().getApplicationContext())) {
      if ((!paramBoolean) || (NetworkUtil.b(this.mRuntime.a().getApplicationContext()) == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("id", paramInt1);
        ((Bundle)localObject).putInt("businessType", paramInt2);
        localObject = DataFactory.makeIPCRequestPacket("startDownloadEmoji", paramString, this.mOnRemoteResp.key, (Bundle)localObject);
        addDownloadingStateObserver(new Pair(Integer.valueOf(paramInt1), paramString));
        WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout((Bundle)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "js startDownloadEmoji ,callbackid:" + paramString + "emoPackId" + paramInt1);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "startDownloadEmoji non wifi net");
      }
      localObject = DialogUtil.a(this.mRuntime.a(), 230).a(this.mRuntime.a().getString(2131562442)).b(this.mRuntime.a().getString(2131563236)).a(this.mRuntime.a().getString(2131561749), new EmojiJsPlugin.6(this, paramString)).c(this.mRuntime.a().getString(2131561876), new EmojiJsPlugin.5(this, paramInt1, paramInt2, paramString));
      ((QQCustomDialogThreeBtns)localObject).setOnKeyListener(new EmojiJsPlugin.7(this, (QQCustomDialogThreeBtns)localObject, paramString));
      ((QQCustomDialogThreeBtns)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialogThreeBtns)localObject).show();
      continue;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("result", 5);
        ((JSONObject)localObject).put("message", "no net");
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "startDownloadEmoji resp to js onDownloadingResultSingle:" + ((JSONObject)localObject).toString());
        }
        onAppResponse(paramString, ((JSONObject)localObject).toString());
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      EmosmUtils.showNetEnable(this.mRuntime.a());
    }
  }
  
  private void stopDownloadEmoji(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    paramString = DataFactory.makeIPCRequestPacket("stopDownloadEmoji", paramString, this.mOnRemoteResp.key, localBundle);
    WebIPCOperator.getInstance().sendServiceIpcReq(paramString);
  }
  
  protected void OnActivityCreate()
  {
    this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
    this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt("emomall_new_time", -1);
  }
  
  void addDownloadingStateObserver(Pair paramPair)
  {
    Vector localVector = this.mDownloadingFunctions;
    if (paramPair != null) {}
    try
    {
      if (!this.mDownloadingFunctions.contains(paramPair))
      {
        this.mDownloadingFunctions.add(paramPair);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "addDownloadingStateObserver id:" + paramPair.first + "callbackid:" + (String)paramPair.second);
        }
      }
      return;
    }
    finally {}
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    if (15 == paramInt)
    {
      if (paramMap != null)
      {
        paramString = (String)paramMap.get(KEY_DEMOJI_MAKE_ID);
        respMakeDynamicEmoji(((Integer)paramMap.get(KEY_DEMOJI_MAKE_RESULT)).intValue(), paramString);
      }
      return true;
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483662L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"emoji".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    if (((TextUtils.isEmpty(this.mSelfUin)) || (TextUtils.isEmpty(this.mSid))) && (this.mRuntime.a() != null))
    {
      this.mSelfUin = this.mRuntime.a().getAccount();
      this.mSid = this.mRuntime.a().getSid();
    }
    int i;
    try
    {
      i = paramString1.indexOf("=");
      if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
        throw new Exception("illegal json");
      }
    }
    catch (Throwable paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, paramJsBridgeListener.getMessage());
      }
    }
    for (;;)
    {
      return true;
      paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramString1 = paramJsBridgeListener.getString("callback");
      if (paramString1 == null) {
        throw new Exception("need callbackId");
      }
      if ("demojiremake".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = (String)paramJsBridgeListener.get(KEY_DEMOJI_MAKE_ID);
        respMakeDynamicEmoji(((Integer)paramJsBridgeListener.get(KEY_DEMOJI_MAKE_RESULT)).intValue(), paramString1);
      }
      else
      {
        invoke(paramString3, paramJsBridgeListener.toString(), paramString1);
      }
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (((TextUtils.isEmpty(this.mSelfUin)) || (TextUtils.isEmpty(this.mSid))) && (this.mRuntime.a() != null))
    {
      this.mSelfUin = this.mRuntime.a().getAccount();
      this.mSid = this.mRuntime.a().getSid();
    }
    return handleEmojiSchemaRequest(paramString1, paramString2);
  }
  
  public void invoke(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      WebIPCOperator.getInstance().getClient().doBindService(this.mRuntime.a().getApplicationContext());
    }
    EmojiJsPlugin.JSONWrapper localJSONWrapper;
    int i;
    int j;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        localJSONWrapper = new EmojiJsPlugin.JSONWrapper(paramString2);
        if (paramString1.equals("openPage"))
        {
          openPage(paramString3, localJSONWrapper.getString("pageUrl"), localJSONWrapper.getString("pageTitle"), localJSONWrapper.getBoolean("pageSession", false));
          return;
        }
        if (paramString1.equals("showMsgBox"))
        {
          showMsgBox(paramString3, localJSONWrapper.getString("prompt"), localJSONWrapper.getString("title"), localJSONWrapper.getString("button"));
          return;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (paramString1.equals("buyEmoji"))
      {
        buyEmoji(paramString3, localJSONWrapper.getString("appId"), localJSONWrapper.getString("userId"), localJSONWrapper.getString("userKey"), localJSONWrapper.getString("sessionId"), localJSONWrapper.getString("sessionType"), localJSONWrapper.getString("pf"), localJSONWrapper.getString("pfKey"), localJSONWrapper.getString("zoneId"), localJSONWrapper.getString("tokenUrl"));
        return;
      }
      if (paramString1.equals("queryEmojiInfo"))
      {
        queryEmojiInfo(paramString3, localJSONWrapper.getString("id"), localJSONWrapper.getInt("businessType", 1));
        return;
      }
      if (paramString1.equals("queryEmojiInfos"))
      {
        queryEmojiInfos(paramString3);
        return;
      }
      if (paramString1.equals("startDownloadEmoji"))
      {
        i = localJSONWrapper.getInt("id", 0);
        j = localJSONWrapper.getInt("businessType", 1);
        bool1 = bool2;
        if (paramString2.has("withoutFlowTips")) {
          if (paramString2.getBoolean("withoutFlowTips")) {
            break label565;
          }
        }
      }
    }
    label565:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      startDownloadEmoji(paramString3, i, j, bool1);
      return;
      if (paramString1.equals("sendEmojiToFrd"))
      {
        sendEmojiToFriend(localJSONWrapper.getInt("id", 0));
        return;
      }
      if (paramString1.equals("stopDownloadEmoji"))
      {
        stopDownloadEmoji(paramString3, localJSONWrapper.getInt("id", 0));
        return;
      }
      if (paramString1.equals("closePage"))
      {
        closePage(0);
        return;
      }
      if (paramString1.equals("getPerformance"))
      {
        getPerformance(paramString3);
        return;
      }
      if (paramString1.equals("getSessionKey"))
      {
        getSessionKey(localJSONWrapper.getString("type"), paramString3);
        return;
      }
      if (paramString1.equals("getNetwork"))
      {
        getNetwork(paramString3);
        return;
      }
      if ("makeDynamicEmoji".equals(paramString1))
      {
        makeDynamicEmoji(paramString3, localJSONWrapper.getInt("id", 0));
        return;
      }
      if ("getVipType".equals(paramString1))
      {
        getVipType(paramString2, paramString3);
        return;
      }
      paramString1 = new JSONObject();
      try
      {
        paramString2.put("result", -1);
        paramString2.put("message", "error handler");
        onAppResponse(paramString3, paramString1.toString());
        return;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
    }
  }
  
  public void onAppResponse(String paramString1, String paramString2)
  {
    callJs(paramString1 + "(" + paramString2 + ");");
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mWebView = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    clearDownloadingObservers();
  }
  
  public void onDisconnectWithService()
  {
    onDownloadingResultAll(-1, "service disconnect");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDisconnectWithService");
    }
  }
  
  void onDownloadingResultAll(int paramInt, String paramString)
  {
    synchronized (this.mDownloadingFunctions)
    {
      Iterator localIterator = this.mDownloadingFunctions.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("result", paramInt);
            localJSONObject.put("message", paramString);
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "onDownloadingResultAll startDownloadEmoji resp to js onDownloadingResultall:" + localJSONObject.toString());
            }
            onAppResponse((String)localPair.second, localJSONObject.toString());
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    this.mDownloadingFunctions.clear();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onDownloadingResultAll clear all:");
    }
  }
  
  void onDownloadingResultSingle(int paramInt1, int paramInt2, String paramString)
  {
    Vector localVector = this.mDownloadingFunctions;
    if (paramInt1 > 0)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = new Vector();
        localObject2 = this.mDownloadingFunctions.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Pair)((Iterator)localObject2).next();
          if (((Integer)((Pair)localObject3).first).intValue() == paramInt1) {
            ((Vector)localObject1).add(localObject3);
          }
        }
        localObject1 = ((Vector)localObject1).iterator();
      }
      finally {}
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label288;
        }
        localObject2 = (Pair)((Iterator)localObject1).next();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("result", paramInt2);
          ((JSONObject)localObject3).put("message", paramString);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onDownloadingResultSingle startDownloadEmoji resp to js onDownloadingResultSingle:" + ((JSONObject)localObject3).toString());
          }
          onAppResponse((String)((Pair)localObject2).second, ((JSONObject)localObject3).toString());
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        this.mDownloadingFunctions.remove(localObject2);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "onDownloadingResultSingle remove id:" + ((Pair)localObject2).first + "callbackid:" + (String)((Pair)localObject2).second + "mDownloadingFunctions size:" + this.mDownloadingFunctions.size());
        }
      }
    }
    label288:
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("packetid", -1);
      int j = paramBundle.getInt("resultcode", -1);
      onDownloadingResultSingle(i, j, "");
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onPushMsg + id:" + i + "resultcode:" + j);
      }
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject2;
    String str;
    Object localObject3;
    Object localObject1;
    int k;
    int i;
    int j;
    int m;
    long l;
    int n;
    int i1;
    JSONObject localJSONObject1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject2 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject3 = paramBundle.getBundle("request");
      localObject1 = paramBundle.getBundle("response");
      k = paramBundle.getInt("failcode");
      if (localObject2 != null)
      {
        if (!((String)localObject2).equals("queryEmojiInfo")) {
          break label435;
        }
        i = ((Bundle)localObject1).getInt("result");
        paramBundle = ((Bundle)localObject1).getString("messge");
        j = ((Bundle)localObject1).getInt("status");
        m = ((Bundle)localObject1).getInt("pluginStatus");
        l = ((Bundle)localObject1).getLong("pluginSize");
        n = ((Bundle)localObject1).getInt("progress");
        i1 = ((Bundle)localObject1).getInt("dynamicEmojiId");
        localObject2 = ((Bundle)localObject1).getStringArrayList("dynamicEmojiList");
        localObject1 = ((Bundle)localObject1).getStringArrayList("urlParamsList");
        if (k != 1000)
        {
          i = -1;
          paramBundle = "queryEmojiInfo error";
        }
        localObject3 = new JSONObject();
        localJSONObject1 = new JSONObject();
      }
    }
    label435:
    label997:
    do
    {
      for (;;)
      {
        try
        {
          ((JSONObject)localObject3).put("result", i);
          ((JSONObject)localObject3).put("message", paramBundle);
          localJSONObject1.put("status", j);
          localJSONObject1.put("progress", n);
          localJSONObject1.put("pluginSize", l);
          localJSONObject1.put("pluginStatus", m);
          if (i1 > 0) {
            localJSONObject1.put("dynamicEmojiId", i1);
          }
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            paramBundle = new JSONArray();
            i = 0;
            if (i < ((ArrayList)localObject2).size())
            {
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("src", ((ArrayList)localObject2).get(i));
              localJSONObject2.put("urlParam", ((ArrayList)localObject1).get(i));
              paramBundle.put(localJSONObject2);
              i += 1;
              continue;
            }
            localJSONObject1.put("dynamicEmojiList", paramBundle);
          }
          ((JSONObject)localObject3).put("data", localJSONObject1);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "queryEmojiInfo resp to js:" + ((JSONObject)localObject3).toString());
          }
          onAppResponse(str, ((JSONObject)localObject3).toString());
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        if ("queryEmojiInfos".equals(localObject2))
        {
          i = 0;
          paramBundle = "";
          if (k != 1000)
          {
            i = -1;
            paramBundle = "queryEmojiInfos error";
          }
          localObject2 = new JSONObject();
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("pkgStatusList");
          try
          {
            ((JSONObject)localObject2).put("result", i);
            ((JSONObject)localObject2).put("message", paramBundle);
            if (localObject1 != null)
            {
              paramBundle = new JSONObject();
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Bundle)((Iterator)localObject1).next();
                localJSONObject1 = new JSONObject();
                localJSONObject1.put("status", ((Bundle)localObject3).getInt("status"));
                localJSONObject1.put("progress", ((Bundle)localObject3).getInt("progress"));
                localJSONObject1.put("usable", ((Bundle)localObject3).getInt("flag"));
                i = ((Bundle)localObject3).getInt("dEmojiId");
                if (i > 0) {
                  localJSONObject1.put("dynamicEmojiId", i);
                }
                paramBundle.put(((Bundle)localObject3).getString("id"), localJSONObject1);
              }
              ((JSONObject)localObject2).put("data", paramBundle);
            }
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          onAppResponse(str, ((JSONObject)localObject2).toString());
          return;
        }
        if ("writeQFaceResult".equals(localObject2))
        {
          i = ((Bundle)localObject1).getInt("result", -1);
          paramBundle = ((Bundle)localObject1).getString("messge");
          if (k != 1000)
          {
            i = -1;
            paramBundle = "QFaceResult error";
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoQFace", 2, "write qface result, result:" + i + " msg:" + paramBundle);
          }
        }
        else
        {
          if (!((String)localObject2).equals("startDownloadEmoji")) {
            break;
          }
          n = ((Bundle)localObject1).getInt("result", -1);
          m = ((Bundle)localObject3).getInt("id");
          j = -2147483648;
          if (k == 1000) {
            if (n == 0)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.i(TAG, 2, "startDownloadEmoji resp + addDownloadingStateObserver + id:" + m + "callbackid:" + str);
                i = j;
              }
              j = i;
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startDownloadEmoji resp suc:result:" + n);
              }
            }
          }
          for (j = i;; j = -1)
          {
            if (j == -2147483648) {
              break label997;
            }
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "startDownloadEmoji resp error");
            }
            onDownloadingResultSingle(m, j, "");
            return;
            if (n == 1)
            {
              i = -1;
              break;
            }
            if (n == 3)
            {
              i = 3;
              break;
            }
            i = j;
            if (n != 4) {
              break;
            }
            i = 4;
            break;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "startDownloadEmoji resp error: failcode:" + k);
            }
          }
        }
      }
      if (!((String)localObject2).equals("stopDownloadEmoji")) {
        break label1134;
      }
      i = ((Bundle)localObject1).getInt("result", -1);
      paramBundle = ((Bundle)localObject1).getString("messge");
      if (k != 1000)
      {
        i = 1;
        paramBundle = "startDownloadEmoji error";
      }
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("result", i);
        ((JSONObject)localObject1).put("message", paramBundle);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "stopDownloadEmoji resp to js:" + ((JSONObject)localObject1).toString());
        }
        onAppResponse(str, ((JSONObject)localObject1).toString());
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    } while (k != 1000);
    return;
    label1134:
    super.onResponse(paramBundle);
  }
  
  protected boolean shouldGetBusiness()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin
 * JD-Core Version:    0.7.0.1
 */