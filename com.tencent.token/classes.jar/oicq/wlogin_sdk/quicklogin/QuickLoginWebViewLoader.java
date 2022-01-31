package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
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
    if (Build.VERSION.SDK_INT == 17) {
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
      catch (Exception paramContext) {}catch (Error paramContext) {}
    }
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
    if (true == paramIntent.getBooleanExtra("isUserAccountLocked", false))
    {
      i = 1;
      if (true != paramIntent.getBooleanExtra("forceWebLogin", false)) {
        break label106;
      }
    }
    label106:
    for (int j = 1;; j = 0)
    {
      if (0L != l) {
        break label111;
      }
      util.LOGI("QuickLoginWebViewActivity get appid failed");
      return;
      i = 0;
      break;
    }
    label111:
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
    RelativeLayout localRelativeLayout = new RelativeLayout(paramActivity);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    int k = paramActivity.getWindowManager().getDefaultDisplay().getHeight();
    int m = (int)(0.07000000000000001D * k);
    localObject2 = new TextView(paramActivity);
    for (;;)
    {
      try
      {
        ((TextView)localObject2).setBackgroundColor(Color.parseColor((String)localObject1));
        ((TextView)localObject2).setTextColor(Color.parseColor(paramIntent));
        ((TextView)localObject2).setText("");
        ((TextView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, m));
        localRelativeLayout.addView((View)localObject2);
        localObject2 = new Button(paramActivity);
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        try
        {
          ((Button)localObject2).setBackgroundColor(Color.parseColor((String)localObject1));
          ((Button)localObject2).setTextColor(Color.parseColor(paramIntent));
          ((Button)localObject2).setText("关闭");
          ((Button)localObject2).setPadding(15, ((Button)localObject2).getPaddingTop(), 15, ((Button)localObject2).getPaddingBottom());
          ((Button)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-2, m));
          localRelativeLayout.addView((View)localObject2);
          ((Button)localObject2).setOnClickListener(new a(paramActivity));
          try
          {
            localObject2 = new WebView(paramActivity);
            paramIntent = new RelativeLayout.LayoutParams(-1, k - m);
            paramIntent.setMargins(0, m, 0, 0);
            ((WebView)localObject2).setLayoutParams(paramIntent);
            localRelativeLayout.addView((View)localObject2);
            paramActivity.setContentView(localRelativeLayout);
            localObject1 = ((WebView)localObject2).getSettings();
            ((WebSettings)localObject1).setUseWideViewPort(true);
            ((WebSettings)localObject1).setLoadWithOverviewMode(true);
            if (17 > Build.VERSION.SDK_INT) {
              break label857;
            }
            ((WebView)localObject2).addJavascriptInterface(new QuikLoginJSInterface(paramActivity), "WTLogin");
            paramIntent = "javascript:function wtCB(uin, sig, input) { WTLogin.ptloginCallBack(uin, sig, input); }function wtAlert(input) { WTLogin.ptAlertCallBack(input); }";
            disableAccessibility(paramActivity);
            ((WebSettings)localObject1).setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11)
            {
              ((WebView)localObject2).removeJavascriptInterface("searchBoxJavaBridge_");
              ((WebView)localObject2).removeJavascriptInterface("accessibility");
              ((WebView)localObject2).removeJavascriptInterface("accessibilityTraversal");
            }
            if (17 > Build.VERSION.SDK_INT) {
              ((WebView)localObject2).setWebChromeClient(new b(localQuikLoginJSInterface));
            }
            ((WebView)localObject2).setWebViewClient(new c(paramActivity, (WebView)localObject2, paramIntent));
            if ((str == null) || (str.length() == 0)) {
              break label864;
            }
            localObject1 = "&default_uin=" + str + "&pt_lock_uin=" + i;
            paramActivity.runOnUiThread(new g((WebView)localObject2, "https://xui.ptlogin2.qq.com/cgi-bin/xlogin?appid=" + l + "&style=42&s_url=http://wtlogin.qq.com/&pt_no_onekey=1&pt_no_auth=1&daid=499&wt_force_pwd=" + j + (String)localObject1, paramIntent));
            return;
          }
          catch (Exception paramActivity)
          {
            util.LOGI("create webview failed " + paramActivity.getMessage(), "");
            return;
          }
          catch (Error paramActivity)
          {
            util.LOGI("create webview failed " + paramActivity.getMessage(), "");
            return;
          }
          localIllegalArgumentException1 = localIllegalArgumentException1;
          util.LOGI("color error titleBackgroundColor " + (String)localObject1 + " titleTextColor " + paramIntent, "");
          Log.e("wtlogin", "color error titleBackgroundColor " + (String)localObject1 + " titleTextColor " + paramIntent);
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          util.LOGI("color error titleBackgroundColor " + (String)localObject1 + " titleTextColor " + paramIntent, "");
          Log.e("wtlogin", "color error titleBackgroundColor " + (String)localObject1 + " titleTextColor " + paramIntent);
          continue;
        }
      }
      label857:
      paramIntent = "javascript:function wtCB(uin, sig, input) { return prompt(JSON.stringify({ uin:''+uin, sig:''+sig, input:''+input})); }";
      continue;
      label864:
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader
 * JD-Core Version:    0.7.0.1
 */