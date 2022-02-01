package com.tencent.mobileqq.vaswebviewplugin;

import affz.a;
import affz.b;
import afjy;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import aqha;
import aqkf;
import aqqj;
import aqzl;
import arcd;
import arhz;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public abstract class EmojiUiPlugin
  extends VasWebviewUiPlugin
  implements DialogInterface.OnDismissListener
{
  public static final String tag = "Q.emoji.web.EmojiUiPlugin";
  boolean bNeedGetKey = false;
  protected boolean closeBtnClick;
  HomePageUrlInfo configUrl = new HomePageUrlInfo();
  String errorUrl = "";
  String errordescription = "";
  int failcode = 0;
  HomePageLoadInfo homePageUrlInfo = new HomePageLoadInfo();
  protected int loadmode;
  protected int mActivityType = 2;
  Client.b mEmojiKeygetOnRemoteResp = new EmojiUiPlugin.1(this);
  protected int mEmomallNewTimeFlag = -1;
  protected String mSelfUin;
  String mSid = "";
  protected int mSrcFromType = 1;
  long openToFinishOrErrorGap = -1L;
  long openToOncreateGap = -1L;
  long openTogetKeyTimeGap = -1L;
  int processStep = 1;
  arhz progressDialog;
  
  private void dismissProgressDialog()
  {
    this.mRuntime.getActivity().runOnUiThread(new EmojiUiPlugin.5(this));
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
      this.mRuntime.getWebView().loadUrl("javascript:qqJSBridge.setMessage('" + paramIntent + "')");
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
      this.mRuntime.getWebView().loadUrl("javascript:qqJSBridge.setMessage('" + paramString1 + "')");
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
    aqkf localaqkf = aqha.a(this.activity, 230).a(this.activity.getString(2131693084)).b(this.activity.getString(2131693083)).a(this.activity.getString(2131721079), new EmojiUiPlugin.3(this));
    localaqkf.setOnDismissListener(this);
    localaqkf.setCanceledOnTouchOutside(false);
    localaqkf.show();
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.getActivity().runOnUiThread(new EmojiUiPlugin.4(this));
  }
  
  protected void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.mSelfUin = getInfoIntent().getExtras().getString("selfuin");
    this.mSid = getInfoIntent().getExtras().getString("emojimall_sid");
    getInfoIntent().getExtras().getBoolean("emojimall_qFace", false);
    this.openToOncreateGap = (System.currentTimeMillis() - this.startOpenPageTime);
    this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
    this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt("emomall_new_time", -1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "emojiactivity oncreate");
    }
    afjy.a().a(this.mEmojiKeygetOnRemoteResp);
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    afjy.a().b(this.mEmojiKeygetOnRemoteResp);
  }
  
  protected void OnActivityPause()
  {
    super.OnActivityPause();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mRuntime.getWebView();
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
    if ((this.closeBtnClick) && ((this.mSrcFromType == 1) || (this.mSrcFromType == 6) || (this.mSrcFromType == 9)))
    {
      this.closeBtnClick = false;
      localIntent = new Intent();
      localIntent.addFlags(536870912);
      localIntent.putExtra("back_from_emojimall", true);
      localIntent.setClass(this.activity, SplashActivity.class);
      localIntent = wja.a(localIntent, null);
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
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {
      uiSetCallBack();
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934594L)
      {
        if (this.activity != null)
        {
          this.openToFinishOrErrorGap = (System.currentTimeMillis() - this.startOpenPageTime);
          this.processStep = 2;
        }
      }
      else if ((paramLong == 8589934595L) && (this.activity != null))
      {
        this.openToFinishOrErrorGap = (System.currentTimeMillis() - this.startOpenPageTime);
        this.processStep = 3;
      }
    }
  }
  
  protected void getConfigUrl(int paramInt)
  {
    if (paramInt == 6)
    {
      this.configUrl.index = aqqj.o(this.activity, "magicPlus", "");
      if (this.configUrl.index == null) {
        this.configUrl.index = aqqj.o(this.activity, "emoji", "");
      }
      this.configUrl.indexSession = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "getConfigUrl:index:" + this.configUrl.index + ",detail:" + this.configUrl.detail + "indexsession:" + this.configUrl.indexSession + "detailsession:" + this.configUrl.detailSession);
    }
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.EmojiUiPlugin", 2, "onActivityResult request=" + paramInt1 + " result=" + paramInt2);
    }
    if ((paramInt1 == 1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      affz.b localb = affz.b.a(paramIntent.getExtras());
      paramIntent = affz.a.a(paramIntent.getExtras());
      onPayResultCallback(localb.message, localb.result, localb.realSaveNum, localb.payChannel, localb.payState, localb.provideState, paramIntent.callbackid);
    }
    do
    {
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
        else
        {
          if (paramInt1 != 7) {
            break;
          }
          onPayResultCallback(paramIntent);
        }
      }
    } while ((paramInt1 == 201) && (paramIntent != null) && (paramIntent.getExtras() != null));
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.activity.finish();
  }
  
  public void uiSetCallBack()
  {
    WebViewFragment localWebViewFragment = this.mRuntime.b();
    if (localWebViewFragment != null)
    {
      localWebViewFragment.jdField_a_of_type_Arcd.d(getInfoIntent(), this.homePageUrlInfo.homePageUrl);
      if ((localWebViewFragment.jdField_a_of_type_Aqzl.leftView != null) && (this.mActivityType == 1) && ((this.mSrcFromType == 1) || (this.mSrcFromType == 6)))
      {
        localWebViewFragment.jdField_a_of_type_Aqzl.leftView.setText(2131721059);
        localWebViewFragment.jdField_a_of_type_Aqzl.leftView.setOnClickListener(new EmojiUiPlugin.2(this));
      }
    }
  }
  
  class HomePageLoadInfo
  {
    boolean bUseConfigUrl = false;
    String homePageUrl = "";
    boolean isNeedKey = false;
    
    public HomePageLoadInfo() {}
  }
  
  public class HomePageUrlInfo
  {
    String detail = "";
    boolean detailSession = false;
    String index = "";
    boolean indexSession = false;
    
    public HomePageUrlInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin
 * JD-Core Version:    0.7.0.1
 */