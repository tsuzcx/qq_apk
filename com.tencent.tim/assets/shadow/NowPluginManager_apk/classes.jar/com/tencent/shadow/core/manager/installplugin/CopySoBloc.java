package com.tencent.shadow.core.manager.installplugin;

import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.util.concurrent.ConcurrentHashMap;

public class CopySoBloc
{
  private static final Logger mLogger = LoggerFactory.getLogger(CopySoBloc.class);
  private static ConcurrentHashMap<String, Object> sLocks = new ConcurrentHashMap();
  
  /* Error */
  public static java.io.File copySo(java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: invokevirtual 40	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   7: astore 9
    //   9: getstatic 26	com/tencent/shadow/core/manager/installplugin/CopySoBloc:sLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload 9
    //   14: invokevirtual 44	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore 7
    //   19: aload 7
    //   21: astore 6
    //   23: aload 7
    //   25: ifnonnull +23 -> 48
    //   28: new 4	java/lang/Object
    //   31: dup
    //   32: invokespecial 28	java/lang/Object:<init>	()V
    //   35: astore 6
    //   37: getstatic 26	com/tencent/shadow/core/manager/installplugin/CopySoBloc:sLocks	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload 9
    //   42: aload 6
    //   44: invokevirtual 48	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload 6
    //   50: monitorenter
    //   51: aload_3
    //   52: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +10 -> 65
    //   58: aload_2
    //   59: invokevirtual 58	java/io/File:exists	()Z
    //   62: ifeq +8 -> 70
    //   65: aload 6
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: aload_1
    //   71: invokevirtual 58	java/io/File:exists	()Z
    //   74: ifeq +51 -> 125
    //   77: aload_1
    //   78: invokevirtual 61	java/io/File:isFile	()Z
    //   81: ifeq +44 -> 125
    //   84: new 63	com/tencent/shadow/core/manager/installplugin/InstallPluginException
    //   87: dup
    //   88: new 65	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   95: ldc 68
    //   97: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 40	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   104: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 74
    //   109: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 80	com/tencent/shadow/core/manager/installplugin/InstallPluginException:<init>	(Ljava/lang/String;)V
    //   118: athrow
    //   119: astore_0
    //   120: aload 6
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    //   125: aload_1
    //   126: invokevirtual 83	java/io/File:mkdirs	()Z
    //   129: pop
    //   130: new 85	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream
    //   133: dup
    //   134: new 87	java/io/FileInputStream
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   142: invokespecial 93	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   145: astore 7
    //   147: aload 7
    //   149: invokevirtual 97	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   152: astore 8
    //   154: aload 8
    //   156: ifnull +203 -> 359
    //   159: aload 8
    //   161: invokevirtual 102	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   164: aload_3
    //   165: invokevirtual 108	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   168: istore 5
    //   170: iload 5
    //   172: ifeq -25 -> 147
    //   175: new 110	java/io/BufferedOutputStream
    //   178: dup
    //   179: new 112	java/io/FileOutputStream
    //   182: dup
    //   183: new 36	java/io/File
    //   186: dup
    //   187: aload_1
    //   188: aload 8
    //   190: invokevirtual 102	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   193: aload_3
    //   194: invokevirtual 116	java/lang/String:length	()I
    //   197: invokevirtual 120	java/lang/String:substring	(I)Ljava/lang/String;
    //   200: invokespecial 123	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   203: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   206: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   209: astore 8
    //   211: new 129	java/io/BufferedInputStream
    //   214: dup
    //   215: aload 7
    //   217: invokespecial 130	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   220: astore 9
    //   222: sipush 8192
    //   225: newarray byte
    //   227: astore 10
    //   229: aload 9
    //   231: aload 10
    //   233: iconst_0
    //   234: sipush 8192
    //   237: invokevirtual 134	java/io/BufferedInputStream:read	([BII)I
    //   240: istore 4
    //   242: iload 4
    //   244: iflt +90 -> 334
    //   247: aload 8
    //   249: aload 10
    //   251: iconst_0
    //   252: iload 4
    //   254: invokevirtual 138	java/io/BufferedOutputStream:write	([BII)V
    //   257: goto -28 -> 229
    //   260: astore_1
    //   261: aload 8
    //   263: astore_2
    //   264: aload 7
    //   266: invokevirtual 141	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream:closeEntry	()V
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 144	java/io/BufferedOutputStream:close	()V
    //   277: aload_1
    //   278: athrow
    //   279: astore_2
    //   280: aload 7
    //   282: astore_1
    //   283: new 63	com/tencent/shadow/core/manager/installplugin/InstallPluginException
    //   286: dup
    //   287: new 65	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   294: ldc 146
    //   296: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: invokevirtual 40	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   303: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 148
    //   308: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_3
    //   312: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: aload_2
    //   319: invokespecial 151	com/tencent/shadow/core/manager/installplugin/InstallPluginException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   322: athrow
    //   323: astore_0
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 152	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream:close	()V
    //   332: aload_0
    //   333: athrow
    //   334: aload 7
    //   336: invokevirtual 141	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream:closeEntry	()V
    //   339: aload 8
    //   341: ifnull -194 -> 147
    //   344: aload 8
    //   346: invokevirtual 144	java/io/BufferedOutputStream:close	()V
    //   349: goto -202 -> 147
    //   352: astore_0
    //   353: aload 7
    //   355: astore_1
    //   356: goto -32 -> 324
    //   359: aload_2
    //   360: invokevirtual 155	java/io/File:createNewFile	()Z
    //   363: pop
    //   364: aload 7
    //   366: ifnull +8 -> 374
    //   369: aload 7
    //   371: invokevirtual 152	com/tencent/shadow/core/manager/installplugin/SafeZipInputStream:close	()V
    //   374: aload 6
    //   376: monitorexit
    //   377: aload_1
    //   378: areturn
    //   379: astore_1
    //   380: new 63	com/tencent/shadow/core/manager/installplugin/InstallPluginException
    //   383: dup
    //   384: new 65	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   391: ldc 157
    //   393: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_2
    //   397: invokevirtual 40	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   400: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: aload_1
    //   407: invokespecial 151	com/tencent/shadow/core/manager/installplugin/InstallPluginException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   410: athrow
    //   411: astore_0
    //   412: getstatic 19	com/tencent/shadow/core/manager/installplugin/CopySoBloc:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   415: ldc 159
    //   417: aload_0
    //   418: invokeinterface 164 3 0
    //   423: goto -49 -> 374
    //   426: astore_1
    //   427: getstatic 19	com/tencent/shadow/core/manager/installplugin/CopySoBloc:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   430: ldc 159
    //   432: aload_1
    //   433: invokeinterface 164 3 0
    //   438: goto -106 -> 332
    //   441: astore_0
    //   442: aconst_null
    //   443: astore_1
    //   444: goto -120 -> 324
    //   447: astore_2
    //   448: aload 8
    //   450: astore_1
    //   451: goto -168 -> 283
    //   454: astore_1
    //   455: aconst_null
    //   456: astore_2
    //   457: goto -193 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	paramFile1	java.io.File
    //   0	460	1	paramFile2	java.io.File
    //   0	460	2	paramFile3	java.io.File
    //   0	460	3	paramString	String
    //   240	13	4	i	int
    //   168	3	5	bool	boolean
    //   21	354	6	localObject1	Object
    //   17	353	7	localObject2	Object
    //   1	448	8	localObject3	Object
    //   7	223	9	localObject4	Object
    //   227	23	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   51	65	119	finally
    //   65	68	119	finally
    //   70	119	119	finally
    //   120	123	119	finally
    //   125	130	119	finally
    //   328	332	119	finally
    //   332	334	119	finally
    //   369	374	119	finally
    //   374	377	119	finally
    //   412	423	119	finally
    //   427	438	119	finally
    //   211	229	260	finally
    //   229	242	260	finally
    //   247	257	260	finally
    //   147	154	279	java/lang/Exception
    //   159	170	279	java/lang/Exception
    //   264	269	279	java/lang/Exception
    //   273	277	279	java/lang/Exception
    //   277	279	279	java/lang/Exception
    //   334	339	279	java/lang/Exception
    //   344	349	279	java/lang/Exception
    //   359	364	279	java/lang/Exception
    //   380	411	279	java/lang/Exception
    //   283	323	323	finally
    //   147	154	352	finally
    //   159	170	352	finally
    //   264	269	352	finally
    //   273	277	352	finally
    //   277	279	352	finally
    //   334	339	352	finally
    //   344	349	352	finally
    //   359	364	352	finally
    //   380	411	352	finally
    //   359	364	379	java/io/IOException
    //   369	374	411	java/io/IOException
    //   328	332	426	java/io/IOException
    //   130	147	441	finally
    //   130	147	447	java/lang/Exception
    //   175	211	454	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.CopySoBloc
 * JD-Core Version:    0.7.0.1
 */