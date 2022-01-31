package tmsdkdual;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tmsdk.dual.TMSDualSDKContext;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackCommon;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;

public class i
{
  private static long a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    long l1 = 0L;
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      long l2 = paramFile[i].lastModified();
      if (l2 > l1) {
        l1 = l2;
      }
      for (;;)
      {
        i += 1;
        break;
      }
    }
    return l1;
  }
  
  /* Error */
  public static void e(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: lookupswitch	default:+36->40, 139:+535->539, 141:+40->44, 163:+163->167
    //   41: iconst_m1
    //   42: monitorexit
    //   43: return
    //   44: invokestatic 35	tmsdkdual/i:j	()Ljava/util/ArrayList;
    //   47: astore 6
    //   49: aload 6
    //   51: ifnull -11 -> 40
    //   54: aload 6
    //   56: invokevirtual 41	java/util/ArrayList:size	()I
    //   59: ifle -19 -> 40
    //   62: new 43	java/util/HashMap
    //   65: dup
    //   66: invokespecial 47	java/util/HashMap:<init>	()V
    //   69: astore 5
    //   71: aload 6
    //   73: invokevirtual 51	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   76: astore 6
    //   78: aload 6
    //   80: invokeinterface 57 1 0
    //   85: ifeq +56 -> 141
    //   88: aload 6
    //   90: invokeinterface 61 1 0
    //   95: checkcast 14	tmsdkdual/i$a
    //   98: astore 7
    //   100: aload 5
    //   102: iconst_1
    //   103: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aload 7
    //   108: getfield 71	tmsdkdual/i$a:J	Ljava/lang/String;
    //   111: invokeinterface 77 3 0
    //   116: pop
    //   117: aload 5
    //   119: bipush 7
    //   121: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aload 7
    //   126: getfield 80	tmsdkdual/i$a:time	J
    //   129: invokestatic 85	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   132: invokeinterface 77 3 0
    //   137: pop
    //   138: goto -60 -> 78
    //   141: sipush 141
    //   144: aload 5
    //   146: new 6	tmsdkdual/i$1
    //   149: dup
    //   150: invokespecial 86	tmsdkdual/i$1:<init>	()V
    //   153: invokestatic 92	com/tmsdk/dual/sharkcpp/SharkCppProxy:unifiedReportAsyn	(ILjava/util/Map;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   156: goto -116 -> 40
    //   159: astore 5
    //   161: ldc 2
    //   163: monitorexit
    //   164: aload 5
    //   166: athrow
    //   167: invokestatic 95	tmsdkdual/i:k	()V
    //   170: invokestatic 99	tmsdkdual/i:getPath	()Ljava/lang/String;
    //   173: invokestatic 104	tmsdkdual/h:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   176: astore 5
    //   178: aload 5
    //   180: ifnull -140 -> 40
    //   183: aload 5
    //   185: invokevirtual 107	java/util/ArrayList:isEmpty	()Z
    //   188: ifne -148 -> 40
    //   191: new 109	org/json/JSONArray
    //   194: dup
    //   195: aload 5
    //   197: iconst_0
    //   198: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   201: checkcast 82	java/lang/String
    //   204: invokespecial 116	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   207: astore 6
    //   209: new 109	org/json/JSONArray
    //   212: dup
    //   213: invokespecial 117	org/json/JSONArray:<init>	()V
    //   216: astore 7
    //   218: aload 6
    //   220: invokevirtual 120	org/json/JSONArray:length	()I
    //   223: ifle -183 -> 40
    //   226: invokestatic 126	tmsdkdual/k:q	()Ltmsdkdual/k;
    //   229: iconst_1
    //   230: iconst_0
    //   231: invokevirtual 129	tmsdkdual/k:a	(II)Ljava/util/ArrayList;
    //   234: astore 8
    //   236: aload 8
    //   238: ifnull -198 -> 40
    //   241: aload 8
    //   243: invokevirtual 41	java/util/ArrayList:size	()I
    //   246: ifle -206 -> 40
    //   249: new 43	java/util/HashMap
    //   252: dup
    //   253: invokespecial 47	java/util/HashMap:<init>	()V
    //   256: astore 9
    //   258: iconst_0
    //   259: istore_0
    //   260: aload 6
    //   262: invokevirtual 120	org/json/JSONArray:length	()I
    //   265: istore_1
    //   266: iload_0
    //   267: iload_1
    //   268: if_icmpge +246 -> 514
    //   271: aload 6
    //   273: iload_0
    //   274: invokevirtual 130	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   277: checkcast 132	org/json/JSONObject
    //   280: astore 10
    //   282: aload 10
    //   284: ldc 134
    //   286: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   289: istore_1
    //   290: aload 10
    //   292: ldc 140
    //   294: invokevirtual 144	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   297: lstore_2
    //   298: aload 8
    //   300: invokevirtual 51	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   303: astore 5
    //   305: aload 5
    //   307: invokeinterface 57 1 0
    //   312: ifeq +306 -> 618
    //   315: aload 5
    //   317: invokeinterface 61 1 0
    //   322: checkcast 146	tmsdkdual/j
    //   325: astore 11
    //   327: aload 11
    //   329: ldc 134
    //   331: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   334: checkcast 63	java/lang/Integer
    //   337: astore 12
    //   339: aload 12
    //   341: ifnull -36 -> 305
    //   344: aload 12
    //   346: invokevirtual 152	java/lang/Integer:intValue	()I
    //   349: iload_1
    //   350: if_icmpne -45 -> 305
    //   353: aload 11
    //   355: ldc 154
    //   357: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   360: checkcast 82	java/lang/String
    //   363: astore 5
    //   365: aload 11
    //   367: ldc 156
    //   369: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   372: checkcast 158	java/lang/Boolean
    //   375: astore 11
    //   377: aload 11
    //   379: ifnonnull +17 -> 396
    //   382: iconst_0
    //   383: istore 4
    //   385: aload 5
    //   387: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   390: ifeq +16 -> 406
    //   393: goto +240 -> 633
    //   396: aload 11
    //   398: invokevirtual 166	java/lang/Boolean:booleanValue	()Z
    //   401: istore 4
    //   403: goto -18 -> 385
    //   406: aload 10
    //   408: ldc 140
    //   410: iconst_0
    //   411: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   414: pop
    //   415: lload_2
    //   416: lconst_0
    //   417: lcmp
    //   418: ifle +215 -> 633
    //   421: aload 7
    //   423: aload 10
    //   425: invokevirtual 172	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   428: pop
    //   429: aload 9
    //   431: bipush 8
    //   433: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   439: invokestatic 85	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   442: invokeinterface 77 3 0
    //   447: pop
    //   448: aload 9
    //   450: bipush 9
    //   452: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: lload_2
    //   456: invokestatic 85	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   459: invokeinterface 77 3 0
    //   464: pop
    //   465: aload 9
    //   467: bipush 10
    //   469: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: aload 5
    //   474: invokeinterface 77 3 0
    //   479: pop
    //   480: iload 4
    //   482: ifeq +25 -> 507
    //   485: ldc 179
    //   487: astore 5
    //   489: aload 9
    //   491: bipush 11
    //   493: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aload 5
    //   498: invokeinterface 77 3 0
    //   503: pop
    //   504: goto +129 -> 633
    //   507: ldc 181
    //   509: astore 5
    //   511: goto -22 -> 489
    //   514: sipush 163
    //   517: aload 9
    //   519: new 8	tmsdkdual/i$2
    //   522: dup
    //   523: aload 7
    //   525: invokespecial 184	tmsdkdual/i$2:<init>	(Lorg/json/JSONArray;)V
    //   528: invokestatic 92	com/tmsdk/dual/sharkcpp/SharkCppProxy:unifiedReportAsyn	(ILjava/util/Map;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   531: goto -491 -> 40
    //   534: astore 5
    //   536: goto -496 -> 40
    //   539: invokestatic 188	tmsdkdual/i:n	()Ltmsdkdual/i$a;
    //   542: astore 5
    //   544: aload 5
    //   546: ifnull -506 -> 40
    //   549: new 43	java/util/HashMap
    //   552: dup
    //   553: invokespecial 47	java/util/HashMap:<init>	()V
    //   556: astore 6
    //   558: aload 6
    //   560: iconst_1
    //   561: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aload 5
    //   566: getfield 71	tmsdkdual/i$a:J	Ljava/lang/String;
    //   569: invokeinterface 77 3 0
    //   574: pop
    //   575: aload 6
    //   577: iconst_2
    //   578: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aload 5
    //   583: getfield 80	tmsdkdual/i$a:time	J
    //   586: invokestatic 85	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   589: invokeinterface 77 3 0
    //   594: pop
    //   595: sipush 139
    //   598: aload 6
    //   600: new 10	tmsdkdual/i$3
    //   603: dup
    //   604: invokespecial 189	tmsdkdual/i$3:<init>	()V
    //   607: invokestatic 92	com/tmsdk/dual/sharkcpp/SharkCppProxy:unifiedReportAsyn	(ILjava/util/Map;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   610: goto -570 -> 40
    //   613: astore 5
    //   615: goto -575 -> 40
    //   618: iconst_0
    //   619: istore 4
    //   621: ldc 191
    //   623: astore 5
    //   625: goto -240 -> 385
    //   628: astore 5
    //   630: goto -590 -> 40
    //   633: iload_0
    //   634: iconst_1
    //   635: iadd
    //   636: istore_0
    //   637: goto -377 -> 260
    //   640: astore 5
    //   642: goto -9 -> 633
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	paramInt	int
    //   265	86	1	i	int
    //   297	159	2	l	long
    //   383	237	4	bool	boolean
    //   69	76	5	localHashMap1	java.util.HashMap
    //   159	6	5	localObject1	Object
    //   176	334	5	localObject2	Object
    //   534	1	5	localThrowable1	Throwable
    //   542	40	5	locala	a
    //   613	1	5	localThrowable2	Throwable
    //   623	1	5	str	String
    //   628	1	5	localThrowable3	Throwable
    //   640	1	5	localThrowable4	Throwable
    //   47	552	6	localObject3	Object
    //   98	426	7	localObject4	Object
    //   234	65	8	localArrayList	ArrayList
    //   256	262	9	localHashMap2	java.util.HashMap
    //   280	144	10	localJSONObject	org.json.JSONObject
    //   325	72	11	localObject5	Object
    //   337	8	12	localInteger	java.lang.Integer
    // Exception table:
    //   from	to	target	type
    //   44	49	159	finally
    //   54	78	159	finally
    //   78	138	159	finally
    //   141	156	159	finally
    //   167	178	159	finally
    //   183	236	159	finally
    //   241	258	159	finally
    //   260	266	159	finally
    //   271	305	159	finally
    //   305	339	159	finally
    //   344	377	159	finally
    //   385	393	159	finally
    //   396	403	159	finally
    //   406	415	159	finally
    //   421	480	159	finally
    //   489	504	159	finally
    //   514	531	159	finally
    //   539	544	159	finally
    //   549	610	159	finally
    //   167	178	534	java/lang/Throwable
    //   183	236	534	java/lang/Throwable
    //   241	258	534	java/lang/Throwable
    //   260	266	534	java/lang/Throwable
    //   514	531	534	java/lang/Throwable
    //   539	544	613	java/lang/Throwable
    //   549	610	613	java/lang/Throwable
    //   44	49	628	java/lang/Throwable
    //   54	78	628	java/lang/Throwable
    //   78	138	628	java/lang/Throwable
    //   141	156	628	java/lang/Throwable
    //   271	305	640	java/lang/Throwable
    //   305	339	640	java/lang/Throwable
    //   344	377	640	java/lang/Throwable
    //   385	393	640	java/lang/Throwable
    //   396	403	640	java/lang/Throwable
    //   406	415	640	java/lang/Throwable
    //   421	480	640	java/lang/Throwable
    //   489	504	640	java/lang/Throwable
  }
  
  public static String getPath()
  {
    return TMSDualSDKContext.getApplicaionContext().getFilesDir().getAbsolutePath() + File.separator + "d_" + 163;
  }
  
  private static ArrayList<a> j()
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/");
      if (!((File)localObject).exists()) {
        return localArrayList;
      }
      localObject = ((File)localObject).listFiles();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = localObject[i];
        if (localFile.getName().length() == 32)
        {
          a locala = new a();
          locala.J = localFile.getName();
          locala.time = (a(localFile) / 1000L);
          localArrayList.add(locala);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  public static void k()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 255	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   6: invokeinterface 261 1 0
    //   11: ldc_w 263
    //   14: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   17: ldc2_w 244
    //   20: ldiv
    //   21: invokeinterface 269 4 0
    //   26: invokeinterface 272 1 0
    //   31: invokestatic 276	tmsdkdual/i:m	()Ljava/util/Map;
    //   34: astore 12
    //   36: aload 12
    //   38: invokeinterface 277 1 0
    //   43: istore 4
    //   45: iload 4
    //   47: ifeq +7 -> 54
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: invokestatic 99	tmsdkdual/i:getPath	()Ljava/lang/String;
    //   57: invokestatic 104	tmsdkdual/h:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   60: astore 11
    //   62: aload 11
    //   64: invokevirtual 41	java/util/ArrayList:size	()I
    //   67: ifle +261 -> 328
    //   70: new 109	org/json/JSONArray
    //   73: dup
    //   74: aload 11
    //   76: iconst_0
    //   77: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 82	java/lang/String
    //   83: invokespecial 116	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   86: astore 11
    //   88: iconst_0
    //   89: istore_1
    //   90: invokestatic 280	tmsdkdual/h:i	()Z
    //   93: istore 4
    //   95: getstatic 255	tmsdkdual/h:H	Landroid/content/SharedPreferences;
    //   98: ldc_w 263
    //   101: ldc2_w 281
    //   104: invokeinterface 285 4 0
    //   109: lconst_0
    //   110: lcmp
    //   111: ifgt +299 -> 410
    //   114: iconst_1
    //   115: istore_2
    //   116: aload 12
    //   118: invokeinterface 289 1 0
    //   123: invokeinterface 292 1 0
    //   128: astore 13
    //   130: aload 13
    //   132: invokeinterface 57 1 0
    //   137: ifeq +245 -> 382
    //   140: aload 13
    //   142: invokeinterface 61 1 0
    //   147: checkcast 63	java/lang/Integer
    //   150: astore 14
    //   152: aload 14
    //   154: invokevirtual 152	java/lang/Integer:intValue	()I
    //   157: istore_3
    //   158: aload 12
    //   160: aload 14
    //   162: invokeinterface 295 2 0
    //   167: checkcast 297	java/lang/Long
    //   170: invokevirtual 300	java/lang/Long:longValue	()J
    //   173: lstore 5
    //   175: iconst_0
    //   176: istore_0
    //   177: iload_1
    //   178: ifne +84 -> 262
    //   181: iconst_0
    //   182: istore_0
    //   183: iload_0
    //   184: aload 11
    //   186: invokevirtual 120	org/json/JSONArray:length	()I
    //   189: if_icmpge +218 -> 407
    //   192: aload 11
    //   194: iload_0
    //   195: invokevirtual 130	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   198: checkcast 132	org/json/JSONObject
    //   201: astore 14
    //   203: aload 14
    //   205: ldc 134
    //   207: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   210: iload_3
    //   211: if_icmpne +209 -> 420
    //   214: aload 14
    //   216: ldc_w 302
    //   219: invokevirtual 144	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   222: lstore 7
    //   224: aload 14
    //   226: ldc 140
    //   228: invokevirtual 144	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   231: lstore 9
    //   233: aload 14
    //   235: ldc_w 302
    //   238: lload 5
    //   240: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   243: pop
    //   244: iload 4
    //   246: ifeq +96 -> 342
    //   249: aload 14
    //   251: ldc 140
    //   253: lload 9
    //   255: lload 5
    //   257: ladd
    //   258: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   261: pop
    //   262: iload_1
    //   263: ifne +12 -> 275
    //   266: iload_0
    //   267: aload 11
    //   269: invokevirtual 120	org/json/JSONArray:length	()I
    //   272: if_icmplt -142 -> 130
    //   275: new 132	org/json/JSONObject
    //   278: dup
    //   279: invokespecial 306	org/json/JSONObject:<init>	()V
    //   282: astore 14
    //   284: aload 14
    //   286: ldc 134
    //   288: iload_3
    //   289: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 14
    //   295: ldc_w 302
    //   298: lload 5
    //   300: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   303: pop
    //   304: iload_2
    //   305: ifeq +56 -> 361
    //   308: aload 14
    //   310: ldc 140
    //   312: iconst_0
    //   313: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload 11
    //   319: aload 14
    //   321: invokevirtual 172	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   324: pop
    //   325: goto -195 -> 130
    //   328: new 109	org/json/JSONArray
    //   331: dup
    //   332: invokespecial 117	org/json/JSONArray:<init>	()V
    //   335: astore 11
    //   337: iconst_1
    //   338: istore_1
    //   339: goto -249 -> 90
    //   342: aload 14
    //   344: ldc 140
    //   346: lload 9
    //   348: lload 5
    //   350: ladd
    //   351: lload 7
    //   353: lsub
    //   354: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   357: pop
    //   358: goto -96 -> 262
    //   361: aload 14
    //   363: ldc 140
    //   365: lload 5
    //   367: invokevirtual 305	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   370: pop
    //   371: goto -54 -> 317
    //   374: astore 11
    //   376: ldc 2
    //   378: monitorexit
    //   379: aload 11
    //   381: athrow
    //   382: aload 11
    //   384: invokevirtual 120	org/json/JSONArray:length	()I
    //   387: ifle -337 -> 50
    //   390: aload 11
    //   392: invokevirtual 307	org/json/JSONArray:toString	()Ljava/lang/String;
    //   395: invokestatic 99	tmsdkdual/i:getPath	()Ljava/lang/String;
    //   398: sipush 163
    //   401: invokestatic 310	tmsdkdual/h:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   404: goto -354 -> 50
    //   407: goto -145 -> 262
    //   410: iconst_0
    //   411: istore_2
    //   412: goto -296 -> 116
    //   415: astore 11
    //   417: goto -367 -> 50
    //   420: iload_0
    //   421: iconst_1
    //   422: iadd
    //   423: istore_0
    //   424: goto -241 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   176	248	0	i	int
    //   89	250	1	j	int
    //   115	297	2	k	int
    //   157	132	3	m	int
    //   43	202	4	bool	boolean
    //   173	193	5	l1	long
    //   222	130	7	l2	long
    //   231	116	9	l3	long
    //   60	276	11	localObject1	Object
    //   374	17	11	localObject2	Object
    //   415	1	11	localThrowable	Throwable
    //   34	125	12	localMap	java.util.Map
    //   128	13	13	localIterator	java.util.Iterator
    //   150	212	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	45	374	finally
    //   54	88	374	finally
    //   90	114	374	finally
    //   116	130	374	finally
    //   130	175	374	finally
    //   183	244	374	finally
    //   249	262	374	finally
    //   266	275	374	finally
    //   275	304	374	finally
    //   308	317	374	finally
    //   317	325	374	finally
    //   328	337	374	finally
    //   342	358	374	finally
    //   361	371	374	finally
    //   382	404	374	finally
    //   3	45	415	java/lang/Throwable
    //   54	88	415	java/lang/Throwable
    //   90	114	415	java/lang/Throwable
    //   116	130	415	java/lang/Throwable
    //   130	175	415	java/lang/Throwable
    //   183	244	415	java/lang/Throwable
    //   249	262	415	java/lang/Throwable
    //   266	275	415	java/lang/Throwable
    //   275	304	415	java/lang/Throwable
    //   308	317	415	java/lang/Throwable
    //   317	325	415	java/lang/Throwable
    //   328	337	415	java/lang/Throwable
    //   342	358	415	java/lang/Throwable
    //   361	371	415	java/lang/Throwable
    //   382	404	415	java/lang/Throwable
  }
  
  /* Error */
  public static void l()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 95	tmsdkdual/i:k	()V
    //   6: invokestatic 99	tmsdkdual/i:getPath	()Ljava/lang/String;
    //   9: invokestatic 104	tmsdkdual/h:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnull +13 -> 29
    //   19: aload 5
    //   21: invokevirtual 107	java/util/ArrayList:isEmpty	()Z
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq +7 -> 33
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: new 109	org/json/JSONArray
    //   36: dup
    //   37: aload 5
    //   39: iconst_0
    //   40: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   43: checkcast 82	java/lang/String
    //   46: invokespecial 116	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   49: astore 6
    //   51: new 109	org/json/JSONArray
    //   54: dup
    //   55: invokespecial 117	org/json/JSONArray:<init>	()V
    //   58: astore 7
    //   60: aload 6
    //   62: invokevirtual 120	org/json/JSONArray:length	()I
    //   65: ifle -36 -> 29
    //   68: invokestatic 126	tmsdkdual/k:q	()Ltmsdkdual/k;
    //   71: iconst_1
    //   72: iconst_0
    //   73: invokevirtual 129	tmsdkdual/k:a	(II)Ljava/util/ArrayList;
    //   76: astore 8
    //   78: aload 8
    //   80: ifnull -51 -> 29
    //   83: aload 8
    //   85: invokevirtual 41	java/util/ArrayList:size	()I
    //   88: ifle -59 -> 29
    //   91: new 37	java/util/ArrayList
    //   94: dup
    //   95: invokespecial 225	java/util/ArrayList:<init>	()V
    //   98: astore 9
    //   100: iconst_0
    //   101: istore_0
    //   102: aload 6
    //   104: invokevirtual 120	org/json/JSONArray:length	()I
    //   107: istore_1
    //   108: iload_0
    //   109: iload_1
    //   110: if_icmpge +262 -> 372
    //   113: new 43	java/util/HashMap
    //   116: dup
    //   117: invokespecial 47	java/util/HashMap:<init>	()V
    //   120: astore 10
    //   122: aload 6
    //   124: iload_0
    //   125: invokevirtual 130	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   128: checkcast 132	org/json/JSONObject
    //   131: astore 11
    //   133: aload 11
    //   135: ldc 134
    //   137: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   140: istore_1
    //   141: aload 11
    //   143: ldc 140
    //   145: invokevirtual 144	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   148: lstore_3
    //   149: aload 8
    //   151: invokevirtual 51	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   154: astore 5
    //   156: aload 5
    //   158: invokeinterface 57 1 0
    //   163: ifeq +242 -> 405
    //   166: aload 5
    //   168: invokeinterface 61 1 0
    //   173: checkcast 146	tmsdkdual/j
    //   176: astore 12
    //   178: aload 12
    //   180: ldc 134
    //   182: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   185: checkcast 63	java/lang/Integer
    //   188: astore 13
    //   190: aload 13
    //   192: ifnull -36 -> 156
    //   195: aload 13
    //   197: invokevirtual 152	java/lang/Integer:intValue	()I
    //   200: iload_1
    //   201: if_icmpne -45 -> 156
    //   204: aload 12
    //   206: ldc 154
    //   208: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   211: checkcast 82	java/lang/String
    //   214: astore 5
    //   216: aload 12
    //   218: ldc 156
    //   220: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   223: checkcast 158	java/lang/Boolean
    //   226: astore 12
    //   228: aload 12
    //   230: ifnonnull +16 -> 246
    //   233: iconst_0
    //   234: istore_2
    //   235: aload 5
    //   237: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifeq +15 -> 255
    //   243: goto +171 -> 414
    //   246: aload 12
    //   248: invokevirtual 166	java/lang/Boolean:booleanValue	()Z
    //   251: istore_2
    //   252: goto -17 -> 235
    //   255: aload 11
    //   257: ldc 140
    //   259: iconst_0
    //   260: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   263: pop
    //   264: lload_3
    //   265: lconst_0
    //   266: lcmp
    //   267: ifle +147 -> 414
    //   270: aload 7
    //   272: aload 11
    //   274: invokevirtual 172	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   277: pop
    //   278: aload 10
    //   280: bipush 8
    //   282: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   288: invokestatic 85	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   291: invokeinterface 77 3 0
    //   296: pop
    //   297: aload 10
    //   299: bipush 9
    //   301: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: lload_3
    //   305: invokestatic 85	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokeinterface 77 3 0
    //   313: pop
    //   314: aload 10
    //   316: bipush 10
    //   318: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aload 5
    //   323: invokeinterface 77 3 0
    //   328: pop
    //   329: iload_2
    //   330: ifeq +35 -> 365
    //   333: ldc 179
    //   335: astore 5
    //   337: aload 10
    //   339: bipush 11
    //   341: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aload 5
    //   346: invokeinterface 77 3 0
    //   351: pop
    //   352: aload 9
    //   354: aload 10
    //   356: invokeinterface 314 2 0
    //   361: pop
    //   362: goto +52 -> 414
    //   365: ldc 181
    //   367: astore 5
    //   369: goto -32 -> 337
    //   372: sipush 163
    //   375: aload 9
    //   377: new 12	tmsdkdual/i$4
    //   380: dup
    //   381: aload 7
    //   383: invokespecial 315	tmsdkdual/i$4:<init>	(Lorg/json/JSONArray;)V
    //   386: invokestatic 319	com/tmsdk/dual/sharkcpp/SharkCppProxy:unifiedReportListAsyn	(ILjava/util/List;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   389: goto -360 -> 29
    //   392: astore 5
    //   394: goto -365 -> 29
    //   397: astore 5
    //   399: ldc 2
    //   401: monitorexit
    //   402: aload 5
    //   404: athrow
    //   405: iconst_0
    //   406: istore_2
    //   407: ldc 191
    //   409: astore 5
    //   411: goto -176 -> 235
    //   414: iload_0
    //   415: iconst_1
    //   416: iadd
    //   417: istore_0
    //   418: goto -316 -> 102
    //   421: astore 5
    //   423: goto -9 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   101	317	0	i	int
    //   107	95	1	j	int
    //   24	383	2	bool	boolean
    //   148	157	3	l	long
    //   12	356	5	localObject1	Object
    //   392	1	5	localThrowable1	Throwable
    //   397	6	5	localObject2	Object
    //   409	1	5	str	String
    //   421	1	5	localThrowable2	Throwable
    //   49	74	6	localJSONArray1	JSONArray
    //   58	324	7	localJSONArray2	JSONArray
    //   76	74	8	localArrayList1	ArrayList
    //   98	278	9	localArrayList2	ArrayList
    //   120	235	10	localHashMap	java.util.HashMap
    //   131	142	11	localJSONObject	org.json.JSONObject
    //   176	71	12	localObject3	Object
    //   188	8	13	localInteger	java.lang.Integer
    // Exception table:
    //   from	to	target	type
    //   3	14	392	java/lang/Throwable
    //   19	25	392	java/lang/Throwable
    //   33	78	392	java/lang/Throwable
    //   83	100	392	java/lang/Throwable
    //   102	108	392	java/lang/Throwable
    //   372	389	392	java/lang/Throwable
    //   3	14	397	finally
    //   19	25	397	finally
    //   33	78	397	finally
    //   83	100	397	finally
    //   102	108	397	finally
    //   113	156	397	finally
    //   156	190	397	finally
    //   195	228	397	finally
    //   235	243	397	finally
    //   246	252	397	finally
    //   255	264	397	finally
    //   270	329	397	finally
    //   337	362	397	finally
    //   372	389	397	finally
    //   113	156	421	java/lang/Throwable
    //   156	190	421	java/lang/Throwable
    //   195	228	421	java/lang/Throwable
    //   235	243	421	java/lang/Throwable
    //   246	252	421	java/lang/Throwable
    //   255	264	421	java/lang/Throwable
    //   270	329	421	java/lang/Throwable
    //   337	362	421	java/lang/Throwable
  }
  
  /* Error */
  private static java.util.Map<java.lang.Integer, java.lang.Long> m()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 43	java/util/HashMap
    //   6: dup
    //   7: invokespecial 47	java/util/HashMap:<init>	()V
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 9
    //   18: new 321	java/io/FileReader
    //   21: dup
    //   22: ldc_w 323
    //   25: invokespecial 324	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   28: astore 7
    //   30: new 326	java/io/BufferedReader
    //   33: dup
    //   34: aload 7
    //   36: invokespecial 329	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore 8
    //   41: aload 8
    //   43: invokevirtual 332	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 9
    //   48: aload 9
    //   50: ifnull +136 -> 186
    //   53: aload 9
    //   55: invokevirtual 335	java/lang/String:trim	()Ljava/lang/String;
    //   58: ldc_w 337
    //   61: invokevirtual 341	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore 9
    //   66: aload 9
    //   68: iconst_4
    //   69: aaload
    //   70: invokestatic 344	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   73: iconst_1
    //   74: if_icmpne -33 -> 41
    //   77: aload 9
    //   79: iconst_3
    //   80: aaload
    //   81: invokestatic 344	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   84: istore_0
    //   85: iload_0
    //   86: ldc_w 345
    //   89: irem
    //   90: sipush 1000
    //   93: if_icmpeq -52 -> 41
    //   96: iload_0
    //   97: ifeq -56 -> 41
    //   100: aload 9
    //   102: iconst_5
    //   103: aaload
    //   104: invokestatic 348	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   107: aload 9
    //   109: bipush 7
    //   111: aaload
    //   112: invokestatic 348	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   115: ladd
    //   116: lstore 5
    //   118: lload 5
    //   120: lstore_3
    //   121: aload 11
    //   123: iload_0
    //   124: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokeinterface 295 2 0
    //   132: ifnull +24 -> 156
    //   135: lload 5
    //   137: aload 11
    //   139: iload_0
    //   140: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokeinterface 295 2 0
    //   148: checkcast 297	java/lang/Long
    //   151: invokevirtual 300	java/lang/Long:longValue	()J
    //   154: ladd
    //   155: lstore_3
    //   156: lload_3
    //   157: lconst_0
    //   158: lcmp
    //   159: ifle -118 -> 41
    //   162: aload 11
    //   164: iload_0
    //   165: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: lload_3
    //   169: invokestatic 351	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   172: invokeinterface 77 3 0
    //   177: pop
    //   178: goto -137 -> 41
    //   181: astore 9
    //   183: goto -142 -> 41
    //   186: aload 7
    //   188: ifnull +8 -> 196
    //   191: aload 7
    //   193: invokevirtual 354	java/io/FileReader:close	()V
    //   196: aload 8
    //   198: ifnull +8 -> 206
    //   201: aload 8
    //   203: invokevirtual 355	java/io/BufferedReader:close	()V
    //   206: aload 8
    //   208: astore 9
    //   210: aload 7
    //   212: astore 8
    //   214: aload 9
    //   216: astore 7
    //   218: invokestatic 200	com/tmsdk/dual/TMSDualSDKContext:getApplicaionContext	()Landroid/content/Context;
    //   221: invokevirtual 359	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   224: getfield 364	android/content/pm/ApplicationInfo:uid	I
    //   227: istore_2
    //   228: iconst_0
    //   229: istore_0
    //   230: iconst_0
    //   231: istore_1
    //   232: aload 11
    //   234: invokeinterface 365 1 0
    //   239: ifne +436 -> 675
    //   242: iconst_1
    //   243: istore_1
    //   244: iload_1
    //   245: ifeq +699 -> 944
    //   248: invokestatic 126	tmsdkdual/k:q	()Ltmsdkdual/k;
    //   251: iconst_1
    //   252: iconst_0
    //   253: invokevirtual 129	tmsdkdual/k:a	(II)Ljava/util/ArrayList;
    //   256: invokevirtual 51	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   259: astore 10
    //   261: aload 8
    //   263: astore 9
    //   265: aload 7
    //   267: astore 8
    //   269: aload 10
    //   271: invokeinterface 57 1 0
    //   276: ifeq +668 -> 944
    //   279: aload 10
    //   281: invokeinterface 61 1 0
    //   286: checkcast 146	tmsdkdual/j
    //   289: ldc 134
    //   291: invokevirtual 149	tmsdkdual/j:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   294: checkcast 63	java/lang/Integer
    //   297: astore 7
    //   299: aload 7
    //   301: ifnonnull +433 -> 734
    //   304: iconst_0
    //   305: istore_0
    //   306: iload_0
    //   307: ldc_w 345
    //   310: irem
    //   311: sipush 1000
    //   314: if_icmpeq -45 -> 269
    //   317: iload_0
    //   318: ifeq -49 -> 269
    //   321: lconst_0
    //   322: lstore 5
    //   324: new 193	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 367
    //   334: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: iload_0
    //   338: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc_w 369
    //   344: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 7
    //   352: new 321	java/io/FileReader
    //   355: dup
    //   356: aload 7
    //   358: invokespecial 324	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   361: astore 7
    //   363: new 326	java/io/BufferedReader
    //   366: dup
    //   367: aload 7
    //   369: invokespecial 329	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   372: astore 9
    //   374: aload 9
    //   376: invokevirtual 332	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   379: astore 8
    //   381: lload 5
    //   383: lstore_3
    //   384: aload 8
    //   386: ifnull +9 -> 395
    //   389: aload 8
    //   391: invokestatic 348	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   394: lstore_3
    //   395: aload 7
    //   397: ifnull +8 -> 405
    //   400: aload 7
    //   402: invokevirtual 354	java/io/FileReader:close	()V
    //   405: aload 9
    //   407: ifnull +8 -> 415
    //   410: aload 9
    //   412: invokevirtual 355	java/io/BufferedReader:close	()V
    //   415: aload 7
    //   417: astore 8
    //   419: aload 9
    //   421: astore 7
    //   423: new 193	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 367
    //   433: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: iload_0
    //   437: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: ldc_w 371
    //   443: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: astore 9
    //   451: new 321	java/io/FileReader
    //   454: dup
    //   455: aload 9
    //   457: invokespecial 324	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   460: astore 9
    //   462: new 326	java/io/BufferedReader
    //   465: dup
    //   466: aload 9
    //   468: invokespecial 329	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   471: astore 8
    //   473: aload 8
    //   475: invokevirtual 332	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   478: astore 7
    //   480: lload_3
    //   481: lstore 5
    //   483: aload 7
    //   485: ifnull +16 -> 501
    //   488: aload 7
    //   490: invokestatic 348	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   493: lstore 5
    //   495: lload_3
    //   496: lload 5
    //   498: ladd
    //   499: lstore 5
    //   501: aload 9
    //   503: ifnull +8 -> 511
    //   506: aload 9
    //   508: invokevirtual 354	java/io/FileReader:close	()V
    //   511: aload 8
    //   513: ifnull +8 -> 521
    //   516: aload 8
    //   518: invokevirtual 355	java/io/BufferedReader:close	()V
    //   521: aload 8
    //   523: astore 7
    //   525: lload 5
    //   527: lstore_3
    //   528: lload_3
    //   529: lconst_0
    //   530: lcmp
    //   531: ifle +19 -> 550
    //   534: aload 11
    //   536: iload_0
    //   537: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   540: lload_3
    //   541: invokestatic 351	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   544: invokeinterface 77 3 0
    //   549: pop
    //   550: aload 7
    //   552: astore 8
    //   554: goto -285 -> 269
    //   557: astore 9
    //   559: aload 7
    //   561: astore 9
    //   563: aload 8
    //   565: astore 7
    //   567: aload 9
    //   569: astore 8
    //   571: goto -353 -> 218
    //   574: astore 7
    //   576: aload 8
    //   578: astore 7
    //   580: aload 9
    //   582: astore 8
    //   584: aload 7
    //   586: ifnull +8 -> 594
    //   589: aload 7
    //   591: invokevirtual 354	java/io/FileReader:close	()V
    //   594: aload 8
    //   596: ifnull +8 -> 604
    //   599: aload 8
    //   601: invokevirtual 355	java/io/BufferedReader:close	()V
    //   604: aload 7
    //   606: astore 9
    //   608: aload 8
    //   610: astore 7
    //   612: aload 9
    //   614: astore 8
    //   616: goto -398 -> 218
    //   619: astore 9
    //   621: aload 7
    //   623: astore 9
    //   625: aload 8
    //   627: astore 7
    //   629: aload 9
    //   631: astore 8
    //   633: goto -415 -> 218
    //   636: astore 9
    //   638: aconst_null
    //   639: astore 7
    //   641: aconst_null
    //   642: astore 8
    //   644: aload 7
    //   646: ifnull +8 -> 654
    //   649: aload 7
    //   651: invokevirtual 354	java/io/FileReader:close	()V
    //   654: aload 8
    //   656: ifnull +8 -> 664
    //   659: aload 8
    //   661: invokevirtual 355	java/io/BufferedReader:close	()V
    //   664: aload 9
    //   666: athrow
    //   667: astore 7
    //   669: ldc 2
    //   671: monitorexit
    //   672: aload 7
    //   674: athrow
    //   675: aload 11
    //   677: invokeinterface 365 1 0
    //   682: iconst_1
    //   683: if_icmpne -439 -> 244
    //   686: aload 11
    //   688: invokeinterface 289 1 0
    //   693: invokeinterface 292 1 0
    //   698: astore 9
    //   700: iload_0
    //   701: istore_1
    //   702: aload 9
    //   704: invokeinterface 57 1 0
    //   709: ifeq -465 -> 244
    //   712: aload 9
    //   714: invokeinterface 61 1 0
    //   719: checkcast 63	java/lang/Integer
    //   722: invokevirtual 152	java/lang/Integer:intValue	()I
    //   725: iload_2
    //   726: if_icmpne +410 -> 1136
    //   729: iconst_1
    //   730: istore_0
    //   731: goto +405 -> 1136
    //   734: aload 7
    //   736: invokevirtual 152	java/lang/Integer:intValue	()I
    //   739: istore_0
    //   740: goto -434 -> 306
    //   743: astore 8
    //   745: aload 7
    //   747: astore 8
    //   749: aload 9
    //   751: astore 7
    //   753: goto -330 -> 423
    //   756: astore 7
    //   758: aload 8
    //   760: astore 7
    //   762: aload 9
    //   764: astore 8
    //   766: aload 8
    //   768: ifnull +8 -> 776
    //   771: aload 8
    //   773: invokevirtual 354	java/io/FileReader:close	()V
    //   776: aload 7
    //   778: ifnull +8 -> 786
    //   781: aload 7
    //   783: invokevirtual 355	java/io/BufferedReader:close	()V
    //   786: lload 5
    //   788: lstore_3
    //   789: goto -366 -> 423
    //   792: astore 9
    //   794: lload 5
    //   796: lstore_3
    //   797: goto -374 -> 423
    //   800: astore 10
    //   802: aload 9
    //   804: astore 7
    //   806: aload 10
    //   808: astore 9
    //   810: aload 7
    //   812: ifnull +8 -> 820
    //   815: aload 7
    //   817: invokevirtual 354	java/io/FileReader:close	()V
    //   820: aload 8
    //   822: ifnull +8 -> 830
    //   825: aload 8
    //   827: invokevirtual 355	java/io/BufferedReader:close	()V
    //   830: aload 9
    //   832: athrow
    //   833: astore 7
    //   835: ldc 2
    //   837: monitorexit
    //   838: aload 11
    //   840: areturn
    //   841: astore 7
    //   843: aload 8
    //   845: astore 7
    //   847: lload 5
    //   849: lstore_3
    //   850: goto -322 -> 528
    //   853: astore 9
    //   855: aload 7
    //   857: astore 9
    //   859: aload 8
    //   861: astore 7
    //   863: aload 9
    //   865: astore 8
    //   867: aload 7
    //   869: ifnull +8 -> 877
    //   872: aload 7
    //   874: invokevirtual 354	java/io/FileReader:close	()V
    //   877: aload 8
    //   879: ifnull +8 -> 887
    //   882: aload 8
    //   884: invokevirtual 355	java/io/BufferedReader:close	()V
    //   887: aload 7
    //   889: astore 9
    //   891: aload 8
    //   893: astore 7
    //   895: goto -367 -> 528
    //   898: astore 9
    //   900: aload 7
    //   902: astore 9
    //   904: aload 8
    //   906: astore 7
    //   908: goto -380 -> 528
    //   911: astore 10
    //   913: aload 8
    //   915: astore 9
    //   917: aload 10
    //   919: astore 8
    //   921: aload 9
    //   923: ifnull +8 -> 931
    //   926: aload 9
    //   928: invokevirtual 354	java/io/FileReader:close	()V
    //   931: aload 7
    //   933: ifnull +8 -> 941
    //   936: aload 7
    //   938: invokevirtual 355	java/io/BufferedReader:close	()V
    //   941: aload 8
    //   943: athrow
    //   944: aload 11
    //   946: invokeinterface 365 1 0
    //   951: iconst_1
    //   952: if_icmpne -117 -> 835
    //   955: aload 11
    //   957: invokeinterface 289 1 0
    //   962: invokeinterface 292 1 0
    //   967: astore 7
    //   969: aload 7
    //   971: invokeinterface 57 1 0
    //   976: ifeq -141 -> 835
    //   979: aload 7
    //   981: invokeinterface 61 1 0
    //   986: checkcast 63	java/lang/Integer
    //   989: invokevirtual 152	java/lang/Integer:intValue	()I
    //   992: iload_2
    //   993: if_icmpne -24 -> 969
    //   996: aload 11
    //   998: invokeinterface 374 1 0
    //   1003: goto -34 -> 969
    //   1006: astore 7
    //   1008: goto -67 -> 941
    //   1011: astore 8
    //   1013: goto -92 -> 921
    //   1016: astore 10
    //   1018: aload 8
    //   1020: astore 7
    //   1022: aload 10
    //   1024: astore 8
    //   1026: goto -105 -> 921
    //   1029: astore 8
    //   1031: aload 7
    //   1033: astore 8
    //   1035: aload 9
    //   1037: astore 7
    //   1039: goto -172 -> 867
    //   1042: astore 7
    //   1044: aload 9
    //   1046: astore 7
    //   1048: goto -181 -> 867
    //   1051: astore 7
    //   1053: goto -223 -> 830
    //   1056: astore 9
    //   1058: goto -248 -> 810
    //   1061: astore 10
    //   1063: aload 9
    //   1065: astore 8
    //   1067: aload 10
    //   1069: astore 9
    //   1071: goto -261 -> 810
    //   1074: astore 9
    //   1076: aload 7
    //   1078: astore 9
    //   1080: aload 8
    //   1082: astore 7
    //   1084: aload 9
    //   1086: astore 8
    //   1088: goto -322 -> 766
    //   1091: astore 8
    //   1093: aload 7
    //   1095: astore 8
    //   1097: aload 9
    //   1099: astore 7
    //   1101: goto -335 -> 766
    //   1104: astore 7
    //   1106: goto -442 -> 664
    //   1109: astore 9
    //   1111: aconst_null
    //   1112: astore 8
    //   1114: goto -470 -> 644
    //   1117: astore 9
    //   1119: goto -475 -> 644
    //   1122: astore 8
    //   1124: aload 9
    //   1126: astore 8
    //   1128: goto -544 -> 584
    //   1131: astore 9
    //   1133: goto -549 -> 584
    //   1136: goto -436 -> 700
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	656	0	i	int
    //   231	471	1	j	int
    //   227	767	2	k	int
    //   120	730	3	l1	long
    //   116	732	5	l2	long
    //   28	538	7	localObject1	Object
    //   574	1	7	localThrowable1	Throwable
    //   578	72	7	localObject2	Object
    //   667	79	7	localObject3	Object
    //   751	1	7	localIterator1	java.util.Iterator
    //   756	1	7	localThrowable2	Throwable
    //   760	56	7	localObject4	Object
    //   833	1	7	localThrowable3	Throwable
    //   841	1	7	localThrowable4	Throwable
    //   845	135	7	localObject5	Object
    //   1006	1	7	localThrowable5	Throwable
    //   1020	18	7	localObject6	Object
    //   1042	1	7	localThrowable6	Throwable
    //   1046	1	7	localObject7	Object
    //   1051	26	7	localThrowable7	Throwable
    //   1082	18	7	localObject8	Object
    //   1104	1	7	localThrowable8	Throwable
    //   13	647	8	localObject9	Object
    //   743	1	8	localThrowable9	Throwable
    //   747	195	8	localObject10	Object
    //   1011	8	8	localObject11	Object
    //   1024	1	8	localObject12	Object
    //   1029	1	8	localThrowable10	Throwable
    //   1033	54	8	localObject13	Object
    //   1091	1	8	localThrowable11	Throwable
    //   1095	18	8	localObject14	Object
    //   1122	1	8	localThrowable12	Throwable
    //   1126	1	8	localObject15	Object
    //   16	92	9	localObject16	Object
    //   181	1	9	localThrowable13	Throwable
    //   208	299	9	localObject17	Object
    //   557	1	9	localThrowable14	Throwable
    //   561	52	9	localObject18	Object
    //   619	1	9	localThrowable15	Throwable
    //   623	7	9	localObject19	Object
    //   636	29	9	localObject20	Object
    //   698	65	9	localIterator2	java.util.Iterator
    //   792	11	9	localThrowable16	Throwable
    //   808	23	9	localObject21	Object
    //   853	1	9	localThrowable17	Throwable
    //   857	33	9	localObject22	Object
    //   898	1	9	localThrowable18	Throwable
    //   902	143	9	localObject23	Object
    //   1056	8	9	localObject24	Object
    //   1069	1	9	localObject25	Object
    //   1074	1	9	localThrowable19	Throwable
    //   1078	20	9	localObject26	Object
    //   1109	1	9	localObject27	Object
    //   1117	8	9	localObject28	Object
    //   1131	1	9	localThrowable20	Throwable
    //   259	21	10	localIterator3	java.util.Iterator
    //   800	7	10	localObject29	Object
    //   911	7	10	localObject30	Object
    //   1016	7	10	localObject31	Object
    //   1061	7	10	localObject32	Object
    //   10	987	11	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   53	85	181	java/lang/Throwable
    //   100	118	181	java/lang/Throwable
    //   121	156	181	java/lang/Throwable
    //   162	178	181	java/lang/Throwable
    //   191	196	557	java/lang/Throwable
    //   201	206	557	java/lang/Throwable
    //   18	30	574	java/lang/Throwable
    //   589	594	619	java/lang/Throwable
    //   599	604	619	java/lang/Throwable
    //   18	30	636	finally
    //   3	12	667	finally
    //   191	196	667	finally
    //   201	206	667	finally
    //   218	228	667	finally
    //   232	242	667	finally
    //   248	261	667	finally
    //   269	299	667	finally
    //   324	352	667	finally
    //   400	405	667	finally
    //   410	415	667	finally
    //   423	451	667	finally
    //   506	511	667	finally
    //   516	521	667	finally
    //   534	550	667	finally
    //   589	594	667	finally
    //   599	604	667	finally
    //   649	654	667	finally
    //   659	664	667	finally
    //   664	667	667	finally
    //   675	700	667	finally
    //   702	729	667	finally
    //   734	740	667	finally
    //   771	776	667	finally
    //   781	786	667	finally
    //   815	820	667	finally
    //   825	830	667	finally
    //   830	833	667	finally
    //   872	877	667	finally
    //   882	887	667	finally
    //   926	931	667	finally
    //   936	941	667	finally
    //   941	944	667	finally
    //   944	969	667	finally
    //   969	1003	667	finally
    //   400	405	743	java/lang/Throwable
    //   410	415	743	java/lang/Throwable
    //   352	363	756	java/lang/Throwable
    //   771	776	792	java/lang/Throwable
    //   781	786	792	java/lang/Throwable
    //   352	363	800	finally
    //   218	228	833	java/lang/Throwable
    //   232	242	833	java/lang/Throwable
    //   248	261	833	java/lang/Throwable
    //   269	299	833	java/lang/Throwable
    //   324	352	833	java/lang/Throwable
    //   423	451	833	java/lang/Throwable
    //   534	550	833	java/lang/Throwable
    //   675	700	833	java/lang/Throwable
    //   702	729	833	java/lang/Throwable
    //   734	740	833	java/lang/Throwable
    //   830	833	833	java/lang/Throwable
    //   941	944	833	java/lang/Throwable
    //   944	969	833	java/lang/Throwable
    //   969	1003	833	java/lang/Throwable
    //   506	511	841	java/lang/Throwable
    //   516	521	841	java/lang/Throwable
    //   451	462	853	java/lang/Throwable
    //   872	877	898	java/lang/Throwable
    //   882	887	898	java/lang/Throwable
    //   451	462	911	finally
    //   926	931	1006	java/lang/Throwable
    //   936	941	1006	java/lang/Throwable
    //   462	473	1011	finally
    //   473	480	1016	finally
    //   488	495	1016	finally
    //   462	473	1029	java/lang/Throwable
    //   473	480	1042	java/lang/Throwable
    //   488	495	1042	java/lang/Throwable
    //   815	820	1051	java/lang/Throwable
    //   825	830	1051	java/lang/Throwable
    //   363	374	1056	finally
    //   374	381	1061	finally
    //   389	395	1061	finally
    //   363	374	1074	java/lang/Throwable
    //   374	381	1091	java/lang/Throwable
    //   389	395	1091	java/lang/Throwable
    //   649	654	1104	java/lang/Throwable
    //   659	664	1104	java/lang/Throwable
    //   30	41	1109	finally
    //   41	48	1117	finally
    //   53	85	1117	finally
    //   100	118	1117	finally
    //   121	156	1117	finally
    //   162	178	1117	finally
    //   30	41	1122	java/lang/Throwable
    //   41	48	1131	java/lang/Throwable
  }
  
  private static a n()
  {
    try
    {
      Object localObject = (TelephonyManager)TMSDualSDKContext.getApplicaionContext().getSystemService("phone");
      if (TextUtils.isEmpty(((TelephonyManager)localObject).getSubscriberId())) {
        return null;
      }
      String str = ((TelephonyManager)localObject).getLine1Number();
      if (TextUtils.isEmpty(str))
      {
        h.H.edit().putString("h", "139;0;;;").apply();
        return null;
      }
      localObject = new a();
      try
      {
        ((a)localObject).J = str;
        ((a)localObject).time = (System.currentTimeMillis() / 1000L);
        return localObject;
      }
      catch (Throwable localThrowable2)
      {
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable1) {}
  }
  
  static class a
  {
    public String J;
    public long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.i
 * JD-Core Version:    0.7.0.1
 */