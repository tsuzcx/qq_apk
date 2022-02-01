package com.tencent.av.video.call;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import aqiw;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import igg;
import ihn;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jgu;

public class ClientLogReport
{
  private static final int GACSReportNewKey = 2085;
  private static final int GACSReportNewKey2 = 2207;
  private static final String HWCodecCapabilityTestKey = "dc05274";
  public static final int HWCodecCapabilityTestTopicId = 5274;
  private static final int LogSendRet_FAIL = 0;
  private static final int LogSendRet_OK = 1;
  private static final int LogSendRet_PENDING = 2;
  private static final String NewGACSReport = "dc02085";
  private static final String NewGACSReport2 = "dc02207";
  private static final String REPORT_FAIL_LOG_DIR = ;
  private static final long REPORT_FAIL_RETRY_MAX_INTERVAL = 86400000L;
  private static final String REPORT_RECORD_IS_RETRY = "report_record_is_retry";
  private static final String REPORT_RECORD_SEQ = "report_record_seq";
  private static final String ServerFilterKey = "video_log";
  private static final String TAG = "ClientLogReport";
  private static final String UdpCheckResultServerFilterKey = "video_udpcheck_log";
  private static ClientLogReport instance;
  private int mAppId;
  private Context mContext;
  private boolean mInit;
  private MsfServiceSdk mMsfSub;
  private boolean mNativeInit;
  private Map<Integer, ReportRecord> mReportRecordCache = new ConcurrentHashMap();
  private boolean mReportRetryEnable;
  private int mSeqNo;
  private VideoAppInterface mVideoApp;
  
  static
  {
    try
    {
      cacheMethodIds();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ClientLogReport", 1, "cacheMethodIds fail.", localThrowable);
    }
  }
  
