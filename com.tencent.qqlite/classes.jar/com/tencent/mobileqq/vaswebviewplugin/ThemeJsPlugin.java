package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeJsPlugin
  extends VasWebviewJsPlugin
{
  private static final int ANIMATION_DURATION = 501;
  private static final String BUSINESS_NAME = "theme";
  public static final String TAG = "ThemeJsPlugin";
  private static final String XM_3 = "Xiaomi_MI 3";
  private BrowserAppInterface app;
  private Context context;
  private String currDownloadingThemeId;
  QQCustomDialog dialog;
  private HashMap downloadThemeMap = new HashMap();
  Bitmap drawingCache;
  boolean isAnimating = false;
  private boolean isDownloadingInProgress = false;
  public Boolean isSwitchTheme = Boolean.valueOf(false);
  View rootView;
  public QQProgressDialog themeSwitchDialog;
  ImageView tmpScreenShot;
  
  private boolean isThemeExist(String paramString1, String paramString2, long paramLong)
  {
    File localFile = new File(ThemeUtil.getThemeDownloadFilePath(this.context, paramString1, paramString2));
    if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() == paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "themeZipFile:" + paramString1 + "," + paramString2 + "," + paramLong + " already exists.");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeJsPlugin", 2, "themeZipFile:" + paramString1 + "," + paramString2 + "," + paramLong + " not exist.");
    }
    return false;
  }
  
  private void reportTheme(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    ((QQBrowserActivity)this.mRuntime.a()).a().postDelayed(new ThemeJsPlugin.1(this, paramString1, paramInt, paramString2, paramLong), 2000L);
  }
  
  protected void doAnimation(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "doAnimation, view is null");
      }
      return;
    }
    this.isAnimating = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
    localAlphaAnimation.setDuration(501L);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    paramView.setAnimation(localAlphaAnimation);
  }
  
  protected void doScreenShot()
  {
    try
    {
      if (this.rootView == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ThemeJsPlugin", 2, "doScreenShot, titleView is null");
        return;
      }
      boolean bool1 = this.rootView.isDrawingCacheEnabled();
      boolean bool2 = this.rootView.willNotCacheDrawing();
      this.rootView.setDrawingCacheEnabled(true);
      this.rootView.setWillNotCacheDrawing(false);
      Object localObject = this.rootView.getDrawingCache();
      if (localObject != null)
      {
        this.drawingCache = Bitmap.createBitmap((Bitmap)localObject);
        this.tmpScreenShot = new ImageView(this.mRuntime.a());
        this.tmpScreenShot.setImageBitmap(this.drawingCache);
        localObject = (ViewGroup)this.mRuntime.a().getWindow().getDecorView().getRootView();
        this.tmpScreenShot.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)localObject).addView(this.tmpScreenShot);
      }
      this.rootView.setDrawingCacheEnabled(bool1);
      this.rootView.setWillNotCacheDrawing(bool2);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "screen shot oom, no animation", localOutOfMemoryError);
        }
        this.drawingCache = null;
        if ((this.tmpScreenShot != null) && (this.tmpScreenShot.getParent() != null)) {
          ((ViewGroup)this.tmpScreenShot.getParent()).removeView(this.tmpScreenShot);
        }
        this.tmpScreenShot = null;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeJsPlugin", 2, "drawingCache is:" + this.drawingCache);
      return;
    }
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    if (17 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "EVENT_THEME_POSTCHANGED");
      }
      onPostThemeChanged();
      return true;
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483680L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"theme".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
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
          QLog.e("ThemeJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
      paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramString1 = paramJsBridgeListener.getString("callback");
      if (paramString1 == null) {
        throw new Exception("need callbackId");
      }
      if ("queryInfo".equals(paramString3))
      {
        queryInfo(paramJsBridgeListener, paramString1);
      }
      else if ("queryLocal".equals(paramString3))
      {
        queryLocal(paramJsBridgeListener, paramString1);
      }
      else if ("setup".equals(paramString3))
      {
        setup(paramJsBridgeListener, paramString1);
      }
      else if ("startDownload".equals(paramString3))
      {
        startDownload(paramJsBridgeListener, paramString1);
      }
      else
      {
        if (!"stopDownload".equals(paramString3)) {
          break;
        }
        stopDownload(paramJsBridgeListener, paramString1);
      }
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  public void handleMessage(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "handleMessage:" + paramInt + " " + paramString1 + " " + paramString2 + " " + paramLong + " ");
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramString2.startsWith(AppConstants.bj)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ThemeJsPlugin", 2, "not download theme file message" + AppConstants.bj);
          return;
          if (paramInt != 2002) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ThemeJsPlugin", 2, "download theme file process");
          }
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            paramString2.downsize = paramLong;
            paramString2.status = "2";
            this.downloadThemeMap.put(this.currDownloadingThemeId, paramString2);
            ThemeUtil.setThemeInfo(this.context, paramString2);
            return;
          }
        } while (this.isDownloadingInProgress != true);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "downloadThemeMap themeInfo is null,themeId=" + this.currDownloadingThemeId);
        }
        this.isDownloadingInProgress = false;
        super.callJsOnError(paramString1, "themeInfo is null");
        return;
        if (paramInt != 2003) {
          break;
        }
        try
        {
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            reportTheme("theme_download", 0, this.currDownloadingThemeId, 0L);
            paramString2.downsize = paramLong;
            paramString2.status = "3";
            this.downloadThemeMap.remove(this.currDownloadingThemeId);
            ThemeUtil.setThemeInfo(this.context, paramString2);
            paramString2 = new JSONObject();
            paramString2.put("result", 0);
            paramString2.put("message", "ok, Theme downloaded.");
            this.isDownloadingInProgress = false;
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            return;
          }
        }
        catch (Exception paramString2)
        {
          this.isDownloadingInProgress = false;
          super.callJsOnError(paramString1, paramString2.getMessage());
          return;
        }
        this.isDownloadingInProgress = false;
        super.callJsOnError(paramString1, "themeInfo is null");
      } while (!QLog.isColorLevel());
      QLog.d("ThemeJsPlugin", 2, "downloadThemeMap themeInfo is null,themeId=" + this.currDownloadingThemeId);
      return;
      if (paramInt == 2005) {
        try
        {
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            reportTheme("theme_download", 2, this.currDownloadingThemeId, 0L);
            paramString2.downsize = paramLong;
            paramString2.status = "4";
            ThemeUtil.setThemeInfo(this.context, paramString2);
            this.downloadThemeMap.remove(this.currDownloadingThemeId);
          }
          paramString2 = new JSONObject();
          paramString2.put("result", -1);
          paramString2.put("message", "recv error");
          this.isDownloadingInProgress = false;
          super.callJs(paramString1 + "(" + paramString2.toString() + ");");
          return;
        }
        catch (Exception paramString2)
        {
          super.callJsOnError(paramString1, paramString2.getMessage());
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeJsPlugin", 2, "" + paramInt);
  }
  
  protected void onCreate()
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.context = this.mRuntime.a().getApplicationContext();
    super.onCreate();
    this.rootView = this.mRuntime.a().getWindow().getDecorView().getRootView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  @SuppressLint({"NewApi"})
  public void onPostThemeChanged()
  {
    if (this.rootView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "titleView is null");
      }
    }
    do
    {
      return;
      String str = Build.MANUFACTURER + "_" + Build.MODEL;
      if ((Build.VERSION.SDK_INT >= 16) && (str.contains("Xiaomi_MI 3"))) {
        this.rootView.setLayerType(1, null);
      }
      if ((this.themeSwitchDialog != null) && (this.themeSwitchDialog.isShowing())) {
        this.themeSwitchDialog.dismiss();
      }
      if (this.drawingCache == null) {
        break;
      }
    } while (this.isAnimating);
    doAnimation(this.tmpScreenShot);
    this.rootView.postDelayed(new ThemeJsPlugin.6(this), 601L);
    return;
    this.isSwitchTheme = Boolean.valueOf(false);
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("status");
    int i = paramBundle.getInt("result");
    Long localLong = Long.valueOf(paramBundle.getLong("readSize"));
    String str1 = paramBundle.getString("callbackId");
    long l = paramBundle.getLong("downloadTime");
    if ("onProgress".equals(str2))
    {
      paramBundle = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
      if (paramBundle != null)
      {
        paramBundle.downsize = localLong.longValue();
        paramBundle.status = "2";
        this.downloadThemeMap.put(this.currDownloadingThemeId, paramBundle);
        ThemeUtil.setThemeInfo(this.context, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, "onProgress, " + localLong);
        }
      }
    }
    while (!"onDone".equals(str2))
    {
      return;
      this.isDownloadingInProgress = false;
      super.callJsOnError(str1, "onProgress, themeInfo is null");
      return;
    }
    paramBundle = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
    if (paramBundle != null)
    {
      this.downloadThemeMap.remove(this.currDownloadingThemeId);
      this.isDownloadingInProgress = false;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "onDone, result=" + i);
      }
      if (i == 3)
      {
        reportTheme("theme_download", 0, this.currDownloadingThemeId, Long.valueOf(l).longValue());
        paramBundle.downsize = localLong.longValue();
        paramBundle.status = "3";
        ThemeUtil.setThemeInfo(this.context, paramBundle);
        super.callJs(str1, new String[] { "{'result':0, 'message':'OK'}" });
        return;
      }
      reportTheme("theme_download", 2, this.currDownloadingThemeId, 0L);
      paramBundle.downsize = localLong.longValue();
      paramBundle.status = "4";
      ThemeUtil.setThemeInfo(this.context, paramBundle);
      super.callJs(str1, new String[] { "{'result':-1, 'message':'Failure'}" });
      return;
    }
    this.isDownloadingInProgress = false;
    super.callJsOnError(str1, "onDone, themeInfo is null");
  }
  
  public void onResponse(Bundle paramBundle)
  {
    int i;
    Object localObject3;
    String str;
    Object localObject4;
    Object localObject1;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("respkey", 0);
      localObject3 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject4 = paramBundle.getBundle("request");
      localObject1 = paramBundle.getBundle("response");
      if (localObject1 != null) {
        break label54;
      }
    }
    label53:
    label54:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (i != this.mOnRemoteResp.key);
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "response:" + (String)localObject3);
          }
        } while (localObject3 == null);
        if (!"startDownloadTheme".equals(localObject3)) {
          break;
        }
      } while (((Bundle)localObject1).getBoolean("StartDownloadResult"));
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "ThemeJsPlugin.onResponse, startDownload error");
      }
      this.isDownloadingInProgress = false;
      super.callJsOnError(str, "startDownload error.");
      return;
      if (!"stopdownload".equals(localObject3)) {
        break label339;
      }
      paramBundle = ((Bundle)localObject4).getString("id");
      localObject3 = new JSONObject();
      if (!((Bundle)localObject1).getBoolean("processor")) {
        break;
      }
      localObject1 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramBundle);
    } while (localObject1 == null);
    ((ThemeUtil.ThemeInfo)localObject1).status = "4";
    ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)localObject1);
    this.downloadThemeMap.remove(paramBundle);
    this.isDownloadingInProgress = false;
    try
    {
      ((JSONObject)localObject3).put("result", 0);
      ((JSONObject)localObject3).put("message", "Download process paused.");
      super.callJs(str + "(" + ((JSONObject)localObject3).toString() + ");");
      reportTheme("theme_download", 1, paramBundle, 0L);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        callJsOnError(str, localJSONException.getMessage());
      }
    }
    super.callJsOnError(str, "stop failure.");
    return;
    label339:
    if ("pausedownload".equals(localObject3))
    {
      paramBundle = ((Bundle)localObject4).getString("currid");
      localObject3 = ((Bundle)localObject4).getString("id");
      localObject4 = ((Bundle)localObject4).getString("version");
      if (localJSONException.getBoolean("processor"))
      {
        localObject2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramBundle);
        ((ThemeUtil.ThemeInfo)localObject2).status = "4";
        ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)localObject2);
        this.downloadThemeMap.remove(paramBundle);
        this.isDownloadingInProgress = false;
      }
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("result", 2);
        ((JSONObject)localObject2).put("message", "pause download themeId= " + paramBundle + ",version=" + (String)localObject4 + ",for start download themeid=" + (String)localObject3);
        super.callJs(str + "(" + ((JSONObject)localObject2).toString() + ");");
        return;
      }
      catch (JSONException paramBundle)
      {
        super.callJsOnError(str, paramBundle.getMessage());
        return;
      }
    }
    super.onResponse(paramBundle);
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    String str;
    ThemeUtil.ThemeInfo localThemeInfo;
    JSONObject localJSONObject2;
    try
    {
      str = paramJSONObject.getString("id");
      localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(str);
      JSONObject localJSONObject1;
      if (localThemeInfo == null)
      {
        localThemeInfo = ThemeUtil.getThemeInfo(this.context, str);
        paramJSONObject = Boolean.valueOf(false);
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "ok");
        localJSONObject2 = new JSONObject();
        if (!str.equals("1000")) {
          break label236;
        }
        localJSONObject2.put("status", Integer.parseInt("3"));
        localJSONObject2.put("version", 0);
        localJSONObject2.put("progress", 100);
      }
      for (;;)
      {
        localJSONObject1.put("data", localJSONObject2);
        super.callJs(paramString + "(" + localJSONObject1.toString() + ");");
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("ThemeJsPlugin", 2, "queryInfo,themeId=" + str + "result=" + localJSONObject1.toString());
        return;
        paramJSONObject = Boolean.valueOf(true);
        break;
        label236:
        if (localThemeInfo != null) {
          break label290;
        }
        localJSONObject2.put("status", Integer.parseInt("1"));
        localJSONObject2.put("version", 0);
        localJSONObject2.put("progress", 0);
      }
      if (!localThemeInfo.status.equals("5")) {
        break label312;
      }
    }
    catch (Throwable paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    label290:
    localThemeInfo.status = "3";
    label312:
    if ((localThemeInfo.status.equals("2")) && (!paramJSONObject.booleanValue()))
    {
      if (isThemeExist(localThemeInfo.themeId, localThemeInfo.version, localThemeInfo.size))
      {
        localThemeInfo.status = "3";
        localThemeInfo.downsize = localThemeInfo.size;
        label373:
        if (QLog.isColorLevel()) {
          QLog.d("ThemeJsPlugin", 2, str + ",queryInfo, modify theme download status to " + localThemeInfo.status);
        }
        ThemeUtil.setThemeInfo(this.context, localThemeInfo);
      }
    }
    else
    {
      localJSONObject2.put("status", Integer.parseInt(localThemeInfo.status));
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "downsize:" + localThemeInfo.downsize + "--size:" + localThemeInfo.size);
      }
      if (localThemeInfo.size <= 0L) {
        break label570;
      }
    }
    label570:
    for (int i = (int)Math.floor(localThemeInfo.downsize * 1.0D / localThemeInfo.size * 100.0D);; i = 0)
    {
      i = Math.min(i, 100);
      localJSONObject2.put("version", localThemeInfo.version);
      localJSONObject2.put("progress", i);
      break;
      localThemeInfo.status = "4";
      break label373;
    }
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal");
    }
    new Thread(new ThemeJsPlugin.2(this, paramString)).start();
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        str2 = paramJSONObject.getString("id");
        if (!paramJSONObject.has("version")) {
          break label480;
        }
        str1 = paramJSONObject.getString("version");
        if (!paramJSONObject.has("showDlgTip")) {
          break label488;
        }
        bool1 = paramJSONObject.getBoolean("showDlgTip");
        if (!paramJSONObject.has("isSound")) {
          break label494;
        }
        i = paramJSONObject.getInt("isSound");
        paramJSONObject = ThemeUtil.getThemeInfo((BaseActivity)this.mRuntime.a(), str2);
        if (paramJSONObject == null) {
          continue;
        }
        if (!paramJSONObject.isVoiceTheme) {
          continue;
        }
        j = 1;
      }
      catch (Throwable paramJSONObject)
      {
        String str2;
        Object localObject;
        callJsOnError(paramString, paramJSONObject.getMessage());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ThemeJsPlugin", 2, paramJSONObject.getMessage());
        return;
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", 2);
        paramJSONObject.put("message", "is switching theme");
        super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
        int j = 0;
        if (j == i) {
          continue;
        }
        if (i != 1) {
          break label499;
        }
        bool2 = true;
        continue;
        return;
      }
      paramJSONObject.isVoiceTheme = bool2;
      ThemeUtil.setThemeInfo((BaseActivity)this.mRuntime.a(), paramJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup,themeId=" + str2 + ",version=" + str1 + ",isSound=" + i);
      }
      localObject = ThemeUtil.getCurrentThemeInfo();
      paramJSONObject = ((Bundle)localObject).getString("themeId");
      localObject = ((Bundle)localObject).getString("version");
      if ((str2.equals(paramJSONObject)) && (str1.equals(localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup the same theme,themeId=" + str2 + ",version=" + str1);
        }
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", 0);
        paramJSONObject.put("message", "set the same theme");
        super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
      if (!this.isSwitchTheme.booleanValue())
      {
        new ThemeJsPlugin.SwitchThemeTask(this, paramString, bool1).execute(new Object[] { str2, str1 });
        return;
      }
      label480:
      String str1 = "0";
      continue;
      label488:
      boolean bool1 = true;
      continue;
      label494:
      int i = 0;
      continue;
      label499:
      boolean bool2 = false;
    }
  }
  
  /* Error */
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc_w 771
    //   11: aload_1
    //   12: ldc_w 773
    //   15: invokevirtual 362	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 778	com/tencent/mobileqq/emosm/EmosmUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 13
    //   23: aload_1
    //   24: ldc_w 650
    //   27: invokevirtual 362	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 11
    //   32: aload_1
    //   33: ldc_w 636
    //   36: invokevirtual 362	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 12
    //   41: aload_1
    //   42: ldc_w 779
    //   45: invokevirtual 736	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   48: istore 5
    //   50: aload_1
    //   51: ldc_w 735
    //   54: invokevirtual 730	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   57: ifeq +183 -> 240
    //   60: aload_1
    //   61: ldc_w 735
    //   64: invokevirtual 736	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   67: istore 4
    //   69: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +63 -> 135
    //   75: ldc 14
    //   77: iconst_2
    //   78: new 118	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 781
    //   88: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 11
    //   93: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 783
    //   99: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 12
    //   104: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 785
    //   110: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload 5
    //   115: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc_w 745
    //   121: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 4
    //   126: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: new 343	org/json/JSONObject
    //   138: dup
    //   139: invokespecial 454	org/json/JSONObject:<init>	()V
    //   142: astore 14
    //   144: invokestatic 789	com/tencent/mobileqq/util/Utils:e	()Z
    //   147: ifne +99 -> 246
    //   150: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 14
    //   158: iconst_2
    //   159: ldc_w 791
    //   162: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 14
    //   167: ldc_w 456
    //   170: bipush 7
    //   172: invokevirtual 459	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   175: pop
    //   176: aload 14
    //   178: ldc_w 461
    //   181: ldc_w 791
    //   184: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload_0
    //   189: new 118	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   196: aload_2
    //   197: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 468
    //   203: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 14
    //   208: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   211: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 471
    //   217: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokespecial 474	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   226: aload_0
    //   227: ldc_w 448
    //   230: iconst_2
    //   231: aload 12
    //   233: lconst_0
    //   234: invokespecial 75	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;J)V
    //   237: aload_0
    //   238: monitorexit
    //   239: return
    //   240: iconst_0
    //   241: istore 4
    //   243: goto -174 -> 69
    //   246: invokestatic 794	com/tencent/mobileqq/util/Utils:b	()J
    //   249: lstore 8
    //   251: lload 8
    //   253: iload 5
    //   255: ldc_w 795
    //   258: iadd
    //   259: i2l
    //   260: lcmp
    //   261: ifge +151 -> 412
    //   264: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +53 -> 320
    //   270: ldc 14
    //   272: iconst_2
    //   273: new 118	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 797
    //   283: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload 5
    //   288: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 799
    //   294: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 795
    //   300: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 801
    //   306: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: lload 8
    //   311: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   314: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 14
    //   322: ldc_w 456
    //   325: iconst_1
    //   326: invokevirtual 459	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload 14
    //   332: ldc_w 461
    //   335: ldc_w 803
    //   338: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   341: pop
    //   342: aload_0
    //   343: ldc_w 448
    //   346: iconst_2
    //   347: aload 12
    //   349: lconst_0
    //   350: invokespecial 75	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;J)V
    //   353: aload_0
    //   354: new 118	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   361: aload_2
    //   362: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 468
    //   368: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 14
    //   373: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   376: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 471
    //   382: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokespecial 474	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   391: goto -154 -> 237
    //   394: astore_1
    //   395: aload_0
    //   396: aload_2
    //   397: aload_1
    //   398: invokevirtual 641	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   401: invokespecial 446	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: goto -167 -> 237
    //   407: astore_1
    //   408: aload_0
    //   409: monitorexit
    //   410: aload_1
    //   411: athrow
    //   412: aload_0
    //   413: getfield 65	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   416: invokestatic 808	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   419: ifne +99 -> 518
    //   422: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +12 -> 437
    //   428: ldc 14
    //   430: iconst_2
    //   431: ldc_w 810
    //   434: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 14
    //   439: ldc_w 456
    //   442: iconst_5
    //   443: invokevirtual 459	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   446: pop
    //   447: aload 14
    //   449: ldc_w 461
    //   452: ldc_w 810
    //   455: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   458: pop
    //   459: aload_0
    //   460: new 118	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   467: aload_2
    //   468: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc_w 468
    //   474: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 14
    //   479: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   482: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc_w 471
    //   488: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokespecial 474	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   497: goto -260 -> 237
    //   500: astore_1
    //   501: aload_0
    //   502: iconst_0
    //   503: putfield 45	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   506: aload_0
    //   507: aload_2
    //   508: aload_1
    //   509: invokevirtual 475	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   512: invokespecial 446	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: goto -278 -> 237
    //   518: aload_0
    //   519: getfield 45	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   522: ifeq +238 -> 760
    //   525: aload_0
    //   526: getfield 50	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   529: aload_0
    //   530: getfield 89	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   533: invokevirtual 419	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   536: checkcast 421	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   539: astore 10
    //   541: aload 12
    //   543: aload_0
    //   544: getfield 89	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   547: if_acmpne +132 -> 679
    //   550: aload 10
    //   552: ifnull +127 -> 679
    //   555: aload 11
    //   557: aload 10
    //   559: getfield 691	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   562: if_acmpne +117 -> 679
    //   565: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +12 -> 580
    //   571: ldc 14
    //   573: iconst_2
    //   574: ldc_w 812
    //   577: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: aload 14
    //   582: ldc_w 456
    //   585: bipush 6
    //   587: invokevirtual 459	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   590: pop
    //   591: aload 14
    //   593: ldc_w 461
    //   596: new 118	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   603: ldc_w 814
    //   606: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 12
    //   611: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: ldc_w 654
    //   617: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload 11
    //   622: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 816
    //   628: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   637: pop
    //   638: aload_0
    //   639: new 118	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   646: aload_2
    //   647: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc_w 468
    //   653: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 14
    //   658: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   661: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 471
    //   667: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokespecial 474	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   676: goto -439 -> 237
    //   679: aload 10
    //   681: ifnull +79 -> 760
    //   684: new 549	android/os/Bundle
    //   687: dup
    //   688: invokespecial 817	android/os/Bundle:<init>	()V
    //   691: astore 15
    //   693: aload 15
    //   695: ldc_w 773
    //   698: aload 10
    //   700: getfield 820	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   703: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: aload 15
    //   708: ldc_w 648
    //   711: aload_0
    //   712: getfield 89	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   715: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload 15
    //   720: ldc_w 636
    //   723: aload 12
    //   725: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   728: aload 15
    //   730: ldc_w 650
    //   733: aload 11
    //   735: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: aload_0
    //   739: ldc_w 646
    //   742: aload_2
    //   743: aload_0
    //   744: getfield 614	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   747: getfield 619	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   750: aload 15
    //   752: invokestatic 829	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   755: iconst_0
    //   756: iconst_1
    //   757: invokespecial 833	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   760: aload_0
    //   761: aload 12
    //   763: aload 11
    //   765: iload 5
    //   767: i2l
    //   768: invokespecial 83	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isThemeExist	(Ljava/lang/String;Ljava/lang/String;J)Z
    //   771: ifeq +202 -> 973
    //   774: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +52 -> 829
    //   780: ldc 14
    //   782: iconst_2
    //   783: new 118	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   790: ldc_w 835
    //   793: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload 12
    //   798: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: ldc_w 654
    //   804: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload 11
    //   809: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: ldc_w 785
    //   815: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: iload 5
    //   820: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: aload_0
    //   830: getfield 65	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   833: aload 12
    //   835: invokestatic 662	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   838: astore 10
    //   840: aload 10
    //   842: astore_1
    //   843: aload 10
    //   845: ifnonnull +11 -> 856
    //   848: new 421	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   851: dup
    //   852: invokespecial 836	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   855: astore_1
    //   856: aload_1
    //   857: iload 5
    //   859: i2l
    //   860: putfield 425	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   863: aload_1
    //   864: iload 5
    //   866: i2l
    //   867: putfield 694	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   870: aload_1
    //   871: aload 12
    //   873: putfield 689	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   876: aload_1
    //   877: aload 11
    //   879: putfield 691	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   882: aload_1
    //   883: ldc_w 450
    //   886: putfield 430	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   889: iload 4
    //   891: iconst_1
    //   892: if_icmpne +541 -> 1433
    //   895: aload_1
    //   896: iload 6
    //   898: putfield 741	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   901: aload_0
    //   902: getfield 65	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   905: aload_1
    //   906: invokestatic 438	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   909: pop
    //   910: aload 14
    //   912: ldc_w 456
    //   915: iconst_3
    //   916: invokevirtual 459	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   919: pop
    //   920: aload 14
    //   922: ldc_w 461
    //   925: ldc_w 838
    //   928: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   931: pop
    //   932: aload_0
    //   933: new 118	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   940: aload_2
    //   941: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: ldc_w 468
    //   947: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: aload 14
    //   952: invokevirtual 469	org/json/JSONObject:toString	()Ljava/lang/String;
    //   955: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 471
    //   961: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: invokespecial 474	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   970: goto -733 -> 237
    //   973: aload_1
    //   974: ldc_w 840
    //   977: invokevirtual 730	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   980: ifeq +464 -> 1444
    //   983: aload_1
    //   984: ldc_w 840
    //   987: invokevirtual 733	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   990: ifne +449 -> 1439
    //   993: iconst_1
    //   994: istore_3
    //   995: aload_0
    //   996: getfield 65	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   999: ldc_w 842
    //   1002: invokevirtual 848	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1005: checkcast 850	android/net/ConnectivityManager
    //   1008: invokevirtual 854	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   1011: astore_1
    //   1012: iload_3
    //   1013: ifeq +152 -> 1165
    //   1016: aload_1
    //   1017: ifnull +148 -> 1165
    //   1020: aload_1
    //   1021: invokestatic 857	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1024: ifeq +141 -> 1165
    //   1027: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1030: ifeq +12 -> 1042
    //   1033: ldc 14
    //   1035: iconst_2
    //   1036: ldc_w 859
    //   1039: invokestatic 299	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1042: aload_0
    //   1043: new 861	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3
    //   1046: dup
    //   1047: aload_0
    //   1048: aload_0
    //   1049: getfield 146	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1052: invokevirtual 152	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1055: ldc_w 862
    //   1058: aload_2
    //   1059: invokespecial 865	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;)V
    //   1062: putfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1065: aload_0
    //   1066: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1069: ldc_w 868
    //   1072: invokevirtual 874	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   1075: aload_0
    //   1076: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1079: ldc_w 876
    //   1082: invokevirtual 880	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1085: pop
    //   1086: aload_0
    //   1087: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1090: ldc_w 881
    //   1093: invokevirtual 885	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1096: pop
    //   1097: aload_0
    //   1098: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1101: iconst_0
    //   1102: invokevirtual 888	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   1105: aload_0
    //   1106: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1109: ldc_w 889
    //   1112: new 891	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   1115: dup
    //   1116: aload_0
    //   1117: aload_2
    //   1118: invokespecial 892	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;)V
    //   1121: invokevirtual 896	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1124: pop
    //   1125: aload_0
    //   1126: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1129: ldc_w 897
    //   1132: new 899	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5
    //   1135: dup
    //   1136: aload_0
    //   1137: aload 12
    //   1139: aload 11
    //   1141: aload 13
    //   1143: iload 5
    //   1145: iload 4
    //   1147: aload_2
    //   1148: invokespecial 902	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   1151: invokevirtual 905	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1154: pop
    //   1155: aload_0
    //   1156: getfield 867	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1159: invokevirtual 908	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1162: goto -925 -> 237
    //   1165: aload_0
    //   1166: getfield 65	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1169: aload 12
    //   1171: aload 11
    //   1173: invokestatic 97	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1176: astore 14
    //   1178: aload_0
    //   1179: iconst_1
    //   1180: putfield 45	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   1183: aload_0
    //   1184: getfield 50	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   1187: aload 12
    //   1189: invokevirtual 419	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1192: checkcast 421	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1195: astore 10
    //   1197: aload 10
    //   1199: astore_1
    //   1200: aload 10
    //   1202: ifnonnull +32 -> 1234
    //   1205: aload_0
    //   1206: getfield 65	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1209: aload 12
    //   1211: invokestatic 662	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   1214: astore 10
    //   1216: aload 10
    //   1218: astore_1
    //   1219: aload 10
    //   1221: ifnull +13 -> 1234
    //   1224: aload 10
    //   1226: aload 13
    //   1228: putfield 820	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1231: aload 10
    //   1233: astore_1
    //   1234: aload_1
    //   1235: ifnull +18 -> 1253
    //   1238: aload_1
    //   1239: astore 10
    //   1241: aload_1
    //   1242: getfield 691	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1245: aload 11
    //   1247: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1250: ifne +72 -> 1322
    //   1253: new 421	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1256: dup
    //   1257: invokespecial 836	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   1260: astore 10
    //   1262: aload 10
    //   1264: aload 12
    //   1266: putfield 689	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1269: aload 10
    //   1271: aload 13
    //   1273: putfield 820	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1276: aload 10
    //   1278: iload 5
    //   1280: i2l
    //   1281: putfield 694	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   1284: aload 10
    //   1286: lconst_0
    //   1287: putfield 425	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1290: aload 10
    //   1292: aload 11
    //   1294: putfield 691	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1297: aload 10
    //   1299: ldc_w 681
    //   1302: putfield 430	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1305: iload 4
    //   1307: iconst_1
    //   1308: if_icmpne +119 -> 1427
    //   1311: iload 7
    //   1313: istore 6
    //   1315: aload 10
    //   1317: iload 6
    //   1319: putfield 741	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   1322: aload_0
    //   1323: getfield 50	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   1326: aload 12
    //   1328: aload 10
    //   1330: invokevirtual 434	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1333: pop
    //   1334: aload_0
    //   1335: aload 12
    //   1337: putfield 89	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   1340: new 549	android/os/Bundle
    //   1343: dup
    //   1344: invokespecial 817	android/os/Bundle:<init>	()V
    //   1347: astore_1
    //   1348: aload_1
    //   1349: ldc_w 773
    //   1352: aload 13
    //   1354: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1357: aload_1
    //   1358: ldc_w 910
    //   1361: aload 14
    //   1363: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1366: aload_1
    //   1367: ldc_w 636
    //   1370: aload 12
    //   1372: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload_1
    //   1376: ldc_w 650
    //   1379: aload 11
    //   1381: invokevirtual 823	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1384: aload_1
    //   1385: ldc_w 779
    //   1388: iload 5
    //   1390: i2l
    //   1391: invokevirtual 914	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1394: aload_1
    //   1395: ldc_w 916
    //   1398: aload 10
    //   1400: invokevirtual 920	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1403: aload_0
    //   1404: ldc_w 623
    //   1407: aload_2
    //   1408: aload_0
    //   1409: getfield 614	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1412: getfield 619	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1415: aload_1
    //   1416: invokestatic 829	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1419: iconst_1
    //   1420: iconst_1
    //   1421: invokespecial 833	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1424: goto -1187 -> 237
    //   1427: iconst_0
    //   1428: istore 6
    //   1430: goto -115 -> 1315
    //   1433: iconst_0
    //   1434: istore 6
    //   1436: goto -541 -> 895
    //   1439: iconst_0
    //   1440: istore_3
    //   1441: goto -446 -> 995
    //   1444: iconst_1
    //   1445: istore_3
    //   1446: goto -451 -> 995
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1449	0	this	ThemeJsPlugin
    //   0	1449	1	paramJSONObject	JSONObject
    //   0	1449	2	paramString	String
    //   994	452	3	i	int
    //   67	1242	4	j	int
    //   48	1341	5	k	int
    //   4	1431	6	bool1	boolean
    //   1	1311	7	bool2	boolean
    //   249	61	8	l	long
    //   539	860	10	localObject1	Object
    //   30	1350	11	str1	String
    //   39	1332	12	str2	String
    //   21	1332	13	str3	String
    //   142	1220	14	localObject2	Object
    //   691	60	15	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   8	69	394	org/json/JSONException
    //   69	135	394	org/json/JSONException
    //   135	165	394	org/json/JSONException
    //   165	237	394	org/json/JSONException
    //   246	251	394	org/json/JSONException
    //   264	320	394	org/json/JSONException
    //   320	391	394	org/json/JSONException
    //   412	437	394	org/json/JSONException
    //   437	497	394	org/json/JSONException
    //   518	550	394	org/json/JSONException
    //   555	580	394	org/json/JSONException
    //   580	676	394	org/json/JSONException
    //   684	760	394	org/json/JSONException
    //   760	829	394	org/json/JSONException
    //   829	840	394	org/json/JSONException
    //   848	856	394	org/json/JSONException
    //   856	889	394	org/json/JSONException
    //   895	970	394	org/json/JSONException
    //   973	993	394	org/json/JSONException
    //   995	1012	394	org/json/JSONException
    //   1020	1042	394	org/json/JSONException
    //   1042	1162	394	org/json/JSONException
    //   1165	1197	394	org/json/JSONException
    //   1205	1216	394	org/json/JSONException
    //   1224	1231	394	org/json/JSONException
    //   1241	1253	394	org/json/JSONException
    //   1253	1305	394	org/json/JSONException
    //   1315	1322	394	org/json/JSONException
    //   1322	1424	394	org/json/JSONException
    //   8	69	407	finally
    //   69	135	407	finally
    //   135	165	407	finally
    //   165	237	407	finally
    //   246	251	407	finally
    //   264	320	407	finally
    //   320	391	407	finally
    //   395	404	407	finally
    //   412	437	407	finally
    //   437	497	407	finally
    //   501	515	407	finally
    //   518	550	407	finally
    //   555	580	407	finally
    //   580	676	407	finally
    //   684	760	407	finally
    //   760	829	407	finally
    //   829	840	407	finally
    //   848	856	407	finally
    //   856	889	407	finally
    //   895	970	407	finally
    //   973	993	407	finally
    //   995	1012	407	finally
    //   1020	1042	407	finally
    //   1042	1162	407	finally
    //   1165	1197	407	finally
    //   1205	1216	407	finally
    //   1224	1231	407	finally
    //   1241	1253	407	finally
    //   1253	1305	407	finally
    //   1315	1322	407	finally
    //   1322	1424	407	finally
    //   8	69	500	java/lang/Exception
    //   69	135	500	java/lang/Exception
    //   135	165	500	java/lang/Exception
    //   165	237	500	java/lang/Exception
    //   246	251	500	java/lang/Exception
    //   264	320	500	java/lang/Exception
    //   320	391	500	java/lang/Exception
    //   412	437	500	java/lang/Exception
    //   437	497	500	java/lang/Exception
    //   518	550	500	java/lang/Exception
    //   555	580	500	java/lang/Exception
    //   580	676	500	java/lang/Exception
    //   684	760	500	java/lang/Exception
    //   760	829	500	java/lang/Exception
    //   829	840	500	java/lang/Exception
    //   848	856	500	java/lang/Exception
    //   856	889	500	java/lang/Exception
    //   895	970	500	java/lang/Exception
    //   973	993	500	java/lang/Exception
    //   995	1012	500	java/lang/Exception
    //   1020	1042	500	java/lang/Exception
    //   1042	1162	500	java/lang/Exception
    //   1165	1197	500	java/lang/Exception
    //   1205	1216	500	java/lang/Exception
    //   1224	1231	500	java/lang/Exception
    //   1241	1253	500	java/lang/Exception
    //   1253	1305	500	java/lang/Exception
    //   1315	1322	500	java/lang/Exception
    //   1322	1424	500	java/lang/Exception
  }
  
  public void stopDownload(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      ThemeUtil.ThemeInfo localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramJSONObject);
      if (localThemeInfo != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("url", localThemeInfo.downloadUrl);
        localBundle.putString("id", paramJSONObject);
        sendRemoteReq(DataFactory.makeIPCRequestPacket("stopdownload", paramString, this.mOnRemoteResp.key, localBundle), true, true);
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "stopDownload, url=" + localThemeInfo.downloadUrl);
        }
      }
      else
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", 0);
        paramJSONObject.put("message", "not in down queue");
        super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      super.callJs(paramString + "(stopdown theme JsonException:" + paramJSONObject.getMessage() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */