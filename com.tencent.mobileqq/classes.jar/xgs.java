import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.File;
import java.io.IOException;

public abstract class xgs
  extends xgo
{
  protected static long a;
  protected static int b;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  protected DiskLruCache a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = xgs.class.getName();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = 10485760L;
  private String d = "";
  
  static
  {
    jdField_a_of_type_Long = 15728640L;
    jdField_b_of_type_Int = 8192;
  }
  
  public xgs(String paramString1, String paramString2)
  {
    jdField_b_of_type_JavaLangString = paramString1;
    c = paramString2;
    c();
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 57	xgs:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: invokevirtual 57	xgs:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   13: invokevirtual 63	com/jakewharton/disklrucache/DiskLruCache:isClosed	()Z
    //   16: ifeq +88 -> 104
    //   19: invokestatic 67	bbjn:c	()Z
    //   22: ifne +10 -> 32
    //   25: aload_0
    //   26: getfield 48	xgs:jdField_b_of_type_Long	J
    //   29: putstatic 20	xgs:jdField_a_of_type_Long	J
    //   32: aload_0
    //   33: invokevirtual 69	xgs:b	()Ljava/lang/String;
    //   36: astore_1
    //   37: new 71	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 77	java/io/File:exists	()Z
    //   50: ifne +57 -> 107
    //   53: aload_0
    //   54: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: new 79	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   64: ldc 82
    //   66: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 88
    //   75: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 20	xgs:jdField_a_of_type_Long	J
    //   81: invokestatic 93	bbkk:b	(J)Ljava/lang/String;
    //   84: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_2
    //   94: invokevirtual 103	java/io/File:mkdirs	()Z
    //   97: pop
    //   98: aload_0
    //   99: aload_2
    //   100: invokevirtual 106	xgs:a	(Ljava/io/File;)Z
    //   103: pop
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: aload_0
    //   108: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: new 79	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   118: ldc 82
    //   120: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 108
    //   129: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 20	xgs:jdField_a_of_type_Long	J
    //   135: invokestatic 93	bbkk:b	(J)Ljava/lang/String;
    //   138: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 110	ved:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: goto -49 -> 98
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	xgs
    //   36	88	1	str	String
    //   150	4	1	localObject	Object
    //   45	55	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	19	150	finally
    //   19	32	150	finally
    //   32	98	150	finally
    //   98	104	150	finally
    //   107	147	150	finally
  }
  
  protected DiskLruCache a()
  {
    return this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  }
  
  protected abstract String a();
  
  public xgp a(String paramString)
  {
    c();
    xgp localxgp = new xgp(this);
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
          ved.d(this.jdField_a_of_type_JavaLangString, "Get cache error: Cache name: " + str + ", Url: " + paramString);
        }
        ved.c(this.jdField_a_of_type_JavaLangString, "Get cache success: Cache name: " + str + ", Url: " + paramString);
        return localxgp;
      }
      if (localObject != null)
      {
        localxgp.a(localObject);
        localxgp.a(localObject.getInputStream(0));
        if (localxgp.a() == null)
        {
          ved.d(this.jdField_a_of_type_JavaLangString, "Get cache error: InputStream is null. Cache name: " + str + ", Url: " + paramString);
          return localxgp;
        }
      }
      ved.d(this.jdField_a_of_type_JavaLangString, "Get cache error: snapshot is null. Cache name: " + str + ", Url: " + paramString);
      return localxgp;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, "Get cache error: DiskCache or cacheName is null. Cache name: " + str + ", Url: " + paramString);
    return localxgp;
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
    ved.b(this.jdField_a_of_type_JavaLangString, "Open cache dir.");
    try
    {
      this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(paramFile, 1, 1, jdField_a_of_type_Long);
      label22:
      return false;
    }
    catch (IOException paramFile)
    {
      break label22;
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
    //   11: invokespecial 54	xgs:c	()V
    //   14: aload_0
    //   15: invokevirtual 57	xgs:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   18: ifnull +183 -> 201
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 123	xgs:a	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 112	xgs:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: invokevirtual 57	xgs:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   44: aload 6
    //   46: invokevirtual 127	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +20 -> 73
    //   56: iload 4
    //   58: istore_2
    //   59: aload 8
    //   61: invokevirtual 176	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
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
    //   76: aload_0
    //   77: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: new 79	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   87: ldc 178
    //   89: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 6
    //   94: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 146
    //   99: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto -46 -> 66
    //   115: astore 6
    //   117: aload 7
    //   119: monitorexit
    //   120: aload 6
    //   122: athrow
    //   123: astore 6
    //   125: aload_0
    //   126: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: new 79	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   136: ldc 180
    //   138: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_2
    //   152: ireturn
    //   153: astore 6
    //   155: iload 5
    //   157: istore_2
    //   158: aload_0
    //   159: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: new 79	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   169: ldc 182
    //   171: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: iload_2
    //   185: ireturn
    //   186: astore 6
    //   188: goto -30 -> 158
    //   191: astore 6
    //   193: goto -68 -> 125
    //   196: astore 6
    //   198: goto -81 -> 117
    //   201: iconst_0
    //   202: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	xgs
    //   0	203	1	paramString	String
    //   4	181	2	bool1	boolean
    //   9	63	3	bool2	boolean
    //   1	73	4	bool3	boolean
    //   6	150	5	bool4	boolean
    //   26	67	6	str	String
    //   115	6	6	localObject1	Object
    //   123	1	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   153	1	6	localIOException1	IOException
    //   186	1	6	localIOException2	IOException
    //   191	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   196	1	6	localObject2	Object
    //   32	86	7	localDiskLruCache	DiskLruCache
    //   49	11	8	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   40	51	115	finally
    //   59	64	115	finally
    //   68	71	115	finally
    //   76	112	115	finally
    //   120	123	123	java/io/UnsupportedEncodingException
    //   21	37	153	java/io/IOException
    //   120	123	186	java/io/IOException
    //   21	37	191	java/io/UnsupportedEncodingException
    //   117	120	196	finally
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
    //   10: getfield 40	xgs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 185	xgs:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 44	xgs:d	Ljava/lang/String;
    //   28: aload 7
    //   30: monitorexit
    //   31: aload_0
    //   32: invokespecial 54	xgs:c	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 123	xgs:a	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 11
    //   42: aload_0
    //   43: invokevirtual 57	xgs:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   46: ifnull +465 -> 511
    //   49: aload 11
    //   51: ifnull +460 -> 511
    //   54: aload_2
    //   55: ifnull +456 -> 511
    //   58: aload_0
    //   59: getfield 112	xgs:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   62: astore 10
    //   64: aload 10
    //   66: monitorenter
    //   67: aload_0
    //   68: invokevirtual 57	xgs:a	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   71: aload 11
    //   73: invokevirtual 189	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +392 -> 472
    //   83: new 191	java/io/BufferedOutputStream
    //   86: dup
    //   87: aload 9
    //   89: iconst_0
    //   90: invokevirtual 197	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   93: getstatic 22	xgs:jdField_b_of_type_Int	I
    //   96: invokespecial 200	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   99: astore 8
    //   101: aload 8
    //   103: astore 7
    //   105: getstatic 22	xgs:jdField_b_of_type_Int	I
    //   108: newarray byte
    //   110: astore 12
    //   112: aload 8
    //   114: astore 7
    //   116: aload_2
    //   117: aload 12
    //   119: invokevirtual 206	java/io/InputStream:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: iconst_m1
    //   125: if_icmpeq +27 -> 152
    //   128: aload 8
    //   130: astore 7
    //   132: aload_0
    //   133: getfield 185	xgs:jdField_a_of_type_Boolean	Z
    //   136: ifne +186 -> 322
    //   139: aload 8
    //   141: astore 7
    //   143: aload_0
    //   144: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: ldc 208
    //   149: invokestatic 211	ved:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 8
    //   154: astore 7
    //   156: aload 8
    //   158: invokevirtual 216	java/io/OutputStream:flush	()V
    //   161: aload 8
    //   163: astore 7
    //   165: aload 9
    //   167: invokevirtual 219	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   170: aload 8
    //   172: ifnull +401 -> 573
    //   175: aload 8
    //   177: invokevirtual 220	java/io/OutputStream:close	()V
    //   180: iconst_1
    //   181: istore 4
    //   183: aload_0
    //   184: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: new 79	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   194: ldc 222
    //   196: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 11
    //   201: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 224
    //   206: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 152	ved:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 112	xgs:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   223: invokevirtual 227	java/lang/Object:notifyAll	()V
    //   226: aload 10
    //   228: monitorexit
    //   229: iload 4
    //   231: istore 5
    //   233: aload_0
    //   234: getfield 185	xgs:jdField_a_of_type_Boolean	Z
    //   237: ifne +12 -> 249
    //   240: aload_0
    //   241: aload_1
    //   242: invokevirtual 229	xgs:a	(Ljava/lang/String;)V
    //   245: iload 4
    //   247: istore 5
    //   249: aload_0
    //   250: getfield 40	xgs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   253: astore_1
    //   254: aload_1
    //   255: monitorenter
    //   256: aload_0
    //   257: iconst_0
    //   258: putfield 185	xgs:jdField_a_of_type_Boolean	Z
    //   261: aload_0
    //   262: ldc 42
    //   264: putfield 44	xgs:d	Ljava/lang/String;
    //   267: aload_1
    //   268: monitorexit
    //   269: iload 5
    //   271: ireturn
    //   272: astore_1
    //   273: aload 7
    //   275: monitorexit
    //   276: aload_1
    //   277: athrow
    //   278: astore 7
    //   280: aload_0
    //   281: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   284: new 79	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   291: ldc 231
    //   293: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 11
    //   298: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 224
    //   303: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aconst_null
    //   317: astore 9
    //   319: goto -241 -> 78
    //   322: aload 8
    //   324: astore 7
    //   326: aload_0
    //   327: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: new 79	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   337: aload 11
    //   339: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 233
    //   344: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload_3
    //   348: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 110	ved:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 8
    //   359: astore 7
    //   361: aload 8
    //   363: aload 12
    //   365: iconst_0
    //   366: iload_3
    //   367: invokevirtual 240	java/io/OutputStream:write	([BII)V
    //   370: goto -258 -> 112
    //   373: astore_2
    //   374: aload 8
    //   376: astore_2
    //   377: aload_2
    //   378: astore 7
    //   380: aload_0
    //   381: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   384: new 79	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   391: ldc 242
    //   393: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 11
    //   398: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc 224
    //   403: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: iload 5
    //   418: istore 4
    //   420: aload_2
    //   421: ifnull -238 -> 183
    //   424: aload_2
    //   425: invokevirtual 220	java/io/OutputStream:close	()V
    //   428: iload 5
    //   430: istore 4
    //   432: goto -249 -> 183
    //   435: astore_2
    //   436: iload 5
    //   438: istore 4
    //   440: goto -257 -> 183
    //   443: astore_2
    //   444: iconst_1
    //   445: istore 4
    //   447: goto -264 -> 183
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 7
    //   454: aload 7
    //   456: ifnull +8 -> 464
    //   459: aload 7
    //   461: invokevirtual 220	java/io/OutputStream:close	()V
    //   464: aload_1
    //   465: athrow
    //   466: astore_1
    //   467: aload 10
    //   469: monitorexit
    //   470: aload_1
    //   471: athrow
    //   472: aload_0
    //   473: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: new 79	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   483: ldc 244
    //   485: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 11
    //   490: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc 224
    //   495: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: goto -289 -> 219
    //   511: aload_0
    //   512: getfield 35	xgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   515: new 79	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   522: ldc 246
    //   524: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 11
    //   529: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc 224
    //   534: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_1
    //   538: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 100	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: iload 6
    //   549: istore 5
    //   551: goto -302 -> 249
    //   554: astore_2
    //   555: aload_1
    //   556: monitorexit
    //   557: aload_2
    //   558: athrow
    //   559: astore_2
    //   560: goto -96 -> 464
    //   563: astore_1
    //   564: goto -110 -> 454
    //   567: astore_2
    //   568: aconst_null
    //   569: astore_2
    //   570: goto -193 -> 377
    //   573: iconst_1
    //   574: istore 4
    //   576: goto -393 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	xgs
    //   0	579	2	paramInputStream	java.io.InputStream
    //   122	245	3	i	int
    //   1	574	4	bool1	boolean
    //   7	543	5	bool2	boolean
    //   4	544	6	bool3	boolean
    //   13	261	7	localObject1	Object
    //   278	1	7	localIOException	IOException
    //   324	136	7	localObject2	Object
    //   99	276	8	localBufferedOutputStream	java.io.BufferedOutputStream
    //   76	242	9	localEditor	DiskLruCache.Editor
    //   62	406	10	localDiskLruCache	DiskLruCache
    //   40	488	11	str	String
    //   110	254	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	31	272	finally
    //   273	276	272	finally
    //   67	78	278	java/io/IOException
    //   105	112	373	java/io/IOException
    //   116	123	373	java/io/IOException
    //   132	139	373	java/io/IOException
    //   143	152	373	java/io/IOException
    //   156	161	373	java/io/IOException
    //   165	170	373	java/io/IOException
    //   326	357	373	java/io/IOException
    //   361	370	373	java/io/IOException
    //   424	428	435	java/io/IOException
    //   175	180	443	java/io/IOException
    //   83	101	450	finally
    //   67	78	466	finally
    //   175	180	466	finally
    //   183	219	466	finally
    //   219	229	466	finally
    //   280	316	466	finally
    //   424	428	466	finally
    //   459	464	466	finally
    //   464	466	466	finally
    //   467	470	466	finally
    //   472	508	466	finally
    //   256	269	554	finally
    //   555	557	554	finally
    //   459	464	559	java/io/IOException
    //   105	112	563	finally
    //   116	123	563	finally
    //   132	139	563	finally
    //   143	152	563	finally
    //   156	161	563	finally
    //   165	170	563	finally
    //   326	357	563	finally
    //   361	370	563	finally
    //   380	416	563	finally
    //   83	101	567	java/io/IOException
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
          ved.d(this.jdField_a_of_type_JavaLangString, "Set cache error: Exception ");
        }
      }
      finally {}
      bool1 = bool2;
      if (localObject != null) {
        ved.c(this.jdField_a_of_type_JavaLangString, "name: " + paramString1 + ", Cache name: " + str + ", value length: " + paramString2.length());
      }
      try
      {
        localObject.set(0, sdp.a(paramString2));
        localObject.commit();
        bool1 = true;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          ved.d(this.jdField_a_of_type_JavaLangString, "Commit cache error: Exception ");
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
    if (bbjn.c()) {}
    for (String str = bbjn.a() + File.separator + "Android" + File.separator + "data" + File.separator + jdField_b_of_type_JavaLangString + File.separator + a();; str = c + File.separator + a())
    {
      ved.b(this.jdField_a_of_type_JavaLangString, "Init cache dir: " + str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgs
 * JD-Core Version:    0.7.0.1
 */