  private ClientLogReport()
  {
    try
    {
      init();
      this.mNativeInit = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ClientLogReport", 1, "ClientLogReport fail.", localThrowable);
    }
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  public static ClientLogReport instance()
  {
    if (instance == null) {
      instance = new ClientLogReport();
    }
    return instance;
  }
  
  private int sendLog(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!this.mInit)
    {
      QLog.e("ClientLogReport", 1, "sendLog mInit is false.");
      return 0;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("ClientLogReport", 1, "sendLog log is empty.");
      return 0;
    }
    if (this.mMsfSub == null)
    {
      QLog.e("ClientLogReport", 1, "sendLog mMsfSub is null.");
      return 0;
    }
    Object localObject1 = String.valueOf(paramInt);
    if (paramInt == 0) {
      localObject1 = "video_log";
    }
    try
    {
      Object localObject2 = new ConcurrentHashMap();
      ((Map)localObject2).put(localObject1, new ArrayList());
      ((ArrayList)((Map)localObject2).get(localObject1)).add(paramArrayOfByte);
      if ((this.mReportRetryEnable) && (this.mVideoApp != null) && (paramInt == 918))
      {
        this.mSeqNo += 1;
        localObject1 = new QQService.strupbuff();
        ((QQService.strupbuff)localObject1).logstring = ((Map)localObject2);
        ((QQService.strupbuff)localObject1).seqno = this.mSeqNo;
        localObject2 = new UniPacket(true);
        ((UniPacket)localObject2).setServantName("QQService.CliLogSvc.MainServantObj");
        ((UniPacket)localObject2).setFuncName("UploadReq");
        ((UniPacket)localObject2).put("Data", localObject1);
        localObject1 = ((UniPacket)localObject2).encode();
        if (QLog.isColorLevel()) {
          QLog.d("ClientLogReport", 2, String.format("sendLog with response length=%s wupBuf=%s", new Object[] { Integer.valueOf(localObject1.length), Arrays.toString((byte[])localObject1) }));
        }
        localObject1 = Arrays.copyOfRange((byte[])localObject1, 4, localObject1.length);
        if (QLog.isColorLevel()) {
          QLog.d("ClientLogReport", 2, String.format("sendLog length=%s wupBuf1=%s", new Object[] { Integer.valueOf(localObject1.length), Arrays.toString((byte[])localObject1) }));
        }
        localObject2 = new ReportRecord(null);
        ((ReportRecord)localObject2).mUin = paramLong;
        ((ReportRecord)localObject2).mTopicId = paramInt;
        ((ReportRecord)localObject2).mLog = paramArrayOfByte;
        ((ReportRecord)localObject2).mTimestamp = System.currentTimeMillis();
        this.mReportRecordCache.put(Integer.valueOf(this.mSeqNo), localObject2);
        paramArrayOfByte = new ToServiceMsg(null, String.valueOf(paramLong), "CliLogSvc.UploadReq");
        paramArrayOfByte.putWupBuffer((byte[])localObject1);
        paramArrayOfByte.setNeedCallback(true);
        paramArrayOfByte.setTimeout(15000L);
        paramArrayOfByte.addAttribute("report_record_seq", Integer.valueOf(this.mSeqNo));
        paramArrayOfByte.addAttribute("report_record_is_retry", Boolean.valueOf(paramBoolean));
        this.mVideoApp.sendToService(paramArrayOfByte);
      }
      for (;;)
      {
        return 1;
        if (paramInt == 1)
        {
          localObject1 = "video_udpcheck_log";
          break;
        }
        if (paramInt == 2085)
        {
          localObject1 = "dc02085";
          break;
        }
        if (paramInt == 2207)
        {
          localObject1 = "dc02207";
          break;
        }
        if (paramInt != 5274) {
          break;
        }
        localObject1 = "dc05274";
        break;
        paramArrayOfByte = new com.tencent.av.video.jce.QQService.strupbuff();
        paramArrayOfByte.logstring = ((Map)localObject2);
        localObject1 = new UniPacket(true);
        ((UniPacket)localObject1).put("Data", paramArrayOfByte);
        paramArrayOfByte = ((UniPacket)localObject1).encode();
        if (QLog.isColorLevel()) {
          QLog.d("ClientLogReport", 2, String.format("sendLog without response length=%s wupBuf=%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Arrays.toString(paramArrayOfByte) }));
        }
        localObject1 = new ToServiceMsg(this.mMsfSub.getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
        ((ToServiceMsg)localObject1).putWupBuffer(paramArrayOfByte);
        ((ToServiceMsg)localObject1).setNeedCallback(false);
        this.mMsfSub.sendMsg((ToServiceMsg)localObject1);
      }
      return 0;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("ClientLogReport", 1, "callbackSendLog fail.", paramArrayOfByte);
    }
  }
  
  /* Error */
  private void writeToFile(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 304	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 307	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: aload_3
    //   12: aload_2
    //   13: invokevirtual 310	java/io/FileOutputStream:write	([B)V
    //   16: aload_3
    //   17: astore_1
    //   18: aload_3
    //   19: invokevirtual 313	java/io/FileOutputStream:flush	()V
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 316	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore 4
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: ldc 47
    //   39: iconst_1
    //   40: ldc_w 318
    //   43: aload 4
    //   45: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_2
    //   49: ifnull -19 -> 30
    //   52: aload_2
    //   53: invokevirtual 316	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: return
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 316	java/io/FileOutputStream:close	()V
    //   70: aload_2
    //   71: athrow
    //   72: astore_1
    //   73: return
    //   74: astore_1
    //   75: goto -5 -> 70
    //   78: astore_2
    //   79: goto -17 -> 62
    //   82: astore 4
    //   84: aload_3
    //   85: astore_2
    //   86: goto -51 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ClientLogReport
    //   0	89	1	paramFile	File
    //   0	89	2	paramArrayOfByte	byte[]
    //   8	77	3	localFileOutputStream	java.io.FileOutputStream
    //   31	13	4	localThrowable1	Throwable
    //   82	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	9	31	java/lang/Throwable
    //   52	56	57	java/lang/Throwable
    //   0	9	59	finally
    //   26	30	72	java/lang/Throwable
    //   66	70	74	java/lang/Throwable
    //   11	16	78	finally
    //   18	22	78	finally
    //   37	48	78	finally
    //   11	16	82	java/lang/Throwable
    //   18	22	82	java/lang/Throwable
  }
  
  public int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    QLog.d("ClientLogReport", 1, String.format("callbackSendLog sendUin=%s topicId=%s log=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramArrayOfByte }));
    return sendLog(paramLong, paramInt, paramArrayOfByte, false);
  }
  
  public void checkLocalReportRecord()
  {
    QLog.d("ClientLogReport", 1, "checkLocalReportRecord");
    if (!this.mInit)
    {
      QLog.e("ClientLogReport", 1, "checkLocalReportRecord mInit is false.");
      return;
    }
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QLog.e("ClientLogReport", 1, "checkLocalReportRecord network is invalid.");
      return;
    }
    new Handler(ThreadManagerV2.getFileThreadLooper()).post(new ClientLogReport.1(this));
  }
  
  public void handleServerResp(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClientLogReport", 2, String.format("handleServerResp request=%s response=%s", new Object[] { paramIntent, paramFromServiceMsg }));
    }
    int i;
    boolean bool2;
    if ((paramIntent != null) && (paramFromServiceMsg != null))
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      i = ((Integer)paramIntent.getAttribute("report_record_seq")).intValue();
      boolean bool1 = ((Boolean)paramIntent.getAttribute("report_record_is_retry")).booleanValue();
      bool2 = paramFromServiceMsg.isSuccess();
      paramIntent = (ReportRecord)this.mReportRecordCache.get(Integer.valueOf(i));
      QLog.d("ClientLogReport", 1, String.format("handleServerResp seq=%s isRetry=%s success=%s record=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramIntent }));
      if (paramIntent != null)
      {
        if (!bool1) {
          break label173;
        }
        ihn.hV(bool2);
      }
    }
    for (;;)
    {
      this.mReportRecordCache.remove(Integer.valueOf(i));
      return;
      label173:
      if (!bool2)
      {
        paramFromServiceMsg = new File(REPORT_FAIL_LOG_DIR);
        if (!paramFromServiceMsg.exists()) {
          paramFromServiceMsg.mkdirs();
        }
        paramIntent.writeToFile(new File(REPORT_FAIL_LOG_DIR, String.valueOf(paramIntent.mTimestamp)));
        ihn.amr();
      }
    }
  }
  
  public void init(Context paramContext, int paramInt)
  {
    if (this.mNativeInit)
    {
      this.mContext = paramContext;
      this.mAppId = paramInt;
      this.mMsfSub = MsfServiceSdk.get();
      if (jgu.a().azs != 1) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      this.mReportRetryEnable = bool;
      this.mInit = true;
      QLog.d("ClientLogReport", 1, String.format("init mReportRetryEnable=%s", new Object[] { Boolean.valueOf(this.mReportRetryEnable) }));
      return;
    }
  }
  
  public void setVideoAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    this.mVideoApp = paramVideoAppInterface;
  }
  
  static class ReportRecord
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    byte[] mLog;
    long mTimestamp;
    int mTopicId;
    long mUin;
    
    /* Error */
    public static ReportRecord readFromFile(File paramFile)
    {
      // Byte code:
      //   0: new 32	java/io/FileInputStream
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   8: astore_1
      //   9: new 37	java/io/ObjectInputStream
      //   12: dup
      //   13: aload_1
      //   14: invokespecial 40	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   17: astore_0
      //   18: aload_0
      //   19: astore_3
      //   20: aload_1
      //   21: astore_2
      //   22: aload_0
      //   23: invokevirtual 44	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   26: checkcast 2	com/tencent/av/video/call/ClientLogReport$ReportRecord
      //   29: astore 4
      //   31: aload_1
      //   32: ifnull +7 -> 39
      //   35: aload_1
      //   36: invokevirtual 47	java/io/FileInputStream:close	()V
      //   39: aload_0
      //   40: ifnull +7 -> 47
      //   43: aload_0
      //   44: invokevirtual 48	java/io/ObjectInputStream:close	()V
      //   47: aload 4
      //   49: areturn
      //   50: astore 4
      //   52: aconst_null
      //   53: astore_0
      //   54: aconst_null
      //   55: astore_1
      //   56: aload_0
      //   57: astore_3
      //   58: aload_1
      //   59: astore_2
      //   60: ldc 50
      //   62: iconst_1
      //   63: ldc 52
      //   65: aload 4
      //   67: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   70: aload_1
      //   71: ifnull +7 -> 78
      //   74: aload_1
      //   75: invokevirtual 47	java/io/FileInputStream:close	()V
      //   78: aload_0
      //   79: ifnull +79 -> 158
      //   82: aload_0
      //   83: invokevirtual 48	java/io/ObjectInputStream:close	()V
      //   86: aconst_null
      //   87: areturn
      //   88: astore_0
      //   89: aconst_null
      //   90: areturn
      //   91: astore_0
      //   92: aconst_null
      //   93: astore_3
      //   94: aconst_null
      //   95: astore_1
      //   96: aload_1
      //   97: ifnull +7 -> 104
      //   100: aload_1
      //   101: invokevirtual 47	java/io/FileInputStream:close	()V
      //   104: aload_3
      //   105: ifnull +7 -> 112
      //   108: aload_3
      //   109: invokevirtual 48	java/io/ObjectInputStream:close	()V
      //   112: aload_0
      //   113: athrow
      //   114: astore_1
      //   115: goto -76 -> 39
      //   118: astore_0
      //   119: aload 4
      //   121: areturn
      //   122: astore_1
      //   123: goto -45 -> 78
      //   126: astore_1
      //   127: goto -23 -> 104
      //   130: astore_1
      //   131: goto -19 -> 112
      //   134: astore_0
      //   135: aconst_null
      //   136: astore_3
      //   137: goto -41 -> 96
      //   140: astore_0
      //   141: aload_2
      //   142: astore_1
      //   143: goto -47 -> 96
      //   146: astore 4
      //   148: aconst_null
      //   149: astore_0
      //   150: goto -94 -> 56
      //   153: astore 4
      //   155: goto -99 -> 56
      //   158: aconst_null
      //   159: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	160	0	paramFile	File
      //   8	93	1	localFileInputStream1	java.io.FileInputStream
      //   114	1	1	localThrowable1	Throwable
      //   122	1	1	localThrowable2	Throwable
      //   126	1	1	localThrowable3	Throwable
      //   130	1	1	localThrowable4	Throwable
      //   142	1	1	localObject	Object
      //   21	121	2	localFileInputStream2	java.io.FileInputStream
      //   19	118	3	localFile	File
      //   29	19	4	localReportRecord	ReportRecord
      //   50	70	4	localThrowable5	Throwable
      //   146	1	4	localThrowable6	Throwable
      //   153	1	4	localThrowable7	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	9	50	java/lang/Throwable
      //   82	86	88	java/lang/Throwable
      //   0	9	91	finally
      //   35	39	114	java/lang/Throwable
      //   43	47	118	java/lang/Throwable
      //   74	78	122	java/lang/Throwable
      //   100	104	126	java/lang/Throwable
      //   108	112	130	java/lang/Throwable
      //   9	18	134	finally
      //   22	31	140	finally
      //   60	70	140	finally
      //   9	18	146	java/lang/Throwable
      //   22	31	153	java/lang/Throwable
    }
    
    public String toString()
    {
      return String.format("ReportRecord{mUin=%s mTopicId=%s mLog=%s mTimestamp=%s}", new Object[] { Long.valueOf(this.mUin), Integer.valueOf(this.mTopicId), this.mLog, Long.valueOf(this.mTimestamp) });
    }
    
    /* Error */
    public void writeToFile(File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: new 90	java/io/FileOutputStream
      //   7: dup
      //   8: aload_1
      //   9: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   12: astore_1
      //   13: new 93	java/io/ObjectOutputStream
      //   16: dup
      //   17: aload_1
      //   18: invokespecial 96	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   21: astore_2
      //   22: aload_2
      //   23: aload_0
      //   24: invokevirtual 100	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   27: aload_2
      //   28: invokevirtual 103	java/io/ObjectOutputStream:flush	()V
      //   31: aload_1
      //   32: ifnull +7 -> 39
      //   35: aload_1
      //   36: invokevirtual 104	java/io/FileOutputStream:close	()V
      //   39: aload_2
      //   40: ifnull +7 -> 47
      //   43: aload_2
      //   44: invokevirtual 105	java/io/ObjectOutputStream:close	()V
      //   47: return
      //   48: astore_1
      //   49: aconst_null
      //   50: astore_2
      //   51: ldc 50
      //   53: iconst_1
      //   54: ldc 107
      //   56: aload_1
      //   57: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   60: aload_3
      //   61: ifnull +7 -> 68
      //   64: aload_3
      //   65: invokevirtual 104	java/io/FileOutputStream:close	()V
      //   68: aload_2
      //   69: ifnull -22 -> 47
      //   72: aload_2
      //   73: invokevirtual 105	java/io/ObjectOutputStream:close	()V
      //   76: return
      //   77: astore_1
      //   78: return
      //   79: astore_1
      //   80: aconst_null
      //   81: astore 4
      //   83: aload_2
      //   84: astore_3
      //   85: aload 4
      //   87: astore_2
      //   88: aload_3
      //   89: ifnull +7 -> 96
      //   92: aload_3
      //   93: invokevirtual 104	java/io/FileOutputStream:close	()V
      //   96: aload_2
      //   97: ifnull +7 -> 104
      //   100: aload_2
      //   101: invokevirtual 105	java/io/ObjectOutputStream:close	()V
      //   104: aload_1
      //   105: athrow
      //   106: astore_1
      //   107: goto -68 -> 39
      //   110: astore_1
      //   111: return
      //   112: astore_1
      //   113: goto -45 -> 68
      //   116: astore_3
      //   117: goto -21 -> 96
      //   120: astore_2
      //   121: goto -17 -> 104
      //   124: astore 4
      //   126: aconst_null
      //   127: astore_2
      //   128: aload_1
      //   129: astore_3
      //   130: aload 4
      //   132: astore_1
      //   133: goto -45 -> 88
      //   136: astore 4
      //   138: aload_1
      //   139: astore_3
      //   140: aload 4
      //   142: astore_1
      //   143: goto -55 -> 88
      //   146: astore_1
      //   147: goto -59 -> 88
      //   150: astore 4
      //   152: aconst_null
      //   153: astore_2
      //   154: aload_1
      //   155: astore_3
      //   156: aload 4
      //   158: astore_1
      //   159: goto -108 -> 51
      //   162: astore 4
      //   164: aload_1
      //   165: astore_3
      //   166: aload 4
      //   168: astore_1
      //   169: goto -118 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	172	0	this	ReportRecord
      //   0	172	1	paramFile	File
      //   1	100	2	localObject1	Object
      //   120	1	2	localThrowable1	Throwable
      //   127	27	2	localObject2	Object
      //   3	90	3	localObject3	Object
      //   116	1	3	localThrowable2	Throwable
      //   129	37	3	localFile	File
      //   81	5	4	localObject4	Object
      //   124	7	4	localObject5	Object
      //   136	5	4	localObject6	Object
      //   150	7	4	localThrowable3	Throwable
      //   162	5	4	localThrowable4	Throwable
      // Exception table:
      //   from	to	target	type
      //   4	13	48	java/lang/Throwable
      //   72	76	77	java/lang/Throwable
      //   4	13	79	finally
      //   35	39	106	java/lang/Throwable
      //   43	47	110	java/lang/Throwable
      //   64	68	112	java/lang/Throwable
      //   92	96	116	java/lang/Throwable
      //   100	104	120	java/lang/Throwable
      //   13	22	124	finally
      //   22	31	136	finally
      //   51	60	146	finally
      //   13	22	150	java/lang/Throwable
      //   22	31	162	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport
 * JD-Core Version:    0.7.0.1
 */