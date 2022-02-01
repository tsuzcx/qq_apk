package com.tencent.moai.downloader.file;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.provider.DocumentFile;
import android.util.Log;
import com.tencent.moai.downloader.DownloadManager;
import com.tencent.moai.downloader.GlobalConfig;
import com.tencent.moai.downloader.algorithm.Hash;
import com.tencent.moai.downloader.util.Logger;
import com.tencent.moai.downloader.util.StringUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class DownloadFileUtil
{
  private static final int READ_FILE_BUFFER_SIZE = 4096;
  private static final int SIZE_UNIT = 1024;
  private static final String TAG = "DownloadFileUtil";
  
  public static void closeOutPutStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      return;
    }
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      Logger.e("DownloadFileUtil", Log.getStackTraceString(paramOutputStream));
    }
  }
  
  public static boolean combineTmpFile(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (!StringUtil.isNullOrEmpty(paramString))) {
      try
      {
        File localFile1 = new File(paramString);
        if (paramArrayList.size() == 1)
        {
          File localFile2 = new File((String)paramArrayList.get(0));
          if (localFile2.exists())
          {
            if (localFile2.renameTo(localFile1))
            {
              Logger.i("DownloadFileUtil", "combine rename tmp file success:" + (String)paramArrayList.get(0) + " to " + paramString);
              return true;
            }
            Logger.e("DownloadFileUtil", "combine rename tmp file fail:" + (String)paramArrayList.get(0) + " to " + paramString + " and try to combine by write.");
            return combineTmpFileByWrite(paramArrayList, paramString);
          }
        }
        else
        {
          Logger.i("DownloadFileUtil", "combine multi tmp files");
          boolean bool = combineTmpFileByWrite(paramArrayList, paramString);
          return bool;
        }
      }
      catch (Exception paramArrayList)
      {
        Logger.e("DownloadFileUtil", Log.getStackTraceString(paramArrayList) + "\n" + paramArrayList.toString());
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean combineTmpFileByWrite(ArrayList<String> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_0
    //   15: ifnull +287 -> 302
    //   18: aload_0
    //   19: invokevirtual 49	java/util/ArrayList:size	()I
    //   22: ifle +280 -> 302
    //   25: aload_1
    //   26: invokestatic 55	com/tencent/moai/downloader/util/StringUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   29: ifne +273 -> 302
    //   32: new 57	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokestatic 112	android/support/v4/provider/DocumentFile:fromFile	(Ljava/io/File;)Landroid/support/v4/provider/DocumentFile;
    //   43: invokevirtual 116	android/support/v4/provider/DocumentFile:getUri	()Landroid/net/Uri;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +370 -> 418
    //   51: invokestatic 122	com/tencent/moai/downloader/DownloadManager:shareInstance	()Lcom/tencent/moai/downloader/DownloadManager;
    //   54: invokevirtual 126	com/tencent/moai/downloader/DownloadManager:getContext	()Landroid/content/Context;
    //   57: invokevirtual 132	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload_3
    //   61: invokevirtual 138	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   64: checkcast 140	java/io/FileOutputStream
    //   67: astore_3
    //   68: aload 7
    //   70: astore 4
    //   72: aload 6
    //   74: astore 5
    //   76: aload_0
    //   77: invokevirtual 144	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   80: astore 6
    //   82: aload_2
    //   83: astore 4
    //   85: aload_2
    //   86: astore 5
    //   88: aload 6
    //   90: invokeinterface 149 1 0
    //   95: ifeq +216 -> 311
    //   98: aload_2
    //   99: astore 4
    //   101: aload_2
    //   102: astore 5
    //   104: aload 6
    //   106: invokeinterface 153 1 0
    //   111: checkcast 66	java/lang/String
    //   114: astore 7
    //   116: aload_2
    //   117: astore 4
    //   119: aload_2
    //   120: astore 5
    //   122: new 57	java/io/File
    //   125: dup
    //   126: aload 7
    //   128: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore 8
    //   133: aload_2
    //   134: astore 4
    //   136: aload_2
    //   137: astore 5
    //   139: ldc 13
    //   141: new 76	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   148: ldc 155
    //   150: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 7
    //   155: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 85
    //   160: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 157
    //   169: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 8
    //   174: invokevirtual 161	java/io/File:length	()J
    //   177: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 92	com/tencent/moai/downloader/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_2
    //   187: astore 4
    //   189: aload_2
    //   190: astore 5
    //   192: aload 8
    //   194: invokevirtual 70	java/io/File:exists	()Z
    //   197: ifeq +326 -> 523
    //   200: aload_2
    //   201: astore 4
    //   203: aload_2
    //   204: astore 5
    //   206: new 166	java/io/FileInputStream
    //   209: dup
    //   210: aload 8
    //   212: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   215: astore_2
    //   216: sipush 1024
    //   219: newarray byte
    //   221: astore 4
    //   223: aload_2
    //   224: aload 4
    //   226: invokevirtual 173	java/io/FileInputStream:read	([B)I
    //   229: iconst_m1
    //   230: if_icmpeq +74 -> 304
    //   233: aload_3
    //   234: aload 4
    //   236: invokevirtual 177	java/io/FileOutputStream:write	([B)V
    //   239: goto -16 -> 223
    //   242: astore_0
    //   243: aload_2
    //   244: astore_1
    //   245: aload_3
    //   246: astore_2
    //   247: ldc 13
    //   249: new 76	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   256: ldc 179
    //   258: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   265: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 103
    //   270: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_0
    //   274: invokevirtual 104	java/lang/Exception:toString	()Ljava/lang/String;
    //   277: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_2
    //   287: ifnull +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 181	java/io/FileInputStream:close	()V
    //   302: iconst_0
    //   303: ireturn
    //   304: aload_2
    //   305: invokevirtual 181	java/io/FileInputStream:close	()V
    //   308: goto -226 -> 82
    //   311: aload_2
    //   312: astore 4
    //   314: aload_2
    //   315: astore 5
    //   317: aload_3
    //   318: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   321: aload_2
    //   322: astore 4
    //   324: aload_2
    //   325: astore 5
    //   327: ldc 13
    //   329: ldc 183
    //   331: invokestatic 92	com/tencent/moai/downloader/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_2
    //   335: astore 4
    //   337: aload_2
    //   338: astore 5
    //   340: aload_0
    //   341: invokevirtual 144	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   344: astore_0
    //   345: aload_2
    //   346: astore 4
    //   348: aload_2
    //   349: astore 5
    //   351: aload_0
    //   352: invokeinterface 149 1 0
    //   357: ifeq +34 -> 391
    //   360: aload_2
    //   361: astore 4
    //   363: aload_2
    //   364: astore 5
    //   366: aload_0
    //   367: invokeinterface 153 1 0
    //   372: checkcast 66	java/lang/String
    //   375: invokestatic 186	com/tencent/moai/downloader/file/DownloadFileUtil:delete	(Ljava/lang/String;)Z
    //   378: pop
    //   379: goto -34 -> 345
    //   382: astore_0
    //   383: aload_3
    //   384: astore_2
    //   385: aload 4
    //   387: astore_1
    //   388: goto -141 -> 247
    //   391: aload_3
    //   392: ifnull +7 -> 399
    //   395: aload_3
    //   396: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   399: aload_2
    //   400: ifnull +7 -> 407
    //   403: aload_2
    //   404: invokevirtual 181	java/io/FileInputStream:close	()V
    //   407: iconst_1
    //   408: ireturn
    //   409: astore_0
    //   410: aload_0
    //   411: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   414: pop
    //   415: goto -8 -> 407
    //   418: iconst_0
    //   419: ifeq +11 -> 430
    //   422: new 188	java/lang/NullPointerException
    //   425: dup
    //   426: invokespecial 189	java/lang/NullPointerException:<init>	()V
    //   429: athrow
    //   430: iconst_0
    //   431: ifeq -129 -> 302
    //   434: new 188	java/lang/NullPointerException
    //   437: dup
    //   438: invokespecial 189	java/lang/NullPointerException:<init>	()V
    //   441: athrow
    //   442: astore_0
    //   443: aload_0
    //   444: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   447: pop
    //   448: goto -146 -> 302
    //   451: astore_0
    //   452: aload_0
    //   453: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   456: pop
    //   457: goto -155 -> 302
    //   460: astore_0
    //   461: aconst_null
    //   462: astore_2
    //   463: aload 5
    //   465: astore_1
    //   466: aload_2
    //   467: ifnull +7 -> 474
    //   470: aload_2
    //   471: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   474: aload_1
    //   475: ifnull +7 -> 482
    //   478: aload_1
    //   479: invokevirtual 181	java/io/FileInputStream:close	()V
    //   482: aload_0
    //   483: athrow
    //   484: astore_1
    //   485: aload_1
    //   486: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   489: pop
    //   490: goto -8 -> 482
    //   493: astore_0
    //   494: aload_3
    //   495: astore_2
    //   496: aload 5
    //   498: astore_1
    //   499: goto -33 -> 466
    //   502: astore_0
    //   503: aload_2
    //   504: astore_1
    //   505: aload_3
    //   506: astore_2
    //   507: goto -41 -> 466
    //   510: astore_0
    //   511: goto -45 -> 466
    //   514: astore_0
    //   515: aconst_null
    //   516: astore_2
    //   517: aload 4
    //   519: astore_1
    //   520: goto -273 -> 247
    //   523: goto -215 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	paramArrayList	ArrayList<String>
    //   0	526	1	paramString	String
    //   13	504	2	localObject1	Object
    //   46	460	3	localObject2	Object
    //   1	517	4	localObject3	Object
    //   7	490	5	localObject4	Object
    //   10	95	6	localIterator	java.util.Iterator
    //   4	150	7	str	String
    //   131	80	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   216	223	242	java/lang/Exception
    //   223	239	242	java/lang/Exception
    //   304	308	242	java/lang/Exception
    //   76	82	382	java/lang/Exception
    //   88	98	382	java/lang/Exception
    //   104	116	382	java/lang/Exception
    //   122	133	382	java/lang/Exception
    //   139	186	382	java/lang/Exception
    //   192	200	382	java/lang/Exception
    //   206	216	382	java/lang/Exception
    //   317	321	382	java/lang/Exception
    //   327	334	382	java/lang/Exception
    //   340	345	382	java/lang/Exception
    //   351	360	382	java/lang/Exception
    //   366	379	382	java/lang/Exception
    //   395	399	409	java/io/IOException
    //   403	407	409	java/io/IOException
    //   422	430	442	java/io/IOException
    //   434	442	442	java/io/IOException
    //   290	294	451	java/io/IOException
    //   298	302	451	java/io/IOException
    //   32	47	460	finally
    //   51	68	460	finally
    //   470	474	484	java/io/IOException
    //   478	482	484	java/io/IOException
    //   76	82	493	finally
    //   88	98	493	finally
    //   104	116	493	finally
    //   122	133	493	finally
    //   139	186	493	finally
    //   192	200	493	finally
    //   206	216	493	finally
    //   317	321	493	finally
    //   327	334	493	finally
    //   340	345	493	finally
    //   351	360	493	finally
    //   366	379	493	finally
    //   216	223	502	finally
    //   223	239	502	finally
    //   304	308	502	finally
    //   247	286	510	finally
    //   32	47	514	java/lang/Exception
    //   51	68	514	java/lang/Exception
  }
  
  /* Error */
  public static boolean copy(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: aload_0
    //   10: invokestatic 55	com/tencent/moai/downloader/util/StringUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 55	com/tencent/moai/downloader/util/StringUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   20: ifeq +7 -> 27
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_3
    //   26: ireturn
    //   27: new 57	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: new 57	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: iload 4
    //   48: istore_3
    //   49: aload_0
    //   50: invokevirtual 194	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: aload 8
    //   55: invokevirtual 194	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne -36 -> 25
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore 7
    //   71: new 200	java/io/BufferedInputStream
    //   74: dup
    //   75: new 166	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_1
    //   87: new 205	java/io/BufferedOutputStream
    //   90: dup
    //   91: new 140	java/io/FileOutputStream
    //   94: dup
    //   95: aload 8
    //   97: iconst_0
    //   98: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   101: invokespecial 210	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore_0
    //   105: aload_1
    //   106: aload 7
    //   108: invokevirtual 211	java/io/BufferedInputStream:read	([B)I
    //   111: istore_2
    //   112: iload_2
    //   113: iconst_m1
    //   114: if_icmpeq +39 -> 153
    //   117: aload_0
    //   118: aload 7
    //   120: iconst_0
    //   121: iload_2
    //   122: invokevirtual 214	java/io/BufferedOutputStream:write	([BII)V
    //   125: goto -20 -> 105
    //   128: astore 5
    //   130: aload 5
    //   132: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   143: aload_0
    //   144: ifnull +172 -> 316
    //   147: aload_0
    //   148: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   161: iload 4
    //   163: istore_3
    //   164: aload_0
    //   165: ifnull -140 -> 25
    //   168: aload_0
    //   169: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_0
    //   175: ldc 13
    //   177: aload_0
    //   178: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   181: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_1
    //   187: ldc 13
    //   189: aload_1
    //   190: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: goto -35 -> 161
    //   199: astore_1
    //   200: ldc 13
    //   202: aload_1
    //   203: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   206: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -66 -> 143
    //   212: astore_0
    //   213: ldc 13
    //   215: aload_0
    //   216: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   219: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: ifnull +7 -> 235
    //   231: aload_1
    //   232: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   235: aload 5
    //   237: ifnull +8 -> 245
    //   240: aload 5
    //   242: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   245: aload_0
    //   246: athrow
    //   247: astore_1
    //   248: ldc 13
    //   250: aload_1
    //   251: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   254: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -22 -> 235
    //   260: astore_1
    //   261: ldc 13
    //   263: aload_1
    //   264: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   267: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: goto -25 -> 245
    //   273: astore_0
    //   274: goto -47 -> 227
    //   277: astore 6
    //   279: aload_0
    //   280: astore 5
    //   282: aload 6
    //   284: astore_0
    //   285: goto -58 -> 227
    //   288: astore 6
    //   290: aload_0
    //   291: astore 5
    //   293: aload 6
    //   295: astore_0
    //   296: goto -69 -> 227
    //   299: astore 5
    //   301: aconst_null
    //   302: astore_0
    //   303: aload 6
    //   305: astore_1
    //   306: goto -176 -> 130
    //   309: astore 5
    //   311: aconst_null
    //   312: astore_0
    //   313: goto -183 -> 130
    //   316: iconst_0
    //   317: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramString1	String
    //   0	318	1	paramString2	String
    //   111	11	2	i	int
    //   24	140	3	bool1	boolean
    //   7	155	4	bool2	boolean
    //   1	1	5	localObject1	Object
    //   128	113	5	localIOException1	IOException
    //   280	12	5	str	String
    //   299	1	5	localIOException2	IOException
    //   309	1	5	localIOException3	IOException
    //   4	1	6	localObject2	Object
    //   277	6	6	localObject3	Object
    //   288	16	6	localObject4	Object
    //   69	50	7	arrayOfByte	byte[]
    //   44	52	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	112	128	java/io/IOException
    //   117	125	128	java/io/IOException
    //   168	172	174	java/lang/Exception
    //   157	161	186	java/lang/Exception
    //   139	143	199	java/lang/Exception
    //   147	151	212	java/lang/Exception
    //   64	87	224	finally
    //   231	235	247	java/lang/Exception
    //   240	245	260	java/lang/Exception
    //   87	105	273	finally
    //   105	112	277	finally
    //   117	125	277	finally
    //   130	135	288	finally
    //   64	87	299	java/io/IOException
    //   87	105	309	java/io/IOException
  }
  
  public static String defaultRename(String paramString1, String paramString2)
  {
    int k = 1;
    if ((StringUtil.isNullOrEmpty(paramString1)) || (StringUtil.isNullOrEmpty(paramString2))) {
      str1 = "";
    }
    String str4;
    String[] arrayOfString;
    do
    {
      do
      {
        return str1;
        str4 = new File(paramString1).getParent().replaceFirst("/*$", "/");
        arrayOfString = paramString2.split("\\.");
        str1 = paramString1;
      } while (arrayOfString == null);
      str1 = paramString1;
    } while (arrayOfString.length <= 0);
    String str1 = arrayOfString[0];
    String str5 = arrayOfString[(arrayOfString.length - 1)];
    int j;
    String str2;
    String str3;
    if (arrayOfString.length > 2)
    {
      int i = 1;
      for (;;)
      {
        j = k;
        str2 = str1;
        str3 = paramString2;
        if (i >= arrayOfString.length - 1) {
          break;
        }
        str1 = str1 + "." + arrayOfString[i];
        i += 1;
      }
    }
    for (;;)
    {
      if (new File(str4 + str3).exists())
      {
        str3 = str2 + "(" + j + ")" + "." + str5;
        j += 1;
      }
      else
      {
        return paramString1 + File.separator + str3;
        j = k;
        str2 = str1;
        str3 = paramString2;
      }
    }
  }
  
  public static boolean delete(String paramString)
  {
    if (StringUtil.isNullOrEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return true;
    }
    return paramString.delete();
  }
  
  public static boolean deleteDir(String paramString)
  {
    int i = 0;
    if (StringUtil.isNullOrEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isDirectory()));
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int j = arrayOfFile.length;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          deleteDir(localFile.getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          localFile.delete();
        }
      }
    }
    return paramString.delete();
  }
  
  public static String getDefaultTmpFileDir()
  {
    if (!mkDirs(GlobalConfig.DEFAULT_TMP_FILE_DIR)) {
      return null;
    }
    return GlobalConfig.DEFAULT_TMP_FILE_DIR;
  }
  
  public static long getFileSize(String paramString)
  {
    if (StringUtil.isNullOrEmpty(paramString)) {}
    do
    {
      return 0L;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.length();
  }
  
  public static OutputStream getOutputStream(String paramString, boolean paramBoolean)
  {
    if (StringUtil.isNullOrEmpty(paramString)) {}
    for (;;)
    {
      return null;
      Logger.i("DownloadFileUtil", "get outPutStream:" + paramString + ", append:" + paramBoolean);
      try
      {
        Uri localUri = DocumentFile.fromFile(new File(paramString)).getUri();
        if (localUri == null) {
          continue;
        }
        ContentResolver localContentResolver = DownloadManager.shareInstance().getContext().getContentResolver();
        if (paramBoolean) {}
        for (paramString = "wa";; paramString = "w") {
          return localContentResolver.openOutputStream(localUri, paramString);
        }
        return null;
      }
      catch (FileNotFoundException paramString)
      {
        Logger.e("DownloadFileUtil", paramString.toString() + "\r\n" + Log.getStackTraceString(paramString));
      }
    }
  }
  
  public static final String getPrefix(String paramString)
  {
    if (StringUtil.isNullOrEmpty(paramString)) {
      return "";
    }
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  public static long getSdcardAvailableSize()
  {
    if (hasSdcard())
    {
      StatFs localStatFs = new StatFs(DownloadFileDefine.EXTERNAL_SDCARD);
      long l = localStatFs.getBlockSize();
      return localStatFs.getAvailableBlocks() * l;
    }
    return 0L;
  }
  
  public static long getSdcardSize()
  {
    if (hasSdcard())
    {
      StatFs localStatFs = new StatFs(DownloadFileDefine.EXTERNAL_SDCARD);
      long l = localStatFs.getBlockSize();
      return localStatFs.getBlockCount() * l;
    }
    return 0L;
  }
  
  public static final String getSuffix(String paramString)
  {
    if (StringUtil.isNullOrEmpty(paramString)) {
      return "";
    }
    return paramString.substring(paramString.lastIndexOf(".") + 1);
  }
  
  public static ArrayList<Long> getThreadTaskFileSizeList(long paramLong)
  {
    int n = 0;
    int j = 0;
    int m = 0;
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    if (paramLong <= 0L) {}
    for (;;)
    {
      return localArrayList;
      long l = GlobalConfig.DEFAULT_TMP_FILE_SIZE;
      int i1 = (int)Math.floor(paramLong / l);
      int i = i1;
      if (paramLong % l > 0L) {
        i = i1 + 1;
      }
      if (i == 1)
      {
        localArrayList.add(Long.valueOf(paramLong));
        return localArrayList;
      }
      if (i <= GlobalConfig.MAX_THREAD_TASK_SIZE)
      {
        j = n;
        if (paramLong % l > 0L)
        {
          j = k;
          while (j < i - 1)
          {
            localArrayList.add(Long.valueOf(l));
            j += 1;
          }
          localArrayList.add(Long.valueOf(paramLong % l));
          return localArrayList;
        }
        while (j < i)
        {
          localArrayList.add(Long.valueOf(l));
          j += 1;
        }
      }
      else
      {
        k = GlobalConfig.MAX_THREAD_TASK_SIZE;
        l = Math.floor(paramLong / k);
        i = m;
        if (paramLong % k > 0L)
        {
          i = j;
          while (i < k - 1)
          {
            localArrayList.add(Long.valueOf(l));
            i += 1;
          }
          localArrayList.add(Long.valueOf(paramLong % k + l));
          return localArrayList;
        }
        while (i < k)
        {
          localArrayList.add(Long.valueOf(l));
          i += 1;
        }
      }
    }
  }
  
  public static String getTmpFile(long paramLong, int paramInt)
  {
    String str = Hash.hashKeyForDisk(String.valueOf(paramLong));
    return getDefaultTmpFileDir() + File.separator + str + "_" + paramInt + ".tmp";
  }
  
  public static long getTmpFileSize(long paramLong)
  {
    long l1 = 0L;
    long l2;
    if (!hasSdcard()) {
      l2 = l1;
    }
    String str1;
    Object localObject;
    String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          do
          {
            return l2;
            str1 = Hash.hashKeyForDisk(String.valueOf(paramLong));
            str1 = str1 + "_";
            localObject = getDefaultTmpFileDir();
            l2 = l1;
          } while (localObject == null);
          localObject = new File((String)localObject);
          l2 = l1;
        } while (!((File)localObject).isDirectory());
        arrayOfString = ((File)localObject).list();
        l2 = l1;
      } while (arrayOfString == null);
      l2 = l1;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (paramLong = l1;; paramLong = l1)
    {
      l2 = paramLong;
      if (i >= j) {
        break;
      }
      String str2 = arrayOfString[i];
      l1 = paramLong;
      if (str2.startsWith(str1)) {
        l1 = paramLong + getFileSize(localObject + File.separator + str2);
      }
      i += 1;
    }
  }
  
  public static boolean hasSdcard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean mkDirs(String paramString)
  {
    if (StringUtil.isNullOrEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while (((!paramString.exists()) || (!paramString.isDirectory())) && (!paramString.mkdirs()));
    return true;
  }
  
  /* Error */
  private static byte[] streamToByte(java.io.FileInputStream paramFileInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 5
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: sipush 4096
    //   15: newarray byte
    //   17: astore 4
    //   19: new 401	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 402	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload_0
    //   30: aload 4
    //   32: invokevirtual 173	java/io/FileInputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +63 -> 100
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 403	java/io/ByteArrayOutputStream:write	([BII)V
    //   50: goto -23 -> 27
    //   53: astore 4
    //   55: aload_3
    //   56: astore_2
    //   57: ldc 13
    //   59: aload 4
    //   61: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   64: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 404	java/io/ByteArrayOutputStream:close	()V
    //   75: aload 5
    //   77: astore_3
    //   78: aload_0
    //   79: ifnull -69 -> 10
    //   82: aload_0
    //   83: invokevirtual 181	java/io/FileInputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: ldc 13
    //   91: aload_0
    //   92: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   95: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: invokevirtual 408	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   106: astore 4
    //   108: aload 4
    //   110: astore_2
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 404	java/io/ByteArrayOutputStream:close	()V
    //   119: aload_2
    //   120: astore_3
    //   121: aload_0
    //   122: ifnull -112 -> 10
    //   125: aload_0
    //   126: invokevirtual 181	java/io/FileInputStream:close	()V
    //   129: aload_2
    //   130: areturn
    //   131: astore_0
    //   132: ldc 13
    //   134: aload_0
    //   135: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   138: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_2
    //   142: areturn
    //   143: astore_3
    //   144: ldc 13
    //   146: aload_3
    //   147: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   150: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto -34 -> 119
    //   156: astore_2
    //   157: ldc 13
    //   159: aload_2
    //   160: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   163: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -91 -> 75
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 404	java/io/ByteArrayOutputStream:close	()V
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 181	java/io/FileInputStream:close	()V
    //   188: aload_3
    //   189: athrow
    //   190: astore_2
    //   191: ldc 13
    //   193: aload_2
    //   194: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   197: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -20 -> 180
    //   203: astore_0
    //   204: ldc 13
    //   206: aload_0
    //   207: invokestatic 33	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: invokestatic 39	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -25 -> 188
    //   216: astore_3
    //   217: goto -45 -> 172
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_3
    //   224: goto -169 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramFileInputStream	java.io.FileInputStream
    //   35	12	1	i	int
    //   28	114	2	localObject1	Object
    //   156	4	2	localException1	Exception
    //   171	6	2	localObject2	Object
    //   190	4	2	localException2	Exception
    //   9	112	3	localObject3	Object
    //   143	4	3	localException3	Exception
    //   169	20	3	localObject4	Object
    //   216	1	3	localObject5	Object
    //   223	1	3	localObject6	Object
    //   17	27	4	arrayOfByte1	byte[]
    //   53	7	4	localException4	Exception
    //   106	3	4	arrayOfByte2	byte[]
    //   220	1	4	localException5	Exception
    //   1	75	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	53	java/lang/Exception
    //   42	50	53	java/lang/Exception
    //   102	108	53	java/lang/Exception
    //   82	86	88	java/lang/Exception
    //   125	129	131	java/lang/Exception
    //   115	119	143	java/lang/Exception
    //   71	75	156	java/lang/Exception
    //   12	27	169	finally
    //   176	180	190	java/lang/Exception
    //   184	188	203	java/lang/Exception
    //   29	36	216	finally
    //   42	50	216	finally
    //   57	67	216	finally
    //   102	108	216	finally
    //   12	27	220	java/lang/Exception
  }
  
  public static void writeTmpFile(OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramOutputStream == null) || (paramArrayOfByte == null)) {
      return;
    }
    try
    {
      paramOutputStream.write(paramArrayOfByte, 0, paramInt);
      return;
    }
    catch (IOException paramOutputStream)
    {
      Logger.e("DownloadFileUtil", paramOutputStream.toString() + "\r\n" + Log.getStackTraceString(paramOutputStream));
    }
  }
  
  public boolean rename(String paramString1, String paramString2)
  {
    if ((StringUtil.isNullOrEmpty(paramString1)) || (StringUtil.isNullOrEmpty(paramString2))) {
      return false;
    }
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    try
    {
      paramString1.renameTo(paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      Logger.e("DownloadFileUtil", Log.getStackTraceString(paramString1));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.file.DownloadFileUtil
 * JD-Core Version:    0.7.0.1
 */