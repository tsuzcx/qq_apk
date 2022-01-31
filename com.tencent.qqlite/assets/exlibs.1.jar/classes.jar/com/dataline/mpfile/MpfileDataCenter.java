package com.dataline.mpfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.util.HttpDownload;
import com.dataline.util.HttpDownload.HttpDownloadListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import db;
import dc;
import dd;
import de;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import mqq.app.MobileQQ;

public class MpfileDataCenter
  implements HttpDownload.HttpDownloadListener
{
  public static int A = 0;
  public static final int B = 3;
  public static final int C = 2;
  public static final int D = 1;
  public static int E = 0;
  public static final int F = 0;
  public static final int a = 0;
  public static String a;
  public static final int b = 1;
  public static final String b = "com.dataline.mpfile.download_progress";
  public static final int c = 2;
  public static final String c = "com.dataline.mpfile.download_completed";
  public static final int d = 3;
  public static final String d = "token_task_id";
  public static final int e = 4;
  public static final String e = "token_file_id";
  public static final int f = 5;
  public static final String f = "token_current_size";
  public static final int g = 6;
  public static final String g = "token_total_size";
  public static final int h = 7;
  public static final String h = "token_is_success";
  public static final int i = 8;
  public static final String i = "token_http_code";
  public static final int j = 255;
  public static final String j = "http://%s:%d/qqmpfile/?action=thumbnail&fileid=%s";
  public static final int k = 254;
  public static String k;
  public static final int l = 253;
  public static final int m = 252;
  public static final int n = 251;
  public static final int o = 250;
  public static final int p = 249;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static int v;
  public static int w;
  public static int x;
  public static int y;
  public static int z;
  public Context a;
  public HttpDownload a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public de a;
  private Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "mpfile";
    q = 1001;
    r = 1002;
    s = 1003;
    t = 1004;
    u = 1005;
    v = 1006;
    w = 1007;
    x = 1008;
    y = 1009;
    z = 1010;
    A = 1011;
    k = "";
  }
  
  public MpfileDataCenter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComDatalineUtilHttpDownload = new HttpDownload(true);
    this.jdField_a_of_type_De = new de(this, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  public static String a()
  {
    File localFile = new File(AppConstants.ay);
    if (!FileUtils.a(AppConstants.ay)) {
      localFile.mkdirs();
    }
    return AppConstants.ay;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  public static String b()
  {
    File localFile = new File(AppConstants.aA);
    if (!FileUtils.a(AppConstants.aA)) {
      localFile.mkdirs();
    }
    return AppConstants.aA;
  }
  
  private void b(long paramLong)
  {
    dd localdd = new dd(this, null);
    localdd.a(paramLong);
    if (this.jdField_a_of_type_JavaUtilTimer == null) {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
    }
    this.jdField_a_of_type_JavaUtilTimer.schedule(localdd, 5000L, 5000L);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  private void e(String paramString)
  {
    ThreadManager.a(new db(this, paramString));
  }
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("http://%s:%d/qqmpfile/?action=download&fileid=%s", new Object[] { k, Integer.valueOf(E), paramString1 });
    MpfileTaskInfo localMpfileTaskInfo = a(paramString1);
    if (localMpfileTaskInfo == null)
    {
      localMpfileTaskInfo = new MpfileTaskInfo();
      localMpfileTaskInfo.jdField_d_of_type_Long = a().longValue();
      localMpfileTaskInfo.jdField_c_of_type_JavaLangString = paramString1;
      localMpfileTaskInfo.jdField_b_of_type_JavaLangString = str;
      localMpfileTaskInfo.jdField_d_of_type_JavaLangString = paramString2;
      localMpfileTaskInfo.jdField_e_of_type_JavaLangString = String.format("%s/%s", new Object[] { a(), paramString2 });
      localMpfileTaskInfo.jdField_f_of_type_JavaLangString = "";
      localMpfileTaskInfo.jdField_b_of_type_Long = paramLong;
      localMpfileTaskInfo.jdField_c_of_type_Long = 0L;
      localMpfileTaskInfo.jdField_a_of_type_JavaLangString = MD5Utils.b(localMpfileTaskInfo.jdField_e_of_type_JavaLangString);
      localMpfileTaskInfo.g = MpfileTaskInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_De.a(localMpfileTaskInfo);
      paramLong = localMpfileTaskInfo.jdField_d_of_type_Long;
    }
    for (;;)
    {
      e(paramString1);
      return paramLong;
      paramLong = localMpfileTaskInfo.jdField_d_of_type_Long;
      localMpfileTaskInfo.g = MpfileTaskInfo.jdField_a_of_type_Int;
      localMpfileTaskInfo.jdField_b_of_type_JavaLangString = str;
    }
  }
  
  public long a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    Object localObject2 = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    int i1 = ((RegisterProxySvcPackHandler)localObject2).a();
    int i2 = ((RegisterProxySvcPackHandler)localObject2).c();
    if ((i1 == 0) || (i2 == 0))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt(MpFileConstant.jdField_e_of_type_JavaLangString, s);
      localObject2 = new Intent();
      ((Intent)localObject2).setAction(MpFileConstant.jdField_d_of_type_JavaLangString);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject2);
      return 0L;
    }
    long l1 = a().longValue();
    if (paramBoolean) {
      ((DataLineHandler)localObject1).a(1L, l1, 1007, 1);
    }
    for (;;)
    {
      b(l1);
      return l1;
      ((DataLineHandler)localObject1).a(1L, l1, 1007, 0);
    }
  }
  
  public MpfileTaskInfo a(long paramLong)
  {
    return this.jdField_a_of_type_De.a(paramLong);
  }
  
  public MpfileTaskInfo a(MpfileTaskRecord paramMpfileTaskRecord)
  {
    MpfileTaskInfo localMpfileTaskInfo = new MpfileTaskInfo();
    localMpfileTaskInfo.jdField_c_of_type_JavaLangString = paramMpfileTaskRecord.fileId;
    localMpfileTaskInfo.jdField_d_of_type_Long = paramMpfileTaskRecord.sessionId;
    localMpfileTaskInfo.jdField_d_of_type_JavaLangString = paramMpfileTaskRecord.fileName;
    localMpfileTaskInfo.jdField_e_of_type_JavaLangString = paramMpfileTaskRecord.filePath;
    localMpfileTaskInfo.jdField_f_of_type_JavaLangString = paramMpfileTaskRecord.fileTempPath;
    localMpfileTaskInfo.jdField_b_of_type_Long = paramMpfileTaskRecord.totalSize;
    localMpfileTaskInfo.jdField_c_of_type_Long = paramMpfileTaskRecord.currentSize;
    localMpfileTaskInfo.h = paramMpfileTaskRecord.fileTempPath;
    localMpfileTaskInfo.jdField_a_of_type_JavaLangString = MD5Utils.b(paramMpfileTaskRecord.filePath);
    localMpfileTaskInfo.jdField_e_of_type_Long = paramMpfileTaskRecord.time;
    localMpfileTaskInfo.g = MpfileTaskInfo.jdField_a_of_type_Int;
    if (a(localMpfileTaskInfo)) {
      localMpfileTaskInfo.g = MpfileTaskInfo.jdField_c_of_type_Int;
    }
    while (!b(localMpfileTaskInfo)) {
      return localMpfileTaskInfo;
    }
    localMpfileTaskInfo.g = MpfileTaskInfo.jdField_d_of_type_Int;
    return localMpfileTaskInfo;
  }
  
  public MpfileTaskInfo a(String paramString)
  {
    paramString = this.jdField_a_of_type_De.a(paramString);
    if (paramString != null)
    {
      if (!a(paramString)) {
        break label30;
      }
      paramString.g = MpfileTaskInfo.jdField_c_of_type_Int;
    }
    label30:
    while ((a(paramString)) || (paramString.g != MpfileTaskInfo.jdField_c_of_type_Int)) {
      return paramString;
    }
    paramString.g = MpfileTaskInfo.jdField_a_of_type_Int;
    return paramString;
  }
  
  public Long a()
  {
    if (this.jdField_a_of_type_JavaLangLong.longValue() == 0L) {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
    }
    Long localLong = Long.valueOf(this.jdField_a_of_type_JavaLangLong.longValue() + 1L);
    this.jdField_a_of_type_JavaLangLong = localLong;
    return localLong;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 378
    //   5: iconst_3
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: getstatic 113	com/dataline/mpfile/MpfileDataCenter:k	Ljava/lang/String;
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: getstatic 115	com/dataline/mpfile/MpfileDataCenter:E	I
    //   20: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: aload_1
    //   27: aastore
    //   28: invokestatic 226	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   31: astore_1
    //   32: new 380	java/net/URL
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 381	java/net/URL:<init>	(Ljava/lang/String;)V
    //   40: invokevirtual 385	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   43: checkcast 387	java/net/HttpURLConnection
    //   46: astore_1
    //   47: new 389	java/io/InputStreamReader
    //   50: dup
    //   51: aload_1
    //   52: invokevirtual 393	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   55: invokespecial 396	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   58: astore_3
    //   59: new 398	java/io/BufferedReader
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 401	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore_2
    //   68: new 403	java/lang/StringBuffer
    //   71: dup
    //   72: invokespecial 404	java/lang/StringBuffer:<init>	()V
    //   75: astore 4
    //   77: aload_2
    //   78: invokevirtual 407	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnull +45 -> 130
    //   88: aload 4
    //   90: aload 5
    //   92: invokevirtual 411	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   95: pop
    //   96: goto -19 -> 77
    //   99: astore 4
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: aload 4
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 417	java/net/HttpURLConnection:disconnect	()V
    //   120: aload_1
    //   121: ifnull +124 -> 245
    //   124: aload_1
    //   125: invokevirtual 420	java/io/InputStreamReader:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: aload 4
    //   132: invokevirtual 423	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 417	java/net/HttpURLConnection:disconnect	()V
    //   144: aload_3
    //   145: ifnull +102 -> 247
    //   148: aload_3
    //   149: invokevirtual 420	java/io/InputStreamReader:close	()V
    //   152: aload_2
    //   153: areturn
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   159: aload_2
    //   160: areturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   166: aconst_null
    //   167: areturn
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 417	java/net/HttpURLConnection:disconnect	()V
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 420	java/io/InputStreamReader:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 424	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload 4
    //   205: astore_1
    //   206: goto -35 -> 171
    //   209: astore 4
    //   211: aload_1
    //   212: astore_2
    //   213: aload 4
    //   215: astore_1
    //   216: goto -45 -> 171
    //   219: astore 4
    //   221: aload_1
    //   222: astore_3
    //   223: aload 4
    //   225: astore_1
    //   226: goto -55 -> 171
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: goto -126 -> 108
    //   237: astore_3
    //   238: aload_1
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_1
    //   242: goto -134 -> 108
    //   245: aconst_null
    //   246: areturn
    //   247: aload_2
    //   248: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	MpfileDataCenter
    //   0	249	1	paramString	String
    //   1	175	2	localObject1	Object
    //   189	2	2	localIOException	java.io.IOException
    //   202	46	2	str1	String
    //   58	165	3	localObject2	Object
    //   229	1	3	localException1	java.lang.Exception
    //   237	1	3	localException2	java.lang.Exception
    //   75	14	4	localStringBuffer	java.lang.StringBuffer
    //   99	32	4	localException3	java.lang.Exception
    //   197	7	4	localObject3	Object
    //   209	5	4	localObject4	Object
    //   219	5	4	localObject5	Object
    //   81	10	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   59	77	99	java/lang/Exception
    //   77	83	99	java/lang/Exception
    //   88	96	99	java/lang/Exception
    //   130	136	99	java/lang/Exception
    //   148	152	154	java/io/IOException
    //   124	128	161	java/io/IOException
    //   32	47	168	finally
    //   183	187	189	java/io/IOException
    //   47	59	197	finally
    //   59	77	209	finally
    //   77	83	209	finally
    //   88	96	209	finally
    //   130	136	209	finally
    //   108	112	219	finally
    //   32	47	229	java/lang/Exception
    //   47	59	237	java/lang/Exception
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_De.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComDatalineUtilHttpDownload != null) {
      this.jdField_a_of_type_ComDatalineUtilHttpDownload.a();
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(long paramLong)
  {
    MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong);
    if (localMpfileTaskInfo != null) {
      localMpfileTaskInfo.g = 1;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong1);
    if (localMpfileTaskInfo != null) {
      localMpfileTaskInfo.jdField_a_of_type_Long = paramLong2;
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong1);
    if (localMpfileTaskInfo != null)
    {
      localMpfileTaskInfo.jdField_b_of_type_Long = paramLong3;
      localMpfileTaskInfo.jdField_c_of_type_Long = paramLong2;
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      Intent localIntent = new Intent("com.dataline.mpfile.download_completed");
      localIntent.putExtra("token_task_id", paramLong1);
      localIntent.putExtra("token_current_size", paramLong2);
      localIntent.putExtra("token_is_success", paramBoolean);
      localIntent.putExtra("token_http_code", paramInt);
      MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong1);
      if (localMpfileTaskInfo != null) {
        localIntent.putExtra("token_file_id", localMpfileTaskInfo.jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    a(paramLong1);
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    a(String.format("download onDoneD %s, nRetCode is %d, nStatusCode is %d", new Object[] { String.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    b(paramLong1, paramLong2);
    paramString1 = this.jdField_a_of_type_De.a(paramLong1);
    if ((paramString1 != null) && (paramString1.jdField_f_of_type_JavaLangString != null))
    {
      if (!paramBoolean) {
        break label291;
      }
      paramString1.g = MpfileTaskInfo.jdField_c_of_type_Int;
      paramString2 = new File(paramString1.jdField_f_of_type_JavaLangString);
      if (!paramString2.exists()) {
        break label280;
      }
      paramString2.renameTo(new File(paramString1.jdField_e_of_type_JavaLangString));
      paramString1 = paramString1.jdField_e_of_type_JavaLangString;
      paramString2 = FileManagerUtil.a(paramString1);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1L, str, 6000);
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.fileSize = FileManagerUtil.a(paramString1);
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = str;
      localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364073);
      localFileManagerEntity.strFilePath = paramString1;
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.fileName = paramString2;
      localFileManagerEntity.cloudType = 3;
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    }
    for (;;)
    {
      a(paramLong1, paramLong2, paramBoolean, 0);
      return;
      label280:
      paramString1.g = MpfileTaskInfo.jdField_e_of_type_Int;
      continue;
      label291:
      paramString1.g = MpfileTaskInfo.jdField_d_of_type_Int;
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getExtras().getInt(MpFileConstant.jdField_e_of_type_JavaLangString) == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(MpfileTaskInfo paramMpfileTaskInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    MpfileTaskRecord localMpfileTaskRecord;
    do
    {
      return;
      localMpfileTaskRecord = new MpfileTaskRecord();
      localMpfileTaskRecord.fileId = paramMpfileTaskInfo.jdField_c_of_type_JavaLangString;
      localMpfileTaskRecord.fileName = paramMpfileTaskInfo.jdField_d_of_type_JavaLangString;
      localMpfileTaskRecord.filePath = paramMpfileTaskInfo.jdField_e_of_type_JavaLangString;
      localMpfileTaskRecord.fileTempPath = paramMpfileTaskInfo.jdField_f_of_type_JavaLangString;
      localMpfileTaskRecord.fileTime = paramMpfileTaskInfo.h;
      localMpfileTaskRecord.currentSize = paramMpfileTaskInfo.jdField_c_of_type_Long;
      localMpfileTaskRecord.totalSize = paramMpfileTaskInfo.jdField_b_of_type_Long;
      localMpfileTaskRecord.sessionId = paramMpfileTaskInfo.jdField_d_of_type_Long;
      localMpfileTaskRecord.time = paramMpfileTaskInfo.jdField_e_of_type_Long;
      paramMpfileTaskInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while (paramMpfileTaskInfo == null);
    paramMpfileTaskInfo.a(localMpfileTaskRecord);
  }
  
  public boolean a(MpfileTaskInfo paramMpfileTaskInfo)
  {
    if (paramMpfileTaskInfo.jdField_e_of_type_JavaLangString == null) {}
    while (!new File(paramMpfileTaskInfo.jdField_e_of_type_JavaLangString).exists()) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.b(new dc(this));
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong1);
    if (localMpfileTaskInfo != null) {
      localMpfileTaskInfo.jdField_c_of_type_Long = paramLong2;
    }
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong1);
    if (localMpfileTaskInfo != null)
    {
      localMpfileTaskInfo.g = MpfileTaskInfo.jdField_b_of_type_Int;
      if ((localMpfileTaskInfo.jdField_b_of_type_Long != 0L) && (paramLong3 != 0L))
      {
        a(paramLong1, paramLong2, paramLong3);
        long l1 = System.currentTimeMillis() - localMpfileTaskInfo.jdField_f_of_type_Long;
        if (l1 > 500L)
        {
          localMpfileTaskInfo.jdField_f_of_type_Long = l1;
          c(paramLong1, paramLong2, paramLong3);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null)
    {
      if ((((MpfileTaskInfo)localObject).jdField_e_of_type_JavaLangString != null) && (((MpfileTaskInfo)localObject).jdField_e_of_type_JavaLangString.length() > 0))
      {
        File localFile = new File(((MpfileTaskInfo)localObject).jdField_e_of_type_JavaLangString);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
      if ((((MpfileTaskInfo)localObject).jdField_f_of_type_JavaLangString != null) && (((MpfileTaskInfo)localObject).jdField_f_of_type_JavaLangString.length() > 0))
      {
        localObject = new File(((MpfileTaskInfo)localObject).jdField_f_of_type_JavaLangString);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      this.jdField_a_of_type_De.a(paramString);
    }
  }
  
  public boolean b(MpfileTaskInfo paramMpfileTaskInfo)
  {
    if (paramMpfileTaskInfo.jdField_f_of_type_JavaLangString == null) {}
    while (!new File(paramMpfileTaskInfo.jdField_f_of_type_JavaLangString).exists()) {
      return false;
    }
    return true;
  }
  
  public void c(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      Intent localIntent = new Intent("com.dataline.mpfile.download_progress");
      localIntent.putExtra("token_task_id", paramLong1);
      localIntent.putExtra("token_current_size", paramLong2);
      localIntent.putExtra("token_total_size", paramLong3);
      MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_De.a(paramLong1);
      if (localMpfileTaskInfo != null) {
        localIntent.putExtra("token_file_id", localMpfileTaskInfo.jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    }
  }
  
  public void c(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString.g = MpfileTaskInfo.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComDatalineUtilHttpDownload.a(paramString.jdField_c_of_type_JavaLangString, paramString.jdField_d_of_type_Long);
    }
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    MpfileTaskProxy localMpfileTaskProxy;
    do
    {
      return;
      localMpfileTaskProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while (localMpfileTaskProxy == null);
    localMpfileTaskProxy.a(MpfileTaskRecord.tableName(), "fileId=?", new String[] { paramString }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileDataCenter
 * JD-Core Version:    0.7.0.1
 */