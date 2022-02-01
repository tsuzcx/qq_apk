package com.tencent.qqmail.activity.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMTopBar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SecurityAppTipsActivity
  extends BaseActivity
{
  public static String PARAM_SECAPPURL = "param_secappurl";
  public static final String TAG = "SecAppTipsActivity";
  private static HashMap<String, String> featureMap = null;
  
  public static void addFeature(String paramString1, String paramString2)
  {
    if (featureMap == null) {
      featureMap = new HashMap();
    }
    QMLog.log(4, "SecAppTipsActivity", "secapp. addFeature:" + paramString1 + "," + paramString2);
    featureMap.put(paramString1, paramString2);
  }
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SecurityAppTipsActivity.class);
    localIntent.putExtra(PARAM_SECAPPURL, paramString);
    return localIntent;
  }
  
  public static void execIntent(String paramString)
  {
    Log.v("mason", "secapp. execIntent featureId:" + paramString);
    if ((featureMap != null) && (featureMap.containsKey(paramString)))
    {
      paramString = (String)featureMap.get(paramString);
      Object localObject1 = Runtime.getRuntime();
      int i;
      StringBuffer localStringBuffer;
      try
      {
        Object localObject2 = "/system/bin/" + paramString;
        QMLog.log(4, "SecAppTipsActivity", "go exec:" + (String)localObject2);
        localObject1 = ((Runtime)localObject1).exec(((String)localObject2).split(" "));
        i = ((Process)localObject1).waitFor();
        localObject2 = new BufferedReader(new InputStreamReader(((Process)localObject1).getInputStream()));
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("");
        for (;;)
        {
          String str = ((BufferedReader)localObject2).readLine();
          if (str == null) {
            break;
          }
          localStringBuffer.append(str).append("\n");
        }
        ((BufferedReader)localObject2).close();
      }
      catch (Exception localException)
      {
        QMLog.log(6, "SecAppTipsActivity", "err exec intent:" + paramString);
        return;
      }
      localException.destroy();
      QMLog.log(4, "SecAppTipsActivity", "intent mExitValue:" + i + ",intent output:" + localStringBuffer.toString());
      return;
    }
    QMLog.log(5, "SecAppTipsActivity", "execIntent. no feature found");
  }
  
  @SuppressLint({"NewApi"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558514);
    paramBundle = getIntent().getStringExtra(PARAM_SECAPPURL);
    if ((paramBundle == null) || (paramBundle.equals("")))
    {
      QMLog.log(5, "SecAppTipsActivity", "url null.");
      return;
    }
    Object localObject = (QMTopBar)findViewById(2131374722);
    ((QMTopBar)localObject).setVisibility(0);
    ((QMTopBar)localObject).setButtonLeftIcon(2130841088);
    ((QMTopBar)localObject).getButtonLeft().setOnClickListener(new SecurityAppTipsActivity.1(this));
    localObject = (WebView)findViewById(2131382171);
    ((WebView)localObject).getSettings().setAllowFileAccess(true);
    ((WebView)localObject).getSettings().setLoadsImagesAutomatically(true);
    ((WebView)localObject).getSettings().setJavaScriptEnabled(false);
    if (Build.VERSION.SDK_INT >= 11) {
      ((WebView)localObject).removeJavascriptInterface("searchBoxJavaBridge_");
    }
    Log.v("mason", "secapp. url:" + paramBundle);
    ((WebView)localObject).loadUrl(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    featureMap = null;
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SecurityAppTipsActivity
 * JD-Core Version:    0.7.0.1
 */