package com.tencent.qqprotect.sfcfg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import aszp;
import aszq;
import auqr;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.SecVerifyApk.ReportDetectResultPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import mqq.app.MobileQQ;

public class QPTxVerifyApkTimerTask
  extends TimerTask
{
  private static String aHY = "SecVAcfg";
  private static boolean aQw;
  private static String cAP = "00000000000000000000000000000000";
  private static String cAQ = "00000000000000000000000000000000";
  private static String cAR = "00000000000000000000000000000000";
  private static String cAS = "00000000000000000000000000000000";
  private static boolean dco;
  private static boolean dcp;
  private static int err;
  
  public QPTxVerifyApkTimerTask(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aQw = paramBoolean;
  }
  
  /* Error */
  private String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: aload_2
    //   5: invokevirtual 49	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: ldc 51
    //   13: invokestatic 57	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore 4
    //   18: aload_2
    //   19: astore_1
    //   20: sipush 8192
    //   23: newarray byte
    //   25: astore 6
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: aload 6
    //   32: invokevirtual 63	java/io/InputStream:read	([B)I
    //   35: istore_3
    //   36: iload_3
    //   37: iconst_m1
    //   38: if_icmpeq +42 -> 80
    //   41: aload_2
    //   42: astore_1
    //   43: aload 4
    //   45: aload 6
    //   47: iconst_0
    //   48: iload_3
    //   49: invokevirtual 67	java/security/MessageDigest:update	([BII)V
    //   52: goto -25 -> 27
    //   55: astore 4
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   64: aload 5
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull +10 -> 78
    //   71: aload_2
    //   72: invokevirtual 73	java/io/InputStream:close	()V
    //   75: aload 5
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: aload_2
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 77	java/security/MessageDigest:digest	()[B
    //   87: invokestatic 83	aszp:F	([B)Ljava/lang/String;
    //   90: astore 4
    //   92: aload 4
    //   94: astore_1
    //   95: aload_2
    //   96: ifnull -18 -> 78
    //   99: aload_2
    //   100: invokevirtual 73	java/io/InputStream:close	()V
    //   103: aload 4
    //   105: areturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   111: aload 4
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 73	java/io/InputStream:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_2
    //   143: goto -19 -> 124
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -93 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	QPTxVerifyApkTimerTask
    //   0	153	1	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	153	2	paramZipEntry	java.util.zip.ZipEntry
    //   35	14	3	i	int
    //   16	28	4	localMessageDigest	java.security.MessageDigest
    //   55	28	4	localException1	Exception
    //   90	22	4	str	String
    //   146	1	4	localException2	Exception
    //   1	75	5	localObject	Object
    //   25	21	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	18	55	java/lang/Exception
    //   20	27	55	java/lang/Exception
    //   29	36	55	java/lang/Exception
    //   43	52	55	java/lang/Exception
    //   82	92	55	java/lang/Exception
    //   99	103	106	java/lang/Exception
    //   71	75	114	java/lang/Exception
    //   3	9	121	finally
    //   128	132	134	java/lang/Exception
    //   11	18	142	finally
    //   20	27	142	finally
    //   29	36	142	finally
    //   43	52	142	finally
    //   59	64	142	finally
    //   82	92	142	finally
    //   3	9	146	java/lang/Exception
  }
  
  private boolean aGV()
  {
    try
    {
      long l1 = BaseApplication.getContext().getSharedPreferences(aHY, 0).getLong("SecHisStamp", 0L);
      long l2 = System.currentTimeMillis();
      return l2 > l1 + 86400000L;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private void bmw()
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(aHY, 0).edit();
      localEditor.putLong("SecHisStamp", System.currentTimeMillis());
      localEditor.putString("SecHisSit", cAS);
      localEditor.putString("SecHisTxs", cAR);
      localEditor.putString("SecHisRa", cAQ);
      localEditor.putString("SecHisAk", cAP);
      localEditor.putString("SecVer", "3.4.4.3058");
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void doReport()
  {
    for (;;)
    {
      SecVerifyApk.ReportDetectResultPacket localReportDetectResultPacket;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        localReportDetectResultPacket = new SecVerifyApk.ReportDetectResultPacket();
        if (aQw)
        {
          localReportDetectResultPacket.uint32_cmd.set(2);
          localReportDetectResultPacket.uint32_result.set(err);
          localReportDetectResultPacket.uint32_appid.set(AppSetting.getAppId());
          Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
          if (localObject1 == null) {
            break;
          }
          if (!dcp)
          {
            Object localObject3 = BaseApplication.getContext().getSharedPreferences(aHY, 0);
            localObject2 = ((SharedPreferences)localObject3).getString("SecHisSit", null);
            String str1 = ((SharedPreferences)localObject3).getString("SecHisTxs", null);
            String str2 = ((SharedPreferences)localObject3).getString("SecHisRa", null);
            String str3 = ((SharedPreferences)localObject3).getString("SecHisAk", null);
            localObject3 = ((SharedPreferences)localObject3).getString("SecVer", null);
            String str4 = qs((String)localObject1);
            if (str4 != null) {
              cAQ = str4;
            }
            if ((str2 == null) || (!str2.equalsIgnoreCase(cAQ)) || (localObject3 == null) || (!((String)localObject3).equalsIgnoreCase("3.4.4.3058"))) {
              break label455;
            }
            if (localObject2 != null) {
              cAS = (String)localObject2;
            }
            if (str3 != null) {
              cAP = str3;
            }
            if (str1 != null) {
              cAR = str1;
            }
          }
          localReportDetectResultPacket.str_signature.set(cAS);
          localReportDetectResultPacket.str_apkmd5.set(cAP);
          localReportDetectResultPacket.str_rsamd5.set(cAQ);
          localReportDetectResultPacket.str_txsfcfgkmd5.set(cAR);
          localReportDetectResultPacket.str_apkversion.set("3.4.4.3058");
          localReportDetectResultPacket.str_channelid.set(AppSetting.getChannelId());
          localReportDetectResultPacket.str_uin.set(localQQAppInterface.getCurrentAccountUin());
          localReportDetectResultPacket.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
          localReportDetectResultPacket.str_sysversion.set(Build.VERSION.RELEASE);
          localReportDetectResultPacket.str_brand.set(Build.BRAND);
          localReportDetectResultPacket.str_model.set(Build.MODEL);
          localObject2 = localQQAppInterface.getApplication().getPackageName();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "com.tencent.tim";
          }
          localReportDetectResultPacket.package_name.set((String)localObject1);
          localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), "SecurityApk.VA");
          if (localObject1 == null) {
            break;
          }
          ((ToServiceMsg)localObject1).putWupBuffer(localReportDetectResultPacket.toByteArray());
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          ((ToServiceMsg)localObject1).setNeedCallback(false);
          localQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      localReportDetectResultPacket.uint32_cmd.set(1);
      continue;
      label455:
      cAS = auqr.bJ(BaseApplication.getContext());
      cAP = auqr.getFileMd5(localException);
      Object localObject2 = new byte[16];
      if (localObject2 != null)
      {
        aszp.a(localException, "txsfcfg.dat", (byte[])localObject2);
        cAR = auqr.I((byte[])localObject2);
      }
      dcp = true;
    }
  }
  
  /* Error */
  private String qs(String paramString)
  {
    // Byte code:
    //   0: new 45	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 359	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 363	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_3
    //   16: aload_2
    //   17: astore_1
    //   18: aload_3
    //   19: invokeinterface 368 1 0
    //   24: ifeq +115 -> 139
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 372 1 0
    //   35: checkcast 374	java/util/zip/ZipEntry
    //   38: astore 4
    //   40: aload_2
    //   41: astore_1
    //   42: aload 4
    //   44: invokevirtual 377	java/util/zip/ZipEntry:isDirectory	()Z
    //   47: ifne -31 -> 16
    //   50: aload_2
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 380	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload_2
    //   60: astore_1
    //   61: aload 5
    //   63: ldc_w 382
    //   66: invokevirtual 385	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifne -53 -> 16
    //   72: aload_2
    //   73: astore_1
    //   74: aload 5
    //   76: ldc_w 387
    //   79: invokevirtual 390	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   82: ifeq -66 -> 16
    //   85: aload_2
    //   86: astore_1
    //   87: aload 5
    //   89: ldc_w 392
    //   92: invokevirtual 395	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   95: ifeq -79 -> 16
    //   98: aload_2
    //   99: astore_1
    //   100: aload 5
    //   102: bipush 47
    //   104: invokevirtual 399	java/lang/String:lastIndexOf	(I)I
    //   107: bipush 8
    //   109: if_icmpne -93 -> 16
    //   112: aload_2
    //   113: astore_1
    //   114: aload_0
    //   115: aload_2
    //   116: aload 4
    //   118: invokespecial 401	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   121: astore_3
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 402	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   130: aload_3
    //   131: areturn
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   137: aload_3
    //   138: areturn
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 402	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   154: goto -7 -> 147
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   166: aload_2
    //   167: ifnull -20 -> 147
    //   170: aload_2
    //   171: invokevirtual 402	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   174: goto -27 -> 147
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   182: goto -35 -> 147
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: astore_1
    //   190: aload_3
    //   191: invokevirtual 404	java/lang/OutOfMemoryError:printStackTrace	()V
    //   194: aload_2
    //   195: ifnull -48 -> 147
    //   198: aload_2
    //   199: invokevirtual 402	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   202: goto -55 -> 147
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   210: goto -63 -> 147
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 402	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   224: aload_2
    //   225: athrow
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_2
    //   235: goto -19 -> 216
    //   238: astore_3
    //   239: goto -51 -> 188
    //   242: astore_3
    //   243: goto -83 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	QPTxVerifyApkTimerTask
    //   0	246	1	paramString	String
    //   8	191	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   213	12	2	localObject1	Object
    //   234	1	2	localObject2	Object
    //   15	123	3	localObject3	Object
    //   157	6	3	localException1	Exception
    //   185	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   238	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   242	1	3	localException2	Exception
    //   38	79	4	localZipEntry	java.util.zip.ZipEntry
    //   57	44	5	str	String
    // Exception table:
    //   from	to	target	type
    //   126	130	132	java/io/IOException
    //   143	147	149	java/io/IOException
    //   0	9	157	java/lang/Exception
    //   170	174	177	java/io/IOException
    //   0	9	185	java/lang/OutOfMemoryError
    //   198	202	205	java/io/IOException
    //   0	9	213	finally
    //   220	224	226	java/io/IOException
    //   11	16	234	finally
    //   18	27	234	finally
    //   29	40	234	finally
    //   42	50	234	finally
    //   52	59	234	finally
    //   61	72	234	finally
    //   74	85	234	finally
    //   87	98	234	finally
    //   100	112	234	finally
    //   114	122	234	finally
    //   162	166	234	finally
    //   190	194	234	finally
    //   11	16	238	java/lang/OutOfMemoryError
    //   18	27	238	java/lang/OutOfMemoryError
    //   29	40	238	java/lang/OutOfMemoryError
    //   42	50	238	java/lang/OutOfMemoryError
    //   52	59	238	java/lang/OutOfMemoryError
    //   61	72	238	java/lang/OutOfMemoryError
    //   74	85	238	java/lang/OutOfMemoryError
    //   87	98	238	java/lang/OutOfMemoryError
    //   100	112	238	java/lang/OutOfMemoryError
    //   114	122	238	java/lang/OutOfMemoryError
    //   11	16	242	java/lang/Exception
    //   18	27	242	java/lang/Exception
    //   29	40	242	java/lang/Exception
    //   42	50	242	java/lang/Exception
    //   52	59	242	java/lang/Exception
    //   61	72	242	java/lang/Exception
    //   74	85	242	java/lang/Exception
    //   87	98	242	java/lang/Exception
    //   100	112	242	java/lang/Exception
    //   114	122	242	java/lang/Exception
  }
  
  public void ekC()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SEC_VA", 2, "start");
      }
      if ((!aQw) && (!aGV())) {
        return;
      }
      if (!dco)
      {
        Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null)
        {
          localObject = ((QQAppInterface)localObject).getApplication().getApplicationInfo().sourceDir;
          if (localObject != null)
          {
            err = aszq.ag((String)localObject, "txsfcfg.dat");
            if ((err != 0) && (err != 143)) {
              err = aszq.ag((String)localObject, "txsfcfg.dat");
            }
            dco = true;
          }
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        doReport();
        long l3 = System.currentTimeMillis();
        bmw();
        long l4 = System.currentTimeMillis();
        QLog.d("SEC_VA", 1, "cost(" + (l2 - l1) + ":" + (l3 - l2) + ":" + (l4 - l3) + ")");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void run()
  {
    ThreadManager.post(new QPTxVerifyApkTimerTask.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask
 * JD-Core Version:    0.7.0.1
 */