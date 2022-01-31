package tmsdkdual;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import dualsim.common.OrderCheckResult;
import dualsim.common.PhoneGetResult;
import java.net.URL;

public class d
{
  private static Object mLock = new Object();
  
  private OrderCheckResult a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        synchronized (mLock)
        {
          if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
          {
            paramString1 = new OrderCheckResult(-10006);
            paramString1.subErrCode = paramInt1;
            paramString1.networkCode = paramInt2;
            return paramString1;
          }
          if (!a.b().g.getBoolean("KC_CTR_OPEN", true)) {
            continue;
          }
          long l2 = a.b().g.getLong("KC_CTR_FETCH_INTERVAL_CLOUD", -1L);
          long l1 = l2;
          if (l2 == -1L) {
            l1 = a.b().g.getLong("KC_CTR_FETCH_INTERVAL", 3600L);
          }
          String str = a.b().g.getString("KC_CTR_LAST_PHONE_NUMBER", null);
          if (((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(str))) && ((!TextUtils.isEmpty(paramString1)) || (paramString2 == null) || (!paramString2.equals(str)) || (System.currentTimeMillis() - a.b().g.getLong("KC_CTR_LAST_FETCH_TIME", 0L) >= l1 * 1000L))) {
            continue;
          }
          paramInt1 = a.b().g.getInt("KC_CTR_CODE_CACHE", 0);
          if (paramInt1 == -1) {
            continue;
          }
          if (paramInt1 != 0) {
            continue;
          }
          paramInt1 = a.b().g.getInt("KC_CTR_RESULT_CACHE", -1);
          if (paramInt1 == -1) {
            continue;
          }
          paramInt2 = c(a.b().g.getInt("KC_CTR_RESULT_PRODUCT_CACHE", 0));
          paramString1 = new OrderCheckResult();
          paramString1.errCode = 0;
          if (paramInt1 == 1)
          {
            paramBoolean = true;
            paramString1.isKingCard = paramBoolean;
            paramString1.requestParamType = 3;
            paramString1.requestParamValue = str;
            paramString1.freeType = paramInt2;
            return paramString1;
          }
        }
        paramBoolean = false;
        continue;
        if (b(paramInt1))
        {
          paramString1 = new OrderCheckResult(-10007);
          paramString1.subErrCode = paramInt1;
          return paramString1;
        }
        paramString3 = new d().a(paramString1, paramBoolean, paramString2, paramString3, paramString4);
        a.b().beginTransaction();
        a.b().a("KC_CTR_CODE_CACHE", paramString3.errCode);
        paramString4 = a.b();
        if (paramString3.isKingCard)
        {
          paramInt1 = 1;
          paramString4.a("KC_CTR_RESULT_CACHE", paramInt1);
          a.b().a("KC_CTR_RESULT_PRODUCT_CACHE", paramString3.product);
          a.b().a("KC_CTR_LAST_FETCH_TIME", System.currentTimeMillis());
          paramString4 = a.b();
          if (TextUtils.isEmpty(paramString1)) {
            break label503;
          }
          paramString4.a("KC_CTR_LAST_PHONE_NUMBER", paramString1);
          a.b().c();
          return paramString3;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1 = new OrderCheckResult(-10004);
        return paramString1;
      }
      paramInt1 = 0;
      continue;
      label503:
      paramString1 = paramString2;
    }
  }
  
  /* Error */
  private a a(URL paramURL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: sipush -10004
    //   9: istore_3
    //   10: getstatic 16	tmsdkdual/d:mLock	Ljava/lang/Object;
    //   13: astore 13
    //   15: aload 13
    //   17: monitorenter
    //   18: aload_1
    //   19: invokevirtual 160	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 162	java/net/HttpURLConnection
    //   25: astore 5
    //   27: aload 5
    //   29: ldc 164
    //   31: invokevirtual 168	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   34: aload 5
    //   36: sipush 10000
    //   39: invokevirtual 171	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   42: aload 5
    //   44: sipush 10000
    //   47: invokevirtual 174	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   50: aload 5
    //   52: invokevirtual 178	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   55: astore_1
    //   56: new 180	java/io/BufferedReader
    //   59: dup
    //   60: new 182	java/io/InputStreamReader
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore 4
    //   73: aload 5
    //   75: astore 9
    //   77: aload 4
    //   79: astore 8
    //   81: aload_1
    //   82: astore 7
    //   84: new 190	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   91: astore 6
    //   93: aload 5
    //   95: astore 9
    //   97: aload 4
    //   99: astore 8
    //   101: aload_1
    //   102: astore 7
    //   104: aload 4
    //   106: invokevirtual 195	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore 10
    //   111: aload 10
    //   113: ifnull +85 -> 198
    //   116: aload 5
    //   118: astore 9
    //   120: aload 4
    //   122: astore 8
    //   124: aload_1
    //   125: astore 7
    //   127: aload 6
    //   129: aload 10
    //   131: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: goto -42 -> 93
    //   138: astore 7
    //   140: aload 4
    //   142: astore 6
    //   144: aload 7
    //   146: astore 4
    //   148: aload 4
    //   150: invokevirtual 202	java/net/UnknownHostException:printStackTrace	()V
    //   153: aload 6
    //   155: ifnull +8 -> 163
    //   158: aload 6
    //   160: invokevirtual 205	java/io/BufferedReader:close	()V
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 208	java/io/InputStream:close	()V
    //   171: aload 5
    //   173: ifnull +912 -> 1085
    //   176: aload 5
    //   178: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   181: sipush -10001
    //   184: istore_2
    //   185: aload 13
    //   187: monitorexit
    //   188: new 6	tmsdkdual/d$a
    //   191: dup
    //   192: aload_0
    //   193: iload_2
    //   194: invokespecial 214	tmsdkdual/d$a:<init>	(Ltmsdkdual/d;I)V
    //   197: areturn
    //   198: aload 5
    //   200: astore 9
    //   202: aload 4
    //   204: astore 8
    //   206: aload_1
    //   207: astore 7
    //   209: aload 6
    //   211: invokevirtual 218	java/lang/StringBuilder:length	()I
    //   214: istore_2
    //   215: iload_2
    //   216: ifle +408 -> 624
    //   219: aload 5
    //   221: astore 9
    //   223: aload 4
    //   225: astore 8
    //   227: aload_1
    //   228: astore 7
    //   230: new 220	org/json/JSONObject
    //   233: dup
    //   234: aload 6
    //   236: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokespecial 225	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   242: astore 12
    //   244: aload 5
    //   246: astore 9
    //   248: aload 4
    //   250: astore 8
    //   252: aload_1
    //   253: astore 7
    //   255: aload 12
    //   257: ldc 227
    //   259: invokevirtual 230	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   262: istore_3
    //   263: iconst_m1
    //   264: istore_2
    //   265: aload 5
    //   267: astore 9
    //   269: aload 4
    //   271: astore 8
    //   273: aload_1
    //   274: astore 7
    //   276: aload 12
    //   278: ldc 232
    //   280: invokevirtual 236	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   283: ifne +821 -> 1104
    //   286: aload 5
    //   288: astore 9
    //   290: aload 4
    //   292: astore 8
    //   294: aload_1
    //   295: astore 7
    //   297: aload 12
    //   299: ldc 232
    //   301: invokevirtual 240	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   304: astore 6
    //   306: aload 5
    //   308: astore 9
    //   310: aload 4
    //   312: astore 8
    //   314: aload_1
    //   315: astore 7
    //   317: aload 6
    //   319: ldc 242
    //   321: invokevirtual 236	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   324: ifne +780 -> 1104
    //   327: aload 5
    //   329: astore 9
    //   331: aload 4
    //   333: astore 8
    //   335: aload_1
    //   336: astore 7
    //   338: aload 6
    //   340: ldc 242
    //   342: invokevirtual 240	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   345: astore 6
    //   347: aload 5
    //   349: astore 9
    //   351: aload 4
    //   353: astore 8
    //   355: aload_1
    //   356: astore 7
    //   358: aload 6
    //   360: ldc 243
    //   362: invokevirtual 230	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   365: istore_2
    //   366: aload 5
    //   368: astore 9
    //   370: aload 4
    //   372: astore 8
    //   374: aload_1
    //   375: astore 7
    //   377: aload 6
    //   379: ldc 245
    //   381: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore 11
    //   386: aload 5
    //   388: astore 9
    //   390: aload 4
    //   392: astore 8
    //   394: aload_1
    //   395: astore 7
    //   397: aload 6
    //   399: ldc 250
    //   401: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: astore 10
    //   406: aload 5
    //   408: astore 9
    //   410: aload 4
    //   412: astore 8
    //   414: aload_1
    //   415: astore 7
    //   417: aload 6
    //   419: ldc 252
    //   421: invokevirtual 236	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   424: ifne +674 -> 1098
    //   427: aload 5
    //   429: astore 9
    //   431: aload 4
    //   433: astore 8
    //   435: aload_1
    //   436: astore 7
    //   438: aload 6
    //   440: ldc 252
    //   442: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: astore 6
    //   447: aload 5
    //   449: astore 9
    //   451: aload 4
    //   453: astore 8
    //   455: aload_1
    //   456: astore 7
    //   458: aload 12
    //   460: ldc 254
    //   462: invokevirtual 236	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   465: ifne +627 -> 1092
    //   468: aload 5
    //   470: astore 9
    //   472: aload 4
    //   474: astore 8
    //   476: aload_1
    //   477: astore 7
    //   479: aload 12
    //   481: ldc 254
    //   483: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   486: astore 12
    //   488: aload 5
    //   490: astore 9
    //   492: aload 4
    //   494: astore 8
    //   496: aload_1
    //   497: astore 7
    //   499: new 6	tmsdkdual/d$a
    //   502: dup
    //   503: aload_0
    //   504: iconst_0
    //   505: iload_3
    //   506: iload_2
    //   507: aload 11
    //   509: aload 10
    //   511: aload 12
    //   513: invokespecial 257	tmsdkdual/d$a:<init>	(Ltmsdkdual/d;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   516: astore 10
    //   518: aload 5
    //   520: astore 9
    //   522: aload 4
    //   524: astore 8
    //   526: aload_1
    //   527: astore 7
    //   529: aload 10
    //   531: aload 6
    //   533: putfield 260	tmsdkdual/d$a:y	Ljava/lang/String;
    //   536: aload 4
    //   538: ifnull +8 -> 546
    //   541: aload 4
    //   543: invokevirtual 205	java/io/BufferedReader:close	()V
    //   546: aload_1
    //   547: ifnull +7 -> 554
    //   550: aload_1
    //   551: invokevirtual 208	java/io/InputStream:close	()V
    //   554: aload 5
    //   556: ifnull +8 -> 564
    //   559: aload 5
    //   561: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   564: aload 13
    //   566: monitorexit
    //   567: aload 10
    //   569: areturn
    //   570: astore_1
    //   571: aload 13
    //   573: monitorexit
    //   574: aload_1
    //   575: athrow
    //   576: astore 6
    //   578: aconst_null
    //   579: astore 6
    //   581: goto -134 -> 447
    //   584: astore 4
    //   586: aload 4
    //   588: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   591: goto -45 -> 546
    //   594: astore_1
    //   595: aload_1
    //   596: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   599: goto -45 -> 554
    //   602: astore 6
    //   604: aload 5
    //   606: astore 9
    //   608: aload 4
    //   610: astore 8
    //   612: aload_1
    //   613: astore 7
    //   615: aload 6
    //   617: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   620: sipush -10003
    //   623: istore_3
    //   624: aload 4
    //   626: ifnull +8 -> 634
    //   629: aload 4
    //   631: invokevirtual 205	java/io/BufferedReader:close	()V
    //   634: aload_1
    //   635: ifnull +7 -> 642
    //   638: aload_1
    //   639: invokevirtual 208	java/io/InputStream:close	()V
    //   642: iload_3
    //   643: istore_2
    //   644: aload 5
    //   646: ifnull -461 -> 185
    //   649: aload 5
    //   651: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   654: iload_3
    //   655: istore_2
    //   656: goto -471 -> 185
    //   659: astore 4
    //   661: aload 4
    //   663: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   666: goto -32 -> 634
    //   669: astore_1
    //   670: aload_1
    //   671: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   674: goto -32 -> 642
    //   677: astore 4
    //   679: aload 4
    //   681: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   684: goto -521 -> 163
    //   687: astore_1
    //   688: aload_1
    //   689: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   692: goto -521 -> 171
    //   695: astore 6
    //   697: aconst_null
    //   698: astore 4
    //   700: aconst_null
    //   701: astore_1
    //   702: aconst_null
    //   703: astore 5
    //   705: sipush -10002
    //   708: istore_3
    //   709: aload 5
    //   711: astore 9
    //   713: aload 4
    //   715: astore 8
    //   717: aload_1
    //   718: astore 7
    //   720: aload 6
    //   722: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   725: aload 4
    //   727: ifnull +8 -> 735
    //   730: aload 4
    //   732: invokevirtual 205	java/io/BufferedReader:close	()V
    //   735: aload_1
    //   736: ifnull +7 -> 743
    //   739: aload_1
    //   740: invokevirtual 208	java/io/InputStream:close	()V
    //   743: iload_3
    //   744: istore_2
    //   745: aload 5
    //   747: ifnull -562 -> 185
    //   750: aload 5
    //   752: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   755: iload_3
    //   756: istore_2
    //   757: goto -572 -> 185
    //   760: astore 4
    //   762: aload 4
    //   764: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   767: goto -32 -> 735
    //   770: astore_1
    //   771: aload_1
    //   772: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   775: goto -32 -> 743
    //   778: astore 4
    //   780: aconst_null
    //   781: astore_1
    //   782: aconst_null
    //   783: astore 5
    //   785: aload 4
    //   787: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   790: aload 6
    //   792: ifnull +8 -> 800
    //   795: aload 6
    //   797: invokevirtual 205	java/io/BufferedReader:close	()V
    //   800: aload_1
    //   801: ifnull +7 -> 808
    //   804: aload_1
    //   805: invokevirtual 208	java/io/InputStream:close	()V
    //   808: iload_3
    //   809: istore_2
    //   810: aload 5
    //   812: ifnull -627 -> 185
    //   815: aload 5
    //   817: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   820: iload_3
    //   821: istore_2
    //   822: goto -637 -> 185
    //   825: astore 4
    //   827: aload 4
    //   829: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   832: goto -32 -> 800
    //   835: astore_1
    //   836: aload_1
    //   837: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   840: goto -32 -> 808
    //   843: astore 4
    //   845: aconst_null
    //   846: astore 5
    //   848: aconst_null
    //   849: astore_1
    //   850: aconst_null
    //   851: astore 6
    //   853: aload 5
    //   855: ifnull +8 -> 863
    //   858: aload 5
    //   860: invokevirtual 205	java/io/BufferedReader:close	()V
    //   863: aload_1
    //   864: ifnull +7 -> 871
    //   867: aload_1
    //   868: invokevirtual 208	java/io/InputStream:close	()V
    //   871: aload 6
    //   873: ifnull +8 -> 881
    //   876: aload 6
    //   878: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   881: aload 4
    //   883: athrow
    //   884: astore 5
    //   886: aload 5
    //   888: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   891: goto -28 -> 863
    //   894: astore_1
    //   895: aload_1
    //   896: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   899: goto -28 -> 871
    //   902: astore 4
    //   904: aconst_null
    //   905: astore 7
    //   907: aconst_null
    //   908: astore_1
    //   909: aload 5
    //   911: astore 6
    //   913: aload 7
    //   915: astore 5
    //   917: goto -64 -> 853
    //   920: astore 4
    //   922: aconst_null
    //   923: astore 7
    //   925: aload 5
    //   927: astore 6
    //   929: aload 7
    //   931: astore 5
    //   933: goto -80 -> 853
    //   936: astore 4
    //   938: aload 9
    //   940: astore 6
    //   942: aload 8
    //   944: astore 5
    //   946: aload 7
    //   948: astore_1
    //   949: goto -96 -> 853
    //   952: astore 4
    //   954: aload 6
    //   956: astore 7
    //   958: aload 5
    //   960: astore 6
    //   962: aload 7
    //   964: astore 5
    //   966: goto -113 -> 853
    //   969: astore 4
    //   971: aload 6
    //   973: astore 7
    //   975: aload 5
    //   977: astore 6
    //   979: aload 7
    //   981: astore 5
    //   983: goto -130 -> 853
    //   986: astore 4
    //   988: aconst_null
    //   989: astore_1
    //   990: goto -205 -> 785
    //   993: astore 4
    //   995: goto -210 -> 785
    //   998: astore 7
    //   1000: aload 4
    //   1002: astore 6
    //   1004: aload 7
    //   1006: astore 4
    //   1008: goto -223 -> 785
    //   1011: astore 7
    //   1013: sipush -10003
    //   1016: istore_3
    //   1017: aload 4
    //   1019: astore 6
    //   1021: aload 7
    //   1023: astore 4
    //   1025: goto -240 -> 785
    //   1028: astore 6
    //   1030: aconst_null
    //   1031: astore 4
    //   1033: aconst_null
    //   1034: astore_1
    //   1035: goto -330 -> 705
    //   1038: astore 6
    //   1040: aconst_null
    //   1041: astore 4
    //   1043: goto -338 -> 705
    //   1046: astore 6
    //   1048: goto -343 -> 705
    //   1051: astore 4
    //   1053: aconst_null
    //   1054: astore_1
    //   1055: aconst_null
    //   1056: astore 5
    //   1058: aload 7
    //   1060: astore 6
    //   1062: goto -914 -> 148
    //   1065: astore 4
    //   1067: aconst_null
    //   1068: astore_1
    //   1069: aload 7
    //   1071: astore 6
    //   1073: goto -925 -> 148
    //   1076: astore 4
    //   1078: aload 7
    //   1080: astore 6
    //   1082: goto -934 -> 148
    //   1085: sipush -10001
    //   1088: istore_2
    //   1089: goto -904 -> 185
    //   1092: aconst_null
    //   1093: astore 12
    //   1095: goto -607 -> 488
    //   1098: aconst_null
    //   1099: astore 6
    //   1101: goto -654 -> 447
    //   1104: aconst_null
    //   1105: astore 6
    //   1107: aconst_null
    //   1108: astore 10
    //   1110: aconst_null
    //   1111: astore 11
    //   1113: goto -666 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1116	0	this	d
    //   0	1116	1	paramURL	URL
    //   184	905	2	i	int
    //   9	1008	3	j	int
    //   71	471	4	localObject1	Object
    //   584	46	4	localIOException1	java.io.IOException
    //   659	3	4	localIOException2	java.io.IOException
    //   677	3	4	localIOException3	java.io.IOException
    //   698	33	4	localObject2	Object
    //   760	3	4	localIOException4	java.io.IOException
    //   778	8	4	localException1	Exception
    //   825	3	4	localIOException5	java.io.IOException
    //   843	39	4	localObject3	Object
    //   902	1	4	localObject4	Object
    //   920	1	4	localObject5	Object
    //   936	1	4	localObject6	Object
    //   952	1	4	localObject7	Object
    //   969	1	4	localObject8	Object
    //   986	1	4	localException2	Exception
    //   993	8	4	localException3	Exception
    //   1006	36	4	localException4	Exception
    //   1051	1	4	localUnknownHostException1	java.net.UnknownHostException
    //   1065	1	4	localUnknownHostException2	java.net.UnknownHostException
    //   1076	1	4	localUnknownHostException3	java.net.UnknownHostException
    //   25	834	5	localHttpURLConnection1	java.net.HttpURLConnection
    //   884	26	5	localIOException6	java.io.IOException
    //   915	142	5	localObject9	Object
    //   1	531	6	localObject10	Object
    //   576	1	6	localException5	Exception
    //   579	1	6	localObject11	Object
    //   602	14	6	localException6	Exception
    //   695	101	6	localIOException7	java.io.IOException
    //   851	169	6	localObject12	Object
    //   1028	1	6	localIOException8	java.io.IOException
    //   1038	1	6	localIOException9	java.io.IOException
    //   1046	1	6	localIOException10	java.io.IOException
    //   1060	46	6	localObject13	Object
    //   4	122	7	localURL	URL
    //   138	7	7	localUnknownHostException4	java.net.UnknownHostException
    //   207	773	7	localObject14	Object
    //   998	7	7	localException7	Exception
    //   1011	68	7	localException8	Exception
    //   79	864	8	localObject15	Object
    //   75	864	9	localHttpURLConnection2	java.net.HttpURLConnection
    //   109	1000	10	localObject16	Object
    //   384	728	11	str	String
    //   242	852	12	localObject17	Object
    //   13	559	13	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   84	93	138	java/net/UnknownHostException
    //   104	111	138	java/net/UnknownHostException
    //   127	135	138	java/net/UnknownHostException
    //   209	215	138	java/net/UnknownHostException
    //   230	244	138	java/net/UnknownHostException
    //   255	263	138	java/net/UnknownHostException
    //   276	286	138	java/net/UnknownHostException
    //   297	306	138	java/net/UnknownHostException
    //   317	327	138	java/net/UnknownHostException
    //   338	347	138	java/net/UnknownHostException
    //   358	366	138	java/net/UnknownHostException
    //   377	386	138	java/net/UnknownHostException
    //   397	406	138	java/net/UnknownHostException
    //   417	427	138	java/net/UnknownHostException
    //   438	447	138	java/net/UnknownHostException
    //   458	468	138	java/net/UnknownHostException
    //   479	488	138	java/net/UnknownHostException
    //   499	518	138	java/net/UnknownHostException
    //   529	536	138	java/net/UnknownHostException
    //   615	620	138	java/net/UnknownHostException
    //   158	163	570	finally
    //   167	171	570	finally
    //   176	181	570	finally
    //   185	188	570	finally
    //   541	546	570	finally
    //   550	554	570	finally
    //   559	564	570	finally
    //   564	567	570	finally
    //   571	574	570	finally
    //   586	591	570	finally
    //   595	599	570	finally
    //   629	634	570	finally
    //   638	642	570	finally
    //   649	654	570	finally
    //   661	666	570	finally
    //   670	674	570	finally
    //   679	684	570	finally
    //   688	692	570	finally
    //   730	735	570	finally
    //   739	743	570	finally
    //   750	755	570	finally
    //   762	767	570	finally
    //   771	775	570	finally
    //   795	800	570	finally
    //   804	808	570	finally
    //   815	820	570	finally
    //   827	832	570	finally
    //   836	840	570	finally
    //   858	863	570	finally
    //   867	871	570	finally
    //   876	881	570	finally
    //   881	884	570	finally
    //   886	891	570	finally
    //   895	899	570	finally
    //   417	427	576	java/lang/Exception
    //   438	447	576	java/lang/Exception
    //   541	546	584	java/io/IOException
    //   550	554	594	java/io/IOException
    //   230	244	602	java/lang/Exception
    //   255	263	602	java/lang/Exception
    //   276	286	602	java/lang/Exception
    //   297	306	602	java/lang/Exception
    //   317	327	602	java/lang/Exception
    //   338	347	602	java/lang/Exception
    //   358	366	602	java/lang/Exception
    //   377	386	602	java/lang/Exception
    //   397	406	602	java/lang/Exception
    //   458	468	602	java/lang/Exception
    //   479	488	602	java/lang/Exception
    //   499	518	602	java/lang/Exception
    //   529	536	602	java/lang/Exception
    //   629	634	659	java/io/IOException
    //   638	642	669	java/io/IOException
    //   158	163	677	java/io/IOException
    //   167	171	687	java/io/IOException
    //   18	27	695	java/io/IOException
    //   730	735	760	java/io/IOException
    //   739	743	770	java/io/IOException
    //   18	27	778	java/lang/Exception
    //   795	800	825	java/io/IOException
    //   804	808	835	java/io/IOException
    //   18	27	843	finally
    //   858	863	884	java/io/IOException
    //   867	871	894	java/io/IOException
    //   27	56	902	finally
    //   56	73	920	finally
    //   84	93	936	finally
    //   104	111	936	finally
    //   127	135	936	finally
    //   209	215	936	finally
    //   230	244	936	finally
    //   255	263	936	finally
    //   276	286	936	finally
    //   297	306	936	finally
    //   317	327	936	finally
    //   338	347	936	finally
    //   358	366	936	finally
    //   377	386	936	finally
    //   397	406	936	finally
    //   417	427	936	finally
    //   438	447	936	finally
    //   458	468	936	finally
    //   479	488	936	finally
    //   499	518	936	finally
    //   529	536	936	finally
    //   615	620	936	finally
    //   720	725	936	finally
    //   148	153	952	finally
    //   785	790	969	finally
    //   27	56	986	java/lang/Exception
    //   56	73	993	java/lang/Exception
    //   84	93	998	java/lang/Exception
    //   104	111	998	java/lang/Exception
    //   127	135	998	java/lang/Exception
    //   209	215	998	java/lang/Exception
    //   615	620	1011	java/lang/Exception
    //   27	56	1028	java/io/IOException
    //   56	73	1038	java/io/IOException
    //   84	93	1046	java/io/IOException
    //   104	111	1046	java/io/IOException
    //   127	135	1046	java/io/IOException
    //   209	215	1046	java/io/IOException
    //   230	244	1046	java/io/IOException
    //   255	263	1046	java/io/IOException
    //   276	286	1046	java/io/IOException
    //   297	306	1046	java/io/IOException
    //   317	327	1046	java/io/IOException
    //   338	347	1046	java/io/IOException
    //   358	366	1046	java/io/IOException
    //   377	386	1046	java/io/IOException
    //   397	406	1046	java/io/IOException
    //   417	427	1046	java/io/IOException
    //   438	447	1046	java/io/IOException
    //   458	468	1046	java/io/IOException
    //   479	488	1046	java/io/IOException
    //   499	518	1046	java/io/IOException
    //   529	536	1046	java/io/IOException
    //   615	620	1046	java/io/IOException
    //   18	27	1051	java/net/UnknownHostException
    //   27	56	1065	java/net/UnknownHostException
    //   56	73	1076	java/net/UnknownHostException
  }
  
  private String b(String paramString1, String paramString2)
  {
    return l.b((paramString1 + "&key=" + paramString2).getBytes());
  }
  
  private boolean b(int paramInt)
  {
    Object localObject = a.b().g.getString("KC_CTR_RESULT_SETTING", null);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("off".equals(localObject))) {}
    for (;;)
    {
      return false;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("#");
        if ((localObject == null) || (localObject.length <= 0)) {
          break label118;
        }
      }
      try
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            int k = Integer.parseInt(localObject[i]);
            if (k == paramInt) {
              break;
            }
            i += 1;
            continue;
            if ((paramInt == -10001) || (paramInt == -10002) || (paramInt == 0)) {
              break;
            }
          }
        }
      }
      catch (Exception localException)
      {
        label118:
        break label118;
      }
    }
    return true;
  }
  
  public OrderCheckResult a(Context paramContext, String paramString1, String paramString2)
  {
    j = 0;
    m = 0;
    k = 0;
    for (;;)
    {
      try
      {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
          return new OrderCheckResult(-10008);
        }
        if (n.t())
        {
          localObject = new b().d();
          if (((PhoneGetResult)localObject).errorCode != 0) {
            continue;
          }
          paramContext = ((PhoneGetResult)localObject).phoneNumber;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        Context localContext;
        int i = 0;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
      }
      try
      {
        i = ((PhoneGetResult)localObject).errorCode;
        localContext = paramContext;
        k = i;
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
      }
      try
      {
        j = ((PhoneGetResult)localObject).networkCode;
        localObject = paramContext;
        if (paramContext != null)
        {
          localObject = paramContext;
          localContext = paramContext;
          k = i;
          m = j;
          if (paramContext.length() > 2)
          {
            localObject = paramContext;
            localContext = paramContext;
            k = i;
            m = j;
            if (paramContext.startsWith("86"))
            {
              localContext = paramContext;
              k = i;
              m = j;
              localObject = paramContext.substring(2);
            }
          }
        }
        paramContext = (Context)localObject;
      }
      catch (Exception paramContext)
      {
        paramContext = localException;
        i = k;
        j = m;
        continue;
      }
      m.b("SimOrderChecker", "checkOrder, imsi:" + null + ",checkingPhoneNumber:" + paramContext);
      return a(paramContext, true, null, paramString1, paramString2, i, j);
      i = -20009;
      paramContext = null;
      j = k;
    }
  }
  
  public OrderCheckResult a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    int m = 1;
    boolean bool = false;
    int j = 0;
    int i;
    if (paramBoolean)
    {
      i = 2;
      for (;;)
      {
        try
        {
          Object localObject = "code=" + paramString3;
          if (!TextUtils.isEmpty(paramString1))
          {
            paramString3 = (String)localObject + "&method=doOrderGet&phone=" + paramString1;
            paramString4 = b(paramString3, paramString4);
            paramString3 = paramString3 + "&sign=" + paramString4;
            paramString4 = a(new URL("http://market.m.qq.com/flow/order.do?" + paramString3));
            if (paramString4.result != 0) {
              break label462;
            }
            if (paramString4.y == null)
            {
              if (paramString4.product == 90063345) {
                break label467;
              }
              if (paramString4.product != 90155946) {
                break label503;
              }
              break label467;
              label186:
              if (("ACTIVESUCC".equals(paramString4.v)) || ("GOODCHG".equals(paramString4.v))) {
                break;
              }
              if (!"ORDER".equals(paramString4.v)) {
                break label509;
              }
              break;
              label231:
              j = c(paramString4.product);
              localObject = new OrderCheckResult();
              ((OrderCheckResult)localObject).isKingCard = paramBoolean;
              ((OrderCheckResult)localObject).freeType = j;
              ((OrderCheckResult)localObject).errCode = paramString4.errorCode;
              if (i != 3) {
                continue;
              }
              j = m;
              ((OrderCheckResult)localObject).requestParamType = j;
              if (TextUtils.isEmpty(paramString1)) {
                continue;
              }
              paramString3 = paramString1;
              ((OrderCheckResult)localObject).requestParamValue = paramString3;
              ((OrderCheckResult)localObject).product = paramString4.product;
              ((OrderCheckResult)localObject).cardStatus = paramString4.v;
              new e().a(paramBoolean, paramString4.result, paramString1, paramString2, i, false);
              new e().a(paramBoolean, paramString4.result, paramString1, paramString2, i);
              return localObject;
            }
          }
          else
          {
            paramString3 = (String)localObject;
            if (paramString2 == null) {
              continue;
            }
            paramString3 = (String)localObject + "&imsi=" + paramString2 + "&method=doOrderGet";
            i = 3;
            continue;
          }
          paramBoolean = "true".equals(paramString4.y);
          continue;
          j = 2;
          continue;
          paramString3 = paramString2;
          continue;
          paramBoolean = false;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return new OrderCheckResult(-10004);
        }
        label462:
        continue;
        label467:
        j = 1;
      }
    }
    label503:
    label509:
    for (int k = 1;; k = 0)
    {
      paramBoolean = bool;
      if (j != 0)
      {
        paramBoolean = bool;
        if (k != 0) {
          paramBoolean = true;
        }
      }
      break label231;
      i = 1;
      break;
      j = 0;
      break label186;
    }
  }
  
  public int c(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = a.b().g.getString("kc_f_t_k", null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label206;
        }
        localObject = ((String)localObject).split(",");
        int j;
        if ((localObject != null) && (localObject.length > 0))
        {
          j = localObject.length;
          i = 0;
          if (i < j)
          {
            if (Integer.parseInt(localObject[i]) != paramInt) {
              break label199;
            }
            return 1;
          }
        }
        localObject = a.b().g.getString("kc_f_t_u_p", null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(",");
          if ((localObject != null) && (localObject.length > 0))
          {
            j = localObject.length;
            i = 0;
            if (i < j)
            {
              int k = Integer.parseInt(localObject[i]);
              if (k == paramInt) {
                return 2;
              }
              i += 1;
              continue;
            }
          }
        }
        else
        {
          switch (paramInt)
          {
          }
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
        return 1;
      }
      return 0;
      return 2;
      label199:
      i += 1;
      continue;
      label206:
      switch (paramInt)
      {
      }
    }
  }
  
  public class a
  {
    public int errorCode;
    public int product;
    public int result = -1;
    public String v;
    public String w;
    public String x;
    public String y;
    
    public a(int paramInt)
    {
      this.errorCode = paramInt;
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
    {
      this.result = paramInt2;
      this.product = paramInt3;
      this.v = paramString1;
      this.w = paramString2;
      this.x = paramString3;
      this.errorCode = paramInt1;
    }
    
    public String toString()
    {
      return "[OrderResultEntry] result:" + this.result + ",product:" + this.product + ",stateTag:" + this.v + ",stateTime:" + this.w + ",msg:" + this.x + ",isFreeFlow:" + this.y;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.d
 * JD-Core Version:    0.7.0.1
 */