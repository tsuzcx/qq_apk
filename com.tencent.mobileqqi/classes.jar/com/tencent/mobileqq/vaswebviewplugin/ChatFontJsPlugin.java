package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatFontJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "font";
  private static final String TAG = "ChatFontJsPlugin";
  private BrowserAppInterface browserApp;
  private HashMap mFontSize;
  private Bundle mReqBundle;
  
  protected long getPluginBusiness()
  {
    return 2147487744L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"font".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i = paramString1.indexOf("=");
    if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
      return false;
    }
    paramString1 = paramString1.substring(i + 1);
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramJsBridgeListener = URLDecoder.decode(paramString1, "UTF-8");
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatFontJsPlugin", 2, "Failed to decode json str, josn=" + paramString1);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
        if (paramJsBridgeListener == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatFontJsPlugin", 2, "Failed to parse json str,json=" + null);
          }
          paramJsBridgeListener = null;
        }
      }
    }
    try
    {
      if (paramJsBridgeListener.has("id")) {
        i = paramJsBridgeListener.getInt("id");
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        try
        {
          paramString1 = paramJsBridgeListener.getString("callback");
          if (paramString1 != null) {
            continue;
          }
          return false;
        }
        catch (JSONException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        i = 0;
        if (QLog.isColorLevel()) {
          QLog.i("ChatFontJsPlugin", 2, "Failed to parse callbackid,json=" + paramJsBridgeListener);
        }
        paramString1 = null;
        continue;
        if ("queryLocal".equals(paramString3))
        {
          queryLocal(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("setSize".equals(paramString3))
        {
          setSize(paramJsBridgeListener, paramString1);
          return true;
        }
        if ((!"queryInfo".equals(paramString3)) || (i == 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject();
          paramString2 = new JSONObject();
          paramString2.put("status", 3);
          paramString2.put("progress", 100);
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("message", "本地已存在");
          callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          paramJsBridgeListener = "queryFontInfo";
          this.mReqBundle.clear();
          this.mReqBundle.putInt("id", i);
          sendRemoteReq(DataFactory.makeIPCRequestPacket(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          return true;
          if ("setup".equals(paramString3))
          {
            paramJsBridgeListener = "setupChatFont";
            continue;
          }
          if ("startDownload".equals(paramString3))
          {
            paramJsBridgeListener = "font_startDownLoad";
            continue;
          }
          if ("stopDownload".equals(paramString3))
          {
            paramJsBridgeListener = "font_StopDownLoad";
            continue;
          }
          if ("showBlackMsgBox".equals(paramString3))
          {
            paramString2 = new JSONObject();
            try
            {
              paramJsBridgeListener = paramJsBridgeListener.getString("msg");
              QQToast.a(this.mRuntime.a(), paramJsBridgeListener, 0).b(((QQBrowserActivity)this.mRuntime.a()).d());
              callJs(paramString1, new String[] { paramString2.toString() });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("ChatFontJsPlugin", 2, "showBlackMsgBox failed: " + paramJsBridgeListener.getMessage());
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("ChatFontJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
          }
          return false;
        }
        catch (JSONException paramJsBridgeListener)
        {
          continue;
        }
        i = 0;
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    for (;;)
    {
      this.mReqBundle = new Bundle();
      this.mFontSize = new HashMap(4);
      this.mFontSize.put("small", Integer.valueOf(0));
      this.mFontSize.put("middle", Integer.valueOf(1));
      this.mFontSize.put("big", Integer.valueOf(2));
      this.mFontSize.put("bigger", Integer.valueOf(3));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ChatFontJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
      }
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatFontJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if ((i != 0) && (i == 2))
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label98:
      callJs(paramBundle, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      break label98;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("cmd");
        try
        {
          str2 = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          localJSONObject = new JSONObject();
          if (!"setupChatFont".equals(str1)) {
            break;
          }
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("message", paramBundle.getString("message"));
          callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("ChatFontJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      if ("queryFontInfo".equals(str1))
      {
        callJs(str2, new String[] { paramBundle.getString("result") });
        return;
      }
    } while (!"font_StopDownLoad".equals(str1));
    localJSONObject.put("result", 0);
    callJs(str2, new String[] { localJSONObject.toString() });
  }
  
  /* Error */
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 11
    //   11: iconst_2
    //   12: new 40	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 314
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 94	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 131	org/json/JSONObject:<init>	()V
    //   42: astore 7
    //   44: aload_0
    //   45: getfield 250	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   48: aconst_null
    //   49: invokevirtual 317	com/tencent/mobileqq/app/BrowserAppInterface:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   52: invokevirtual 323	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   55: astore_1
    //   56: aload_1
    //   57: ldc_w 325
    //   60: aload_0
    //   61: getfield 250	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   64: invokevirtual 328	com/tencent/mobileqq/app/BrowserAppInterface:getAccount	()Ljava/lang/String;
    //   67: invokevirtual 333	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   70: checkcast 325	com/tencent/mobileqq/data/ExtensionInfo
    //   73: astore 5
    //   75: aload_1
    //   76: invokevirtual 335	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   79: aload 7
    //   81: ldc 141
    //   83: iconst_0
    //   84: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload 5
    //   90: ifnonnull +98 -> 188
    //   93: aload 7
    //   95: ldc_w 337
    //   98: lconst_0
    //   99: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   102: pop
    //   103: invokestatic 346	mqq/app/MobileQQ:getContext	()Landroid/content/Context;
    //   106: ldc_w 348
    //   109: iconst_0
    //   110: invokevirtual 354	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   113: ldc_w 356
    //   116: iconst_0
    //   117: invokeinterface 359 3 0
    //   122: istore_3
    //   123: ldc_w 260
    //   126: astore_1
    //   127: aload_0
    //   128: getfield 258	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:mFontSize	Ljava/util/HashMap;
    //   131: invokevirtual 363	java/util/HashMap:keySet	()Ljava/util/Set;
    //   134: invokeinterface 369 1 0
    //   139: astore 8
    //   141: aload 8
    //   143: invokeinterface 374 1 0
    //   148: ifeq +110 -> 258
    //   151: aload 8
    //   153: invokeinterface 378 1 0
    //   158: checkcast 61	java/lang/String
    //   161: astore 5
    //   163: aload_0
    //   164: getfield 258	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:mFontSize	Ljava/util/HashMap;
    //   167: aload 5
    //   169: invokevirtual 382	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast 262	java/lang/Integer
    //   175: invokevirtual 385	java/lang/Integer:intValue	()I
    //   178: iload_3
    //   179: if_icmpne +458 -> 637
    //   182: aload 5
    //   184: astore_1
    //   185: goto +452 -> 637
    //   188: aload 7
    //   190: ldc_w 337
    //   193: aload 5
    //   195: getfield 389	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   198: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   201: pop
    //   202: goto -99 -> 103
    //   205: astore_1
    //   206: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +32 -> 241
    //   212: ldc 11
    //   214: iconst_2
    //   215: new 40	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 391
    //   225: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 230	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_0
    //   242: aload_2
    //   243: iconst_1
    //   244: anewarray 61	java/lang/String
    //   247: dup
    //   248: iconst_0
    //   249: aload_1
    //   250: invokevirtual 230	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   253: aastore
    //   254: invokevirtual 153	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   257: return
    //   258: aload 7
    //   260: ldc_w 393
    //   263: aload_1
    //   264: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: new 395	java/io/File
    //   271: dup
    //   272: getstatic 399	com/etrump/mixlayout/FontManager:a	Ljava/lang/String;
    //   275: ldc_w 401
    //   278: invokespecial 404	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: astore 8
    //   283: aload 8
    //   285: invokevirtual 407	java/io/File:exists	()Z
    //   288: istore 4
    //   290: iload 4
    //   292: ifeq +340 -> 632
    //   295: new 409	java/io/FileReader
    //   298: dup
    //   299: aload 8
    //   301: invokevirtual 412	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   304: invokespecial 413	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   307: astore 5
    //   309: aload 5
    //   311: astore_1
    //   312: sipush 4096
    //   315: newarray char
    //   317: astore 9
    //   319: aload 5
    //   321: astore_1
    //   322: new 40	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   329: astore 10
    //   331: aload 5
    //   333: astore_1
    //   334: aload 5
    //   336: aload 9
    //   338: invokevirtual 417	java/io/FileReader:read	([C)I
    //   341: istore_3
    //   342: iload_3
    //   343: ifle +149 -> 492
    //   346: aload 5
    //   348: astore_1
    //   349: aload 10
    //   351: aload 9
    //   353: iconst_0
    //   354: iload_3
    //   355: invokevirtual 420	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: goto -28 -> 331
    //   362: astore 6
    //   364: aload 5
    //   366: astore_1
    //   367: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +17 -> 387
    //   373: aload 5
    //   375: astore_1
    //   376: ldc 11
    //   378: iconst_2
    //   379: aload 6
    //   381: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   384: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload 5
    //   389: ifnull +8 -> 397
    //   392: aload 5
    //   394: invokevirtual 423	java/io/FileReader:close	()V
    //   397: aconst_null
    //   398: astore_1
    //   399: aload_1
    //   400: ifnonnull +229 -> 629
    //   403: new 425	org/json/JSONArray
    //   406: dup
    //   407: invokespecial 426	org/json/JSONArray:<init>	()V
    //   410: astore_1
    //   411: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +226 -> 640
    //   417: ldc 11
    //   419: iconst_2
    //   420: new 40	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   427: aload 8
    //   429: invokevirtual 412	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc_w 428
    //   438: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: goto +193 -> 640
    //   450: new 425	org/json/JSONArray
    //   453: dup
    //   454: invokespecial 426	org/json/JSONArray:<init>	()V
    //   457: astore 5
    //   459: iconst_0
    //   460: istore_3
    //   461: iload_3
    //   462: aload_1
    //   463: invokevirtual 429	org/json/JSONArray:length	()I
    //   466: if_icmpge +100 -> 566
    //   469: aload 5
    //   471: aload_1
    //   472: iload_3
    //   473: invokevirtual 433	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   476: ldc 104
    //   478: invokevirtual 111	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   481: invokevirtual 436	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   484: pop
    //   485: iload_3
    //   486: iconst_1
    //   487: iadd
    //   488: istore_3
    //   489: goto -28 -> 461
    //   492: aload 5
    //   494: astore_1
    //   495: aload 10
    //   497: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: astore 9
    //   502: aload 6
    //   504: astore_1
    //   505: aload 9
    //   507: ifnull +20 -> 527
    //   510: aload 5
    //   512: astore_1
    //   513: new 425	org/json/JSONArray
    //   516: dup
    //   517: aload 9
    //   519: invokespecial 437	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   522: astore 6
    //   524: aload 6
    //   526: astore_1
    //   527: aload 5
    //   529: ifnull +8 -> 537
    //   532: aload 5
    //   534: invokevirtual 423	java/io/FileReader:close	()V
    //   537: goto -138 -> 399
    //   540: astore 5
    //   542: goto -143 -> 399
    //   545: astore_1
    //   546: aconst_null
    //   547: astore_1
    //   548: goto -149 -> 399
    //   551: astore 5
    //   553: aconst_null
    //   554: astore_1
    //   555: aload_1
    //   556: ifnull +7 -> 563
    //   559: aload_1
    //   560: invokevirtual 423	java/io/FileReader:close	()V
    //   563: aload 5
    //   565: athrow
    //   566: aload 7
    //   568: ldc_w 439
    //   571: aload 5
    //   573: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   576: pop
    //   577: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +14 -> 594
    //   583: ldc 11
    //   585: iconst_2
    //   586: aload 7
    //   588: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   591: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: aload_0
    //   595: aload_2
    //   596: iconst_1
    //   597: anewarray 61	java/lang/String
    //   600: dup
    //   601: iconst_0
    //   602: aload 7
    //   604: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   607: aastore
    //   608: invokevirtual 153	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   611: return
    //   612: astore_1
    //   613: goto -50 -> 563
    //   616: astore 5
    //   618: goto -63 -> 555
    //   621: astore 6
    //   623: aconst_null
    //   624: astore 5
    //   626: goto -262 -> 364
    //   629: goto -179 -> 450
    //   632: aconst_null
    //   633: astore_1
    //   634: goto -235 -> 399
    //   637: goto -496 -> 141
    //   640: goto -190 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	ChatFontJsPlugin
    //   0	643	1	paramJSONObject	JSONObject
    //   0	643	2	paramString	String
    //   122	367	3	i	int
    //   288	3	4	bool	boolean
    //   73	460	5	localObject1	java.lang.Object
    //   540	1	5	localIOException	java.io.IOException
    //   551	21	5	localObject2	java.lang.Object
    //   616	1	5	localObject3	java.lang.Object
    //   624	1	5	localObject4	java.lang.Object
    //   1	1	6	localObject5	java.lang.Object
    //   362	141	6	localException1	Exception
    //   522	3	6	localJSONArray	org.json.JSONArray
    //   621	1	6	localException2	Exception
    //   42	561	7	localJSONObject	JSONObject
    //   139	289	8	localObject6	java.lang.Object
    //   317	201	9	localObject7	java.lang.Object
    //   329	167	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	88	205	org/json/JSONException
    //   93	103	205	org/json/JSONException
    //   103	123	205	org/json/JSONException
    //   127	141	205	org/json/JSONException
    //   141	182	205	org/json/JSONException
    //   188	202	205	org/json/JSONException
    //   258	290	205	org/json/JSONException
    //   392	397	205	org/json/JSONException
    //   403	447	205	org/json/JSONException
    //   450	459	205	org/json/JSONException
    //   461	485	205	org/json/JSONException
    //   532	537	205	org/json/JSONException
    //   559	563	205	org/json/JSONException
    //   563	566	205	org/json/JSONException
    //   566	594	205	org/json/JSONException
    //   594	611	205	org/json/JSONException
    //   312	319	362	java/lang/Exception
    //   322	331	362	java/lang/Exception
    //   334	342	362	java/lang/Exception
    //   349	359	362	java/lang/Exception
    //   495	502	362	java/lang/Exception
    //   513	524	362	java/lang/Exception
    //   532	537	540	java/io/IOException
    //   392	397	545	java/io/IOException
    //   295	309	551	finally
    //   559	563	612	java/io/IOException
    //   312	319	616	finally
    //   322	331	616	finally
    //   334	342	616	finally
    //   349	359	616	finally
    //   367	373	616	finally
    //   376	387	616	finally
    //   495	502	616	finally
    //   513	524	616	finally
    //   295	309	621	java/lang/Exception
  }
  
  public void setSize(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setSize:" + paramJSONObject);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = paramJSONObject.getString("size");
      ReportController.a(null, "CliOper", "", "", "Font_Mall", "change_" + paramJSONObject, 0, 0, "", "", "", "");
      int i;
      if (this.mFontSize.containsKey(paramJSONObject))
      {
        i = ((Integer)this.mFontSize.get(paramJSONObject)).intValue();
        localJSONObject.put("result", 0);
      }
      for (;;)
      {
        paramJSONObject = MobileQQ.getContext().getSharedPreferences("setting_text_size", 0).edit();
        paramJSONObject.putInt("chat_text_size_type", i);
        paramJSONObject.commit();
        localJSONObject.put("message", "success");
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "size illege");
        callJs(paramString, new String[] { localJSONObject.toString() });
        i = 0;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  protected boolean shouldGetBusiness()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin
 * JD-Core Version:    0.7.0.1
 */