package com.tencent.mobileqq.activity;

import acln;
import affz;
import afjy;
import afnu;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import anot;
import aqcx;
import aqge;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import vdm;
import vdn;
import vdo;
import vdp;

public class H5MagicPlayerActivity
  extends BaseActivity
{
  public String aNv;
  public boolean aXs;
  String audioFilePath = null;
  acln jdField_b_of_type_Acln = new vdp(this);
  public Emoticon b;
  WebViewClient jdField_b_of_type_ComTencentSmttSdkWebViewClient;
  int bHJ = 0;
  Emoticon c;
  public int loop = -1;
  public SoundPool mSoundPool;
  float oY;
  float oZ;
  float pa;
  public String selfUin;
  public String senderUin;
  SessionInfo sessionInfo;
  Vibrator vibrator;
  WebView webview;
  
  private void aOF()
  {
    if (this.sessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "openRedPacket:sessionInfo = null ");
      }
      return;
    }
    int i = 0;
    if (this.sessionInfo.cZ == 0) {
      i = 1;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("recv_uin", this.sessionInfo.aTl);
        localJSONObject.put("recv_type", i);
        if (!TextUtils.isEmpty("")) {
          localJSONObject.put("session_token", "");
        }
        localJSONObject.put("channel", 1);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Intent localIntent;
          localJSONException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "click HongBao:params=" + localJSONObject.toString());
      }
      localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#mobiao");
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
      super.startActivity(localIntent);
      anot.a(null, "CliOper", "", "", "ep_mall", "0X8005FE5", 0, 0, "", "", "", "");
      return;
      if (this.sessionInfo.cZ == 3000) {
        i = 2;
      } else if (this.sessionInfo.cZ == 1) {
        i = 3;
      }
    }
  }
  
  private void av(JSONObject paramJSONObject)
  {
    long l = 1000L;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("duration"))
        {
          int i = paramJSONObject.getInt("duration");
          l = i;
        }
      }
      catch (Exception paramJSONObject)
      {
        l = 1000L;
        continue;
      }
      if (this.vibrator == null) {
        this.vibrator = ((Vibrator)getSystemService("vibrator"));
      }
      if (this.vibrator != null) {
        this.vibrator.vibrate(l);
      }
      return;
      l = 1000L;
    }
  }
  
  private void aw(JSONObject paramJSONObject)
  {
    ax(paramJSONObject);
    if (TextUtils.isEmpty(this.audioFilePath))
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "audioFilePath = null ");
      }
      return;
    }
    play(this.audioFilePath);
  }
  
  private void ax(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "getAudioFilePath json = null ");
      }
    }
    for (;;)
    {
      return;
      try
      {
        if (paramJSONObject.has("file"))
        {
          str = paramJSONObject.getString("file");
          label35:
          if (!paramJSONObject.has("loop")) {
            break label80;
          }
        }
        label80:
        for (int i = paramJSONObject.getInt("loop");; i = -1)
        {
          this.loop = i;
          if (str != null) {
            break label114;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("H5MagicPlayerActivity", 2, "playAudio fileName = null ");
          return;
          str = null;
          break label35;
        }
      }
      catch (Exception paramJSONObject)
      {
        String str;
        for (;;)
        {
          this.loop = -1;
          paramJSONObject.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "playAudio json error ");
          }
          str = null;
        }
        label114:
        if (this.loop == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "playAudio loop = -1 ");
          }
        }
        else {
          this.audioFilePath = (afnu.bEy.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqDataEmoticon.epId) + str);
        }
      }
    }
  }
  
  private void ay(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramJSONObject.has("message")) {}
        for (paramJSONObject = paramJSONObject.getString("message"); QLog.isColorLevel(); paramJSONObject = "")
        {
          QLog.d("H5MagicPlayerActivity", 2, "log " + paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = "json parse erro";
        }
      }
    }
  }
  
  private void az(JSONObject paramJSONObject)
  {
    int i = -1;
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      if (paramJSONObject.has("click")) {
        i = paramJSONObject.getInt("click");
      }
      anot.a(null, "CliOper", "", "", "ep_mall", "itemclick", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataEmoticon.epId, i + "", "", "");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "reportClick json error");
        }
        paramJSONObject.printStackTrace();
        i = -1;
      }
    }
  }
  
  private void bPJ()
  {
    if (this.mSoundPool != null)
    {
      aqge.m(BaseApplicationImpl.getContext(), false);
      this.mSoundPool.stop(this.bHJ);
      this.mSoundPool.release();
    }
  }
  
  private void bPK()
  {
    this.aXs = false;
    ((SensorManager)getSystemService("sensor")).unregisterListener(this.jdField_b_of_type_Acln);
  }
  
  private void clear()
  {
    this.webview.removeAllViews();
    this.webview.destroy();
    bPJ();
    bPK();
    afjy.a().a().doUnbindService(getApplicationContext());
  }
  
  private void close()
  {
    super.finish();
  }
  
  private void dl(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "magicCalljs sn is empty");
      }
    }
    do
    {
      return;
      paramString1 = "javascript:execGlobalCallback(((0)),((1)))".replace("((0))", paramString1).replace("((1))", paramString2);
      this.webview.loadUrl(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("H5MagicPlayerActivity", 2, "magicCalljs calljs = " + paramString1);
  }
  
  private void initUI()
  {
    this.webview = new WebView(this);
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131377546);
    localFrameLayout.addView(this.webview, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(aqcx.dip2px(this, 24.0F), aqcx.dip2px(this, 24.0F));
    localLayoutParams.setMargins(0, aqcx.dip2px(this, 9.0F), aqcx.dip2px(this, 10.0F), 0);
    localLayoutParams.gravity = 53;
    localButton.setLayoutParams(localLayoutParams);
    localButton.setBackgroundDrawable(getResources().getDrawable(2130848048));
    localButton.setOnClickListener(new vdm(this));
    localFrameLayout.addView(localButton);
    this.webview.setBackgroundColor(0);
    if (this.webview.getBackground() != null) {
      this.webview.getBackground().setAlpha(0);
    }
    this.webview.setScrollBarStyle(33554432);
  }
  
  private void initWebView()
  {
    Object localObject = this.webview.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setAllowContentAccess(true);
    ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
    this.jdField_b_of_type_ComTencentSmttSdkWebViewClient = new vdn(this);
    this.webview.setWebViewClient(this.jdField_b_of_type_ComTencentSmttSdkWebViewClient);
    localObject = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(localObject))) {
      getWindow().addFlags(16777216);
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.webview.removeJavascriptInterface("searchBoxJavaBridge_");
      this.webview.removeJavascriptInterface("accessibility");
      this.webview.removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  private JSONObject n(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      if (!paramString.contains("=")) {
        continue;
      }
      paramString = paramString.split("=");
      if ((paramString == null) || (paramString.length < 2))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("H5MagicPlayerActivity", 2, "jsons = error ");
        return null;
      }
      paramString = paramString[1].split("#");
      if ((paramString == null) || (paramString.length < 2))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("H5MagicPlayerActivity", 2, "jsons # error ");
        return null;
      }
      String str = paramString[0];
      if (str == null) {
        continue;
      }
      try
      {
        paramString = URLDecoder.decode(str, "UTF-8");
        if (paramString == null) {
          continue;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString == null) {
            continue;
          }
          return paramString;
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "Failed to decode json str, josn=" + str);
          }
          paramString = null;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("H5MagicPlayerActivity", 2, "Failed to parse json str,json=");
            }
            paramString = null;
          }
        }
      }
    }
  }
  
  private void play(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "playAudio file dont exist ");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.loop == -1);
      aqge.m(BaseApplicationImpl.getContext(), true);
      if (this.mSoundPool == null) {
        this.mSoundPool = new SoundPool(5, 3, 0);
      }
      this.bHJ = this.mSoundPool.load(localFile.getAbsolutePath(), 1);
      if (this.bHJ != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("H5MagicPlayerActivity", 2, "load failure filepath=" + paramString);
    return;
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.mSoundPool.setOnLoadCompleteListener(new vdo(this, paramString));
      return;
    }
    ThreadManager.getTimer().schedule(new H5MagicPlayerActivity.4(this, paramString), 200L);
  }
  
  private void reply()
  {
    if (this.c != null)
    {
      Object localObject = afnu.bEz.replace("[epId]", this.c.epId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://" + (String)localObject);
      localStringBuilder.append("?sender_uin=" + this.senderUin);
      localStringBuilder.append("&self_uin=" + this.selfUin);
      localStringBuilder.append("&auto_play=0");
      localStringBuilder.append("&platform=android");
      localStringBuilder.append("&version=3.4.4");
      localStringBuilder.append("&start_time=" + System.currentTimeMillis());
      localStringBuilder.append("&width=" + this.oZ);
      localStringBuilder.append("&height=" + this.pa);
      localStringBuilder.append("&pixel_ratio=" + this.oY);
      localObject = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "reply url = " + (String)localObject);
      }
      this.webview.loadUrl((String)localObject);
      if (afjy.a().ajq())
      {
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("emoticon", this.c);
        ((Bundle)localObject).putParcelable("sessionInfo", this.sessionInfo);
        localObject = affz.a("ipc_h5magic_sendmsg", "", -1, (Bundle)localObject);
        afjy.a().cq((Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: childEmotcionEpid = " + this.c.epId);
        }
        this.jdField_b_of_type_ComTencentMobileqqDataEmoticon = this.c;
      }
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "ep_mall", "0X8005FE6", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: service not bind");
      }
      close();
      break;
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "reply childemoticon doesnt exit ");
      }
      close();
    }
  }
  
  private void vL(String paramString)
  {
    this.aNv = paramString;
    this.aXs = true;
    paramString = (SensorManager)getSystemService("sensor");
    paramString.registerListener(this.jdField_b_of_type_Acln, paramString.getDefaultSensor(1), 0);
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public boolean hj(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("jsbridge://")))
    {
      Object localObject1 = paramString.split("/");
      if ((localObject1 == null) || (localObject1.length < 4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "url js error : length < 4 js = " + paramString);
        }
        return false;
      }
      if (!"magicEmotion".equals(localObject1[2]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "objectName is error ");
        }
        return false;
      }
      Object localObject2 = paramString.split("#");
      if ((localObject2 == null) || (localObject2.length < 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "sn error ");
        }
        return false;
      }
      localObject2 = localObject2[1];
      JSONObject localJSONObject = n(paramString);
      CharSequence localCharSequence = localObject1[3];
      if (TextUtils.isEmpty(localCharSequence))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "method error ");
        }
        return false;
      }
      localObject1 = "\\?";
      if (!paramString.contains("?")) {
        localObject1 = "#";
      }
      paramString = localCharSequence.split((String)localObject1);
      if ((paramString == null) || (paramString.length < 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "methods error ");
        }
        return false;
      }
      paramString = paramString[0];
      if ("close".equals(paramString)) {
        close();
      }
      for (;;)
      {
        return true;
        if ("openRedPacket".equals(paramString)) {
          aOF();
        } else if ("reply".equals(paramString)) {
          reply();
        } else if ("reportClick".equals(paramString)) {
          az(localJSONObject);
        } else if ("vibrate".equals(paramString)) {
          av(localJSONObject);
        } else if ("playAudio".equals(paramString)) {
          aw(localJSONObject);
        } else if ("addShakeEventListener".equals(paramString)) {
          vL((String)localObject2);
        } else if ("removeShakeEventListener".equals(paramString)) {
          bPK();
        } else if ("log".equals(paramString)) {
          ay(localJSONObject);
        }
      }
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    super.setContentView(2131562109);
    initUI();
    initWebView();
    if (!afjy.a().ajq()) {
      afjy.a().a().doBindService(getApplicationContext());
    }
    paramBundle = getApplication().getSharedPreferences("h5magic_sp_name", 4);
    if (paramBundle != null) {
      paramBundle.edit().putBoolean("h5magic_sp_isplay_key", true).commit();
    }
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.oY = paramBundle.density;
    this.oZ = (paramBundle.widthPixels / this.oY);
    this.pa = (paramBundle.heightPixels / this.oY);
    Object localObject = super.getIntent();
    long l = ((Intent)localObject).getLongExtra("clickTime", 0L);
    this.sessionInfo = ((SessionInfo)((Intent)localObject).getParcelableExtra("sessionInfo"));
    this.jdField_b_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)((Intent)localObject).getSerializableExtra("emoticon"));
    paramBundle = ((Intent)localObject).getStringExtra("autoPlay");
    this.senderUin = ((Intent)localObject).getStringExtra("senderUin");
    if (((Intent)localObject).hasExtra("childEmoticon")) {
      this.c = ((Emoticon)((Intent)localObject).getSerializableExtra("childEmoticon"));
    }
    this.selfUin = ((Intent)localObject).getStringExtra("selfUin");
    localObject = afnu.bEz.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqDataEmoticon.epId);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://" + (String)localObject);
    localStringBuilder.append("?sender_uin=" + this.senderUin);
    localStringBuilder.append("&self_uin=" + this.selfUin);
    localStringBuilder.append("&auto_play=" + paramBundle);
    localStringBuilder.append("&platform=android");
    localStringBuilder.append("&version=3.4.4");
    localStringBuilder.append("&start_time=" + l);
    localStringBuilder.append("&width=" + this.oZ);
    localStringBuilder.append("&height=" + this.pa);
    localStringBuilder.append("&pixel_ratio=" + this.oY);
    paramBundle = localStringBuilder.toString();
    this.webview.loadUrl(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SharedPreferences localSharedPreferences = getApplication().getSharedPreferences("h5magic_sp_name", 4);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("h5magic_sp_isplay_key", false).commit();
    }
    clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */