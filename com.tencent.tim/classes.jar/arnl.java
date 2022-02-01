import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqp.app.bps.c;
import com.tencent.mqp.app.bps.d.1;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class arnl
{
  private static String TAG = arni.E(arni.gY);
  private static String aHW;
  private static String aHY;
  private static String cAP = "";
  private static String cAQ = "";
  private static String cAR = "";
  private static String cAS = "";
  private static String cAT;
  private static String cAU;
  private static String cAV;
  private static String cAW;
  private static String cAX;
  private static String cAY;
  private static String cAZ;
  private static String cmd;
  private static boolean dco;
  private static boolean dcp;
  private static int err;
  private static Handler handler = new Handler(ThreadManager.getFileThreadLooper());
  public static Runnable ib = new d.1();
  
  static
  {
    cAP = arni.E(arni.gN);
    cAQ = arni.E(arni.gN);
    cAR = arni.E(arni.gN);
    cAS = arni.E(arni.gN);
    cmd = "";
    cmd = arni.E(arni.gO);
    aHY = "";
    aHY = arni.E(arni.gP);
    cAT = "";
    cAT = arni.E(arni.gQ);
    cAU = "";
    cAU = arni.E(arni.gR);
    aHW = "";
    cAV = "";
    cAW = "";
    cAX = "";
    cAY = "";
    cAZ = "";
    aHW = arni.E(arni.gS);
    cAV = arni.E(arni.gT);
    cAW = arni.E(arni.gU);
    cAX = arni.E(arni.gV);
    cAY = arni.E(arni.gW);
    cAZ = arni.E(arni.gX);
    TAG = "";
  }
  
  /* Error */
  private static String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 137	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: getstatic 140	arni:gZ	[B
    //   14: invokestatic 51	arni:E	([B)Ljava/lang/String;
    //   17: invokestatic 146	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore_3
    //   21: aload_1
    //   22: astore_0
    //   23: sipush 8192
    //   26: newarray byte
    //   28: astore 5
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 152	java/io/InputStream:read	([B)I
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_m1
    //   41: if_icmpeq +39 -> 80
    //   44: aload_1
    //   45: astore_0
    //   46: aload_3
    //   47: aload 5
    //   49: iconst_0
    //   50: iload_2
    //   51: invokevirtual 156	java/security/MessageDigest:update	([BII)V
    //   54: goto -24 -> 30
    //   57: astore_3
    //   58: aload_1
    //   59: astore_0
    //   60: aload_3
    //   61: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   64: aload 4
    //   66: astore_0
    //   67: aload_1
    //   68: ifnull +10 -> 78
    //   71: aload_1
    //   72: invokevirtual 162	java/io/InputStream:close	()V
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: aload_1
    //   81: astore_0
    //   82: aload_3
    //   83: invokevirtual 166	java/security/MessageDigest:digest	()[B
    //   86: invokestatic 171	arnj:F	([B)Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_0
    //   92: aload_1
    //   93: ifnull -15 -> 78
    //   96: aload_1
    //   97: invokevirtual 162	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 162	java/io/InputStream:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   134: goto -7 -> 127
    //   137: astore_1
    //   138: goto -19 -> 119
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_1
    //   144: goto -86 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	147	1	paramZipEntry	java.util.zip.ZipEntry
    //   38	13	2	i	int
    //   20	27	3	localMessageDigest	java.security.MessageDigest
    //   57	26	3	localException1	Exception
    //   89	19	3	str	String
    //   141	1	3	localException2	Exception
    //   1	75	4	localObject	Object
    //   28	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	21	57	java/lang/Exception
    //   23	30	57	java/lang/Exception
    //   32	39	57	java/lang/Exception
    //   46	54	57	java/lang/Exception
    //   82	90	57	java/lang/Exception
    //   96	100	102	java/lang/Exception
    //   71	75	109	java/lang/Exception
    //   3	9	116	finally
    //   123	127	129	java/lang/Exception
    //   11	21	137	finally
    //   23	30	137	finally
    //   32	39	137	finally
    //   46	54	137	finally
    //   60	64	137	finally
    //   82	90	137	finally
    //   3	9	141	java/lang/Exception
  }
  
  private static boolean aGV()
  {
    try
    {
      long l1 = BaseApplication.getContext().getSharedPreferences(aHY, 0).getLong(aHW, 0L);
      long l2 = System.currentTimeMillis();
      return l2 - l1 >= 86400000L;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private static void bmw()
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(aHY, 0).edit();
      localEditor.putLong(aHW, System.currentTimeMillis());
      localEditor.putString(cAV, cAS);
      localEditor.putString(cAW, cAR);
      localEditor.putString(cAX, cAQ);
      localEditor.putString(cAY, cAP);
      localEditor.putString(cAZ, "3.4.4.3058");
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void doReport()
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        c localc = new c();
        localc.uint32_cmd.set(3);
        localc.uint32_result.set(err);
        localc.uint32_appid.set(AppSetting.getAppId());
        Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
        if (localObject1 == null) {
          break;
        }
        if (!dcp)
        {
          Object localObject3 = BaseApplication.getContext().getSharedPreferences(aHY, 0);
          localObject2 = ((SharedPreferences)localObject3).getString(cAV, null);
          String str1 = ((SharedPreferences)localObject3).getString(cAW, null);
          String str2 = ((SharedPreferences)localObject3).getString(cAX, null);
          String str3 = ((SharedPreferences)localObject3).getString(cAY, null);
          localObject3 = ((SharedPreferences)localObject3).getString(cAZ, null);
          String str4 = qs((String)localObject1);
          if (str4 != null) {
            cAQ = str4;
          }
          if ((str2 == null) || (!str2.equalsIgnoreCase(cAQ)) || (localObject3 == null) || (!((String)localObject3).equalsIgnoreCase("3.4.4.3058"))) {
            break label424;
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
        localc.str_signature.set(cAS);
        localc.str_apkmd5.set(cAP);
        localc.str_rsamd5.set(cAQ);
        localc.str_txsfcfgkmd5.set(cAR);
        localc.str_apkversion.set("3.4.4.3058");
        localc.str_channelid.set(AppSetting.getChannelId());
        localc.str_uin.set(localQQAppInterface.getCurrentAccountUin());
        localc.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        localc.str_sysversion.set(Build.VERSION.RELEASE);
        localc.str_brand.set(Build.BRAND);
        localc.str_model.set(Build.MODEL);
        localObject2 = localQQAppInterface.getApplication().getPackageName();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "com.tencent.mobileqq";
        }
        localc.package_name.set((String)localObject1);
        localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), cmd);
        if (localObject1 == null) {
          break;
        }
        ((ToServiceMsg)localObject1).putWupBuffer(localc.toByteArray());
        ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
        ((ToServiceMsg)localObject1).setNeedCallback(false);
        localQQAppInterface.sendToService((ToServiceMsg)localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label424:
      cAS = auqr.bJ(BaseApplication.getContext());
      cAP = auqr.getFileMd5(localException);
      Object localObject2 = new byte[16];
      if (localObject2 != null)
      {
        arnj.a(localException, cAT, (byte[])localObject2);
        cAR = auqr.I((byte[])localObject2);
      }
      dcp = true;
    }
  }
  
  public static void ekA()
  {
    handler.removeCallbacks(ib);
    handler.postDelayed(ib, 210000L);
  }
  
  public static void ekB()
  {
    if (aGV() == true) {
      ekC();
    }
    mn(86400000L);
  }
  
  private static void ekC()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "start");
      }
      if (!dco)
      {
        Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject == null) {
          return;
        }
        localObject = ((QQAppInterface)localObject).getApplication().getApplicationInfo().sourceDir;
        if (localObject != null)
        {
          err = arnk.ag((String)localObject, cAT);
          dco = true;
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        doReport();
        long l3 = System.currentTimeMillis();
        bmw();
        long l4 = System.currentTimeMillis();
        QLog.d(TAG, 1, "cost(" + (l2 - l1) + ":" + (l3 - l2) + ":" + (l4 - l3) + ")");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void mn(long paramLong)
  {
    handler.removeCallbacks(ib);
    handler.postDelayed(ib, paramLong);
  }
  
  /* Error */
  private static String qs(String paramString)
  {
    // Byte code:
    //   0: new 133	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 493	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 497	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_2
    //   16: aload_1
    //   17: astore_0
    //   18: aload_2
    //   19: invokeinterface 502 1 0
    //   24: ifeq +116 -> 140
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: invokeinterface 506 1 0
    //   35: checkcast 508	java/util/zip/ZipEntry
    //   38: astore_3
    //   39: aload_1
    //   40: astore_0
    //   41: aload_3
    //   42: invokevirtual 511	java/util/zip/ZipEntry:isDirectory	()Z
    //   45: ifne -29 -> 16
    //   48: aload_1
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 514	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   54: astore 4
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: ldc_w 516
    //   63: invokevirtual 519	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   66: ifne -50 -> 16
    //   69: aload_1
    //   70: astore_0
    //   71: aload 4
    //   73: getstatic 522	arni:ha	[B
    //   76: invokestatic 51	arni:E	([B)Ljava/lang/String;
    //   79: invokevirtual 525	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   82: ifeq -66 -> 16
    //   85: aload_1
    //   86: astore_0
    //   87: aload 4
    //   89: getstatic 528	arni:hb	[B
    //   92: invokestatic 51	arni:E	([B)Ljava/lang/String;
    //   95: invokevirtual 531	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   98: ifeq -82 -> 16
    //   101: aload_1
    //   102: astore_0
    //   103: aload 4
    //   105: bipush 47
    //   107: invokevirtual 535	java/lang/String:lastIndexOf	(I)I
    //   110: bipush 8
    //   112: if_icmpne -96 -> 16
    //   115: aload_1
    //   116: astore_0
    //   117: aload_1
    //   118: aload_3
    //   119: invokestatic 537	arnl:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   122: astore_2
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 538	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   131: aload_2
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   138: aload_2
    //   139: areturn
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 538	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   155: goto -7 -> 148
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   167: aload_1
    //   168: ifnull -20 -> 148
    //   171: aload_1
    //   172: invokevirtual 538	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   175: goto -27 -> 148
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   183: goto -35 -> 148
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: astore_0
    //   191: aload_2
    //   192: invokevirtual 540	java/lang/OutOfMemoryError:printStackTrace	()V
    //   195: aload_1
    //   196: ifnull -48 -> 148
    //   199: aload_1
    //   200: invokevirtual 538	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   203: goto -55 -> 148
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   211: goto -63 -> 148
    //   214: astore_1
    //   215: aconst_null
    //   216: astore_0
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 538	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   232: goto -7 -> 225
    //   235: astore_1
    //   236: goto -19 -> 217
    //   239: astore_2
    //   240: goto -51 -> 189
    //   243: astore_2
    //   244: goto -83 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramString	String
    //   8	192	1	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   214	12	1	localObject1	Object
    //   235	1	1	localObject2	Object
    //   15	124	2	localObject3	Object
    //   158	6	2	localException1	Exception
    //   186	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   239	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   243	1	2	localException2	Exception
    //   38	81	3	localZipEntry	java.util.zip.ZipEntry
    //   54	50	4	str	String
    // Exception table:
    //   from	to	target	type
    //   127	131	133	java/io/IOException
    //   144	148	150	java/io/IOException
    //   0	9	158	java/lang/Exception
    //   171	175	178	java/io/IOException
    //   0	9	186	java/lang/OutOfMemoryError
    //   199	203	206	java/io/IOException
    //   0	9	214	finally
    //   221	225	227	java/io/IOException
    //   11	16	235	finally
    //   18	27	235	finally
    //   29	39	235	finally
    //   41	48	235	finally
    //   50	56	235	finally
    //   58	69	235	finally
    //   71	85	235	finally
    //   87	101	235	finally
    //   103	115	235	finally
    //   117	123	235	finally
    //   163	167	235	finally
    //   191	195	235	finally
    //   11	16	239	java/lang/OutOfMemoryError
    //   18	27	239	java/lang/OutOfMemoryError
    //   29	39	239	java/lang/OutOfMemoryError
    //   41	48	239	java/lang/OutOfMemoryError
    //   50	56	239	java/lang/OutOfMemoryError
    //   58	69	239	java/lang/OutOfMemoryError
    //   71	85	239	java/lang/OutOfMemoryError
    //   87	101	239	java/lang/OutOfMemoryError
    //   103	115	239	java/lang/OutOfMemoryError
    //   117	123	239	java/lang/OutOfMemoryError
    //   11	16	243	java/lang/Exception
    //   18	27	243	java/lang/Exception
    //   29	39	243	java/lang/Exception
    //   41	48	243	java/lang/Exception
    //   50	56	243	java/lang/Exception
    //   58	69	243	java/lang/Exception
    //   71	85	243	java/lang/Exception
    //   87	101	243	java/lang/Exception
    //   103	115	243	java/lang/Exception
    //   117	123	243	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnl
 * JD-Core Version:    0.7.0.1
 */