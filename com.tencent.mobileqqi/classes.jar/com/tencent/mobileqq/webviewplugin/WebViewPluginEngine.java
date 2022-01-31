package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebViewPluginEngine
{
  static final String jdField_a_of_type_JavaLangString = WebViewPluginEngine.class.getSimpleName();
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  List jdField_a_of_type_JavaUtilList;
  
  public WebViewPluginEngine(WebView paramWebView, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    int i = 0;
    for (;;)
    {
      if (i < WebViewPluginConfig.a.length)
      {
        WebViewPluginConfig.PluginInfo localPluginInfo = WebViewPluginConfig.a[i];
        try
        {
          System.currentTimeMillis();
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)a(localPluginInfo.a, new Class[0]).newInstance(new Object[0]);
          localWebViewPlugin.initRuntime(paramWebView, paramActivity, paramAppInterface);
          localWebViewPlugin.onCreate();
          this.jdField_a_of_type_JavaUtilList.add(localWebViewPlugin);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, "cannot create plugin " + localPluginInfo.a.getSimpleName() + " : " + localException.getMessage());
            }
          }
        }
      }
    }
  }
  
  public WebViewPluginEngine(WebView paramWebView, Activity paramActivity, AppInterface paramAppInterface, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.get(i);
        try
        {
          System.currentTimeMillis();
          localWebViewPlugin.initRuntime(paramWebView, paramActivity, paramAppInterface);
          localWebViewPlugin.onCreate();
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, "cannot create plugin " + localWebViewPlugin.getClass().getSimpleName() + " : " + localException.getMessage());
            }
          }
        }
      }
    }
  }
  
  private static Constructor a(Class paramClass, Class... paramVarArgs)
  {
    if (VersionUtils.e())
    {
      paramClass = paramClass.getConstructor(paramVarArgs);
      return paramClass;
    }
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      Constructor localConstructor = arrayOfConstructor[i];
      paramClass = localConstructor;
      if (a(paramVarArgs, localConstructor.getParameterTypes())) {
        break;
      }
      i += 1;
    }
    label59:
    throw new NoSuchMethodException();
  }
  
  private static boolean a(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length != paramArrayOfClass2.length) {
      return false;
    }
    int j = paramArrayOfClass1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label35;
      }
      if (paramArrayOfClass1[i] != paramArrayOfClass2[i]) {
        break;
      }
      i += 1;
    }
    label35:
    return true;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i)).equals(paramWebViewPlugin)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public WebViewPlugin a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Object a(String paramString, int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
      System.currentTimeMillis();
      localObject = ((WebViewPlugin)localObject).handleEvent(paramString, paramInt);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
      System.currentTimeMillis();
      localWebViewPlugin.onDestroy();
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {}
    label129:
    for (;;)
    {
      return false;
      int i = paramString.indexOf(":");
      String str;
      if (i > 0)
      {
        str = paramString.substring(0, i);
        localObject = ((WebView)localObject).getUrl();
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
          this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
        }
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c((String)localObject, str)) {
          i = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label129;
          }
          localObject = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
          System.currentTimeMillis();
          if (((WebViewPlugin)localObject).handleSchemaRequest(paramString, str))
          {
            return true;
            str = "";
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", Integer.valueOf(paramInt2));
    paramInt2 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
        System.currentTimeMillis();
        if (localWebViewPlugin.handleEvent(paramString, paramInt1, localHashMap)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      paramInt2 += 1;
    }
  }
  
  public boolean a(String paramString, int paramInt, Map paramMap)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
        System.currentTimeMillis();
        if (localWebViewPlugin.handleEvent(paramString, paramInt, paramMap)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   4: astore 10
    //   6: aload 10
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull +719 -> 733
    //   17: aload_1
    //   18: ldc 221
    //   20: invokevirtual 224	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   23: ifeq +710 -> 733
    //   26: new 83	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 226
    //   39: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: ldc 228
    //   47: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore 12
    //   52: aload 12
    //   54: arraylength
    //   55: iconst_5
    //   56: if_icmpge +20 -> 76
    //   59: invokestatic 81	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   62: ifeq +12 -> 74
    //   65: getstatic 19	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: iconst_4
    //   69: ldc 234
    //   71: invokestatic 237	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: iconst_1
    //   75: ireturn
    //   76: aload 12
    //   78: iconst_2
    //   79: aaload
    //   80: astore 11
    //   82: ldc2_w 238
    //   85: lstore 5
    //   87: aload 12
    //   89: arraylength
    //   90: iconst_5
    //   91: if_icmpne +336 -> 427
    //   94: aload 12
    //   96: iconst_3
    //   97: aaload
    //   98: ldc 241
    //   100: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore 8
    //   105: aload 8
    //   107: arraylength
    //   108: iconst_1
    //   109: if_icmple +15 -> 124
    //   112: aload 8
    //   114: iconst_1
    //   115: aaload
    //   116: invokestatic 244	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   119: istore_2
    //   120: iload_2
    //   121: i2l
    //   122: lstore 5
    //   124: aload 8
    //   126: iconst_0
    //   127: aaload
    //   128: ldc 246
    //   130: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   133: astore 12
    //   135: aload 12
    //   137: arraylength
    //   138: iconst_1
    //   139: if_icmple +99 -> 238
    //   142: aload 12
    //   144: iconst_1
    //   145: aaload
    //   146: ldc 248
    //   148: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   151: astore 9
    //   153: iconst_0
    //   154: istore_2
    //   155: aload 9
    //   157: arraylength
    //   158: istore_3
    //   159: aload 9
    //   161: astore 8
    //   163: iload_2
    //   164: iload_3
    //   165: if_icmpge +79 -> 244
    //   168: aload 9
    //   170: iload_2
    //   171: aaload
    //   172: bipush 61
    //   174: invokevirtual 251	java/lang/String:indexOf	(I)I
    //   177: istore 4
    //   179: iload 4
    //   181: iconst_m1
    //   182: if_icmpeq +47 -> 229
    //   185: aload 9
    //   187: iload_2
    //   188: aload 9
    //   190: iload_2
    //   191: aaload
    //   192: iload 4
    //   194: iconst_1
    //   195: iadd
    //   196: invokevirtual 254	java/lang/String:substring	(I)Ljava/lang/String;
    //   199: invokestatic 260	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   202: aastore
    //   203: iload_2
    //   204: iconst_1
    //   205: iadd
    //   206: istore_2
    //   207: goto -48 -> 159
    //   210: astore_1
    //   211: invokestatic 81	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   214: ifeq +13 -> 227
    //   217: getstatic 19	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: iconst_4
    //   221: ldc_w 262
    //   224: invokestatic 237	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_1
    //   228: ireturn
    //   229: aload 9
    //   231: iload_2
    //   232: ldc 193
    //   234: aastore
    //   235: goto -32 -> 203
    //   238: iconst_0
    //   239: anewarray 164	java/lang/String
    //   242: astore 8
    //   244: aload 12
    //   246: iconst_0
    //   247: aaload
    //   248: astore 9
    //   250: iconst_0
    //   251: istore_2
    //   252: invokestatic 81	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   255: ifeq +42 -> 297
    //   258: getstatic 19	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   261: iconst_4
    //   262: new 83	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 264
    //   272: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 11
    //   277: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 266
    //   283: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload 9
    //   288: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: new 268	com/tencent/mobileqq/webviewplugin/JsBridgeListener
    //   300: dup
    //   301: aload 10
    //   303: lload 5
    //   305: aload_1
    //   306: invokespecial 271	com/tencent/mobileqq/webviewplugin/JsBridgeListener:<init>	(Lcom/tencent/smtt/sdk/WebView;JLjava/lang/String;)V
    //   309: astore 12
    //   311: aload 10
    //   313: invokevirtual 177	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   316: astore 13
    //   318: aload_0
    //   319: getfield 179	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   322: ifnonnull +10 -> 332
    //   325: aload_0
    //   326: invokestatic 184	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   329: putfield 179	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   332: aload_0
    //   333: getfield 179	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   336: aload 13
    //   338: new 83	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   345: aload 11
    //   347: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc_w 266
    //   353: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 9
    //   358: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokevirtual 273	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   367: ifeq +358 -> 725
    //   370: iconst_0
    //   371: istore_3
    //   372: iload_3
    //   373: aload_0
    //   374: getfield 31	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   377: invokeinterface 107 1 0
    //   382: if_icmpge +193 -> 575
    //   385: aload_0
    //   386: getfield 31	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   389: iload_3
    //   390: invokeinterface 111 2 0
    //   395: checkcast 60	com/tencent/mobileqq/webviewplugin/WebViewPlugin
    //   398: astore 13
    //   400: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   403: pop2
    //   404: aload 13
    //   406: aload 12
    //   408: aload_1
    //   409: aload 11
    //   411: aload 9
    //   413: aload 8
    //   415: invokevirtual 277	com/tencent/mobileqq/webviewplugin/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webviewplugin/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   418: istore 7
    //   420: iload 7
    //   422: ifeq +146 -> 568
    //   425: iconst_1
    //   426: ireturn
    //   427: aload 12
    //   429: iconst_3
    //   430: aaload
    //   431: astore 9
    //   433: aload 12
    //   435: iconst_4
    //   436: aaload
    //   437: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   440: lstore 5
    //   442: aload 12
    //   444: arraylength
    //   445: bipush 6
    //   447: isub
    //   448: istore_2
    //   449: iload_2
    //   450: anewarray 164	java/lang/String
    //   453: astore 8
    //   455: aload 12
    //   457: iconst_5
    //   458: aload 8
    //   460: iconst_0
    //   461: iload_2
    //   462: invokestatic 287	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   465: iconst_0
    //   466: istore_2
    //   467: aload 8
    //   469: arraylength
    //   470: istore_3
    //   471: iload_2
    //   472: iload_3
    //   473: if_icmpge +269 -> 742
    //   476: aload 8
    //   478: iload_2
    //   479: aload 8
    //   481: iload_2
    //   482: aaload
    //   483: invokestatic 260	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   486: aastore
    //   487: iload_2
    //   488: iconst_1
    //   489: iadd
    //   490: istore_2
    //   491: goto -20 -> 471
    //   494: astore_1
    //   495: invokestatic 81	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   498: ifeq +13 -> 511
    //   501: getstatic 19	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   504: iconst_4
    //   505: ldc_w 262
    //   508: invokestatic 237	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: iconst_1
    //   512: ireturn
    //   513: astore 14
    //   515: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +50 -> 568
    //   521: getstatic 19	com/tencent/mobileqq/webviewplugin/WebViewPluginEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   524: iconst_2
    //   525: new 83	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 292
    //   535: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 13
    //   540: invokevirtual 115	java/lang/Object:getClass	()Ljava/lang/Class;
    //   543: invokevirtual 17	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   546: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc 92
    //   551: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 14
    //   556: invokevirtual 95	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   559: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 237	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: iload_3
    //   569: iconst_1
    //   570: iadd
    //   571: istore_3
    //   572: goto -200 -> 372
    //   575: iload_2
    //   576: ifeq +46 -> 622
    //   579: lload 5
    //   581: ldc2_w 238
    //   584: lcmp
    //   585: ifeq +35 -> 620
    //   588: aload 10
    //   590: new 83	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   597: ldc_w 294
    //   600: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: lload 5
    //   605: invokevirtual 297	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: ldc_w 299
    //   611: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 304	com/tencent/mobileqq/activity/QQBrowserActivity:c	(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)V
    //   620: iconst_1
    //   621: ireturn
    //   622: aconst_null
    //   623: astore 9
    //   625: aload 9
    //   627: astore_1
    //   628: aload 8
    //   630: arraylength
    //   631: ifle +37 -> 668
    //   634: aload 9
    //   636: astore_1
    //   637: aload 8
    //   639: iconst_0
    //   640: aaload
    //   641: ldc_w 306
    //   644: invokevirtual 224	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   647: ifeq +21 -> 668
    //   650: new 308	org/json/JSONObject
    //   653: dup
    //   654: aload 8
    //   656: iconst_0
    //   657: aaload
    //   658: invokespecial 311	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   661: ldc_w 313
    //   664: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   667: astore_1
    //   668: aload_1
    //   669: astore 8
    //   671: aload_1
    //   672: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   675: ifeq +22 -> 697
    //   678: aload_1
    //   679: astore 8
    //   681: lload 5
    //   683: ldc2_w 238
    //   686: lcmp
    //   687: ifeq +10 -> 697
    //   690: lload 5
    //   692: invokestatic 319	java/lang/Long:toString	(J)Ljava/lang/String;
    //   695: astore 8
    //   697: aload 8
    //   699: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   702: ifne -82 -> 620
    //   705: aload 10
    //   707: aload 8
    //   709: iconst_1
    //   710: anewarray 164	java/lang/String
    //   713: dup
    //   714: iconst_0
    //   715: ldc_w 321
    //   718: aastore
    //   719: invokestatic 324	com/tencent/mobileqq/activity/QQBrowserActivity:a	(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;[Ljava/lang/String;)V
    //   722: goto -102 -> 620
    //   725: aload 12
    //   727: invokevirtual 326	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	()V
    //   730: goto -110 -> 620
    //   733: iconst_0
    //   734: ireturn
    //   735: astore_1
    //   736: aload 9
    //   738: astore_1
    //   739: goto -71 -> 668
    //   742: iconst_1
    //   743: istore_2
    //   744: goto -492 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	this	WebViewPluginEngine
    //   0	747	1	paramString	String
    //   119	625	2	i	int
    //   158	414	3	j	int
    //   177	19	4	k	int
    //   85	606	5	l	long
    //   418	3	7	bool	boolean
    //   103	605	8	localObject1	Object
    //   151	586	9	arrayOfString	String[]
    //   4	702	10	localWebView	WebView
    //   80	330	11	str	String
    //   50	676	12	localObject2	Object
    //   316	223	13	localObject3	Object
    //   513	42	14	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   112	120	210	java/lang/NumberFormatException
    //   433	442	494	java/lang/Exception
    //   404	420	513	java/lang/Exception
    //   650	668	735	org/json/JSONException
  }
  
  public boolean c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {}
    while ((paramString == null) || (!paramString.startsWith("mqqopen://"))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */