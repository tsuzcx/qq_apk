import android.app.Application;

public class aolx
  extends aoiz
{
  Application application;
  
  public aolx(Application paramApplication)
  {
    this.application = paramApplication;
  }
  
  /* Error */
  public java.io.File a(java.io.OutputStream paramOutputStream, com.tencent.image.DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 20	java/io/File
    //   9: dup
    //   10: getstatic 26	acbn:bmT	Ljava/lang/String;
    //   13: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 33	java/io/File:exists	()Z
    //   21: ifne +8 -> 29
    //   24: aload_3
    //   25: invokevirtual 36	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: aload_2
    //   30: getfield 42	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   33: invokevirtual 48	java/net/URL:getPath	()Ljava/lang/String;
    //   36: astore_1
    //   37: new 20	java/io/File
    //   40: dup
    //   41: new 50	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   48: aload_3
    //   49: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc 57
    //   54: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 7
    //   69: aload 7
    //   71: invokevirtual 33	java/io/File:exists	()Z
    //   74: ifeq +13 -> 87
    //   77: aload 7
    //   79: invokevirtual 67	java/io/File:length	()J
    //   82: lconst_0
    //   83: lcmp
    //   84: ifne +244 -> 328
    //   87: new 20	java/io/File
    //   90: dup
    //   91: new 50	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   98: aload_3
    //   99: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: ldc 57
    //   104: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 69
    //   113: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore 8
    //   124: aload 8
    //   126: invokevirtual 33	java/io/File:exists	()Z
    //   129: ifeq +9 -> 138
    //   132: aload 8
    //   134: invokevirtual 72	java/io/File:delete	()Z
    //   137: pop
    //   138: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +53 -> 194
    //   144: ldc 79
    //   146: iconst_2
    //   147: new 50	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   154: ldc 81
    //   156: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: getfield 84	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   163: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 86
    //   168: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 88
    //   177: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 7
    //   182: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   185: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_0
    //   195: getfield 13	aolx:application	Landroid/app/Application;
    //   198: invokevirtual 101	android/app/Application:getResources	()Landroid/content/res/Resources;
    //   201: aload_1
    //   202: ldc 103
    //   204: aload_0
    //   205: getfield 13	aolx:application	Landroid/app/Application;
    //   208: invokevirtual 106	android/app/Application:getPackageName	()Ljava/lang/String;
    //   211: invokevirtual 112	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   214: istore 4
    //   216: aload_0
    //   217: getfield 13	aolx:application	Landroid/app/Application;
    //   220: invokevirtual 101	android/app/Application:getResources	()Landroid/content/res/Resources;
    //   223: iload 4
    //   225: invokevirtual 116	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   228: astore_1
    //   229: sipush 4096
    //   232: newarray byte
    //   234: astore_2
    //   235: new 118	java/io/FileOutputStream
    //   238: dup
    //   239: aload 8
    //   241: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   244: astore_3
    //   245: aload_1
    //   246: aload_2
    //   247: invokevirtual 127	java/io/InputStream:read	([B)I
    //   250: iconst_m1
    //   251: if_icmpeq +53 -> 304
    //   254: aload_3
    //   255: aload_2
    //   256: invokevirtual 131	java/io/FileOutputStream:write	([B)V
    //   259: aload_3
    //   260: invokevirtual 134	java/io/FileOutputStream:flush	()V
    //   263: goto -18 -> 245
    //   266: astore 5
    //   268: aload_1
    //   269: astore_2
    //   270: aload_3
    //   271: astore_1
    //   272: aload 5
    //   274: astore_3
    //   275: aload_3
    //   276: athrow
    //   277: astore 5
    //   279: aload_1
    //   280: astore_3
    //   281: aload_2
    //   282: astore_1
    //   283: aload 5
    //   285: astore_2
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 137	java/io/InputStream:close	()V
    //   294: aload_3
    //   295: ifnull +7 -> 302
    //   298: aload_3
    //   299: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   302: aload_2
    //   303: athrow
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 137	java/io/InputStream:close	()V
    //   312: aload_3
    //   313: ifnull +7 -> 320
    //   316: aload_3
    //   317: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   320: aload 8
    //   322: aload 7
    //   324: invokevirtual 142	java/io/File:renameTo	(Ljava/io/File;)Z
    //   327: pop
    //   328: aload 7
    //   330: areturn
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: aload 5
    //   336: astore_3
    //   337: goto -51 -> 286
    //   340: astore_2
    //   341: aload 5
    //   343: astore_3
    //   344: goto -58 -> 286
    //   347: astore_2
    //   348: goto -62 -> 286
    //   351: astore_3
    //   352: aconst_null
    //   353: astore_1
    //   354: aload 6
    //   356: astore_2
    //   357: goto -82 -> 275
    //   360: astore_3
    //   361: aconst_null
    //   362: astore 5
    //   364: aload_1
    //   365: astore_2
    //   366: aload 5
    //   368: astore_1
    //   369: goto -94 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	aolx
    //   0	372	1	paramOutputStream	java.io.OutputStream
    //   0	372	2	paramDownloadParams	com.tencent.image.DownloadParams
    //   0	372	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   214	10	4	i	int
    //   1	1	5	localObject1	java.lang.Object
    //   266	7	5	localException	java.lang.Exception
    //   277	65	5	localObject2	java.lang.Object
    //   362	5	5	localObject3	java.lang.Object
    //   4	351	6	localObject4	java.lang.Object
    //   67	262	7	localFile1	java.io.File
    //   122	199	8	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   245	263	266	java/lang/Exception
    //   275	277	277	finally
    //   216	229	331	finally
    //   229	245	340	finally
    //   245	263	347	finally
    //   216	229	351	java/lang/Exception
    //   229	245	360	java/lang/Exception
  }
  
  public boolean azK()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolx
 * JD-Core Version:    0.7.0.1
 */