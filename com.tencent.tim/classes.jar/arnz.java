import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.ims.safecheckPB.ReportItem;
import com.tencent.ims.safecheckPB.ReqMQScanRequest;
import com.tencent.ims.safecheckPB.RspMQScanReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mqpsdk.secsrv.MQPAPPScanService.1;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class arnz
{
  private static boolean bIP;
  public static int cxT;
  private arnx a;
  
  public arnz(arnx paramarnx)
  {
    this.a = paramarnx;
  }
  
  /* Error */
  private void bH(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 27	arnz:bIP	Z
    //   8: ifne -4 -> 4
    //   11: iconst_1
    //   12: putstatic 27	arnz:bIP	Z
    //   15: new 29	com/tencent/ims/safecheckPB$ReqMQScanRequest
    //   18: dup
    //   19: invokespecial 30	com/tencent/ims/safecheckPB$ReqMQScanRequest:<init>	()V
    //   22: astore 4
    //   24: new 32	com/tencent/ims/safecheckPB$RspMQScanReport
    //   27: dup
    //   28: invokespecial 33	com/tencent/ims/safecheckPB$RspMQScanReport:<init>	()V
    //   31: astore 5
    //   33: aload 4
    //   35: aload_1
    //   36: invokevirtual 37	com/tencent/ims/safecheckPB$ReqMQScanRequest:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   39: pop
    //   40: aload 4
    //   42: getfield 41	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_condition	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   45: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   48: ifeq +539 -> 587
    //   51: aload 4
    //   53: getfield 41	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_condition	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   59: istore_2
    //   60: aload_0
    //   61: iload_2
    //   62: invokevirtual 55	arnz:iy	(I)Z
    //   65: ifne +59 -> 124
    //   68: aload_0
    //   69: monitorenter
    //   70: getstatic 57	arnz:cxT	I
    //   73: iconst_1
    //   74: isub
    //   75: putstatic 57	arnz:cxT	I
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: putstatic 27	arnz:bIP	Z
    //   84: return
    //   85: astore_1
    //   86: iconst_0
    //   87: putstatic 27	arnz:bIP	Z
    //   90: aload_1
    //   91: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   94: aload_0
    //   95: iload_2
    //   96: invokevirtual 55	arnz:iy	(I)Z
    //   99: ifne +184 -> 283
    //   102: aload_0
    //   103: monitorenter
    //   104: getstatic 57	arnz:cxT	I
    //   107: iconst_1
    //   108: isub
    //   109: putstatic 57	arnz:cxT	I
    //   112: aload_0
    //   113: monitorexit
    //   114: iconst_0
    //   115: putstatic 27	arnz:bIP	Z
    //   118: return
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: aload 4
    //   126: getfield 63	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   132: ifeq +450 -> 582
    //   135: aload 4
    //   137: getfield 63	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   140: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   143: istore_3
    //   144: aload 5
    //   146: getfield 66	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   149: aload 4
    //   151: getfield 67	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   154: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   157: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   160: aload 5
    //   162: getfield 74	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   165: iconst_0
    //   166: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   169: iload_3
    //   170: tableswitch	default:+422 -> 592, 1001:+42->212, 1002:+53->223, 1003:+422->592, 1004:+75->245, 1005:+86->256, 1006:+97->267, 1007:+64->234
    //   213: aload 4
    //   215: aload 5
    //   217: invokevirtual 77	arnz:a	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   220: goto -126 -> 94
    //   223: aload_0
    //   224: aload 4
    //   226: aload 5
    //   228: invokevirtual 80	arnz:b	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   231: goto -137 -> 94
    //   234: aload_0
    //   235: aload 4
    //   237: aload 5
    //   239: invokevirtual 83	arnz:c	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   242: goto -148 -> 94
    //   245: aload_0
    //   246: aload 4
    //   248: aload 5
    //   250: invokevirtual 86	arnz:e	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   253: goto -159 -> 94
    //   256: aload_0
    //   257: aload 4
    //   259: aload 5
    //   261: invokevirtual 89	arnz:f	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   264: goto -170 -> 94
    //   267: aload_0
    //   268: aload 4
    //   270: aload 5
    //   272: invokevirtual 92	arnz:d	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   275: goto -181 -> 94
    //   278: astore_1
    //   279: aload_0
    //   280: monitorexit
    //   281: aload_1
    //   282: athrow
    //   283: iconst_0
    //   284: istore_2
    //   285: new 32	com/tencent/ims/safecheckPB$RspMQScanReport
    //   288: dup
    //   289: invokespecial 33	com/tencent/ims/safecheckPB$RspMQScanReport:<init>	()V
    //   292: astore_1
    //   293: aload 5
    //   295: getfield 74	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   298: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   301: bipush 48
    //   303: if_icmple +197 -> 500
    //   306: aload_1
    //   307: getfield 74	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   310: bipush 48
    //   312: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   315: aload_1
    //   316: getfield 66	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   319: aload 5
    //   321: getfield 66	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   324: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   327: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   330: new 94	java/util/ArrayList
    //   333: dup
    //   334: invokespecial 95	java/util/ArrayList:<init>	()V
    //   337: astore 4
    //   339: iconst_0
    //   340: istore_3
    //   341: iload_3
    //   342: bipush 48
    //   344: if_icmpge +36 -> 380
    //   347: aload 4
    //   349: aload 5
    //   351: getfield 99	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   354: iconst_0
    //   355: invokevirtual 104	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   358: invokeinterface 110 2 0
    //   363: pop
    //   364: aload 5
    //   366: getfield 99	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   369: iconst_0
    //   370: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatMessageField:remove	(I)V
    //   373: iload_3
    //   374: iconst_1
    //   375: iadd
    //   376: istore_3
    //   377: goto -36 -> 341
    //   380: aload_1
    //   381: getfield 99	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   384: aload 4
    //   386: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   389: aload 5
    //   391: getfield 74	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   394: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   397: istore_3
    //   398: aload 5
    //   400: getfield 74	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: iload_3
    //   404: bipush 48
    //   406: isub
    //   407: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   410: aload_0
    //   411: getfield 17	arnz:a	Larnx;
    //   414: ifnull -410 -> 4
    //   417: aload_0
    //   418: getfield 17	arnz:a	Larnx;
    //   421: getfield 121	arnx:a	Larnw;
    //   424: astore 6
    //   426: aload 6
    //   428: ifnull -424 -> 4
    //   431: aload_1
    //   432: invokevirtual 125	com/tencent/ims/safecheckPB$RspMQScanReport:toByteArray	()[B
    //   435: astore 4
    //   437: aload 6
    //   439: ldc 127
    //   441: invokeinterface 133 2 0
    //   446: astore 7
    //   448: aload 4
    //   450: astore_1
    //   451: aload 7
    //   453: ifnull +13 -> 466
    //   456: aload 7
    //   458: aload 4
    //   460: invokeinterface 139 2 0
    //   465: astore_1
    //   466: aload 6
    //   468: aload_1
    //   469: invokeinterface 143 2 0
    //   474: pop
    //   475: iload_2
    //   476: istore_3
    //   477: iload_3
    //   478: istore_2
    //   479: iload_3
    //   480: ifeq -195 -> 285
    //   483: aload_0
    //   484: monitorenter
    //   485: getstatic 57	arnz:cxT	I
    //   488: iconst_1
    //   489: isub
    //   490: putstatic 57	arnz:cxT	I
    //   493: aload_0
    //   494: monitorexit
    //   495: iconst_0
    //   496: putstatic 27	arnz:bIP	Z
    //   499: return
    //   500: aload_0
    //   501: getfield 17	arnz:a	Larnx;
    //   504: ifnull -500 -> 4
    //   507: aload_0
    //   508: getfield 17	arnz:a	Larnx;
    //   511: getfield 121	arnx:a	Larnw;
    //   514: astore 6
    //   516: aload 6
    //   518: ifnull -514 -> 4
    //   521: aload 5
    //   523: invokevirtual 125	com/tencent/ims/safecheckPB$RspMQScanReport:toByteArray	()[B
    //   526: astore 4
    //   528: aload 6
    //   530: ldc 127
    //   532: invokeinterface 133 2 0
    //   537: astore 7
    //   539: aload 4
    //   541: astore_1
    //   542: aload 7
    //   544: ifnull +13 -> 557
    //   547: aload 7
    //   549: aload 4
    //   551: invokeinterface 139 2 0
    //   556: astore_1
    //   557: aload 6
    //   559: aload_1
    //   560: invokeinterface 143 2 0
    //   565: pop
    //   566: iconst_1
    //   567: istore_3
    //   568: goto -91 -> 477
    //   571: astore_1
    //   572: aload_0
    //   573: monitorexit
    //   574: aload_1
    //   575: athrow
    //   576: astore_1
    //   577: iconst_0
    //   578: istore_2
    //   579: goto -493 -> 86
    //   582: iconst_0
    //   583: istore_3
    //   584: goto -440 -> 144
    //   587: iconst_0
    //   588: istore_2
    //   589: goto -529 -> 60
    //   592: goto -498 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	arnz
    //   0	595	1	paramArrayOfByte	byte[]
    //   59	530	2	i	int
    //   143	441	3	j	int
    //   22	528	4	localObject	Object
    //   31	491	5	localRspMQScanReport	safecheckPB.RspMQScanReport
    //   424	134	6	localarnw	arnw
    //   446	102	7	locala	arnw.a
    // Exception table:
    //   from	to	target	type
    //   60	70	85	java/lang/Exception
    //   80	84	85	java/lang/Exception
    //   122	124	85	java/lang/Exception
    //   124	144	85	java/lang/Exception
    //   144	169	85	java/lang/Exception
    //   212	220	85	java/lang/Exception
    //   223	231	85	java/lang/Exception
    //   234	242	85	java/lang/Exception
    //   245	253	85	java/lang/Exception
    //   256	264	85	java/lang/Exception
    //   267	275	85	java/lang/Exception
    //   70	80	119	finally
    //   120	122	119	finally
    //   104	114	278	finally
    //   279	281	278	finally
    //   485	495	571	finally
    //   572	574	571	finally
    //   33	60	576	java/lang/Exception
  }
  
  public void a(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject1 = null;
    if (this.a != null) {
      localObject1 = this.a.mContext;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Object localObject2 = ((Context)localObject1).getPackageManager();
      try
      {
        localObject2 = ((PackageManager)localObject2).getPackageInfo(((Context)localObject1).getPackageName(), 1);
        localObject1 = SecUtil.getSign((Context)localObject1);
        new String();
        localObject1 = SecUtil.getSignatureHash((byte[])localObject1);
        new String();
        if (!paramReqMQScanRequest.string_check_target.get().equalsIgnoreCase((String)localObject1))
        {
          paramReqMQScanRequest = new safecheckPB.ReportItem();
          paramReqMQScanRequest.string_target_packname.set(((PackageInfo)localObject2).packageName);
          paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((PackageInfo)localObject2).applicationInfo.sourceDir));
          paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
          paramRspMQScanReport.uint32_check_count.set(1);
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
        return;
      }
      catch (RuntimeException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
      }
    }
  }
  
  public boolean ax(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramString1.length() == 0) || (paramString2.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = Pattern.compile(paramString1, 2).matcher(paramString2).find();
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void b(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    paramReqMQScanRequest = null;
    if (this.a != null) {
      paramReqMQScanRequest = this.a.mContext;
    }
    if (paramReqMQScanRequest == null) {
      return;
    }
    paramReqMQScanRequest = paramReqMQScanRequest.getPackageManager();
    List localList = alkx.b(paramReqMQScanRequest, 8192);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < localList.size()) {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ApplicationInfo)localList.get(j)).packageName, 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            i += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(i);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      } else {
        return;
      }
      j += 1;
    }
  }
  
  public void bG(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    try
    {
      if (cxT >= 1) {
        return;
      }
    }
    finally {}
    new MQPAPPScanService.1(this, paramArrayOfByte).start();
  }
  
  public void c(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = this.a.mContext;
    }
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getPackageManager();
    int i;
    label82:
    String str;
    do
    {
      try
      {
        localObject = alkx.b((PackageManager)localObject, 8192);
        i = 0;
        while (i < ((List)localObject).size())
        {
          if ((ApplicationInfo)((List)localObject).get(i) != null) {
            break label82;
          }
          i += 1;
        }
        str = ((ApplicationInfo)((List)localObject).get(i)).processName;
      }
      catch (RuntimeException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
        return;
      }
    } while ((str == null) || (!ax(paramReqMQScanRequest.string_check_target.get(), str)));
    paramReqMQScanRequest = new safecheckPB.ReportItem();
    paramReqMQScanRequest.string_target_packname.set(((ApplicationInfo)((List)localObject).get(i)).packageName);
    paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((ApplicationInfo)((List)localObject).get(i)).sourceDir));
    paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
    paramRspMQScanReport.uint32_check_count.set(1);
  }
  
  /* Error */
  public void d(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 17	arnz:a	Larnx;
    //   7: ifnull +330 -> 337
    //   10: aload_0
    //   11: getfield 17	arnz:a	Larnx;
    //   14: getfield 151	arnx:mContext	Landroid/content/Context;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +4 -> 25
    //   24: return
    //   25: aload 4
    //   27: invokevirtual 157	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   30: astore 5
    //   32: aload 5
    //   34: aload 4
    //   36: invokevirtual 161	android/content/Context:getPackageName	()Ljava/lang/String;
    //   39: iconst_1
    //   40: invokevirtual 167	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   43: astore 7
    //   45: new 281	com/tencent/commonsdk/zip/QZipFile
    //   48: dup
    //   49: aload 7
    //   51: getfield 214	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   54: getfield 219	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   57: invokespecial 283	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: ldc_w 285
    //   67: invokevirtual 289	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   70: astore 4
    //   72: aload 4
    //   74: ifnull +199 -> 273
    //   77: aload 5
    //   79: aload 4
    //   81: invokevirtual 293	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   84: astore 4
    //   86: sipush 8192
    //   89: newarray byte
    //   91: astore 6
    //   93: ldc_w 295
    //   96: invokestatic 301	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   99: astore 8
    //   101: aload 4
    //   103: aload 6
    //   105: invokevirtual 307	java/io/InputStream:read	([B)I
    //   108: istore_3
    //   109: iload_3
    //   110: ifle +63 -> 173
    //   113: aload 8
    //   115: aload 6
    //   117: iconst_0
    //   118: iload_3
    //   119: invokevirtual 311	java/security/MessageDigest:update	([BII)V
    //   122: goto -21 -> 101
    //   125: astore_2
    //   126: aload 4
    //   128: astore_1
    //   129: aload_2
    //   130: invokevirtual 227	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 314	java/io/InputStream:close	()V
    //   141: aload 5
    //   143: ifnull -119 -> 24
    //   146: aload 5
    //   148: invokevirtual 315	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   151: return
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 316	java/lang/Throwable:printStackTrace	()V
    //   157: return
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 228	java/lang/RuntimeException:printStackTrace	()V
    //   163: return
    //   164: astore_2
    //   165: aconst_null
    //   166: astore 5
    //   168: aconst_null
    //   169: astore_1
    //   170: goto -41 -> 129
    //   173: aload 8
    //   175: invokevirtual 319	java/security/MessageDigest:digest	()[B
    //   178: invokestatic 322	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   181: astore 8
    //   183: new 175	java/lang/String
    //   186: dup
    //   187: invokespecial 176	java/lang/String:<init>	()V
    //   190: pop
    //   191: aload 4
    //   193: astore 6
    //   195: aload_1
    //   196: getfield 184	com/tencent/ims/safecheckPB$ReqMQScanRequest:string_check_target	Lcom/tencent/mobileqq/pb/PBStringField;
    //   199: invokevirtual 188	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   202: aload 8
    //   204: invokevirtual 192	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   207: ifne +66 -> 273
    //   210: aload_2
    //   211: getfield 66	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   214: aload_1
    //   215: getfield 67	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   218: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   221: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   224: aload_2
    //   225: getfield 74	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   228: iconst_1
    //   229: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   232: new 194	com/tencent/ims/safecheckPB$ReportItem
    //   235: dup
    //   236: invokespecial 195	com/tencent/ims/safecheckPB$ReportItem:<init>	()V
    //   239: astore_1
    //   240: aload_1
    //   241: getfield 198	com/tencent/ims/safecheckPB$ReportItem:string_target_packname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload 7
    //   246: getfield 204	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   249: invokevirtual 207	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   252: aload_1
    //   253: getfield 210	com/tencent/ims/safecheckPB$ReportItem:string_target_md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload 8
    //   258: invokevirtual 207	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   261: aload_2
    //   262: getfield 99	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   265: aload_1
    //   266: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   269: aload 4
    //   271: astore 6
    //   273: aload 6
    //   275: astore_1
    //   276: goto -143 -> 133
    //   279: astore_2
    //   280: aconst_null
    //   281: astore 5
    //   283: aconst_null
    //   284: astore_1
    //   285: aload_2
    //   286: invokevirtual 323	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   289: goto -156 -> 133
    //   292: astore_2
    //   293: aconst_null
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_1
    //   298: aload_2
    //   299: invokevirtual 324	java/io/IOException:printStackTrace	()V
    //   302: goto -169 -> 133
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_1
    //   308: goto -10 -> 298
    //   311: astore_2
    //   312: aload 4
    //   314: astore_1
    //   315: goto -17 -> 298
    //   318: astore_2
    //   319: aconst_null
    //   320: astore_1
    //   321: goto -36 -> 285
    //   324: astore_2
    //   325: aload 4
    //   327: astore_1
    //   328: goto -43 -> 285
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -205 -> 129
    //   337: aconst_null
    //   338: astore 4
    //   340: goto -321 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	arnz
    //   0	343	1	paramReqMQScanRequest	safecheckPB.ReqMQScanRequest
    //   0	343	2	paramRspMQScanReport	safecheckPB.RspMQScanReport
    //   108	11	3	i	int
    //   17	322	4	localObject1	Object
    //   30	265	5	localObject2	Object
    //   1	273	6	localObject3	Object
    //   43	202	7	localPackageInfo	PackageInfo
    //   99	158	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   86	101	125	android/content/pm/PackageManager$NameNotFoundException
    //   101	109	125	android/content/pm/PackageManager$NameNotFoundException
    //   113	122	125	android/content/pm/PackageManager$NameNotFoundException
    //   173	191	125	android/content/pm/PackageManager$NameNotFoundException
    //   195	269	125	android/content/pm/PackageManager$NameNotFoundException
    //   137	141	152	java/lang/Throwable
    //   146	151	152	java/lang/Throwable
    //   32	45	158	java/lang/RuntimeException
    //   32	45	164	android/content/pm/PackageManager$NameNotFoundException
    //   45	62	164	android/content/pm/PackageManager$NameNotFoundException
    //   159	163	164	android/content/pm/PackageManager$NameNotFoundException
    //   32	45	279	java/security/NoSuchAlgorithmException
    //   45	62	279	java/security/NoSuchAlgorithmException
    //   159	163	279	java/security/NoSuchAlgorithmException
    //   32	45	292	java/io/IOException
    //   45	62	292	java/io/IOException
    //   159	163	292	java/io/IOException
    //   62	72	305	java/io/IOException
    //   77	86	305	java/io/IOException
    //   86	101	311	java/io/IOException
    //   101	109	311	java/io/IOException
    //   113	122	311	java/io/IOException
    //   173	191	311	java/io/IOException
    //   195	269	311	java/io/IOException
    //   62	72	318	java/security/NoSuchAlgorithmException
    //   77	86	318	java/security/NoSuchAlgorithmException
    //   86	101	324	java/security/NoSuchAlgorithmException
    //   101	109	324	java/security/NoSuchAlgorithmException
    //   113	122	324	java/security/NoSuchAlgorithmException
    //   173	191	324	java/security/NoSuchAlgorithmException
    //   195	269	324	java/security/NoSuchAlgorithmException
    //   62	72	331	android/content/pm/PackageManager$NameNotFoundException
    //   77	86	331	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void e(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    if (this.a != null) {}
    for (Object localObject1 = this.a.mContext;; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        Object localObject2 = (ActivityManager)((Context)localObject1).getSystemService("activity");
        localObject1 = ((Context)localObject1).getPackageManager();
        localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
        while (i < ((List)localObject2).size())
        {
          if (ax(paramReqMQScanRequest.string_check_target.get(), ((ActivityManager.RunningAppProcessInfo)((List)localObject2).get(i)).processName)) {
            try
            {
              paramReqMQScanRequest = ((PackageManager)localObject1).getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject2.get(i)).pkgList[0], 1);
              localObject1 = new safecheckPB.ReportItem();
              ((safecheckPB.ReportItem)localObject1).string_target_packname.set(paramReqMQScanRequest.packageName);
              ((safecheckPB.ReportItem)localObject1).string_target_md5.set(SecUtil.getFileMd5(paramReqMQScanRequest.applicationInfo.sourceDir));
              paramRspMQScanReport.rpt_check_item.add((MessageMicro)localObject1);
              paramRspMQScanReport.uint32_check_count.set(1);
              return;
            }
            catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
            {
              paramReqMQScanRequest.printStackTrace();
              return;
            }
            catch (RuntimeException paramReqMQScanRequest)
            {
              paramReqMQScanRequest.printStackTrace();
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void f(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    Object localObject;
    int j;
    if (this.a != null)
    {
      paramReqMQScanRequest = this.a.mContext;
      if (paramReqMQScanRequest == null) {
        return;
      }
      localObject = (ActivityManager)paramReqMQScanRequest.getSystemService("activity");
      paramReqMQScanRequest = paramReqMQScanRequest.getPackageManager();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      j = 0;
    }
    for (;;)
    {
      if (j < ((List)localObject).size())
      {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject.get(j)).pkgList[0], 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            i += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(i);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
      else
      {
        return;
        paramReqMQScanRequest = null;
        break;
      }
      j += 1;
    }
  }
  
  public boolean iy(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    int i;
    switch (aroc.getNetType(this.a.mContext))
    {
    default: 
      i = 0;
    }
    while ((i & paramInt) == 0)
    {
      return false;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 8;
      continue;
      i = 16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnz
 * JD-Core Version:    0.7.0.1
 */