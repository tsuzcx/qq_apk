import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class yyu
  extends WebViewPlugin
{
  public static final String a;
  protected static final int[] a;
  public static final String b;
  protected static final int[] b;
  private aphy jdField_a_of_type_Aphy = new yyz(this);
  protected bhvq a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  ymk jdField_a_of_type_Ymk = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131705952);
    jdField_b_of_type_JavaLangString = alpo.a(2131705950);
    jdField_a_of_type_ArrayOfInt = new int[] { 2131721126, 2131699402 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130843289, 2130843285 };
  }
  
  public yyu()
  {
    this.mPluginNameSpace = "hotchat";
  }
  
  public void a(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      bhvt localbhvt = new bhvt();
      localbhvt.jdField_a_of_type_Int = i;
      localbhvt.jdField_a_of_type_JavaLangString = localActivity.getString(jdField_a_of_type_ArrayOfInt[i]);
      localbhvt.c = localbhvt.jdField_a_of_type_JavaLangString;
      localbhvt.b = jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localbhvt);
      i += 1;
    }
    if (this.jdField_a_of_type_Bhvq == null) {
      this.jdField_a_of_type_Bhvq = bhvq.a(localActivity, localArrayList, new yza(this, paramString));
    }
    if (this.jdField_a_of_type_Bhvq.isShowing())
    {
      this.jdField_a_of_type_Bhvq.dismiss();
      return;
    }
    paramString = localActivity.findViewById(2131375812);
    this.jdField_a_of_type_Bhvq.showAsDropDown(paramString, paramString.getWidth() - localActivity.getResources().getDimensionPixelSize(2131298647) - localActivity.getResources().getDimensionPixelSize(2131298643), localActivity.getResources().getDimensionPixelSize(2131298644));
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: ldc 163
    //   8: iconst_2
    //   9: new 165	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   16: ldc 168
    //   18: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload 4
    //   23: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 174
    //   28: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 62
    //   46: aload_3
    //   47: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   50: ifeq +235 -> 285
    //   53: ldc 190
    //   55: aload 4
    //   57: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +159 -> 219
    //   63: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 163
    //   71: iconst_2
    //   72: new 165	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   79: ldc 190
    //   81: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload 5
    //   97: ifnull +2340 -> 2437
    //   100: aload 5
    //   102: arraylength
    //   103: ifle +2334 -> 2437
    //   106: new 201	org/json/JSONObject
    //   109: dup
    //   110: aload 5
    //   112: iconst_0
    //   113: aaload
    //   114: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: ldc 205
    //   119: invokevirtual 209	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 72	yyu:mRuntime	Lbecq;
    //   127: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +2305 -> 2437
    //   135: aload_2
    //   136: instanceof 211
    //   139: ifeq +2298 -> 2437
    //   142: aload_2
    //   143: checkcast 211	com/tencent/mobileqq/activity/NearbyActivity
    //   146: invokevirtual 214	com/tencent/mobileqq/activity/NearbyActivity:a	()Lcom/tencent/mobileqq/fragment/HotChatFragment;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +2286 -> 2437
    //   154: aload_3
    //   155: instanceof 216
    //   158: ifeq +2279 -> 2437
    //   161: aload_1
    //   162: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +14 -> 179
    //   168: aload_3
    //   169: checkcast 216	com/tencent/mobileqq/fragment/HotChatFragment
    //   172: aconst_null
    //   173: invokevirtual 225	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   176: goto +2261 -> 2437
    //   179: aload_3
    //   180: checkcast 216	com/tencent/mobileqq/fragment/HotChatFragment
    //   183: new 227	yyv
    //   186: dup
    //   187: aload_0
    //   188: aload_1
    //   189: aload_2
    //   190: invokespecial 230	yyv:<init>	(Lyyu;Ljava/lang/String;Landroid/app/Activity;)V
    //   193: invokevirtual 225	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   196: goto +2241 -> 2437
    //   199: astore_1
    //   200: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +2234 -> 2437
    //   206: ldc 163
    //   208: iconst_2
    //   209: aload_1
    //   210: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   213: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: goto +2221 -> 2437
    //   219: ldc 235
    //   221: aload 4
    //   223: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   226: ifeq +30 -> 256
    //   229: aload 5
    //   231: ifnull +23 -> 254
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +17 -> 254
    //   240: aload_0
    //   241: getfield 72	yyu:mRuntime	Lbecq;
    //   244: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   247: aload 5
    //   249: iconst_0
    //   250: aaload
    //   251: invokestatic 240	com/tencent/mobileqq/dating/NearbyTransitActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   254: iconst_1
    //   255: ireturn
    //   256: ldc 242
    //   258: aload 4
    //   260: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +24 -> 287
    //   266: aload_0
    //   267: getfield 72	yyu:mRuntime	Lbecq;
    //   270: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   273: new 244	android/content/Intent
    //   276: dup
    //   277: ldc 246
    //   279: invokespecial 247	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   282: invokevirtual 251	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   285: iconst_0
    //   286: ireturn
    //   287: ldc 253
    //   289: aload 4
    //   291: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +49 -> 343
    //   297: aload 5
    //   299: iconst_0
    //   300: aaload
    //   301: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne -19 -> 285
    //   307: new 244	android/content/Intent
    //   310: dup
    //   311: ldc 255
    //   313: invokespecial 247	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   316: astore_1
    //   317: aload_1
    //   318: ldc_w 257
    //   321: aload 5
    //   323: iconst_0
    //   324: aaload
    //   325: invokevirtual 261	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_0
    //   330: getfield 72	yyu:mRuntime	Lbecq;
    //   333: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   336: aload_1
    //   337: invokevirtual 251	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   340: goto -55 -> 285
    //   343: ldc_w 263
    //   346: aload 4
    //   348: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   351: ifeq +23 -> 374
    //   354: invokestatic 269	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   357: new 271	com/tencent/biz/webviewplugin/HotchatPlugin$2
    //   360: dup
    //   361: aload_0
    //   362: aload 5
    //   364: invokespecial 274	com/tencent/biz/webviewplugin/HotchatPlugin$2:<init>	(Lyyu;[Ljava/lang/String;)V
    //   367: invokevirtual 280	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   370: pop
    //   371: goto -86 -> 285
    //   374: ldc_w 282
    //   377: aload 4
    //   379: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   382: ifeq +146 -> 528
    //   385: aload_0
    //   386: getfield 72	yyu:mRuntime	Lbecq;
    //   389: invokevirtual 285	becq:a	()Lcom/tencent/common/app/AppInterface;
    //   392: invokevirtual 290	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   395: ldc_w 292
    //   398: iconst_0
    //   399: invokestatic 298	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   402: invokestatic 303	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: checkcast 294	java/lang/Boolean
    //   408: invokevirtual 306	java/lang/Boolean:booleanValue	()Z
    //   411: istore 12
    //   413: aconst_null
    //   414: astore_2
    //   415: aload_2
    //   416: astore_1
    //   417: aload 5
    //   419: ifnull +28 -> 447
    //   422: aload_2
    //   423: astore_1
    //   424: aload 5
    //   426: arraylength
    //   427: ifle +20 -> 447
    //   430: new 201	org/json/JSONObject
    //   433: dup
    //   434: aload 5
    //   436: iconst_0
    //   437: aaload
    //   438: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   441: ldc 205
    //   443: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   446: astore_1
    //   447: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +29 -> 479
    //   453: ldc 163
    //   455: iconst_2
    //   456: new 165	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 310
    //   466: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_1
    //   470: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: aload_1
    //   480: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifne -198 -> 285
    //   486: iload 12
    //   488: ifeq +33 -> 521
    //   491: ldc_w 312
    //   494: astore_2
    //   495: aload_0
    //   496: aload_1
    //   497: iconst_1
    //   498: anewarray 184	java/lang/String
    //   501: dup
    //   502: iconst_0
    //   503: aload_2
    //   504: aastore
    //   505: invokevirtual 316	yyu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   508: goto -223 -> 285
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 319	org/json/JSONException:printStackTrace	()V
    //   516: aload_2
    //   517: astore_1
    //   518: goto -71 -> 447
    //   521: ldc_w 321
    //   524: astore_2
    //   525: goto -30 -> 495
    //   528: ldc_w 323
    //   531: aload 4
    //   533: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   536: ifeq +282 -> 818
    //   539: aconst_null
    //   540: astore 14
    //   542: aconst_null
    //   543: astore_3
    //   544: aconst_null
    //   545: astore 4
    //   547: aconst_null
    //   548: astore 15
    //   550: iconst_0
    //   551: istore 13
    //   553: iload 13
    //   555: istore 12
    //   557: aload 15
    //   559: astore_2
    //   560: aload_3
    //   561: astore_1
    //   562: aload 5
    //   564: ifnull +101 -> 665
    //   567: iload 13
    //   569: istore 12
    //   571: aload 15
    //   573: astore_2
    //   574: aload_3
    //   575: astore_1
    //   576: aload 5
    //   578: arraylength
    //   579: ifle +86 -> 665
    //   582: aload 4
    //   584: astore_2
    //   585: aload 14
    //   587: astore_3
    //   588: new 201	org/json/JSONObject
    //   591: dup
    //   592: aload 5
    //   594: iconst_0
    //   595: aaload
    //   596: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   599: astore 5
    //   601: aload 4
    //   603: astore_2
    //   604: aload 14
    //   606: astore_3
    //   607: aload 5
    //   609: ldc 205
    //   611: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   614: astore_1
    //   615: aload 4
    //   617: astore_2
    //   618: aload_1
    //   619: astore_3
    //   620: aload 5
    //   622: ldc_w 325
    //   625: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   628: astore 4
    //   630: aload 4
    //   632: invokestatic 330	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   635: astore_2
    //   636: aload_2
    //   637: astore 4
    //   639: aload 4
    //   641: astore_2
    //   642: aload_1
    //   643: astore_3
    //   644: aload 5
    //   646: ldc_w 332
    //   649: invokevirtual 336	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   652: istore 6
    //   654: iload 6
    //   656: ifne +137 -> 793
    //   659: iconst_0
    //   660: istore 12
    //   662: aload 4
    //   664: astore_2
    //   665: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +50 -> 718
    //   671: ldc 163
    //   673: iconst_2
    //   674: new 165	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 310
    //   684: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_1
    //   688: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc_w 338
    //   694: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_2
    //   698: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 340
    //   704: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload 12
    //   709: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_2
    //   719: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   722: ifne -437 -> 285
    //   725: aload_1
    //   726: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifne -444 -> 285
    //   732: new 345	android/os/Bundle
    //   735: dup
    //   736: invokespecial 346	android/os/Bundle:<init>	()V
    //   739: astore_3
    //   740: aload_3
    //   741: ldc_w 348
    //   744: aload_2
    //   745: invokevirtual 352	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_3
    //   749: ldc_w 354
    //   752: ldc_w 323
    //   755: invokevirtual 352	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   758: aload_3
    //   759: ldc_w 356
    //   762: iload 12
    //   764: invokevirtual 360	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   767: ldc_w 362
    //   770: aload_1
    //   771: aload_0
    //   772: getfield 60	yyu:jdField_a_of_type_Aphy	Laphy;
    //   775: getfield 367	aphy:key	I
    //   778: aload_3
    //   779: invokestatic 372	apic:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   782: astore_1
    //   783: invokestatic 377	apmy:a	()Lapmy;
    //   786: aload_1
    //   787: invokevirtual 380	apmy:a	(Landroid/os/Bundle;)V
    //   790: goto -505 -> 285
    //   793: iconst_1
    //   794: istore 12
    //   796: aload 4
    //   798: astore_2
    //   799: goto -134 -> 665
    //   802: astore 4
    //   804: aload_3
    //   805: astore_1
    //   806: aload 4
    //   808: invokevirtual 319	org/json/JSONException:printStackTrace	()V
    //   811: iload 13
    //   813: istore 12
    //   815: goto -150 -> 665
    //   818: ldc_w 382
    //   821: aload 4
    //   823: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   826: ifeq +281 -> 1107
    //   829: aload_0
    //   830: getfield 72	yyu:mRuntime	Lbecq;
    //   833: invokevirtual 285	becq:a	()Lcom/tencent/common/app/AppInterface;
    //   836: astore 16
    //   838: aconst_null
    //   839: astore 14
    //   841: aconst_null
    //   842: astore_3
    //   843: aconst_null
    //   844: astore 15
    //   846: aconst_null
    //   847: astore 4
    //   849: aload 15
    //   851: astore_1
    //   852: aload 14
    //   854: astore_2
    //   855: aload 5
    //   857: ifnull +211 -> 1068
    //   860: aload 15
    //   862: astore_1
    //   863: aload 14
    //   865: astore_2
    //   866: aload 5
    //   868: arraylength
    //   869: ifle +199 -> 1068
    //   872: aload 4
    //   874: astore_1
    //   875: aload_3
    //   876: astore_2
    //   877: new 201	org/json/JSONObject
    //   880: dup
    //   881: aload 5
    //   883: iconst_0
    //   884: aaload
    //   885: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   888: astore 14
    //   890: aload 4
    //   892: astore_1
    //   893: aload_3
    //   894: astore_2
    //   895: aload 14
    //   897: ldc_w 384
    //   900: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   903: astore_3
    //   904: aload 4
    //   906: astore_1
    //   907: aload_3
    //   908: astore_2
    //   909: aload 14
    //   911: ldc_w 386
    //   914: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   917: astore 4
    //   919: aload 4
    //   921: astore_1
    //   922: aload_3
    //   923: astore_2
    //   924: aload 14
    //   926: ldc_w 388
    //   929: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   932: astore 14
    //   934: aload_3
    //   935: astore_2
    //   936: aload 4
    //   938: astore_1
    //   939: aload 14
    //   941: astore_3
    //   942: aload 16
    //   944: ifnull +56 -> 1000
    //   947: aload_1
    //   948: ifnull +52 -> 1000
    //   951: aload_2
    //   952: ifnull +48 -> 1000
    //   955: ldc_w 390
    //   958: aload_2
    //   959: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   962: ifeq +113 -> 1075
    //   965: aload 16
    //   967: invokevirtual 393	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   970: ldc_w 395
    //   973: aload_1
    //   974: invokestatic 398	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   977: pop
    //   978: aload 16
    //   980: invokevirtual 393	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   983: ldc_w 400
    //   986: ldc_w 402
    //   989: aload_3
    //   990: invokevirtual 405	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   993: invokestatic 298	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   996: invokestatic 398	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   999: pop
    //   1000: invokestatic 409	ausq:b	()Z
    //   1003: ifeq -718 -> 285
    //   1006: aload 5
    //   1008: ifnull +9 -> 1017
    //   1011: aload 5
    //   1013: arraylength
    //   1014: ifne +84 -> 1098
    //   1017: ldc_w 411
    //   1020: astore 4
    //   1022: ldc 163
    //   1024: bipush 6
    //   1026: anewarray 413	java/lang/Object
    //   1029: dup
    //   1030: iconst_0
    //   1031: ldc_w 382
    //   1034: aastore
    //   1035: dup
    //   1036: iconst_1
    //   1037: aload 16
    //   1039: aastore
    //   1040: dup
    //   1041: iconst_2
    //   1042: aload_2
    //   1043: aastore
    //   1044: dup
    //   1045: iconst_3
    //   1046: aload_1
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_4
    //   1050: aload_3
    //   1051: aastore
    //   1052: dup
    //   1053: iconst_5
    //   1054: aload 4
    //   1056: aastore
    //   1057: invokestatic 416	ausq:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1060: goto -775 -> 285
    //   1063: astore_3
    //   1064: aload_3
    //   1065: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   1068: ldc_w 402
    //   1071: astore_3
    //   1072: goto -130 -> 942
    //   1075: aload_1
    //   1076: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1079: ifne -79 -> 1000
    //   1082: aload 16
    //   1084: invokevirtual 393	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1087: ldc_w 419
    //   1090: aload_1
    //   1091: invokestatic 398	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   1094: pop
    //   1095: goto -95 -> 1000
    //   1098: aload 5
    //   1100: iconst_0
    //   1101: aaload
    //   1102: astore 4
    //   1104: goto -82 -> 1022
    //   1107: ldc_w 421
    //   1110: aload 4
    //   1112: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1115: ifeq +337 -> 1452
    //   1118: aload_0
    //   1119: getfield 72	yyu:mRuntime	Lbecq;
    //   1122: invokevirtual 285	becq:a	()Lcom/tencent/common/app/AppInterface;
    //   1125: astore 15
    //   1127: iconst_0
    //   1128: istore 8
    //   1130: iconst_0
    //   1131: istore 10
    //   1133: iconst_0
    //   1134: istore 9
    //   1136: iconst_0
    //   1137: istore 11
    //   1139: aconst_null
    //   1140: astore_3
    //   1141: aconst_null
    //   1142: astore 14
    //   1144: aconst_null
    //   1145: astore 4
    //   1147: iload 10
    //   1149: istore 6
    //   1151: iload 11
    //   1153: istore 7
    //   1155: aload 14
    //   1157: astore_1
    //   1158: aload 4
    //   1160: astore_2
    //   1161: aload 5
    //   1163: ifnull +128 -> 1291
    //   1166: iload 10
    //   1168: istore 6
    //   1170: iload 11
    //   1172: istore 7
    //   1174: aload 14
    //   1176: astore_1
    //   1177: aload 4
    //   1179: astore_2
    //   1180: aload 5
    //   1182: arraylength
    //   1183: ifle +108 -> 1291
    //   1186: iload 8
    //   1188: istore 6
    //   1190: iload 9
    //   1192: istore 7
    //   1194: aload_3
    //   1195: astore_1
    //   1196: new 201	org/json/JSONObject
    //   1199: dup
    //   1200: aload 5
    //   1202: iconst_0
    //   1203: aaload
    //   1204: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1207: astore_2
    //   1208: iload 8
    //   1210: istore 6
    //   1212: iload 9
    //   1214: istore 7
    //   1216: aload_3
    //   1217: astore_1
    //   1218: aload_2
    //   1219: ldc_w 423
    //   1222: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1225: astore_3
    //   1226: iload 8
    //   1228: istore 6
    //   1230: iload 9
    //   1232: istore 7
    //   1234: aload_3
    //   1235: astore_1
    //   1236: aload_2
    //   1237: ldc_w 425
    //   1240: invokevirtual 336	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1243: istore 8
    //   1245: iload 8
    //   1247: istore 6
    //   1249: iload 9
    //   1251: istore 7
    //   1253: aload_3
    //   1254: astore_1
    //   1255: aload_2
    //   1256: ldc_w 427
    //   1259: invokevirtual 336	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1262: istore 9
    //   1264: iload 8
    //   1266: istore 6
    //   1268: iload 9
    //   1270: istore 7
    //   1272: aload_3
    //   1273: astore_1
    //   1274: aload_2
    //   1275: ldc 205
    //   1277: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1280: astore_2
    //   1281: aload_3
    //   1282: astore_1
    //   1283: iload 9
    //   1285: istore 7
    //   1287: iload 8
    //   1289: istore 6
    //   1291: aload_1
    //   1292: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1295: ifeq +142 -> 1437
    //   1298: ldc_w 429
    //   1301: astore_3
    //   1302: new 201	org/json/JSONObject
    //   1305: dup
    //   1306: invokespecial 430	org/json/JSONObject:<init>	()V
    //   1309: astore 4
    //   1311: aload 4
    //   1313: ldc_w 432
    //   1316: iconst_m1
    //   1317: invokevirtual 436	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1320: pop
    //   1321: aload 4
    //   1323: ldc_w 438
    //   1326: ldc_w 429
    //   1329: invokevirtual 441	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1332: pop
    //   1333: aload 4
    //   1335: ldc_w 443
    //   1338: ldc_w 445
    //   1341: invokevirtual 441	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1344: pop
    //   1345: aload 4
    //   1347: invokevirtual 446	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1350: astore 4
    //   1352: aload 4
    //   1354: astore_3
    //   1355: aload_0
    //   1356: aload_2
    //   1357: iconst_1
    //   1358: anewarray 184	java/lang/String
    //   1361: dup
    //   1362: iconst_0
    //   1363: aload_3
    //   1364: aastore
    //   1365: invokevirtual 316	yyu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1368: invokestatic 409	ausq:b	()Z
    //   1371: ifeq -1086 -> 285
    //   1374: ldc 163
    //   1376: iconst_5
    //   1377: anewarray 413	java/lang/Object
    //   1380: dup
    //   1381: iconst_0
    //   1382: ldc_w 421
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_1
    //   1388: iload 6
    //   1390: invokestatic 451	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1393: aastore
    //   1394: dup
    //   1395: iconst_2
    //   1396: iload 7
    //   1398: invokestatic 451	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1401: aastore
    //   1402: dup
    //   1403: iconst_3
    //   1404: aload_1
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_4
    //   1408: aload_2
    //   1409: aastore
    //   1410: invokestatic 416	ausq:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1413: goto -1128 -> 285
    //   1416: astore_2
    //   1417: aload_2
    //   1418: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   1421: aload 4
    //   1423: astore_2
    //   1424: goto -133 -> 1291
    //   1427: astore 4
    //   1429: aload 4
    //   1431: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   1434: goto -79 -> 1355
    //   1437: aload 15
    //   1439: iload 6
    //   1441: iload 7
    //   1443: aload_1
    //   1444: aload_0
    //   1445: aload_2
    //   1446: invokestatic 456	aupz:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    //   1449: goto -81 -> 1368
    //   1452: ldc_w 458
    //   1455: aload 4
    //   1457: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1460: ifeq +127 -> 1587
    //   1463: aload 5
    //   1465: ifnull +974 -> 2439
    //   1468: aload 5
    //   1470: arraylength
    //   1471: ifle +968 -> 2439
    //   1474: new 201	org/json/JSONObject
    //   1477: dup
    //   1478: aload 5
    //   1480: iconst_0
    //   1481: aaload
    //   1482: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1485: ldc 205
    //   1487: invokevirtual 209	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1490: astore_1
    //   1491: aload_0
    //   1492: getfield 72	yyu:mRuntime	Lbecq;
    //   1495: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   1498: astore_2
    //   1499: aload_2
    //   1500: ifnull +939 -> 2439
    //   1503: aload_2
    //   1504: instanceof 211
    //   1507: ifeq +932 -> 2439
    //   1510: aload_2
    //   1511: checkcast 211	com/tencent/mobileqq/activity/NearbyActivity
    //   1514: invokevirtual 214	com/tencent/mobileqq/activity/NearbyActivity:a	()Lcom/tencent/mobileqq/fragment/HotChatFragment;
    //   1517: astore_3
    //   1518: aload_3
    //   1519: ifnull +920 -> 2439
    //   1522: aload_3
    //   1523: instanceof 216
    //   1526: ifeq +913 -> 2439
    //   1529: aload_1
    //   1530: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1533: ifeq +14 -> 1547
    //   1536: aload_3
    //   1537: checkcast 216	com/tencent/mobileqq/fragment/HotChatFragment
    //   1540: aconst_null
    //   1541: invokevirtual 225	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   1544: goto +895 -> 2439
    //   1547: aload_3
    //   1548: checkcast 216	com/tencent/mobileqq/fragment/HotChatFragment
    //   1551: new 460	yyw
    //   1554: dup
    //   1555: aload_0
    //   1556: aload_1
    //   1557: aload_2
    //   1558: invokespecial 461	yyw:<init>	(Lyyu;Ljava/lang/String;Landroid/app/Activity;)V
    //   1561: invokevirtual 225	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   1564: goto +875 -> 2439
    //   1567: astore_1
    //   1568: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1571: ifeq +868 -> 2439
    //   1574: ldc 163
    //   1576: iconst_2
    //   1577: aload_1
    //   1578: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1581: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1584: goto +855 -> 2439
    //   1587: ldc_w 463
    //   1590: aload 4
    //   1592: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1595: ifeq +169 -> 1764
    //   1598: aload 5
    //   1600: ifnull -1315 -> 285
    //   1603: aload 5
    //   1605: arraylength
    //   1606: ifle -1321 -> 285
    //   1609: new 201	org/json/JSONObject
    //   1612: dup
    //   1613: aload 5
    //   1615: iconst_0
    //   1616: aaload
    //   1617: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1620: astore_1
    //   1621: aload_1
    //   1622: ldc_w 465
    //   1625: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1628: astore_2
    //   1629: aload_1
    //   1630: ldc_w 467
    //   1633: invokevirtual 471	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1636: astore_3
    //   1637: iconst_0
    //   1638: istore 6
    //   1640: iload 6
    //   1642: aload_3
    //   1643: invokevirtual 476	org/json/JSONArray:length	()I
    //   1646: if_icmpge -1361 -> 285
    //   1649: aload_3
    //   1650: iload 6
    //   1652: invokevirtual 480	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1655: checkcast 201	org/json/JSONObject
    //   1658: astore 4
    //   1660: aload 4
    //   1662: ldc_w 482
    //   1665: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1668: astore 5
    //   1670: aload 4
    //   1672: ldc_w 484
    //   1675: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1678: astore_1
    //   1679: aload 4
    //   1681: ldc_w 486
    //   1684: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1687: astore 4
    //   1689: aload_1
    //   1690: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1693: ifeq +741 -> 2434
    //   1696: aload 5
    //   1698: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1701: ifne +733 -> 2434
    //   1704: aload_0
    //   1705: getfield 44	yyu:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1708: aload 5
    //   1710: invokevirtual 489	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1713: checkcast 184	java/lang/String
    //   1716: astore_1
    //   1717: aload_1
    //   1718: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1721: ifne +14 -> 1735
    //   1724: aload_0
    //   1725: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   1728: aload_2
    //   1729: aload_1
    //   1730: aload 4
    //   1732: invokevirtual 494	ymk:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1735: iload 6
    //   1737: iconst_1
    //   1738: iadd
    //   1739: istore 6
    //   1741: goto -101 -> 1640
    //   1744: astore_1
    //   1745: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1748: ifeq -1463 -> 285
    //   1751: ldc 163
    //   1753: iconst_2
    //   1754: aload_1
    //   1755: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1758: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1761: goto -1476 -> 285
    //   1764: ldc_w 496
    //   1767: aload 4
    //   1769: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1772: ifeq +90 -> 1862
    //   1775: aload 5
    //   1777: ifnull -1492 -> 285
    //   1780: aload 5
    //   1782: arraylength
    //   1783: ifle -1498 -> 285
    //   1786: new 201	org/json/JSONObject
    //   1789: dup
    //   1790: aload 5
    //   1792: iconst_0
    //   1793: aaload
    //   1794: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1797: astore_3
    //   1798: aload_3
    //   1799: ldc 205
    //   1801: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1804: astore_1
    //   1805: aload_3
    //   1806: ldc_w 465
    //   1809: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1812: astore_2
    //   1813: aload_3
    //   1814: ldc_w 498
    //   1817: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1820: astore_3
    //   1821: aload_0
    //   1822: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   1825: aload_2
    //   1826: aload_3
    //   1827: new 500	yyx
    //   1830: dup
    //   1831: aload_0
    //   1832: aload_1
    //   1833: invokespecial 501	yyx:<init>	(Lyyu;Ljava/lang/String;)V
    //   1836: invokevirtual 504	ymk:d	(Ljava/lang/String;Ljava/lang/String;Lymm;)V
    //   1839: goto -1554 -> 285
    //   1842: astore_1
    //   1843: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1846: ifeq -1561 -> 285
    //   1849: ldc 163
    //   1851: iconst_2
    //   1852: aload_1
    //   1853: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1856: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: goto -1574 -> 285
    //   1862: ldc_w 506
    //   1865: aload 4
    //   1867: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1870: ifeq +128 -> 1998
    //   1873: new 79	java/util/ArrayList
    //   1876: dup
    //   1877: invokespecial 80	java/util/ArrayList:<init>	()V
    //   1880: astore_1
    //   1881: aload 5
    //   1883: ifnull -1598 -> 285
    //   1886: aload 5
    //   1888: arraylength
    //   1889: ifle -1604 -> 285
    //   1892: new 201	org/json/JSONObject
    //   1895: dup
    //   1896: aload 5
    //   1898: iconst_0
    //   1899: aaload
    //   1900: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1903: astore_2
    //   1904: aload_2
    //   1905: ldc 205
    //   1907: invokevirtual 209	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1910: pop
    //   1911: aload_2
    //   1912: ldc_w 465
    //   1915: invokevirtual 209	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1918: pop
    //   1919: aload_2
    //   1920: ldc_w 508
    //   1923: invokevirtual 471	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1926: astore_2
    //   1927: iconst_0
    //   1928: istore 6
    //   1930: iload 6
    //   1932: aload_2
    //   1933: invokevirtual 476	org/json/JSONArray:length	()I
    //   1936: if_icmpge +23 -> 1959
    //   1939: aload_1
    //   1940: aload_2
    //   1941: iload 6
    //   1943: invokevirtual 509	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1946: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1949: pop
    //   1950: iload 6
    //   1952: iconst_1
    //   1953: iadd
    //   1954: istore 6
    //   1956: goto -26 -> 1930
    //   1959: aload_0
    //   1960: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   1963: aload_1
    //   1964: new 512	yyy
    //   1967: dup
    //   1968: aload_0
    //   1969: invokespecial 513	yyy:<init>	(Lyyu;)V
    //   1972: invokevirtual 516	ymk:a	(Ljava/util/ArrayList;Lymm;)V
    //   1975: goto -1690 -> 285
    //   1978: astore_1
    //   1979: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1982: ifeq -1697 -> 285
    //   1985: ldc 163
    //   1987: iconst_2
    //   1988: aload_1
    //   1989: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1992: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1995: goto -1710 -> 285
    //   1998: ldc_w 518
    //   2001: aload 4
    //   2003: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2006: ifeq +62 -> 2068
    //   2009: aload 5
    //   2011: ifnull -1726 -> 285
    //   2014: aload 5
    //   2016: arraylength
    //   2017: ifle -1732 -> 285
    //   2020: new 201	org/json/JSONObject
    //   2023: dup
    //   2024: aload 5
    //   2026: iconst_0
    //   2027: aaload
    //   2028: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2031: ldc_w 465
    //   2034: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2037: pop
    //   2038: aload_0
    //   2039: getfield 44	yyu:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2042: invokevirtual 521	java/util/HashMap:clear	()V
    //   2045: goto -1760 -> 285
    //   2048: astore_1
    //   2049: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2052: ifeq -1767 -> 285
    //   2055: ldc 163
    //   2057: iconst_2
    //   2058: aload_1
    //   2059: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2062: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2065: goto -1780 -> 285
    //   2068: ldc_w 523
    //   2071: aload 4
    //   2073: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2076: ifeq +75 -> 2151
    //   2079: aload_0
    //   2080: getfield 72	yyu:mRuntime	Lbecq;
    //   2083: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   2086: astore_1
    //   2087: aload 5
    //   2089: ifnull -1804 -> 285
    //   2092: aload 5
    //   2094: arraylength
    //   2095: ifle -1810 -> 285
    //   2098: new 201	org/json/JSONObject
    //   2101: dup
    //   2102: aload 5
    //   2104: iconst_0
    //   2105: aaload
    //   2106: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2109: ldc_w 465
    //   2112: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2115: astore_2
    //   2116: aload_0
    //   2117: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   2120: aload_2
    //   2121: invokevirtual 525	ymk:d	(Ljava/lang/String;)V
    //   2124: aload_1
    //   2125: invokevirtual 528	android/app/Activity:finish	()V
    //   2128: goto -1843 -> 285
    //   2131: astore_1
    //   2132: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2135: ifeq -1850 -> 285
    //   2138: ldc 163
    //   2140: iconst_2
    //   2141: aload_1
    //   2142: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2145: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2148: goto -1863 -> 285
    //   2151: ldc_w 530
    //   2154: aload 4
    //   2156: invokevirtual 188	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2159: ifeq +235 -> 2394
    //   2162: aload 5
    //   2164: ifnull -1879 -> 285
    //   2167: aload 5
    //   2169: arraylength
    //   2170: ifle -1885 -> 285
    //   2173: new 201	org/json/JSONObject
    //   2176: dup
    //   2177: aload 5
    //   2179: iconst_0
    //   2180: aaload
    //   2181: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2184: astore_1
    //   2185: aload_0
    //   2186: getfield 72	yyu:mRuntime	Lbecq;
    //   2189: invokevirtual 77	becq:a	()Landroid/app/Activity;
    //   2192: astore_3
    //   2193: aload_1
    //   2194: ldc_w 532
    //   2197: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2200: astore 4
    //   2202: aload_1
    //   2203: ldc_w 484
    //   2206: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2209: astore_2
    //   2210: aload_1
    //   2211: ldc_w 482
    //   2214: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2217: astore 14
    //   2219: aload_1
    //   2220: ldc_w 486
    //   2223: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2226: astore 5
    //   2228: aload_1
    //   2229: ldc_w 465
    //   2232: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2235: astore 15
    //   2237: aload_2
    //   2238: astore_1
    //   2239: aload_2
    //   2240: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2243: ifeq +26 -> 2269
    //   2246: aload_2
    //   2247: astore_1
    //   2248: aload 14
    //   2250: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2253: ifne +16 -> 2269
    //   2256: aload_0
    //   2257: getfield 44	yyu:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2260: aload 14
    //   2262: invokevirtual 489	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2265: checkcast 184	java/lang/String
    //   2268: astore_1
    //   2269: aload_1
    //   2270: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2273: ifeq +19 -> 2292
    //   2276: invokestatic 538	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2279: getstatic 27	yyu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2282: iconst_0
    //   2283: invokestatic 543	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   2286: invokevirtual 546	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   2289: pop
    //   2290: iconst_0
    //   2291: ireturn
    //   2292: aload 4
    //   2294: ldc_w 321
    //   2297: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2300: ifeq +40 -> 2340
    //   2303: aload_0
    //   2304: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   2307: aload 15
    //   2309: aload_1
    //   2310: invokevirtual 549	ymk:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   2313: aload_3
    //   2314: invokevirtual 528	android/app/Activity:finish	()V
    //   2317: goto -2032 -> 285
    //   2320: astore_1
    //   2321: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2324: ifeq -2039 -> 285
    //   2327: ldc 163
    //   2329: iconst_2
    //   2330: aload_1
    //   2331: invokevirtual 233	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2334: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2337: goto -2052 -> 285
    //   2340: aload 4
    //   2342: ldc_w 312
    //   2345: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2348: ifeq +22 -> 2370
    //   2351: aload_0
    //   2352: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   2355: aload 15
    //   2357: aload_1
    //   2358: aload 5
    //   2360: invokevirtual 551	ymk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2363: aload_3
    //   2364: invokevirtual 528	android/app/Activity:finish	()V
    //   2367: goto -2082 -> 285
    //   2370: aload 4
    //   2372: ldc_w 553
    //   2375: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2378: ifeq -2093 -> 285
    //   2381: aload_0
    //   2382: getfield 46	yyu:jdField_a_of_type_Ymk	Lymk;
    //   2385: aload 15
    //   2387: aload_1
    //   2388: invokevirtual 556	ymk:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   2391: goto -2106 -> 285
    //   2394: ldc 163
    //   2396: iconst_1
    //   2397: new 165	java/lang/StringBuilder
    //   2400: dup
    //   2401: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   2404: ldc_w 558
    //   2407: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2410: aload 4
    //   2412: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2418: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2421: goto -2136 -> 285
    //   2424: astore_3
    //   2425: aload 4
    //   2427: astore_2
    //   2428: aload_3
    //   2429: astore 4
    //   2431: goto -1625 -> 806
    //   2434: goto -717 -> 1717
    //   2437: iconst_1
    //   2438: ireturn
    //   2439: iconst_1
    //   2440: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2441	0	this	yyu
    //   0	2441	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2441	2	paramString1	String
    //   0	2441	3	paramString2	String
    //   0	2441	4	paramString3	String
    //   0	2441	5	paramVarArgs	String[]
    //   652	1303	6	i	int
    //   1153	289	7	j	int
    //   1128	160	8	k	int
    //   1134	150	9	m	int
    //   1131	36	10	n	int
    //   1137	34	11	i1	int
    //   411	403	12	bool1	boolean
    //   551	261	13	bool2	boolean
    //   540	1721	14	localObject1	java.lang.Object
    //   548	1838	15	localObject2	java.lang.Object
    //   836	247	16	localAppInterface	com.tencent.common.app.AppInterface
    // Exception table:
    //   from	to	target	type
    //   106	131	199	org/json/JSONException
    //   135	150	199	org/json/JSONException
    //   154	176	199	org/json/JSONException
    //   179	196	199	org/json/JSONException
    //   430	447	511	org/json/JSONException
    //   588	601	802	org/json/JSONException
    //   607	615	802	org/json/JSONException
    //   620	630	802	org/json/JSONException
    //   644	654	802	org/json/JSONException
    //   877	890	1063	java/lang/Exception
    //   895	904	1063	java/lang/Exception
    //   909	919	1063	java/lang/Exception
    //   924	934	1063	java/lang/Exception
    //   1196	1208	1416	java/lang/Exception
    //   1218	1226	1416	java/lang/Exception
    //   1236	1245	1416	java/lang/Exception
    //   1255	1264	1416	java/lang/Exception
    //   1274	1281	1416	java/lang/Exception
    //   1302	1352	1427	java/lang/Exception
    //   1474	1499	1567	org/json/JSONException
    //   1503	1518	1567	org/json/JSONException
    //   1522	1544	1567	org/json/JSONException
    //   1547	1564	1567	org/json/JSONException
    //   1609	1637	1744	org/json/JSONException
    //   1640	1717	1744	org/json/JSONException
    //   1717	1735	1744	org/json/JSONException
    //   1786	1839	1842	org/json/JSONException
    //   1892	1927	1978	org/json/JSONException
    //   1930	1950	1978	org/json/JSONException
    //   1959	1975	1978	org/json/JSONException
    //   2020	2045	2048	org/json/JSONException
    //   2098	2128	2131	org/json/JSONException
    //   2173	2237	2320	org/json/JSONException
    //   2239	2246	2320	org/json/JSONException
    //   2248	2269	2320	org/json/JSONException
    //   2269	2290	2320	org/json/JSONException
    //   2292	2317	2320	org/json/JSONException
    //   2340	2367	2320	org/json/JSONException
    //   2370	2391	2320	org/json/JSONException
    //   630	636	2424	org/json/JSONException
  }
  
  public void onCreate()
  {
    apmy.a().a(this.jdField_a_of_type_Aphy);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Ymk = ymk.a();
      this.jdField_a_of_type_Ymk.a();
    }
  }
  
  public void onDestroy()
  {
    apmy.a().b(this.jdField_a_of_type_Aphy);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_Ymk.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyu
 * JD-Core Version:    0.7.0.1
 */