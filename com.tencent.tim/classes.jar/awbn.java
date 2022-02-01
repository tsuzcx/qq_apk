import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfServerInfo;
import cooperation.qzone.statistic.serverip.WebAppIpRecord;
import cooperation.qzone.statistic.serverip.WebAppIpRecord.FixedSizeLinkedHashMap;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class awbn
{
  private static final awau<awbn, Void> sSingleton = new awbo();
  private LinkedHashMap<Long, WebAppIpRecord> an;
  
  private File Q()
    throws IOException
  {
    File localFile = new File(avsu.Gu() + File.separator + "webapp_iplist");
    if (!localFile.exists())
    {
      if (localFile.getParentFile().exists()) {
        break label69;
      }
      if (localFile.getParentFile().mkdirs()) {
        localFile.createNewFile();
      }
    }
    return localFile;
    label69:
    localFile.createNewFile();
    return localFile;
  }
  
  public static awbn a()
  {
    return (awbn)sSingleton.get(null);
  }
  
  private LinkedHashMap<Long, WebAppIpRecord> a(LinkedHashMap<Long, WebAppIpRecord> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.isEmpty()) || (paramLong == 0L)) {
      return paramLinkedHashMap;
    }
    WebAppIpRecord[] arrayOfWebAppIpRecord = (WebAppIpRecord[])paramLinkedHashMap.values().toArray(new WebAppIpRecord[paramLinkedHashMap.size()]);
    long l = System.currentTimeMillis();
    int k = arrayOfWebAppIpRecord.length;
    int i = 0;
    label53:
    WebAppIpRecord localWebAppIpRecord;
    WebAppIpRecord.FixedSizeLinkedHashMap localFixedSizeLinkedHashMap;
    if (i < k)
    {
      localWebAppIpRecord = arrayOfWebAppIpRecord[i];
      localFixedSizeLinkedHashMap = localWebAppIpRecord.a;
      if (!localFixedSizeLinkedHashMap.isEmpty()) {
        break label91;
      }
    }
    for (;;)
    {
      i += 1;
      break label53;
      break;
      label91:
      Integer[] arrayOfInteger = (Integer[])localFixedSizeLinkedHashMap.keySet().toArray(new Integer[localFixedSizeLinkedHashMap.size()]);
      int m = arrayOfInteger.length;
      int j = 0;
      while (j < m)
      {
        Integer localInteger = arrayOfInteger[j];
        if (l - ((Long)localFixedSizeLinkedHashMap.get(localInteger)).longValue() > paramLong) {
          localFixedSizeLinkedHashMap.remove(localInteger);
        }
        if ((j == m - 1) && (localFixedSizeLinkedHashMap.isEmpty())) {
          paramLinkedHashMap.remove(Long.valueOf(localWebAppIpRecord.aAI));
        }
        j += 1;
      }
    }
  }
  
  public static boolean a(QmfServerInfo paramQmfServerInfo)
  {
    if ((paramQmfServerInfo == null) || (paramQmfServerInfo.ipWebapp == null)) {}
    while ((paramQmfServerInfo.changeTime == 0L) || (paramQmfServerInfo.ipWebapp.ClientIpv4 == 0)) {
      return false;
    }
    return true;
  }
  
  public void a(QmfServerInfo paramQmfServerInfo)
  {
    try
    {
      if (QZLog.isColorLevel()) {
        QZLog.d("WebAppIpManager", 2, "addWebAppIpRecord--changeTime:" + paramQmfServerInfo.changeTime + ", Ipv4:" + paramQmfServerInfo.ipWebapp.ClientIpv4);
      }
      if (this.an == null) {
        this.an = new LinkedHashMap();
      }
      WebAppIpRecord localWebAppIpRecord2 = (WebAppIpRecord)this.an.get(Long.valueOf(paramQmfServerInfo.changeTime));
      WebAppIpRecord localWebAppIpRecord1 = localWebAppIpRecord2;
      if (localWebAppIpRecord2 == null)
      {
        localWebAppIpRecord1 = new WebAppIpRecord();
        this.an.put(Long.valueOf(paramQmfServerInfo.changeTime), localWebAppIpRecord1);
      }
      localWebAppIpRecord1.aAI = paramQmfServerInfo.changeTime;
      localWebAppIpRecord1.ack(paramQmfServerInfo.ipWebapp.ClientIpv4);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void eDb()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 182	awbn:an	Ljava/util/LinkedHashMap;
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: getfield 182	awbn:an	Ljava/util/LinkedHashMap;
    //   15: invokevirtual 80	java/util/LinkedHashMap:isEmpty	()Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   31: ifeq +34 -> 65
    //   34: ldc 166
    //   36: iconst_2
    //   37: new 29	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   44: ldc 198
    //   46: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 182	awbn:an	Ljava/util/LinkedHashMap;
    //   53: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   56: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 180	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aconst_null
    //   66: astore 6
    //   68: aconst_null
    //   69: astore 7
    //   71: aload 6
    //   73: astore 5
    //   75: invokestatic 204	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   78: ldc 206
    //   80: ldc 208
    //   82: bipush 60
    //   84: invokevirtual 212	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   87: istore_2
    //   88: aload 6
    //   90: astore 5
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 182	awbn:an	Ljava/util/LinkedHashMap;
    //   97: iload_2
    //   98: sipush 1000
    //   101: imul
    //   102: i2l
    //   103: invokespecial 214	awbn:a	(Ljava/util/LinkedHashMap;J)Ljava/util/LinkedHashMap;
    //   106: astore 8
    //   108: aload 6
    //   110: astore 5
    //   112: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   115: ifeq +55 -> 170
    //   118: aload 6
    //   120: astore 5
    //   122: new 29	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   129: ldc 216
    //   131: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: astore 9
    //   136: aload 8
    //   138: ifnull +13 -> 151
    //   141: aload 6
    //   143: astore 5
    //   145: aload 8
    //   147: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   150: istore_1
    //   151: aload 6
    //   153: astore 5
    //   155: ldc 166
    //   157: iconst_2
    //   158: aload 9
    //   160: iload_1
    //   161: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 180	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 6
    //   172: astore 5
    //   174: invokestatic 204	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   177: ldc 206
    //   179: ldc 218
    //   181: iconst_3
    //   182: invokevirtual 212	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   185: istore_1
    //   186: aload 6
    //   188: astore 5
    //   190: aload 8
    //   192: invokevirtual 219	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   195: aload 8
    //   197: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   200: anewarray 125	java/lang/Long
    //   203: invokeinterface 120 2 0
    //   208: checkcast 221	[Ljava/lang/Long;
    //   211: astore 10
    //   213: aload 6
    //   215: astore 5
    //   217: aload 10
    //   219: invokestatic 227	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   222: aload 6
    //   224: astore 5
    //   226: aload 10
    //   228: arraylength
    //   229: istore_3
    //   230: iload_1
    //   231: iload_3
    //   232: if_icmple +383 -> 615
    //   235: iload_3
    //   236: istore_1
    //   237: aload 6
    //   239: astore 5
    //   241: new 229	java/util/ArrayList
    //   244: dup
    //   245: invokespecial 230	java/util/ArrayList:<init>	()V
    //   248: astore 9
    //   250: iload_3
    //   251: iconst_1
    //   252: isub
    //   253: istore_2
    //   254: iload_2
    //   255: iload_3
    //   256: iload_1
    //   257: isub
    //   258: if_icmplt +29 -> 287
    //   261: aload 6
    //   263: astore 5
    //   265: aload 9
    //   267: aload 8
    //   269: aload 10
    //   271: iload_2
    //   272: aaload
    //   273: invokevirtual 184	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: invokevirtual 234	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   279: pop
    //   280: iload_2
    //   281: iconst_1
    //   282: isub
    //   283: istore_2
    //   284: goto -30 -> 254
    //   287: aload 6
    //   289: astore 5
    //   291: invokestatic 240	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   294: astore 8
    //   296: aload 6
    //   298: astore 5
    //   300: aload 8
    //   302: iconst_0
    //   303: invokevirtual 243	android/os/Parcel:setDataPosition	(I)V
    //   306: aload 6
    //   308: astore 5
    //   310: aload 8
    //   312: aload 9
    //   314: invokevirtual 244	java/util/ArrayList:size	()I
    //   317: invokevirtual 247	android/os/Parcel:writeInt	(I)V
    //   320: aload 6
    //   322: astore 5
    //   324: aload 9
    //   326: invokevirtual 251	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   329: astore 9
    //   331: aload 6
    //   333: astore 5
    //   335: aload 9
    //   337: invokeinterface 256 1 0
    //   342: ifeq +144 -> 486
    //   345: aload 6
    //   347: astore 5
    //   349: aload 9
    //   351: invokeinterface 260 1 0
    //   356: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   359: astore 10
    //   361: aload 6
    //   363: astore 5
    //   365: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   368: ifeq +54 -> 422
    //   371: aload 6
    //   373: astore 5
    //   375: ldc 166
    //   377: iconst_2
    //   378: new 29	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 262
    //   388: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 10
    //   393: getfield 135	cooperation/qzone/statistic/serverip/WebAppIpRecord:aAI	J
    //   396: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: ldc_w 264
    //   402: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 10
    //   407: getfield 107	cooperation/qzone/statistic/serverip/WebAppIpRecord:a	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   410: invokevirtual 267	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:toString	()Ljava/lang/String;
    //   413: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 270	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload 6
    //   424: astore 5
    //   426: aload 10
    //   428: aload 8
    //   430: iconst_0
    //   431: invokevirtual 274	cooperation/qzone/statistic/serverip/WebAppIpRecord:writeToParcel	(Landroid/os/Parcel;I)V
    //   434: goto -103 -> 331
    //   437: astore 5
    //   439: aload 7
    //   441: astore 6
    //   443: aload 5
    //   445: astore 7
    //   447: aload 6
    //   449: astore 5
    //   451: aload 7
    //   453: invokestatic 278	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   456: aload 6
    //   458: ifnull -433 -> 25
    //   461: aload 6
    //   463: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   466: goto -441 -> 25
    //   469: astore 5
    //   471: aload 5
    //   473: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   476: goto -451 -> 25
    //   479: astore 5
    //   481: aload_0
    //   482: monitorexit
    //   483: aload 5
    //   485: athrow
    //   486: aload 6
    //   488: astore 5
    //   490: aload 8
    //   492: invokevirtual 290	android/os/Parcel:marshall	()[B
    //   495: astore 9
    //   497: aload 6
    //   499: astore 5
    //   501: aload 8
    //   503: invokevirtual 293	android/os/Parcel:recycle	()V
    //   506: aload 6
    //   508: astore 5
    //   510: aload_0
    //   511: invokespecial 295	awbn:Q	()Ljava/io/File;
    //   514: astore 8
    //   516: aload 8
    //   518: ifnull +91 -> 609
    //   521: aload 6
    //   523: astore 5
    //   525: new 280	java/io/FileOutputStream
    //   528: dup
    //   529: aload 8
    //   531: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   534: astore 6
    //   536: aload 6
    //   538: aload 9
    //   540: invokevirtual 302	java/io/FileOutputStream:write	([B)V
    //   543: aload 6
    //   545: ifnull -520 -> 25
    //   548: aload 6
    //   550: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   553: goto -528 -> 25
    //   556: astore 5
    //   558: aload 5
    //   560: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   563: goto -538 -> 25
    //   566: astore 7
    //   568: aload 5
    //   570: astore 6
    //   572: aload 7
    //   574: astore 5
    //   576: aload 6
    //   578: ifnull +8 -> 586
    //   581: aload 6
    //   583: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   586: aload 5
    //   588: athrow
    //   589: astore 6
    //   591: aload 6
    //   593: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   596: goto -10 -> 586
    //   599: astore 5
    //   601: goto -25 -> 576
    //   604: astore 7
    //   606: goto -159 -> 447
    //   609: aconst_null
    //   610: astore 6
    //   612: goto -69 -> 543
    //   615: goto -378 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	awbn
    //   1	257	1	i	int
    //   87	197	2	j	int
    //   229	29	3	k	int
    //   18	3	4	bool	boolean
    //   73	352	5	localObject1	Object
    //   437	7	5	localThrowable1	java.lang.Throwable
    //   449	1	5	localObject2	Object
    //   469	3	5	localIOException1	IOException
    //   479	5	5	localObject3	Object
    //   488	36	5	localObject4	Object
    //   556	13	5	localIOException2	IOException
    //   574	13	5	localObject5	Object
    //   599	1	5	localObject6	Object
    //   66	516	6	localObject7	Object
    //   589	3	6	localIOException3	IOException
    //   610	1	6	localObject8	Object
    //   69	383	7	localObject9	Object
    //   566	7	7	localObject10	Object
    //   604	1	7	localThrowable2	java.lang.Throwable
    //   106	424	8	localObject11	Object
    //   134	405	9	localObject12	Object
    //   211	216	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   75	88	437	java/lang/Throwable
    //   92	108	437	java/lang/Throwable
    //   112	118	437	java/lang/Throwable
    //   122	136	437	java/lang/Throwable
    //   145	151	437	java/lang/Throwable
    //   155	170	437	java/lang/Throwable
    //   174	186	437	java/lang/Throwable
    //   190	213	437	java/lang/Throwable
    //   217	222	437	java/lang/Throwable
    //   226	230	437	java/lang/Throwable
    //   241	250	437	java/lang/Throwable
    //   265	280	437	java/lang/Throwable
    //   291	296	437	java/lang/Throwable
    //   300	306	437	java/lang/Throwable
    //   310	320	437	java/lang/Throwable
    //   324	331	437	java/lang/Throwable
    //   335	345	437	java/lang/Throwable
    //   349	361	437	java/lang/Throwable
    //   365	371	437	java/lang/Throwable
    //   375	422	437	java/lang/Throwable
    //   426	434	437	java/lang/Throwable
    //   490	497	437	java/lang/Throwable
    //   501	506	437	java/lang/Throwable
    //   510	516	437	java/lang/Throwable
    //   525	536	437	java/lang/Throwable
    //   461	466	469	java/io/IOException
    //   4	20	479	finally
    //   28	65	479	finally
    //   461	466	479	finally
    //   471	476	479	finally
    //   548	553	479	finally
    //   558	563	479	finally
    //   581	586	479	finally
    //   586	589	479	finally
    //   591	596	479	finally
    //   548	553	556	java/io/IOException
    //   75	88	566	finally
    //   92	108	566	finally
    //   112	118	566	finally
    //   122	136	566	finally
    //   145	151	566	finally
    //   155	170	566	finally
    //   174	186	566	finally
    //   190	213	566	finally
    //   217	222	566	finally
    //   226	230	566	finally
    //   241	250	566	finally
    //   265	280	566	finally
    //   291	296	566	finally
    //   300	306	566	finally
    //   310	320	566	finally
    //   324	331	566	finally
    //   335	345	566	finally
    //   349	361	566	finally
    //   365	371	566	finally
    //   375	422	566	finally
    //   426	434	566	finally
    //   451	456	566	finally
    //   490	497	566	finally
    //   501	506	566	finally
    //   510	516	566	finally
    //   525	536	566	finally
    //   581	586	589	java/io/IOException
    //   536	543	599	finally
    //   536	543	604	java/lang/Throwable
  }
  
  /* Error */
  public void report()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 27	java/io/File
    //   11: dup
    //   12: new 29	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 36	avsu:Gu	()Ljava/lang/String;
    //   22: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   28: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 46
    //   33: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 56	java/io/File:exists	()Z
    //   49: ifeq +545 -> 594
    //   52: aload 4
    //   54: invokevirtual 308	java/io/File:length	()J
    //   57: l2i
    //   58: newarray byte
    //   60: astore 5
    //   62: new 310	java/io/FileInputStream
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 311	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_3
    //   72: aload_3
    //   73: aload 5
    //   75: invokevirtual 315	java/io/FileInputStream:read	([B)I
    //   78: pop
    //   79: aload 4
    //   81: invokestatic 321	awcf:deleteFile	(Ljava/io/File;)Z
    //   84: pop
    //   85: aload 5
    //   87: ifnonnull +39 -> 126
    //   90: aload_3
    //   91: ifnull +7 -> 98
    //   94: aload_3
    //   95: invokevirtual 322	java/io/FileInputStream:close	()V
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 324	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 325	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_3
    //   114: aload_3
    //   115: invokestatic 278	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   118: goto -20 -> 98
    //   121: astore_3
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_3
    //   125: athrow
    //   126: invokestatic 240	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   129: astore 4
    //   131: aload 4
    //   133: aload 5
    //   135: iconst_0
    //   136: aload 5
    //   138: arraylength
    //   139: invokevirtual 329	android/os/Parcel:unmarshall	([BII)V
    //   142: aload 4
    //   144: iconst_0
    //   145: invokevirtual 243	android/os/Parcel:setDataPosition	(I)V
    //   148: aload 4
    //   150: invokevirtual 332	android/os/Parcel:readInt	()I
    //   153: istore_2
    //   154: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   157: ifeq +29 -> 186
    //   160: ldc 166
    //   162: iconst_2
    //   163: new 29	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 334
    //   173: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload_2
    //   177: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 270	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: new 229	java/util/ArrayList
    //   189: dup
    //   190: invokespecial 230	java/util/ArrayList:<init>	()V
    //   193: astore 7
    //   195: iconst_0
    //   196: istore_1
    //   197: iload_1
    //   198: iload_2
    //   199: if_icmpge +29 -> 228
    //   202: aload 7
    //   204: getstatic 338	cooperation/qzone/statistic/serverip/WebAppIpRecord:CREATOR	Landroid/os/Parcelable$Creator;
    //   207: aload 4
    //   209: invokeinterface 344 2 0
    //   214: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   217: invokevirtual 234	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -28 -> 197
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 322	java/io/FileInputStream:close	()V
    //   236: aload 7
    //   238: astore_3
    //   239: aload 4
    //   241: ifnull +11 -> 252
    //   244: aload 4
    //   246: invokevirtual 293	android/os/Parcel:recycle	()V
    //   249: aload 7
    //   251: astore_3
    //   252: aload_3
    //   253: ifnull -143 -> 110
    //   256: aload_3
    //   257: invokevirtual 251	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   260: astore 4
    //   262: aload 4
    //   264: invokeinterface 256 1 0
    //   269: ifeq -159 -> 110
    //   272: aload 4
    //   274: invokeinterface 260 1 0
    //   279: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   282: astore 6
    //   284: aload 6
    //   286: ifnull -24 -> 262
    //   289: aload 6
    //   291: getfield 107	cooperation/qzone/statistic/serverip/WebAppIpRecord:a	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   294: ifnull -32 -> 262
    //   297: aload 6
    //   299: getfield 107	cooperation/qzone/statistic/serverip/WebAppIpRecord:a	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   302: invokevirtual 345	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:keySet	()Ljava/util/Set;
    //   305: invokeinterface 346 1 0
    //   310: astore_3
    //   311: aload_3
    //   312: invokeinterface 256 1 0
    //   317: ifeq -55 -> 262
    //   320: aload_3
    //   321: invokeinterface 260 1 0
    //   326: checkcast 117	java/lang/Integer
    //   329: astore 5
    //   331: invokestatic 164	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   334: ifeq +44 -> 378
    //   337: ldc 166
    //   339: iconst_2
    //   340: new 29	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 348
    //   350: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 5
    //   355: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: ldc_w 353
    //   361: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 6
    //   366: getfield 135	cooperation/qzone/statistic/serverip/WebAppIpRecord:aAI	J
    //   369: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 270	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload 5
    //   380: invokevirtual 356	java/lang/Integer:intValue	()I
    //   383: aload 6
    //   385: getfield 135	cooperation/qzone/statistic/serverip/WebAppIpRecord:aAI	J
    //   388: invokestatic 361	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   391: invokestatic 367	awat:ex	(ILjava/lang/String;)V
    //   394: goto -83 -> 311
    //   397: astore_3
    //   398: aload_3
    //   399: invokestatic 278	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   402: goto -166 -> 236
    //   405: astore 5
    //   407: aconst_null
    //   408: astore_3
    //   409: aconst_null
    //   410: astore 4
    //   412: aload 5
    //   414: invokestatic 278	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   417: aload 4
    //   419: ifnull +8 -> 427
    //   422: aload 4
    //   424: invokevirtual 322	java/io/FileInputStream:close	()V
    //   427: aload 6
    //   429: ifnull +162 -> 591
    //   432: aload 6
    //   434: invokevirtual 293	android/os/Parcel:recycle	()V
    //   437: goto -185 -> 252
    //   440: astore 4
    //   442: aload 4
    //   444: invokestatic 278	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   447: goto -20 -> 427
    //   450: astore 4
    //   452: aconst_null
    //   453: astore_3
    //   454: aload 7
    //   456: astore 6
    //   458: aload_3
    //   459: ifnull +7 -> 466
    //   462: aload_3
    //   463: invokevirtual 322	java/io/FileInputStream:close	()V
    //   466: aload 6
    //   468: ifnull +8 -> 476
    //   471: aload 6
    //   473: invokevirtual 293	android/os/Parcel:recycle	()V
    //   476: aload 4
    //   478: athrow
    //   479: astore_3
    //   480: aload_3
    //   481: invokestatic 278	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   484: goto -18 -> 466
    //   487: astore 4
    //   489: aload 7
    //   491: astore 6
    //   493: goto -35 -> 458
    //   496: astore 4
    //   498: aload 7
    //   500: astore 6
    //   502: goto -44 -> 458
    //   505: astore 5
    //   507: aload 4
    //   509: astore 6
    //   511: aload 5
    //   513: astore 4
    //   515: goto -57 -> 458
    //   518: astore 5
    //   520: aload 4
    //   522: astore_3
    //   523: aload 5
    //   525: astore 4
    //   527: goto -69 -> 458
    //   530: astore 5
    //   532: aload_3
    //   533: astore 4
    //   535: aconst_null
    //   536: astore_3
    //   537: goto -125 -> 412
    //   540: astore 5
    //   542: aconst_null
    //   543: astore 7
    //   545: aload_3
    //   546: astore 4
    //   548: aload 7
    //   550: astore_3
    //   551: goto -139 -> 412
    //   554: astore 5
    //   556: aload_3
    //   557: astore 7
    //   559: aconst_null
    //   560: astore_3
    //   561: aload 4
    //   563: astore 6
    //   565: aload 7
    //   567: astore 4
    //   569: goto -157 -> 412
    //   572: astore 5
    //   574: aload_3
    //   575: astore 8
    //   577: aload 4
    //   579: astore 6
    //   581: aload 7
    //   583: astore_3
    //   584: aload 8
    //   586: astore 4
    //   588: goto -176 -> 412
    //   591: goto -339 -> 252
    //   594: aconst_null
    //   595: astore 5
    //   597: aconst_null
    //   598: astore_3
    //   599: goto -514 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	awbn
    //   196	29	1	i	int
    //   153	47	2	j	int
    //   71	24	3	localFileInputStream	java.io.FileInputStream
    //   113	2	3	localIOException1	IOException
    //   121	112	3	localObject1	Object
    //   238	83	3	localObject2	Object
    //   397	2	3	localIOException2	IOException
    //   408	55	3	localObject3	Object
    //   479	2	3	localIOException3	IOException
    //   522	77	3	localObject4	Object
    //   42	381	4	localObject5	Object
    //   440	3	4	localIOException4	IOException
    //   450	27	4	localObject6	Object
    //   487	1	4	localObject7	Object
    //   496	12	4	localObject8	Object
    //   513	74	4	localObject9	Object
    //   60	319	5	localObject10	Object
    //   405	8	5	localException1	java.lang.Exception
    //   505	7	5	localObject11	Object
    //   518	6	5	localObject12	Object
    //   530	1	5	localException2	java.lang.Exception
    //   540	1	5	localException3	java.lang.Exception
    //   554	1	5	localException4	java.lang.Exception
    //   572	1	5	localException5	java.lang.Exception
    //   595	1	5	localObject13	Object
    //   4	576	6	localObject14	Object
    //   1	581	7	localObject15	Object
    //   575	10	8	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   94	98	113	java/io/IOException
    //   94	98	121	finally
    //   102	110	121	finally
    //   114	118	121	finally
    //   232	236	121	finally
    //   244	249	121	finally
    //   256	262	121	finally
    //   262	284	121	finally
    //   289	311	121	finally
    //   311	378	121	finally
    //   378	394	121	finally
    //   398	402	121	finally
    //   422	427	121	finally
    //   432	437	121	finally
    //   442	447	121	finally
    //   462	466	121	finally
    //   471	476	121	finally
    //   476	479	121	finally
    //   480	484	121	finally
    //   232	236	397	java/io/IOException
    //   8	72	405	java/lang/Exception
    //   422	427	440	java/io/IOException
    //   8	72	450	finally
    //   462	466	479	java/io/IOException
    //   72	85	487	finally
    //   126	131	496	finally
    //   131	186	505	finally
    //   186	195	505	finally
    //   202	221	505	finally
    //   412	417	518	finally
    //   72	85	530	java/lang/Exception
    //   126	131	540	java/lang/Exception
    //   131	186	554	java/lang/Exception
    //   186	195	554	java/lang/Exception
    //   202	221	572	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbn
 * JD-Core Version:    0.7.0.1
 */