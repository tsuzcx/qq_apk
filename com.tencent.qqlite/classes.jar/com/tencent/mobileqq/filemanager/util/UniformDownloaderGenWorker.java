package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.MobileQQ;

public class UniformDownloaderGenWorker
  implements IHttpCommunicatorListener
{
  public static int a = 0;
  public static String a;
  public static int b = 0;
  public static final String b = "EXT_TRANS_SIZE ";
  public static int c = 0;
  public static final String c = "EXT_TTRANS_SIZE ";
  public static final int d = 3;
  public static final String d = "EXT_AUTOTRY_COUNT";
  long jdField_a_of_type_Long = 0L;
  private UniformDownloaderGen.IUniformDownloaderGenListener jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener = null;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private OutputStream jdField_a_of_type_JavaIoOutputStream = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private final long jdField_d_of_type_Long;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private int jdField_e_of_type_Int = jdField_b_of_type_Int;
  private long jdField_e_of_type_Long = 0L;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private final String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int = 0;
  private String jdField_f_of_type_JavaLangString;
  private int g = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGenWorker<FileAssistant>";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
  }
  
  public UniformDownloaderGenWorker(long paramLong1, QQAppInterface paramQQAppInterface, String paramString, long paramLong2, UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
    this.jdField_d_of_type_Long = paramLong2;
  }
  
  private int a()
  {
    int i = jdField_b_of_type_Int;
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      i = this.jdField_e_of_type_Int;
      return i;
    }
  }
  
  private long a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      long l = this.jdField_e_of_type_Long;
      return l;
    }
  }
  
  private UniformDownloaderGen.IUniformDownloaderGenListener a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      UniformDownloaderGen.IUniformDownloaderGenListener localIUniformDownloaderGenListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener;
      return localIUniformDownloaderGenListener;
    }
  }
  
  private HttpMsg a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      HttpMsg localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      return localHttpMsg;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. setStatus: " + this.jdField_e_of_type_Int + " -> " + paramInt);
      this.jdField_e_of_type_Int = paramInt;
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface != null)
    {
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", this.jdField_f_of_type_Int, paramString2, null);
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", this.jdField_f_of_type_Int, paramString2, null);
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.a(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramString2 = a();
      if (paramString2 != null) {
        paramString2.a(paramInt, paramString1, null);
      }
      return;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 3");
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_e_of_type_Long = paramLong;
      return;
    }
  }
  
  private void a(UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
      return;
    }
  }
  
  private boolean a()
  {
    return jdField_b_of_type_Int == a();
  }
  
  /* Error */
  private boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: lload_1
    //   6: invokespecial 176	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:a	(J)V
    //   9: new 86	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   16: ldc 178
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_1
    //   22: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: ldc 180
    //   27: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_0
    //   36: getfield 75	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   39: ifnull +216 -> 255
    //   42: aload_0
    //   43: getfield 75	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   46: ldc 182
    //   48: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   51: ifne +204 -> 255
    //   54: new 86	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 75	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 190
    //   70: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 4
    //   85: new 196	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   88: dup
    //   89: aload 4
    //   91: aconst_null
    //   92: aload_0
    //   93: iconst_1
    //   94: invokespecial 199	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;Z)V
    //   97: astore 6
    //   99: ldc 201
    //   101: astore 4
    //   103: invokestatic 206	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   106: invokestatic 211	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   109: iconst_1
    //   110: if_icmpne +7 -> 117
    //   113: ldc 213
    //   115: astore 4
    //   117: aload 6
    //   119: ldc 215
    //   121: aload 4
    //   123: invokevirtual 218	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: ldc 220
    //   130: aload 5
    //   132: invokevirtual 218	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 6
    //   137: iconst_1
    //   138: invokevirtual 222	com/tencent/mobileqq/utils/httputils/HttpMsg:b	(I)V
    //   141: aload 6
    //   143: iconst_1
    //   144: invokevirtual 225	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Z)V
    //   147: aload 6
    //   149: iconst_5
    //   150: putfield 227	com/tencent/mobileqq/utils/httputils/HttpMsg:d	I
    //   153: aload 6
    //   155: iconst_0
    //   156: putfield 228	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Int	I
    //   159: aload 6
    //   161: invokestatic 233	java/lang/System:currentTimeMillis	()J
    //   164: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   167: putfield 236	com/tencent/mobileqq/utils/httputils/HttpMsg:ae	Ljava/lang/String;
    //   170: aload 6
    //   172: ldc 238
    //   174: ldc 240
    //   176: invokevirtual 218	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: aload 6
    //   182: invokespecial 243	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   185: invokestatic 121	com/tencent/mobileqq/filemanager/core/UniformDownloadMgr:a	()Lcom/tencent/mobileqq/filemanager/core/UniformDownloadMgr;
    //   188: invokevirtual 124	com/tencent/mobileqq/filemanager/core/UniformDownloadMgr:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   191: astore 4
    //   193: aload 4
    //   195: ifnonnull +94 -> 289
    //   198: getstatic 34	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: iconst_1
    //   202: new 86	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   209: ldc 89
    //   211: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: getfield 73	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_c_of_type_Long	J
    //   218: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: ldc 245
    //   223: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: lload_1
    //   227: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc 247
    //   232: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload_1
    //   236: aload_0
    //   237: getfield 77	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_d_of_type_Long	J
    //   240: ldiv
    //   241: l2i
    //   242: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: monitorexit
    //   253: iload_3
    //   254: ireturn
    //   255: new 86	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   262: aload_0
    //   263: getfield 75	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   266: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 249
    //   271: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: lload_1
    //   275: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   278: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 4
    //   286: goto -201 -> 85
    //   289: aload 4
    //   291: invokevirtual 252	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   294: aload 6
    //   296: invokevirtual 257	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   299: pop
    //   300: getstatic 34	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   303: iconst_1
    //   304: new 86	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   311: ldc 89
    //   313: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_0
    //   317: getfield 73	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_c_of_type_Long	J
    //   320: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   323: ldc_w 259
    //   326: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: lload_1
    //   330: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   333: ldc 247
    //   335: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: lload_1
    //   339: aload_0
    //   340: getfield 77	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_d_of_type_Long	J
    //   343: ldiv
    //   344: l2i
    //   345: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_1
    //   355: istore_3
    //   356: goto -105 -> 251
    //   359: astore 4
    //   361: aload_0
    //   362: monitorexit
    //   363: aload 4
    //   365: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	UniformDownloaderGenWorker
    //   0	366	1	paramLong	long
    //   1	355	3	bool	boolean
    //   83	207	4	localObject1	Object
    //   359	5	4	localObject2	Object
    //   33	98	5	str	String
    //   97	198	6	localHttpMsg	HttpMsg
    // Exception table:
    //   from	to	target	type
    //   4	85	359	finally
    //   85	99	359	finally
    //   103	113	359	finally
    //   117	193	359	finally
    //   198	251	359	finally
    //   255	286	359	finally
    //   289	354	359	finally
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return paramHttpMsg2.d();
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. writeFileStream: stream = null:");
          return false;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
  }
  
  private void b(HttpMsg paramHttpMsg)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg;
      return;
    }
  }
  
  private boolean b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        OutputStream localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
        if (localOutputStream == null) {
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_f_of_type_JavaLangString, true);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: filepath:" + this.jdField_f_of_type_JavaLangString);
            return true;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: exception");
            localFileNotFoundException.printStackTrace();
            return false;
          }
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: had be opened");
    }
  }
  
  private void c()
  {
    try
    {
      a(jdField_b_of_type_Int);
      d();
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          this.jdField_a_of_type_JavaIoOutputStream = null;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: filepath:" + this.jdField_f_of_type_JavaLangString);
        }
        for (;;)
        {
          return true;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
        localObject2 = finally;
      }
      catch (IOException localIOException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: exception");
        localIOException.printStackTrace();
        return false;
      }
    }
  }
  
  private void d()
  {
    HttpMsg localHttpMsg = a();
    if (localHttpMsg != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest");
      b(null);
      QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
      if (localQQAppInterface == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest failed.APP=null");
        return;
      }
      localQQAppInterface.a().a(localHttpMsg);
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest: no request");
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i;
    int j;
    int k;
    if (paramHttpMsg != null)
    {
      i = paramHttpMsg.d;
      j = paramHttpMsg.jdField_e_of_type_Int;
      k = paramHttpMsg.jdField_f_of_type_Int;
      if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
      }
      if (!"POST".equals(paramHttpMsg.e())) {
        break label138;
      }
    }
    QQAppInterface localQQAppInterface;
    label138:
    for (boolean bool = true;; bool = false)
    {
      localQQAppInterface = UniformDownloadMgr.a().a();
      if (localQQAppInterface != null) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. onFlowEvent failed.APP=null");
      return;
    }
    localQQAppInterface.a(localQQAppInterface.getAccount(), bool, k, i, j, paramHttpMsg.i);
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a()) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. decode. but had stoped");
    }
    int i;
    do
    {
      long l;
      do
      {
        for (;;)
        {
          return;
          try
          {
            if ((paramHttpMsg2.c() == 206) || (paramHttpMsg2.c() == 200)) {
              if (!a(paramHttpMsg2.a()))
              {
                i = 3;
                paramHttpMsg1 = UniformDownloader.a(3);
                l = 0L;
                if (SystemUtil.a()) {
                  l = SystemUtil.a() * 1024L;
                }
                if (l < this.jdField_d_of_type_Long - a())
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] write file failed. sd card space is no enough:[" + this.jdField_d_of_type_Long + " " + a() + " " + l + "]");
                  i = 9;
                  paramHttpMsg1 = UniformDownloader.a(9);
                }
                a(i, paramHttpMsg1, paramHttpMsg1);
                return;
              }
            }
          }
          catch (Exception paramHttpMsg1)
          {
            paramHttpMsg1.printStackTrace();
            paramHttpMsg1 = UniformDownloader.a(12);
            a(12, paramHttpMsg1, paramHttpMsg1);
            return;
          }
        }
        l = a() + paramHttpMsg2.a().length;
        a(l);
        this.jdField_b_of_type_Long += paramHttpMsg2.a().length;
        if (l < this.jdField_d_of_type_Long) {
          break;
        }
        if (!c())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].closeFileStream falied.path=" + this.jdField_f_of_type_JavaLangString);
          paramHttpMsg1 = UniformDownloader.a(4);
          a(4, paramHttpMsg1, paramHttpMsg1);
          return;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].decode >>>>>>>. SUCESSFUL!!!");
        paramHttpMsg1 = a();
      } while (paramHttpMsg1 == null);
      paramHttpMsg2 = new Bundle();
      paramHttpMsg2.putLong("EXT_TRANS_SIZE ", this.jdField_e_of_type_Long);
      paramHttpMsg2.putLong("EXT_TTRANS_SIZE ", this.jdField_b_of_type_Long);
      paramHttpMsg2.putInt("EXT_AUTOTRY_COUNT", this.jdField_f_of_type_Int);
      paramHttpMsg1.a(this.jdField_f_of_type_JavaLangString, this.jdField_d_of_type_Long, paramHttpMsg2);
      return;
      i = (int)((float)l / (float)this.jdField_d_of_type_Long * 100.0F);
      paramHttpMsg1 = a();
    } while (paramHttpMsg1 == null);
    paramHttpMsg1.a(i, null);
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. HttpCommunicator statusChanged. status:" + paramInt);
    if ((5 == paramInt) && (a() < this.jdField_d_of_type_Long))
    {
      c();
      paramHttpMsg1 = UniformDownloader.a(14);
      QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
      if (localQQAppInterface == null) {
        break label226;
      }
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_f_of_type_Int, paramHttpMsg1, null);
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_f_of_type_Int, paramHttpMsg1, null);
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.a(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramHttpMsg1 = a();
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(14, "downloader fialed", null);
      }
      return true;
      label226:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. filepath = null. POS:" + paramLong);
      return false;
    }
    if (jdField_a_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start. is runing. POS:" + paramLong);
      return true;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    if (!b())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. openFileStream failed. POS:" + paramLong);
      paramString = UniformDownloader.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start download failed. POS:" + paramLong);
      paramString = UniformDownloader.a(6);
      a(6, paramString, paramString);
      return false;
    }
    a(jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start to run download . POS:" + paramLong);
    return true;
  }
  
  public void b()
  {
    a(jdField_c_of_type_Int);
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError..user puase");
      return;
    }
    String str = null;
    if (paramHttpMsg2 != null) {
      str = paramHttpMsg2.d();
    }
    Object localObject = str;
    if (str == null) {
      localObject = "null";
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. errString:" + (String)localObject);
    if (jdField_c_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. slience pause. may app destroy!!");
      c();
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      c();
      paramHttpMsg1 = UniformDownloader.a(2);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        StatisticAssist.a(paramHttpMsg2.getApplication().getApplicationContext(), paramHttpMsg2.a(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(2, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    long l = paramHttpMsg2.h;
    int i = paramHttpMsg2.a();
    str = paramHttpMsg2.d();
    if ((a(paramHttpMsg1, paramHttpMsg2)) && (this.jdField_f_of_type_Int < 3))
    {
      this.jdField_f_of_type_Int += 1;
      if ((this.g < 3) && (paramHttpMsg2.h == 9056))
      {
        this.g += 1;
        this.jdField_f_of_type_Int -= 1;
        label438:
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError. auto retry to download. autoRetry=" + this.jdField_f_of_type_Int + " eofRetry=" + this.g);
        d();
        if (a(a())) {
          break label778;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload failed.");
        str = UniformDownloader.a((int)13L);
        l = 13L;
      }
    }
    for (paramHttpMsg1 = str;; paramHttpMsg1 = String.valueOf(i))
    {
      this.jdField_f_of_type_Int = 0;
      this.g = 0;
      c();
      localObject = UniformDownloadMgr.a().a();
      if (localObject != null)
      {
        if (13L == l) {
          break label962;
        }
        l = 11L;
        str = UniformDownloader.a((int)11L);
        paramHttpMsg1 = str;
      }
      label778:
      label962:
      for (;;)
      {
        FileManagerUtil.a((QQAppInterface)localObject, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", l, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_f_of_type_Int, str, null);
        FileManagerUtil.a((QQAppInterface)localObject, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.h, String.valueOf(paramHttpMsg2.a()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_f_of_type_Int, paramHttpMsg2.d(), null);
        StatisticAssist.a(((QQAppInterface)localObject).getApplication().getApplicationContext(), ((QQAppInterface)localObject).a(), "Stop_download_2-0_3-1");
        for (;;)
        {
          paramHttpMsg1 = a();
          if (paramHttpMsg1 == null) {
            break;
          }
          paramHttpMsg1.a(6, "downloader fialed", null);
          return;
          this.g = 0;
          break label438;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload started.");
          paramHttpMsg1 = UniformDownloadMgr.a().a();
          if (paramHttpMsg1 != null)
          {
            FileManagerUtil.a(paramHttpMsg1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.h, String.valueOf(paramHttpMsg2.a()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_f_of_type_Int, paramHttpMsg2.d(), null);
            return;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 1");
          return;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloaderGenWorker
 * JD-Core Version:    0.7.0.1
 */