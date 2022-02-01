package com.tencent.mobileqq.webview.swift;

import adrt;
import adto;
import aeak;
import aiiy;
import aike;
import ajmu;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.JavascriptInterface;
import anmn;
import anot;
import aqgz;
import aqtl;
import aqze;
import aqzv;
import arao;
import arap;
import araq;
import aray;
import arbz;
import arcp;
import asbw;
import asid;
import awpj;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.ApolloGamePlugin;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import igc;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jml;
import kdl;
import org.json.JSONException;
import org.json.JSONObject;
import sst;
import sun;
import suw;
import svb;
import tzk;
import uaw;
import uay;
import ubu;

public final class WebViewPluginEngine
{
  protected static final HashSet<String> bI;
  private static boolean cXx;
  public static WebViewPluginEngine e;
  private static int eea = -1;
  protected static final HashMap<String, String> pz = new HashMap();
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private WebViewJSInterfaceImpl jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl;
  public Activity activity;
  private jml authCfg;
  public WebViewFragment b;
  public AppInterface c;
  private final ConcurrentHashMap<String, WebViewPlugin> pluginHashMap = new ConcurrentHashMap();
  private final HashMap<Long, CopyOnWriteArrayList<WebViewPlugin>> px = new HashMap();
  private final HashMap<String, CopyOnWriteArrayList<WebViewPlugin>> py = new HashMap();
  private LruCache<String, uaw> x;
  
  static
  {
    bI = new HashSet();
    pz.put("auth.init", "Troop.init");
    pz.put("device.getNetworkInfo", "qbizApi.getNetworkInfo");
    pz.put("data.setShareInfo", "QQApi.setShareInfo");
    pz.put("event.dispatchEvent", "event.dispatchEvent");
    pz.put("media.showPicture", "troopNotice.showPicture");
    pz.put("ui.popBack", "publicAccount.close");
    pz.put("ui.shareMessage", "QQApi.shareMsg");
    bI.add("gflive.addBarrageList");
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.activity = paramActivity;
    this.c = paramAppInterface;
    a(false, paramAppInterface, paramCommonJsPluginFactory, null);
    preCreatePlugin();
    a(paramAppInterface, paramActivity);
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.activity = paramActivity;
    this.c = paramAppInterface;
    a(false, paramAppInterface, paramCommonJsPluginFactory, null);
    paramCustomWebView = paramList.iterator();
    while (paramCustomWebView.hasNext())
    {
      paramCommonJsPluginFactory = (WebViewPlugin)paramCustomWebView.next();
      b(paramCommonJsPluginFactory);
      a(paramCommonJsPluginFactory);
    }
    a(paramAppInterface, paramActivity);
  }
  
