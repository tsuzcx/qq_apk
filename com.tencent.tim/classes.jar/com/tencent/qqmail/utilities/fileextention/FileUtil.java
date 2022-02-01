package com.tencent.qqmail.utilities.fileextention;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.core.utilities.Utils;

public class FileUtil
{
  public static final int FILE_COPY_ERROR_NOPERMISSION = -2;
  public static final int FILE_COPY_ERROR_NORMAL = -1;
  public static final int FILE_COPY_SUCCESS = 0;
  public static final String TAG = "FileUtil";
  public static String[] imgFileSuffix = null;
  
  /* Error */
  public static String calculateDigest(File paramFile, String paramString)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 4
    //   7: new 36	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_0
    //   18: aload_1
    //   19: invokestatic 45	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore_1
    //   23: aload_3
    //   24: astore_0
    //   25: aload_3
    //   26: aload 4
    //   28: invokevirtual 49	java/io/FileInputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: ifle +46 -> 79
    //   36: aload_3
    //   37: astore_0
    //   38: aload_1
    //   39: aload 4
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 53	java/security/MessageDigest:update	([BII)V
    //   46: goto -23 -> 23
    //   49: astore_0
    //   50: aload_3
    //   51: astore_1
    //   52: aload_0
    //   53: astore_3
    //   54: aload_1
    //   55: astore_0
    //   56: bipush 6
    //   58: ldc 18
    //   60: aload_3
    //   61: invokestatic 59	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   64: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 68	java/io/FileInputStream:close	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: areturn
    //   79: aload_3
    //   80: astore_0
    //   81: new 70	java/lang/String
    //   84: dup
    //   85: aload_1
    //   86: invokevirtual 74	java/security/MessageDigest:digest	()[B
    //   89: invokestatic 80	com/tencent/qqmail/utilities/stringextention/Hex:encodeHex	([B)[C
    //   92: invokespecial 83	java/lang/String:<init>	([C)V
    //   95: astore_1
    //   96: aload_1
    //   97: astore_0
    //   98: aload_3
    //   99: ifnull -22 -> 77
    //   102: aload_3
    //   103: invokevirtual 68	java/io/FileInputStream:close	()V
    //   106: aload_1
    //   107: areturn
    //   108: astore_0
    //   109: bipush 6
    //   111: ldc 18
    //   113: aload_0
    //   114: invokestatic 59	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   120: aload_1
    //   121: areturn
    //   122: astore_0
    //   123: bipush 6
    //   125: ldc 18
    //   127: aload_0
    //   128: invokestatic 59	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   131: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   134: goto -59 -> 75
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 68	java/io/FileInputStream:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_0
    //   151: bipush 6
    //   153: ldc 18
    //   155: aload_0
    //   156: invokestatic 59	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   162: goto -14 -> 148
    //   165: astore_1
    //   166: goto -26 -> 140
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -118 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramFile	File
    //   0	175	1	paramString	String
    //   31	12	2	i	int
    //   15	88	3	localObject	Object
    //   169	1	3	localException	Exception
    //   5	35	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	23	49	java/lang/Exception
    //   25	32	49	java/lang/Exception
    //   38	46	49	java/lang/Exception
    //   81	96	49	java/lang/Exception
    //   102	106	108	java/io/IOException
    //   71	75	122	java/io/IOException
    //   7	16	137	finally
    //   144	148	150	java/io/IOException
    //   18	23	165	finally
    //   25	32	165	finally
    //   38	46	165	finally
    //   56	67	165	finally
    //   81	96	165	finally
    //   7	16	169	java/lang/Exception
  }
  
  public static boolean canPathWritable(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return false;
    }
    Object localObject4 = null;
    localStringBuilder = null;
    localObject3 = null;
    str = toDirPath(paramString) + "test.tmp";
    localObject1 = localObject4;
    localObject2 = localStringBuilder;
    try
    {
      Uri localUri = DocumentFile.fromFile(new File(str)).getUri();
      if (localUri != null)
      {
        localObject1 = localObject4;
        localObject2 = localStringBuilder;
        localObject3 = QMApplicationContext.sharedInstance().getContentResolver().openOutputStream(localUri);
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((OutputStream)localObject3).write(0);
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      QMLog.log(4, "FileUtil", "path can write into:" + paramString);
      if (localObject3 == null) {}
    }
    catch (IOException localIOException2)
    {
      label139:
      localObject2 = localObject1;
      localStringBuilder = new StringBuilder();
      localObject2 = localObject1;
      if (localIOException2.getCause() != null) {
        localObject2 = localObject1;
      }
      for (localObject3 = localIOException2.getCause().toString();; localObject3 = localIOException2.toString())
      {
        localObject2 = localObject1;
        localStringBuilder.append((String)localObject3);
        localObject2 = localObject1;
        localStringBuilder.append("\r\n");
        localObject2 = localObject1;
        localStringBuilder.append(Log.getStackTraceString(localIOException2));
        localObject2 = localObject1;
        QMLog.log(5, "FileUtil", "write test file into path fail:" + paramString + ", error:" + localStringBuilder.toString());
        if (localObject1 != null) {}
        try
        {
          localObject1.close();
          delFile(str);
          return false;
        }
        catch (IOException paramString)
        {
          return false;
        }
        localObject2 = localObject1;
      }
    }
    finally
    {
      if (localObject2 != null) {}
      try
      {
        ((OutputStream)localObject2).close();
        delFile(str);
      }
      catch (IOException localIOException1)
      {
        break label292;
      }
    }
    try
    {
      ((OutputStream)localObject3).close();
      delFile(str);
    }
    catch (IOException paramString)
    {
      break label139;
    }
    return true;
  }
  
  public static void clearCache(int paramInt)
  {
    QMLog.log(4, "FileUtil", "clearCache");
    delFolder(FileDefine.INNER_DATA_BIG_ATTACH_DIR);
    delFolder(FileDefine.INNER_DATA_THUMB_IMAGE_CACHE_DIR);
    delFolder(FileDefine.EXTERNAL_ANDROID_DATA_THUMB_IMAGE_CACHE_DIR);
    delFolder(FileDefine.EXTERNAL_ANDROID_DATA_BIGATTACH_DIR);
    delFolder(FileDefine.EXTERNAL_ANDROID_DATA_ATTACHMENT_DIR);
    delFolder(FileDefine.EXTERNAL_ANDROID_DATA_SCREENSHOT);
    delFolder(FileDefine.EXTERNAL_ANDROID_DATA_COMPRESS_DIR);
    delFolder(QMPathManager.sharedInstance().getQQMailAttachmentDir());
    if ((paramInt & 0x3) == 3)
    {
      ArrayList localArrayList = DownloadInfoManager.shareInstance().getPathsInAttachDownloadDir(true);
      DownloadInfoManager.shareInstance().deleteDownloadInfoOfflineByPaths(localArrayList);
      DownloadInfoManager.shareInstance().deleteDownloadInfoBeforeTime(System.currentTimeMillis());
      localArrayList = delFileByPath(localArrayList);
      DownloadInfoManager.shareInstance().deleteDownloadInfoByPaths(localArrayList, true);
    }
    if ((paramInt & 0x4) == 4) {
      delFileByPath(QMMailManager.sharedInstance().clearMailContent());
    }
    if ((paramInt & 0x8) == 8)
    {
      ImageDownloadManager.shareInstance().clearCache();
      ImageCompresser.getInstance().clearCache();
    }
    if ((paramInt & 0x10) == 16)
    {
      QMMailManager.sharedInstance().deleteAllProtocolAttachCache();
      delFolder(QMPathManager.sharedInstance().getQQMailEmailIconDir());
      delFolder(QMPathManager.sharedInstance().getQQMailNickIconDir());
      QMCardManager.shareInstance().clearCardCache();
      delFolder(QMPathManager.sharedInstance().getQQMailLogDir());
    }
  }
  
