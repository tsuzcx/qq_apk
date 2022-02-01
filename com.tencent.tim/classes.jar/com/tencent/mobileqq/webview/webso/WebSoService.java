package com.tencent.mobileqq.webview.webso;

import aesd;
import aese;
import ajnj;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import aoop;
import aqhq;
import arcx;
import arcy;
import ardc;
import arde;
import ardf;
import ardg;
import ardh;
import ardi;
import ardj;
import ardk;
import avpq;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import jqo;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class WebSoService
  implements BusinessObserver
{
  private static volatile WebSoService a;
  private static Object cK = new Object();
  private static String czQ = "";
  LruCache<String, WebSoState> I = new ardc(this, 10);
  private boolean bKr;
  private HashMap<String, String> pF = new HashMap();
  
  private static SharedPreferences E()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
  }
  
  public static void Q(Activity paramActivity, String paramString)
  {
    if (aese.d().cOJ <= 0) {}
    do
    {
      do
      {
        return;
        paramString = s(paramString);
      } while (paramString == null);
      paramActivity = paramActivity.findViewById(2131371159);
    } while (paramActivity == null);
    Drawable localDrawable = paramActivity.getBackground();
    paramActivity.setBackgroundDrawable(paramString);
    paramActivity.setAlpha(1.0F);
    paramActivity.setVisibility(0);
    paramActivity.postDelayed(new WebSoService.12(paramActivity, localDrawable), 2000L);
  }
  
  private static void Wn(String paramString)
  {
    aqhq.delete(ardk.qh(paramString), false);
  }
  
  private void Z(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("url");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    WebSoState localWebSoState = (WebSoState)this.I.get(ardk.qg(str));
    localWebSoState.cm.set(2);
    localWebSoState.resultCode = 0;
    HttpRsp localHttpRsp = (HttpRsp)paramBundle.getSerializable("rsp_data");
    Bundle localBundle = new Bundle();
    if ((localHttpRsp == null) || (!paramBoolean)) {
      localBundle.putBoolean("key_rsp_succeed", false);
    }
    for (;;)
    {
      a(paramBoolean, paramBundle, localWebSoState);
      QLog.i("WebSoService", 1, "onGetHttpData succed(" + paramBoolean + "), url:" + jqo.b(str, new String[0]));
      return;
      localBundle.putBoolean("key_rsp_succeed", true);
      localBundle.putString("url", paramBundle.getString("url"));
    }
  }
  
  public static WebSoService a()
  {
    if (a == null) {}
    synchronized (cK)
    {
      if (a == null) {
        a = new WebSoService();
      }
      return a;
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoState paramWebSoState, boolean paramBoolean)
  {
    String str6 = "";
    if (paramUri == null) {
      return "";
    }
    int i = 1;
    String str2 = "";
    String str3 = str2;
    String str4 = str2;
    String str5 = str2;
    String str1;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString1);
        str3 = str2;
        str4 = str2;
        str5 = str2;
        l = System.currentTimeMillis();
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (!a(localJSONObject, paramUri, paramWebSoState, paramBoolean)) {
          continue;
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (QLog.isColorLevel())
        {
          str3 = str2;
          str4 = str2;
          str5 = str2;
          QLog.d("WebSoService", 2, "composeDiffFile cost=" + (System.currentTimeMillis() - l));
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (paramWebSoState.czX == null)
        {
          str3 = str2;
          str4 = str2;
          str5 = str2;
          if (localJSONObject.has("template-tag"))
          {
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramString1 = ardk.j(paramUri);
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramString1 = new File(paramString1 + "_template.txt");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str1 = ardk.g(paramUri);
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str1 = E().getString("templateTag_" + String.valueOf(l) + str1, "");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str6 = localJSONObject.optString("template-tag");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!str1.equals(str6)) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!paramString1.exists()) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            QLog.w("WebSoService", 1, "html template is null, now read from " + paramString1.getPath());
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramWebSoState.czX = aqhq.readFileToString(paramString1);
          }
        }
      }
      catch (JSONException paramString1)
      {
        JSONObject localJSONObject;
        i = 0;
        str1 = "";
        paramString1.printStackTrace();
        paramString1 = str3;
        continue;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (paramString1.exists()) {
          continue;
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.w("WebSoService", 1, " template file is not exits!");
        continue;
      }
      catch (Exception paramString1)
      {
        long l;
        i = 0;
        str1 = "";
        paramString1.printStackTrace();
        paramString1 = str4;
        continue;
        int j = 0;
        continue;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.e("WebSoService", 1, "check html data fail cost=" + (System.currentTimeMillis() - l));
        i = 0;
        str1 = "";
        str3 = str2;
        str4 = str2;
        str5 = str2;
        ardk.k(paramUri);
        paramString1 = str2;
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "storeDiffData is OutOfMemoryError");
        paramString1.printStackTrace();
        VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 2, 1, null);
        paramString1 = str5;
        i = 0;
        str1 = "";
        continue;
        paramWebSoState.putString("eTag_" + str2 + paramUri, "");
        paramWebSoState.putString("pageVersion_" + str2 + paramUri, paramString3);
        paramWebSoState.putString("templateTag_" + str2 + paramUri, "");
        paramWebSoState.putString("htmlSha1_" + str2 + paramUri, "");
        continue;
        paramWebSoState.apply();
      }
      str3 = str2;
      str4 = str2;
      str5 = str2;
      l = System.currentTimeMillis();
      str3 = str2;
      str4 = str2;
      str5 = str2;
      paramString1 = a(localJSONObject, paramWebSoState);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (QLog.isColorLevel())
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.d("WebSoService", 2, "updateHtml cost=" + (System.currentTimeMillis() - l));
      }
      j = i;
      str6 = paramString1;
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (TextUtils.isEmpty(paramString1))
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.w("WebSoService", 1, "htmlContent is null! " + localJSONObject.toString());
        str6 = paramString1;
        j = i;
      }
      paramString1 = str2;
      i = j;
      str1 = str6;
      if (j != 0)
      {
        paramString1 = str2;
        i = j;
        str1 = str6;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (!TextUtils.isEmpty(str6))
        {
          paramString1 = str2;
          i = j;
          str1 = str6;
          str3 = str2;
          str4 = str2;
          str5 = str2;
          if (localJSONObject.has("html-sha1"))
          {
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str2 = localJSONObject.optString("html-sha1", "");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            l = System.currentTimeMillis();
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!arcy.getSHA1(str6).equals(str2)) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (QLog.isColorLevel())
            {
              str3 = str2;
              str4 = str2;
              str5 = str2;
              QLog.d("WebSoService", 2, "check html data success cost=" + (System.currentTimeMillis() - l));
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            a(paramUri, paramWebSoState, localJSONObject);
            paramString1 = str2;
            i = j;
            str1 = str6;
            if (paramBoolean)
            {
              str3 = str2;
              str4 = str2;
              str5 = str2;
              ardk.i(str6.getBytes(), ardk.h(paramUri));
              paramString1 = str2;
              i = j;
              str1 = str6;
              str3 = str2;
              str4 = str2;
              str5 = str2;
              if (paramWebSoState.cn.get() == 1)
              {
                paramString1 = str2;
                i = j;
                str1 = str6;
                str3 = str2;
                str4 = str2;
                str5 = str2;
                if (localJSONObject.has("data"))
                {
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  paramString1 = localJSONObject.optJSONObject("data");
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  paramWebSoState = ardk.j(paramUri) + "_data.txt";
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  ardk.i(paramString1.toString().getBytes(), paramWebSoState);
                  str1 = str6;
                  i = j;
                  paramString1 = str2;
                }
              }
            }
          }
        }
      }
      paramWebSoState = E().edit();
      str2 = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      paramUri = ardk.g(paramUri);
      if ((i == 0) || (!paramBoolean)) {
        continue;
      }
      paramWebSoState.putString("eTag_" + str2 + paramUri, paramString2);
      paramWebSoState.putString("pageVersion_" + str2 + paramUri, paramString3);
      paramWebSoState.putString("templateTag_" + str2 + paramUri, paramString4);
      paramWebSoState.putString("htmlSha1_" + str2 + paramUri, paramString1);
      if (Build.VERSION.SDK_INT >= 9) {
        continue;
      }
      paramWebSoState.commit();
      return str1;
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (str1.equals(str6)) {
        continue;
      }
      str3 = str2;
      str4 = str2;
      str5 = str2;
      QLog.w("WebSoService", 1, "I have no idea how to handle this situation! " + str1 + " vs new tag: " + str6);
    }
    return str1;
  }
  
  private static String a(JSONObject paramJSONObject, WebSoState paramWebSoState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSoService", 2, "updateHtml");
    }
    if ((paramWebSoState == null) || (paramWebSoState.czX == null) || (paramJSONObject == null))
    {
      if ((paramWebSoState != null) && (paramWebSoState.czX == null)) {
        QLog.w("WebSoService", 1, "template body is null!!!!");
      }
      if (paramJSONObject == null) {
        QLog.w("WebSoService", 1, "allJson is null, how possible!");
      }
      paramWebSoState = "";
    }
    String str;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return paramWebSoState;
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "updateHtml data");
          }
          str = EncodingUtils.getString(paramWebSoState.czX.getBytes(), "UTF-8");
          paramWebSoState = str;
        } while (TextUtils.isEmpty(str));
        paramWebSoState = str;
      } while (!paramJSONObject.has("data"));
      localJSONObject = paramJSONObject.optJSONObject("data");
      paramWebSoState = str;
    } while (localJSONObject == null);
    Iterator localIterator = localJSONObject.keys();
    for (paramJSONObject = str;; paramJSONObject = paramJSONObject.replace(paramWebSoState, localJSONObject.optString(paramWebSoState)))
    {
      paramWebSoState = paramJSONObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramWebSoState = localIterator.next().toString();
    }
  }
  
  private static void a(Uri paramUri, WebSoState paramWebSoState, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    if (paramWebSoState.cn.get() != 1) {}
    Object localObject;
    for (;;)
    {
      return;
      try
      {
        long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
        localObject = ardk.g(paramUri);
        if (!E().getString("templateTag_" + String.valueOf(l) + (String)localObject, "").equals(paramJSONObject.optString("template-tag")))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("WebSoService", 2, "template has changed, so it can't use local refresh!");
        }
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        paramWebSoState.czY = "";
        return;
      }
    }
    paramUri = aqhq.readFileToString(new File(ardk.j(paramUri) + "_data.txt"));
    if (!TextUtils.isEmpty(paramUri)) {}
    for (paramUri = new JSONObject(paramUri);; paramUri = null)
    {
      if (paramJSONObject.has("data")) {
        localJSONObject = paramJSONObject.optJSONObject("data");
      }
      paramJSONObject = new JSONObject();
      if ((localJSONObject != null) && (paramUri != null))
      {
        localObject = localJSONObject.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = ((Iterator)localObject).next().toString();
          String str2 = localJSONObject.optString(str1);
          if (QLog.isColorLevel()) {
            QLog.i("WebSoService", 2, "local check key: " + str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            if (!paramUri.has(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoService", 2, "local refresh key: " + str1);
              }
              paramJSONObject.put(str1, str2);
            }
            else if (!str2.equalsIgnoreCase(paramUri.optString(str1, "")))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoService", 2, "local refresh key: " + str1);
              }
              paramJSONObject.put(str1, str2);
            }
          }
        }
      }
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject.put("local_refresh_time", System.currentTimeMillis());
        paramWebSoState.czY = paramJSONObject.toString();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WebSoService", 2, "no local refresh data.");
      }
      paramWebSoState.czY = "";
      return;
    }
  }
  
  private void a(Uri paramUri, String paramString, File paramFile, WebSoState paramWebSoState, a parama)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.3(this, paramFile, paramString, parama, paramUri));
  }
  
  private void a(Handler paramHandler, WebSoState paramWebSoState)
  {
    if ((paramHandler == null) || (paramWebSoState == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_rsp_succeed", paramWebSoState.success);
    localBundle.putString("url", paramWebSoState.currentUrl);
    localBundle.putBoolean("need_force_refresh", paramWebSoState.forceRefresh);
    localBundle.putBoolean("need_local_refresh", paramWebSoState.cZg);
    localBundle.putString("key_html_changed_data", paramWebSoState.czY);
    localBundle.putBoolean("key_wns_cache_hit", paramWebSoState.cZf);
    if ((paramWebSoState.cZf) && (TextUtils.isEmpty(paramWebSoState.czO)))
    {
      paramWebSoState.czO = ardk.qi(paramWebSoState.currentUrl);
      if (!TextUtils.isEmpty(paramWebSoState.czO)) {
        paramWebSoState.aCu = true;
      }
    }
    localBundle.putBoolean("is_local_data", paramWebSoState.aCu);
    localBundle.putString("wns_proxy_http_data", paramWebSoState.czO);
    localBundle.putInt("result_code", paramWebSoState.resultCode);
    localBundle.putString("error_message", paramWebSoState.errorMsg);
    localBundle.putInt("req_state", paramWebSoState.cm.get());
    localBundle.putBoolean("is_silent_mode", paramWebSoState.aPr);
    localBundle.putParcelable("key_webso_3", paramWebSoState.b);
    ardk.Wo("send webso3 " + paramWebSoState.b.toString());
    paramWebSoState = paramHandler.obtainMessage(203);
    paramWebSoState.obj = localBundle;
    paramHandler.sendMessage(paramWebSoState);
  }
  
  private static void a(arcx paramarcx, String paramString1, String paramString2, Uri paramUri, WebSoState paramWebSoState)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.10(paramarcx, paramUri, paramString1, paramString2, paramWebSoState));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Uri paramUri)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.11(paramString1, paramUri, paramString2, paramString3));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoState paramWebSoState, boolean paramBoolean, a parama)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.9(paramString1, paramString2, paramString3, paramString4, paramUri, paramWebSoState, paramBoolean, parama));
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, WebSoState paramWebSoState)
  {
    if (paramWebSoState.a == null)
    {
      paramWebSoState.a = new HybridWebReporter.a();
      paramWebSoState.a.uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      paramWebSoState.a.url = paramWebSoState.currentUrl;
      paramWebSoState.a.cYY = true;
    }
    if (!paramBoolean) {
      paramWebSoState.a.eeG = 1;
    }
    paramWebSoState.a.czK = paramBundle.getString("key_user_ip");
    paramWebSoState.a.czL = paramBundle.getString("key_dns_result");
    paramWebSoState.a.cnH = paramBundle.getString("key_server_ip");
    paramWebSoState.a.port = paramBundle.getString("key_server_port");
    paramWebSoState.a.eeB = paramBundle.getInt("key_time_cost");
    paramWebSoState.a.eeC = paramBundle.getInt("rsp_code");
    paramWebSoState.a.eeD = 2;
    paramWebSoState.a.detail = paramBundle.getString("key_detail_info");
    paramWebSoState.aPr = false;
    paramWebSoState.b.reset();
    if (!paramBoolean)
    {
      paramWebSoState.resultCode = 10001;
      if (!TextUtils.isEmpty(paramWebSoState.czO)) {
        paramWebSoState.cZf = true;
      }
      a(paramWebSoState);
      return;
    }
    paramWebSoState.a.reset();
    Object localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
    if (localObject1 != null) {}
    for (arcx localarcx = new arcx((HttpRsp)localObject1);; localarcx = null)
    {
      if (localObject1 == null)
      {
        paramWebSoState.resultCode = 10002;
        paramWebSoState.errorMsg = "rsp is null";
        a(paramWebSoState);
        return;
      }
      localObject1 = ((HttpRsp)localObject1).rspinfo;
      int i = ((String)localObject1).indexOf("\r\n\r\n");
      String str5 = localarcx.entity_body;
      if (i < 1) {
        break;
      }
      String[] arrayOfString = ((String)localObject1).substring(0, i - 1).split("\r\n");
      Uri localUri = Uri.parse(paramBundle.getString("url"));
      localObject1 = arrayOfString[0].split(" ");
      if (localObject1.length >= 2) {}
      try
      {
        paramWebSoState.a.czJ = localObject1[1].trim();
        paramWebSoState.cZf = false;
        str2 = null;
        str3 = null;
        localObject1 = null;
        int j = arrayOfString.length;
        str1 = null;
        str4 = null;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label618;
          }
          localObject3 = arrayOfString[i].toLowerCase();
          if (!((String)localObject3).contains("cache-offline")) {
            break;
          }
          str4 = localObject3.split(":")[1].trim();
          i += 1;
        }
      }
      catch (Exception localException)
      {
        String str2;
        String str3;
        String str1;
        String str4;
        Object localObject3;
        Object localObject2;
        for (;;)
        {
          localException.printStackTrace();
          continue;
          if (((String)localObject3).contains("etag"))
          {
            str1 = localObject3.split(":")[1].trim();
          }
          else if (((String)localObject3).contains("template-tag"))
          {
            str2 = localObject3.split(":")[1].trim();
          }
          else if (((String)localObject3).contains("webso-page-version"))
          {
            str3 = localObject3.split(":")[1].trim();
            if (paramWebSoState.a.eeF < 3) {
              paramWebSoState.a.eeF = 3;
            }
          }
          else if (((String)localObject3).contains("webso-content-type"))
          {
            localObject3 = localObject3.split(":")[1].trim();
            localObject2 = localObject3;
            if (paramWebSoState.a.eeF < 3)
            {
              paramWebSoState.a.eeF = 3;
              localObject2 = localObject3;
            }
          }
        }
        label618:
        paramBoolean = "json".equals(localObject2);
        if (!paramBoolean) {
          Wn(localUri.toString());
        }
        ardk.Wo("receive header : " + Arrays.toString(arrayOfString));
        ardk.Wo("receive data : " + str5);
        if (paramBoolean) {
          ardk.Wo("receive contentType = " + (String)localObject2 + "  pageVersion = " + str3 + " etag = " + str1);
        }
        paramWebSoState.a.avt = str5.length();
        if (arrayOfString[0].contains("304"))
        {
          if (paramBoolean)
          {
            ardk.Wo("result = 304");
            paramWebSoState.b.valid = true;
            paramWebSoState.b.eTag = str1;
            paramWebSoState.b.czZ = str3;
            paramWebSoState.b.jsonData = ("\"" + arrayOfString[0] + "\"");
            paramWebSoState.b.uri = localUri.toString();
            paramWebSoState.b.cAa = "webso-304";
            paramWebSoState.cZf = true;
            paramWebSoState.a.cZa = true;
            paramWebSoState.a.czM = "304";
            a(paramWebSoState);
            return;
          }
          QLog.i("WebSoService", 1, "now 304,so return! ");
          paramWebSoState.cZf = true;
          paramWebSoState.a.cZa = true;
          a(paramWebSoState);
          return;
        }
        if ("http".equals(str4))
        {
          QLog.i("WebSoService", 1, "now 503, so start reLoadUrl");
          paramWebSoState.resultCode = 10503;
          paramWebSoState.cZf = false;
          paramWebSoState.forceRefresh = true;
          ardk.l(localUri);
          a(paramWebSoState);
          return;
        }
        if (paramBoolean)
        {
          ardk.Wo("result = json");
          paramWebSoState.b.valid = true;
          paramWebSoState.b.eTag = str1;
          paramWebSoState.b.czZ = str3;
          paramWebSoState.b.jsonData = localarcx.entity_body;
          paramWebSoState.b.uri = localUri.toString();
          paramWebSoState.b.cAa = "webso-data-json";
          paramWebSoState.cZf = true;
          paramWebSoState.a.cZa = true;
          paramWebSoState.a.czM = "json";
          a(paramWebSoState);
          return;
        }
        if ("true".equals(str4))
        {
          if (TextUtils.isEmpty(str2))
          {
            if (QLog.isDebugVersion()) {
              QLog.i("WebSoService", 1, "webso etag=" + str1 + ",url=" + paramBundle.getString("url"));
            }
            a(localarcx, str1, str3, localUri, paramWebSoState);
            paramWebSoState.czO = str5;
            paramWebSoState.forceRefresh = true;
            paramWebSoState.aCu = false;
            a(paramWebSoState);
            return;
          }
          a(str5, str1, str3, str2, localUri, paramWebSoState, true, new ardf(this, paramWebSoState, System.currentTimeMillis()));
          return;
        }
        if ("store".equals(str4))
        {
          if ((rV(paramWebSoState.currentUrl)) && (paramWebSoState.y != null) && (paramWebSoState.y.length > 0) && (paramWebSoState.y[0] != 0))
          {
            paramWebSoState.aPr = true;
            paramWebSoState.forceRefresh = false;
            paramWebSoState.aCu = false;
          }
          try
          {
            paramBundle = new JSONObject(str5).optJSONObject("data");
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("code", 1);
            ((JSONObject)localObject2).put("data", paramBundle);
            ((JSONObject)localObject2).put("type", str4);
            paramWebSoState.czO = ((JSONObject)localObject2).toString();
            a(paramWebSoState);
            if (TextUtils.isEmpty(str2))
            {
              a(localarcx, str1, str3, localUri, paramWebSoState);
              paramWebSoState.aPr = false;
              paramWebSoState.czO = str5;
              paramWebSoState.forceRefresh = false;
              paramWebSoState.aCu = false;
              a(paramWebSoState);
              return;
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
            }
            a(str5, str1, str3, str2, localUri, paramWebSoState, true, new ardg(this, paramWebSoState, System.currentTimeMillis()));
            return;
          }
        }
        if ("silent".equals(str4))
        {
          paramWebSoState.aPr = true;
          paramWebSoState.forceRefresh = false;
          paramWebSoState.aCu = false;
          paramBundle = "{\"code\":-1,\"data\":null}";
          try
          {
            localObject2 = new JSONObject(str5).optJSONObject("data");
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("code", 1);
            ((JSONObject)localObject3).put("data", localObject2);
            ((JSONObject)localObject3).put("type", str4);
            localObject2 = ((JSONObject)localObject3).toString();
            paramBundle = (Bundle)localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
            System.currentTimeMillis();
            a(str5, str1, str3, str2, localUri, paramWebSoState, true, new ardh(this, paramWebSoState));
            return;
          }
          paramWebSoState.czO = paramBundle;
          a(paramWebSoState);
          if (TextUtils.isEmpty(str2))
          {
            a(localarcx, str1, str3, localUri, paramWebSoState);
            paramWebSoState.aPr = false;
            return;
          }
        }
        if ((str4 == null) || ("false".equals(str4)))
        {
          if (TextUtils.isEmpty(str2))
          {
            paramWebSoState.czO = str5;
            paramWebSoState.forceRefresh = true;
            paramWebSoState.aCu = false;
            paramWebSoState.a.eeE = 0;
            paramWebSoState.a.eeD = 0;
            a(paramWebSoState);
          }
          for (;;)
          {
            ardk.k(localUri);
            return;
            a(str5, str1, str3, str2, localUri, paramWebSoState, false, new ardi(this, paramWebSoState, System.currentTimeMillis()));
          }
        }
        ardk.k(localUri);
        paramWebSoState.czO = str5;
        paramWebSoState.forceRefresh = true;
        paramWebSoState.aCu = false;
        a(paramWebSoState);
        return;
      }
    }
  }
  
  private static boolean a(JSONObject paramJSONObject, Uri paramUri, WebSoState paramWebSoState, boolean paramBoolean)
  {
    Object localObject2 = ardk.j(paramUri);
    bool2 = true;
    if ((paramJSONObject == null) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      bool2 = false;
      return bool2;
    }
    bool1 = bool2;
    paramUri = paramWebSoState;
    String str;
    Object localObject1;
    if (paramJSONObject.has("template"))
    {
      str = paramJSONObject.optString("template", "");
      localObject1 = paramWebSoState;
      if (paramWebSoState == null) {
        localObject1 = new WebSoState();
      }
      if (TextUtils.isEmpty(str)) {
        break label638;
      }
      ((WebSoState)localObject1).czX = str;
      bool1 = bool2;
      paramUri = (Uri)localObject1;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        ardk.i(str.getBytes(), (String)localObject2 + "_template.txt");
        paramUri = (Uri)localObject1;
        bool1 = bool2;
      }
      catch (OutOfMemoryError paramUri)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "html is too large, OutOfMemoryError");
        VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 3, 1, null);
        bool1 = false;
        paramUri = (Uri)localObject1;
        continue;
      }
      catch (Exception paramUri)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "template is exception=" + paramUri.getMessage());
        bool1 = false;
        paramUri = (Uri)localObject1;
        continue;
      }
      bool2 = bool1;
      if (!paramJSONObject.has("diff")) {
        break;
      }
      paramJSONObject = paramJSONObject.optString("diff", "");
      bool2 = bool1;
      if (TextUtils.isEmpty(paramJSONObject)) {
        break;
      }
      ardk.i(ajnj.decode(paramJSONObject.getBytes()), (String)localObject2 + ".patch");
      paramWebSoState = new File((String)localObject2 + "_template.txt");
      bool2 = bool1;
      if (!paramWebSoState.exists()) {}
      try
      {
        paramWebSoState.createNewFile();
        bool2 = bool1;
      }
      catch (IOException paramJSONObject)
      {
        bool2 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      localObject1 = new File((String)localObject2 + ".patch");
      bool1 = bool2;
      if (!((File)localObject1).exists()) {}
      try
      {
        ((File)localObject1).createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramJSONObject)
      {
        bool1 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      localObject2 = new File((String)localObject2 + "_compose.txt");
      bool2 = bool1;
      if (!((File)localObject2).exists()) {}
      try
      {
        ((File)localObject2).createNewFile();
        bool2 = bool1;
      }
      catch (IOException paramJSONObject)
      {
        long l;
        bool2 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      bool1 = bool2;
      if (bool2)
      {
        l = System.currentTimeMillis();
        bool1 = BspatchUtil.D(paramWebSoState.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath());
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "patch file cost=" + (System.currentTimeMillis() - l));
        }
        paramJSONObject = paramUri;
        if (paramUri == null) {
          paramJSONObject = new WebSoState();
        }
        bool2 = bool1;
        if (bool1)
        {
          paramWebSoState.delete();
          ((File)localObject2).renameTo(paramWebSoState.getAbsoluteFile());
        }
      }
      try
      {
        paramJSONObject.czX = aqhq.readFileToString(paramWebSoState);
        bool2 = bool1;
      }
      catch (IOException paramUri)
      {
        paramUri.printStackTrace();
        bool2 = false;
        continue;
      }
      bool1 = bool2;
      if (!bool2)
      {
        paramWebSoState.delete();
        ((File)localObject1).delete();
        ((File)localObject2).delete();
        paramJSONObject.czX = null;
        bool1 = bool2;
      }
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      paramWebSoState.delete();
      return bool1;
      label638:
      bool1 = false;
      paramUri = (Uri)localObject1;
    }
  }
  
  public static void f(CustomWebView paramCustomWebView)
  {
    if (aese.d().cOJ <= 0) {
      return;
    }
    paramCustomWebView.post(new WebSoService.13(paramCustomWebView));
  }
  
  private static Drawable s(String paramString)
  {
    String str = ardk.qh(paramString);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
      return null;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      try
      {
        paramString = new BitmapFactory.Options();
        paramString.inSampleSize = 4;
        paramString = BitmapFactory.decodeFile(str, paramString);
        if (paramString == null)
        {
          paramString = aoop.TRANSPARENT;
          localURLDrawableOptions.mLoadingDrawable = paramString;
          localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
          localURLDrawableOptions.mUseAutoScaleParams = false;
          return URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          paramString = new BitmapDrawable(paramString);
        }
      }
      return null;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static void t(View paramView, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 982	android/view/View:getMeasuredWidth	()I
    //   6: aload_0
    //   7: invokevirtual 985	android/view/View:getHeight	()I
    //   10: getstatic 991	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   13: invokestatic 997	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   16: astore 4
    //   18: aload_0
    //   19: new 999	android/graphics/Canvas
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 1000	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   28: invokevirtual 1004	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   31: aload 4
    //   33: invokestatic 1009	awcg:j	(Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: getstatic 39	com/tencent/mobileqq/webview/webso/WebSoService:czQ	Ljava/lang/String;
    //   41: invokestatic 1013	awcg:am	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: istore_2
    //   45: new 191	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 1015
    //   55: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 1017
    //   65: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 39	com/tencent/mobileqq/webview/webso/WebSoService:czQ	Ljava/lang/String;
    //   71: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 1019
    //   77: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 1022	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 580	ardk:Wo	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: ldc_w 1024
    //   94: invokevirtual 314	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifne +128 -> 225
    //   100: aload_0
    //   101: putstatic 39	com/tencent/mobileqq/webview/webso/WebSoService:czQ	Ljava/lang/String;
    //   104: new 1026	java/io/FileOutputStream
    //   107: dup
    //   108: aload_1
    //   109: invokestatic 129	ardk:qh	(Ljava/lang/String;)Ljava/lang/String;
    //   112: invokespecial 1027	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: aload_1
    //   117: astore_0
    //   118: aload_1
    //   119: astore_3
    //   120: aload 4
    //   122: getstatic 1033	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: bipush 70
    //   127: aload_1
    //   128: invokevirtual 1037	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   131: pop
    //   132: aload_1
    //   133: astore_0
    //   134: aload_1
    //   135: astore_3
    //   136: aload_1
    //   137: invokevirtual 1040	java/io/FileOutputStream:close	()V
    //   140: aload_1
    //   141: astore_0
    //   142: aload_1
    //   143: astore_3
    //   144: aload 4
    //   146: invokevirtual 1043	android/graphics/Bitmap:recycle	()V
    //   149: aload_1
    //   150: astore_0
    //   151: aload_1
    //   152: astore_3
    //   153: ldc_w 1045
    //   156: invokestatic 580	ardk:Wo	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 1040	java/io/FileOutputStream:close	()V
    //   167: return
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore_0
    //   173: ldc 189
    //   175: iconst_1
    //   176: aload_1
    //   177: invokevirtual 1046	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   180: invokestatic 413	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload_3
    //   184: ifnull -17 -> 167
    //   187: aload_3
    //   188: invokevirtual 1040	java/io/FileOutputStream:close	()V
    //   191: return
    //   192: astore_0
    //   193: return
    //   194: astore_0
    //   195: aload_3
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 1040	java/io/FileOutputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: return
    //   209: astore_1
    //   210: goto -5 -> 205
    //   213: astore_3
    //   214: aload_0
    //   215: astore_1
    //   216: aload_3
    //   217: astore_0
    //   218: goto -21 -> 197
    //   221: astore_1
    //   222: goto -51 -> 171
    //   225: aconst_null
    //   226: astore_1
    //   227: goto -87 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramView	View
    //   0	230	1	paramString	String
    //   44	37	2	i	int
    //   1	195	3	str	String
    //   213	4	3	localObject	Object
    //   16	129	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	116	168	java/lang/Throwable
    //   187	191	192	java/io/IOException
    //   2	116	194	finally
    //   163	167	207	java/io/IOException
    //   201	205	209	java/io/IOException
    //   120	132	213	finally
    //   136	140	213	finally
    //   144	149	213	finally
    //   153	159	213	finally
    //   173	183	213	finally
    //   120	132	221	java/lang/Throwable
    //   136	140	221	java/lang/Throwable
    //   144	149	221	java/lang/Throwable
    //   153	159	221	java/lang/Throwable
  }
  
  public void Wm(String paramString)
  {
    if (this.pF.containsKey(paramString)) {
      this.pF.remove(paramString);
    }
  }
  
  public String a(String paramString, Handler paramHandler)
  {
    return a(paramString, paramHandler, null);
  }
  
  public String a(String paramString, Handler paramHandler, boolean[] paramArrayOfBoolean)
  {
    WebSoState localWebSoState = (WebSoState)this.I.get(ardk.qg(paramString));
    if (!TextUtils.isEmpty(localWebSoState.currentUrl))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "QonzeWnsProxyService getProxyData命中缓存，reqState:" + localWebSoState.cm);
      }
      localWebSoState.y = paramArrayOfBoolean;
      if (localWebSoState.cm.get() == 2) {
        a(paramHandler, localWebSoState);
      }
    }
    for (;;)
    {
      return localWebSoState.czO;
      if (localWebSoState.cm.get() == 1)
      {
        localWebSoState.iD = new WeakReference(paramHandler);
        if (localWebSoState.cZe)
        {
          localWebSoState.aCu = true;
          a(paramHandler, localWebSoState);
        }
        else
        {
          ThreadManager.getFileThreadHandler().post(new WebSoService.4(this, localWebSoState, paramString, paramHandler));
          return null;
        }
      }
      else
      {
        a(paramString, paramHandler);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "QonzeWnsProxyService getProxyData未命中缓存，reqState:" + localWebSoState.cm);
        }
        localWebSoState.y = paramArrayOfBoolean;
        a(paramString, paramHandler);
      }
    }
  }
  
  public void a(WebSoState paramWebSoState)
  {
    Handler localHandler;
    if ((paramWebSoState != null) && (paramWebSoState.iD != null) && (paramWebSoState.iD.get() != null))
    {
      localHandler = (Handler)paramWebSoState.iD.get();
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, paramWebSoState);
    paramWebSoState.iD = null;
    HybridWebReporter.a().a(paramWebSoState.a);
  }
  
  public boolean a(String paramString, Handler paramHandler)
  {
    return a(paramString, paramHandler, false);
  }
  
  public boolean a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "do not need startWebSoRequest, url=" + paramString);
      }
      return false;
    }
    ardk.Wo("startWebSoRequest");
    Wm(paramString);
    WebSoState localWebSoState = (WebSoState)this.I.get(ardk.qg(paramString));
    localWebSoState.currentUrl = paramString;
    localWebSoState.aCu = false;
    localWebSoState.cm.set(1);
    localWebSoState.forceRefresh = false;
    localWebSoState.cZf = false;
    localWebSoState.a = new HybridWebReporter.a();
    localWebSoState.a.uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localWebSoState.a.url = paramString;
    localWebSoState.a.cYY = true;
    localWebSoState.a.isReported = false;
    localWebSoState.a.reset();
    localWebSoState.b.reset();
    if (ardk.rW(paramString))
    {
      localWebSoState.cn.set(1);
      localWebSoState.cZg = false;
      localWebSoState.czY = "";
    }
    while (ardk.sa(paramString))
    {
      return false;
      localWebSoState.cn.set(0);
    }
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str2 = avpq.getQUA3();
    String str1 = ardk.CN();
    Object localObject2 = "";
    Object localObject1 = "";
    Object localObject3 = Uri.parse(paramString);
    if (localObject3 != null)
    {
      String str3 = String.valueOf(l);
      Object localObject4 = E();
      String str4 = ardk.g((Uri)localObject3);
      localObject2 = ((SharedPreferences)localObject4).getString("eTag_" + str3 + str4, "");
      localObject1 = ((SharedPreferences)localObject4).getString("pageVersion_" + str3 + str4, "");
      str3 = ((SharedPreferences)localObject4).getString("htmlSha1_" + str3 + str4, "");
      localObject4 = new File(ardk.h((Uri)localObject3));
      if ((TextUtils.isEmpty(str3)) || (!((File)localObject4).exists())) {
        break label802;
      }
      a((Uri)localObject3, str3, (File)localObject4, localWebSoState, new arde(this, System.currentTimeMillis(), localWebSoState, paramHandler, paramString));
    }
    for (;;)
    {
      localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("if_None_Match", localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((JSONObject)localObject3).put("web_page_version", localObject1);
        }
        ((JSONObject)localObject3).put("uri", paramString);
        localObject1 = SwiftBrowserCookieMonster.pZ(paramString);
        ((JSONObject)localObject3).put("cookie", (String)localObject1 + "; qua=" + str2 + "; ");
        ((JSONObject)localObject3).put("no_Chunked", "true");
        ((JSONObject)localObject3).put("accept_Encoding", "identity");
        if (paramBoolean) {
          ((JSONObject)localObject3).put("x_wns_ispreload_request", "1");
        }
        localObject1 = new HttpRequestPackage(str1, (JSONObject)localObject3);
        if (Build.VERSION.SDK_INT >= 17) {
          localObject2 = new JSONObject();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((JSONObject)localObject2).put("webso", "3.0");
          ((HttpRequestPackage)localObject1).addHeader(((JSONObject)localObject2).toString());
          ardk.Wo("send header = " + ((HttpRequestPackage)localObject1).getHeaderString());
          localObject1 = new HttpReq(EnumHttpMethod.convert("e" + ((HttpRequestPackage)localObject1).method).value(), ((HttpRequestPackage)localObject1).getHeaderString(), ((HttpRequestPackage)localObject1).getBodyString(), ((HttpRequestPackage)localObject1).host);
          if (paramHandler != null) {
            localWebSoState.iD = new WeakReference(paramHandler);
          }
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l, paramString, (HttpReq)localObject1, "");
          if (!this.bKr)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.bKr = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          ardk.Wo("startServlet req");
          return true;
          label802:
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "set eTag to get all data");
          }
          localObject2 = "";
          localObject1 = "";
          VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 0, new String[] { paramString });
          continue;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public void clearCache()
  {
    this.I.evictAll();
  }
  
  public void iC(String paramString1, String paramString2)
  {
    this.pF.put(paramString1, paramString2);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 100) {
      Z(paramBoolean, paramBundle);
    }
  }
  
  public String qf(String paramString)
  {
    if (this.pF.containsKey(paramString)) {
      return (String)this.pF.get(paramString);
    }
    return null;
  }
  
  public boolean rV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = Uri.parse(paramString);
    } while ((paramString == null) || (!new File(ardk.h(paramString)).exists()));
    return true;
  }
  
  public void startWebSoRequestWithCheck(String paramString, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!ardk.hasProxyParam(Uri.parse(paramString))) {
      return;
    }
    a(paramString, paramHandler);
  }
  
  public static class WebSoState
  {
    public HybridWebReporter.a a;
    public boolean aCu;
    public boolean aPr = true;
    public WebSo3 b = new WebSo3();
    public boolean cZe;
    public boolean cZf;
    public boolean cZg;
    public final AtomicInteger cm = new AtomicInteger(0);
    public final AtomicInteger cn = new AtomicInteger(0);
    public String currentUrl;
    public volatile String czO;
    public String czX;
    public String czY;
    public String errorMsg = "";
    public boolean forceRefresh;
    public WeakReference<Handler> iD;
    public int resultCode = 0;
    public boolean success;
    public boolean[] y;
    
    public static class WebSo3
      implements Parcelable
    {
      public static final Parcelable.Creator<WebSo3> CREATOR = new ardj();
      public String cAa = "";
      public String code = "0";
      public String czZ;
      public String eTag;
      public String jsonData;
      public String uri;
      public boolean valid;
      
      public WebSo3() {}
      
      public WebSo3(Parcel paramParcel)
      {
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.valid = bool;
          this.eTag = paramParcel.readString();
          this.czZ = paramParcel.readString();
          this.jsonData = paramParcel.readString();
          this.uri = paramParcel.readString();
          this.cAa = paramParcel.readString();
          this.code = paramParcel.readString();
          return;
        }
      }
      
      public String CL()
      {
        return String.format("{\"code\":\"%s\",\"type\":\"%s\",\"data\":%s}", new Object[] { this.code, this.cAa, this.jsonData });
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void reset()
      {
        this.valid = false;
        this.eTag = null;
        this.czZ = null;
        this.jsonData = null;
        this.uri = null;
        this.code = "0";
        this.cAa = "";
      }
      
      public String toString()
      {
        return "WebSo3{valid=" + this.valid + ", eTag='" + this.eTag + '\'' + ", pageVersion='" + this.czZ + '\'' + ", jsonData='" + this.jsonData + '\'' + ", uri='" + this.uri + '\'' + ", callbackType='" + this.cAa + '\'' + ", code='" + this.code + '\'' + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        if (this.valid) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeByte((byte)paramInt);
          paramParcel.writeString(this.eTag);
          paramParcel.writeString(this.czZ);
          paramParcel.writeString(this.jsonData);
          paramParcel.writeString(this.uri);
          paramParcel.writeString(this.cAa);
          paramParcel.writeString(this.code);
          return;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService
 * JD-Core Version:    0.7.0.1
 */