  public WebViewPluginEngine(AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    this.c = paramAppInterface;
    a(true, paramAppInterface, paramCommonJsPluginFactory, paramList);
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin == null) {}
    label37:
    label60:
    do
    {
      do
      {
        return -1;
        if (!(paramWebViewPlugin instanceof aqze)) {
          break;
        }
        paramWebViewPlugin = ((aqze)paramWebViewPlugin).getMultiNameSpace();
      } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.length <= 0));
      int j = paramWebViewPlugin.length;
      int i = 0;
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = paramWebViewPlugin[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          break label60;
        }
      }
      while (!arap.sPluginNameSpaceHashMap.containsKey(localCharSequence))
      {
        i += 1;
        break label37;
        break;
      }
      return ((Integer)arap.sPluginNameSpaceHashMap.get(localCharSequence)).intValue();
      if (TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)) {
        break;
      }
    } while (!arap.sPluginNameSpaceHashMap.containsKey(paramWebViewPlugin.mPluginNameSpace));
    return ((Integer)arap.sPluginNameSpaceHashMap.get(paramWebViewPlugin.mPluginNameSpace)).intValue();
    qw(paramWebViewPlugin.toString() + " have no namespace!!!!");
    return -1;
  }
  
  private WebViewPlugin a(String paramString)
  {
    paramString = arap.c(paramString);
    b(paramString);
    a(paramString);
    return paramString;
  }
  
  private void a(AppInterface paramAppInterface, Activity paramActivity, List<WebViewPlugin> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
        localWebViewPlugin.initRuntime(paramActivity, paramAppInterface);
        localWebViewPlugin.onCreate();
        localWebViewPlugin.onAppRuntimeReady(paramAppInterface);
        b(localWebViewPlugin);
      }
    }
  }
  
  private void a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin.initRuntime(this.activity, this.c);
      paramWebViewPlugin.mRuntime.a(this.b);
      paramWebViewPlugin.onCreate();
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        paramWebViewPlugin.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      }
    }
  }
  
  private void a(String paramString, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramWebViewPlugin == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if (this.pluginHashMap.containsKey(paramString))
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, "insertPlugin:namespace " + paramString + " already exists!");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewPluginEngine", 2, "insertPlugin:add pair [" + paramString + "] -> " + paramWebViewPlugin.getClass().getSimpleName());
      }
      this.pluginHashMap.put(paramString, paramWebViewPlugin);
      if (aray.pB.containsKey(paramString))
      {
        l2 = ((Long)aray.pB.get(paramString)).longValue();
        if (l2 > 0L)
        {
          i = 1;
          l1 = 1L;
          while (l2 >= l1)
          {
            if ((l2 & l1) != 0L)
            {
              localObject2 = (CopyOnWriteArrayList)this.px.get(Long.valueOf(l1));
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new CopyOnWriteArrayList();
                this.px.put(Long.valueOf(l1), localObject1);
              }
              ((CopyOnWriteArrayList)localObject1).add(paramWebViewPlugin);
            }
            int j = i + 1;
            l1 = 1L << i;
            i = j;
          }
        }
      }
    } while (!araq.pA.containsKey(paramString));
    long l2 = ((Long)araq.pA.get(paramString)).longValue();
    int i = 1;
    long l1 = 1L;
    label268:
    if ((l2 > 0L) && (l2 >= l1)) {
      if ((l2 & l1) != 0L)
      {
        localObject2 = araq.bY(l1);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = (CopyOnWriteArrayList)this.py.get(localObject2);
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = new CopyOnWriteArrayList();
            this.py.put(localObject2, paramString);
          }
          if (!(paramWebViewPlugin instanceof adto)) {
            break label374;
          }
          paramString.add(0, paramWebViewPlugin);
        }
      }
    }
    for (;;)
    {
      l1 = 1L << i;
      i += 1;
      break label268;
      break;
      label374:
      paramString.add(paramWebViewPlugin);
    }
  }
  
  private void a(boolean paramBoolean, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List<WebViewPlugin> paramList)
  {
    paramCommonJsPluginFactory = paramCommonJsPluginFactory.getCommonJsPlugin().iterator();
    while (paramCommonJsPluginFactory.hasNext()) {
      b((WebViewPlugin)paramCommonJsPluginFactory.next());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramCommonJsPluginFactory = paramList.iterator();
      while (paramCommonJsPluginFactory.hasNext()) {
        b((WebViewPlugin)paramCommonJsPluginFactory.next());
      }
    }
    paramCommonJsPluginFactory = this.pluginHashMap.values().iterator();
    while (paramCommonJsPluginFactory.hasNext())
    {
      paramList = (WebViewPlugin)paramCommonJsPluginFactory.next();
      paramList.onAppRuntimeReady(paramAppInterface);
      paramList.onCreate();
      if (!paramBoolean)
      {
        paramList.initRuntime(this.activity, paramAppInterface);
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          paramList.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
        }
      }
    }
  }
  
  private static boolean a(WebViewPlugin paramWebViewPlugin, JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (paramWebViewPlugin == null) {}
    for (;;)
    {
      return false;
      try
      {
        long l1 = System.currentTimeMillis();
        long l2;
        if (paramWebViewPlugin.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramArrayOfString))
        {
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(paramWebViewPlugin.getClass().getSimpleName()).append("] handle JsApi[").append(paramString2).append(".").append(paramString3).append("] cost ").append(l2 - l1).append(" ms.") });
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          l2 = System.currentTimeMillis();
          QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(paramWebViewPlugin.getClass().getSimpleName()).append("] ignore JsApi[").append(paramString2).append(".").append(paramString3).append("] cost ").append(l2 - l1).append(" ms.") });
          return false;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener = paramJsBridgeListener;
        QLog.e("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(paramWebViewPlugin.getClass().getSimpleName()).append("] handle JsApi[").append(paramString2).append(".").append(paramString3).append("] error:").append(paramJsBridgeListener.toString()) });
        return false;
      }
      finally {}
    }
    return true;
  }
  
  private static boolean a(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    Object localObject3 = (paramString + "/#").split("/");
    if (localObject3.length < 5)
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "illegal jsbridge:" + paramString);
      return true;
    }
    String str2 = localObject3[2];
    int j = 1;
    Object localObject1;
    if (localObject3.length == 5)
    {
      j = 0;
      localObject1 = localObject3[3].split("#");
      if (localObject1.length <= 1) {
        break label1144;
      }
    }
    for (;;)
    {
      int k;
      Object localObject4;
      try
      {
        i = Integer.parseInt(localObject1[1]);
        l = i;
        localObject1 = localObject1[0].split("\\?");
        localObject3 = localObject1[0];
        if (localObject1.length <= 1) {
          break label559;
        }
        localObject2 = localObject1[1].split("&");
        localObject1 = localObject2;
        if (localObject2.length <= 0) {
          break label387;
        }
        localObject1 = new ArrayList();
        i = 0;
        k = localObject2.length;
        if (i >= k) {
          break label365;
        }
        int m = localObject2[i].indexOf('=');
        if (m == -1) {
          break label351;
        }
        if (!"mqq_tt".equals(localObject2[i].substring(0, m)))
        {
          localObject4 = str2 + "." + (String)localObject3;
          if (bI.contains(localObject4)) {
            ((List)localObject1).add(localObject2[i].substring(m + 1));
          }
        }
        else
        {
          i += 1;
          continue;
        }
        ((List)localObject1).add(URLDecoder.decode(localObject2[i].substring(m + 1)));
      }
      catch (NumberFormatException paramWebViewPluginEngine)
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramWebViewPluginEngine.toString()) });
        return true;
      }
      continue;
      label351:
      ((List)localObject1).add("");
      continue;
      label365:
      localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
      label387:
      Object localObject2 = localObject1;
      localObject1 = localObject3;
      for (int i = j;; i = j)
      {
        JsBridgeListener localJsBridgeListener = new JsBridgeListener(paramCustomWebView, l, paramString);
        localObject3 = paramCustomWebView.getUrl();
        String str1 = str2 + "." + (String)localObject1;
        if (paramWebViewPluginEngine.b().z((String)localObject3, str1))
        {
          localObject4 = paramWebViewPluginEngine.b(str2);
          paramCustomWebView = (CustomWebView)localObject4;
          if (localObject4 == null) {
            paramCustomWebView = paramWebViewPluginEngine.a(str2);
          }
          label513:
          label521:
          label680:
          if (paramCustomWebView != null)
          {
            a(paramCustomWebView, localJsBridgeListener, paramString, str2, (String)localObject1, (String[])localObject2);
            if (arbz.cYb)
            {
              if (localObject3 != null) {
                break label680;
              }
              paramCustomWebView = null;
              if (paramCustomWebView != null) {
                break label689;
              }
              paramWebViewPluginEngine = "";
              if (paramCustomWebView != null) {
                break label697;
              }
            }
            label559:
            label689:
            label697:
            for (paramCustomWebView = "";; paramCustomWebView = paramCustomWebView.getPath())
            {
              anot.a(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 0, 0, paramWebViewPluginEngine, paramCustomWebView, str1, "");
              return true;
              localObject1 = new String[0];
              break;
              localObject1 = localObject3[3];
              try
              {
                l = Long.parseLong(localObject3[4]);
                i = localObject3.length - 6;
                localObject2 = new String[i];
                System.arraycopy(localObject3, 5, localObject2, 0, i);
                i = 0;
                k = localObject2.length;
                while (i < k)
                {
                  localObject2[i] = URLDecoder.decode(localObject2[i]);
                  i += 1;
                }
                paramCustomWebView = Uri.parse((String)localObject3);
              }
              catch (Exception paramWebViewPluginEngine)
              {
                QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramWebViewPluginEngine.toString()) });
                return true;
              }
              break label513;
              paramWebViewPluginEngine = paramCustomWebView.getHost();
              break label521;
            }
          }
          if (i == 0) {}
        }
        for (;;)
        {
          if ((l == -1L) || (arbz.cYb))
          {
            if (localObject3 == null)
            {
              paramCustomWebView = null;
              label731:
              if (paramCustomWebView != null) {
                break label865;
              }
              paramWebViewPluginEngine = "";
              label739:
              if (paramCustomWebView != null) {
                break label873;
              }
              paramCustomWebView = "";
              label747:
              anot.a(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 2, 0, paramWebViewPluginEngine, paramCustomWebView, str1, "");
            }
          }
          else
          {
            label775:
            return true;
            paramCustomWebView = null;
            paramWebViewPluginEngine = paramCustomWebView;
            if (localObject2.length > 0)
            {
              paramWebViewPluginEngine = paramCustomWebView;
              if (!localObject2[0].startsWith("{")) {}
            }
          }
          try
          {
            paramWebViewPluginEngine = new JSONObject(localObject2[0]).optString("callback");
            paramCustomWebView = paramWebViewPluginEngine;
            if (TextUtils.isEmpty(paramWebViewPluginEngine))
            {
              paramCustomWebView = paramWebViewPluginEngine;
              if (l != -1L) {
                paramCustomWebView = Long.toString(l);
              }
            }
            if (!TextUtils.isEmpty(paramCustomWebView))
            {
              continue;
              paramCustomWebView = Uri.parse((String)localObject3);
              break label731;
              label865:
              paramWebViewPluginEngine = paramCustomWebView.getHost();
              break label739;
              label873:
              paramCustomWebView = paramCustomWebView.getPath();
              break label747;
              localJsBridgeListener.dsB();
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (!((String)localObject3).contains("?")) {
                  break label1132;
                }
                paramCustomWebView = ((String)localObject3).substring(0, ((String)localObject3).indexOf("?"));
                i = (int)paramWebViewPluginEngine.b().bW();
                j = QbSdk.getTbsVersion(BaseApplication.getContext());
                paramWebViewPluginEngine = aqgz.BY() + " " + aqgz.getModel();
                VasWebviewUtil.reportVasStatus("JsApiRights", str2, (String)localObject1, 3, 0, j, i, paramCustomWebView, paramWebViewPluginEngine);
                if (!paramCustomWebView.startsWith("http")) {
                  QLog.d("WebLog_WebViewPluginEngine", 1, "no plugin have right handle  " + str1 + ", x5 version = " + j + ", phone is " + paramWebViewPluginEngine);
                }
              }
              if (!arbz.cYb) {
                break label775;
              }
              if (localObject3 == null)
              {
                paramCustomWebView = null;
                label1054:
                if (paramCustomWebView != null) {
                  break label1110;
                }
                paramWebViewPluginEngine = "";
                label1062:
                if (paramCustomWebView != null) {
                  break label1118;
                }
              }
              label1110:
              label1118:
              for (paramCustomWebView = "";; paramCustomWebView = paramCustomWebView.getPath())
              {
                anot.a(null, "dc00899", "WV_Analysis", "", "jsapi_call", "total", 1, 0, paramWebViewPluginEngine, paramCustomWebView, str1, "");
                break;
                paramCustomWebView = Uri.parse((String)localObject3);
                break label1054;
                paramWebViewPluginEngine = paramCustomWebView.getHost();
                break label1062;
              }
            }
          }
          catch (JSONException paramWebViewPluginEngine)
          {
            for (;;)
            {
              paramWebViewPluginEngine = paramCustomWebView;
              continue;
              label1132:
              paramCustomWebView = (CustomWebView)localObject3;
            }
          }
        }
      }
      label1144:
      long l = -1L;
    }
  }
  
  private void b(WebViewPlugin paramWebViewPlugin)
  {
    if ((paramWebViewPlugin instanceof aqze))
    {
      String[] arrayOfString = ((aqze)paramWebViewPlugin).getMultiNameSpace();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!TextUtils.isEmpty(str)) {
            a(str, paramWebViewPlugin);
          }
          i += 1;
        }
      }
    }
    else if ((paramWebViewPlugin != null) && (!TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)))
    {
      a(paramWebViewPlugin.mPluginNameSpace, paramWebViewPlugin);
    }
  }
  
  /* Error */
  private static boolean b(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    // Byte code:
    //   0: new 184	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   7: aload_2
    //   8: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11: ldc_w 359
    //   14: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: ldc_w 361
    //   23: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore 9
    //   28: aload 9
    //   30: arraylength
    //   31: iconst_5
    //   32: if_icmpge +31 -> 63
    //   35: ldc 238
    //   37: iconst_1
    //   38: new 184	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 369
    //   48: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: aload 9
    //   65: iconst_2
    //   66: aaload
    //   67: astore 14
    //   69: ldc2_w 483
    //   72: lstore 7
    //   74: aload 9
    //   76: arraylength
    //   77: iconst_5
    //   78: if_icmpne +507 -> 585
    //   81: aload 9
    //   83: iconst_3
    //   84: aaload
    //   85: ldc_w 371
    //   88: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   91: astore 9
    //   93: aload 9
    //   95: arraylength
    //   96: iconst_1
    //   97: if_icmple +15 -> 112
    //   100: aload 9
    //   102: iconst_1
    //   103: aaload
    //   104: invokestatic 375	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: istore_3
    //   108: iload_3
    //   109: i2l
    //   110: lstore 7
    //   112: aload 9
    //   114: iconst_0
    //   115: aaload
    //   116: ldc_w 377
    //   119: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   122: astore 10
    //   124: aload 10
    //   126: arraylength
    //   127: iconst_1
    //   128: if_icmple +448 -> 576
    //   131: aload 10
    //   133: iconst_1
    //   134: aaload
    //   135: bipush 61
    //   137: invokevirtual 386	java/lang/String:indexOf	(I)I
    //   140: istore_3
    //   141: iload_3
    //   142: iconst_m1
    //   143: if_icmpeq +424 -> 567
    //   146: aload 10
    //   148: iconst_1
    //   149: aaload
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: invokevirtual 401	java/lang/String:substring	(I)Ljava/lang/String;
    //   156: invokestatic 411	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 11
    //   161: ldc_w 559
    //   164: aload 11
    //   166: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +383 -> 552
    //   172: iconst_0
    //   173: anewarray 363	java/lang/String
    //   176: astore 9
    //   178: aload 9
    //   180: astore 11
    //   182: aload 10
    //   184: iconst_0
    //   185: aaload
    //   186: astore 15
    //   188: new 184	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   195: aload 14
    //   197: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 334
    //   203: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 15
    //   208: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 22
    //   216: new 421	com/tencent/mobileqq/webview/swift/JsBridgeListener
    //   219: dup
    //   220: aload_1
    //   221: lload 7
    //   223: iconst_1
    //   224: invokespecial 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:<init>	(Lcom/tencent/smtt/sdk/WebView;JZ)V
    //   227: astore 21
    //   229: getstatic 92	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:eea	I
    //   232: iconst_m1
    //   233: if_icmpne +17 -> 250
    //   236: iconst_3
    //   237: iconst_1
    //   238: invokestatic 568	arca:s	(IZ)Z
    //   241: ifeq +362 -> 603
    //   244: iconst_1
    //   245: istore_3
    //   246: iload_3
    //   247: putstatic 92	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:eea	I
    //   250: getstatic 92	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:eea	I
    //   253: iconst_1
    //   254: if_icmpne +67 -> 321
    //   257: aload_1
    //   258: invokevirtual 429	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   261: astore 9
    //   263: aload 9
    //   265: ifnonnull +343 -> 608
    //   268: aconst_null
    //   269: astore 10
    //   271: aload 10
    //   273: ifnonnull +345 -> 618
    //   276: ldc_w 413
    //   279: astore 9
    //   281: aload 10
    //   283: ifnonnull +345 -> 628
    //   286: ldc_w 413
    //   289: astore 10
    //   291: aconst_null
    //   292: ldc_w 451
    //   295: ldc_w 453
    //   298: ldc_w 413
    //   301: ldc_w 570
    //   304: aload 22
    //   306: iconst_0
    //   307: iconst_0
    //   308: aload 9
    //   310: aload 10
    //   312: ldc_w 413
    //   315: ldc_w 413
    //   318: invokestatic 462	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   321: iconst_0
    //   322: istore 4
    //   324: iconst_0
    //   325: istore 5
    //   327: iconst_0
    //   328: istore 6
    //   330: aconst_null
    //   331: astore 18
    //   333: aconst_null
    //   334: astore 17
    //   336: aconst_null
    //   337: astore 19
    //   339: aconst_null
    //   340: astore 13
    //   342: aconst_null
    //   343: astore 16
    //   345: aconst_null
    //   346: astore 20
    //   348: iload 6
    //   350: istore_3
    //   351: aload 19
    //   353: astore 9
    //   355: aload 20
    //   357: astore 10
    //   359: aload 11
    //   361: astore 12
    //   363: aload 11
    //   365: arraylength
    //   366: iconst_1
    //   367: if_icmpne +123 -> 490
    //   370: iload 6
    //   372: istore_3
    //   373: aload 19
    //   375: astore 9
    //   377: aload 20
    //   379: astore 10
    //   381: aload 11
    //   383: astore 12
    //   385: ldc 56
    //   387: aload 22
    //   389: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   392: ifne +98 -> 490
    //   395: new 492	org/json/JSONObject
    //   398: dup
    //   399: aload 11
    //   401: iconst_0
    //   402: aaload
    //   403: invokespecial 493	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   406: astore 12
    //   408: aload 12
    //   410: ldc_w 572
    //   413: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   416: checkcast 363	java/lang/String
    //   419: invokestatic 375	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   422: istore_3
    //   423: aload 12
    //   425: ldc_w 578
    //   428: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   431: checkcast 363	java/lang/String
    //   434: astore 9
    //   436: aload 12
    //   438: ldc_w 580
    //   441: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   444: checkcast 363	java/lang/String
    //   447: astore 10
    //   449: aload 12
    //   451: ldc_w 582
    //   454: invokevirtual 576	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   457: pop
    //   458: aload 12
    //   460: invokevirtual 583	org/json/JSONObject:toString	()Ljava/lang/String;
    //   463: astore 13
    //   465: ldc_w 559
    //   468: aload 13
    //   470: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifeq +165 -> 638
    //   476: iconst_0
    //   477: anewarray 363	java/lang/String
    //   480: astore 12
    //   482: aload 12
    //   484: astore 11
    //   486: aload 11
    //   488: astore 12
    //   490: aload_1
    //   491: aload_1
    //   492: iload_3
    //   493: aload 9
    //   495: aload 10
    //   497: aload 22
    //   499: aload 21
    //   501: invokevirtual 587	com/tencent/biz/pubaccount/CustomWebView:checkToken	(Lcom/tencent/biz/pubaccount/CustomWebView;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)Z
    //   504: ifne +270 -> 774
    //   507: iconst_1
    //   508: ireturn
    //   509: astore_0
    //   510: ldc 238
    //   512: iconst_1
    //   513: iconst_1
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: new 184	java/lang/StringBuilder
    //   522: dup
    //   523: ldc_w 404
    //   526: invokespecial 330	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   529: aload_2
    //   530: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 349
    //   536: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_0
    //   540: invokevirtual 405	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   543: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aastore
    //   547: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   550: iconst_1
    //   551: ireturn
    //   552: iconst_1
    //   553: anewarray 363	java/lang/String
    //   556: astore 9
    //   558: aload 9
    //   560: iconst_0
    //   561: aload 11
    //   563: aastore
    //   564: goto -386 -> 178
    //   567: iconst_0
    //   568: anewarray 363	java/lang/String
    //   571: astore 9
    //   573: goto -395 -> 178
    //   576: iconst_0
    //   577: anewarray 363	java/lang/String
    //   580: astore 11
    //   582: goto -400 -> 182
    //   585: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq +13 -> 601
    //   591: ldc_w 589
    //   594: iconst_2
    //   595: ldc_w 591
    //   598: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: iconst_0
    //   602: ireturn
    //   603: iconst_0
    //   604: istore_3
    //   605: goto -359 -> 246
    //   608: aload 9
    //   610: invokestatic 476	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   613: astore 10
    //   615: goto -344 -> 271
    //   618: aload 10
    //   620: invokevirtual 479	android/net/Uri:getHost	()Ljava/lang/String;
    //   623: astore 9
    //   625: goto -344 -> 281
    //   628: aload 10
    //   630: invokevirtual 482	android/net/Uri:getPath	()Ljava/lang/String;
    //   633: astore 10
    //   635: goto -344 -> 291
    //   638: iconst_1
    //   639: anewarray 363	java/lang/String
    //   642: astore 12
    //   644: aload 12
    //   646: iconst_0
    //   647: aload 13
    //   649: aastore
    //   650: aload 12
    //   652: astore 11
    //   654: goto -168 -> 486
    //   657: astore 13
    //   659: aload 10
    //   661: astore 12
    //   663: aload 9
    //   665: astore 10
    //   667: aload 13
    //   669: astore 9
    //   671: ldc 238
    //   673: iconst_1
    //   674: new 184	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 593
    //   684: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 9
    //   689: invokevirtual 405	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   692: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: aload 10
    //   703: astore 9
    //   705: aload 12
    //   707: astore 10
    //   709: aload 11
    //   711: astore 12
    //   713: goto -223 -> 490
    //   716: astore 9
    //   718: aload 16
    //   720: astore 12
    //   722: aload 17
    //   724: astore 10
    //   726: iload 5
    //   728: istore_3
    //   729: ldc 238
    //   731: iconst_1
    //   732: new 184	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   739: ldc_w 595
    //   742: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload 9
    //   747: invokevirtual 596	org/json/JSONException:toString	()Ljava/lang/String;
    //   750: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: aload 10
    //   761: astore 9
    //   763: aload 12
    //   765: astore 10
    //   767: aload 11
    //   769: astore 12
    //   771: goto -281 -> 490
    //   774: getstatic 49	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:pz	Ljava/util/HashMap;
    //   777: aload 22
    //   779: invokevirtual 168	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   782: ifeq +207 -> 989
    //   785: getstatic 49	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:pz	Ljava/util/HashMap;
    //   788: aload 22
    //   790: invokevirtual 172	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   793: checkcast 363	java/lang/String
    //   796: ldc_w 598
    //   799: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   802: astore 10
    //   804: aload 10
    //   806: arraylength
    //   807: iconst_2
    //   808: if_icmpne +181 -> 989
    //   811: aload 10
    //   813: iconst_0
    //   814: aaload
    //   815: astore 9
    //   817: aload 10
    //   819: iconst_1
    //   820: aaload
    //   821: astore 10
    //   823: aload_0
    //   824: aload 9
    //   826: invokevirtual 440	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   829: astore 13
    //   831: aload 13
    //   833: astore 11
    //   835: aload 13
    //   837: ifnonnull +11 -> 848
    //   840: aload_0
    //   841: aload 9
    //   843: invokespecial 442	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   846: astore 11
    //   848: aload 11
    //   850: ifnull +22 -> 872
    //   853: aload 11
    //   855: aload 21
    //   857: aload_2
    //   858: aload 9
    //   860: aload 10
    //   862: aload 12
    //   864: invokestatic 444	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   867: ifeq +5 -> 872
    //   870: iconst_1
    //   871: ireturn
    //   872: aload_1
    //   873: aload 21
    //   875: iconst_3
    //   876: iconst_1
    //   877: anewarray 363	java/lang/String
    //   880: dup
    //   881: iconst_0
    //   882: iconst_3
    //   883: aconst_null
    //   884: ldc_w 600
    //   887: invokestatic 603	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   890: aastore
    //   891: invokevirtual 607	com/tencent/biz/pubaccount/CustomWebView:callJs4OpenApi	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;I[Ljava/lang/String;)V
    //   894: iconst_1
    //   895: ireturn
    //   896: astore 9
    //   898: aload 17
    //   900: astore 10
    //   902: aload 16
    //   904: astore 12
    //   906: goto -177 -> 729
    //   909: astore 12
    //   911: aload 9
    //   913: astore 10
    //   915: aload 12
    //   917: astore 9
    //   919: aload 16
    //   921: astore 12
    //   923: goto -194 -> 729
    //   926: astore 13
    //   928: aload 10
    //   930: astore 12
    //   932: aload 9
    //   934: astore 10
    //   936: aload 13
    //   938: astore 9
    //   940: goto -211 -> 729
    //   943: astore 9
    //   945: iload 4
    //   947: istore_3
    //   948: aload 18
    //   950: astore 10
    //   952: aload 13
    //   954: astore 12
    //   956: goto -285 -> 671
    //   959: astore 9
    //   961: aload 18
    //   963: astore 10
    //   965: aload 13
    //   967: astore 12
    //   969: goto -298 -> 671
    //   972: astore 12
    //   974: aload 9
    //   976: astore 10
    //   978: aload 12
    //   980: astore 9
    //   982: aload 13
    //   984: astore 12
    //   986: goto -315 -> 671
    //   989: aload 15
    //   991: astore 10
    //   993: aload 14
    //   995: astore 9
    //   997: goto -174 -> 823
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	paramWebViewPluginEngine	WebViewPluginEngine
    //   0	1000	1	paramCustomWebView	CustomWebView
    //   0	1000	2	paramString	String
    //   107	841	3	i	int
    //   322	624	4	j	int
    //   325	402	5	k	int
    //   328	43	6	m	int
    //   72	150	7	l	long
    //   26	678	9	localObject1	Object
    //   716	30	9	localJSONException1	JSONException
    //   761	98	9	localObject2	Object
    //   896	16	9	localJSONException2	JSONException
    //   917	22	9	localObject3	Object
    //   943	1	9	localNumberFormatException1	NumberFormatException
    //   959	16	9	localNumberFormatException2	NumberFormatException
    //   980	16	9	localObject4	Object
    //   122	870	10	localObject5	Object
    //   159	695	11	localObject6	Object
    //   361	544	12	localObject7	Object
    //   909	7	12	localJSONException3	JSONException
    //   921	47	12	localObject8	Object
    //   972	7	12	localNumberFormatException3	NumberFormatException
    //   984	1	12	localJSONException4	JSONException
    //   340	308	13	str1	String
    //   657	11	13	localNumberFormatException4	NumberFormatException
    //   829	7	13	localWebViewPlugin	WebViewPlugin
    //   926	57	13	localJSONException5	JSONException
    //   67	927	14	str2	String
    //   186	804	15	str3	String
    //   343	577	16	localObject9	Object
    //   334	565	17	localObject10	Object
    //   331	631	18	localObject11	Object
    //   337	37	19	localObject12	Object
    //   346	32	20	localObject13	Object
    //   227	647	21	localJsBridgeListener	JsBridgeListener
    //   214	575	22	str4	String
    // Exception table:
    //   from	to	target	type
    //   100	108	509	java/lang/NumberFormatException
    //   449	482	657	java/lang/NumberFormatException
    //   638	644	657	java/lang/NumberFormatException
    //   395	423	716	org/json/JSONException
    //   423	436	896	org/json/JSONException
    //   436	449	909	org/json/JSONException
    //   449	482	926	org/json/JSONException
    //   638	644	926	org/json/JSONException
    //   395	423	943	java/lang/NumberFormatException
    //   423	436	959	java/lang/NumberFormatException
    //   436	449	972	java/lang/NumberFormatException
  }
  
  private String bX(long paramLong)
  {
    String str = Long.toBinaryString(paramLong);
    if (!TextUtils.isEmpty(str))
    {
      int i = str.length();
      return "1L << " + (i - str.replaceAll("0", "").length());
    }
    return "";
  }
  
  private static boolean c(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    String str2 = paramCustomWebView.getUrl();
    int i = "nativeapi".length();
    int j = paramString.indexOf('?');
    if (j == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "invalid native api call, '?' request");
      }
    }
    String str1;
    JSONObject localJSONObject;
    uay localuay;
    do
    {
      for (;;)
      {
        return true;
        str1 = paramString.substring(i + 3, j);
        if (!paramString.startsWith("p=", j + 1))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_WebViewPluginEngine", 2, "invalid native api call, param key not found");
            return true;
          }
        }
        else
        {
          paramString = URLDecoder.decode(paramString.substring(j + 3));
          try
          {
            localJSONObject = new JSONObject(paramString);
            localuay = new uay(paramCustomWebView, localJSONObject);
            str2 = ubu.gZ(str2);
            if (!TextUtils.isEmpty(str2)) {
              break label171;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("WebLog_WebViewPluginEngine", 2, "invalid native api call, url is illegal");
              return true;
            }
          }
          catch (JSONException paramWebViewPluginEngine) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewPluginEngine", 2, "invalid native api call, parse param error", paramWebViewPluginEngine);
    return true;
    label171:
    if (paramWebViewPluginEngine.x == null)
    {
      if (!cXx)
      {
        cXx = true;
        tzk.prepare();
      }
      paramWebViewPluginEngine.x = new arao(2);
    }
    paramString = (uaw)paramWebViewPluginEngine.x.get(str2);
    if ("config".equals(str1))
    {
      paramCustomWebView = paramString;
      if (paramString == null)
      {
        paramCustomWebView = localJSONObject.optString("appid");
        paramString = new Bundle();
        paramString.putString("urlSummary", str2);
        paramString = (uaw)tzk.a(paramWebViewPluginEngine.activity, 0, paramCustomWebView, paramString);
        paramCustomWebView = paramString;
        if (paramString != null)
        {
          paramCustomWebView = localJSONObject.optString("state");
          String str3 = localJSONObject.optString("redirect_uri");
          if ((!TextUtils.isEmpty(paramCustomWebView)) && (!TextUtils.isEmpty(str3)))
          {
            paramString.aQP = true;
            paramString.aKs = paramCustomWebView;
            paramString.aKt = str3;
          }
          paramWebViewPluginEngine.x.put(str2, paramString);
          paramCustomWebView = paramString;
        }
      }
      if (paramCustomWebView != null)
      {
        paramCustomWebView.a(str1, localJSONObject, localuay);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "apimgr create fail");
      }
      ubu.a(localuay, 11);
      return true;
    }
    if ((paramString != null) && (paramString.Oz()))
    {
      paramString.a(str1, localJSONObject, localuay);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewPluginEngine", 2, "apimgr not verified");
    }
    ubu.a(localuay, 10);
    return true;
  }
  
  private void d(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null) {
      QLog.e("WebLog_WebViewPluginEngine", 1, "registerJSInterface webView is null");
    }
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT >= 17) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WebLog_WebViewPluginEngine", 1, "registerJSInterface SDK is lower than 4.2");
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl != null);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewPluginEngine", 2, "registerJSInterface");
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl = new WebViewJSInterfaceImpl();
    paramCustomWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine$WebViewJSInterfaceImpl, "_mqqWebViewJSInterface");
  }
  
  private boolean internalShouldOverrideUrlRequest(String paramString)
  {
    String str1 = arcp.getSchemeFromUrl(paramString);
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    if ("javascript".equals(str1)) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject1 == null) {
      return false;
    }
    if ("jsbridge".equals(str1)) {
      return a(this, (CustomWebView)localObject1, paramString);
    }
    if ("openapi".equals(str1)) {
      return b(this, (CustomWebView)localObject1, paramString);
    }
    if ("nativeapi".equals(str1)) {
      return c(this, (CustomWebView)localObject1, paramString);
    }
    String str2 = ((CustomWebView)localObject1).getUrl();
    if ((this.py.containsKey(str1)) && (b().B(str2, str1)))
    {
      Object localObject2 = (CopyOnWriteArrayList)this.py.get(str1);
      if ((localObject2 != null) && (!((CopyOnWriteArrayList)localObject2).isEmpty()))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(((CopyOnWriteArrayList)localObject2).size() * 64);
          localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label394;
          }
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin != null)
          {
            if (localWebViewPlugin.handleSchemaRequest(paramString, str1))
            {
              if (QLog.isColorLevel())
              {
                long l2 = System.currentTimeMillis();
                ((StringBuilder)localObject1).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handle scheme[").append(str1).append("] success cost ").append(l2 - l1).append(" ms.");
                QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
              }
              arbz.ad(paramString, str2, 0);
              return true;
              localObject1 = new StringBuilder();
              break;
            }
            if (QLog.isColorLevel())
            {
              l1 = System.currentTimeMillis() - l1;
              if (l1 > 50L) {
                ((StringBuilder)localObject1).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handle scheme[").append(str1).append("] cost ").append(l1).append(" ms.");
              }
            }
          }
        }
        label394:
        if ((QLog.isColorLevel()) && (((StringBuilder)localObject1).length() > 0))
        {
          ((StringBuilder)localObject1).append("overrideUrlRequest error:no plugin can handle this scheme[").append(str1).append("].");
          QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
        }
        arbz.ad(paramString, str2, 1);
      }
    }
    for (;;)
    {
      return false;
      QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("overrideUrlRequest error:no plugin can handle this scheme[").append(str1).append("].") });
      arbz.ad(paramString, str2, 2);
    }
  }
  
  private static void qw(String paramString)
  {
    QLog.e("WebLog_WebViewPluginEngine", 1, paramString);
  }
  
  public String CJ()
  {
    if ((this.pluginHashMap == null) || (this.pluginHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "-->plugin list is empty.");
      }
      return "no plugins";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("plugin list:\n");
    Iterator localIterator = this.pluginHashMap.values().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((WebViewPlugin)localIterator.next()).getClass().getSimpleName()).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  public void VT(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is null");
      return;
    }
    String str;
    if (paramString.startsWith("https://jsbridge/"))
    {
      str = paramString.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
          break label140;
        }
        QLog.i("WebLog_WebViewPluginEngine", 2, "handleJsInterfaceRequest:" + str.substring(0, 512));
      }
    }
    for (;;)
    {
      if (str.startsWith("jsbridge:")) {
        break label166;
      }
      QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is not startsWith jsbridge");
      return;
      str = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      str = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label140:
      QLog.i("WebLog_WebViewPluginEngine", 2, "handleJsInterfaceRequest:" + str);
    }
    label166:
    ThreadManagerV2.getUIHandlerV2().post(new WebViewPluginEngine.3(this, str));
  }
  
  public WebViewPlugin a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = arap.sPluginNameSpaceHashMap.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (((Integer)((Map.Entry)localObject2).getValue()).intValue() == paramInt) {
        if (!this.pluginHashMap.containsKey(((Map.Entry)localObject2).getKey())) {
          break;
        }
      }
    }
    for (localObject1 = (WebViewPlugin)this.pluginHashMap.get(((Map.Entry)localObject2).getKey());; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (paramBoolean)
        {
          localObject1 = arap.a(paramInt);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            b((WebViewPlugin)localObject1);
            a((WebViewPlugin)localObject1);
            localObject2 = localObject1;
          }
        }
      }
      return localObject2;
    }
  }
  
  public uaw a(String paramString)
  {
    paramString = ubu.gZ(paramString);
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewPluginEngine", 2, "invalid native api call, url is illegal");
      }
    }
    while (this.x == null) {
      return null;
    }
    return (uaw)this.x.get(paramString);
  }
  
  public void a(AppInterface paramAppInterface, Activity paramActivity)
  {
    b(paramAppInterface, paramActivity, null);
  }
  
  public void aa(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  public WebViewPlugin b(String paramString)
  {
    if (this.pluginHashMap.containsKey(paramString)) {
      return (WebViewPlugin)this.pluginHashMap.get(paramString);
    }
    return null;
  }
  
  public jml b()
  {
    if (this.authCfg == null) {
      this.authCfg = jml.a();
    }
    return this.authCfg;
  }
  
  public void b(aqzv paramaqzv)
  {
    if (paramaqzv == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.pluginHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if (localWebViewPlugin != null) {
          localWebViewPlugin.setWebUiInterface(paramaqzv);
        }
      }
    }
  }
  
  public void b(AppInterface paramAppInterface, Activity paramActivity, List<WebViewPlugin> paramList)
  {
    int i = 0;
    if (this.activity == null) {
      this.activity = paramActivity;
    }
    if (this.c == null) {
      this.c = paramAppInterface;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      a(paramAppInterface, paramActivity, paramList);
    }
    if ((paramActivity != null) && (paramActivity.getIntent() != null)) {}
    for (boolean bool = paramActivity.getIntent().getBooleanExtra("fromQZone", false);; bool = false)
    {
      paramList = this.pluginHashMap.values().iterator();
      while (paramList.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
        if (localWebViewPlugin != null)
        {
          if (localWebViewPlugin.mRuntime == null) {
            localWebViewPlugin.initRuntime(paramActivity, paramAppInterface);
          }
          localWebViewPlugin.onActivityReady();
          if ((localWebViewPlugin instanceof suw)) {
            i = 1;
          }
        }
      }
      if ((bool) && (i == 0))
      {
        paramList = new suw();
        paramList.initRuntime(paramActivity, paramAppInterface);
        paramList.onCreate();
        paramList.onAppRuntimeReady(paramAppInterface);
        b(paramList);
      }
      return;
    }
  }
  
  public void bindFragment(WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment == null) {}
    for (;;)
    {
      return;
      this.b = paramWebViewFragment;
      Iterator localIterator = this.pluginHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if (localWebViewPlugin != null) {
          localWebViewPlugin.bindFragment(paramWebViewFragment);
        }
      }
    }
  }
  
  public boolean c(String paramString, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", Integer.valueOf(paramInt));
    return handleEvent(paramString, paramLong, localHashMap);
  }
  
  public void e(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != paramCustomWebView))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      Iterator localIterator = this.pluginHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((WebViewPlugin)localIterator.next()).onWebViewCreated(paramCustomWebView);
      }
      d(paramCustomWebView);
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    Object localObject1 = (List)this.px.get(Long.valueOf(paramLong));
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = bX(paramLong);
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    while ((localObject2 == null) || (((List)localObject2).size() == 0))
    {
      return null;
      if (paramLong > 8589934592L)
      {
        localObject2 = new CopyOnWriteArrayList(this.pluginHashMap.values());
        localObject1 = String.valueOf(paramLong - 8589934592L);
      }
      else
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("handleEvent error:no plugin can handle this event(").append(paramLong).append(").") });
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    HashMap localHashMap = new HashMap();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder(((List)localObject2).size() * 64);
      localObject2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label410;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        long l1 = System.currentTimeMillis();
        Object localObject4 = localWebViewPlugin.handleEvent(paramString, paramLong);
        if (localObject4 != null)
        {
          if (QLog.isColorLevel())
          {
            long l2 = System.currentTimeMillis();
            ((StringBuilder)localObject3).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] success cost ").append(l2 - l1).append(" ms.");
            QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject3).toString());
          }
          return localObject4;
          localObject3 = new StringBuilder();
          break;
        }
        localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
        if (QLog.isColorLevel())
        {
          l1 = System.currentTimeMillis() - l1;
          if (l1 > 50L) {
            ((StringBuilder)localObject3).append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] cost ").append(l1).append(" ms\r\n.");
          }
        }
      }
    }
    label410:
    if ((QLog.isColorLevel()) && (((StringBuilder)localObject3).length() > 0))
    {
      ((StringBuilder)localObject3).append("handleEvent error:no plugin can handleEvent (").append((String)localObject1).append(")");
      QLog.i("WebLog_WebViewPluginEngine", 2, ((StringBuilder)localObject3).toString());
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject;
    if (this.px.containsKey(Long.valueOf(paramLong))) {
      localObject = (List)this.px.get(Long.valueOf(paramLong));
    }
    while ((localObject == null) || (((List)localObject).size() == 0))
    {
      return false;
      if (paramLong > 8589934592L)
      {
        localObject = new CopyOnWriteArrayList(this.pluginHashMap.values());
      }
      else
      {
        QLog.e("WebLog_WebViewPluginEngine", 1, new Object[] { new StringBuilder("handleEvent error:no plugin can handle this event(").append(paramLong).append(").") });
        localObject = null;
      }
    }
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(((List)localObject).size() * 64);
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label390;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        long l = System.currentTimeMillis();
        if (localWebViewPlugin.handleEvent(paramString, paramLong, paramMap))
        {
          if (QLog.isColorLevel())
          {
            l = System.currentTimeMillis() - l;
            if (l > 50L)
            {
              localStringBuilder.append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] success cost ").append(l).append(" ms.");
              QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
            }
          }
          return true;
          localStringBuilder = new StringBuilder();
          break;
        }
        localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
        if (QLog.isColorLevel())
        {
          l = System.currentTimeMillis() - l;
          if (l > 50L) {
            localStringBuilder.append("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] handled event[").append(paramLong).append("] cost ").append(l).append(" ms\r\n.");
          }
        }
      }
    }
    label390:
    if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
    {
      localStringBuilder.append("handleEvent error: no plugin can handleEvent(").append(paramLong).append(")");
      QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean i(Map<String, Object> paramMap)
  {
    Object localObject1 = (CopyOnWriteArrayList)this.px.get(Long.valueOf(32L));
    if ((localObject1 == null) || (((CopyOnWriteArrayList)localObject1).size() == 0)) {
      return false;
    }
    StringBuilder localStringBuilder;
    HashMap localHashMap;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(((CopyOnWriteArrayList)localObject1).size() * 64);
      localHashMap = new HashMap();
      localObject1 = ((CopyOnWriteArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label295;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject1).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        Object localObject2 = paramMap.get("url");
        if ((localObject2 instanceof String))
        {
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin.handleEvent((String)localObject2, 32L, paramMap))
          {
            if (QLog.isColorLevel())
            {
              long l2 = System.currentTimeMillis();
              localStringBuilder.append("plugin [").append(localWebViewPlugin.getClass().getSimpleName()).append("] handleBeforeLoad success, cost ").append(l2 - l1).append(" ms.");
              QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
            }
            return true;
            localStringBuilder = new StringBuilder();
            break;
          }
          localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
          if (QLog.isColorLevel())
          {
            l1 = System.currentTimeMillis() - l1;
            if (l1 > 50L) {
              localStringBuilder.append("plugin [").append(localWebViewPlugin.getClass().getSimpleName()).append("] handleBeforeLoad, cost ").append(l1).append(" ms.\r\n");
            }
          }
        }
      }
    }
    label295:
    if ((QLog.isColorLevel()) && (localStringBuilder.length() > 0))
    {
      localStringBuilder.append("handleBeforeLoad error:no plugin can handled!");
      QLog.i("WebLog_WebViewPluginEngine", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void onDestroy()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.pluginHashMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
        if ((localWebViewPlugin == null) || (localHashMap.containsKey(localWebViewPlugin))) {
          continue;
        }
        long l = System.currentTimeMillis();
        try
        {
          localWebViewPlugin.onDestroy();
          localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
          if (QLog.isColorLevel())
          {
            l = System.currentTimeMillis() - l;
            if (l > 50L) {
              QLog.d("WebLog_WebViewPluginEngine", 2, new Object[] { new StringBuilder("plugin[").append(localWebViewPlugin.getClass().getSimpleName()).append("] onDestroy cost ").append(l).append(" ms.") });
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewPluginEngine", 2, QLog.getStackTraceString(localException));
            }
          }
        }
      }
    }
    this.pluginHashMap.clear();
    this.px.clear();
    this.py.clear();
    if (this.x != null) {
      this.x.evictAll();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  }
  
  public void preCreatePlugin()
  {
    Intent localIntent;
    Object localObject1;
    if (this.activity != null)
    {
      localIntent = this.activity.getIntent();
      localObject2 = localIntent.getStringExtra("url");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = localIntent.getStringExtra("key_params_qq");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      return;
    }
    int i = ((String)localObject1).indexOf(":");
    if (i > 0) {}
    for (Object localObject2 = ((String)localObject1).substring(0, i);; localObject2 = "")
    {
      Object localObject3;
      if (localIntent.getIntExtra("uintype", -1) == 1030)
      {
        localObject3 = new aeak();
        a((WebViewPlugin)localObject3);
        a("campus_circle", (WebViewPlugin)localObject3);
      }
      if ((localIntent.getBooleanExtra("fromQZone", false)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https"))))
      {
        localObject3 = new suw();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (ajmu.nv((String)localObject1))
      {
        localObject3 = new ajmu();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (awpj.ud((String)localObject1))
      {
        localObject3 = new awpj();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (sun.gk((String)localObject1))
      {
        localObject3 = new sun();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if ((((String)localObject1).startsWith("http://clientui.3g.qq.com/mqqapi/im/roam")) || (((String)localObject1).startsWith("https://mapp.3g.qq.com/touch/psw/verify.jsp")) || (((String)localObject1).startsWith("https://mapp.3g.qq.com/touch/psw/create.jsp")))
      {
        localObject3 = new MessageRoamJsPlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (((String)localObject2).equals("qqjsbridge"))
      {
        localObject3 = new QWalletPayJsPlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if ((kdl.yW()) && (kdl.dq((String)localObject1)))
      {
        localObject3 = new sst();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (((String)localObject1).contains("thunder_id"))
      {
        localObject3 = new ApolloJsPlugin((String)localObject1);
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (((String)localObject1).contains("apollo_bk"))
      {
        localObject3 = new ApolloGamePlugin();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if ((((String)localObject1).contains("docx.qq.com")) || (((String)localObject1).contains("docs.qq.com")))
      {
        localObject3 = new aiiy();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (aqtl.rG((String)localObject1))
      {
        localObject3 = new aqtl();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (((String)localObject1).contains("lbs.qidian.qq.com/authorize/voiceShow"))
      {
        localObject3 = new asid();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if (((String)localObject1).contains("kandian.qq.com"))
      {
        localObject3 = new svb();
        a((WebViewPlugin)localObject3);
        b((WebViewPlugin)localObject3);
      }
      if ((localIntent.getBooleanExtra("key_from_splash_ad", false)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https"))))
      {
        localObject2 = new anmn();
        a((WebViewPlugin)localObject2);
        a("splashADPlugin", (WebViewPlugin)localObject2);
      }
      if ((((String)localObject1).contains("sou.qq.com")) || (MiniAppPlugin.isUrlBelongToMiniAppShare((String)localObject1)))
      {
        localObject1 = new MiniAppPlugin();
        a((WebViewPlugin)localObject1);
        b((WebViewPlugin)localObject1);
      }
      localObject1 = localIntent.getExtras();
      if ((localObject1 != null) && ((Class)((Bundle)localObject1).getSerializable("fragmentClass") == ArkBrowserFragment.class))
      {
        localObject2 = new adrt();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if ((localObject1 != null) && (((Bundle)localObject1).getParcelable("h5_ark_url_web_checker") != null))
      {
        localObject2 = new adto((Bundle)localObject1);
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      localObject2 = new aike();
      a((WebViewPlugin)localObject2);
      b((WebViewPlugin)localObject2);
      if ((localObject1 != null) && ("music".equals(((Bundle)localObject1).getString("forward_ark_app_view"))))
      {
        localObject1 = new igc();
        a((WebViewPlugin)localObject1);
        b((WebViewPlugin)localObject1);
      }
      asbw.a();
      return;
    }
  }
  
  public boolean shouldOverrideUrlRequest(String paramString)
  {
    boolean bool = internalShouldOverrideUrlRequest(paramString);
    if (bool) {}
    return bool;
  }
  
  public class WebViewJSInterfaceImpl
  {
    public WebViewJSInterfaceImpl() {}
    
    @JavascriptInterface
    public void invoke(String paramString)
    {
      WebViewPluginEngine.this.VT(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */