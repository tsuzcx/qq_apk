package com.tencent.mobileqq.jsp;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.smtt.sdk.CookieManager;
import dwj;
import java.util.Map;

public class DataApiPlugin
  extends WebViewPlugin
{
  public static final String a;
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  public Client.onRemoteRespObserver a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  
  static
  {
    jdField_a_of_type_JavaLangString = DataApiPlugin.class.getSimpleName();
  }
  
  public DataApiPlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new dwj(this);
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    return false;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 38
    //   2: aload_3
    //   3: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +1883 -> 1889
    //   9: ldc 46
    //   11: aload 4
    //   13: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifeq +440 -> 456
    //   19: aload 5
    //   21: arraylength
    //   22: iconst_1
    //   23: if_icmpne +433 -> 456
    //   26: new 48	org/json/JSONObject
    //   29: dup
    //   30: aload 5
    //   32: iconst_0
    //   33: aaload
    //   34: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: ldc 53
    //   39: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   47: invokevirtual 66	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   50: invokevirtual 71	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +1843 -> 1898
    //   58: aload_1
    //   59: ldc 73
    //   61: invokevirtual 77	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +1834 -> 1898
    //   67: aload_1
    //   68: invokestatic 82	com/tencent/biz/common/offline/HtmlOffline:e	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +16 -> 92
    //   79: aload_0
    //   80: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   83: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   86: invokevirtual 97	com/tencent/common/app/AppInterface:isLogin	()Z
    //   89: ifne +26 -> 115
    //   92: aload_2
    //   93: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifne +19 -> 115
    //   99: aload_0
    //   100: aload_2
    //   101: iconst_1
    //   102: anewarray 40	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: ldc 99
    //   109: aastore
    //   110: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   113: iconst_1
    //   114: ireturn
    //   115: aload_0
    //   116: getfield 105	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   119: ifnonnull +10 -> 129
    //   122: aload_0
    //   123: invokestatic 110	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   126: putfield 105	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   129: aload_0
    //   130: getfield 105	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   133: aload_1
    //   134: invokevirtual 112	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifne +1776 -> 1916
    //   143: iconst_1
    //   144: istore 6
    //   146: aload_0
    //   147: getfield 105	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   150: aload_1
    //   151: invokevirtual 114	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   154: istore 9
    //   156: aload_0
    //   157: getfield 105	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   160: aload_1
    //   161: invokevirtual 117	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;)Z
    //   164: istore 10
    //   166: iload 6
    //   168: ifne +13 -> 181
    //   171: iload 9
    //   173: ifne +8 -> 181
    //   176: iload 10
    //   178: ifeq +246 -> 424
    //   181: aload_0
    //   182: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   185: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   188: iconst_2
    //   189: invokevirtual 121	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   192: checkcast 123	mqq/manager/TicketManager
    //   195: astore 5
    //   197: aload_0
    //   198: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   201: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   204: invokevirtual 126	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   207: astore 11
    //   209: new 48	org/json/JSONObject
    //   212: dup
    //   213: invokespecial 127	org/json/JSONObject:<init>	()V
    //   216: astore_3
    //   217: aload_3
    //   218: ldc 129
    //   220: aload 11
    //   222: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   225: pop
    //   226: iload 6
    //   228: ifeq +1673 -> 1901
    //   231: aload_3
    //   232: ldc 135
    //   234: aload 5
    //   236: aload 11
    //   238: invokeinterface 138 2 0
    //   243: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: goto +1654 -> 1901
    //   250: aload_1
    //   251: invokestatic 142	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 4
    //   256: aload_0
    //   257: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   260: ifnonnull +18 -> 278
    //   263: aload_0
    //   264: invokestatic 150	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   267: putfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   270: aload_0
    //   271: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   274: iconst_1
    //   275: invokevirtual 154	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   278: iload 9
    //   280: ifeq +58 -> 338
    //   283: aload 5
    //   285: aload 11
    //   287: invokeinterface 157 2 0
    //   292: astore 12
    //   294: aload_3
    //   295: ldc 159
    //   297: aload 12
    //   299: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 12
    //   305: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifne +30 -> 338
    //   311: aload_0
    //   312: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   315: aload_1
    //   316: ldc 161
    //   318: iconst_2
    //   319: anewarray 163	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload 12
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: aload 4
    //   331: aastore
    //   332: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   335: invokevirtual 171	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: iload 10
    //   340: ifeq +58 -> 398
    //   343: aload 5
    //   345: aload 11
    //   347: invokeinterface 174 2 0
    //   352: astore 5
    //   354: aload_3
    //   355: ldc 176
    //   357: aload 5
    //   359: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   362: pop
    //   363: aload 5
    //   365: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifne +30 -> 398
    //   371: aload_0
    //   372: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   375: aload_1
    //   376: ldc 178
    //   378: iconst_2
    //   379: anewarray 163	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: aload 5
    //   386: aastore
    //   387: dup
    //   388: iconst_1
    //   389: aload 4
    //   391: aastore
    //   392: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   395: invokevirtual 171	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_2
    //   399: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   402: ifne +1512 -> 1914
    //   405: aload_0
    //   406: aload_2
    //   407: iconst_1
    //   408: anewarray 40	java/lang/String
    //   411: dup
    //   412: iconst_0
    //   413: aload_3
    //   414: invokevirtual 181	org/json/JSONObject:toString	()Ljava/lang/String;
    //   417: aastore
    //   418: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   421: goto +1493 -> 1914
    //   424: aload_2
    //   425: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   428: ifne +1486 -> 1914
    //   431: aload_0
    //   432: aload_2
    //   433: iconst_1
    //   434: anewarray 40	java/lang/String
    //   437: dup
    //   438: iconst_0
    //   439: ldc 99
    //   441: aastore
    //   442: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   445: goto +1469 -> 1914
    //   448: astore_1
    //   449: aload_1
    //   450: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   453: goto +1461 -> 1914
    //   456: ldc 186
    //   458: aload 4
    //   460: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   463: ifeq +101 -> 564
    //   466: new 48	org/json/JSONObject
    //   469: dup
    //   470: aload 5
    //   472: iconst_0
    //   473: aaload
    //   474: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   477: astore_2
    //   478: aload_2
    //   479: ldc 53
    //   481: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: astore_1
    //   485: aload_2
    //   486: ldc 129
    //   488: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore_2
    //   492: aload_2
    //   493: aload_0
    //   494: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   497: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   500: invokevirtual 126	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   503: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +1408 -> 1914
    //   509: aload_1
    //   510: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifne +1401 -> 1914
    //   516: new 188	android/os/Bundle
    //   519: dup
    //   520: invokespecial 189	android/os/Bundle:<init>	()V
    //   523: astore_3
    //   524: aload_3
    //   525: ldc 129
    //   527: aload_2
    //   528: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: ldc 194
    //   533: aload_1
    //   534: aload_0
    //   535: getfield 30	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   538: getfield 200	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   541: aload_3
    //   542: invokestatic 206	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   545: astore_1
    //   546: invokestatic 211	com/tencent/mobileqq/emosm/web/WebIPCOperator:getInstance	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   549: aload_1
    //   550: invokevirtual 215	com/tencent/mobileqq/emosm/web/WebIPCOperator:sendServiceIpcReq	(Landroid/os/Bundle;)V
    //   553: goto +1361 -> 1914
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   561: goto +1353 -> 1914
    //   564: ldc 217
    //   566: aload 4
    //   568: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   571: ifeq +295 -> 866
    //   574: aload 5
    //   576: arraylength
    //   577: iconst_1
    //   578: if_icmpne +288 -> 866
    //   581: new 48	org/json/JSONObject
    //   584: dup
    //   585: aload 5
    //   587: iconst_0
    //   588: aaload
    //   589: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   592: astore 5
    //   594: aload 5
    //   596: ldc 219
    //   598: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   601: astore_3
    //   602: aload 5
    //   604: ldc 53
    //   606: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   609: astore 4
    //   611: aload_3
    //   612: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   615: ifne +21 -> 636
    //   618: aload_3
    //   619: ldc 221
    //   621: invokevirtual 77	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   624: ifne +43 -> 667
    //   627: aload_3
    //   628: ldc 223
    //   630: invokevirtual 77	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   633: ifne +34 -> 667
    //   636: aload 4
    //   638: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   641: ifne +1281 -> 1922
    //   644: aload_0
    //   645: aload 4
    //   647: iconst_2
    //   648: anewarray 40	java/lang/String
    //   651: dup
    //   652: iconst_0
    //   653: ldc 225
    //   655: aastore
    //   656: dup
    //   657: iconst_1
    //   658: ldc 227
    //   660: aastore
    //   661: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   664: goto +1258 -> 1922
    //   667: aconst_null
    //   668: astore_1
    //   669: aload 5
    //   671: ldc 229
    //   673: invokevirtual 233	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   676: astore 11
    //   678: aload 11
    //   680: ifnull +72 -> 752
    //   683: new 188	android/os/Bundle
    //   686: dup
    //   687: invokespecial 189	android/os/Bundle:<init>	()V
    //   690: astore_2
    //   691: aload 11
    //   693: invokevirtual 237	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   696: astore 12
    //   698: aload_2
    //   699: astore_1
    //   700: aload 12
    //   702: invokeinterface 242 1 0
    //   707: ifeq +45 -> 752
    //   710: aload 12
    //   712: invokeinterface 246 1 0
    //   717: invokestatic 250	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   720: astore_1
    //   721: aload 11
    //   723: aload_1
    //   724: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   727: astore 13
    //   729: aload 13
    //   731: ifnull -33 -> 698
    //   734: aload_2
    //   735: aload_1
    //   736: aload 13
    //   738: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: goto -43 -> 698
    //   744: astore_1
    //   745: aload_1
    //   746: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   749: goto +1165 -> 1914
    //   752: aload 5
    //   754: ldc 252
    //   756: invokevirtual 233	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   759: astore_2
    //   760: aload_2
    //   761: ifnull +98 -> 859
    //   764: ldc 254
    //   766: aload_2
    //   767: ldc_w 256
    //   770: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   773: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   776: ifeq +83 -> 859
    //   779: ldc 254
    //   781: astore_2
    //   782: new 188	android/os/Bundle
    //   785: dup
    //   786: invokespecial 189	android/os/Bundle:<init>	()V
    //   789: astore 5
    //   791: aload_0
    //   792: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   795: ifnonnull +18 -> 813
    //   798: aload_0
    //   799: invokestatic 150	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   802: putfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   805: aload_0
    //   806: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   809: iconst_1
    //   810: invokevirtual 154	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   813: aload_0
    //   814: getfield 144	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   817: aload_3
    //   818: invokevirtual 262	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   821: astore 11
    //   823: aload 11
    //   825: ifnull +13 -> 838
    //   828: aload 5
    //   830: ldc_w 264
    //   833: aload 11
    //   835: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: new 266	dwk
    //   841: dup
    //   842: aload_0
    //   843: aload_3
    //   844: aload_2
    //   845: aload_1
    //   846: aload 5
    //   848: aload 4
    //   850: invokespecial 269	dwk:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)V
    //   853: invokestatic 274	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;)V
    //   856: goto +1058 -> 1914
    //   859: ldc_w 276
    //   862: astore_2
    //   863: goto -81 -> 782
    //   866: ldc_w 278
    //   869: aload 4
    //   871: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   874: ifeq +137 -> 1011
    //   877: aload 5
    //   879: arraylength
    //   880: iconst_1
    //   881: if_icmpne +130 -> 1011
    //   884: new 48	org/json/JSONObject
    //   887: dup
    //   888: aload 5
    //   890: iconst_0
    //   891: aaload
    //   892: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   895: astore_1
    //   896: aload_1
    //   897: ldc 53
    //   899: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   902: astore_2
    //   903: aload_2
    //   904: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   907: ifne +1007 -> 1914
    //   910: ldc_w 280
    //   913: aload_1
    //   914: ldc_w 281
    //   917: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   920: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   923: ifeq +23 -> 946
    //   926: aload_0
    //   927: aload_2
    //   928: iconst_1
    //   929: anewarray 40	java/lang/String
    //   932: dup
    //   933: iconst_0
    //   934: getstatic 286	com/tencent/mobileqq/activity/QQBrowserActivity:w	I
    //   937: invokestatic 291	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   940: aastore
    //   941: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   944: iconst_1
    //   945: ireturn
    //   946: aconst_null
    //   947: astore_1
    //   948: aload_0
    //   949: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   952: invokevirtual 294	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   955: astore_3
    //   956: aload_3
    //   957: ifnull +14 -> 971
    //   960: aload_3
    //   961: invokevirtual 300	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   964: ldc_w 302
    //   967: invokevirtual 307	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   970: astore_1
    //   971: aload_1
    //   972: ifnonnull +31 -> 1003
    //   975: ldc_w 309
    //   978: astore_1
    //   979: aload_0
    //   980: aload_2
    //   981: iconst_1
    //   982: anewarray 40	java/lang/String
    //   985: dup
    //   986: iconst_0
    //   987: aload_1
    //   988: aastore
    //   989: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   992: goto +922 -> 1914
    //   995: astore_1
    //   996: aload_1
    //   997: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   1000: goto +914 -> 1914
    //   1003: aload_1
    //   1004: invokestatic 312	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1007: astore_1
    //   1008: goto -29 -> 979
    //   1011: ldc_w 314
    //   1014: aload 4
    //   1016: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1019: ifeq +126 -> 1145
    //   1022: aload 5
    //   1024: arraylength
    //   1025: iconst_1
    //   1026: if_icmpne +119 -> 1145
    //   1029: new 48	org/json/JSONObject
    //   1032: dup
    //   1033: aload 5
    //   1035: iconst_0
    //   1036: aaload
    //   1037: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1040: astore_1
    //   1041: aload_1
    //   1042: ldc_w 316
    //   1045: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1048: astore_2
    //   1049: aload_1
    //   1050: ldc 53
    //   1052: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1055: astore_1
    //   1056: aload_2
    //   1057: ifnonnull +838 -> 1895
    //   1060: ldc_w 309
    //   1063: astore_2
    //   1064: invokestatic 322	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   1067: ldc_w 324
    //   1070: invokevirtual 330	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1073: checkcast 332	android/text/ClipboardManager
    //   1076: astore_3
    //   1077: aload_3
    //   1078: ifnull +32 -> 1110
    //   1081: aload_3
    //   1082: aload_2
    //   1083: invokevirtual 336	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   1086: aload_1
    //   1087: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1090: ifne +18 -> 1108
    //   1093: aload_0
    //   1094: aload_1
    //   1095: iconst_1
    //   1096: anewarray 40	java/lang/String
    //   1099: dup
    //   1100: iconst_0
    //   1101: ldc_w 338
    //   1104: aastore
    //   1105: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1108: iconst_1
    //   1109: ireturn
    //   1110: aload_1
    //   1111: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1114: ifne +800 -> 1914
    //   1117: aload_0
    //   1118: aload_1
    //   1119: iconst_1
    //   1120: anewarray 40	java/lang/String
    //   1123: dup
    //   1124: iconst_0
    //   1125: ldc_w 340
    //   1128: aastore
    //   1129: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1132: goto +782 -> 1914
    //   1135: astore_2
    //   1136: aconst_null
    //   1137: astore_1
    //   1138: aload_2
    //   1139: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   1142: goto -32 -> 1110
    //   1145: ldc_w 342
    //   1148: aload 4
    //   1150: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1153: ifeq +93 -> 1246
    //   1156: aload 5
    //   1158: arraylength
    //   1159: iconst_1
    //   1160: if_icmpne +86 -> 1246
    //   1163: new 48	org/json/JSONObject
    //   1166: dup
    //   1167: aload 5
    //   1169: iconst_0
    //   1170: aaload
    //   1171: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1174: ldc 53
    //   1176: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1179: astore_2
    //   1180: aload_2
    //   1181: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1184: ifne +730 -> 1914
    //   1187: invokestatic 322	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   1190: ldc_w 324
    //   1193: invokevirtual 330	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1196: checkcast 332	android/text/ClipboardManager
    //   1199: astore_1
    //   1200: aload_1
    //   1201: ifnull +38 -> 1239
    //   1204: aload_1
    //   1205: invokevirtual 346	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   1208: invokevirtual 347	java/lang/Object:toString	()Ljava/lang/String;
    //   1211: astore_1
    //   1212: aload_0
    //   1213: aload_2
    //   1214: iconst_1
    //   1215: anewarray 40	java/lang/String
    //   1218: dup
    //   1219: iconst_0
    //   1220: aload_1
    //   1221: invokestatic 312	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1224: aastore
    //   1225: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1228: goto +686 -> 1914
    //   1231: astore_1
    //   1232: aload_1
    //   1233: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   1236: goto +678 -> 1914
    //   1239: ldc_w 309
    //   1242: astore_1
    //   1243: goto -31 -> 1212
    //   1246: ldc_w 349
    //   1249: aload 4
    //   1251: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1254: ifeq +475 -> 1729
    //   1257: aload 5
    //   1259: arraylength
    //   1260: iconst_1
    //   1261: if_icmpne +468 -> 1729
    //   1264: new 48	org/json/JSONObject
    //   1267: dup
    //   1268: aload 5
    //   1270: iconst_0
    //   1271: aaload
    //   1272: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1275: astore_1
    //   1276: aload_1
    //   1277: ldc_w 351
    //   1280: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1283: astore_3
    //   1284: aload_1
    //   1285: ldc_w 353
    //   1288: invokevirtual 356	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1291: astore_1
    //   1292: aload_0
    //   1293: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1296: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1299: astore_2
    //   1300: ldc_w 358
    //   1303: aload_3
    //   1304: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1307: ifeq +233 -> 1540
    //   1310: aload_1
    //   1311: ldc_w 360
    //   1314: ldc_w 309
    //   1317: invokevirtual 363	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1320: astore_3
    //   1321: aload_1
    //   1322: ldc_w 365
    //   1325: invokevirtual 368	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: astore 4
    //   1330: aload_1
    //   1331: ldc_w 370
    //   1334: invokevirtual 368	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1337: astore 5
    //   1339: aload_1
    //   1340: ldc_w 372
    //   1343: invokevirtual 368	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1346: astore 11
    //   1348: aload_1
    //   1349: ldc_w 374
    //   1352: ldc_w 309
    //   1355: invokevirtual 363	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1358: astore 12
    //   1360: aload_1
    //   1361: ldc_w 376
    //   1364: iconst_0
    //   1365: invokevirtual 380	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1368: istore 6
    //   1370: aload_1
    //   1371: ldc_w 382
    //   1374: iconst_1
    //   1375: invokevirtual 380	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1378: istore 7
    //   1380: aload_1
    //   1381: ldc_w 384
    //   1384: iconst_0
    //   1385: invokevirtual 380	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1388: istore 8
    //   1390: aload_1
    //   1391: ldc_w 386
    //   1394: ldc_w 309
    //   1397: invokevirtual 363	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1400: astore 13
    //   1402: aload_1
    //   1403: ldc_w 388
    //   1406: ldc_w 309
    //   1409: invokevirtual 363	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1412: astore 14
    //   1414: aload_1
    //   1415: ldc_w 390
    //   1418: ldc_w 309
    //   1421: invokevirtual 363	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1424: astore 15
    //   1426: aload_1
    //   1427: ldc_w 392
    //   1430: ldc_w 309
    //   1433: invokevirtual 363	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1436: astore 16
    //   1438: aconst_null
    //   1439: astore_1
    //   1440: aload_2
    //   1441: instanceof 394
    //   1444: ifeq +8 -> 1452
    //   1447: aload_2
    //   1448: checkcast 394	com/tencent/mobileqq/app/QQAppInterface
    //   1451: astore_1
    //   1452: aload_2
    //   1453: invokevirtual 97	com/tencent/common/app/AppInterface:isLogin	()Z
    //   1456: ifeq +54 -> 1510
    //   1459: aload_1
    //   1460: aload 4
    //   1462: aload_3
    //   1463: aload 12
    //   1465: aload 5
    //   1467: aload 11
    //   1469: iload 6
    //   1471: iload 7
    //   1473: iload 8
    //   1475: aload 13
    //   1477: aload 14
    //   1479: aload 15
    //   1481: aload 16
    //   1483: invokestatic 399	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1486: goto +428 -> 1914
    //   1489: astore_1
    //   1490: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1493: ifeq +421 -> 1914
    //   1496: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1499: iconst_2
    //   1500: aload_1
    //   1501: invokevirtual 407	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1504: invokestatic 410	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1507: goto +407 -> 1914
    //   1510: aload_1
    //   1511: aload 4
    //   1513: aload_3
    //   1514: aload 12
    //   1516: aload 5
    //   1518: aload 11
    //   1520: iload 6
    //   1522: iload 7
    //   1524: iload 8
    //   1526: aload 13
    //   1528: aload 14
    //   1530: aload 15
    //   1532: aload 16
    //   1534: invokestatic 412	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1537: goto +377 -> 1914
    //   1540: ldc_w 414
    //   1543: aload_3
    //   1544: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1547: ifeq +163 -> 1710
    //   1550: aload_1
    //   1551: ldc_w 416
    //   1554: invokevirtual 368	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1557: astore_3
    //   1558: aload_1
    //   1559: ldc_w 418
    //   1562: iconst_1
    //   1563: invokevirtual 422	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1566: istore 9
    //   1568: aload_1
    //   1569: ldc_w 424
    //   1572: iconst_1
    //   1573: invokevirtual 422	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1576: istore 10
    //   1578: aload_1
    //   1579: ldc_w 426
    //   1582: iconst_0
    //   1583: invokevirtual 380	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1586: istore 6
    //   1588: aload_1
    //   1589: ldc_w 428
    //   1592: iconst_0
    //   1593: invokevirtual 380	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1596: istore 7
    //   1598: new 430	java/util/HashMap
    //   1601: dup
    //   1602: invokespecial 431	java/util/HashMap:<init>	()V
    //   1605: astore 4
    //   1607: aload_1
    //   1608: ldc_w 433
    //   1611: invokevirtual 233	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1614: astore_1
    //   1615: aload_1
    //   1616: ifnull +53 -> 1669
    //   1619: aload_1
    //   1620: invokevirtual 237	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1623: astore 5
    //   1625: aload 5
    //   1627: ifnull +42 -> 1669
    //   1630: aload 5
    //   1632: invokeinterface 242 1 0
    //   1637: ifeq +32 -> 1669
    //   1640: aload 5
    //   1642: invokeinterface 246 1 0
    //   1647: checkcast 40	java/lang/String
    //   1650: astore 11
    //   1652: aload 4
    //   1654: aload 11
    //   1656: aload_1
    //   1657: aload 11
    //   1659: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1662: invokevirtual 436	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1665: pop
    //   1666: goto -41 -> 1625
    //   1669: aconst_null
    //   1670: astore_1
    //   1671: aload_2
    //   1672: invokevirtual 97	com/tencent/common/app/AppInterface:isLogin	()Z
    //   1675: ifeq +8 -> 1683
    //   1678: aload_2
    //   1679: invokevirtual 126	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1682: astore_1
    //   1683: aconst_null
    //   1684: invokestatic 441	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1687: aload_1
    //   1688: aload_3
    //   1689: iload 10
    //   1691: iload 6
    //   1693: i2l
    //   1694: iload 7
    //   1696: i2l
    //   1697: aload 4
    //   1699: ldc_w 309
    //   1702: iload 9
    //   1704: invokevirtual 444	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1707: goto +207 -> 1914
    //   1710: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1713: ifeq +201 -> 1914
    //   1716: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1719: iconst_2
    //   1720: ldc_w 446
    //   1723: invokestatic 410	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1726: goto +188 -> 1914
    //   1729: ldc_w 448
    //   1732: aload 4
    //   1734: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1737: ifeq +177 -> 1914
    //   1740: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1743: ifeq +13 -> 1756
    //   1746: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1749: iconst_2
    //   1750: ldc_w 448
    //   1753: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1756: new 48	org/json/JSONObject
    //   1759: dup
    //   1760: aload 5
    //   1762: iconst_0
    //   1763: aaload
    //   1764: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1767: ldc 53
    //   1769: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1772: astore_1
    //   1773: aload_1
    //   1774: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1777: ifne +93 -> 1870
    //   1780: new 188	android/os/Bundle
    //   1783: dup
    //   1784: invokespecial 189	android/os/Bundle:<init>	()V
    //   1787: astore_2
    //   1788: aload_2
    //   1789: ldc 129
    //   1791: aload_0
    //   1792: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1795: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1798: invokevirtual 126	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1801: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1804: ldc_w 453
    //   1807: aload_1
    //   1808: aload_0
    //   1809: getfield 30	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1812: getfield 200	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1815: aload_2
    //   1816: invokestatic 206	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1819: astore_1
    //   1820: invokestatic 211	com/tencent/mobileqq/emosm/web/WebIPCOperator:getInstance	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   1823: aload_1
    //   1824: invokevirtual 215	com/tencent/mobileqq/emosm/web/WebIPCOperator:sendServiceIpcReq	(Landroid/os/Bundle;)V
    //   1827: goto +87 -> 1914
    //   1830: astore_1
    //   1831: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1834: ifeq +80 -> 1914
    //   1837: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1840: iconst_2
    //   1841: new 455	java/lang/StringBuilder
    //   1844: dup
    //   1845: invokespecial 456	java/lang/StringBuilder:<init>	()V
    //   1848: ldc_w 458
    //   1851: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: aload_1
    //   1855: invokevirtual 407	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1858: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1864: invokestatic 410	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1867: goto +47 -> 1914
    //   1870: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1873: ifeq +41 -> 1914
    //   1876: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1879: iconst_2
    //   1880: ldc_w 465
    //   1883: invokestatic 451	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1886: goto +28 -> 1914
    //   1889: iconst_0
    //   1890: ireturn
    //   1891: astore_2
    //   1892: goto -754 -> 1138
    //   1895: goto -831 -> 1064
    //   1898: goto -1826 -> 72
    //   1901: iload 9
    //   1903: ifne -1653 -> 250
    //   1906: iload 10
    //   1908: ifeq -1510 -> 398
    //   1911: goto -1661 -> 250
    //   1914: iconst_1
    //   1915: ireturn
    //   1916: iconst_0
    //   1917: istore 6
    //   1919: goto -1773 -> 146
    //   1922: iconst_1
    //   1923: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1924	0	this	DataApiPlugin
    //   0	1924	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	1924	2	paramString1	String
    //   0	1924	3	paramString2	String
    //   0	1924	4	paramString3	String
    //   0	1924	5	paramVarArgs	String[]
    //   144	1774	6	i	int
    //   1378	317	7	j	int
    //   1388	137	8	k	int
    //   154	1748	9	bool1	boolean
    //   164	1743	10	bool2	boolean
    //   207	1451	11	localObject1	java.lang.Object
    //   292	1223	12	localObject2	java.lang.Object
    //   727	800	13	str1	String
    //   1412	117	14	str2	String
    //   1424	107	15	str3	String
    //   1436	97	16	str4	String
    // Exception table:
    //   from	to	target	type
    //   26	54	448	org/json/JSONException
    //   58	72	448	org/json/JSONException
    //   72	92	448	org/json/JSONException
    //   92	113	448	org/json/JSONException
    //   115	129	448	org/json/JSONException
    //   129	143	448	org/json/JSONException
    //   146	166	448	org/json/JSONException
    //   181	226	448	org/json/JSONException
    //   231	247	448	org/json/JSONException
    //   250	278	448	org/json/JSONException
    //   283	338	448	org/json/JSONException
    //   343	398	448	org/json/JSONException
    //   398	421	448	org/json/JSONException
    //   424	445	448	org/json/JSONException
    //   466	553	556	org/json/JSONException
    //   581	636	744	org/json/JSONException
    //   636	664	744	org/json/JSONException
    //   669	678	744	org/json/JSONException
    //   683	698	744	org/json/JSONException
    //   700	729	744	org/json/JSONException
    //   734	741	744	org/json/JSONException
    //   752	760	744	org/json/JSONException
    //   764	779	744	org/json/JSONException
    //   782	813	744	org/json/JSONException
    //   813	823	744	org/json/JSONException
    //   828	838	744	org/json/JSONException
    //   838	856	744	org/json/JSONException
    //   884	944	995	org/json/JSONException
    //   948	956	995	org/json/JSONException
    //   960	971	995	org/json/JSONException
    //   979	992	995	org/json/JSONException
    //   1003	1008	995	org/json/JSONException
    //   1029	1056	1135	org/json/JSONException
    //   1163	1200	1231	org/json/JSONException
    //   1204	1212	1231	org/json/JSONException
    //   1212	1228	1231	org/json/JSONException
    //   1264	1438	1489	org/json/JSONException
    //   1440	1452	1489	org/json/JSONException
    //   1452	1486	1489	org/json/JSONException
    //   1510	1537	1489	org/json/JSONException
    //   1540	1615	1489	org/json/JSONException
    //   1619	1625	1489	org/json/JSONException
    //   1630	1666	1489	org/json/JSONException
    //   1671	1683	1489	org/json/JSONException
    //   1683	1707	1489	org/json/JSONException
    //   1710	1726	1489	org/json/JSONException
    //   1756	1827	1830	org/json/JSONException
    //   1870	1886	1830	org/json/JSONException
    //   1064	1077	1891	org/json/JSONException
    //   1081	1108	1891	org/json/JSONException
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.getInstance().registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.getInstance().unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin
 * JD-Core Version:    0.7.0.1
 */