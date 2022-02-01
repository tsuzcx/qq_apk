import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.File;
import java.io.IOException;

public abstract class zwy
  extends zwu
{
  protected static long a;
  protected static int b;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  protected DiskLruCache a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "LruCache";
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = 15728640L;
  private String d = "";
  
  static
  {
    jdField_a_of_type_Long = 15728640L;
    jdField_b_of_type_Int = 8192;
  }
  
  public zwy(String paramString1, String paramString2)
  {
    jdField_b_of_type_JavaLangString = paramString1;
    c = paramString2;
    c();
  }
  
  private int a()
  {
    if (a() == null) {
      return 0;
    }
    return a().hashCode();
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 52	zwy:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: invokevirtual 52	zwy:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   13: invokevirtual 61	com/jakewharton/disklrucache/DiskLruCache:isClosed	()Z
    //   16: ifeq +86 -> 102
    //   19: invokestatic 65	bgru:c	()Z
    //   22: ifne +10 -> 32
    //   25: aload_0
    //   26: getfield 42	zwy:jdField_b_of_type_Long	J
    //   29: putstatic 20	zwy:jdField_a_of_type_Long	J
    //   32: aload_0
    //   33: invokevirtual 68	zwy:b	()Ljava/lang/String;
    //   36: astore_1
    //   37: new 70	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 76	java/io/File:exists	()Z
    //   50: ifne +55 -> 105
    //   53: ldc 29
    //   55: new 78	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   62: ldc 81
    //   64: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 87
    //   73: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 20	zwy:jdField_a_of_type_Long	J
    //   79: invokestatic 92	bgsp:a	(J)Ljava/lang/String;
    //   82: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: invokevirtual 102	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 105	zwy:a	(Ljava/io/File;)Z
    //   101: pop
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: ldc 29
    //   107: new 78	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   114: ldc 81
    //   116: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 107
    //   125: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 20	zwy:jdField_a_of_type_Long	J
    //   131: invokestatic 92	bgsp:a	(J)Ljava/lang/String;
    //   134: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 109	yqp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -47 -> 96
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	zwy
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
  
  protected DiskLruCache a()
  {
    return this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  }
  
  protected abstract String a();
  
  public zwv a(String paramString)
  {
    c();
    zwv localzwv = new zwv(this);
    String str = a(paramString);
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
          yqp.d("LruCache", "Get cache error: Cache name: " + str + ", Url: " + paramString);
        }
        yqp.c("LruCache", "Get cache success: Cache name: " + str + ", Url: " + paramString);
        return localzwv;
      }
      if (localObject != null)
      {
        localzwv.a(localObject);
        localzwv.a(localObject.getInputStream(0));
        if (localzwv.a() == null)
        {
          yqp.d("LruCache", "Get cache error: InputStream is null. Cache name: " + str + ", Url: " + paramString);
          return localzwv;
        }
      }
      yqp.d("LruCache", "Get cache error: snapshot is null. Cache name: " + str + ", Url: " + paramString + ",instance hashCode:" + a());
      return localzwv;
    }
    yqp.d("LruCache", "Get cache error: DiskCache or cacheName is null. Cache name: " + str + ", Url: " + paramString);
    return localzwv;
  }
  
  public void a()
  {
    c();
    try
    {
      synchronized (this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache)
      {
        a().delete();
        return;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void a(String paramString)
  {
    c();
    try
    {
      synchronized (this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache)
      {
        a().remove(a(paramString));
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
  
  protected boolean a(File paramFile)
  {
    yqp.b("LruCache", "Open cache dir.");
    try
    {
      this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(paramFile, 1, 1, jdField_a_of_type_Long);
      label20:
      return false;
    }
    catch (IOException paramFile)
    {
      break label20;
    }
  }
  
  /* Error */
  public boolean a(String paramString)
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
    //   11: invokespecial 48	zwy:c	()V
    //   14: aload_0
    //   15: invokevirtual 52	zwy:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   18: ifnull +177 -> 195
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 122	zwy:a	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 111	zwy:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: invokevirtual 52	zwy:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   44: aload 6
    //   46: invokevirtual 126	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +20 -> 73
    //   56: iload 4
    //   58: istore_2
    //   59: aload 8
    //   61: invokevirtual 182	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
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
    //   76: ldc 29
    //   78: new 78	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   85: ldc 184
    //   87: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 6
    //   92: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 145
    //   97: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -44 -> 66
    //   113: astore 6
    //   115: aload 7
    //   117: monitorexit
    //   118: aload 6
    //   120: athrow
    //   121: astore 6
    //   123: ldc 29
    //   125: new 78	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   132: ldc 186
    //   134: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: iload_2
    //   148: ireturn
    //   149: astore 6
    //   151: iload 5
    //   153: istore_2
    //   154: ldc 29
    //   156: new 78	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   163: ldc 188
    //   165: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: iload_2
    //   179: ireturn
    //   180: astore 6
    //   182: goto -28 -> 154
    //   185: astore 6
    //   187: goto -64 -> 123
    //   190: astore 6
    //   192: goto -77 -> 115
    //   195: iconst_0
    //   196: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	zwy
    //   0	197	1	paramString	String
    //   4	175	2	bool1	boolean
    //   9	63	3	bool2	boolean
    //   1	73	4	bool3	boolean
    //   6	146	5	bool4	boolean
    //   26	65	6	str	String
    //   113	6	6	localObject1	Object
    //   121	1	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   149	1	6	localIOException1	IOException
    //   180	1	6	localIOException2	IOException
    //   185	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   190	1	6	localObject2	Object
    //   32	84	7	localDiskLruCache	DiskLruCache
    //   49	11	8	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   40	51	113	finally
    //   59	64	113	finally
    //   68	71	113	finally
    //   76	110	113	finally
    //   118	121	121	java/io/UnsupportedEncodingException
    //   21	37	149	java/io/IOException
    //   118	121	180	java/io/IOException
    //   21	37	185	java/io/UnsupportedEncodingException
    //   115	118	190	finally
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
    //   10: getfield 36	zwy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 191	zwy:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 40	zwy:d	Ljava/lang/String;
    //   28: aload 7
    //   30: monitorexit
    //   31: aload_0
    //   32: invokespecial 48	zwy:c	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 122	zwy:a	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 11
    //   42: aload_0
    //   43: invokevirtual 52	zwy:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   46: ifnull +477 -> 523
    //   49: aload 11
    //   51: ifnull +472 -> 523
    //   54: aload_2
    //   55: ifnull +468 -> 523
    //   58: aload_0
    //   59: getfield 111	zwy:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   62: astore 10
    //   64: aload 10
    //   66: monitorenter
    //   67: aload_0
    //   68: invokevirtual 52	zwy:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   71: aload 11
    //   73: invokevirtual 195	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +406 -> 486
    //   83: new 197	java/io/BufferedOutputStream
    //   86: dup
    //   87: aload 9
    //   89: iconst_0
    //   90: invokevirtual 203	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   93: getstatic 22	zwy:jdField_b_of_type_Int	I
    //   96: invokespecial 206	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   99: astore 8
    //   101: aload 8
    //   103: astore 7
    //   105: getstatic 22	zwy:jdField_b_of_type_Int	I
    //   108: newarray byte
    //   110: astore 12
    //   112: aload 8
    //   114: astore 7
    //   116: aload_2
    //   117: aload 12
    //   119: invokevirtual 212	java/io/InputStream:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: iconst_m1
    //   125: if_icmpeq +25 -> 150
    //   128: aload 8
    //   130: astore 7
    //   132: aload_0
    //   133: getfield 191	zwy:jdField_a_of_type_Boolean	Z
    //   136: ifne +192 -> 328
    //   139: aload 8
    //   141: astore 7
    //   143: ldc 29
    //   145: ldc 214
    //   147: invokestatic 217	yqp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload 8
    //   152: astore 7
    //   154: aload 8
    //   156: invokevirtual 222	java/io/OutputStream:flush	()V
    //   159: aload 8
    //   161: astore 7
    //   163: aload 9
    //   165: invokevirtual 225	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   168: aload 8
    //   170: ifnull +413 -> 583
    //   173: aload 8
    //   175: invokevirtual 226	java/io/OutputStream:close	()V
    //   178: iconst_1
    //   179: istore 4
    //   181: ldc 29
    //   183: new 78	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   190: ldc 228
    //   192: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 11
    //   197: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 230
    //   202: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 232
    //   211: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: invokespecial 157	zwy:a	()I
    //   218: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 151	yqp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 111	zwy:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   231: invokevirtual 235	java/lang/Object:notifyAll	()V
    //   234: aload 10
    //   236: monitorexit
    //   237: iload 4
    //   239: istore 5
    //   241: aload_0
    //   242: getfield 191	zwy:jdField_a_of_type_Boolean	Z
    //   245: ifne +12 -> 257
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 237	zwy:a	(Ljava/lang/String;)V
    //   253: iload 4
    //   255: istore 5
    //   257: aload_0
    //   258: getfield 36	zwy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   261: astore_1
    //   262: aload_1
    //   263: monitorenter
    //   264: aload_0
    //   265: iconst_0
    //   266: putfield 191	zwy:jdField_a_of_type_Boolean	Z
    //   269: aload_0
    //   270: ldc 38
    //   272: putfield 40	zwy:d	Ljava/lang/String;
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
    //   288: ldc 29
    //   290: new 78	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   297: ldc 239
    //   299: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 11
    //   304: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc 230
    //   309: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_1
    //   313: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aconst_null
    //   323: astore 9
    //   325: goto -247 -> 78
    //   328: aload 8
    //   330: astore 7
    //   332: ldc 29
    //   334: new 78	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   341: aload 11
    //   343: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 241
    //   348: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload_3
    //   352: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 109	yqp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 8
    //   363: astore 7
    //   365: aload 8
    //   367: aload 12
    //   369: iconst_0
    //   370: iload_3
    //   371: invokevirtual 245	java/io/OutputStream:write	([BII)V
    //   374: goto -262 -> 112
    //   377: astore_2
    //   378: aload 8
    //   380: astore_2
    //   381: aload_2
    //   382: astore 7
    //   384: ldc 29
    //   386: new 78	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   393: ldc 247
    //   395: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 11
    //   400: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc 230
    //   405: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_1
    //   409: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc 232
    //   414: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: invokespecial 157	zwy:a	()I
    //   421: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: iload 5
    //   432: istore 4
    //   434: aload_2
    //   435: ifnull -254 -> 181
    //   438: aload_2
    //   439: invokevirtual 226	java/io/OutputStream:close	()V
    //   442: iload 5
    //   444: istore 4
    //   446: goto -265 -> 181
    //   449: astore_2
    //   450: iload 5
    //   452: istore 4
    //   454: goto -273 -> 181
    //   457: astore_2
    //   458: iconst_1
    //   459: istore 4
    //   461: goto -280 -> 181
    //   464: astore_1
    //   465: aconst_null
    //   466: astore 7
    //   468: aload 7
    //   470: ifnull +8 -> 478
    //   473: aload 7
    //   475: invokevirtual 226	java/io/OutputStream:close	()V
    //   478: aload_1
    //   479: athrow
    //   480: astore_1
    //   481: aload 10
    //   483: monitorexit
    //   484: aload_1
    //   485: athrow
    //   486: ldc 29
    //   488: new 78	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   495: ldc 249
    //   497: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload 11
    //   502: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc 230
    //   507: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_1
    //   511: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: goto -293 -> 227
    //   523: ldc 29
    //   525: new 78	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   532: ldc 251
    //   534: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload 11
    //   539: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc 230
    //   544: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_1
    //   548: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 99	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: iload 6
    //   559: istore 5
    //   561: goto -304 -> 257
    //   564: astore_2
    //   565: aload_1
    //   566: monitorexit
    //   567: aload_2
    //   568: athrow
    //   569: astore_2
    //   570: goto -92 -> 478
    //   573: astore_1
    //   574: goto -106 -> 468
    //   577: astore_2
    //   578: aconst_null
    //   579: astore_2
    //   580: goto -199 -> 381
    //   583: iconst_1
    //   584: istore 4
    //   586: goto -405 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	zwy
    //   0	589	2	paramInputStream	java.io.InputStream
    //   122	249	3	i	int
    //   1	584	4	bool1	boolean
    //   7	553	5	bool2	boolean
    //   4	554	6	bool3	boolean
    //   13	269	7	localObject1	Object
    //   286	1	7	localIOException	IOException
    //   330	144	7	localObject2	Object
    //   99	280	8	localBufferedOutputStream	java.io.BufferedOutputStream
    //   76	248	9	localEditor	DiskLruCache.Editor
    //   62	420	10	localDiskLruCache	DiskLruCache
    //   40	498	11	str	String
    //   110	258	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	31	280	finally
    //   281	284	280	finally
    //   67	78	286	java/io/IOException
    //   105	112	377	java/io/IOException
    //   116	123	377	java/io/IOException
    //   132	139	377	java/io/IOException
    //   143	150	377	java/io/IOException
    //   154	159	377	java/io/IOException
    //   163	168	377	java/io/IOException
    //   332	361	377	java/io/IOException
    //   365	374	377	java/io/IOException
    //   438	442	449	java/io/IOException
    //   173	178	457	java/io/IOException
    //   83	101	464	finally
    //   67	78	480	finally
    //   173	178	480	finally
    //   181	227	480	finally
    //   227	237	480	finally
    //   288	322	480	finally
    //   438	442	480	finally
    //   473	478	480	finally
    //   478	480	480	finally
    //   481	484	480	finally
    //   486	520	480	finally
    //   264	277	564	finally
    //   565	567	564	finally
    //   473	478	569	java/io/IOException
    //   105	112	573	finally
    //   116	123	573	finally
    //   132	139	573	finally
    //   143	150	573	finally
    //   154	159	573	finally
    //   163	168	573	finally
    //   332	361	573	finally
    //   365	374	573	finally
    //   384	430	573	finally
    //   83	101	577	java/io/IOException
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    c();
    String str = a(paramString1);
    DiskLruCache localDiskLruCache;
    boolean bool1;
    if ((a() != null) && (str != null))
    {
      localDiskLruCache = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
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
          yqp.d("LruCache", "Set cache error: Exception ");
        }
      }
      finally {}
      bool1 = bool2;
      if (localObject != null) {
        yqp.c("LruCache", "name: " + paramString1 + ", Cache name: " + str + ", value length: " + paramString2.length());
      }
      try
      {
        localObject.set(0, tww.a(paramString2));
        localObject.commit();
        bool1 = true;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          yqp.d("LruCache", "Commit cache error: Exception ");
          bool1 = bool2;
        }
      }
      this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.notifyAll();
      return bool1;
    }
    return false;
  }
  
  public String b()
  {
    if (bgru.c()) {}
    for (String str = bgru.a() + File.separator + "Android" + File.separator + "data" + File.separator + jdField_b_of_type_JavaLangString + File.separator + "cache" + File.separator + a();; str = c + File.separator + "cache" + File.separator + a())
    {
      yqp.b("LruCache", "Init cache dir: " + str);
      return str;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwy
 * JD-Core Version:    0.7.0.1
 */