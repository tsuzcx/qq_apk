package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.lang.reflect.Method;
import oicq.wlogin_sdk.tools.util;

public class QuickLoginWebViewLoader
{
  static int finishAnimEnter = 0;
  static int finishAnimExit = 0;
  static final String link = "https://xui.ptlogin2.qq.com/cgi-bin/xlogin";
  static boolean sslErrorProcessed = false;
  
  public static void disableAccessibility(Context paramContext)
  {
    if (Build.VERSION.SDK_INT == 17) {}
    try
    {
      paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
      if (!paramContext.isEnabled()) {
        return;
      }
      Method localMethod = paramContext.getClass().getDeclaredMethod("setState", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(paramContext, new Object[] { Integer.valueOf(0) });
      return;
    }
    catch (Exception paramContext)
    {
      return;
    }
    catch (Error paramContext) {}
    return;
  }
  
  public static void load(Activity paramActivity, Intent paramIntent)
  {
    finishAnimEnter = paramIntent.getIntExtra("finishAnimEnter", 0);
    finishAnimExit = paramIntent.getIntExtra("finishAnimExit", 0);
    QuikLoginJSInterface localQuikLoginJSInterface = new QuikLoginJSInterface(paramActivity);
    sslErrorProcessed = false;
    if (paramIntent == null)
    {
      util.LOGI("QuickLoginWebViewLoader.load parameter data is null", null);
      return;
    }
    long l = paramIntent.getLongExtra("appid", 0L);
    String str = paramIntent.getStringExtra("account");
    int i;
    if (true == paramIntent.getBooleanExtra("isUserAccountLocked", false)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (true == paramIntent.getBooleanExtra("forceWebLogin", false)) {
      j = 1;
    } else {
      j = 0;
    }
    if (0L == l)
    {
      util.LOGI("QuickLoginWebViewActivity get appid failed");
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("titleBackgroundColor");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "#3F51B5";
    }
    localObject2 = paramIntent.getStringExtra("titleTextColor");
    if (localObject2 != null)
    {
      paramIntent = (Intent)localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      paramIntent = "#FFFFFF";
    }
    localObject2 = new RelativeLayout(paramActivity);
    ((RelativeLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    int n = paramActivity.getWindowManager().getDefaultDisplay().getHeight();
    double d = n;
    Double.isNaN(d);
    int k = (int)(d * 0.07000000000000001D);
    int m;
    if (80 > k)
    {
      k = 80;
      m = 1;
    }
    else
    {
      m = 0;
    }
    Object localObject3 = new TextView(paramActivity);
    try
    {
      ((TextView)localObject3).setBackgroundColor(Color.parseColor((String)localObject1));
      ((TextView)localObject3).setTextColor(Color.parseColor(paramIntent));
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      label278:
      StringBuilder localStringBuilder;
      break label278;
    }
    localStringBuilder = new StringBuilder("color error titleBackgroundColor ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" titleTextColor ");
    localStringBuilder.append(paramIntent);
    util.LOGI(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder("color error titleBackgroundColor ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" titleTextColor ");
    localStringBuilder.append(paramIntent);
    ((TextView)localObject3).setText("");
    ((TextView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, k));
    ((RelativeLayout)localObject2).addView((View)localObject3);
    localObject3 = new Button(paramActivity);
    try
    {
      ((Button)localObject3).setBackgroundColor(Color.parseColor((String)localObject1));
      ((Button)localObject3).setTextColor(Color.parseColor(paramIntent));
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      label417:
      int i1;
      int i2;
      break label417;
    }
    localStringBuilder = new StringBuilder("color error titleBackgroundColor ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" titleTextColor ");
    localStringBuilder.append(paramIntent);
    util.LOGI(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder("color error titleBackgroundColor ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" titleTextColor ");
    localStringBuilder.append(paramIntent);
    ((Button)localObject3).setText("关闭");
    i1 = ((Button)localObject3).getPaddingTop();
    i2 = ((Button)localObject3).getPaddingBottom();
    if (1 == m) {
      ((Button)localObject3).setPadding(15, 0, 15, 0);
    } else {
      ((Button)localObject3).setPadding(15, i1, 15, i2);
    }
    ((Button)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-2, k));
    ((RelativeLayout)localObject2).addView((View)localObject3);
    ((Button)localObject3).setOnClickListener(new a(paramActivity));
    try
    {
      localObject3 = new WebView(paramActivity);
      paramIntent = new RelativeLayout.LayoutParams(-1, n - k);
      paramIntent.setMargins(0, k, 0, 0);
      ((WebView)localObject3).setLayoutParams(paramIntent);
      ((RelativeLayout)localObject2).addView((View)localObject3);
      paramActivity.setContentView((View)localObject2);
      localObject1 = ((WebView)localObject3).getSettings();
      ((WebSettings)localObject1).setUseWideViewPort(true);
      ((WebSettings)localObject1).setLoadWithOverviewMode(true);
      if (17 <= Build.VERSION.SDK_INT)
      {
        ((WebView)localObject3).addJavascriptInterface(new QuikLoginJSInterface(paramActivity), "WTLogin");
        paramIntent = "javascript:function wtCB(uin, sig, input) { WTLogin.ptloginCallBack(uin, sig, input); }function wtAlert(input) { WTLogin.ptAlertCallBack(input); }";
      }
      else
      {
        paramIntent = "javascript:function wtCB(uin, sig, input) { return prompt(JSON.stringify({ uin:''+uin, sig:''+sig, input:''+input})); }";
      }
      disableAccessibility(paramActivity);
      ((WebSettings)localObject1).setJavaScriptEnabled(true);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((WebView)localObject3).removeJavascriptInterface("searchBoxJavaBridge_");
        ((WebView)localObject3).removeJavascriptInterface("accessibility");
        ((WebView)localObject3).removeJavascriptInterface("accessibilityTraversal");
      }
      if (17 > Build.VERSION.SDK_INT) {
        ((WebView)localObject3).setWebChromeClient(new b(localQuikLoginJSInterface));
      }
      ((WebView)localObject3).setWebViewClient(new c(paramActivity, (WebView)localObject3, paramIntent));
      localObject2 = "";
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.length() != 0)
        {
          localObject1 = new StringBuilder("&default_uin=");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("&pt_lock_uin=");
          ((StringBuilder)localObject1).append(i);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      localObject2 = new StringBuilder("https://xui.ptlogin2.qq.com/cgi-bin/xlogin?appid=");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("&style=42&s_url=https://wtlogin.qq.com/&pt_no_onekey=1&pt_no_auth=1&daid=499&wt_force_pwd=");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append((String)localObject1);
      paramActivity.runOnUiThread(new g((WebView)localObject3, ((StringBuilder)localObject2).toString(), paramIntent));
      return;
    }
    catch (Error paramActivity)
    {
      paramIntent = new StringBuilder("create webview failed ");
      paramIntent.append(paramActivity.getMessage());
      util.LOGI(paramIntent.toString(), "");
      return;
    }
    catch (Exception paramActivity)
    {
      paramIntent = new StringBuilder("create webview failed ");
      paramIntent.append(paramActivity.getMessage());
      util.LOGI(paramIntent.toString(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader
 * JD-Core Version:    0.7.0.1
 */