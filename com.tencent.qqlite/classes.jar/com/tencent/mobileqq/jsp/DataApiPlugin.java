package com.tencent.mobileqq.jsp;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.smtt.sdk.CookieManager;
import dxm;
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
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new dxm(this);
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
    //   6: ifeq +1885 -> 1891
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
    //   55: ifnull +1845 -> 1900
    //   58: aload_1
    //   59: ldc 73
    //   61: invokevirtual 77	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +1836 -> 1900
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
    //   140: ifne +1778 -> 1918
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
    //   228: ifeq +1675 -> 1903
    //   231: aload_3
    //   232: ldc 135
    //   234: aload 5
    //   236: aload 11
    //   238: invokeinterface 138 2 0
    //   243: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: goto +1656 -> 1903
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
    //   402: ifne +1514 -> 1916
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
    //   421: goto +1495 -> 1916
    //   424: aload_2
    //   425: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   428: ifne +1488 -> 1916
    //   431: aload_0
    //   432: aload_2
    //   433: iconst_1
    //   434: anewarray 40	java/lang/String
    //   437: dup
    //   438: iconst_0
    //   439: ldc 99
    //   441: aastore
    //   442: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   445: goto +1471 -> 1916
    //   448: astore_1
    //   449: aload_1
    //   450: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   453: goto +1463 -> 1916
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
    //   506: ifeq +1410 -> 1916
    //   509: aload_1
    //   510: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifne +1403 -> 1916
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
    //   553: goto +1363 -> 1916
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   561: goto +1355 -> 1916
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
    //   641: ifne +1283 -> 1924
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
    //   664: goto +1260 -> 1924
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
    //   749: goto +1167 -> 1916
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
    //   838: new 266	dxn
    //   841: dup
    //   842: aload_0
    //   843: aload_3
    //   844: aload_2
    //   845: aload_1
    //   846: aload 5
    //   848: aload 4
    //   850: invokespecial 269	dxn:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)V
    //   853: invokestatic 274	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;)V
    //   856: goto +1060 -> 1916
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
    //   907: ifne +1009 -> 1916
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
    //   992: goto +924 -> 1916
    //   995: astore_1
    //   996: aload_1
    //   997: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   1000: goto +916 -> 1916
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
    //   1057: ifnonnull +840 -> 1897
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
    //   1114: ifne +802 -> 1916
    //   1117: aload_0
    //   1118: aload_1
    //   1119: iconst_1
    //   1120: anewarray 40	java/lang/String
    //   1123: dup
    //   1124: iconst_0
    //   1125: ldc_w 340
    //   1128: aastore
    //   1129: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1132: goto +784 -> 1916
    //   1135: astore_2
    //   1136: aconst_null
    //   1137: astore_1
    //   1138: aload_2
    //   1139: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   1142: goto -32 -> 1110
    //   1145: ldc_w 342
    //   1148: aload 4
    //   1150: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1153: ifeq +95 -> 1248
    //   1156: aload 5
    //   1158: arraylength
    //   1159: iconst_1
    //   1160: if_icmpne +88 -> 1248
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
    //   1184: ifne +732 -> 1916
    //   1187: invokestatic 322	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   1190: ldc_w 324
    //   1193: invokevirtual 330	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1196: checkcast 332	android/text/ClipboardManager
    //   1199: astore_1
    //   1200: aload_1
    //   1201: ifnull +40 -> 1241
    //   1204: aload_1
    //   1205: invokevirtual 346	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   1208: invokeinterface 349 1 0
    //   1213: astore_1
    //   1214: aload_0
    //   1215: aload_2
    //   1216: iconst_1
    //   1217: anewarray 40	java/lang/String
    //   1220: dup
    //   1221: iconst_0
    //   1222: aload_1
    //   1223: invokestatic 312	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1226: aastore
    //   1227: invokevirtual 103	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1230: goto +686 -> 1916
    //   1233: astore_1
    //   1234: aload_1
    //   1235: invokevirtual 184	org/json/JSONException:printStackTrace	()V
    //   1238: goto +678 -> 1916
    //   1241: ldc_w 309
    //   1244: astore_1
    //   1245: goto -31 -> 1214
    //   1248: ldc_w 351
    //   1251: aload 4
    //   1253: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1256: ifeq +475 -> 1731
    //   1259: aload 5
    //   1261: arraylength
    //   1262: iconst_1
    //   1263: if_icmpne +468 -> 1731
    //   1266: new 48	org/json/JSONObject
    //   1269: dup
    //   1270: aload 5
    //   1272: iconst_0
    //   1273: aaload
    //   1274: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1277: astore_1
    //   1278: aload_1
    //   1279: ldc_w 353
    //   1282: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1285: astore_3
    //   1286: aload_1
    //   1287: ldc_w 355
    //   1290: invokevirtual 358	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1293: astore_1
    //   1294: aload_0
    //   1295: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1298: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1301: astore_2
    //   1302: ldc_w 360
    //   1305: aload_3
    //   1306: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1309: ifeq +233 -> 1542
    //   1312: aload_1
    //   1313: ldc_w 362
    //   1316: ldc_w 309
    //   1319: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1322: astore_3
    //   1323: aload_1
    //   1324: ldc_w 367
    //   1327: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1330: astore 4
    //   1332: aload_1
    //   1333: ldc_w 372
    //   1336: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1339: astore 5
    //   1341: aload_1
    //   1342: ldc_w 374
    //   1345: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1348: astore 11
    //   1350: aload_1
    //   1351: ldc_w 376
    //   1354: ldc_w 309
    //   1357: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1360: astore 12
    //   1362: aload_1
    //   1363: ldc_w 378
    //   1366: iconst_0
    //   1367: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1370: istore 6
    //   1372: aload_1
    //   1373: ldc_w 384
    //   1376: iconst_1
    //   1377: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1380: istore 7
    //   1382: aload_1
    //   1383: ldc_w 386
    //   1386: iconst_0
    //   1387: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1390: istore 8
    //   1392: aload_1
    //   1393: ldc_w 388
    //   1396: ldc_w 309
    //   1399: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1402: astore 13
    //   1404: aload_1
    //   1405: ldc_w 390
    //   1408: ldc_w 309
    //   1411: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1414: astore 14
    //   1416: aload_1
    //   1417: ldc_w 392
    //   1420: ldc_w 309
    //   1423: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1426: astore 15
    //   1428: aload_1
    //   1429: ldc_w 394
    //   1432: ldc_w 309
    //   1435: invokevirtual 365	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1438: astore 16
    //   1440: aconst_null
    //   1441: astore_1
    //   1442: aload_2
    //   1443: instanceof 396
    //   1446: ifeq +8 -> 1454
    //   1449: aload_2
    //   1450: checkcast 396	com/tencent/mobileqq/app/QQAppInterface
    //   1453: astore_1
    //   1454: aload_2
    //   1455: invokevirtual 97	com/tencent/common/app/AppInterface:isLogin	()Z
    //   1458: ifeq +54 -> 1512
    //   1461: aload_1
    //   1462: aload 4
    //   1464: aload_3
    //   1465: aload 12
    //   1467: aload 5
    //   1469: aload 11
    //   1471: iload 6
    //   1473: iload 7
    //   1475: iload 8
    //   1477: aload 13
    //   1479: aload 14
    //   1481: aload 15
    //   1483: aload 16
    //   1485: invokestatic 401	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1488: goto +428 -> 1916
    //   1491: astore_1
    //   1492: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1495: ifeq +421 -> 1916
    //   1498: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1501: iconst_2
    //   1502: aload_1
    //   1503: invokevirtual 409	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1506: invokestatic 412	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1509: goto +407 -> 1916
    //   1512: aload_1
    //   1513: aload 4
    //   1515: aload_3
    //   1516: aload 12
    //   1518: aload 5
    //   1520: aload 11
    //   1522: iload 6
    //   1524: iload 7
    //   1526: iload 8
    //   1528: aload 13
    //   1530: aload 14
    //   1532: aload 15
    //   1534: aload 16
    //   1536: invokestatic 414	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1539: goto +377 -> 1916
    //   1542: ldc_w 416
    //   1545: aload_3
    //   1546: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1549: ifeq +163 -> 1712
    //   1552: aload_1
    //   1553: ldc_w 418
    //   1556: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: astore_3
    //   1560: aload_1
    //   1561: ldc_w 420
    //   1564: iconst_1
    //   1565: invokevirtual 424	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1568: istore 9
    //   1570: aload_1
    //   1571: ldc_w 426
    //   1574: iconst_1
    //   1575: invokevirtual 424	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1578: istore 10
    //   1580: aload_1
    //   1581: ldc_w 428
    //   1584: iconst_0
    //   1585: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1588: istore 6
    //   1590: aload_1
    //   1591: ldc_w 430
    //   1594: iconst_0
    //   1595: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1598: istore 7
    //   1600: new 432	java/util/HashMap
    //   1603: dup
    //   1604: invokespecial 433	java/util/HashMap:<init>	()V
    //   1607: astore 4
    //   1609: aload_1
    //   1610: ldc_w 435
    //   1613: invokevirtual 233	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1616: astore_1
    //   1617: aload_1
    //   1618: ifnull +53 -> 1671
    //   1621: aload_1
    //   1622: invokevirtual 237	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1625: astore 5
    //   1627: aload 5
    //   1629: ifnull +42 -> 1671
    //   1632: aload 5
    //   1634: invokeinterface 242 1 0
    //   1639: ifeq +32 -> 1671
    //   1642: aload 5
    //   1644: invokeinterface 246 1 0
    //   1649: checkcast 40	java/lang/String
    //   1652: astore 11
    //   1654: aload 4
    //   1656: aload 11
    //   1658: aload_1
    //   1659: aload 11
    //   1661: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1664: invokevirtual 438	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1667: pop
    //   1668: goto -41 -> 1627
    //   1671: aconst_null
    //   1672: astore_1
    //   1673: aload_2
    //   1674: invokevirtual 97	com/tencent/common/app/AppInterface:isLogin	()Z
    //   1677: ifeq +8 -> 1685
    //   1680: aload_2
    //   1681: invokevirtual 126	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1684: astore_1
    //   1685: aconst_null
    //   1686: invokestatic 443	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1689: aload_1
    //   1690: aload_3
    //   1691: iload 10
    //   1693: iload 6
    //   1695: i2l
    //   1696: iload 7
    //   1698: i2l
    //   1699: aload 4
    //   1701: ldc_w 309
    //   1704: iload 9
    //   1706: invokevirtual 446	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1709: goto +207 -> 1916
    //   1712: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1715: ifeq +201 -> 1916
    //   1718: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1721: iconst_2
    //   1722: ldc_w 448
    //   1725: invokestatic 412	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1728: goto +188 -> 1916
    //   1731: ldc_w 450
    //   1734: aload 4
    //   1736: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1739: ifeq +177 -> 1916
    //   1742: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1745: ifeq +13 -> 1758
    //   1748: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1751: iconst_2
    //   1752: ldc_w 450
    //   1755: invokestatic 453	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1758: new 48	org/json/JSONObject
    //   1761: dup
    //   1762: aload 5
    //   1764: iconst_0
    //   1765: aaload
    //   1766: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1769: ldc 53
    //   1771: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1774: astore_1
    //   1775: aload_1
    //   1776: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1779: ifne +93 -> 1872
    //   1782: new 188	android/os/Bundle
    //   1785: dup
    //   1786: invokespecial 189	android/os/Bundle:<init>	()V
    //   1789: astore_2
    //   1790: aload_2
    //   1791: ldc 129
    //   1793: aload_0
    //   1794: getfield 61	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1797: invokevirtual 91	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1800: invokevirtual 126	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1803: invokevirtual 192	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1806: ldc_w 455
    //   1809: aload_1
    //   1810: aload_0
    //   1811: getfield 30	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1814: getfield 200	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1817: aload_2
    //   1818: invokestatic 206	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1821: astore_1
    //   1822: invokestatic 211	com/tencent/mobileqq/emosm/web/WebIPCOperator:getInstance	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   1825: aload_1
    //   1826: invokevirtual 215	com/tencent/mobileqq/emosm/web/WebIPCOperator:sendServiceIpcReq	(Landroid/os/Bundle;)V
    //   1829: goto +87 -> 1916
    //   1832: astore_1
    //   1833: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1836: ifeq +80 -> 1916
    //   1839: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1842: iconst_2
    //   1843: new 457	java/lang/StringBuilder
    //   1846: dup
    //   1847: invokespecial 458	java/lang/StringBuilder:<init>	()V
    //   1850: ldc_w 460
    //   1853: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: aload_1
    //   1857: invokevirtual 409	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1860: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: invokevirtual 465	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokestatic 412	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1869: goto +47 -> 1916
    //   1872: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1875: ifeq +41 -> 1916
    //   1878: getstatic 19	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1881: iconst_2
    //   1882: ldc_w 467
    //   1885: invokestatic 453	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1888: goto +28 -> 1916
    //   1891: iconst_0
    //   1892: ireturn
    //   1893: astore_2
    //   1894: goto -756 -> 1138
    //   1897: goto -833 -> 1064
    //   1900: goto -1828 -> 72
    //   1903: iload 9
    //   1905: ifne -1655 -> 250
    //   1908: iload 10
    //   1910: ifeq -1512 -> 398
    //   1913: goto -1663 -> 250
    //   1916: iconst_1
    //   1917: ireturn
    //   1918: iconst_0
    //   1919: istore 6
    //   1921: goto -1775 -> 146
    //   1924: iconst_1
    //   1925: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1926	0	this	DataApiPlugin
    //   0	1926	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	1926	2	paramString1	String
    //   0	1926	3	paramString2	String
    //   0	1926	4	paramString3	String
    //   0	1926	5	paramVarArgs	String[]
    //   144	1776	6	i	int
    //   1380	317	7	j	int
    //   1390	137	8	k	int
    //   154	1750	9	bool1	boolean
    //   164	1745	10	bool2	boolean
    //   207	1453	11	localObject1	java.lang.Object
    //   292	1225	12	localObject2	java.lang.Object
    //   727	802	13	str1	String
    //   1414	117	14	str2	String
    //   1426	107	15	str3	String
    //   1438	97	16	str4	String
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
    //   1163	1200	1233	org/json/JSONException
    //   1204	1214	1233	org/json/JSONException
    //   1214	1230	1233	org/json/JSONException
    //   1266	1440	1491	org/json/JSONException
    //   1442	1454	1491	org/json/JSONException
    //   1454	1488	1491	org/json/JSONException
    //   1512	1539	1491	org/json/JSONException
    //   1542	1617	1491	org/json/JSONException
    //   1621	1627	1491	org/json/JSONException
    //   1632	1668	1491	org/json/JSONException
    //   1673	1685	1491	org/json/JSONException
    //   1685	1709	1491	org/json/JSONException
    //   1712	1728	1491	org/json/JSONException
    //   1758	1829	1832	org/json/JSONException
    //   1872	1888	1832	org/json/JSONException
    //   1064	1077	1893	org/json/JSONException
    //   1081	1108	1893	org/json/JSONException
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