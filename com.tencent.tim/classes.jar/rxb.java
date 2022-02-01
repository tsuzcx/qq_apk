import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.File;
import java.io.IOException;

public abstract class rxb
  extends rwy
{
  protected static long CA = 15728640L;
  protected static int IO_BUFFER_SIZE = 8192;
  private static String aDe;
  private static String aDf;
  private long CB = 15728640L;
  private final String TAG = "LruCache";
  private String aDg = "";
  private boolean aKq;
  protected DiskLruCache b;
  private Object bx = new Object();
  
  public rxb(String paramString1, String paramString2)
  {
    aDe = paramString1;
    aDf = paramString2;
    initDiskCache();
  }
  
  /* Error */
  private void initDiskCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 59	rxb:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: invokevirtual 59	rxb:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   13: invokevirtual 65	com/jakewharton/disklrucache/DiskLruCache:isClosed	()Z
    //   16: ifeq +86 -> 102
    //   19: invokestatic 70	aqmb:aEZ	()Z
    //   22: ifne +10 -> 32
    //   25: aload_0
    //   26: getfield 48	rxb:CB	J
    //   29: putstatic 26	rxb:CA	J
    //   32: aload_0
    //   33: invokevirtual 74	rxb:getCacheDir	()Ljava/lang/String;
    //   36: astore_1
    //   37: new 76	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 82	java/io/File:exists	()Z
    //   50: ifne +55 -> 105
    //   53: ldc 35
    //   55: new 84	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   62: ldc 87
    //   64: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 93
    //   73: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 26	rxb:CA	J
    //   79: invokestatic 99	aqmr:formatSize	(J)Ljava/lang/String;
    //   82: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: invokevirtual 110	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 113	rxb:w	(Ljava/io/File;)Z
    //   101: pop
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: ldc 35
    //   107: new 84	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   114: ldc 87
    //   116: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 115
    //   125: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 26	rxb:CA	J
    //   131: invokestatic 99	aqmr:formatSize	(J)Ljava/lang/String;
    //   134: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 118	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -47 -> 96
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	rxb
    //   36	84	1	str	String
    //   146	4	1	localObject	Object
    //   45	53	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	19	146	finally
    //   19	32	146	finally
    //   32	96	146	finally
    //   96	102	146	finally
    //   105	143	146	finally
  }
  
  private int ud()
  {
    if (a() == null) {
      return 0;
    }
    return a().hashCode();
  }
  
  public boolean R(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    initDiskCache();
    String str = gs(paramString1);
    DiskLruCache localDiskLruCache;
    boolean bool1;
    if ((a() != null) && (str != null))
    {
      localDiskLruCache = this.b;
      Object localObject = null;
      try
      {
        DiskLruCache.Editor localEditor = a().edit(str);
        localObject = localEditor;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ram.w("LruCache", "Set cache error: Exception ");
        }
      }
      finally {}
      bool1 = bool2;
      if (localObject != null) {
        ram.i("LruCache", "name: " + paramString1 + ", Cache name: " + str + ", value length: " + paramString2.length());
      }
      try
      {
        localObject.set(0, oav.encrypt(paramString2));
        localObject.commit();
        bool1 = true;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          ram.w("LruCache", "Commit cache error: Exception ");
          bool1 = bool2;
        }
      }
      this.b.notifyAll();
      return bool1;
    }
    return false;
  }
  
  protected DiskLruCache a()
  {
    return this.b;
  }
  
  public rwy.a a(String paramString)
  {
    initDiskCache();
    rwy.a locala = new rwy.a(this);
    String str = gs(paramString);
    if ((a() != null) && (str != null))
    {
      Object localObject = null;
      try
      {
        DiskLruCache.Snapshot localSnapshot = a().get(str);
        localObject = localSnapshot;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ram.w("LruCache", "Get cache error: Cache name: " + str + ", Url: " + paramString);
        }
        ram.i("LruCache", "Get cache success: Cache name: " + str + ", Url: " + paramString);
        return locala;
      }
      if (localObject != null)
      {
        locala.a(localObject);
        locala.setInputStream(localObject.getInputStream(0));
        if (locala.getInputStream() == null)
        {
          ram.w("LruCache", "Get cache error: InputStream is null. Cache name: " + str + ", Url: " + paramString);
          return locala;
        }
      }
      ram.w("LruCache", "Get cache error: snapshot is null. Cache name: " + str + ", Url: " + paramString + ",instance hashCode:" + ud());
      return locala;
    }
    ram.w("LruCache", "Get cache error: DiskCache or cacheName is null. Cache name: " + str + ", Url: " + paramString);
    return locala;
  }
  
  /* Error */
  public boolean a(String arg1, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: getfield 42	rxb:bx	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 220	rxb:aKq	Z
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 46	rxb:aDg	Ljava/lang/String;
    //   28: aload 7
    //   30: monitorexit
    //   31: aload_0
    //   32: invokespecial 55	rxb:initDiskCache	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 131	rxb:gs	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 11
    //   42: aload_0
    //   43: invokevirtual 59	rxb:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   46: ifnull +481 -> 527
    //   49: aload 11
    //   51: ifnull +476 -> 527
    //   54: aload_2
    //   55: ifnull +472 -> 527
    //   58: aload_0
    //   59: getfield 133	rxb:b	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   62: astore 10
    //   64: aload 10
    //   66: monitorenter
    //   67: aload_0
    //   68: invokevirtual 59	rxb:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   71: aload 11
    //   73: invokevirtual 137	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +409 -> 489
    //   83: new 222	java/io/BufferedOutputStream
    //   86: dup
    //   87: aload 9
    //   89: iconst_0
    //   90: invokevirtual 226	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   93: getstatic 28	rxb:IO_BUFFER_SIZE	I
    //   96: invokespecial 229	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   99: astore 8
    //   101: aload 8
    //   103: astore 7
    //   105: getstatic 28	rxb:IO_BUFFER_SIZE	I
    //   108: newarray byte
    //   110: astore 12
    //   112: aload 8
    //   114: astore 7
    //   116: aload_2
    //   117: aload 12
    //   119: invokevirtual 235	java/io/InputStream:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: iconst_m1
    //   125: if_icmpeq +25 -> 150
    //   128: aload 8
    //   130: astore 7
    //   132: aload_0
    //   133: getfield 220	rxb:aKq	Z
    //   136: ifne +193 -> 329
    //   139: aload 8
    //   141: astore 7
    //   143: ldc 35
    //   145: ldc 237
    //   147: invokestatic 240	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload 8
    //   152: astore 7
    //   154: aload 8
    //   156: invokevirtual 245	java/io/OutputStream:flush	()V
    //   159: aload 8
    //   161: astore 7
    //   163: aload 9
    //   165: invokevirtual 168	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   168: aload 8
    //   170: ifnull +418 -> 588
    //   173: aload 8
    //   175: invokevirtual 248	java/io/OutputStream:close	()V
    //   178: iconst_1
    //   179: istore 4
    //   181: ldc 35
    //   183: new 84	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   190: ldc 250
    //   192: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 11
    //   197: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 252
    //   202: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 254
    //   211: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: invokespecial 215	rxb:ud	()I
    //   218: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 154	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 133	rxb:b	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   231: invokevirtual 171	java/lang/Object:notifyAll	()V
    //   234: aload 10
    //   236: monitorexit
    //   237: iload 4
    //   239: istore 5
    //   241: aload_0
    //   242: getfield 220	rxb:aKq	Z
    //   245: ifne +12 -> 257
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 257	rxb:remove	(Ljava/lang/String;)V
    //   253: iload 4
    //   255: istore 5
    //   257: aload_0
    //   258: getfield 42	rxb:bx	Ljava/lang/Object;
    //   261: astore_1
    //   262: aload_1
    //   263: monitorenter
    //   264: aload_0
    //   265: iconst_0
    //   266: putfield 220	rxb:aKq	Z
    //   269: aload_0
    //   270: ldc 44
    //   272: putfield 46	rxb:aDg	Ljava/lang/String;
    //   275: aload_1
    //   276: monitorexit
    //   277: iload 5
    //   279: ireturn
    //   280: astore_1
    //   281: aload 7
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: astore 7
    //   288: ldc 35
    //   290: new 84	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 259
    //   300: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 11
    //   305: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 252
    //   310: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aconst_null
    //   324: astore 9
    //   326: goto -248 -> 78
    //   329: aload 8
    //   331: astore 7
    //   333: ldc 35
    //   335: new 84	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   342: aload 11
    //   344: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 261
    //   350: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_3
    //   354: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 118	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 8
    //   365: astore 7
    //   367: aload 8
    //   369: aload 12
    //   371: iconst_0
    //   372: iload_3
    //   373: invokevirtual 265	java/io/OutputStream:write	([BII)V
    //   376: goto -264 -> 112
    //   379: astore_2
    //   380: aload 8
    //   382: astore_2
    //   383: aload_2
    //   384: astore 7
    //   386: ldc 35
    //   388: new 84	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 267
    //   398: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 11
    //   403: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc 252
    //   408: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 254
    //   417: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: invokespecial 215	rxb:ud	()I
    //   424: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: iload 5
    //   435: istore 4
    //   437: aload_2
    //   438: ifnull -257 -> 181
    //   441: aload_2
    //   442: invokevirtual 248	java/io/OutputStream:close	()V
    //   445: iload 5
    //   447: istore 4
    //   449: goto -268 -> 181
    //   452: astore_2
    //   453: iload 5
    //   455: istore 4
    //   457: goto -276 -> 181
    //   460: astore_2
    //   461: iconst_1
    //   462: istore 4
    //   464: goto -283 -> 181
    //   467: astore_1
    //   468: aconst_null
    //   469: astore 7
    //   471: aload 7
    //   473: ifnull +8 -> 481
    //   476: aload 7
    //   478: invokevirtual 248	java/io/OutputStream:close	()V
    //   481: aload_1
    //   482: athrow
    //   483: astore_1
    //   484: aload 10
    //   486: monitorexit
    //   487: aload_1
    //   488: athrow
    //   489: ldc 35
    //   491: new 84	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   498: ldc_w 269
    //   501: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 11
    //   506: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 252
    //   511: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_1
    //   515: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: goto -297 -> 227
    //   527: ldc 35
    //   529: new 84	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 271
    //   539: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 11
    //   544: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc 252
    //   549: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_1
    //   553: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: iload 6
    //   564: istore 5
    //   566: goto -309 -> 257
    //   569: astore_2
    //   570: aload_1
    //   571: monitorexit
    //   572: aload_2
    //   573: athrow
    //   574: astore_2
    //   575: goto -94 -> 481
    //   578: astore_1
    //   579: goto -108 -> 471
    //   582: astore_2
    //   583: aconst_null
    //   584: astore_2
    //   585: goto -202 -> 383
    //   588: iconst_1
    //   589: istore 4
    //   591: goto -410 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	rxb
    //   0	594	2	paramInputStream	java.io.InputStream
    //   122	251	3	i	int
    //   1	589	4	bool1	boolean
    //   7	558	5	bool2	boolean
    //   4	559	6	bool3	boolean
    //   13	269	7	localObject1	Object
    //   286	1	7	localIOException	IOException
    //   331	146	7	localObject2	Object
    //   99	282	8	localBufferedOutputStream	java.io.BufferedOutputStream
    //   76	249	9	localEditor	DiskLruCache.Editor
    //   62	423	10	localDiskLruCache	DiskLruCache
    //   40	503	11	str	String
    //   110	260	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	31	280	finally
    //   281	284	280	finally
    //   67	78	286	java/io/IOException
    //   105	112	379	java/io/IOException
    //   116	123	379	java/io/IOException
    //   132	139	379	java/io/IOException
    //   143	150	379	java/io/IOException
    //   154	159	379	java/io/IOException
    //   163	168	379	java/io/IOException
    //   333	363	379	java/io/IOException
    //   367	376	379	java/io/IOException
    //   441	445	452	java/io/IOException
    //   173	178	460	java/io/IOException
    //   83	101	467	finally
    //   67	78	483	finally
    //   173	178	483	finally
    //   181	227	483	finally
    //   227	237	483	finally
    //   288	323	483	finally
    //   441	445	483	finally
    //   476	481	483	finally
    //   481	483	483	finally
    //   484	487	483	finally
    //   489	524	483	finally
    //   264	277	569	finally
    //   570	572	569	finally
    //   476	481	574	java/io/IOException
    //   105	112	578	finally
    //   116	123	578	finally
    //   132	139	578	finally
    //   143	150	578	finally
    //   154	159	578	finally
    //   163	168	578	finally
    //   333	363	578	finally
    //   367	376	578	finally
    //   386	433	578	finally
    //   83	101	582	java/io/IOException
  }
  
  public void clear()
  {
    initDiskCache();
    try
    {
      synchronized (this.b)
      {
        a().delete();
        return;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  /* Error */
  public boolean fR(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore_3
    //   10: aload_0
    //   11: invokespecial 55	rxb:initDiskCache	()V
    //   14: aload_0
    //   15: invokevirtual 59	rxb:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   18: ifnull +180 -> 198
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 131	rxb:gs	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 133	rxb:b	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: invokevirtual 59	rxb:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   44: aload 6
    //   46: invokevirtual 185	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +20 -> 73
    //   56: iload 4
    //   58: istore_2
    //   59: aload 8
    //   61: invokevirtual 280	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   64: iconst_1
    //   65: istore_3
    //   66: iload_3
    //   67: istore_2
    //   68: aload 7
    //   70: monitorexit
    //   71: iload_3
    //   72: ireturn
    //   73: iload 4
    //   75: istore_2
    //   76: ldc 35
    //   78: new 84	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 282
    //   88: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 6
    //   93: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 205
    //   98: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: goto -45 -> 66
    //   114: astore 6
    //   116: aload 7
    //   118: monitorexit
    //   119: aload 6
    //   121: athrow
    //   122: astore 6
    //   124: ldc 35
    //   126: new 84	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 284
    //   136: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iload_2
    //   150: ireturn
    //   151: astore 6
    //   153: iload 5
    //   155: istore_2
    //   156: ldc 35
    //   158: new 84	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 286
    //   168: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 107	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: iload_2
    //   182: ireturn
    //   183: astore 6
    //   185: goto -29 -> 156
    //   188: astore 6
    //   190: goto -66 -> 124
    //   193: astore 6
    //   195: goto -79 -> 116
    //   198: iconst_0
    //   199: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	rxb
    //   0	200	1	paramString	String
    //   4	178	2	bool1	boolean
    //   9	63	3	bool2	boolean
    //   1	73	4	bool3	boolean
    //   6	148	5	bool4	boolean
    //   26	66	6	str	String
    //   114	6	6	localObject1	Object
    //   122	1	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   151	1	6	localIOException1	IOException
    //   183	1	6	localIOException2	IOException
    //   188	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   193	1	6	localObject2	Object
    //   32	85	7	localDiskLruCache	DiskLruCache
    //   49	11	8	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   40	51	114	finally
    //   59	64	114	finally
    //   68	71	114	finally
    //   76	111	114	finally
    //   119	122	122	java/io/UnsupportedEncodingException
    //   21	37	151	java/io/IOException
    //   119	122	183	java/io/IOException
    //   21	37	188	java/io/UnsupportedEncodingException
    //   116	119	193	finally
  }
  
  protected void finalize()
  {
    try
    {
      super.finalize();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          a().close();
          return;
        }
        catch (IOException localIOException) {}
        localThrowable = localThrowable;
      }
    }
  }
  
  public String getCacheDir()
  {
    if (aqmb.aEZ()) {}
    for (String str = aqmb.Cg() + File.separator + "Android" + File.separator + "data" + File.separator + aDe + File.separator + "cache" + File.separator + nk();; str = aDf + File.separator + "cache" + File.separator + nk())
    {
      ram.d("LruCache", "Init cache dir: " + str);
      return str;
    }
  }
  
  protected abstract String nk();
  
  public void remove(String paramString)
  {
    initDiskCache();
    try
    {
      synchronized (this.b)
      {
        a().remove(gs(paramString));
        return;
      }
      return;
    }
    catch (IOException paramString)
    {
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  protected boolean w(File paramFile)
  {
    ram.d("LruCache", "Open cache dir.");
    try
    {
      this.b = DiskLruCache.open(paramFile, 1, 1, CA);
      label21:
      return false;
    }
    catch (IOException paramFile)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxb
 * JD-Core Version:    0.7.0.1
 */