import com.tencent.biz.AuthorizeConfig;

public class bgi
  implements Runnable
{
  public bgi(AuthorizeConfig paramAuthorizeConfig) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc2_w 24
    //   3: invokestatic 31	java/lang/Thread:sleep	(J)V
    //   6: aload_0
    //   7: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   10: getfield 36	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: ldc 38
    //   15: iconst_0
    //   16: invokevirtual 44	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: astore 7
    //   21: aload 7
    //   23: ldc 46
    //   25: aconst_null
    //   26: invokeinterface 52 3 0
    //   31: astore 9
    //   33: aload 7
    //   35: ldc 54
    //   37: aconst_null
    //   38: invokeinterface 52 3 0
    //   43: astore 8
    //   45: aconst_null
    //   46: astore 6
    //   48: aload 6
    //   50: astore 5
    //   52: aload 8
    //   54: ifnull +47 -> 101
    //   57: aload 6
    //   59: astore 5
    //   61: aload 8
    //   63: invokevirtual 60	java/lang/String:length	()I
    //   66: ifle +35 -> 101
    //   69: aload 6
    //   71: astore 5
    //   73: ldc 62
    //   75: aload 9
    //   77: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +21 -> 101
    //   83: new 68	android/os/Bundle
    //   86: dup
    //   87: invokespecial 69	android/os/Bundle:<init>	()V
    //   90: astore 5
    //   92: aload 5
    //   94: ldc 71
    //   96: aload 8
    //   98: invokevirtual 75	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: ldc 77
    //   103: invokestatic 83	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   106: invokevirtual 87	android/net/Uri:getHost	()Ljava/lang/String;
    //   109: astore 6
    //   111: aload_0
    //   112: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   115: getfield 36	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   118: ldc 77
    //   120: aload 6
    //   122: ldc 89
    //   124: aconst_null
    //   125: aload 5
    //   127: invokestatic 94	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/apache/http/HttpResponse;
    //   130: astore 5
    //   132: aload 5
    //   134: ifnonnull +87 -> 221
    //   137: new 96	java/io/IOException
    //   140: dup
    //   141: ldc 98
    //   143: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: astore 5
    //   149: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +32 -> 184
    //   155: ldc 109
    //   157: iconst_2
    //   158: new 111	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   165: ldc 114
    //   167: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 5
    //   172: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iconst_0
    //   185: putstatic 132	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   188: aconst_null
    //   189: ldc 134
    //   191: ldc 136
    //   193: ldc 138
    //   195: ldc 140
    //   197: ldc 142
    //   199: iconst_0
    //   200: iconst_1
    //   201: iconst_0
    //   202: ldc 138
    //   204: ldc 138
    //   206: ldc 138
    //   208: ldc 138
    //   210: invokestatic 147	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: return
    //   214: astore 5
    //   216: iconst_0
    //   217: putstatic 132	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   220: return
    //   221: aload 5
    //   223: invokeinterface 153 1 0
    //   228: invokeinterface 158 1 0
    //   233: istore_1
    //   234: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +31 -> 268
    //   240: ldc 109
    //   242: iconst_2
    //   243: new 111	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   250: ldc 160
    //   252: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload_1
    //   256: invokestatic 164	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   259: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iload_1
    //   269: sipush 200
    //   272: if_icmpne +188 -> 460
    //   275: aload 5
    //   277: ldc 166
    //   279: invokeinterface 170 2 0
    //   284: astore 6
    //   286: aload 6
    //   288: ifnonnull +160 -> 448
    //   291: aconst_null
    //   292: astore 6
    //   294: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +29 -> 326
    //   300: ldc 109
    //   302: iconst_2
    //   303: new 111	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   310: ldc 172
    //   312: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 6
    //   317: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: new 174	org/json/JSONObject
    //   329: dup
    //   330: aload 5
    //   332: invokestatic 177	com/tencent/biz/common/util/HttpUtil:a	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   335: invokespecial 178	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   338: astore 8
    //   340: iconst_1
    //   341: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   344: astore 5
    //   346: aload 7
    //   348: invokeinterface 187 1 0
    //   353: astore 7
    //   355: new 174	org/json/JSONObject
    //   358: dup
    //   359: invokespecial 188	org/json/JSONObject:<init>	()V
    //   362: astore 9
    //   364: aload 8
    //   366: ldc 190
    //   368: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   371: astore 10
    //   373: iconst_0
    //   374: istore_1
    //   375: aload 10
    //   377: invokevirtual 197	org/json/JSONArray:length	()I
    //   380: istore_3
    //   381: iload_1
    //   382: iload_3
    //   383: if_icmpge +168 -> 551
    //   386: aload 10
    //   388: iload_1
    //   389: invokevirtual 201	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   392: astore 12
    //   394: aload 12
    //   396: ldc 203
    //   398: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   401: astore 11
    //   403: aload 12
    //   405: ldc 205
    //   407: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   410: astore 12
    //   412: iconst_0
    //   413: istore_2
    //   414: aload 12
    //   416: invokevirtual 197	org/json/JSONArray:length	()I
    //   419: istore 4
    //   421: iload_2
    //   422: iload 4
    //   424: if_icmpge +120 -> 544
    //   427: aload 9
    //   429: aload 12
    //   431: iload_2
    //   432: invokevirtual 207	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   435: aload 11
    //   437: invokevirtual 211	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: iload_2
    //   442: iconst_1
    //   443: iadd
    //   444: istore_2
    //   445: goto -24 -> 421
    //   448: aload 6
    //   450: invokeinterface 216 1 0
    //   455: astore 6
    //   457: goto -163 -> 294
    //   460: iload_1
    //   461: sipush 304
    //   464: if_icmpne +70 -> 534
    //   467: iconst_2
    //   468: putstatic 132	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   471: aload 7
    //   473: invokeinterface 187 1 0
    //   478: ldc 218
    //   480: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   483: invokeinterface 230 4 0
    //   488: invokeinterface 233 1 0
    //   493: pop
    //   494: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +11 -> 508
    //   500: ldc 109
    //   502: iconst_2
    //   503: ldc 235
    //   505: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: aconst_null
    //   509: ldc 134
    //   511: ldc 136
    //   513: ldc 138
    //   515: ldc 140
    //   517: ldc 237
    //   519: iconst_0
    //   520: iconst_1
    //   521: iconst_0
    //   522: ldc 138
    //   524: ldc 138
    //   526: ldc 138
    //   528: ldc 138
    //   530: invokestatic 147	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   533: return
    //   534: new 96	java/io/IOException
    //   537: dup
    //   538: ldc 239
    //   540: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   543: athrow
    //   544: iload_1
    //   545: iconst_1
    //   546: iadd
    //   547: istore_1
    //   548: goto -167 -> 381
    //   551: aload_0
    //   552: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   555: aload 9
    //   557: putfield 242	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   560: aload 7
    //   562: ldc 244
    //   564: aload 9
    //   566: invokevirtual 245	org/json/JSONObject:toString	()Ljava/lang/String;
    //   569: invokeinterface 248 3 0
    //   574: pop
    //   575: aload 8
    //   577: ldc 250
    //   579: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   582: astore 9
    //   584: aload_0
    //   585: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   588: aload 9
    //   590: putfield 253	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   593: aload 7
    //   595: ldc 250
    //   597: aload 9
    //   599: invokevirtual 254	org/json/JSONArray:toString	()Ljava/lang/String;
    //   602: invokeinterface 248 3 0
    //   607: pop
    //   608: aload 8
    //   610: ldc_w 256
    //   613: invokevirtual 259	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   616: astore 9
    //   618: aload_0
    //   619: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   622: aload 9
    //   624: putfield 261	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   627: aload 7
    //   629: ldc_w 263
    //   632: aload 9
    //   634: invokevirtual 245	org/json/JSONObject:toString	()Ljava/lang/String;
    //   637: invokeinterface 248 3 0
    //   642: pop
    //   643: aload 8
    //   645: ldc_w 265
    //   648: invokevirtual 259	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   651: astore 9
    //   653: aload_0
    //   654: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   657: aload 9
    //   659: putfield 268	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   662: aload 7
    //   664: ldc_w 270
    //   667: aload 9
    //   669: invokevirtual 245	org/json/JSONObject:toString	()Ljava/lang/String;
    //   672: invokeinterface 248 3 0
    //   677: pop
    //   678: aload 8
    //   680: ldc_w 272
    //   683: invokevirtual 259	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   686: astore 9
    //   688: aload_0
    //   689: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   692: aload 9
    //   694: putfield 274	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   697: aload 7
    //   699: ldc_w 272
    //   702: aload 9
    //   704: invokevirtual 245	org/json/JSONObject:toString	()Ljava/lang/String;
    //   707: invokeinterface 248 3 0
    //   712: pop
    //   713: aload 8
    //   715: ldc_w 276
    //   718: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   721: astore 9
    //   723: aload_0
    //   724: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   727: aload 9
    //   729: putfield 278	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   732: aload 7
    //   734: ldc_w 276
    //   737: aload 9
    //   739: invokevirtual 254	org/json/JSONArray:toString	()Ljava/lang/String;
    //   742: invokeinterface 248 3 0
    //   747: pop
    //   748: aload_0
    //   749: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   752: aconst_null
    //   753: putfield 281	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   756: aload 8
    //   758: ldc_w 283
    //   761: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   764: astore 9
    //   766: aload_0
    //   767: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   770: aload 9
    //   772: putfield 285	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   775: aload 7
    //   777: ldc_w 283
    //   780: aload 9
    //   782: invokevirtual 254	org/json/JSONArray:toString	()Ljava/lang/String;
    //   785: invokeinterface 248 3 0
    //   790: pop
    //   791: aload_0
    //   792: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   795: aconst_null
    //   796: putfield 281	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   799: aload 8
    //   801: ldc_w 287
    //   804: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   807: astore 9
    //   809: aload_0
    //   810: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   813: aload 9
    //   815: putfield 290	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   818: aload 7
    //   820: ldc_w 287
    //   823: aload 9
    //   825: invokevirtual 254	org/json/JSONArray:toString	()Ljava/lang/String;
    //   828: invokeinterface 248 3 0
    //   833: pop
    //   834: aload_0
    //   835: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   838: aconst_null
    //   839: putfield 292	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   842: new 174	org/json/JSONObject
    //   845: dup
    //   846: invokespecial 188	org/json/JSONObject:<init>	()V
    //   849: astore 9
    //   851: aload 8
    //   853: ldc_w 294
    //   856: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   859: astore 8
    //   861: aload 8
    //   863: invokevirtual 197	org/json/JSONArray:length	()I
    //   866: istore_3
    //   867: iconst_0
    //   868: istore_1
    //   869: iload_1
    //   870: iload_3
    //   871: if_icmpge +161 -> 1032
    //   874: aload 8
    //   876: iload_1
    //   877: invokevirtual 201	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   880: astore 11
    //   882: aload 11
    //   884: ldc_w 296
    //   887: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   890: astore 10
    //   892: aload 11
    //   894: ldc 205
    //   896: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   899: astore 11
    //   901: iconst_0
    //   902: istore_2
    //   903: aload 11
    //   905: invokevirtual 197	org/json/JSONArray:length	()I
    //   908: istore 4
    //   910: iload_2
    //   911: iload 4
    //   913: if_icmpge +112 -> 1025
    //   916: aload 9
    //   918: aload 11
    //   920: iload_2
    //   921: invokevirtual 207	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   924: aload 10
    //   926: invokevirtual 211	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   929: pop
    //   930: iload_2
    //   931: iconst_1
    //   932: iadd
    //   933: istore_2
    //   934: goto -24 -> 910
    //   937: astore 5
    //   939: iconst_0
    //   940: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   943: astore 5
    //   945: goto -370 -> 575
    //   948: astore 5
    //   950: iconst_0
    //   951: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   954: astore 5
    //   956: goto -348 -> 608
    //   959: astore 5
    //   961: iconst_0
    //   962: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   965: astore 5
    //   967: goto -324 -> 643
    //   970: astore 5
    //   972: iconst_0
    //   973: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   976: astore 5
    //   978: goto -300 -> 678
    //   981: astore 5
    //   983: iconst_0
    //   984: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   987: astore 5
    //   989: goto -276 -> 713
    //   992: astore 5
    //   994: iconst_0
    //   995: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   998: astore 5
    //   1000: goto -244 -> 756
    //   1003: astore 5
    //   1005: iconst_0
    //   1006: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1009: astore 5
    //   1011: goto -212 -> 799
    //   1014: astore 5
    //   1016: iconst_0
    //   1017: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1020: astore 5
    //   1022: goto -180 -> 842
    //   1025: iload_1
    //   1026: iconst_1
    //   1027: iadd
    //   1028: istore_1
    //   1029: goto -160 -> 869
    //   1032: aload_0
    //   1033: getfield 12	bgi:a	Lcom/tencent/biz/AuthorizeConfig;
    //   1036: aload 9
    //   1038: putfield 298	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   1041: aload 7
    //   1043: ldc_w 294
    //   1046: aload 9
    //   1048: invokevirtual 245	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1051: invokeinterface 248 3 0
    //   1056: pop
    //   1057: aload 5
    //   1059: invokevirtual 301	java/lang/Boolean:booleanValue	()Z
    //   1062: ifeq +105 -> 1167
    //   1065: iconst_2
    //   1066: putstatic 132	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   1069: aload 7
    //   1071: ldc 218
    //   1073: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   1076: invokeinterface 230 4 0
    //   1081: pop
    //   1082: aload 7
    //   1084: ldc 46
    //   1086: ldc 62
    //   1088: invokeinterface 248 3 0
    //   1093: pop
    //   1094: aload 7
    //   1096: ldc 54
    //   1098: aload 6
    //   1100: invokeinterface 248 3 0
    //   1105: pop
    //   1106: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1109: ifeq +12 -> 1121
    //   1112: ldc 109
    //   1114: iconst_2
    //   1115: ldc_w 303
    //   1118: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1121: aconst_null
    //   1122: ldc 134
    //   1124: ldc 136
    //   1126: ldc 138
    //   1128: ldc 140
    //   1130: ldc_w 305
    //   1133: iconst_0
    //   1134: iconst_1
    //   1135: iconst_0
    //   1136: ldc 138
    //   1138: ldc 138
    //   1140: ldc 138
    //   1142: ldc 138
    //   1144: invokestatic 147	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1147: aload 7
    //   1149: invokeinterface 233 1 0
    //   1154: pop
    //   1155: return
    //   1156: astore 5
    //   1158: iconst_0
    //   1159: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1162: astore 5
    //   1164: goto -107 -> 1057
    //   1167: iconst_0
    //   1168: putstatic 132	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   1171: aconst_null
    //   1172: ldc 134
    //   1174: ldc 136
    //   1176: ldc 138
    //   1178: ldc 140
    //   1180: ldc 142
    //   1182: iconst_0
    //   1183: iconst_1
    //   1184: iconst_0
    //   1185: ldc 138
    //   1187: ldc 138
    //   1189: ldc 138
    //   1191: ldc 138
    //   1193: invokestatic 147	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1196: goto -49 -> 1147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1199	0	this	bgi
    //   233	796	1	i	int
    //   413	521	2	j	int
    //   380	492	3	k	int
    //   419	495	4	m	int
    //   50	83	5	localObject1	Object
    //   147	24	5	localException1	java.lang.Exception
    //   214	117	5	localInterruptedException	java.lang.InterruptedException
    //   344	1	5	localBoolean1	java.lang.Boolean
    //   937	1	5	localException2	java.lang.Exception
    //   943	1	5	localBoolean2	java.lang.Boolean
    //   948	1	5	localJSONException1	org.json.JSONException
    //   954	1	5	localBoolean3	java.lang.Boolean
    //   959	1	5	localJSONException2	org.json.JSONException
    //   965	1	5	localBoolean4	java.lang.Boolean
    //   970	1	5	localJSONException3	org.json.JSONException
    //   976	1	5	localBoolean5	java.lang.Boolean
    //   981	1	5	localJSONException4	org.json.JSONException
    //   987	1	5	localBoolean6	java.lang.Boolean
    //   992	1	5	localJSONException5	org.json.JSONException
    //   998	1	5	localBoolean7	java.lang.Boolean
    //   1003	1	5	localJSONException6	org.json.JSONException
    //   1009	1	5	localBoolean8	java.lang.Boolean
    //   1014	1	5	localJSONException7	org.json.JSONException
    //   1020	38	5	localBoolean9	java.lang.Boolean
    //   1156	1	5	localException3	java.lang.Exception
    //   1162	1	5	localBoolean10	java.lang.Boolean
    //   46	1053	6	localObject2	Object
    //   19	1129	7	localObject3	Object
    //   43	832	8	localObject4	Object
    //   31	1016	9	localObject5	Object
    //   371	554	10	localJSONArray	org.json.JSONArray
    //   401	518	11	localObject6	Object
    //   392	38	12	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   21	45	147	java/lang/Exception
    //   61	69	147	java/lang/Exception
    //   73	101	147	java/lang/Exception
    //   101	132	147	java/lang/Exception
    //   137	147	147	java/lang/Exception
    //   221	268	147	java/lang/Exception
    //   275	286	147	java/lang/Exception
    //   294	326	147	java/lang/Exception
    //   326	340	147	java/lang/Exception
    //   448	457	147	java/lang/Exception
    //   467	508	147	java/lang/Exception
    //   508	533	147	java/lang/Exception
    //   534	544	147	java/lang/Exception
    //   0	6	214	java/lang/InterruptedException
    //   355	373	937	java/lang/Exception
    //   375	381	937	java/lang/Exception
    //   386	412	937	java/lang/Exception
    //   414	421	937	java/lang/Exception
    //   427	441	937	java/lang/Exception
    //   551	575	937	java/lang/Exception
    //   575	608	948	org/json/JSONException
    //   608	643	959	org/json/JSONException
    //   643	678	970	org/json/JSONException
    //   678	713	981	org/json/JSONException
    //   713	756	992	org/json/JSONException
    //   756	799	1003	org/json/JSONException
    //   799	842	1014	org/json/JSONException
    //   842	867	1156	java/lang/Exception
    //   874	901	1156	java/lang/Exception
    //   903	910	1156	java/lang/Exception
    //   916	930	1156	java/lang/Exception
    //   1032	1057	1156	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgi
 * JD-Core Version:    0.7.0.1
 */