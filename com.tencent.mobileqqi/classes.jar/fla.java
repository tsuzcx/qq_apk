class fla
  extends Thread
{
  boolean jdField_a_of_type_Boolean = false;
  
  fla(fky paramfky) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 26	java/io/File
    //   5: dup
    //   6: getstatic 31	com/tencent/mobileqq/app/ScreenShot:a	Ljava/lang/String;
    //   9: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 38	java/io/File:exists	()Z
    //   17: ifne +8 -> 25
    //   20: aload_2
    //   21: invokevirtual 41	java/io/File:mkdirs	()Z
    //   24: pop
    //   25: new 26	java/io/File
    //   28: dup
    //   29: new 43	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 31	com/tencent/mobileqq/app/ScreenShot:a	Ljava/lang/String;
    //   39: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   45: invokevirtual 57	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: ldc 59
    //   50: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull +50 -> 111
    //   64: new 65	java/io/FileOutputStream
    //   67: dup
    //   68: aload_3
    //   69: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 11	fla:jdField_a_of_type_Fky	Lfky;
    //   80: getfield 73	fky:a	Landroid/graphics/Bitmap;
    //   83: getstatic 79	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 80
    //   88: aload_2
    //   89: invokevirtual 85	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: putfield 16	fla:jdField_a_of_type_Boolean	Z
    //   95: aload_0
    //   96: getfield 11	fla:jdField_a_of_type_Fky	Lfky;
    //   99: aconst_null
    //   100: putfield 73	fky:a	Landroid/graphics/Bitmap;
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   111: new 90	android/os/Handler
    //   114: dup
    //   115: invokestatic 96	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   118: invokespecial 99	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   121: new 101	flb
    //   124: dup
    //   125: aload_0
    //   126: aload_3
    //   127: invokespecial 104	flb:<init>	(Lfla;Ljava/io/File;)V
    //   130: invokevirtual 108	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   133: pop
    //   134: return
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 16	fla:jdField_a_of_type_Boolean	Z
    //   145: aload_0
    //   146: getfield 11	fla:jdField_a_of_type_Fky	Lfky;
    //   149: aconst_null
    //   150: putfield 73	fky:a	Landroid/graphics/Bitmap;
    //   153: aload_2
    //   154: ifnull -43 -> 111
    //   157: aload_2
    //   158: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   161: goto -50 -> 111
    //   164: astore_1
    //   165: goto -54 -> 111
    //   168: astore_3
    //   169: aload_1
    //   170: astore_2
    //   171: aload_3
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 11	fla:jdField_a_of_type_Fky	Lfky;
    //   177: aconst_null
    //   178: putfield 73	fky:a	Landroid/graphics/Bitmap;
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: return
    //   193: astore_1
    //   194: goto -83 -> 111
    //   197: astore_2
    //   198: goto -9 -> 189
    //   201: astore_3
    //   202: aload_1
    //   203: astore_2
    //   204: aload_3
    //   205: astore_1
    //   206: goto -33 -> 173
    //   209: astore_1
    //   210: goto -72 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	fla
    //   1	74	1	localObject1	java.lang.Object
    //   135	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   139	1	1	localObject2	java.lang.Object
    //   164	6	1	localIOException1	java.io.IOException
    //   172	18	1	localObject3	java.lang.Object
    //   191	1	1	localException	java.lang.Exception
    //   193	10	1	localIOException2	java.io.IOException
    //   205	1	1	localObject4	java.lang.Object
    //   209	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   12	174	2	localObject5	java.lang.Object
    //   197	1	2	localIOException3	java.io.IOException
    //   203	1	2	localIOException4	java.io.IOException
    //   59	68	3	localFile	java.io.File
    //   168	4	3	localObject6	java.lang.Object
    //   201	4	3	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   64	73	135	java/io/FileNotFoundException
    //   157	161	164	java/io/IOException
    //   64	73	168	finally
    //   2	25	191	java/lang/Exception
    //   25	60	191	java/lang/Exception
    //   95	103	191	java/lang/Exception
    //   107	111	191	java/lang/Exception
    //   111	134	191	java/lang/Exception
    //   145	153	191	java/lang/Exception
    //   157	161	191	java/lang/Exception
    //   173	181	191	java/lang/Exception
    //   185	189	191	java/lang/Exception
    //   189	191	191	java/lang/Exception
    //   107	111	193	java/io/IOException
    //   185	189	197	java/io/IOException
    //   75	95	201	finally
    //   140	145	201	finally
    //   75	95	209	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fla
 * JD-Core Version:    0.7.0.1
 */