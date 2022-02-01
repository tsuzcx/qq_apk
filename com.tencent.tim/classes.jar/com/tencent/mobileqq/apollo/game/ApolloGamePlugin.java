package com.tencent.mobileqq.apollo.game;

import abll;
import abll.a;
import ablq;
import abmt;
import acfp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import ardm.k;
import arhz;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import svi;

public class ApolloGamePlugin
  extends VasWebviewJsPlugin
{
  private static int cpI;
  public static List<WeakReference<ApolloGamePlugin>> wm = new ArrayList();
  private String YP;
  private ablq a;
  private boolean bDE;
  private String bgQ = "";
  protected BroadcastReceiver mBroadcastReceiver;
  
  public ApolloGamePlugin()
  {
    this.mPluginNameSpace = "apolloGame";
  }
  
  private void BV(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() < 500)) {
      QLog.e("sava", 1, paramString);
    }
  }
  
  private boolean Yw()
  {
    return (!TextUtils.isEmpty(this.bgQ)) && (!"Android.H5".equals(this.bgQ));
  }
  
  private String iv(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf("?");
      str = paramString;
      if (i >= 0)
      {
        str = paramString;
        if (i < paramString.length()) {
          str = paramString.substring(0, i);
        }
      }
    }
    return str;
  }
  
  private boolean js(String paramString)
  {
    boolean bool2 = true;
    if (this.bDE) {
      return false;
    }
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = iv(paramString);
      if ((!TextUtils.isEmpty(str)) && (str.endsWith(".js")))
      {
        bool1 = true;
        if ((!bool1) && (!TextUtils.isEmpty(this.YP)))
        {
          str = this.YP;
          paramString = iv(paramString);
          str = iv(str);
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (paramString.trim().equals(str.trim()))) {
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      continue;
      continue;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void BU(String paramString)
  {
    this.bgQ = paramString;
    if ((wm != null) && (!TextUtils.isEmpty(this.bgQ))) {
      wm.add(new WeakReference(this));
    }
    this.mBroadcastReceiver = new GameEventReceiver();
    paramString = new IntentFilter();
    paramString.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.mRuntime != null)
      {
        AppInterface localAppInterface = this.mRuntime.a();
        if (localAppInterface != null) {
          localAppInterface.getApplication().registerReceiver(this.mBroadcastReceiver, paramString, "com.tencent.tim.msg.permission.pushnotify", null);
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGamePlugin", 1, paramString, new Object[0]);
    }
  }
  
  public void DH()
  {
    if (this.mRuntime != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = this.mRuntime.a(this.mRuntime.getActivity());
        if ((localObject1 != null) && ((localObject1 instanceof ardm.k)))
        {
          localObject1 = (ardm.k)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((ardm.k)localObject1).b().b();
            if ((localObject1 != null) && (((arhz)localObject1).isShowing())) {
              ((arhz)localObject1).dismiss();
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGamePlugin", 1, localThrowable, new Object[0]);
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void eq(String paramString1, String paramString2)
  {
    if (this.a != null) {
      this.a.y(0, paramString1, paramString2);
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (Yw())) {}
    for (;;)
    {
      boolean bool;
      try
      {
        bool = js(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject = Uri.parse(paramString).getQueryParameter("_gameid");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!URLUtil.isNetworkUrl(paramString))) {
            break label211;
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label168;
          }
          if (((String)localObject).trim().equals(this.bgQ))
          {
            localObject = abll.a().a(paramString, this.bgQ);
            if (localObject == null)
            {
              BV(acfp.m(2131702504) + paramString);
              if (!bool) {
                break;
              }
              return new WebResourceResponse();
            }
            return ((abll.a)localObject).a();
          }
          paramString = new WebResourceResponse();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGamePlugin", 1, paramString, new Object[0]);
      }
      label168:
      label211:
      do
      {
        return null;
        BV(acfp.m(2131702525) + paramString);
        if (bool)
        {
          paramString = new WebResourceResponse();
          return paramString;
        }
        return null;
      } while (!bool);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (8589934593L == paramLong)
    {
      if ((this.a == null) && (this.mRuntime != null))
      {
        this.a = new ablq(this.bgQ);
        this.a.c(this.mRuntime.getWebView());
      }
      if (this.a != null) {
        this.a.DM(this.bDE);
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (8589934594L == paramLong)
      {
        if (this.a != null) {
          this.a.onLoadFinish(this.bDE);
        } else {
          QLog.e("ApolloGamePlugin", 1, "[handleEvent] jscontext is null");
        }
      }
      else if (8589934595L != paramLong) {}
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (paramString1 != null) {
      for (;;)
      {
        try
        {
          if ((!"apolloGame".equals(paramString2)) || (paramString3 == null)) {
            break;
          }
          Object localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
          if (localObject == null) {
            break label188;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGamePlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString() + " " + paramString3);
          }
          if (paramString3.equals("send"))
          {
            if (this.a == null) {
              continue;
            }
            String str = ((JSONObject)localObject).optString("cmd");
            localObject = ((JSONObject)localObject).optString("dataStr");
            if (this.a != null) {
              this.a.send(str, (String)localObject);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloGamePlugin", 1, localThrowable, new Object[] { "[handleJsRequest]" });
          continue;
        }
        return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
        QLog.e("ApolloGamePlugin", 1, "[handleJsRequest] jscontext null");
      }
    }
    bool = false;
    label188:
    return bool;
  }
  
  public void onCreate()
  {
    super.onCreate();
    cpI += 1;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    cpI -= 1;
    if (cpI == 0) {
      abll.a().destroy();
    }
    try
    {
      if ((this.mBroadcastReceiver != null) && (this.mRuntime != null)) {
        this.mRuntime.a().getApplication().unregisterReceiver(this.mBroadcastReceiver);
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloGamePlugin", 1, "[doDestroy] exception=", localException);
      }
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    Intent localIntent = getInfoIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("game_busid");
      if (!TextUtils.isEmpty(str))
      {
        BU(str);
        if ((this.a == null) && (paramCustomWebView != null))
        {
          this.a = new ablq(str);
          this.a.c(this.mRuntime.getWebView());
          this.YP = localIntent.getStringExtra("url");
          this.bDE = true;
        }
      }
      return;
    }
    QLog.e("ApolloGamePlugin", 1, "bus empty");
  }
  
  public void y(int paramInt, String paramString1, String paramString2)
  {
    if (this.a != null) {
      this.a.y(paramInt, paramString1, paramString2);
    }
  }
  
  public class GameEventReceiver
    extends BroadcastReceiver
  {
    public GameEventReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {
        QLog.e("ApolloGamePlugin", 1, "[onReceive] intent null");
      }
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGamePlugin", 2, new Object[] { "[onReceive] action=", paramContext });
          }
        } while ((abmt.a() == null) || (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
        paramContext = paramIntent.getStringExtra("data");
      } while (TextUtils.isEmpty(ApolloGamePlugin.a(ApolloGamePlugin.this)));
      ApolloGamePlugin.this.y(0, "sc.apolloGameWebMessage.local", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin
 * JD-Core Version:    0.7.0.1
 */