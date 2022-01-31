class bjy
  extends Thread
{
  boolean jdField_a_of_type_Boolean = false;
  
  bjy(bjw parambjw) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: getstatic 31	com/tencent/mobileqq/activity/SnapScreenActivity:a	Ljava/lang/String;
    //   7: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 38	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 41	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: new 26	java/io/File
    //   26: dup
    //   27: new 43	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   34: getstatic 31	com/tencent/mobileqq/activity/SnapScreenActivity:a	Ljava/lang/String;
    //   37: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   43: invokevirtual 57	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: ldc 59
    //   48: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +44 -> 103
    //   62: aconst_null
    //   63: astore_1
    //   64: new 65	java/io/FileOutputStream
    //   67: dup
    //   68: aload_3
    //   69: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 11	bjy:jdField_a_of_type_Bjw	Lbjw;
    //   80: getfield 73	bjw:a	Landroid/graphics/Bitmap;
    //   83: getstatic 79	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 80
    //   88: aload_2
    //   89: invokevirtual 85	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: putfield 16	bjy:jdField_a_of_type_Boolean	Z
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   103: aload_0
    //   104: getfield 11	bjy:jdField_a_of_type_Bjw	Lbjw;
    //   107: new 90	bjz
    //   110: dup
    //   111: aload_0
    //   112: aload_3
    //   113: invokespecial 93	bjz:<init>	(Lbjy;Ljava/io/File;)V
    //   116: invokevirtual 97	bjw:post	(Ljava/lang/Runnable;)Z
    //   119: pop
    //   120: return
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 16	bjy:jdField_a_of_type_Boolean	Z
    //   131: aload_2
    //   132: ifnull -29 -> 103
    //   135: aload_2
    //   136: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   139: goto -36 -> 103
    //   142: astore_1
    //   143: goto -40 -> 103
    //   146: astore_3
    //   147: aload_1
    //   148: astore_2
    //   149: aload_3
    //   150: astore_1
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: return
    //   163: astore_1
    //   164: goto -61 -> 103
    //   167: astore_2
    //   168: goto -9 -> 159
    //   171: astore_3
    //   172: aload_1
    //   173: astore_2
    //   174: aload_3
    //   175: astore_1
    //   176: goto -25 -> 151
    //   179: astore_1
    //   180: goto -56 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	bjy
    //   10	65	1	localObject1	java.lang.Object
    //   121	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	1	1	localObject2	java.lang.Object
    //   142	6	1	localIOException1	java.io.IOException
    //   150	10	1	localObject3	java.lang.Object
    //   161	1	1	localException	java.lang.Exception
    //   163	10	1	localIOException2	java.io.IOException
    //   175	1	1	localObject4	java.lang.Object
    //   179	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   72	84	2	localObject5	java.lang.Object
    //   167	1	2	localIOException3	java.io.IOException
    //   173	1	2	localIOException4	java.io.IOException
    //   57	56	3	localFile	java.io.File
    //   146	4	3	localObject6	java.lang.Object
    //   171	4	3	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   64	73	121	java/io/FileNotFoundException
    //   135	139	142	java/io/IOException
    //   64	73	146	finally
    //   0	23	161	java/lang/Exception
    //   23	58	161	java/lang/Exception
    //   99	103	161	java/lang/Exception
    //   103	120	161	java/lang/Exception
    //   135	139	161	java/lang/Exception
    //   155	159	161	java/lang/Exception
    //   159	161	161	java/lang/Exception
    //   99	103	163	java/io/IOException
    //   155	159	167	java/io/IOException
    //   75	95	171	finally
    //   126	131	171	finally
    //   75	95	179	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjy
 * JD-Core Version:    0.7.0.1
 */