  public static void clearFileContent(String paramString)
    throws IOException
  {
    paramString = new FileOutputStream(new File(paramString));
    paramString.write("".getBytes());
    paramString.close();
  }
  
  /* Error */
  public static int copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: ifnull +7 -> 19
    //   15: aload_1
    //   16: ifnonnull +7 -> 23
    //   19: iconst_m1
    //   20: istore_2
    //   21: iload_2
    //   22: ireturn
    //   23: iload_3
    //   24: istore_2
    //   25: aload_0
    //   26: invokevirtual 292	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: aload_1
    //   30: invokevirtual 296	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   33: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifne -15 -> 21
    //   39: new 302	java/io/BufferedInputStream
    //   42: dup
    //   43: new 36	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 305	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_0
    //   55: new 307	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 277	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: iconst_0
    //   65: invokespecial 310	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   68: invokespecial 313	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore_1
    //   72: sipush 1024
    //   75: newarray byte
    //   77: astore 5
    //   79: aload_0
    //   80: aload 5
    //   82: invokevirtual 314	java/io/BufferedInputStream:read	([B)I
    //   85: istore_2
    //   86: iload_2
    //   87: iconst_m1
    //   88: if_icmpeq +112 -> 200
    //   91: aload_1
    //   92: aload 5
    //   94: iconst_0
    //   95: iload_2
    //   96: invokevirtual 316	java/io/BufferedOutputStream:write	([BII)V
    //   99: goto -20 -> 79
    //   102: astore 6
    //   104: aload_0
    //   105: astore 5
    //   107: aload 6
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   114: astore 6
    //   116: bipush 6
    //   118: ldc 18
    //   120: new 92	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 321
    //   130: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: invokestatic 59	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   146: aload 6
    //   148: ldc_w 323
    //   151: invokevirtual 327	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   154: ifne +18 -> 172
    //   157: aload 6
    //   159: ldc_w 329
    //   162: invokevirtual 327	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: istore 4
    //   167: iload 4
    //   169: ifeq +54 -> 223
    //   172: bipush 254
    //   174: istore_2
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 330	java/io/BufferedInputStream:close	()V
    //   185: aload_1
    //   186: ifnull -165 -> 21
    //   189: aload_1
    //   190: invokevirtual 331	java/io/BufferedOutputStream:close	()V
    //   193: bipush 254
    //   195: ireturn
    //   196: astore_0
    //   197: bipush 254
    //   199: ireturn
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 330	java/io/BufferedInputStream:close	()V
    //   208: iload_3
    //   209: istore_2
    //   210: aload_1
    //   211: ifnull -190 -> 21
    //   214: aload_1
    //   215: invokevirtual 331	java/io/BufferedOutputStream:close	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_0
    //   221: iconst_0
    //   222: ireturn
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 330	java/io/BufferedInputStream:close	()V
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 331	java/io/BufferedOutputStream:close	()V
    //   241: iconst_m1
    //   242: ireturn
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_0
    //   247: aload 6
    //   249: astore_1
    //   250: bipush 6
    //   252: ldc 18
    //   254: new 92	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 321
    //   264: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 5
    //   269: invokestatic 59	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   272: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: ifnull +7 -> 289
    //   285: aload_0
    //   286: invokevirtual 330	java/io/BufferedInputStream:close	()V
    //   289: iload_3
    //   290: istore_2
    //   291: aload_1
    //   292: ifnull -271 -> 21
    //   295: aload_1
    //   296: invokevirtual 331	java/io/BufferedOutputStream:close	()V
    //   299: iconst_0
    //   300: ireturn
    //   301: astore_0
    //   302: iconst_0
    //   303: ireturn
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_1
    //   307: aload 7
    //   309: astore 5
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 330	java/io/BufferedInputStream:close	()V
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 331	java/io/BufferedOutputStream:close	()V
    //   329: aload_0
    //   330: athrow
    //   331: astore_0
    //   332: goto -124 -> 208
    //   335: astore_0
    //   336: goto -151 -> 185
    //   339: astore_0
    //   340: goto -107 -> 233
    //   343: astore_0
    //   344: goto -103 -> 241
    //   347: astore_0
    //   348: goto -59 -> 289
    //   351: astore 5
    //   353: goto -32 -> 321
    //   356: astore_1
    //   357: goto -28 -> 329
    //   360: astore 6
    //   362: aconst_null
    //   363: astore_1
    //   364: aload_0
    //   365: astore 5
    //   367: aload 6
    //   369: astore_0
    //   370: goto -59 -> 311
    //   373: astore 6
    //   375: aload_0
    //   376: astore 5
    //   378: aload 6
    //   380: astore_0
    //   381: goto -70 -> 311
    //   384: astore_0
    //   385: goto -74 -> 311
    //   388: astore 6
    //   390: aload_0
    //   391: astore 5
    //   393: aload 6
    //   395: astore_0
    //   396: goto -85 -> 311
    //   399: astore 5
    //   401: aload 6
    //   403: astore_1
    //   404: goto -154 -> 250
    //   407: astore 5
    //   409: goto -159 -> 250
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_1
    //   415: goto -305 -> 110
    //   418: astore 6
    //   420: aconst_null
    //   421: astore_1
    //   422: aload_0
    //   423: astore 5
    //   425: aload 6
    //   427: astore_0
    //   428: goto -318 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramFile1	File
    //   0	431	1	paramFile2	File
    //   20	271	2	i	int
    //   10	280	3	j	int
    //   165	3	4	bool	boolean
    //   7	222	5	localObject1	Object
    //   243	25	5	localException1	Exception
    //   309	8	5	localObject2	Object
    //   351	1	5	localIOException1	IOException
    //   365	27	5	localFile1	File
    //   399	1	5	localException2	Exception
    //   407	1	5	localException3	Exception
    //   423	1	5	localFile2	File
    //   1	1	6	localObject3	Object
    //   102	6	6	localIOException2	IOException
    //   114	134	6	str	String
    //   360	8	6	localObject4	Object
    //   373	6	6	localObject5	Object
    //   388	14	6	localObject6	Object
    //   418	8	6	localIOException3	IOException
    //   4	304	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   72	79	102	java/io/IOException
    //   79	86	102	java/io/IOException
    //   91	99	102	java/io/IOException
    //   189	193	196	java/io/IOException
    //   214	218	220	java/io/IOException
    //   39	55	243	java/lang/Exception
    //   295	299	301	java/io/IOException
    //   39	55	304	finally
    //   204	208	331	java/io/IOException
    //   180	185	335	java/io/IOException
    //   228	233	339	java/io/IOException
    //   237	241	343	java/io/IOException
    //   285	289	347	java/io/IOException
    //   316	321	351	java/io/IOException
    //   325	329	356	java/io/IOException
    //   55	72	360	finally
    //   72	79	373	finally
    //   79	86	373	finally
    //   91	99	373	finally
    //   110	167	384	finally
    //   250	281	388	finally
    //   55	72	399	java/lang/Exception
    //   72	79	407	java/lang/Exception
    //   79	86	407	java/lang/Exception
    //   91	99	407	java/lang/Exception
    //   39	55	412	java/io/IOException
    //   55	72	418	java/io/IOException
  }
  
  /* Error */
  public static void copyFile(android.os.ParcelFileDescriptor paramParcelFileDescriptor, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: ifnull +138 -> 148
    //   13: new 36	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual 338	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   21: invokespecial 341	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore 5
    //   28: aload 7
    //   30: astore 4
    //   32: sipush 4096
    //   35: newarray byte
    //   37: astore 8
    //   39: aload_3
    //   40: astore 5
    //   42: aload 7
    //   44: astore 4
    //   46: new 277	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_3
    //   56: aload 8
    //   58: iconst_0
    //   59: sipush 4096
    //   62: invokevirtual 345	java/io/FileInputStream:read	([BII)I
    //   65: istore_2
    //   66: iload_2
    //   67: ifle +82 -> 149
    //   70: aload_1
    //   71: aload 8
    //   73: iconst_0
    //   74: iload_2
    //   75: invokevirtual 346	java/io/FileOutputStream:write	([BII)V
    //   78: goto -23 -> 55
    //   81: astore 4
    //   83: aload_1
    //   84: astore 6
    //   86: aload 4
    //   88: astore_1
    //   89: aload_3
    //   90: astore 5
    //   92: aload 6
    //   94: astore 4
    //   96: bipush 6
    //   98: ldc 18
    //   100: new 92	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 348
    //   110: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   117: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 350	android/os/ParcelFileDescriptor:close	()V
    //   130: aload 6
    //   132: ifnull +8 -> 140
    //   135: aload 6
    //   137: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 68	java/io/FileInputStream:close	()V
    //   148: return
    //   149: aload_1
    //   150: invokevirtual 354	java/io/FileOutputStream:flush	()V
    //   153: aload_1
    //   154: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   157: aload_3
    //   158: invokevirtual 68	java/io/FileInputStream:close	()V
    //   161: aload_0
    //   162: invokevirtual 350	android/os/ParcelFileDescriptor:close	()V
    //   165: aload_0
    //   166: invokevirtual 350	android/os/ParcelFileDescriptor:close	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   177: aload_3
    //   178: ifnull -30 -> 148
    //   181: aload_3
    //   182: invokevirtual 68	java/io/FileInputStream:close	()V
    //   185: return
    //   186: astore_0
    //   187: return
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_0
    //   192: invokevirtual 350	android/os/ParcelFileDescriptor:close	()V
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 68	java/io/FileInputStream:close	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore_0
    //   216: goto -47 -> 169
    //   219: astore_0
    //   220: goto -43 -> 177
    //   223: astore_0
    //   224: goto -94 -> 130
    //   227: astore_0
    //   228: goto -88 -> 140
    //   231: astore_0
    //   232: return
    //   233: astore_0
    //   234: goto -39 -> 195
    //   237: astore_0
    //   238: goto -33 -> 205
    //   241: astore_0
    //   242: goto -29 -> 213
    //   245: astore_1
    //   246: aload 5
    //   248: astore_3
    //   249: goto -58 -> 191
    //   252: astore 5
    //   254: aload_1
    //   255: astore 4
    //   257: aload 5
    //   259: astore_1
    //   260: goto -69 -> 191
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_3
    //   266: goto -177 -> 89
    //   269: astore_1
    //   270: goto -181 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   0	273	1	paramString	String
    //   65	10	2	i	int
    //   24	242	3	localObject1	Object
    //   1	44	4	localObject2	Object
    //   81	6	4	localException	Exception
    //   94	162	4	localObject3	Object
    //   26	221	5	localObject4	Object
    //   252	6	5	localObject5	Object
    //   7	129	6	str	String
    //   4	39	7	localObject6	Object
    //   37	35	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   149	165	81	java/lang/Exception
    //   181	185	186	java/io/IOException
    //   13	25	188	finally
    //   165	169	215	java/io/IOException
    //   173	177	219	java/io/IOException
    //   126	130	223	java/io/IOException
    //   135	140	227	java/io/IOException
    //   144	148	231	java/io/IOException
    //   191	195	233	java/io/IOException
    //   200	205	237	java/io/IOException
    //   209	213	241	java/io/IOException
    //   32	39	245	finally
    //   46	55	245	finally
    //   96	126	245	finally
    //   55	66	252	finally
    //   70	78	252	finally
    //   149	165	252	finally
    //   13	25	263	java/lang/Exception
    //   32	39	269	java/lang/Exception
    //   46	55	269	java/lang/Exception
  }
  
  @Deprecated
  public static int copySdcardFile(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || ("".equals(paramString1)) || ("".equals(paramString2))) {
      return -1;
    }
    return copyFile(new File(paramString1), new File(paramString2));
  }
  
  public static String copyXMLForWebview(String paramString1, String paramString2)
  {
    paramString2 = paramString2.replace("file://", "");
    Object localObject = getFileNameSuffix(paramString1);
    paramString1 = paramString2;
    if (localObject != null)
    {
      paramString1 = paramString2;
      if (((String)localObject).equalsIgnoreCase("xml"))
      {
        localObject = new File(paramString2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".txt");
        paramString1 = paramString2;
        if (copyFile((File)localObject, new File(localStringBuilder.toString())) == 0) {
          paramString1 = localStringBuilder.toString();
        }
      }
    }
    return "file://" + paramString1;
  }
  
  public static boolean createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void createNoMediaFileForCertainPath(String paramString)
  {
    Object localObject = new File(paramString);
    if ((TextUtils.isEmpty(paramString)) || (localObject == null) || (!((File)localObject).exists())) {}
    do
    {
      return;
      localObject = paramString;
      if (!paramString.endsWith("/")) {
        localObject = paramString + "/";
      }
      paramString = new File((String)localObject + ".nomedia");
    } while (paramString.exists());
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      QMLog.log(6, "FileUtil", "create noMedia fail!");
    }
  }
  
  public static String createPhotoDirAtRootPath(String paramString)
  {
    String str = "";
    if ((!paramString.startsWith(FileDefine.EXTERNAL_SDCARD)) || (hasSdcard()))
    {
      paramString = paramString + File.separator + CommUtils.COMPOSE_CACHE + File.separator;
      File localFile = new File(paramString);
      str = paramString;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        str = paramString;
      }
    }
    return str;
  }
  
  public static String createThumbnailDirAtRootPath(String paramString)
  {
    String str = "";
    if ((!paramString.startsWith(FileDefine.EXTERNAL_SDCARD)) || (hasSdcard()))
    {
      paramString = "" + paramString + File.separator + CommUtils.COMPOSE_THUMBNAIL;
      File localFile = new File(paramString);
      str = paramString;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        str = paramString;
      }
    }
    return str;
  }
  
  public static void delAllFile(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return;
      } while (!localFile.isDirectory());
      arrayOfString = localFile.list();
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    int i = 0;
    label40:
    if (i < arrayOfString.length) {
      if (!paramString.endsWith(File.separator)) {
        break label168;
      }
    }
    label168:
    for (localFile = new File(paramString + arrayOfString[i]);; localFile = new File(paramString + File.separator + arrayOfString[i]))
    {
      if (localFile.isFile()) {
        localFile.delete();
      }
      if (localFile.isDirectory())
      {
        delAllFile(paramString + File.separator + arrayOfString[i]);
        delFolder(paramString + File.separator + arrayOfString[i]);
      }
      i += 1;
      break label40;
      break;
    }
  }
  
  public static void delAllPrefixFile(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return;
      } while (!localFile.isDirectory());
      arrayOfString = localFile.list();
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    int i = 0;
    label43:
    if (i < arrayOfString.length) {
      if (arrayOfString[i].startsWith(paramString2)) {
        if (!paramString1.endsWith(File.separator)) {
          break label186;
        }
      }
    }
    label186:
    for (localFile = new File(paramString1 + arrayOfString[i]);; localFile = new File(paramString1 + File.separator + arrayOfString[i]))
    {
      if (localFile.isFile()) {
        localFile.delete();
      }
      if (localFile.isDirectory())
      {
        delAllFile(paramString1 + "/" + arrayOfString[i]);
        delFolder(paramString1 + "/" + arrayOfString[i]);
      }
      i += 1;
      break label43;
      break;
    }
  }
  
  public static boolean delFile(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return true;
    }
    return paramString.delete();
  }
  
  public static void delFileBeforeCertianTime(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.isEmpty()) {
          return;
        }
        paramString = new File(paramString);
        if ((paramString.isDirectory()) && (paramString.exists()) && (paramString != null))
        {
          paramString = paramString.listFiles();
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString[i];
            long l = new Date(localObject.lastModified()).getTime();
            if (System.currentTimeMillis() - l > paramLong)
            {
              QMLog.log(4, "FileUtil", "File before certain time : delete" + localObject.getAbsolutePath());
              localObject.delete();
            }
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QMLog.log(6, "FileUtil", Log.getStackTraceString(paramString));
      }
    }
  }
  
  public static ArrayList<String> delFileByPath(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = Lists.newArrayList();
    for (;;)
    {
      File localFile;
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localFile = new File(str);
          if (!localFile.isFile()) {
            continue;
          }
          if (localFile.delete())
          {
            localArrayList.add(str);
            QMLog.log(4, "FileUtil", "delete file succ: " + localFile.getAbsolutePath());
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "FileUtil", "delFileByPath toDeleteSize " + paramArrayList.size() + " successSize " + localArrayList.size() + " " + Log.getStackTraceString(localException));
      }
      QMLog.log(4, "FileUtil", "delete file fail: " + localFile.getAbsolutePath());
    }
  }
  
  public static void delFolder(String paramString)
  {
    try
    {
      delAllFile(paramString);
      new File(paramString).delete();
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "FileUtil", "delFolder: " + paramString.getMessage());
    }
  }
  
  public static void delOldestNFile(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.isEmpty()) {
          return;
        }
        paramString = new File(paramString);
        if (paramString.exists())
        {
          paramString = paramString.listFiles();
          if (paramString != null)
          {
            Arrays.sort(paramString, new FileUtil.1());
            int i = 0;
            while (i < paramInt)
            {
              Log.d("FileUtil", "delOldestNFile, file:" + paramString[i].getName());
              paramString[i].delete();
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QMLog.log(6, "FileUtil", Log.getStackTraceString(paramString));
      }
    }
  }
  
  public static String file2String(String paramString)
  {
    paramString = fileContent(paramString);
    if (paramString == null) {
      return "";
    }
    return new String(paramString);
  }
  
  private static byte[] fileContent(FileInputStream paramFileInputStream)
  {
    Object localObject2 = null;
    if (paramFileInputStream == null) {}
    for (;;)
    {
      return localObject2;
      try
      {
        byte[] arrayOfByte1 = new byte[4096];
        localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          int i = paramFileInputStream.read(arrayOfByte1);
          if (i <= 0) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte1, 0, i);
        }
      }
      catch (Exception localException)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        QMLog.log(6, "FileUtil", "fileContent: " + localException.getMessage());
        if (paramFileInputStream != null)
        {
          try
          {
            paramFileInputStream.close();
            return null;
          }
          catch (IOException paramFileInputStream)
          {
            return null;
          }
          byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          localObject2 = arrayOfByte2;
          if (paramFileInputStream != null) {
            try
            {
              paramFileInputStream.close();
              return arrayOfByte2;
            }
            catch (IOException paramFileInputStream)
            {
              return arrayOfByte2;
            }
          }
        }
      }
      finally
      {
        if (paramFileInputStream == null) {}
      }
    }
    try
    {
      paramFileInputStream.close();
      label118:
      throw localObject1;
    }
    catch (IOException paramFileInputStream)
    {
      break label118;
    }
  }
  
  public static byte[] fileContent(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      if (paramString == null) {
        return null;
      }
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    return fileContent(paramString);
  }
  
  private static boolean filterLineWithIWE(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramArrayOfString.length)
      {
        if (paramString.contains(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String filterLocalPath(String paramString)
  {
    return paramString.replace("localhost/", "/");
  }
  
  public static String formatPath(String paramString)
  {
    String[] arrayOfString = paramString.split(File.separator);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("...").append(File.separator);
    if (arrayOfString.length > 4)
    {
      int i = arrayOfString.length - 4;
      while (i < arrayOfString.length)
      {
        localStringBuilder.append(arrayOfString[i]).append(File.separator);
        i += 1;
      }
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  public static String getAdvertiseImgDir()
  {
    if (!hasSdcard()) {
      QMLog.log(6, "FileUtil", "has not Sdcard");
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailAdvertiseGifDir()))) {
      return null;
    }
    File localFile = new File(QMPathManager.sharedInstance().getQQMailAdvertiseGifDir() + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return QMPathManager.sharedInstance().getQQMailAdvertiseGifDir();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QMLog.log(6, "FileUtil", "create noMedia fail!");
      }
    }
  }
  
  public static String getAttachDownloadDir()
  {
    if (!hasSdcard()) {}
    File localFile;
    do
    {
      return null;
      localFile = getDownloadDirectoryFile();
    } while (localFile == null);
    return localFile.getAbsolutePath() + File.separator;
  }
  
  public static long getCacheSize()
  {
    return 0L + getDirectorySize(getThumbImageCacheDir()) + getProtocolMailCacheSize() + getDirectorySize(QMPathManager.sharedInstance().getQQMailEmailIconDir()) + getDirectorySize(QMPathManager.sharedInstance().getQQMailNickIconDir()) + getDirectorySize(QMPathManager.sharedInstance().getQQMailLogDir()) + getDownloadAttachCacheSize(DownloadInfoManager.shareInstance().getPathsInAttachDownloadDir(true));
  }
  
  public static String getComposeCachePath()
  {
    if (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailComposeCacheDir()))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailComposeCacheDir();
  }
  
  public static String getCompressCacheDir()
  {
    if (!hasSdcard()) {
      QMLog.log(6, "FileUtil", "has not Sdcard");
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailCompressDir()))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailCompressDir();
  }
  
  private static String getDirFilesStorage(String paramString)
  {
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists()) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return "";
      } while (!((File)localObject1).isDirectory());
      arrayOfString = ((File)localObject1).list();
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    localObject1 = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      String str = paramString + File.separator + arrayOfString[i];
      File localFile = new File(str);
      Object localObject2;
      if (!localFile.exists()) {
        localObject2 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (localFile.isDirectory()) {
          localObject2 = (String)localObject1 + str + ":" + getDirectorySize(str) + ";";
        }
      }
    }
    return localObject1;
  }
  
  public static long getDirectorySize(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (!"".equals(paramString)) {
        break label25;
      }
      l2 = l1;
    }
    label25:
    int i;
    do
    {
      do
      {
        do
        {
          return l2;
          paramString = new File(paramString);
          l2 = l1;
        } while (!paramString.isDirectory());
        paramString = paramString.listFiles();
        l2 = l1;
      } while (paramString == null);
      i = 0;
      l2 = l1;
    } while (i >= paramString.length);
    l2 = l1;
    if (paramString[i] != null) {
      if (!paramString[i].isDirectory()) {
        break label108;
      }
    }
    label108:
    for (l2 = l1 + getDirectorySize(paramString[i].getAbsolutePath());; l2 = l1 + getFileSize(paramString[i].getAbsolutePath()))
    {
      i += 1;
      l1 = l2;
      break;
    }
  }
  
  public static long getDownloadAttachCacheSize(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    for (long l = 0L; paramArrayList.hasNext(); l = getFileSize((String)paramArrayList.next()) + l) {}
    return l;
  }
  
  public static File getDownloadDirectoryFile()
  {
    Object localObject2 = QMSettingManager.sharedInstance().getDownloadPath();
    Object localObject1 = localObject2;
    if (StringExtention.isNullOrEmpty((String)localObject2)) {
      localObject1 = QMPathManager.sharedInstance().getAttachDownloadPath();
    }
    localObject2 = new File((String)localObject1);
    if (!tryMkdirs((File)localObject2))
    {
      QMLog.log(6, "FileUtil", "mkdirs error:" + (String)localObject1);
      return null;
    }
    return localObject2;
  }
  
  public static String getDownloadTmpFileDir()
  {
    String str = QMPathManager.sharedInstance().getQQMailTmpDir();
    File localFile = new File(str);
    if (!tryMkdirs(localFile))
    {
      QMLog.log(6, "FileUtil", "mkdirs error:" + str);
      return null;
    }
    return localFile.getAbsolutePath() + File.separator;
  }
  
  public static String getEmailIconDirPath()
  {
    if (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailEmailIconDir()))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailEmailIconDir();
  }
  
  public static String getEmlCacheDir()
  {
    if (!hasSdcard())
    {
      QMLog.log(6, "FileUtil", "has not Sdcard");
      return null;
    }
    String str = QMPathManager.sharedInstance().getExternalQqmailEmlCacheDir();
    if (!tryMkdirs(new File(str)))
    {
      QMLog.log(4, "FileUtil", "can not make EmlCacheDirDir");
      return null;
    }
    createNoMediaFileForCertainPath(str);
    return str;
  }
  
  public static String getExitPushFileDir()
  {
    return FileDefine.INNER_DATA_DIR + "/watchfile/exitpush.watch";
  }
  
  public static String getExternalComposeCachePathWithKey(String paramString)
  {
    paramString = QMPathManager.sharedInstance().getQQMailComposeCacheDir() + paramString;
    tryMkdirs(new File(paramString));
    File localFile = new File(paramString + File.separator + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QMLog.log(6, "FileUtil", "create noMedia fail!");
    }
    return paramString;
  }
  
  public static String getExternalQQMailCacheDirPath()
  {
    if (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailCacheDir()))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailCacheDir();
  }
  
  public static String getExternalQQMailDirPath()
  {
    if (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailDir())))
    {
      QMLog.log(6, "FileUtil", "mkdirs error:" + QMPathManager.sharedInstance().getQQMailDir());
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailDir();
  }
  
  public static String getExternalUpLoadImageCachePath()
  {
    tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailUploadImageDir()));
    return QMPathManager.sharedInstance().getQQMailUploadImageDir();
  }
  
  public static String getFileNameSuffix(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return "";
      i = paramString.lastIndexOf('.');
    } while (i <= 0);
    return paramString.substring(i + 1);
  }
  
  public static long getFileSize(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    do
    {
      return 0L;
      paramString = new File(paramString);
    } while (paramString.isDirectory());
    return paramString.length();
  }
  
  public static String getFileType(String paramString)
  {
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        byte[] arrayOfByte = new byte[2];
        paramString = "";
        if (localFileInputStream.read(arrayOfByte) == -1) {
          break label219;
        }
        int i = 0;
        if (i < arrayOfByte.length)
        {
          paramString = paramString + Integer.toString(arrayOfByte[i] & 0xFF);
          i += 1;
          continue;
        }
        switch (Integer.parseInt(paramString))
        {
        case 7790: 
          paramString = "unknown type: " + paramString;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        FileInputStream localFileInputStream;
        paramString = "";
        localFileNotFoundException1.printStackTrace();
        return paramString;
      }
      catch (IOException localIOException1)
      {
        paramString = "";
        localIOException1.printStackTrace();
        return paramString;
      }
      try
      {
        localFileInputStream.close();
        return paramString;
      }
      catch (IOException localIOException2)
      {
        continue;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        continue;
      }
      paramString = "exe";
      continue;
      paramString = "png";
      continue;
      label219:
      paramString = "";
      continue;
      continue;
      paramString = "midi";
      continue;
      paramString = "rar";
      continue;
      paramString = "zip";
      continue;
      paramString = "jpg";
      continue;
      paramString = "gif";
      continue;
      paramString = "bmp";
    }
  }
  
  public static ArrayList<File> getFiles(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      return localArrayList;
    }
    if (!localFile.isDirectory()) {
      return localArrayList;
    }
    String[] arrayOfString = localFile.list();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int i = 0;
      if (i < arrayOfString.length)
      {
        if (paramString.endsWith(File.separator)) {}
        for (localFile = new File(paramString + arrayOfString[i]);; localFile = new File(paramString + File.separator + arrayOfString[i]))
        {
          localArrayList.add(localFile);
          i += 1;
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static String getInlineFileCacheDir()
  {
    if (!hasSdcard()) {}
    for (Object localObject = FileDefine.INNER_DATA_MAIL_INLINE_FILE;; localObject = QMPathManager.sharedInstance().getQQMailMailInlineFileCacheDir())
    {
      localObject = new File((String)localObject);
      if (tryMkdirs((File)localObject)) {
        break;
      }
      return null;
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  public static String getLastPushAdvertiseImgDir()
  {
    if (!hasSdcard()) {
      QMLog.log(6, "FileUtil", "has not Sdcard");
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailLastAdvertiseDir()))) {
      return null;
    }
    File localFile = new File(QMPathManager.sharedInstance().getQQMailLastAdvertiseDir() + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return QMPathManager.sharedInstance().getQQMailLastAdvertiseDir();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QMLog.log(6, "FileUtil", "create noMedia fail!");
      }
    }
  }
  
  public static String getLegalFileName(String paramString)
  {
    paramString = removeIllegalName(paramString);
    paramString = Pattern.compile("[\\\\/:*?\"<>|]").matcher(paramString).replaceAll("");
    paramString.trim().replaceAll(" ", "\\ ");
    return paramString;
  }
  
  private static String getLine(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    paramByteArrayOutputStream = paramByteArrayOutputStream.toByteArray();
    int k = 0;
    int j = paramByteArrayOutputStream.length - 1;
    while (j > k)
    {
      int i = paramByteArrayOutputStream[j];
      paramByteArrayOutputStream[j] = paramByteArrayOutputStream[k];
      paramByteArrayOutputStream[k] = i;
      k += 1;
      j -= 1;
    }
    return new String(paramByteArrayOutputStream);
  }
  
  public static String getLocalMailCachePathWithKey(String paramString, boolean paramBoolean)
  {
    File localFile = new File(QMPathManager.sharedInstance().getQQMailLocalCacheDir() + paramString);
    if ((paramBoolean) && (!tryMkdirs(localFile))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailLocalCacheDir() + paramString;
  }
  
  public static String getNativePagesDir()
  {
    if (!hasSdcard()) {
      QMLog.log(6, "FileUtil", "has not Sdcard");
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getNativePagesDir()))) {
      return null;
    }
    File localFile = new File(QMPathManager.sharedInstance().getNativePagesDir() + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return QMPathManager.sharedInstance().getNativePagesDir();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QMLog.log(6, "FileUtil", "create noMedia fail!");
      }
    }
  }
  
  public static String getNickIconDirPath()
  {
    if (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailNickIconDir()))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailNickIconDir();
  }
  
  public static int getOpenType(Context paramContext, String paramString)
  {
    if (IntentUtil.canDisplayByWebView(paramString)) {
      return 0;
    }
    if ((IntentUtil.canDisplayBySelf(paramString)) || (IntentUtil.canDisplayByOtherApp(paramContext, paramString))) {
      return 1;
    }
    return 2;
  }
  
  public static String getParentPath(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString);
    return paramString.getParent() + "/";
  }
  
  public static String getPopPurgeMailIdPath()
  {
    if (!hasSdcard()) {
      if (tryMkdirs(new File(FileDefine.PURGE_UIDS_PATH_NO_SDCARD_DIR))) {}
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailPurgeUidDir())))
    {
      return null;
      return FileDefine.PURGE_UIDS_PATH_NO_SDCARD_DIR;
    }
    return QMPathManager.sharedInstance().getQQMailPurgeUidDir();
  }
  
  public static String getPopUidsPath()
  {
    if (!hasSdcard()) {
      if (tryMkdirs(new File(FileDefine.POP_UIDS_PATH_NO_SDCARD))) {}
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailPopUidDir())))
    {
      return null;
      return FileDefine.POP_UIDS_PATH_NO_SDCARD;
    }
    return QMPathManager.sharedInstance().getQQMailPopUidDir();
  }
  
  @SuppressLint({"SdCardPath"})
  public static long getProtocolMailCacheSize()
  {
    long l1 = 0L;
    Object localObject = new File(FileDefine.INNER_DATA_CACHE_DIR);
    long l2 = l1;
    if (localObject != null)
    {
      l2 = l1;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).list();
        l2 = l1;
        if (localObject != null)
        {
          l2 = l1;
          if (localObject.length > 0)
          {
            int i = 0;
            for (;;)
            {
              l2 = l1;
              if (i >= localObject.length) {
                break;
              }
              l2 = l1;
              if (localObject[i] != null)
              {
                l2 = l1;
                if (localObject[i].toLowerCase().startsWith("foxmail_"))
                {
                  File localFile = new File(FileDefine.INNER_DATA_CACHE_DIR + localObject[i]);
                  l2 = l1;
                  if (localFile != null)
                  {
                    l2 = l1;
                    if (localFile.isFile())
                    {
                      l2 = l1;
                      if (localFile.getName() != null)
                      {
                        l2 = l1;
                        if (localFile.getName().startsWith("foxmail_")) {
                          l2 = l1 + localFile.length();
                        }
                      }
                    }
                  }
                }
              }
              i += 1;
              l1 = l2;
            }
          }
        }
        QMLog.log(4, "FileUtil", "getProtocolMailCacheSize:" + l2);
      }
    }
    return l2;
  }
  
  public static String getRqdNativeLogPath()
  {
    if (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailRqdNativeDir()))) {
      return null;
    }
    return QMPathManager.sharedInstance().getQQMailRqdNativeDir();
  }
  
  public static String getScanImageCacheDir()
  {
    if (!hasSdcard()) {
      QMLog.log(6, "FileUtil", "has not Sdcard");
    }
    String str;
    do
    {
      return null;
      str = QMPathManager.sharedInstance().getQQmailScanShareImageDir();
    } while (!tryMkdirs(new File(str)));
    createNoMediaFileForCertainPath(str);
    return str;
  }
  
  public static String getScanPDFCacheDir()
  {
    if (!hasSdcard()) {
      QMLog.log(6, "FileUtil", "has not Sdcard");
    }
    String str;
    do
    {
      return null;
      str = QMPathManager.sharedInstance().getQQmailScanSharePDFDir();
    } while (!tryMkdirs(new File(str)));
    createNoMediaFileForCertainPath(str);
    return str;
  }
  
  public static long getSdcardAllSpace()
  {
    if (hasSdcard()) {
      try
      {
        StatFs localStatFs = new StatFs(FileDefine.EXTERNAL_SDCARD);
        long l = localStatFs.getBlockSize();
        int i = localStatFs.getBlockCount();
        return i * l;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "FileUtil", "getSdcardAllSpace error");
      }
    }
    return 0L;
  }
  
  public static long getSdcardUsableSpace()
  {
    if (hasSdcard()) {
      try
      {
        StatFs localStatFs = new StatFs(FileDefine.EXTERNAL_SDCARD);
        long l = localStatFs.getBlockSize();
        int i = localStatFs.getAvailableBlocks();
        return i * l;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "FileUtil", "getSdcardUsableSpace error " + localException.getMessage());
      }
    }
    return 0L;
  }
  
  public static String getThumbImageCacheDir()
  {
    if (!hasSdcard()) {}
    for (Object localObject = FileDefine.INNER_DATA_THUMB_IMAGE_CACHE_DIR;; localObject = QMPathManager.sharedInstance().getQQMailThumbImageCacheDir())
    {
      localObject = new File((String)localObject);
      if (tryMkdirs((File)localObject)) {
        break;
      }
      return null;
    }
    return ((File)localObject).getAbsolutePath() + File.separator;
  }
  
  @TargetApi(9)
  public static long getUsableSpace(File paramFile)
  {
    if (Utils.hasGingerbread()) {
      return paramFile.getUsableSpace();
    }
    try
    {
      paramFile = new StatFs(paramFile.getPath());
      long l = paramFile.getBlockSize();
      int i = paramFile.getAvailableBlocks();
      return i * l;
    }
    catch (Exception paramFile)
    {
      QMLog.log(6, "FileUtil", "getUsableSpace error " + paramFile.getMessage());
    }
    return 0L;
  }
  
  public static String getWebviewScreenshotDir()
  {
    if (!hasSdcard())
    {
      QMLog.log(6, "FileUtil", "has not Sdcard");
      return null;
    }
    String str = QMPathManager.sharedInstance().getExternalQqmailWebviewScreenshotDir();
    if (!tryMkdirs(new File(str)))
    {
      QMLog.log(4, "FileUtil", "can not make ScreenshotDir");
      return null;
    }
    createNoMediaFileForCertainPath(str);
    return str;
  }
  
  public static String getWelcomeSplashPath()
  {
    if (!hasSdcard()) {
      if (tryMkdirs(new File(FileDefine.WELCOME_SPLASH_NO_SDCARD_DIR))) {}
    }
    while (!tryMkdirs(new File(QMPathManager.sharedInstance().getQQMailWelcomeDir())))
    {
      return null;
      return FileDefine.WELCOME_SPLASH_NO_SDCARD_DIR;
    }
    return QMPathManager.sharedInstance().getQQMailWelcomeDir();
  }
  
  public static boolean hasSdcard()
  {
    Object localObject = null;
    try
    {
      String str = Environment.getExternalStorageState();
      localObject = str;
    }
    catch (Exception localException)
    {
      label8:
      boolean bool;
      break label8;
    }
    bool = "mounted".equals(localObject);
    if (!bool) {
      QMLog.log(5, "FileUtil", "no sdcard!");
    }
    return bool;
  }
  
  public static boolean isCompressSuffix(String paramString)
  {
    return "compress".equals(AttachType.valueOf(QMAttachUtils.attachFileType(paramString)).name().toLowerCase(Locale.getDefault()));
  }
  
  public static boolean isFileDir(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return false;
    }
    return new File(paramString).isDirectory();
  }
  
  public static boolean isFileExist(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean isFileTypeTiff(String paramString)
  {
    paramString = getFileNameSuffix(paramString);
    if ((paramString != null) && (!paramString.equals(""))) {
      return paramString.contains("tif");
    }
    return false;
  }
  
  public static boolean isImageSuffix(String paramString)
  {
    paramString = paramString.toLowerCase();
    if (imgFileSuffix == null) {
      imgFileSuffix = new String[] { "png", "gif", "jpg", "jpeg", "bmp", "ico" };
    }
    int j = imgFileSuffix.length;
    int i = 0;
    while (i < j)
    {
      if (imgFileSuffix[i].equals(paramString.toLowerCase(Locale.getDefault()))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isSuffixEml(String paramString)
  {
    return "eml".equals(paramString.toLowerCase());
  }
  
  public static byte[] readByte(String paramString, long paramLong)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      QMLog.log(6, "FileUtil", "read file to bytes. file not exist.");
      return null;
    }
    return readBytesFromFile(paramString, paramLong);
  }
  
  private static byte[] readBytesFromFile(File paramFile, long paramLong)
  {
    label182:
    for (;;)
    {
      try
      {
        paramFile = new BufferedInputStream(new FileInputStream(paramFile));
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        if (paramLong > 0L)
        {
          int j = paramFile.read(arrayOfByte);
          if (j != -1)
          {
            if (paramLong <= j) {
              break label182;
            }
            i = j;
            localByteArrayOutputStream.write(arrayOfByte, 0, i);
            paramLong -= j;
            continue;
          }
        }
        paramFile.close();
        paramFile = localByteArrayOutputStream.toByteArray();
        int i = (int)paramLong;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        try
        {
          localByteArrayOutputStream.close();
          return paramFile;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          continue;
        }
        localFileNotFoundException1 = localFileNotFoundException1;
        paramFile = null;
        QMLog.log(6, "FileUtil", "read file to bytes e : " + localFileNotFoundException1.toString());
        return paramFile;
      }
      catch (IOException localIOException1)
      {
        paramFile = null;
        QMLog.log(6, "FileUtil", "read file to bytes e : " + localIOException1.toString());
        return paramFile;
      }
    }
  }
  
  /* Error */
  public static List<String> readFileLastLines(String paramString, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 109	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 383	java/io/File:exists	()Z
    //   11: ifne +7 -> 18
    //   14: aconst_null
    //   15: astore_0
    //   16: aload_0
    //   17: areturn
    //   18: new 471	java/util/ArrayList
    //   21: dup
    //   22: bipush 50
    //   24: invokespecial 923	java/util/ArrayList:<init>	(I)V
    //   27: astore 11
    //   29: new 925	java/io/RandomAccessFile
    //   32: dup
    //   33: aload_0
    //   34: ldc_w 927
    //   37: invokespecial 929	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: astore 10
    //   42: aload 10
    //   44: astore_0
    //   45: new 537	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 538	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 12
    //   54: aload 10
    //   56: astore_0
    //   57: aload 10
    //   59: invokevirtual 930	java/io/RandomAccessFile:length	()J
    //   62: lstore 8
    //   64: lload 8
    //   66: lconst_1
    //   67: lsub
    //   68: lstore 6
    //   70: lload 6
    //   72: lconst_0
    //   73: lcmp
    //   74: iflt +181 -> 255
    //   77: aload 10
    //   79: astore_0
    //   80: aload 11
    //   82: invokeinterface 933 1 0
    //   87: iload_1
    //   88: if_icmpge +167 -> 255
    //   91: aload 10
    //   93: astore_0
    //   94: aload 10
    //   96: lload 6
    //   98: invokevirtual 936	java/io/RandomAccessFile:seek	(J)V
    //   101: aload 10
    //   103: astore_0
    //   104: aload 10
    //   106: invokevirtual 938	java/io/RandomAccessFile:read	()I
    //   109: istore 4
    //   111: iload 4
    //   113: bipush 10
    //   115: if_icmpne +70 -> 185
    //   118: lload 6
    //   120: lload 8
    //   122: lconst_1
    //   123: lsub
    //   124: lcmp
    //   125: ifge +313 -> 438
    //   128: aload 10
    //   130: astore_0
    //   131: aload 12
    //   133: invokestatic 940	com/tencent/qqmail/utilities/fileextention/FileUtil:getLine	(Ljava/io/ByteArrayOutputStream;)Ljava/lang/String;
    //   136: astore 13
    //   138: iconst_1
    //   139: istore 5
    //   141: iload_3
    //   142: ifeq +14 -> 156
    //   145: aload 10
    //   147: astore_0
    //   148: aload_2
    //   149: aload 13
    //   151: invokestatic 942	com/tencent/qqmail/utilities/fileextention/FileUtil:filterLineWithIWE	([Ljava/lang/String;Ljava/lang/String;)Z
    //   154: istore 5
    //   156: iload 5
    //   158: ifeq +16 -> 174
    //   161: aload 10
    //   163: astore_0
    //   164: aload 11
    //   166: iconst_0
    //   167: aload 13
    //   169: invokeinterface 945 3 0
    //   174: aload 10
    //   176: astore_0
    //   177: aload 12
    //   179: invokevirtual 948	java/io/ByteArrayOutputStream:reset	()V
    //   182: goto +256 -> 438
    //   185: iload 4
    //   187: bipush 13
    //   189: if_icmpeq +249 -> 438
    //   192: aload 10
    //   194: astore_0
    //   195: aload 12
    //   197: iload 4
    //   199: invokevirtual 949	java/io/ByteArrayOutputStream:write	(I)V
    //   202: goto +236 -> 438
    //   205: astore_0
    //   206: aload 10
    //   208: astore_2
    //   209: aload_0
    //   210: astore 10
    //   212: aload_2
    //   213: astore_0
    //   214: bipush 6
    //   216: ldc 18
    //   218: new 92	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 951
    //   228: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 10
    //   233: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   236: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   245: aload_2
    //   246: ifnull +7 -> 253
    //   249: aload_2
    //   250: invokevirtual 953	java/io/RandomAccessFile:close	()V
    //   253: aconst_null
    //   254: areturn
    //   255: lload 6
    //   257: ldc2_w 954
    //   260: lcmp
    //   261: ifne +38 -> 299
    //   264: aload 10
    //   266: astore_0
    //   267: aload 12
    //   269: invokestatic 940	com/tencent/qqmail/utilities/fileextention/FileUtil:getLine	(Ljava/io/ByteArrayOutputStream;)Ljava/lang/String;
    //   272: astore 12
    //   274: aload 10
    //   276: astore_0
    //   277: aload_2
    //   278: aload 12
    //   280: invokestatic 942	com/tencent/qqmail/utilities/fileextention/FileUtil:filterLineWithIWE	([Ljava/lang/String;Ljava/lang/String;)Z
    //   283: ifeq +16 -> 299
    //   286: aload 10
    //   288: astore_0
    //   289: aload 11
    //   291: iconst_0
    //   292: aload 12
    //   294: invokeinterface 945 3 0
    //   299: aload 11
    //   301: astore_0
    //   302: aload 10
    //   304: ifnull -288 -> 16
    //   307: aload 10
    //   309: invokevirtual 953	java/io/RandomAccessFile:close	()V
    //   312: aload 11
    //   314: areturn
    //   315: astore_0
    //   316: iconst_3
    //   317: ldc 18
    //   319: new 92	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 957
    //   329: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: invokevirtual 164	java/io/IOException:toString	()Ljava/lang/String;
    //   336: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   345: aload 11
    //   347: areturn
    //   348: astore_0
    //   349: iconst_3
    //   350: ldc 18
    //   352: new 92	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 957
    //   362: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: invokevirtual 164	java/io/IOException:toString	()Ljava/lang/String;
    //   369: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   378: goto -125 -> 253
    //   381: astore_2
    //   382: aconst_null
    //   383: astore_0
    //   384: aload_0
    //   385: ifnull +7 -> 392
    //   388: aload_0
    //   389: invokevirtual 953	java/io/RandomAccessFile:close	()V
    //   392: aload_2
    //   393: athrow
    //   394: astore_0
    //   395: iconst_3
    //   396: ldc 18
    //   398: new 92	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   405: ldc_w 957
    //   408: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: invokevirtual 164	java/io/IOException:toString	()Ljava/lang/String;
    //   415: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   424: goto -32 -> 392
    //   427: astore_2
    //   428: goto -44 -> 384
    //   431: astore 10
    //   433: aconst_null
    //   434: astore_2
    //   435: goto -223 -> 212
    //   438: lload 6
    //   440: lconst_1
    //   441: lsub
    //   442: lstore 6
    //   444: goto -374 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramString	String
    //   0	447	1	paramInt	int
    //   0	447	2	paramArrayOfString	String[]
    //   0	447	3	paramBoolean	boolean
    //   109	89	4	i	int
    //   139	18	5	bool	boolean
    //   68	375	6	l1	long
    //   62	59	8	l2	long
    //   40	268	10	localObject1	Object
    //   431	1	10	localException	Exception
    //   27	319	11	localArrayList	ArrayList
    //   52	241	12	localObject2	Object
    //   136	32	13	str	String
    // Exception table:
    //   from	to	target	type
    //   45	54	205	java/lang/Exception
    //   57	64	205	java/lang/Exception
    //   80	91	205	java/lang/Exception
    //   94	101	205	java/lang/Exception
    //   104	111	205	java/lang/Exception
    //   131	138	205	java/lang/Exception
    //   148	156	205	java/lang/Exception
    //   164	174	205	java/lang/Exception
    //   177	182	205	java/lang/Exception
    //   195	202	205	java/lang/Exception
    //   267	274	205	java/lang/Exception
    //   277	286	205	java/lang/Exception
    //   289	299	205	java/lang/Exception
    //   307	312	315	java/io/IOException
    //   249	253	348	java/io/IOException
    //   29	42	381	finally
    //   388	392	394	java/io/IOException
    //   45	54	427	finally
    //   57	64	427	finally
    //   80	91	427	finally
    //   94	101	427	finally
    //   104	111	427	finally
    //   131	138	427	finally
    //   148	156	427	finally
    //   164	174	427	finally
    //   177	182	427	finally
    //   195	202	427	finally
    //   214	245	427	finally
    //   267	274	427	finally
    //   277	286	427	finally
    //   289	299	427	finally
    //   29	42	431	java/lang/Exception
  }
  
  public static String readString(String paramString)
  {
    return readString(paramString, 9223372036854775807L, Charset.defaultCharset());
  }
  
  public static String readString(String paramString, long paramLong, Charset paramCharset)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = readByte(paramString, paramLong);
    } while (paramString == null);
    try
    {
      paramString = new String(paramString, paramCharset);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String removeIllegalName(String paramString)
  {
    String str = paramString;
    if (!StringExtention.isNullOrEmpty(paramString)) {
      str = paramString.replace('\r', '_').replace('\t', '_').replace('\n', '_').replace('\\', '_');
    }
    return str;
  }
  
  public static String rename(String paramString1, String paramString2)
  {
    if ((StringExtention.isNullOrEmpty(paramString1)) || (StringExtention.isNullOrEmpty(paramString2))) {
      return "";
    }
    String str2 = toDirPath(paramString1.replaceFirst("/*$", "/"));
    String str3 = removeIllegalName(paramString2);
    paramString2 = str3.split("\\.");
    String str1;
    int i;
    if ((paramString2 != null) && (paramString2.length > 0))
    {
      str1 = paramString2[0];
      if (paramString2.length <= 1) {
        break label285;
      }
      paramString1 = str1;
      i = 1;
      while (i < paramString2.length - 1)
      {
        paramString1 = paramString1 + "." + paramString2[i];
        i += 1;
      }
      paramString2 = paramString2[(paramString2.length - 1)];
      str1 = paramString1;
    }
    for (;;)
    {
      paramString1 = new String(str3);
      i = 1;
      if (new File(str2 + paramString1).exists())
      {
        if (StringExtention.isNullOrEmpty(paramString2)) {}
        for (paramString1 = str1 + "(" + i + ")";; paramString1 = str1 + "(" + i + ")." + paramString2)
        {
          i += 1;
          break;
        }
      }
      QMLog.log(4, "FileUtil", str3 + " is renamed to " + paramString1);
      return paramString1;
      return str3;
      label285:
      paramString2 = "";
    }
  }
  
  public static File renameFile(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1);
      paramString1 = new File(paramString2);
      paramString2.printStackTrace();
    }
    catch (Exception paramString2)
    {
      try
      {
        localFile.renameTo(paramString1);
        return paramString1;
      }
      catch (Exception paramString2)
      {
        break label29;
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    label29:
    return paramString1;
  }
  
  public static int safeCopyFile(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2 + paramString3);
    try
    {
      int i = copyFile(paramString1, paramString2);
      return i;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public static void setAttachDownloadDir(String paramString)
  {
    QMSettingManager.sharedInstance().setDownloadPath(paramString);
  }
  
  public static String toDirPath(String paramString)
  {
    String str = paramString;
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
    }
    else {
      return str;
    }
    int i = paramString.length() - 1;
    for (;;)
    {
      if ((i <= 0) || (paramString.charAt(i) != '/') || (paramString.charAt(i - 1) != '/')) {
        return paramString.substring(0, i + 1);
      }
      i -= 1;
    }
  }
  
  public static String trimFileNameSufix(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      if (paramString.equals("")) {
        break;
      }
      i = paramString.lastIndexOf('.');
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
    return "";
  }
  
  /* Error */
  public static boolean tryMkdirs(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 383	java/io/File:exists	()Z
    //   7: ifeq +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 430	java/io/File:isDirectory	()Z
    //   14: ifne +47 -> 61
    //   17: aload_0
    //   18: invokevirtual 422	java/io/File:mkdirs	()Z
    //   21: ifne +40 -> 61
    //   24: bipush 6
    //   26: ldc 18
    //   28: new 92	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 1021
    //   38: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 292	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 65	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   54: iconst_0
    //   55: istore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: iload_1
    //   60: ireturn
    //   61: iconst_1
    //   62: istore_1
    //   63: goto -7 -> 56
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramFile	File
    //   55	8	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	66	finally
    //   17	54	66	finally
  }
  
  @Deprecated
  public static String uniqueFileName(String paramString1, String paramString2)
  {
    int k = 1;
    String[] arrayOfString = paramString1.split("\\.");
    paramString1 = arrayOfString[0];
    String str2 = arrayOfString[(arrayOfString.length - 1)];
    int j;
    String str1;
    if (arrayOfString.length > 2)
    {
      int i = 1;
      for (;;)
      {
        j = k;
        str1 = paramString1;
        if (i >= arrayOfString.length - 1) {
          break;
        }
        paramString1 = paramString1 + "." + arrayOfString[i];
        i += 1;
      }
    }
    for (;;)
    {
      if (new File(paramString2 + str1 + "." + str2).exists())
      {
        str1 = str1 + j;
        j += 1;
      }
      else
      {
        return str1 + "." + str2;
        j = k;
        str1 = paramString1;
      }
    }
  }
  
  public static boolean verifyMd5(String paramString1, String paramString2)
  {
    paramString1 = StringExtention.fileMD5(paramString1);
    QMLog.log(4, "FileUtil", "currentMd5 = " + paramString1 + " desireMd5 = " + paramString2);
    return TextUtils.equals(paramString1, paramString2);
  }
  
  public static void writeLogFileClear(File paramFile, List<String> paramList)
  {
    if ((paramList == null) || (paramFile == null))
    {
      QMLog.log(6, "FileUtil", "writeLogFileClear. invalid param");
      return;
    }
    try
    {
      if (!paramFile.exists()) {
        paramFile.createNewFile();
      }
      Object localObject = new FileOutputStream(paramFile);
      ((FileOutputStream)localObject).write(new String("").getBytes());
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      paramFile = new BufferedWriter(new FileWriter(paramFile));
      localObject = new StringBuilder();
      int i = 0;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append((String)paramList.get(i)).append("\n");
        i += 1;
      }
      paramFile.write(((StringBuilder)localObject).toString());
      paramFile.flush();
      paramFile.close();
      return;
    }
    catch (IOException paramFile)
    {
      QMLog.log(6, "FileUtil", "writeLogFile err:" + paramFile.toString());
    }
  }
  
  public static abstract interface CallBack
  {
    public abstract void onError(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fileextention.FileUtil
 * JD-Core Version:    0.7.0.1
 */