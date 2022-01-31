package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.sdk.stat.HttpUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  private static final String LOGTAG = "webview";
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String SCHEME_DEBUG_TBS = "http://debugtbs.qq.com";
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  public static String TBS_DEBUG_INSTALL_ONLINE;
  private static final String WX_PACKAGE_NAME = "com.tencent.mm";
  static boolean current_process_used_x5;
  private static Context mAppContext;
  private static String mCallerAppPackageName;
  private static boolean mIsDayMode;
  private static Paint mNightModePaint;
  public static boolean mSysWebviewCreated;
  private static TbsConfigFile mTbsConfig;
  private static final Lock mTbsPvLock = new ReentrantLock();
  private static OutputStream outputStream = null;
  private static Method sWebviewsetWebContentsDebuggingEnabled;
  private final int ATTRIBUTE_SCROLLBARS_HORIZONTAL = 2;
  private final int ATTRIBUTE_SCROLLBARS_NONE = 1;
  private final int ATTRIBUTE_SCROLLBARS_VERTICAL = 3;
  private final String LOG_TAG = "WebView";
  private Button assistant_confirm;
  private Button assistant_test_reset;
  private final String deleteNightMode = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private boolean isShowDebugView = false;
  private boolean isX5Core = false;
  private Object longClickListener = null;
  private Context mContext = null;
  private boolean mIsReported = false;
  private View.OnLongClickListener mOnLongClickListener = null;
  int mPv = 0;
  private SystemWebView mSysWebView;
  private WebSettings mWebSettings = null;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient mWebViewClient = null;
  private IX5WebViewBase mX5WebView;
  private final String nightMode = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  private CheckBox tbs_use_qproxy_query;
  private CheckBox tbs_use_syswebview_query;
  
  static
  {
    mAppContext = null;
    TBS_DEBUG_INSTALL_ONLINE = "tbsdebug_install_online_";
    current_process_used_x5 = false;
    mTbsConfig = null;
    sWebviewsetWebContentsDebuggingEnabled = null;
    mCallerAppPackageName = null;
    mSysWebviewCreated = false;
    mNightModePaint = null;
    mIsDayMode = true;
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramContext == null)
    {
      current_process_used_x5 = this.isX5Core;
      throw new IllegalArgumentException("Invalid context argument");
    }
    if (mTbsConfig == null) {
      mTbsConfig = TbsConfigFile.getInstance(paramContext);
    }
    if (mTbsConfig.mForceUseSystemWebview)
    {
      TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
      QbSdk.forceSysWebViewInner();
    }
    init(paramContext);
    this.mContext = paramContext;
    if (paramContext != null) {
      mAppContext = paramContext.getApplicationContext();
    }
    if (this.isX5Core)
    {
      this.mX5WebView = SDKEngine.getInstance(true).wizard().createSDKWebview(paramContext);
      if ((this.mX5WebView == null) || (this.mX5WebView.getView() == null))
      {
        TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
        this.mX5WebView = null;
        this.isX5Core = false;
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 301);
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 405);
        QbSdk.forceSysWebViewInner();
        init(paramContext);
        if (TbsShareManager.isThirdPartyApp(this.mContext)) {
          this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);
        }
        for (;;)
        {
          TbsLog.i("WebView", "SystemWebView Created Success! #1");
          this.mSysWebView.setFocusableInTouchMode(true);
          addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
          try
          {
            if (Build.VERSION.SDK_INT >= 11) {
              removeJavascriptInterface("searchBoxJavaBridge_");
            }
            current_process_used_x5 = this.isX5Core;
            return;
            this.mSysWebView = new SystemWebView(paramContext);
          }
          catch (Throwable paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
            }
          }
        }
      }
      TbsLog.i("WebView", "X5 WebView Created Success!!");
      this.mX5WebView.getView().setFocusableInTouchMode(true);
      setAttributeForX5(paramAttributeSet);
      addView(this.mX5WebView.getView(), new FrameLayout.LayoutParams(-1, -1));
      this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, null, this.isX5Core));
      this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(SDKEngine.getInstance(false).wizard().createDefaultX5WebChromeClientExtension())
      {
        public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          WebView.this.onScrollChanged(paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
        }
      });
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        removeJavascriptInterface("searchBoxJavaBridge_");
      }
      if ((("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName))) && (SDKEngine.getInstance(true).useSoftWare()) && (Build.VERSION.SDK_INT >= 11)) {
        setLayerType(1, null);
      }
      if ((TbsShareManager.isThirdPartyApp(this.mContext)) && (!TbsShareManager.forceLoadX5FromTBSDemo(mAppContext))) {
        TbsDownloader.needDownload(this.mContext);
      }
      current_process_used_x5 = this.isX5Core;
      return;
      this.mX5WebView = null;
      this.isX5Core = false;
      QbSdk.forceSysWebViewInner();
      if (TbsShareManager.isThirdPartyApp(this.mContext)) {}
      for (this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);; this.mSysWebView = new SystemWebView(paramContext))
      {
        TbsLog.i("WebView", "SystemWebView Created Success! #2");
        this.mSysWebView.setFocusableInTouchMode(true);
        addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
        setDownloadListener(null);
        break;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  private boolean callX5CoreOnLongClick(View paramView)
  {
    boolean bool = false;
    paramView = ReflectionUtils.invokeInstance(this.longClickListener, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      bool = ((Boolean)paramView).booleanValue();
    }
    return bool;
  }
  
  private void deletepvfile(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      if (paramContext != null)
      {
        if (!paramContext.exists()) {
          return;
        }
        paramContext.delete();
        return;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if ((SDKEngine.getInstance(false) == null) || (!SDKEngine.getInstance(false).isX5Core())) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if ((SDKEngine.getInstance(false) == null) || (!SDKEngine.getInstance(false).isX5Core())) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if ((SDKEngine.getInstance(false) != null) && (!SDKEngine.getInstance(false).isX5Core())) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    String str = "tbs_core_version:" + QbSdk.getTbsVersion(paramContext) + ";" + "tbs_sdk_version:" + 36001 + ";";
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return "nothing return ^-^." + str;
    }
    paramContext = new StringBuilder();
    paramContext.append(SDKEngine.getInstance(true).getCrashExtraMessage());
    paramContext.append("\n");
    paramContext.append(str);
    if (paramContext.length() > 8192) {
      return paramContext.substring(paramContext.length() - 8192);
    }
    return paramContext.toString();
  }
  
  private LinearLayout getDebugSettingsView()
  {
    final CheckBox localCheckBox = null;
    try
    {
      localObject1 = new LinearLayout(this.mContext);
      float f;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      FrameLayout.LayoutParams localLayoutParams;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        f = this.mContext.getApplicationContext().getResources().getDisplayMetrics().density;
        ((LinearLayout)localObject1).setBackgroundColor(-1);
        ((LinearLayout)localObject1).setOrientation(1);
        ((LinearLayout)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setText("TBS调试选项设置");
        ((TextView)localObject2).setTextColor(-16711936);
        ((TextView)localObject2).setTextSize((int)(5.0F * f + 0.5F));
        ((TextView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ((LinearLayout)localObject1).addView((View)localObject2);
        localObject3 = new LinearLayout(this.mContext);
        ((LinearLayout)localObject3).setOrientation(1);
        ((LinearLayout)localObject3).setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setText("请选择以下测试选项");
        ((TextView)localObject2).setTextColor(-16777216);
        ((TextView)localObject2).setTextSize((int)(5.0F * f + 0.5F));
        ((TextView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        ((LinearLayout)localObject3).addView((View)localObject2);
        localObject2 = new CheckBox(this.mContext);
        ((CheckBox)localObject2).setText("强制使用系统内核");
        ((CheckBox)localObject2).setTextColor(-16777216);
        ((CheckBox)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ((LinearLayout)localObject3).addView((View)localObject2);
        localCheckBox = new CheckBox(this.mContext);
        localCheckBox.setText("强制走代理(QProxy)");
        localCheckBox.setTextColor(-16777216);
        localCheckBox.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ((LinearLayout)localObject3).addView(localCheckBox);
        localObject4 = new LinearLayout(this.mContext);
        ((LinearLayout)localObject4).setOrientation(0);
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = ((int)(8.0F * f + 0.5F));
        ((LinearLayout)localObject4).setLayoutParams(localLayoutParams);
        this.assistant_confirm = new Button(this.mContext);
        this.assistant_confirm.setText("确定");
        localLayoutParams = new FrameLayout.LayoutParams(-2, (int)(60.0F * f + 0.5F));
        localLayoutParams.topMargin = ((int)(5.0F * f + 0.5F));
        this.assistant_confirm.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject4).addView(this.assistant_confirm);
        this.assistant_test_reset = new Button(this.mContext);
        this.assistant_test_reset.setText("恢复原始设置");
        localLayoutParams = new FrameLayout.LayoutParams(-2, (int)(60.0F * f + 0.5F));
        localLayoutParams.leftMargin = ((int)(15.0F * f + 0.5F));
        localLayoutParams.topMargin = ((int)(5.0F * f + 0.5F));
        this.assistant_test_reset.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject4).addView(this.assistant_test_reset);
        ((LinearLayout)localObject3).addView((View)localObject4);
        ((LinearLayout)localObject1).addView((View)localObject3);
        localObject3 = new TextView(this.mContext);
        ((TextView)localObject3).setText("调试选项的当前状态");
        ((TextView)localObject3).setTextColor(-7829368);
        ((TextView)localObject3).setTextSize((int)(5.0F * f + 0.5F));
        localObject4 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject4).topMargin = ((int)(25.0F * f + 0.5F));
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((LinearLayout)localObject1).addView((View)localObject3);
        localObject3 = new LinearLayout(this.mContext);
        ((LinearLayout)localObject3).setBackgroundColor(-1);
        ((LinearLayout)localObject3).setOrientation(1);
        localObject4 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject4).topMargin = ((int)(5.0F * f + 0.5F));
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        this.tbs_use_syswebview_query = new CheckBox(this.mContext);
        this.tbs_use_syswebview_query.setClickable(false);
        this.tbs_use_syswebview_query.setText("强制使用系统内核");
        this.tbs_use_syswebview_query.setTextColor(-7829368);
        localObject4 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject4).leftMargin = ((int)(5.0F * f + 0.5F));
        this.tbs_use_syswebview_query.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((LinearLayout)localObject3).addView(this.tbs_use_syswebview_query);
        this.tbs_use_qproxy_query = new CheckBox(this.mContext);
        this.tbs_use_qproxy_query.setClickable(false);
        this.tbs_use_qproxy_query.setText("强制走代理(QProxy)");
        this.tbs_use_qproxy_query.setTextColor(-7829368);
        localObject4 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject4).leftMargin = ((int)(5.0F * f + 0.5F));
        this.tbs_use_qproxy_query.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((LinearLayout)localObject3).addView(this.tbs_use_qproxy_query);
        ((LinearLayout)localObject1).addView((View)localObject3);
        this.assistant_confirm.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (WebView.mTbsConfig == null) {
              WebView.access$402(TbsConfigFile.getInstance(WebView.this.mContext));
            }
            WebView.mTbsConfig.mForceUseSystemWebview = this.val$tbs_use_syswebview_check.isChecked();
            WebView.mTbsConfig.mForceUseQqProxy = localCheckBox.isChecked();
            WebView.mTbsConfig.saveProperties();
            WebView.this.query_settings_and_update();
            paramAnonymousView = new AlertDialog.Builder(WebView.this.mContext);
            paramAnonymousView.setTitle("提示");
            paramAnonymousView.setPositiveButton("确定", null);
            paramAnonymousView.setMessage("设置成功!");
            paramAnonymousView.create().show();
          }
        });
        this.assistant_test_reset.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            WebView.this.tbs_test_reset_settings();
            WebView.this.query_settings_and_update();
          }
        });
        query_settings_and_update();
        return localObject1;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject1;
        break label920;
      }
      localThrowable1 = localThrowable1;
      localObject1 = localCheckBox;
    }
    label920:
    return localObject1;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: invokestatic 268	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   7: ifnull +28 -> 35
    //   10: iconst_0
    //   11: invokestatic 268	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   14: invokevirtual 529	com/tencent/smtt/sdk/SDKEngine:isX5Core	()Z
    //   17: ifne +18 -> 35
    //   20: ldc_w 531
    //   23: ldc_w 680
    //   26: invokestatic 536	com/tencent/smtt/utils/ReflectionUtils:invokeStatic	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: aconst_null
    //   36: astore_0
    //   37: goto -7 -> 30
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	8	0	localObject1	Object
    //   40	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	40	finally
  }
  
  /* Error */
  private int getTbsCorePV(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 688	com/tencent/smtt/sdk/TbsInstaller:getLockFos	(Landroid/content/Context;)Ljava/io/FileOutputStream;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnonnull +5 -> 13
    //   11: iconst_m1
    //   12: ireturn
    //   13: aload_1
    //   14: aload 7
    //   16: invokestatic 692	com/tencent/smtt/sdk/TbsInstaller:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   19: astore 8
    //   21: aload 8
    //   23: ifnonnull +5 -> 28
    //   26: iconst_m1
    //   27: ireturn
    //   28: getstatic 147	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 697 1 0
    //   36: ifeq +478 -> 514
    //   39: aconst_null
    //   40: astore 6
    //   42: aconst_null
    //   43: astore 5
    //   45: aload 6
    //   47: astore 4
    //   49: aload_1
    //   50: ldc_w 485
    //   53: iconst_0
    //   54: invokevirtual 489	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   57: astore_1
    //   58: aload 6
    //   60: astore 4
    //   62: new 491	java/io/File
    //   65: dup
    //   66: new 493	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   73: aload_1
    //   74: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: getstatic 501	java/io/File:separator	Ljava/lang/String;
    //   80: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 506
    //   86: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: ldc_w 512
    //   95: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +16 -> 116
    //   103: aload 6
    //   105: astore 4
    //   107: aload_1
    //   108: invokevirtual 517	java/io/File:exists	()Z
    //   111: istore_3
    //   112: iload_3
    //   113: ifne +65 -> 178
    //   116: iconst_0
    //   117: ifeq +11 -> 128
    //   120: new 699	java/lang/NullPointerException
    //   123: dup
    //   124: invokespecial 700	java/lang/NullPointerException:<init>	()V
    //   127: athrow
    //   128: getstatic 147	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   131: invokeinterface 703 1 0
    //   136: aload 8
    //   138: aload 7
    //   140: invokestatic 707	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   143: iconst_m1
    //   144: ireturn
    //   145: astore_1
    //   146: ldc_w 522
    //   149: new 493	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 709
    //   159: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   166: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: goto -47 -> 128
    //   178: aload 6
    //   180: astore 4
    //   182: new 714	java/util/Properties
    //   185: dup
    //   186: invokespecial 715	java/util/Properties:<init>	()V
    //   189: astore 9
    //   191: aload 6
    //   193: astore 4
    //   195: new 717	java/io/FileInputStream
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 720	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   203: astore_1
    //   204: aload 9
    //   206: aload_1
    //   207: invokevirtual 724	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   210: aload_1
    //   211: invokevirtual 727	java/io/FileInputStream:close	()V
    //   214: aload 9
    //   216: ldc_w 729
    //   219: invokevirtual 732	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   222: astore 4
    //   224: aload 4
    //   226: ifnonnull +61 -> 287
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 727	java/io/FileInputStream:close	()V
    //   237: getstatic 147	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   240: invokeinterface 703 1 0
    //   245: aload 8
    //   247: aload 7
    //   249: invokestatic 707	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   252: iconst_m1
    //   253: ireturn
    //   254: astore_1
    //   255: ldc_w 522
    //   258: new 493	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 709
    //   268: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   275: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: goto -47 -> 237
    //   287: aload 4
    //   289: invokestatic 738	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   292: istore_2
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 727	java/io/FileInputStream:close	()V
    //   301: getstatic 147	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   304: invokeinterface 703 1 0
    //   309: aload 8
    //   311: aload 7
    //   313: invokestatic 707	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   316: iload_2
    //   317: ireturn
    //   318: astore_1
    //   319: ldc_w 522
    //   322: new 493	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 709
    //   332: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   339: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: goto -47 -> 301
    //   351: astore 4
    //   353: aload 5
    //   355: astore_1
    //   356: aload 4
    //   358: astore 5
    //   360: aload_1
    //   361: astore 4
    //   363: ldc_w 522
    //   366: new 493	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 524
    //   376: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 5
    //   381: invokevirtual 525	java/lang/Exception:toString	()Ljava/lang/String;
    //   384: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_1
    //   394: ifnull +7 -> 401
    //   397: aload_1
    //   398: invokevirtual 727	java/io/FileInputStream:close	()V
    //   401: getstatic 147	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   404: invokeinterface 703 1 0
    //   409: aload 8
    //   411: aload 7
    //   413: invokestatic 707	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   416: iconst_m1
    //   417: ireturn
    //   418: astore_1
    //   419: ldc_w 522
    //   422: new 493	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 709
    //   432: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   439: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: goto -47 -> 401
    //   451: astore_1
    //   452: aload 4
    //   454: ifnull +8 -> 462
    //   457: aload 4
    //   459: invokevirtual 727	java/io/FileInputStream:close	()V
    //   462: getstatic 147	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   465: invokeinterface 703 1 0
    //   470: aload 8
    //   472: aload 7
    //   474: invokestatic 707	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   477: aload_1
    //   478: athrow
    //   479: astore 4
    //   481: ldc_w 522
    //   484: new 493	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 709
    //   494: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 4
    //   499: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   502: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: goto -49 -> 462
    //   514: aload 8
    //   516: aload 7
    //   518: invokestatic 707	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   521: iconst_m1
    //   522: ireturn
    //   523: astore 5
    //   525: aload_1
    //   526: astore 4
    //   528: aload 5
    //   530: astore_1
    //   531: goto -79 -> 452
    //   534: astore 5
    //   536: goto -176 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	WebView
    //   0	539	1	paramContext	Context
    //   292	25	2	i	int
    //   111	2	3	bool	boolean
    //   47	241	4	localObject1	Object
    //   351	6	4	localException1	Exception
    //   361	97	4	localContext1	Context
    //   479	19	4	localIOException	java.io.IOException
    //   526	1	4	localContext2	Context
    //   43	337	5	localObject2	Object
    //   523	6	5	localObject3	Object
    //   534	1	5	localException2	Exception
    //   40	152	6	localObject4	Object
    //   4	513	7	localFileOutputStream	java.io.FileOutputStream
    //   19	496	8	localFileLock	java.nio.channels.FileLock
    //   189	26	9	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   120	128	145	java/io/IOException
    //   233	237	254	java/io/IOException
    //   297	301	318	java/io/IOException
    //   49	58	351	java/lang/Exception
    //   62	99	351	java/lang/Exception
    //   107	112	351	java/lang/Exception
    //   182	191	351	java/lang/Exception
    //   195	204	351	java/lang/Exception
    //   397	401	418	java/io/IOException
    //   49	58	451	finally
    //   62	99	451	finally
    //   107	112	451	finally
    //   182	191	451	finally
    //   195	204	451	finally
    //   363	393	451	finally
    //   457	462	479	java/io/IOException
    //   204	224	523	finally
    //   287	293	523	finally
    //   204	224	534	java/lang/Exception
    //   287	293	534	java/lang/Exception
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    updateRebootStatus();
    return SDKEngine.getInstance(true).getTbsNeedReboot();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 36001;
  }
  
  private void init(Context paramContext)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(true);
    localSDKEngine.init(paramContext);
    this.isX5Core = localSDKEngine.isX5Core();
  }
  
  private boolean isQQ(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void query_settings_and_update()
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        if (WebView.mTbsConfig == null) {
          WebView.access$402(TbsConfigFile.getInstance(WebView.this.mContext));
        }
        WebView.mTbsConfig.loadProperties();
        WebView.this.tbs_use_syswebview_query.setChecked(WebView.mTbsConfig.mForceUseSystemWebview);
        WebView.this.tbs_use_qproxy_query.setChecked(WebView.mTbsConfig.mForceUseQqProxy);
      }
    }, 200L);
  }
  
  private void setAttributeForX5(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null) {}
    for (;;)
    {
      int i;
      int[] arrayOfInt;
      int k;
      try
      {
        int j = paramAttributeSet.getAttributeCount();
        i = 0;
        if (i < j)
        {
          if (!paramAttributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
            break label147;
          }
          arrayOfInt = getResources().getIntArray(16842974);
          k = paramAttributeSet.getAttributeIntValue(i, -1);
          if (k == arrayOfInt[1])
          {
            this.mX5WebView.getView().setVerticalScrollBarEnabled(false);
            this.mX5WebView.getView().setHorizontalScrollBarEnabled(false);
          }
          else if (k == arrayOfInt[2])
          {
            this.mX5WebView.getView().setVerticalScrollBarEnabled(false);
          }
        }
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
      return;
      if (k == arrayOfInt[3]) {
        this.mX5WebView.getView().setHorizontalScrollBarEnabled(false);
      }
      label147:
      i += 1;
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = mIsDayMode;
        if (paramBoolean == bool) {
          return;
        }
        mIsDayMode = paramBoolean;
        if (mNightModePaint == null)
        {
          mNightModePaint = new Paint();
          mNightModePaint.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (mNightModePaint.getAlpha() == NIGHT_MODE_ALPHA) {
            continue;
          }
          mNightModePaint.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (mNightModePaint.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      mNightModePaint.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      sWebviewsetWebContentsDebuggingEnabled = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
      if (sWebviewsetWebContentsDebuggingEnabled != null)
      {
        sWebviewsetWebContentsDebuggingEnabled.setAccessible(true);
        sWebviewsetWebContentsDebuggingEnabled.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    catch (Exception localException)
    {
      TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
      localException.printStackTrace();
    }
  }
  
  private void tbs_test_reset_settings()
  {
    if (mTbsConfig == null) {
      mTbsConfig = TbsConfigFile.getInstance(this.mContext);
    }
    boolean bool = mTbsConfig.resetProperties();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setTitle("提示");
    localBuilder.setPositiveButton("确定", null);
    if (bool) {
      localBuilder.setMessage("成功!");
    }
    for (;;)
    {
      localBuilder.create().show();
      return;
      localBuilder.setMessage("Ooops, 失败了!");
    }
  }
  
  static void updateRebootStatus()
  {
    if (mAppContext == null) {}
    SDKEngine localSDKEngine;
    int i;
    int j;
    do
    {
      do
      {
        return;
        localSDKEngine = SDKEngine.getInstance(true);
      } while (SDKEngine.mTbsNeedReboot);
      TbsCoreVerManager localTbsCoreVerManager = TbsCoreVerManager.getInstance(mAppContext);
      i = localTbsCoreVerManager.getTbsCoreInstallStatus();
      if (i == 2)
      {
        localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getTbsCoreInstallVer()));
        localSDKEngine.setTbsNeedReboot(true);
        return;
      }
      j = localTbsCoreVerManager.getTbsCoreCopyStatus();
      if (j == 1)
      {
        localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getTbsCoreCopyVer()));
        localSDKEngine.setTbsNeedReboot(true);
        return;
      }
    } while ((localSDKEngine.isX5Core()) || ((i != 3) && (j != 3)));
    localSDKEngine.setCalledCountKey(String.valueOf(SDKEngine.getTbsCoreVersion()));
    localSDKEngine.setTbsNeedReboot(true);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.mX5WebView.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addView(paramView);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean canGoBack()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBack();
    }
    return this.mX5WebView.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBackOrForward(paramInt);
    }
    return this.mX5WebView.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoForward();
    }
    return this.mX5WebView.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.isX5Core)
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomIn");
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return this.mX5WebView.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.isX5Core)
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomOut");
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return this.mX5WebView.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.mX5WebView.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearCache(paramBoolean);
      return;
    }
    this.mX5WebView.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearFormData();
      return;
    }
    this.mX5WebView.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearHistory();
      return;
    }
    this.mX5WebView.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearMatches();
      return;
    }
    this.mX5WebView.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearSslPreferences();
      return;
    }
    this.mX5WebView.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "clearView");
      return;
    }
    this.mX5WebView.clearView();
  }
  
  public void computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.computeScroll();
      return;
    }
    this.mX5WebView.computeScroll();
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.isX5Core) {
      return WebBackForwardList.wrap(this.mX5WebView.copyBackForwardList());
    }
    return WebBackForwardList.wrap(this.mSysWebView.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.isX5Core) {}
    while (Build.VERSION.SDK_INT < 21) {
      try
      {
        localObject = this.mX5WebView.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return ReflectionUtils.invokeInstance(this.mSysWebView, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void destroy()
  {
    Object localObject4;
    Object localObject1;
    int i;
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua2");
          localObject1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, (String)localObject4, (String)???, (String)localObject1, this.mPv, this.isX5Core);
      this.mPv = 0;
      this.mIsReported = false;
    }
    if (!this.isX5Core) {}
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.mSysWebView });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          i = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i);
        }
      }
    }
    catch (Exception localException2)
    {
      label359:
      break label359;
    }
    this.mSysWebView.destroy();
    try
    {
      ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
      ((Field)???).setAccessible(true);
      localObject1 = (ComponentCallbacks)((Field)???).get(null);
      if (localObject1 != null)
      {
        ((Field)???).set(null, null);
        ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
        ((Field)???).setAccessible(true);
        ??? = ((Field)???).get(null);
        if (??? != null)
        {
          synchronized ((List)???)
          {
            ((List)???).remove(localObject1);
            return;
          }
          this.mX5WebView.destroy();
        }
      }
    }
    catch (Exception localException1)
    {
      return;
    }
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.documentHasImages(paramMessage);
      return;
    }
    this.mX5WebView.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.mX5WebView.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.isX5Core) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.mX5WebView.getView(), new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramValueCallback)
      {
        paramValueCallback.printStackTrace();
        loadUrl(paramString);
        return;
      }
    }
    try
    {
      localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.mSysWebView, new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.isX5Core)
    {
      paramString = ReflectionUtils.invokeInstance(this.mSysWebView, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.mX5WebView.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.mX5WebView.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.mX5WebView.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.findNext(paramBoolean);
      return;
    }
    this.mX5WebView.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.mX5WebView.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "freeMemory");
      return;
    }
    this.mX5WebView.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getCertificate();
    }
    return this.mX5WebView.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getContentHeight();
    }
    return this.mX5WebView.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getFavicon();
    }
    return this.mX5WebView.getFavicon();
  }
  
  public HitTestResult getHitTestResult()
  {
    if (!this.isX5Core) {
      return new HitTestResult(this.mSysWebView.getHitTestResult());
    }
    return new HitTestResult(this.mX5WebView.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.mX5WebView.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getOriginalUrl();
    }
    return this.mX5WebView.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getProgress();
    }
    return this.mX5WebView.getProgress();
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.mX5WebView.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.mWebSettings != null) {
      return this.mWebSettings;
    }
    if (this.isX5Core)
    {
      localWebSettings = new WebSettings(this.mX5WebView.getSettings());
      this.mWebSettings = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.mSysWebView.getSettings());
    this.mWebSettings = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  android.webkit.WebView getSysWebView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return null;
  }
  
  public String getTitle()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getTitle();
    }
    return this.mX5WebView.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getUrl();
    }
    return this.mX5WebView.getUrl();
  }
  
  public View getView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return this.mX5WebView.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getVisibleTitleHeight();
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollX();
    }
    return this.mSysWebView.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollY();
    }
    Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getWebScrollY");
    if (localObject == null) {
      return this.mSysWebView.getScrollY();
    }
    return ((Integer)localObject).intValue();
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  IX5WebViewBase getX5WebView()
  {
    return this.mX5WebView;
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "getZoomControls");
    }
    return this.mX5WebView.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBack();
      return;
    }
    this.mX5WebView.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBackOrForward(paramInt);
      return;
    }
    this.mX5WebView.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goForward();
      return;
    }
    this.mX5WebView.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.invokeZoomPicker();
      return;
    }
    this.mX5WebView.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return mIsDayMode;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.isX5Core)
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "isPrivateBrowsingEnabled");
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return this.mX5WebView.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.mX5WebView.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.mX5WebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((paramString == null) || (showDebugView(paramString))) {
      return;
    }
    if (!this.isX5Core)
    {
      this.mSysWebView.loadUrl(paramString);
      return;
    }
    this.mX5WebView.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((paramString == null) || (showDebugView(paramString))) {}
    do
    {
      return;
      if (this.isX5Core) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.mSysWebView.loadUrl(paramString, paramMap);
    return;
    this.mX5WebView.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core);
      this.mPv = 0;
      this.mIsReported = false;
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.mOnLongClickListener != null)
    {
      if (!this.mOnLongClickListener.onLongClick(paramView)) {
        return callX5CoreOnLongClick(paramView);
      }
      return true;
    }
    return callX5CoreOnLongClick(paramView);
  }
  
  public void onPause()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onPause");
      return;
    }
    this.mX5WebView.onPause();
  }
  
  public void onResume()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onResume");
      return;
    }
    this.mX5WebView.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (isQQ(this.mContext)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0) && (getLayerType() != 2) && (this.mX5WebView != null) && (this.mX5WebView.getView() != null)) {
      this.mX5WebView.getView().setLayerType(2, null);
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.mContext == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (mCallerAppPackageName == null) {
      mCallerAppPackageName = this.mContext.getApplicationInfo().packageName;
    }
    if ((mCallerAppPackageName != null) && ((mCallerAppPackageName.equals("com.tencent.mm")) || (mCallerAppPackageName.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core);
      this.mPv = 0;
      this.mIsReported = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.overlayHorizontalScrollbar();
    }
    return this.mX5WebView.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.isX5Core) {
      return this.mX5WebView.overlayVerticalScrollbar();
    }
    return this.mSysWebView.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageDown(paramBoolean);
    }
    return this.mX5WebView.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageUp(paramBoolean);
    }
    return this.mX5WebView.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.pauseTimers();
      return;
    }
    this.mX5WebView.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.mX5WebView.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.reload();
      return;
    }
    this.mX5WebView.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      return;
    }
    this.mX5WebView.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.removeView(paramView);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.isX5Core)
    {
      localObject1 = this.mX5WebView.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.mSysWebView;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.mSysWebView;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestFocusNodeHref(paramMessage);
      return;
    }
    this.mX5WebView.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestImageRef(paramMessage);
      return;
    }
    this.mX5WebView.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.restoreState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.resumeTimers();
      return;
    }
    this.mX5WebView.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.mX5WebView.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.saveState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.isX5Core) {
      this.mSysWebView.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.mX5WebView.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setCertificate(paramSslCertificate);
      return;
    }
    this.mX5WebView.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.isX5Core) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          if (paramDownloadListener == null)
          {
            MttLoader.loadUrl(WebView.this.mContext, paramAnonymousString1, null);
            return;
          }
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
        }
      });
      return;
    }
    this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, paramDownloadListener, this.isX5Core));
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mSysWebView.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          }
        });
      }
      return;
    }
    this.mX5WebView.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.mX5WebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setInitialScale(paramInt);
      return;
    }
    this.mX5WebView.setInitialScale(paramInt);
  }
  
  public void setLongPressTextExtensionMenu(int paramInt)
  {
    if (this.isX5Core) {
      ReflectionUtils.invokeInstance(this.mX5WebView, "setLongPressTextExtensionMenu", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.mSysWebView.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.mX5WebView.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.mX5WebView.getView();
    try
    {
      if (this.longClickListener == null)
      {
        Object localObject2 = ReflectionUtils.getParentDeclaredMethod(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, (Object[])null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.longClickListener = ((Field)localObject2).get(localObject1);
      }
      this.mOnLongClickListener = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    if (!this.isX5Core)
    {
      if (paramPictureListener == null)
      {
        this.mSysWebView.setPictureListener(null);
        return;
      }
      this.mSysWebView.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          WebView.this.setSysWebView(paramAnonymousWebView);
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        }
      });
      return;
    }
    if (paramPictureListener == null)
    {
      this.mX5WebView.setPictureListener(null);
      return;
    }
    this.mX5WebView.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        WebView.this.setX5WebView(paramAnonymousIX5WebViewBase);
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.isX5Core)
    {
      this.mX5WebView.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.mSysWebView.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  void setSysWebView(android.webkit.WebView paramWebView)
  {
    if (!this.isX5Core) {}
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.mX5WebView != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.mX5WebView.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    return false;
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    SystemWebView localSystemWebView = null;
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebChromeClient == null) {}
      for (paramWebChromeClient = localSystemWebView;; paramWebChromeClient = new SmttWebChromeClient(SDKEngine.getInstance(true).wizard().createDefaultX5WebChromeClient(), this, paramWebChromeClient))
      {
        localIX5WebViewBase.setWebChromeClient(paramWebChromeClient);
        return;
      }
    }
    localSystemWebView = this.mSysWebView;
    if (paramWebChromeClient == null) {}
    for (paramWebChromeClient = localIX5WebViewBase;; paramWebChromeClient = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localSystemWebView.setWebChromeClient(paramWebChromeClient);
      return;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.isX5Core) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    SystemWebView localSystemWebView = null;
    this.mWebViewClient = paramWebViewClient;
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebViewClient == null) {}
      for (paramWebViewClient = localSystemWebView;; paramWebViewClient = new SmttWebViewClient(SDKEngine.getInstance(true).wizard().createDefaultX5WebViewClient(), this, paramWebViewClient))
      {
        localIX5WebViewBase.setWebViewClient(paramWebViewClient);
        return;
      }
    }
    localSystemWebView = this.mSysWebView;
    if (paramWebViewClient == null) {}
    for (paramWebViewClient = localIX5WebViewBase;; paramWebViewClient = new SystemWebViewClient(this, paramWebViewClient))
    {
      localSystemWebView.setWebViewClient(paramWebViewClient);
      return;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  void setX5WebView(IX5WebViewBase paramIX5WebViewBase)
  {
    this.mX5WebView = paramIX5WebViewBase;
  }
  
  public boolean showDebugView(final String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.startsWith("javascript:")) {
      return this.isShowDebugView;
    }
    if ((!paramString.equals("http://debugtbs.qq.com")) && (!paramString.startsWith("http://debugtbs.qq.com/")))
    {
      getView().setVisibility(0);
      if (this.isShowDebugView)
      {
        removeViewAt(1);
        this.isShowDebugView = false;
      }
      return false;
    }
    TbsLog.i("webview", "showDebugView...");
    if (this.isShowDebugView) {
      return true;
    }
    paramString = this.mContext;
    getView().setVisibility(4);
    Object localObject;
    if (this.mWebViewClient == null)
    {
      localObject = new WebViewClient();
      if (!this.isX5Core) {
        break label386;
      }
      this.mX5WebView.setWebViewClient(new SmttWebViewClient(SDKEngine.getInstance(true).wizard().createDefaultX5WebViewClient(), this, (WebViewClient)localObject));
    }
    for (;;)
    {
      localObject = new LinearLayout(paramString);
      ((LinearLayout)localObject).setBackgroundColor(-7829368);
      ((LinearLayout)localObject).setOrientation(1);
      Button localButton1 = new Button(paramString);
      localButton1.setText("安装本地TBS内核");
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent("com.tencent.smtt.installtbs");
          paramAnonymousView.setPackage("com.tencent.tbssuite");
          paramAnonymousView.putExtra("dest_package_name", paramString.getPackageName());
          paramString.sendBroadcast(paramAnonymousView);
          Toast.makeText(paramString, "#正在准备安装", 0).show();
          new Thread(new Runnable()
          {
            public void run()
            {
              int i = 0;
              final boolean bool = false;
              for (;;)
              {
                i += 1;
                if ((i < 10) && (!bool)) {}
                try
                {
                  Thread.sleep(1000L);
                  bool = TbsDownloader.installLocalTbs(WebView.2.this.val$context);
                }
                catch (Throwable localThrowable)
                {
                  StringWriter localStringWriter = new StringWriter();
                  localThrowable.printStackTrace(new PrintWriter(localStringWriter));
                  TbsLog.e("webview", "install tbs exceptions:" + localStringWriter.toString());
                }
              }
              WebView.this.getView().post(new Runnable()
              {
                public void run()
                {
                  String str = "无法安装，请检查是否放入了正确的TBS内核!";
                  if (bool) {
                    str = "安装中，请等待...";
                  }
                  Toast.makeText(WebView.2.this.val$context, "#" + str, 0).show();
                }
              });
              return;
            }
          }).start();
        }
      });
      final Button localButton2 = new Button(paramString);
      localButton2.setText("安装线上TBS内核");
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (QbSdk.mTbsDebugInstallOnline)
          {
            paramAnonymousView = new AlertDialog.Builder(paramString);
            paramAnonymousView.setTitle("提示");
            paramAnonymousView.setPositiveButton("确定", null);
            paramAnonymousView.setMessage("正在进行线上安装，请等待!");
            paramAnonymousView.create().show();
          }
          for (;;)
          {
            return;
            try
            {
              paramAnonymousView = WebView.TBS_DEBUG_INSTALL_ONLINE + paramString.getPackageName();
              Settings.System.putString(WebView.this.mContext.getContentResolver(), paramAnonymousView, "true");
              QbSdk.mTbsDebugInstallOnline = true;
              QbSdk.reset(paramString);
              if (!TbsDownloader.needDownload(paramString)) {
                continue;
              }
              TbsDownloader.startDownload(paramString);
              return;
            }
            catch (SecurityException paramAnonymousView)
            {
              for (;;)
              {
                paramAnonymousView.printStackTrace();
              }
            }
          }
        }
      });
      QbSdk.mTbsListenerDebug = new TbsListener()
      {
        public void onDownloadFinish(int paramAnonymousInt)
        {
          if (!WebView.this.isShowDebugView) {
            return;
          }
          if (paramAnonymousInt == 100)
          {
            Toast.makeText(paramString, "#" + "下载成功", 0).show();
            WebView.this.post(new Runnable()
            {
              public void run()
              {
                WebView.4.this.val$install_online.setText("安装线上TBS内核 - 100%");
              }
            });
            return;
          }
          if (paramAnonymousInt == 120)
          {
            Toast.makeText(paramString, "#" + "本地已有需要下载的TBS版本，虽然不需要下载，但会使用本地的TBS版本进行安装", 0).show();
            return;
          }
          if (paramAnonymousInt == 110)
          {
            Toast.makeText(paramString, "#" + "不需要下载 2.1以下的ROM不需要下载；后台没有合适的版本不需要下载；正在下载过程中又开始了新的下载所以不需要下载", 0).show();
            return;
          }
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramString);
          localBuilder.setTitle("提示");
          localBuilder.setPositiveButton("确定", null);
          localBuilder.setMessage("下载失败 - " + paramAnonymousInt + "!");
          localBuilder.create().show();
          WebView.this.post(new Runnable()
          {
            public void run()
            {
              WebView.4.this.val$install_online.setText("安装线上TBS内核");
            }
          });
        }
        
        public void onDownloadProgress(final int paramAnonymousInt)
        {
          if (!WebView.this.isShowDebugView) {
            return;
          }
          WebView.this.post(new Runnable()
          {
            public void run()
            {
              WebView.4.this.val$install_online.setText("安装线上TBS内核 - " + paramAnonymousInt + "%");
            }
          });
        }
        
        public void onInstallFinish(int paramAnonymousInt)
        {
          String str2;
          Object localObject;
          if (QbSdk.mTbsDebugInstallOnline)
          {
            str2 = WebView.TBS_DEBUG_INSTALL_ONLINE + paramString.getPackageName();
            localObject = null;
          }
          AlertDialog.Builder localBuilder;
          try
          {
            String str1 = Settings.System.getString(WebView.this.mContext.getContentResolver(), str2);
            localObject = str1;
          }
          catch (SecurityException localSecurityException2)
          {
            try
            {
              Settings.System.putString(WebView.this.mContext.getContentResolver(), str2, "false");
              QbSdk.mTbsDebugInstallOnline = false;
              if (!WebView.this.isShowDebugView)
              {
                return;
                localSecurityException2 = localSecurityException2;
                localSecurityException2.printStackTrace();
              }
            }
            catch (SecurityException localSecurityException1)
            {
              for (;;)
              {
                localSecurityException1.printStackTrace();
              }
              localBuilder = new AlertDialog.Builder(paramString);
              localBuilder.setTitle("提示");
              localBuilder.setPositiveButton("确定", null);
              if (paramAnonymousInt == 200) {
                break label164;
              }
            }
          }
          if (((localObject == null) || (!localObject.equals("true"))) || ((paramAnonymousInt == 220) || (paramAnonymousInt == 221))) {
            label164:
            localBuilder.setMessage("安装成功!");
          }
          for (;;)
          {
            localBuilder.create().show();
            return;
            localBuilder.setMessage("安装失败 - " + paramAnonymousInt + "!");
          }
        }
      };
      Button localButton3 = new Button(paramString);
      localButton3.setText("清除TBS内核");
      localButton3.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          WebView.this.post(new Runnable()
          {
            public void run()
            {
              QbSdk.reset(WebView.5.this.val$context);
              AlertDialog.Builder localBuilder = new AlertDialog.Builder(WebView.5.this.val$context);
              localBuilder.setTitle("提示");
              localBuilder.setPositiveButton("确定", null);
              localBuilder.setMessage("删除成功!");
              localBuilder.create().show();
            }
          });
        }
      });
      Button localButton4 = new Button(paramString);
      localButton4.setText("TBS选项设置");
      localButton4.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          WebView.this.post(new Runnable()
          {
            public void run()
            {
              if ((LinearLayout)WebView.6.this.val$layout.getChildAt(4) == null)
              {
                LinearLayout localLinearLayout = WebView.this.getDebugSettingsView();
                WebView.6.this.val$layout.addView(localLinearLayout, 4);
              }
            }
          });
        }
      });
      ((LinearLayout)localObject).addView(localButton1, 0);
      ((LinearLayout)localObject).addView(localButton2, 1);
      ((LinearLayout)localObject).addView(localButton3, 2);
      ((LinearLayout)localObject).addView(localButton4, 3);
      paramString = new ScrollView(paramString);
      paramString.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      ((LinearLayout)localObject).requestFocus();
      this.isShowDebugView = true;
      return this.isShowDebugView;
      label386:
      this.mSysWebView.setWebViewClient(new SystemWebViewClient(this, (WebViewClient)localObject));
    }
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.stopLoading();
      return;
    }
    this.mX5WebView.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_computeScroll();
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!this.isX5Core) {
      bool = this.mSysWebView.super_dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      View localView = this.mX5WebView.getView();
      try
      {
        paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
        if (paramMotionEvent != null)
        {
          bool = ((Boolean)paramMotionEvent).booleanValue();
          return bool;
        }
      }
      catch (Throwable paramMotionEvent) {}
    }
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!this.isX5Core) {
      bool = this.mSysWebView.super_onInterceptTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      View localView = this.mX5WebView.getView();
      try
      {
        paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
        if (paramMotionEvent != null)
        {
          bool = ((Boolean)paramMotionEvent).booleanValue();
          return bool;
        }
      }
      catch (Throwable paramMotionEvent) {}
    }
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!this.isX5Core) {
      bool = this.mSysWebView.super_onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      View localView = this.mX5WebView.getView();
      try
      {
        paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
        if (paramMotionEvent != null)
        {
          bool = ((Boolean)paramMotionEvent).booleanValue();
          return bool;
        }
      }
      catch (Throwable paramMotionEvent) {}
    }
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.mX5WebView.getView();
    try
    {
      localObject = ReflectionUtils.invokeInstance(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == mIsDayMode) {
      return;
    }
    mIsDayMode = paramBoolean;
    if (mIsDayMode)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!mIsDayMode)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  /* Error */
  void writetbscorepvfile(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1018	com/tencent/smtt/sdk/WebView:getTbsCorePV	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +80 -> 88
    //   11: new 493	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1726
    //   21: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: iconst_1
    //   26: iadd
    //   27: invokestatic 888	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_1
    //   38: ldc_w 485
    //   41: iconst_0
    //   42: invokevirtual 489	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   45: astore_1
    //   46: new 491	java/io/File
    //   49: dup
    //   50: new 493	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 494	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 498	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: getstatic 501	java/io/File:separator	Ljava/lang/String;
    //   64: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 506
    //   70: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc_w 512
    //   79: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +11 -> 95
    //   87: return
    //   88: ldc_w 1728
    //   91: astore_3
    //   92: goto -55 -> 37
    //   95: aload_1
    //   96: invokevirtual 1732	java/io/File:getParentFile	()Ljava/io/File;
    //   99: invokevirtual 1735	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: aload_1
    //   104: invokevirtual 1738	java/io/File:isFile	()Z
    //   107: ifeq +10 -> 117
    //   110: aload_1
    //   111: invokevirtual 517	java/io/File:exists	()Z
    //   114: ifne +8 -> 122
    //   117: aload_1
    //   118: invokevirtual 1741	java/io/File:createNewFile	()Z
    //   121: pop
    //   122: new 1743	java/io/FileOutputStream
    //   125: dup
    //   126: aload_1
    //   127: iconst_0
    //   128: invokespecial 1746	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   131: putstatic 149	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   134: getstatic 149	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   137: aload_3
    //   138: invokevirtual 1750	java/lang/String:getBytes	()[B
    //   141: invokevirtual 1756	java/io/OutputStream:write	([B)V
    //   144: getstatic 149	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   147: ifnull -60 -> 87
    //   150: getstatic 149	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   153: invokevirtual 1759	java/io/OutputStream:flush	()V
    //   156: return
    //   157: astore_1
    //   158: getstatic 149	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   161: ifnull +9 -> 170
    //   164: getstatic 149	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   167: invokevirtual 1759	java/io/OutputStream:flush	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	WebView
    //   0	174	1	paramContext	Context
    //   5	22	2	i	int
    //   36	102	3	str	String
    // Exception table:
    //   from	to	target	type
    //   95	117	157	finally
    //   117	122	157	finally
    //   122	144	157	finally
    //   144	156	172	java/lang/Throwable
    //   158	170	172	java/lang/Throwable
    //   170	172	172	java/lang/Throwable
  }
  
  public boolean zoomIn()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomIn();
    }
    return this.mX5WebView.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomOut();
    }
    return this.mX5WebView.zoomOut();
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult mHitTestResultImpl;
    private android.webkit.WebView.HitTestResult mSysHitTestResult = null;
    
    public HitTestResult()
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = paramHitTestResult;
      this.mSysHitTestResult = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.mHitTestResultImpl != null) {
        str = this.mHitTestResultImpl.getExtra();
      }
      while (this.mSysHitTestResult == null) {
        return str;
      }
      return this.mSysHitTestResult.getExtra();
    }
    
    public int getType()
    {
      int i = 0;
      if (this.mHitTestResultImpl != null) {
        i = this.mHitTestResultImpl.getType();
      }
      while (this.mSysHitTestResult == null) {
        return i;
      }
      return this.mSysHitTestResult.getType();
    }
    
    public void setExtra(String paramString)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setExtra(paramString);
      }
    }
    
    public void setType(int paramInt)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setType(paramInt);
      }
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  private class SystemWebView
    extends android.webkit.WebView
  {
    public SystemWebView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SystemWebView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      CookieSyncManager.createInstance(WebView.this.mContext).startSync();
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
        WebView.mSysWebviewCreated = true;
        return;
      }
      catch (Exception this$1) {}
    }
    
    public void computeScroll()
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        return;
      }
      super.computeScroll();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.mIsDayMode) && (WebView.mNightModePaint != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.mNightModePaint);
          paramCanvas.restore();
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public android.webkit.WebSettings getSettings()
    {
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        return localWebSettings;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
      }
      while (Build.VERSION.SDK_INT < 9) {
        return;
      }
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.this.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public void super_computeScroll()
    {
      super.computeScroll();
    }
    
    public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
  }
  
  public class WebViewTransport
  {
    private WebView mWebview;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.mWebview;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.mWebview = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */