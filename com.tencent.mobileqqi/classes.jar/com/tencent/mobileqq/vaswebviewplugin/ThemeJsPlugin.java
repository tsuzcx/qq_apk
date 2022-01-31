package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  private static final String OBJECT_NAME = "theme";
  public static final String TAG = "ThemeJsPlugin";
  private static final String XM_3 = "Xiaomi_MI 3";
  private static final String XM_One = "Xiaomi_MI-ONE";
  private static final String XM_One_S = "Xiaomi_MI 1S";
  private BrowserAppInterface app;
  private Context context;
  private String currDownloadingThemeId;
  QQCustomDialog dialog;
  private HashMap downloadThemeMap = new HashMap();
  Bitmap drawingCache;
  protected boolean isAddSpecificWatinBinded;
  boolean isAnimating = false;
  private boolean isDownloadingInProgress = false;
  public Boolean isSwitchTheme = Boolean.valueOf(false);
  View rootView;
  private String themeDownloadCallbackId;
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
  
  private void reportThemeDown(int paramInt, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler reportThemeDown actionResult=" + paramInt + ",themeId=" + paramString);
      }
      this.app.getAccount();
      int i = NetworkUtil.a(this.context);
      if (i >= 2) {}
      for (String str = "2";; str = String.valueOf(i))
      {
        ReportController.a(null, "CliOper", "", "", "theme_mall", "theme_download", 0, paramInt, paramString, str, "", "");
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void addThemeSpecific()
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    if (WebIPCOperator.getInstance().isServiceClientBinded()) {
      sendRemoteReq(DataFactory.makeIPCRequestPacket("addThemeSpecific", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
    for (;;)
    {
      this.rootView = this.mRuntime.a().getWindow().getDecorView().getRootView();
      return;
      this.isAddSpecificWatinBinded = true;
    }
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
            if (paramString2.startsWith(AppConstants.bf)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ThemeJsPlugin", 2, "not download theme file message" + AppConstants.bf);
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
        callJsOnError(paramString1, "themeInfo is null");
        return;
        if (paramInt != 2003) {
          break;
        }
        try
        {
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            reportThemeDown(0, this.currDownloadingThemeId);
            paramString2.downsize = paramLong;
            paramString2.status = "3";
            this.downloadThemeMap.remove(this.currDownloadingThemeId);
            ThemeUtil.setThemeInfo(this.context, paramString2);
            paramString2 = new JSONObject();
            paramString2.put("result", 0);
            paramString2.put("message", "ok, Theme downloaded.");
            this.isDownloadingInProgress = false;
            callJs(paramString1 + "(" + paramString2.toString() + ");");
            return;
          }
        }
        catch (Exception paramString2)
        {
          this.isDownloadingInProgress = false;
          callJsOnError(paramString1, paramString2.getMessage());
          return;
        }
        this.isDownloadingInProgress = false;
        callJsOnError(paramString1, "themeInfo is null");
      } while (!QLog.isColorLevel());
      QLog.d("ThemeJsPlugin", 2, "downloadThemeMap themeInfo is null,themeId=" + this.currDownloadingThemeId);
      return;
      if (paramInt == 2005) {
        try
        {
          paramString2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(this.currDownloadingThemeId);
          if (paramString2 != null)
          {
            reportThemeDown(2, this.currDownloadingThemeId);
            paramString2.downsize = paramLong;
            paramString2.status = "4";
            ThemeUtil.setThemeInfo(this.context, paramString2);
            this.downloadThemeMap.remove(this.currDownloadingThemeId);
          }
          paramString2 = new JSONObject();
          paramString2.put("result", -1);
          paramString2.put("message", "recv error");
          this.isDownloadingInProgress = false;
          callJs(paramString1 + "(" + paramString2.toString() + ");");
          return;
        }
        catch (Exception paramString2)
        {
          callJsOnError(paramString1, paramString2.getMessage());
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeJsPlugin", 2, "" + paramInt);
  }
  
  public void onBindedToClient()
  {
    if (this.isAddSpecificWatinBinded)
    {
      sendRemoteReq(DataFactory.makeIPCRequestPacket("addThemeSpecific", "", this.mOnRemoteResp.key, new Bundle()), true, false);
      this.isAddSpecificWatinBinded = false;
    }
  }
  
  protected void onCreate()
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.context = this.mRuntime.a().getApplicationContext();
    super.onCreate();
    addThemeSpecific();
  }
  
  protected void onDestroy()
  {
    removeThemeDownHandler();
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
      if ((Build.VERSION.SDK_INT >= 16) && ((str.contains("Xiaomi_MI 3")) || (str.contains("Xiaomi_MI-ONE")) || (str.contains("Xiaomi_MI 1S")))) {
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
    this.rootView.postDelayed(new ThemeJsPlugin.5(this), 601L);
    return;
    this.isSwitchTheme = Boolean.valueOf(false);
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
        break label55;
      }
    }
    label54:
    label55:
    do
    {
      do
      {
        do
        {
          break label54;
          do
          {
            return;
          } while (i != this.mOnRemoteResp.key);
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "response:" + (String)localObject3);
          }
        } while (localObject3 == null);
        if ("addThemeSpecific".equals(localObject3))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "response1:IPC_THEME_ADDTHEMESPECIFIC");
          }
          i = ((Bundle)localObject1).getInt("what");
          paramBundle = ((Bundle)localObject1).getString("filePath");
          long l = ((Bundle)localObject1).getLong("transferedSize");
          handleMessage(i, this.themeDownloadCallbackId, paramBundle, l);
          return;
        }
        if (!"startDownloadTheme".equals(localObject3)) {
          break;
        }
      } while (((Bundle)localObject1).getBoolean("StartDownloadResult"));
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "ThemeJsPlugin.onResponse, startDownload error");
      }
      this.isDownloadingInProgress = false;
      callJsOnError(str, "startDownload error.");
      return;
      if (!"stopdownload".equals(localObject3)) {
        break label404;
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
      callJs(str + "(" + ((JSONObject)localObject3).toString() + ");");
      reportThemeDown(1, paramBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        callJsOnError(str, localJSONException.getMessage());
      }
    }
    callJsOnError(str, "stop failure.");
    return;
    label404:
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
        callJs(str + "(" + ((JSONObject)localObject2).toString() + ");");
        return;
      }
      catch (JSONException paramBundle)
      {
        callJsOnError(str, paramBundle.getMessage());
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
        callJs(paramString + "(" + localJSONObject1.toString() + ");");
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
      callJsOnError(paramString, paramJSONObject.getMessage());
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
        label372:
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
        break label569;
      }
    }
    label569:
    for (int i = (int)Math.floor(localThemeInfo.downsize * 1.0D / localThemeInfo.size * 100.0D);; i = 0)
    {
      i = Math.min(i, 100);
      localJSONObject2.put("version", localThemeInfo.version);
      localJSONObject2.put("progress", i);
      break;
      localThemeInfo.status = "4";
      break label372;
    }
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal");
    }
    new Thread(new ThemeJsPlugin.1(this, paramString)).start();
  }
  
  public void removeThemeDownHandler()
  {
    sendRemoteReq(DataFactory.makeIPCRequestPacket("removeThemeDownHandler", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        str2 = paramJSONObject.getString("id");
        if (!paramJSONObject.has("version")) {
          break label459;
        }
        str1 = paramJSONObject.getString("version");
        if (!paramJSONObject.has("isSound")) {
          break label467;
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
        callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
        int j = 0;
        if (j == i) {
          continue;
        }
        if (i != 1) {
          break label472;
        }
        bool = true;
        continue;
        return;
      }
      paramJSONObject.isVoiceTheme = bool;
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
        callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
      if (!this.isSwitchTheme.booleanValue())
      {
        new ThemeJsPlugin.SwitchThemeTask(this, paramString).execute(new Object[] { str2, str1 });
        return;
      }
      label459:
      String str1 = "0";
      continue;
      label467:
      int i = 0;
      continue;
      label472:
      boolean bool = false;
    }
  }
  
  protected boolean shouldGetBusiness()
  {
    return false;
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
    //   8: aload_1
    //   9: ldc_w 795
    //   12: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 13
    //   17: aload_1
    //   18: ldc_w 676
    //   21: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 11
    //   26: aload_1
    //   27: ldc_w 663
    //   30: invokevirtual 425	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 12
    //   35: aload_1
    //   36: ldc_w 796
    //   39: invokevirtual 761	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   42: istore 5
    //   44: aload_1
    //   45: ldc_w 760
    //   48: invokevirtual 758	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   51: ifeq +179 -> 230
    //   54: aload_1
    //   55: ldc_w 760
    //   58: invokevirtual 761	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   61: istore 4
    //   63: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +63 -> 129
    //   69: ldc 15
    //   71: iconst_2
    //   72: new 124	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 798
    //   82: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 11
    //   87: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 800
    //   93: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 12
    //   98: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 802
    //   104: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload 5
    //   109: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 770
    //   115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: new 407	org/json/JSONObject
    //   132: dup
    //   133: invokespecial 512	org/json/JSONObject:<init>	()V
    //   136: astore 14
    //   138: invokestatic 806	com/tencent/mobileqq/util/Utils:e	()Z
    //   141: ifne +95 -> 236
    //   144: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +12 -> 159
    //   150: ldc 15
    //   152: iconst_2
    //   153: ldc_w 808
    //   156: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 14
    //   161: ldc_w 514
    //   164: bipush 7
    //   166: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload 14
    //   172: ldc_w 519
    //   175: ldc_w 808
    //   178: invokevirtual 524	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload_0
    //   183: new 124	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   190: aload_2
    //   191: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 526
    //   197: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 14
    //   202: invokevirtual 527	org/json/JSONObject:toString	()Ljava/lang/String;
    //   205: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 529
    //   211: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 532	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;)V
    //   220: aload_0
    //   221: iconst_2
    //   222: aload 12
    //   224: invokespecial 506	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportThemeDown	(ILjava/lang/String;)V
    //   227: aload_0
    //   228: monitorexit
    //   229: return
    //   230: iconst_0
    //   231: istore 4
    //   233: goto -170 -> 63
    //   236: invokestatic 811	com/tencent/mobileqq/util/Utils:b	()J
    //   239: lstore 8
    //   241: lload 8
    //   243: iload 5
    //   245: ldc_w 812
    //   248: iadd
    //   249: i2l
    //   250: lcmp
    //   251: ifge +147 -> 398
    //   254: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +53 -> 310
    //   260: ldc 15
    //   262: iconst_2
    //   263: new 124	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 814
    //   273: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: iload 5
    //   278: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 816
    //   284: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 812
    //   290: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 818
    //   296: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: lload 8
    //   301: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aload 14
    //   312: ldc_w 514
    //   315: iconst_1
    //   316: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload 14
    //   322: ldc_w 519
    //   325: ldc_w 820
    //   328: invokevirtual 524	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload_0
    //   333: iconst_2
    //   334: aload 12
    //   336: invokespecial 506	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportThemeDown	(ILjava/lang/String;)V
    //   339: aload_0
    //   340: new 124	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   347: aload_2
    //   348: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc_w 526
    //   354: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 14
    //   359: invokevirtual 527	org/json/JSONObject:toString	()Ljava/lang/String;
    //   362: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 529
    //   368: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokevirtual 532	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;)V
    //   377: goto -150 -> 227
    //   380: astore_1
    //   381: aload_0
    //   382: aload_2
    //   383: aload_1
    //   384: invokevirtual 668	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   387: invokevirtual 504	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: goto -163 -> 227
    //   393: astore_1
    //   394: aload_0
    //   395: monitorexit
    //   396: aload_1
    //   397: athrow
    //   398: aload_0
    //   399: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   402: invokestatic 823	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   405: ifne +99 -> 504
    //   408: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +12 -> 423
    //   414: ldc 15
    //   416: iconst_2
    //   417: ldc_w 825
    //   420: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: aload 14
    //   425: ldc_w 514
    //   428: iconst_5
    //   429: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   432: pop
    //   433: aload 14
    //   435: ldc_w 519
    //   438: ldc_w 825
    //   441: invokevirtual 524	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   444: pop
    //   445: aload_0
    //   446: new 124	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   453: aload_2
    //   454: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc_w 526
    //   460: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 14
    //   465: invokevirtual 527	org/json/JSONObject:toString	()Ljava/lang/String;
    //   468: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc_w 529
    //   474: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokevirtual 532	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;)V
    //   483: goto -256 -> 227
    //   486: astore_1
    //   487: aload_0
    //   488: iconst_0
    //   489: putfield 54	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   492: aload_0
    //   493: aload_2
    //   494: aload_1
    //   495: invokevirtual 533	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   498: invokevirtual 504	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: goto -274 -> 227
    //   504: aload_0
    //   505: getfield 54	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   508: ifeq +238 -> 746
    //   511: aload_0
    //   512: getfield 59	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   515: aload_0
    //   516: getfield 92	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   519: invokevirtual 479	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   522: checkcast 481	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   525: astore 10
    //   527: aload 12
    //   529: aload_0
    //   530: getfield 92	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   533: if_acmpne +132 -> 665
    //   536: aload 10
    //   538: ifnull +127 -> 665
    //   541: aload 11
    //   543: aload 10
    //   545: getfield 718	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   548: if_acmpne +117 -> 665
    //   551: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +12 -> 566
    //   557: ldc 15
    //   559: iconst_2
    //   560: ldc_w 827
    //   563: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 14
    //   568: ldc_w 514
    //   571: bipush 6
    //   573: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   576: pop
    //   577: aload 14
    //   579: ldc_w 519
    //   582: new 124	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 829
    //   592: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 12
    //   597: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 680
    //   603: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 11
    //   608: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: ldc_w 831
    //   614: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 524	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   623: pop
    //   624: aload_0
    //   625: new 124	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   632: aload_2
    //   633: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: ldc_w 526
    //   639: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload 14
    //   644: invokevirtual 527	org/json/JSONObject:toString	()Ljava/lang/String;
    //   647: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc_w 529
    //   653: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokevirtual 532	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;)V
    //   662: goto -435 -> 227
    //   665: aload 10
    //   667: ifnull +79 -> 746
    //   670: new 227	android/os/Bundle
    //   673: dup
    //   674: invokespecial 228	android/os/Bundle:<init>	()V
    //   677: astore 15
    //   679: aload 15
    //   681: ldc_w 795
    //   684: aload 10
    //   686: getfield 834	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   689: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: aload 15
    //   694: ldc_w 674
    //   697: aload_0
    //   698: getfield 92	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   701: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 15
    //   706: ldc_w 663
    //   709: aload 12
    //   711: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload 15
    //   716: ldc_w 676
    //   719: aload 11
    //   721: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload_0
    //   725: ldc_w 672
    //   728: aload_2
    //   729: aload_0
    //   730: getfield 220	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   733: getfield 225	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   736: aload 15
    //   738: invokestatic 234	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   741: iconst_0
    //   742: iconst_1
    //   743: invokevirtual 238	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   746: aload_0
    //   747: aload 12
    //   749: aload 11
    //   751: iload 5
    //   753: i2l
    //   754: invokespecial 86	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isThemeExist	(Ljava/lang/String;Ljava/lang/String;J)Z
    //   757: ifeq +202 -> 959
    //   760: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   763: ifeq +52 -> 815
    //   766: ldc 15
    //   768: iconst_2
    //   769: new 124	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 839
    //   779: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 12
    //   784: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: ldc_w 680
    //   790: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 11
    //   795: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: ldc_w 802
    //   801: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: iload 5
    //   806: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: aload_0
    //   816: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   819: aload 12
    //   821: invokestatic 688	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   824: astore 10
    //   826: aload 10
    //   828: astore_1
    //   829: aload 10
    //   831: ifnonnull +11 -> 842
    //   834: new 481	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   837: dup
    //   838: invokespecial 840	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   841: astore_1
    //   842: aload_1
    //   843: iload 5
    //   845: i2l
    //   846: putfield 485	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   849: aload_1
    //   850: iload 5
    //   852: i2l
    //   853: putfield 721	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   856: aload_1
    //   857: aload 12
    //   859: putfield 716	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   862: aload_1
    //   863: aload 11
    //   865: putfield 718	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   868: aload_1
    //   869: ldc_w 508
    //   872: putfield 488	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   875: iload 4
    //   877: iconst_1
    //   878: if_icmpne +545 -> 1423
    //   881: aload_1
    //   882: iload 6
    //   884: putfield 766	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   887: aload_0
    //   888: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   891: aload_1
    //   892: invokestatic 496	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   895: pop
    //   896: aload 14
    //   898: ldc_w 514
    //   901: iconst_3
    //   902: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   905: pop
    //   906: aload 14
    //   908: ldc_w 519
    //   911: ldc_w 842
    //   914: invokevirtual 524	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   917: pop
    //   918: aload_0
    //   919: new 124	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   926: aload_2
    //   927: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: ldc_w 526
    //   933: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 14
    //   938: invokevirtual 527	org/json/JSONObject:toString	()Ljava/lang/String;
    //   941: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: ldc_w 529
    //   947: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: invokevirtual 532	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;)V
    //   956: goto -729 -> 227
    //   959: aload_1
    //   960: ldc_w 844
    //   963: invokevirtual 758	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   966: ifeq +468 -> 1434
    //   969: aload_1
    //   970: ldc_w 844
    //   973: invokevirtual 845	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   976: ifne +453 -> 1429
    //   979: iconst_1
    //   980: istore_3
    //   981: aload_0
    //   982: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   985: ldc_w 847
    //   988: invokevirtual 853	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   991: checkcast 855	android/net/ConnectivityManager
    //   994: invokevirtual 859	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   997: astore_1
    //   998: iload_3
    //   999: ifeq +151 -> 1150
    //   1002: aload_1
    //   1003: ifnull +147 -> 1150
    //   1006: aload_1
    //   1007: invokestatic 862	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1010: ifeq +140 -> 1150
    //   1013: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq +12 -> 1028
    //   1019: ldc 15
    //   1021: iconst_2
    //   1022: ldc_w 864
    //   1025: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: aload_0
    //   1029: new 866	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$2
    //   1032: dup
    //   1033: aload_0
    //   1034: aload_0
    //   1035: getfield 201	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1038: invokevirtual 206	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1041: ldc_w 867
    //   1044: aload_2
    //   1045: invokespecial 870	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$2:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;)V
    //   1048: putfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1051: aload_0
    //   1052: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1055: ldc_w 873
    //   1058: invokevirtual 879	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   1061: aload_0
    //   1062: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1065: ldc_w 880
    //   1068: invokevirtual 883	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(I)V
    //   1071: aload_0
    //   1072: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1075: ldc_w 884
    //   1078: invokevirtual 888	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1081: pop
    //   1082: aload_0
    //   1083: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1086: iconst_0
    //   1087: invokevirtual 891	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   1090: aload_0
    //   1091: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1094: ldc_w 892
    //   1097: new 894	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3
    //   1100: dup
    //   1101: aload_0
    //   1102: aload_2
    //   1103: invokespecial 895	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;)V
    //   1106: invokevirtual 899	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1109: pop
    //   1110: aload_0
    //   1111: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1114: ldc_w 900
    //   1117: new 902	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   1120: dup
    //   1121: aload_0
    //   1122: aload 12
    //   1124: aload 11
    //   1126: aload 13
    //   1128: iload 5
    //   1130: iload 4
    //   1132: aload_2
    //   1133: invokespecial 905	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   1136: invokevirtual 908	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1139: pop
    //   1140: aload_0
    //   1141: getfield 872	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1144: invokevirtual 911	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1147: goto -920 -> 227
    //   1150: aload_0
    //   1151: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1154: aload 12
    //   1156: aload 11
    //   1158: invokestatic 103	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1161: astore 14
    //   1163: aload_0
    //   1164: iconst_1
    //   1165: putfield 54	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isDownloadingInProgress	Z
    //   1168: aload_0
    //   1169: getfield 59	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   1172: aload 12
    //   1174: invokevirtual 479	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1177: checkcast 481	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1180: astore 10
    //   1182: aload 10
    //   1184: astore_1
    //   1185: aload 10
    //   1187: ifnonnull +32 -> 1219
    //   1190: aload_0
    //   1191: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   1194: aload 12
    //   1196: invokestatic 688	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   1199: astore 10
    //   1201: aload 10
    //   1203: astore_1
    //   1204: aload 10
    //   1206: ifnull +13 -> 1219
    //   1209: aload 10
    //   1211: aload 13
    //   1213: putfield 834	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1216: aload 10
    //   1218: astore_1
    //   1219: aload_1
    //   1220: ifnull +18 -> 1238
    //   1223: aload_1
    //   1224: astore 10
    //   1226: aload_1
    //   1227: getfield 718	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1230: aload 11
    //   1232: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1235: ifne +72 -> 1307
    //   1238: new 481	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1241: dup
    //   1242: invokespecial 840	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   1245: astore 10
    //   1247: aload 10
    //   1249: aload 12
    //   1251: putfield 716	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1254: aload 10
    //   1256: aload 13
    //   1258: putfield 834	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   1261: aload 10
    //   1263: iload 5
    //   1265: i2l
    //   1266: putfield 721	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   1269: aload 10
    //   1271: lconst_0
    //   1272: putfield 485	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1275: aload 10
    //   1277: aload 11
    //   1279: putfield 718	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1282: aload 10
    //   1284: ldc_w 708
    //   1287: putfield 488	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1290: iload 4
    //   1292: iconst_1
    //   1293: if_icmpne +124 -> 1417
    //   1296: iload 7
    //   1298: istore 6
    //   1300: aload 10
    //   1302: iload 6
    //   1304: putfield 766	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   1307: aload_0
    //   1308: getfield 59	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   1311: aload 12
    //   1313: aload 10
    //   1315: invokevirtual 492	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1318: pop
    //   1319: aload_0
    //   1320: aload 12
    //   1322: putfield 92	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   1325: aload_0
    //   1326: aload_2
    //   1327: putfield 95	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeDownloadCallbackId	Ljava/lang/String;
    //   1330: new 227	android/os/Bundle
    //   1333: dup
    //   1334: invokespecial 228	android/os/Bundle:<init>	()V
    //   1337: astore_1
    //   1338: aload_1
    //   1339: ldc_w 795
    //   1342: aload 13
    //   1344: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1347: aload_1
    //   1348: ldc_w 913
    //   1351: aload 14
    //   1353: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1356: aload_1
    //   1357: ldc_w 663
    //   1360: aload 12
    //   1362: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: aload_1
    //   1366: ldc_w 676
    //   1369: aload 11
    //   1371: invokevirtual 837	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1374: aload_1
    //   1375: ldc_w 796
    //   1378: iload 5
    //   1380: i2l
    //   1381: invokevirtual 917	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1384: aload_1
    //   1385: ldc_w 919
    //   1388: aload 10
    //   1390: invokevirtual 923	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1393: aload_0
    //   1394: ldc_w 650
    //   1397: aload_2
    //   1398: aload_0
    //   1399: getfield 220	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1402: getfield 225	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1405: aload_1
    //   1406: invokestatic 234	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1409: iconst_1
    //   1410: iconst_1
    //   1411: invokevirtual 238	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1414: goto -1187 -> 227
    //   1417: iconst_0
    //   1418: istore 6
    //   1420: goto -120 -> 1300
    //   1423: iconst_0
    //   1424: istore 6
    //   1426: goto -545 -> 881
    //   1429: iconst_0
    //   1430: istore_3
    //   1431: goto -450 -> 981
    //   1434: iconst_1
    //   1435: istore_3
    //   1436: goto -455 -> 981
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1439	0	this	ThemeJsPlugin
    //   0	1439	1	paramJSONObject	JSONObject
    //   0	1439	2	paramString	String
    //   980	456	3	i	int
    //   61	1233	4	j	int
    //   42	1337	5	k	int
    //   4	1421	6	bool1	boolean
    //   1	1296	7	bool2	boolean
    //   239	61	8	l	long
    //   525	864	10	localObject1	Object
    //   24	1346	11	str1	String
    //   33	1328	12	str2	String
    //   15	1328	13	str3	String
    //   136	1216	14	localObject2	Object
    //   677	60	15	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   8	63	380	org/json/JSONException
    //   63	129	380	org/json/JSONException
    //   129	159	380	org/json/JSONException
    //   159	227	380	org/json/JSONException
    //   236	241	380	org/json/JSONException
    //   254	310	380	org/json/JSONException
    //   310	377	380	org/json/JSONException
    //   398	423	380	org/json/JSONException
    //   423	483	380	org/json/JSONException
    //   504	536	380	org/json/JSONException
    //   541	566	380	org/json/JSONException
    //   566	662	380	org/json/JSONException
    //   670	746	380	org/json/JSONException
    //   746	815	380	org/json/JSONException
    //   815	826	380	org/json/JSONException
    //   834	842	380	org/json/JSONException
    //   842	875	380	org/json/JSONException
    //   881	956	380	org/json/JSONException
    //   959	979	380	org/json/JSONException
    //   981	998	380	org/json/JSONException
    //   1006	1028	380	org/json/JSONException
    //   1028	1147	380	org/json/JSONException
    //   1150	1182	380	org/json/JSONException
    //   1190	1201	380	org/json/JSONException
    //   1209	1216	380	org/json/JSONException
    //   1226	1238	380	org/json/JSONException
    //   1238	1290	380	org/json/JSONException
    //   1300	1307	380	org/json/JSONException
    //   1307	1414	380	org/json/JSONException
    //   8	63	393	finally
    //   63	129	393	finally
    //   129	159	393	finally
    //   159	227	393	finally
    //   236	241	393	finally
    //   254	310	393	finally
    //   310	377	393	finally
    //   381	390	393	finally
    //   398	423	393	finally
    //   423	483	393	finally
    //   487	501	393	finally
    //   504	536	393	finally
    //   541	566	393	finally
    //   566	662	393	finally
    //   670	746	393	finally
    //   746	815	393	finally
    //   815	826	393	finally
    //   834	842	393	finally
    //   842	875	393	finally
    //   881	956	393	finally
    //   959	979	393	finally
    //   981	998	393	finally
    //   1006	1028	393	finally
    //   1028	1147	393	finally
    //   1150	1182	393	finally
    //   1190	1201	393	finally
    //   1209	1216	393	finally
    //   1226	1238	393	finally
    //   1238	1290	393	finally
    //   1300	1307	393	finally
    //   1307	1414	393	finally
    //   8	63	486	java/lang/Exception
    //   63	129	486	java/lang/Exception
    //   129	159	486	java/lang/Exception
    //   159	227	486	java/lang/Exception
    //   236	241	486	java/lang/Exception
    //   254	310	486	java/lang/Exception
    //   310	377	486	java/lang/Exception
    //   398	423	486	java/lang/Exception
    //   423	483	486	java/lang/Exception
    //   504	536	486	java/lang/Exception
    //   541	566	486	java/lang/Exception
    //   566	662	486	java/lang/Exception
    //   670	746	486	java/lang/Exception
    //   746	815	486	java/lang/Exception
    //   815	826	486	java/lang/Exception
    //   834	842	486	java/lang/Exception
    //   842	875	486	java/lang/Exception
    //   881	956	486	java/lang/Exception
    //   959	979	486	java/lang/Exception
    //   981	998	486	java/lang/Exception
    //   1006	1028	486	java/lang/Exception
    //   1028	1147	486	java/lang/Exception
    //   1150	1182	486	java/lang/Exception
    //   1190	1201	486	java/lang/Exception
    //   1209	1216	486	java/lang/Exception
    //   1226	1238	486	java/lang/Exception
    //   1238	1290	486	java/lang/Exception
    //   1300	1307	486	java/lang/Exception
    //   1307	1414	486	java/lang/Exception
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
        callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      callJs(paramString + "(stopdown theme JsonException:" + paramJSONObject.getMessage() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */