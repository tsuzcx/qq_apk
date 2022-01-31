package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class EmojiUiPlugin
  extends VasWebviewUiPlugin
  implements DialogInterface.OnDismissListener
{
  public static final String tag = "Q.emoji.web.EmojiUiPlugin";
  boolean bNeedGetKey = false;
  protected boolean closeBtnClick = false;
  EmojiUiPlugin.HomePageUrlInfo configUrl = new EmojiUiPlugin.HomePageUrlInfo(this);
  String errorUrl = "";
  String errordescription = "";
  int failcode = 0;
  EmojiUiPlugin.HomePageLoadInfo homePageUrlInfo = new EmojiUiPlugin.HomePageLoadInfo(this);
  protected int loadmode;
  int mActivityType = 2;
  Client.onRemoteRespObserver mEmojiKeygetOnRemoteResp = new EmojiUiPlugin.1(this);
  protected int mEmomallNewTimeFlag = -1;
  protected String mSelfUin;
  String mSid = "";
  protected int mSrcFromType = 1;
  long openToFinishOrErrorGap = -1L;
  long openToOncreateGap = -1L;
  long openTogetKeyTimeGap = -1L;
  int processStep = 1;
  QQProgressDialog progressDialog;
  
  private void dismissProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new EmojiUiPlugin.7(this));
  }
  
  private void onPayResultCallback(Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("callbackSn");
      Object localObject = paramIntent.getStringExtra("result");
      paramIntent = new JSONObject();
      paramIntent.put("result", 0);
      paramIntent.put("message", "ok");
      paramIntent.put("data", new JSONObject((String)localObject));
      localObject = new JSONObject();
      ((JSONObject)localObject).put("responseId", str);
      ((JSONObject)localObject).put("responseData", paramIntent);
      paramIntent = ((JSONObject)localObject).toString();
      this.mRuntime.a().loadUrl("javascript:qqJSBridge.setMessage('" + paramIntent + "')");
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
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
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "queryEmojiInfo resp to js:" + localJSONObject1.toString());
      }
      paramString1 = new JSONObject();
      paramString1.put("responseId", paramString2);
      paramString1.put("responseData", localJSONObject1);
      paramString1 = paramString1.toString();
      this.mRuntime.a().loadUrl("javascript:qqJSBridge.setMessage('" + paramString1 + "')");
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void showGetKeyErrorDialog()
  {
    QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = DialogUtil.a(this.activity, 230).a(this.activity.getString(2131364096)).b(this.activity.getString(2131364095)).a(this.activity.getString(2131362802), new EmojiUiPlugin.5(this));
    localQQCustomDialogThreeBtns.setOnDismissListener(this);
    localQQCustomDialogThreeBtns.setCanceledOnTouchOutside(false);
    localQQCustomDialogThreeBtns.show();
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new EmojiUiPlugin.6(this));
  }
  
  void OnActivityCreate()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    super.OnActivityCreate();
    this.activity.setTheme(2131624266);
    this.mSelfUin = getInfoIntent().getExtras().getString("selfuin");
    this.mSid = getInfoIntent().getExtras().getString("emojimall_sid");
    boolean bool3 = getInfoIntent().getExtras().getBoolean("emojimall_qFace", false);
    this.openToOncreateGap = (System.currentTimeMillis() - this.startOpenPageTime);
    this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
    this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt("emomall_new_time", -1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "emojiactivity oncreate");
    }
    WebIPCOperator.getInstance().registerObserver(this.mEmojiKeygetOnRemoteResp);
    Object localObject;
    String str;
    if ((this.mActivityType == 1) || (this.mActivityType == 3)) {
      if ((this.mSrcFromType == 8) || (this.mSrcFromType == 4)) {
        if (!TextUtils.isEmpty(this.configUrl.detail))
        {
          this.homePageUrlInfo.homePageUrl = this.configUrl.detail;
          this.homePageUrlInfo.isNeedKey = this.configUrl.detailSession;
          localObject = (TicketManager)this.mRuntime.a().getManager(2);
          str = this.mRuntime.a().getAccount();
          if ((!TextUtils.isEmpty(this.mSid)) || (!this.homePageUrlInfo.isNeedKey)) {
            break label595;
          }
          this.bNeedGetKey = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "oncreate -> get sid && skey");
          }
          showProgressDialog();
          this.mSid = ((TicketManager)localObject).getSid(str);
          localObject = ((TicketManager)localObject).getSkey(str);
          dismissProgressDialog();
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.mSid))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              bool1 = loadHomePage(this.homePageUrlInfo, this.mSid);
            }
          }
          if (!bool1) {
            showGetKeyErrorDialog();
          }
        }
      }
    }
    label900:
    label903:
    for (;;)
    {
      uiSetCallBack();
      return;
      if (bool3) {}
      for (this.homePageUrlInfo.homePageUrl = "http://imgcache.qq.com/club/themes/mobile/bq/html/qFaceDetail.html?id=[id]&type=[type]&uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=3";; this.homePageUrlInfo.homePageUrl = "http://imgcache.qq.com/club/themes/mobile/bq/html/detail.html?id=[id]&type=[type]&uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=3")
      {
        this.homePageUrlInfo.isNeedKey = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
        break;
      }
      if (this.mSrcFromType == 5)
      {
        this.homePageUrlInfo.homePageUrl = "http://imgcache.qq.com/club/themes/mobile/bq/html/author.html?id=[id]&type=[type]&uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=3";
        this.homePageUrlInfo.isNeedKey = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
        break;
      }
      if (this.mSrcFromType == 6)
      {
        getConfigUrl(this.mSrcFromType);
        if (!TextUtils.isEmpty(this.configUrl.index))
        {
          this.homePageUrlInfo.homePageUrl = this.configUrl.index;
          this.homePageUrlInfo.isNeedKey = this.configUrl.indexSession;
          break;
        }
        this.homePageUrlInfo.homePageUrl = "http://imgcache.qq.com/club/themes/mobile/bq/html/index.html?uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&_bid=102&_wv=1027";
        this.homePageUrlInfo.isNeedKey = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
        break;
      }
      if (!TextUtils.isEmpty(this.configUrl.index))
      {
        this.homePageUrlInfo.homePageUrl = this.configUrl.index;
        this.homePageUrlInfo.isNeedKey = this.configUrl.indexSession;
        break;
      }
      this.homePageUrlInfo.homePageUrl = "http://imgcache.qq.com/club/themes/mobile/bq/html/index.html?uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&_bid=102&_wv=1027";
      this.homePageUrlInfo.isNeedKey = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
      break;
      label595:
      if (TextUtils.isEmpty(this.mSid))
      {
        this.bNeedGetKey = true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "oncreate -> get sid");
        }
        showProgressDialog();
        this.mSid = ((TicketManager)localObject).getSid(str);
        dismissProgressDialog();
        if (!TextUtils.isEmpty(this.mSid)) {
          bool1 = loadHomePage(this.homePageUrlInfo, this.mSid);
        }
        if (!bool1) {
          showGetKeyErrorDialog();
        }
      }
      else
      {
        if (this.homePageUrlInfo.isNeedKey)
        {
          this.bNeedGetKey = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "oncreate -> get skey");
          }
          showProgressDialog();
          localObject = ((TicketManager)localObject).getSkey(str);
          dismissProgressDialog();
          if ((TextUtils.isEmpty(this.mSid)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label900;
          }
        }
        for (bool1 = loadHomePage(this.homePageUrlInfo, this.mSid);; bool1 = false)
        {
          if (bool1) {
            break label903;
          }
          showGetKeyErrorDialog();
          break;
          if (WebIPCOperator.getInstance().isServiceClientBinded())
          {
            loadHomePage(this.homePageUrlInfo, this.mSid);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "oncreate -> loading url");
            break;
          }
          this.isHomePageWatingBind = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "oncreate -> loadurl waiting binding");
          break;
          str = "";
          localObject = "";
          if (getInfoIntent().getExtras() != null)
          {
            str = getInfoIntent().getExtras().getString("pageUrl");
            localObject = getInfoIntent().getExtras().getString("pageTitle");
          }
          this.activity.setTitle((CharSequence)localObject);
          super.webviewLoadUrl(str);
          break;
        }
      }
    }
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    WebIPCOperator.getInstance().unRegisterObserver(this.mEmojiKeygetOnRemoteResp);
  }
  
  void OnActivityPause()
  {
    super.OnActivityPause();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mRuntime.a();
      CustomWebView.disablePlatformNotifications();
    }
  }
  
  protected boolean checkOncreateParam(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (TextUtils.isEmpty(this.mSelfUin))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "checkOncreateParam activity type:" + this.mActivityType + " selfuin null");
      }
      return false;
    }
    if ((this.mSrcFromType == 8) || (this.mSrcFromType == 4))
    {
      paramIntent = "";
      if (getInfoIntent() != null) {
        paramIntent = getInfoIntent().getStringExtra("emojimall_detail_id");
      }
      if (TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "checkOncreateParam activity type:" + this.mActivityType + "detailid null");
        }
        return false;
      }
    }
    return true;
  }
  
  public void closeAllPage()
  {
    if ((this.closeBtnClick) && ((this.mSrcFromType == 1) || (this.mSrcFromType == 6)))
    {
      this.closeBtnClick = false;
      localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      localIntent.putExtra("back_from_emojimall", true);
      localIntent.setClass(this.activity, ChatActivity.class);
      this.activity.startActivity(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.emoji.web.EmojiUiPlugin", 4, "emojimallbaseactivity closeAllPage to chatactivity");
      }
    }
    while (this.mSrcFromType != 2) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    localIntent.putExtra("back_from_emojimall", true);
    localIntent.setClass(this.activity, EmosmActivity.class);
    this.activity.startActivity(localIntent);
  }
  
  public void doBeforeFinish()
  {
    closeAllPage();
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    switch (paramInt)
    {
    }
    while (paramInt == 21)
    {
      return true;
      if (this.activity != null)
      {
        this.openToFinishOrErrorGap = (System.currentTimeMillis() - this.startOpenPageTime);
        this.processStep = 2;
        continue;
        if (this.activity != null)
        {
          this.openToFinishOrErrorGap = (System.currentTimeMillis() - this.startOpenPageTime);
          this.processStep = 3;
        }
      }
    }
    return false;
  }
  
  protected void getConfigUrl(int paramInt)
  {
    if (paramInt == 6)
    {
      Bundle localBundle = EmoticonUtils.a((BrowserAppInterface)this.activity.getAppRuntime());
      if (localBundle != null)
      {
        this.configUrl.index = localBundle.getString("url");
        if (this.configUrl.index == null) {
          this.configUrl.index = "http://imgcache.qq.com/club/themes/mobile/bq/html/index.html?uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&_bid=102&_wv=1027";
        }
        this.configUrl.indexSession = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "getConfigUrl:index:" + this.configUrl.index + ",detail:" + this.configUrl.detail + "indexsession:" + this.configUrl.indexSession + "detailsession:" + this.configUrl.detailSession);
    }
  }
  
  boolean loadHomePage(EmojiUiPlugin.HomePageLoadInfo paramHomePageLoadInfo, String paramString)
  {
    if ((paramHomePageLoadInfo == null) || (paramString == null)) {}
    do
    {
      return false;
      paramHomePageLoadInfo = new String(paramHomePageLoadInfo.homePageUrl);
    } while (TextUtils.isEmpty(paramHomePageLoadInfo));
    String str1 = "vip.gongneng.mobile.biaoqing.client_tab_store";
    String str2;
    int i;
    if ((this.mSrcFromType == 8) || (this.mSrcFromType == 4))
    {
      str2 = getInfoIntent().getStringExtra("emojimall_detail_id");
      if (TextUtils.isEmpty(str2)) {
        i = 0;
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.mSelfUin)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "getSTWebKey responseclientkey null or mSelfUin:" + this.mSelfUin);
        }
        i = 0;
      }
      if (i == 0) {
        break;
      }
      str1 = paramHomePageLoadInfo.replace("[client]", "androidQQ").replace("[version]", "5.3.1.660").replace("[adtag]", str1).replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
      paramHomePageLoadInfo = str1;
      if (str1.contains("[platformId]")) {
        paramHomePageLoadInfo = str1.replace("[platformId]", "2");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.EmojiUiPlugin", 2, "loadHomePage:" + paramHomePageLoadInfo);
      }
      paramHomePageLoadInfo = paramHomePageLoadInfo.replace("[uin]", this.mSelfUin).replace("[sid]", paramString);
      if (this.mEmomallNewTimeFlag > 0) {}
      for (paramHomePageLoadInfo = paramHomePageLoadInfo.replace("[updateTime]", "" + this.mEmomallNewTimeFlag);; paramHomePageLoadInfo = paramHomePageLoadInfo.replace("[updateTime]", "0"))
      {
        paramString = getInfoIntent();
        webviewLoadUrl(paramHomePageLoadInfo.replace("[updateFlag]", Boolean.valueOf(paramString.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + paramString.getIntExtra("updateId", 0)));
        return true;
        paramHomePageLoadInfo = paramHomePageLoadInfo.replace("[id]", str2).replace("[type]", "view");
        str1 = "vip.gongneng.mobile.biaoqing.client_manager_item";
        i = 1;
        break;
        if ((this.mSrcFromType == 2) || (this.mSrcFromType == 3))
        {
          str1 = "vip.gongneng.mobile.biaoqing.client_manager_top";
          i = 1;
          break;
        }
        if (this.mSrcFromType == 7)
        {
          str1 = "vip.gongneng.mobile.biaoqing.client_index_banner";
          i = 1;
          break;
        }
        if (this.mSrcFromType != 6) {
          break label475;
        }
        str1 = "vip.gongneng.mobile.biaoqing.client_aio_magic";
        i = 1;
        break;
      }
      label475:
      i = 1;
    }
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.EmojiUiPlugin", 2, "onActivityResult request=" + paramInt1 + " result=" + paramInt2);
    }
    Object localObject;
    if ((paramInt1 == 1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localObject = DataFactory.EmojiPayRespData.makeEmojiPayRespData(paramIntent.getExtras());
      paramIntent = DataFactory.EmojiPayReqData.makeEmojiPayReqData(paramIntent.getExtras());
      onPayResultCallback(((DataFactory.EmojiPayRespData)localObject).message, ((DataFactory.EmojiPayRespData)localObject).result, ((DataFactory.EmojiPayRespData)localObject).realSaveNum, ((DataFactory.EmojiPayRespData)localObject).payChannel, ((DataFactory.EmojiPayRespData)localObject).payState, ((DataFactory.EmojiPayRespData)localObject).provideState, paramIntent.callbackid);
    }
    label605:
    for (;;)
    {
      return true;
      if (paramInt1 == 4)
      {
        onPayResultCallback(paramIntent);
      }
      else if (paramInt1 == 5)
      {
        onPayResultCallback(paramIntent);
      }
      else if (paramInt1 == 9)
      {
        onPayResultCallback(paramIntent);
      }
      else if (paramInt1 == 6)
      {
        onPayResultCallback(paramIntent);
      }
      else if (paramInt1 == 8)
      {
        onPayResultCallback(paramIntent);
      }
      else if (paramInt1 == 7)
      {
        onPayResultCallback(paramIntent);
      }
      else
      {
        if ((paramInt1 != 201) || (paramIntent == null) || (paramIntent.getExtras() == null)) {
          break;
        }
        paramInt1 = -1;
        localObject = null;
        if (paramInt2 == -1)
        {
          paramInt1 = 0;
          String str1 = paramIntent.getStringExtra("qFace_name");
          int i = paramIntent.getIntExtra("qFace_type", 0);
          String str2 = paramIntent.getStringExtra("qFace_author");
          localObject = paramIntent.getStringExtra("qFace_material_id");
          String str3 = paramIntent.getStringExtra("qFace_pack_id");
          String str4 = paramIntent.getStringExtra("qFace_md5");
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("qFace_eId_arr");
          paramIntent = paramIntent.getStringArrayListExtra("qFace_shortcut_arr");
          if ((localArrayList != null) && (paramIntent != null) && (localArrayList.size() == paramIntent.size()) && (str4 != null))
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("result", paramInt2);
            localBundle.putString("qFace_name", str1);
            localBundle.putInt("qFace_type", i);
            localBundle.putString("qFace_author", str2);
            localBundle.putString("qFace_material_id", (String)localObject);
            localBundle.putString("qFace_pack_id", str3);
            localBundle.putString("qFace_md5", str4);
            localBundle.putStringArrayList("qFace_eId_arr", localArrayList);
            localBundle.putStringArrayList("qFace_shortcut_arr", paramIntent);
            sendRemoteReq(DataFactory.makeIPCRequestPacket("writeQFaceResult", "", this.mEmojiKeygetOnRemoteResp.key, localBundle), true, false);
          }
        }
        for (;;)
        {
          if (this.activity == null) {
            break label605;
          }
          paramIntent = new HashMap();
          paramIntent.put(EmojiJsPlugin.KEY_DEMOJI_MAKE_RESULT, Integer.valueOf(paramInt1));
          paramIntent.put(EmojiJsPlugin.KEY_DEMOJI_MAKE_ID, localObject);
          this.activity.a().a("", 15, paramIntent);
          break;
          paramInt1 = 3;
          continue;
          if (paramInt2 == 0)
          {
            paramInt1 = 2;
            localObject = paramIntent.getStringExtra("qFace_material_id");
          }
          else if ((paramInt2 == 101) || (paramInt2 == 102))
          {
            paramInt1 = 1;
            localObject = paramIntent.getStringExtra("qFace_material_id");
            paramIntent = new Bundle();
            paramIntent.putInt("result", paramInt2);
            paramIntent.putInt("qFace_type", 0);
            paramIntent.putString("qFace_material_id", (String)localObject);
            sendRemoteReq(DataFactory.makeIPCRequestPacket("writeQFaceResult", "", this.mEmojiKeygetOnRemoteResp.key, paramIntent), true, false);
          }
        }
      }
    }
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.activity.finish();
  }
  
  public void uiSetCallBack()
  {
    this.activity.b(getInfoIntent(), this.homePageUrlInfo.homePageUrl);
    if ((this.mActivityType == 1) && ((this.mSrcFromType == 3) || (this.mSrcFromType == 1) || (this.mSrcFromType == 6))) {
      this.activity.setRightButton(2131364097, new EmojiUiPlugin.2(this));
    }
    for (;;)
    {
      if ((this.mActivityType == 1) && ((this.mSrcFromType == 1) || (this.mSrcFromType == 6))) {
        this.activity.setLeftButton(2131363534, new EmojiUiPlugin.4(this));
      }
      return;
      if ((this.mSrcFromType != 3) && (this.mSrcFromType != 7) && (this.mSrcFromType != 8) && (this.mSrcFromType != 4) && (this.mSrcFromType != 2)) {
        this.activity.setRightButton(2131363534, new EmojiUiPlugin.3(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin
 * JD-Core Version:    0.7.0.1
 */