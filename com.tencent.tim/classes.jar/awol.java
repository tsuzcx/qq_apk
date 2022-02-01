import android.os.Bundle;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class awol
  implements awos
{
  public awof b;
  
  public awol()
  {
    asbt.i("WadlProxyServiceWrap", "##@WadlProxyServiceWrap()");
    this.b = new awof();
    awot.a().a(this);
  }
  
  public static long getAvailableBytes()
  {
    try
    {
      long l = aqft.hE();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void XE(String paramString)
  {
    asbt.i("WadlProxyServiceWrap", "doQueryActionByVia via=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    localBundle.putString("via", paramString);
    this.b.eo(localBundle);
  }
  
  public void a(awoe paramawoe)
  {
    this.b.a(paramawoe);
  }
  
  public void b(awoe paramawoe)
  {
    this.b.b(paramawoe);
  }
  
  public void c(WadlParams paramWadlParams)
  {
    asbt.i("WadlProxyServiceWrap", "doInstallAction：" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    localBundle.putString("appId", paramWadlParams.appId);
    localBundle.putInt("actionFrom", paramWadlParams.from);
    this.b.eo(localBundle);
    try
    {
      ascc.cf(paramWadlParams.packageName, paramWadlParams.appId);
      return;
    }
    catch (Exception paramWadlParams)
    {
      asbt.e("WadlProxyServiceWrap", "savePackageInfo", paramWadlParams);
    }
  }
  
  public void cC(int paramInt, String paramString)
  {
    asbt.i("WadlProxyServiceWrap", "##@deleteDownload from=" + paramInt + ",appID=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.b.eo(localBundle);
  }
  
  public void destroy()
  {
    awot.a().destroy();
    this.b.destroy();
  }
  
  public void eE(int paramInt, String paramString)
  {
    asbt.i("WadlProxyServiceWrap", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.b.eo(localBundle);
  }
  
  public void eEF()
  {
    asbt.i("WadlProxyServiceWrap", "##@launchService");
    this.b.eEA();
  }
  
  public void eEG()
  {
    asbt.i("WadlProxyServiceWrap", "initWadlTaskManager:");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInitWadlTaskManager");
    this.b.eo(localBundle);
  }
  
  public void eF(int paramInt, String paramString)
  {
    asbt.i("WadlProxyServiceWrap", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.b.eo(localBundle);
  }
  
  public void emA()
  {
    asbt.i("WadlProxyServiceWrap", "doQueryAllTask");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllTask");
    this.b.eo(localBundle);
  }
  
  public void fz(ArrayList<String> paramArrayList)
  {
    asbt.i("WadlProxyServiceWrap", "doQueryAction:" + paramArrayList.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
    localBundle.putStringArrayList("appIdLis", paramArrayList);
    this.b.eo(localBundle);
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12829");
    return localHashSet;
  }
  
  public void h(WadlParams paramWadlParams)
  {
    asbt.i("WadlProxyServiceWrap", "doDownloadAction wadlParams=" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    localBundle.putString("appId", paramWadlParams.appId);
    localBundle.putInt("actionFrom", paramWadlParams.from);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    if (paramWadlParams.dqZ)
    {
      this.b.eo(localBundle);
      return;
    }
    awot.a().a(paramWadlParams, localBundle);
  }
  
  public List<awoe> hD()
  {
    return this.b.hD();
  }
  
  public void jG(String paramString1, String paramString2)
  {
    asbt.i("WadlProxyServiceWrap", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    this.b.eo(localBundle);
  }
  
  public void m(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    asbt.i("WadlProxyServiceWrap", "##@unpackTgpaApk appid=" + paramString1 + ",version=" + paramInt + ",cdnUrl=" + paramString2 + ",cdnMD5=" + paramString3);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "unpackTgpaApk");
    localBundle.putString("appId", paramString1);
    localBundle.putInt("version", paramInt);
    localBundle.putString("url", paramString2);
    localBundle.putString("md5", paramString3);
    this.b.eo(localBundle);
  }
  
  /* Error */
  public void onCmdRsp(android.content.Intent paramIntent, String paramString, long paramLong, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 14
    //   2: new 50	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   9: ldc 248
    //   11: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 250
    //   20: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_3
    //   24: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 22	asbt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 194
    //   35: aload_2
    //   36: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +26 -> 65
    //   42: aload_1
    //   43: invokevirtual 264	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   46: astore 15
    //   48: aload 15
    //   50: ldc 93
    //   52: invokevirtual 268	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   55: checkcast 101	cooperation/wadl/ipc/WadlParams
    //   58: astore 16
    //   60: aload 16
    //   62: ifnonnull +4 -> 66
    //   65: return
    //   66: iconst_0
    //   67: istore 9
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_1
    //   73: istore 8
    //   75: iload 8
    //   77: istore 7
    //   79: iload 10
    //   81: istore 6
    //   83: lload_3
    //   84: lconst_0
    //   85: lcmp
    //   86: ifne +347 -> 433
    //   89: iload 8
    //   91: istore 7
    //   93: iload 10
    //   95: istore 6
    //   97: aload 5
    //   99: ifnull +334 -> 433
    //   102: iload 9
    //   104: istore 6
    //   106: aload 5
    //   108: ldc_w 270
    //   111: ldc_w 272
    //   114: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: astore_1
    //   118: iload 9
    //   120: istore 6
    //   122: aload 5
    //   124: ldc_w 280
    //   127: ldc_w 272
    //   130: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_2
    //   134: iload 9
    //   136: istore 6
    //   138: aload 5
    //   140: ldc_w 282
    //   143: ldc_w 272
    //   146: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 14
    //   151: iload 9
    //   153: istore 6
    //   155: aload 5
    //   157: ldc_w 284
    //   160: ldc_w 272
    //   163: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 13
    //   168: iload 9
    //   170: istore 6
    //   172: aload 5
    //   174: ldc_w 286
    //   177: ldc_w 272
    //   180: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 12
    //   185: iload 9
    //   187: istore 6
    //   189: aload 5
    //   191: ldc_w 288
    //   194: invokevirtual 291	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 18
    //   199: iload 9
    //   201: istore 6
    //   203: aload 5
    //   205: ldc_w 293
    //   208: ldc_w 272
    //   211: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 17
    //   216: iconst_0
    //   217: istore 10
    //   219: iload 9
    //   221: istore 6
    //   223: aload 18
    //   225: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: istore 11
    //   230: iload 10
    //   232: istore 7
    //   234: iload 11
    //   236: ifne +14 -> 250
    //   239: iload 9
    //   241: istore 6
    //   243: aload 18
    //   245: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   248: istore 7
    //   250: iload 9
    //   252: istore 6
    //   254: aload_1
    //   255: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +273 -> 531
    //   261: iload 9
    //   263: istore 6
    //   265: aload 16
    //   267: aload_1
    //   268: putfield 104	cooperation/wadl/ipc/WadlParams:appId	Ljava/lang/String;
    //   271: iload 9
    //   273: istore 6
    //   275: aload 14
    //   277: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +264 -> 544
    //   283: aload 14
    //   285: astore_1
    //   286: iload 9
    //   288: istore 6
    //   290: aload 16
    //   292: aload_1
    //   293: putfield 308	cooperation/wadl/ipc/WadlParams:apkUrl	Ljava/lang/String;
    //   296: iload 9
    //   298: istore 6
    //   300: aload 13
    //   302: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +252 -> 557
    //   308: aload 13
    //   310: astore_1
    //   311: iload 9
    //   313: istore 6
    //   315: aload 16
    //   317: aload_1
    //   318: putfield 117	cooperation/wadl/ipc/WadlParams:packageName	Ljava/lang/String;
    //   321: iload 9
    //   323: istore 6
    //   325: aload 16
    //   327: iload 7
    //   329: putfield 311	cooperation/wadl/ipc/WadlParams:versionCode	I
    //   332: iload 9
    //   334: istore 6
    //   336: aload 12
    //   338: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifne +229 -> 570
    //   344: aload 12
    //   346: astore_1
    //   347: iload 9
    //   349: istore 6
    //   351: aload 16
    //   353: aload_1
    //   354: putfield 314	cooperation/wadl/ipc/WadlParams:appName	Ljava/lang/String;
    //   357: iload 9
    //   359: istore 6
    //   361: aload_2
    //   362: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifne +218 -> 583
    //   368: aload_2
    //   369: astore_1
    //   370: iload 9
    //   372: istore 6
    //   374: aload 16
    //   376: aload_1
    //   377: putfield 317	cooperation/wadl/ipc/WadlParams:apkChannel	Ljava/lang/String;
    //   380: iload 9
    //   382: istore 6
    //   384: aload 16
    //   386: aload 17
    //   388: putfield 320	cooperation/wadl/ipc/WadlParams:bLD	Ljava/lang/String;
    //   391: iload 9
    //   393: istore 6
    //   395: aload 5
    //   397: ldc_w 322
    //   400: iconst_0
    //   401: invokevirtual 326	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   404: istore 7
    //   406: iload 7
    //   408: istore 6
    //   410: aload 5
    //   412: ldc_w 328
    //   415: iconst_1
    //   416: invokevirtual 326	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   419: istore 9
    //   421: iload 9
    //   423: istore 8
    //   425: iload 7
    //   427: istore 6
    //   429: iload 8
    //   431: istore 7
    //   433: aload 16
    //   435: getfield 314	cooperation/wadl/ipc/WadlParams:appName	Ljava/lang/String;
    //   438: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   441: ifeq +13 -> 454
    //   444: aload 16
    //   446: aload 16
    //   448: getfield 117	cooperation/wadl/ipc/WadlParams:packageName	Ljava/lang/String;
    //   451: putfield 314	cooperation/wadl/ipc/WadlParams:appName	Ljava/lang/String;
    //   454: iload 6
    //   456: iconst_1
    //   457: if_icmpne +156 -> 613
    //   460: aload 16
    //   462: sipush 256
    //   465: invokevirtual 332	cooperation/wadl/ipc/WadlParams:setFlags	(I)V
    //   468: iload 7
    //   470: istore 6
    //   472: iload 7
    //   474: iconst_1
    //   475: if_icmpge +6 -> 481
    //   478: iconst_1
    //   479: istore 6
    //   481: aload 16
    //   483: iload 6
    //   485: putfield 335	cooperation/wadl/ipc/WadlParams:channelNum	I
    //   488: aload 15
    //   490: ldc 93
    //   492: aload 16
    //   494: invokevirtual 97	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   497: aload_0
    //   498: getfield 27	awol:b	Lawof;
    //   501: aload 15
    //   503: invokevirtual 77	awof:eo	(Landroid/os/Bundle;)V
    //   506: aload 16
    //   508: getfield 117	cooperation/wadl/ipc/WadlParams:packageName	Ljava/lang/String;
    //   511: aload 16
    //   513: getfield 104	cooperation/wadl/ipc/WadlParams:appId	Ljava/lang/String;
    //   516: invokestatic 123	ascc:cf	(Ljava/lang/String;Ljava/lang/String;)Z
    //   519: pop
    //   520: return
    //   521: astore_1
    //   522: ldc 14
    //   524: ldc 125
    //   526: aload_1
    //   527: invokestatic 129	asbt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   530: return
    //   531: iload 9
    //   533: istore 6
    //   535: aload 16
    //   537: getfield 104	cooperation/wadl/ipc/WadlParams:appId	Ljava/lang/String;
    //   540: astore_1
    //   541: goto -280 -> 261
    //   544: iload 9
    //   546: istore 6
    //   548: aload 16
    //   550: getfield 308	cooperation/wadl/ipc/WadlParams:apkUrl	Ljava/lang/String;
    //   553: astore_1
    //   554: goto -268 -> 286
    //   557: iload 9
    //   559: istore 6
    //   561: aload 16
    //   563: getfield 117	cooperation/wadl/ipc/WadlParams:packageName	Ljava/lang/String;
    //   566: astore_1
    //   567: goto -256 -> 311
    //   570: iload 9
    //   572: istore 6
    //   574: aload 16
    //   576: getfield 314	cooperation/wadl/ipc/WadlParams:appName	Ljava/lang/String;
    //   579: astore_1
    //   580: goto -233 -> 347
    //   583: iload 9
    //   585: istore 6
    //   587: aload 16
    //   589: getfield 317	cooperation/wadl/ipc/WadlParams:apkChannel	Ljava/lang/String;
    //   592: astore_1
    //   593: goto -223 -> 370
    //   596: astore_1
    //   597: ldc 14
    //   599: ldc_w 337
    //   602: aload_1
    //   603: invokestatic 129	asbt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   606: iload 8
    //   608: istore 7
    //   610: goto -177 -> 433
    //   613: aload 16
    //   615: sipush 256
    //   618: invokevirtual 340	cooperation/wadl/ipc/WadlParams:acT	(I)V
    //   621: goto -133 -> 488
    //   624: astore 18
    //   626: iload 10
    //   628: istore 7
    //   630: goto -380 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	this	awol
    //   0	633	1	paramIntent	android.content.Intent
    //   0	633	2	paramString	String
    //   0	633	3	paramLong	long
    //   0	633	5	paramJSONObject	org.json.JSONObject
    //   81	505	6	i	int
    //   77	552	7	j	int
    //   73	534	8	k	int
    //   67	517	9	m	int
    //   70	557	10	n	int
    //   228	7	11	bool	boolean
    //   183	162	12	str1	String
    //   166	143	13	str2	String
    //   149	135	14	str3	String
    //   46	456	15	localBundle	Bundle
    //   58	556	16	localWadlParams	WadlParams
    //   214	173	17	str4	String
    //   197	47	18	str5	String
    //   624	1	18	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   506	520	521	java/lang/Exception
    //   106	118	596	java/lang/Throwable
    //   122	134	596	java/lang/Throwable
    //   138	151	596	java/lang/Throwable
    //   155	168	596	java/lang/Throwable
    //   172	185	596	java/lang/Throwable
    //   189	199	596	java/lang/Throwable
    //   203	216	596	java/lang/Throwable
    //   223	230	596	java/lang/Throwable
    //   243	250	596	java/lang/Throwable
    //   254	261	596	java/lang/Throwable
    //   265	271	596	java/lang/Throwable
    //   275	283	596	java/lang/Throwable
    //   290	296	596	java/lang/Throwable
    //   300	308	596	java/lang/Throwable
    //   315	321	596	java/lang/Throwable
    //   325	332	596	java/lang/Throwable
    //   336	344	596	java/lang/Throwable
    //   351	357	596	java/lang/Throwable
    //   361	368	596	java/lang/Throwable
    //   374	380	596	java/lang/Throwable
    //   384	391	596	java/lang/Throwable
    //   395	406	596	java/lang/Throwable
    //   410	421	596	java/lang/Throwable
    //   535	541	596	java/lang/Throwable
    //   548	554	596	java/lang/Throwable
    //   561	567	596	java/lang/Throwable
    //   574	580	596	java/lang/Throwable
    //   587	593	596	java/lang/Throwable
    //   243	250	624	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awol
 * JD-Core Version:    0.7.0.1
 */