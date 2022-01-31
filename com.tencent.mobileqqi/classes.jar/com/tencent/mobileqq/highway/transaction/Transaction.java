package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeItem.ProbeResult;
import com.tencent.mobileqq.highway.netprobe.ProbeResponse;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHole;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Transaction
  implements ProbeCallback
{
  public static final long C2C_FileSize_Limit = 19922944L;
  public static final int HOLE_MASK_FIN = 3;
  public static final int HOLE_MASK_HOLD = 4;
  public static final int HOLE_MASK_INIT = 0;
  public static final int HOLE_MASK_SENT = 2;
  public static final int HOLE_MASK_WAIT = 1;
  public static final int HOLE_SIZE_PER_HOLE = 4096;
  private static final int MAX_QUERY_HOLE_RSP_SIZE = 5;
  public byte[] MD5;
  public Tracker TRACKER = null;
  private AtomicBoolean TimerStarted = new AtomicBoolean(false);
  public volatile boolean bQueryForFIN = false;
  public byte[] bitmap;
  private ITransactionCallback cb;
  public byte[] extendInfo;
  public String filePath;
  public AtomicBoolean hasSwitch2BackupChannel = new AtomicBoolean(false);
  public AtomicBoolean isFinish = new AtomicBoolean(false);
  public boolean isOpenUpEnable;
  public AtomicBoolean isSuccess = new AtomicBoolean(false);
  public CSDataHighwayHead.LoginSigHead loginSigHead;
  public byte[] mBuExtendinfo;
  public int mBuzCmdId;
  private int mErrorCode = -1;
  private AtomicBoolean mIsPause = new AtomicBoolean(false);
  private HashMap<String, String> mReport = new HashMap();
  public TransTimeOutMonitor mTimeOutMonitor;
  public TransReport mTransReport = new TransReport();
  private TransactionWorker mTransWorker;
  private int offset;
  public String peerUin;
  public int preSendDots;
  private RandomAccessFile raf;
  public byte[] ticket;
  public int totalLength = 0;
  int transationId = -1;
  private int transferedSize = 0;
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback)
  {
    this.peerUin = paramString1;
    this.filePath = paramString2;
    this.offset = paramInt2;
    this.mBuzCmdId = paramInt1;
    this.MD5 = paramArrayOfByte2;
    this.ticket = paramArrayOfByte1;
    this.cb = paramITransactionCallback;
    if (this.offset < 0) {
      this.offset = 0;
    }
    this.isOpenUpEnable = false;
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback, int paramInt3, byte[] paramArrayOfByte3, CSDataHighwayHead.LoginSigHead paramLoginSigHead)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramITransactionCallback);
    this.isOpenUpEnable = true;
    this.preSendDots = paramInt3;
    this.extendInfo = paramArrayOfByte3;
    this.loginSigHead = paramLoginSigHead;
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback, byte[] paramArrayOfByte3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramITransactionCallback);
    this.extendInfo = paramArrayOfByte3;
  }
  
  private void extendTimeExceedLimit()
  {
    TransTimeOutMonitor localTransTimeOutMonitor = this.mTimeOutMonitor;
    if (localTransTimeOutMonitor.needExtendTimeExceedLimit())
    {
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " ExtendTimeExceedLimit.");
      localTransTimeOutMonitor.isKilled = true;
      if (this.mTransWorker != null)
      {
        this.mTimeOutMonitor = new TransTimeOutMonitor();
        this.mTransWorker.startTransRunnable(localTransTimeOutMonitor, this.mTimeOutMonitor);
      }
    }
  }
  
  private void finishAndDetachFromWorker(boolean paramBoolean)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish. IsSuccess:" + paramBoolean);
    if (this.mTransWorker != null)
    {
      this.mTransWorker.onTransactionFinish(paramBoolean, this);
      this.mTransWorker = null;
    }
    try
    {
      if (this.raf != null)
      {
        this.raf.close();
        this.raf = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish Error: IsSuccess:" + paramBoolean, localIOException);
    }
  }
  
  private boolean isPause()
  {
    return this.mIsPause.get();
  }
  
  private void startTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "startTimeoutTimer.");
    Object localObject = this.cb;
    if (localObject != null) {
      ((ITransactionCallback)localObject).onTransStart();
    }
    if (this.mTransWorker != null)
    {
      localObject = this.mTimeOutMonitor;
      ((TransTimeOutMonitor)localObject).isKilled = true;
      this.mTimeOutMonitor = new TransTimeOutMonitor();
      this.mTransWorker.startTransRunnable((Runnable)localObject, this.mTimeOutMonitor);
    }
  }
  
  private void stopTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " StopTimeoutTime.");
    this.TimerStarted.set(false);
    if (this.mTimeOutMonitor != null) {
      this.mTimeOutMonitor.isKilled = true;
    }
    if (this.mTransWorker != null) {
      this.mTransWorker.stopTransRunnable(this.mTimeOutMonitor);
    }
  }
  
  private HashMap<String, String> updateAndGetReporter()
  {
    this.mTransReport.ipConnCost = this.mTransWorker.getIpConnectCost();
    this.mTransReport.dataFlow = this.mTransWorker.getReportDataFlow();
    this.mTransReport.ipAddr = this.mTransWorker.getLastUsedIp();
    this.mTransReport.port = this.mTransWorker.getLastUsedPort();
    this.mTransReport.mTransferedSize = this.transferedSize;
    return this.mTransReport.getReportInfo();
  }
  
  public void cancelTransaction()
  {
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    this.TRACKER.logStep("CANCL", "");
    stopTimeoutTimer();
    finishAndDetachFromWorker(false);
  }
  
  public void continueTrans()
  {
    QLog.d("BDH_LOG", 1, "T \tT_ID:" + getTransationId() + "\tcontinueTrans.");
    if (this.isFinish.get()) {
      return;
    }
    int j = this.totalLength / 4096;
    int i = j;
    if (this.totalLength % 4096 != 0) {
      i = j + 1;
    }
    j = this.preSendDots;
    while (j < i)
    {
      if (this.bitmap[j] == 4) {
        this.bitmap[j] = 0;
      }
      j += 1;
    }
    this.mTransWorker.notifyToSend();
  }
  
  public int getBuzType()
  {
    if (this.mBuzCmdId == 12) {
      return 1;
    }
    if ((this.mBuzCmdId == 1) || (this.mBuzCmdId == 4)) {
      return 0;
    }
    return 0;
  }
  
  /* Error */
  public byte[] getData(DataTransInfo paramDataTransInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/mobileqq/highway/transaction/Transaction:isFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 224	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +16 -> 25
    //   12: aload_1
    //   13: iconst_0
    //   14: putfield 323	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   17: aconst_null
    //   18: astore 5
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 5
    //   24: areturn
    //   25: iconst_0
    //   26: istore_3
    //   27: aload_1
    //   28: getfield 326	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   31: istore_2
    //   32: aload_1
    //   33: getfield 326	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   36: newarray byte
    //   38: astore 6
    //   40: aload_0
    //   41: getfield 209	com/tencent/mobileqq/highway/transaction/Transaction:raf	Ljava/io/RandomAccessFile;
    //   44: aload_1
    //   45: getfield 327	com/tencent/mobileqq/highway/transaction/DataTransInfo:offset	I
    //   48: i2l
    //   49: invokevirtual 331	java/io/RandomAccessFile:seek	(J)V
    //   52: aload 6
    //   54: astore 5
    //   56: iload_3
    //   57: aload_1
    //   58: getfield 326	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   61: if_icmpge -41 -> 20
    //   64: aload_0
    //   65: getfield 209	com/tencent/mobileqq/highway/transaction/Transaction:raf	Ljava/io/RandomAccessFile;
    //   68: aload 6
    //   70: iload_3
    //   71: iload_2
    //   72: invokevirtual 335	java/io/RandomAccessFile:read	([BII)I
    //   75: istore 4
    //   77: iload 4
    //   79: iconst_m1
    //   80: if_icmpne +16 -> 96
    //   83: aload_1
    //   84: sipush 9303
    //   87: putfield 323	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   90: aconst_null
    //   91: astore 5
    //   93: goto -73 -> 20
    //   96: iload_3
    //   97: iload 4
    //   99: iadd
    //   100: istore_3
    //   101: iload_2
    //   102: iload 4
    //   104: isub
    //   105: istore_2
    //   106: goto -54 -> 52
    //   109: astore 5
    //   111: ldc 151
    //   113: new 153	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   120: ldc 156
    //   122: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 123	com/tencent/mobileqq/highway/transaction/Transaction:mBuzCmdId	I
    //   129: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 165
    //   134: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokevirtual 169	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   141: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 337
    //   147: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload 5
    //   155: invokestatic 220	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_1
    //   159: aload 5
    //   161: invokestatic 343	com/tencent/mobileqq/highway/utils/BdhUtils:analysisIOProblem	(Ljava/io/IOException;)I
    //   164: putfield 323	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   167: aconst_null
    //   168: astore 5
    //   170: goto -150 -> 20
    //   173: astore_1
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	Transaction
    //   0	178	1	paramDataTransInfo	DataTransInfo
    //   31	75	2	i	int
    //   26	75	3	j	int
    //   75	30	4	k	int
    //   18	74	5	localObject1	Object
    //   109	51	5	localIOException	IOException
    //   168	1	5	localObject2	Object
    //   38	31	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	52	109	java/io/IOException
    //   56	77	109	java/io/IOException
    //   83	90	109	java/io/IOException
    //   2	17	173	finally
    //   27	52	173	finally
    //   56	77	173	finally
    //   83	90	173	finally
    //   111	167	173	finally
  }
  
  public int getTransationId()
  {
    return this.transationId;
  }
  
  int initSegmentList(TransactionWorker paramTransactionWorker, boolean paramBoolean)
  {
    QLog.d("BDH_LOG", 1, "T T_ID:" + getTransationId() + "\tinitSegmentList : " + "\tisOpenUpEnable : " + this.isOpenUpEnable);
    this.mTransReport.mIsPreConnExist = paramBoolean;
    File localFile = new File(this.filePath);
    this.mTransWorker = paramTransactionWorker;
    if (localFile.exists())
    {
      if (!localFile.canRead()) {
        return 9070;
      }
      this.totalLength = ((int)localFile.length());
      if (this.totalLength > 19922944L) {
        return 9063;
      }
      if (this.totalLength <= 0) {
        return 9071;
      }
      int i;
      int k;
      for (;;)
      {
        try
        {
          this.raf = new RandomAccessFile(localFile, "r");
          j = this.totalLength / 4096;
          i = j;
          if (this.totalLength % 4096 != 0) {
            i = j + 1;
          }
          k = this.offset / 4096;
          this.bitmap = new byte[i];
          if (!this.isOpenUpEnable) {
            break;
          }
          j = 0;
          if (j >= i) {
            break label296;
          }
          if (j < this.preSendDots)
          {
            this.bitmap[j] = 0;
            j += 1;
          }
          else
          {
            this.bitmap[j] = 4;
          }
        }
        catch (FileNotFoundException paramTransactionWorker)
        {
          return 9042;
        }
      }
      int j = 0;
      if (j < i)
      {
        if (j < k) {
          this.bitmap[j] = 3;
        }
        for (;;)
        {
          j += 1;
          break;
          this.bitmap[j] = 0;
        }
      }
      label296:
      this.TRACKER = new Tracker(this.transationId, this.totalLength);
      this.mTimeOutMonitor = new TransTimeOutMonitor();
      this.TRACKER.logStep("INITI", "DotsNum:" + i + " StartHole:" + k);
      return 0;
    }
    return 9042;
  }
  
  public void onProbeFinish(ProbeResponse paramProbeResponse)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    Iterator localIterator1 = paramProbeResponse.mProbeItemResults.keySet().iterator();
    while (localIterator1.hasNext())
    {
      paramProbeResponse = (ProbeItem)localIterator1.next();
      if ("ProbeChain".equals(paramProbeResponse.getProbeName()))
      {
        Iterator localIterator2 = ((ProbeChain)paramProbeResponse).chain.iterator();
        label68:
        ProbeItem localProbeItem;
        StringBuilder localStringBuilder2;
        while (localIterator2.hasNext())
        {
          localProbeItem = (ProbeItem)localIterator2.next();
          if (localProbeItem.mResult != null)
          {
            localStringBuilder2 = localStringBuilder1.append(localProbeItem.getProbeName()).append("[");
            if (!localProbeItem.mResult.success) {
              break label169;
            }
          }
        }
        label169:
        for (paramProbeResponse = "1";; paramProbeResponse = "0")
        {
          localStringBuilder2.append(paramProbeResponse).append("]").append("[").append(localProbeItem.mResult.errCode).append("];");
          break label68;
          break;
        }
      }
    }
    paramProbeResponse = (String)this.mReport.get("rep_bdhTrans");
    if (paramProbeResponse != null)
    {
      paramProbeResponse = paramProbeResponse + localStringBuilder1;
      this.mReport.put("rep_bdhTrans", paramProbeResponse);
    }
    if (this.cb != null) {
      this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
    }
  }
  
  public void onProbeProgress(String paramString) {}
  
  public void onQuertHoleError(byte[] paramArrayOfByte)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " QueryDebug Query OnQuertHoleError : CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    int i = 0;
    while (i < this.bitmap.length)
    {
      if ((this.bitmap[i] != 3) && (paramArrayOfByte[i] == 2)) {
        this.bitmap[i] = 0;
      }
      i += 1;
    }
    this.TRACKER.logStep("QUERY", "QueryHoleError Bitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onQueryHoleResp(CSDataHighwayHead.QueryHoleRsp paramQueryHoleRsp, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + " \tT_ID:" + getTransationId() + "\tQueryHoleResp。");
    int i = paramQueryHoleRsp.uint32_result.get();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    BdhUtils.copyData(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (i != 0)
    {
      onQuertHoleError(paramArrayOfByte);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Holes:");
    paramQueryHoleRsp = paramQueryHoleRsp.rpt_data_hole.get();
    i = 0;
    if ((paramQueryHoleRsp != null) && (!paramQueryHoleRsp.isEmpty()))
    {
      Iterator localIterator = paramQueryHoleRsp.iterator();
      if (localIterator.hasNext())
      {
        CSDataHighwayHead.DataHole localDataHole = (CSDataHighwayHead.DataHole)localIterator.next();
        int n = (int)localDataHole.uint64_begin.get();
        int i1 = (int)localDataHole.uint64_end.get();
        int k = n / 4096;
        int m = (i1 - 1) / 4096;
        j = i;
        if (m > i) {
          j = m;
        }
        localStringBuilder.append("Holes Start:").append(k).append(" End:").append(m);
        BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : holes : " + " HoleStart:" + n + " HoleEnd:" + i1 + " BitmapS:" + k + " BitmapE:" + m);
        for (;;)
        {
          i = j;
          if (k > m) {
            break;
          }
          if (paramArrayOfByte[k] == 2) {
            paramArrayOfByte[k] = 0;
          }
          k += 1;
        }
      }
      int j = i;
      if (i >= paramArrayOfByte.length) {
        j = paramArrayOfByte.length - 1;
      }
      if (paramQueryHoleRsp.size() >= 5) {
        while (j < paramArrayOfByte.length)
        {
          paramArrayOfByte[j] = 0;
          j += 1;
        }
      }
      i = 0;
      if (i < paramArrayOfByte.length)
      {
        if ((arrayOfByte[i] == 2) && (paramArrayOfByte[i] == 0) && ((this.bQueryForFIN) || (this.bitmap[i] != 3))) {
          this.bitmap[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramArrayOfByte[i] == 2) {
            this.bitmap[i] = 3;
          }
        }
      }
    }
    else
    {
      localStringBuilder.append("null");
    }
    this.TRACKER.logStep("QUERY", "QueryHoleResp " + localStringBuilder.toString());
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : Merged :" + " CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onSwitchToBackupChannel()
  {
    stopTimeoutTimer();
    if (this.hasSwitch2BackupChannel.get()) {}
    do
    {
      return;
      this.hasSwitch2BackupChannel.set(true);
    } while (this.cb == null);
    this.cb.onSwitch2BackupChannel();
  }
  
  public void onTransFailed(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!this.isFinish.compareAndSet(false, true)) {}
    label118:
    do
    {
      return;
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnTransFailed : ERR_C:" + paramInt1 + " ERR_H:" + paramInt2 + " ERR_B:" + paramInt3);
      stopTimeoutTimer();
      this.mTransReport.updateRetryInfo(paramInt4);
      this.mBuExtendinfo = paramArrayOfByte;
      this.mErrorCode = paramInt1;
      if (paramInt3 != 0)
      {
        this.mErrorCode = paramInt3;
        if (this.mTransWorker != null)
        {
          this.mTransReport.bHasNet = this.mTransWorker.updateAndCheckNet();
          this.mTransReport.isConnected = this.mTransWorker.isNetworkConnected();
          this.mTransReport.connErrCode = this.mTransWorker.getConnErroCode();
          this.mTransReport.setFailReason(this.mErrorCode, paramString);
          if ((this.mErrorCode == -1002) || (this.mErrorCode == -1005))
          {
            this.mTransWorker.dumpEngineInfo();
            paramString = this.TRACKER.dumpTrackerInfo();
            this.TRACKER.logStep("QUERY", "TransFailed  Bitmap:" + Arrays.toString(this.bitmap));
            QLog.d("T", 1, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " TRACEKERINFO:" + paramString);
            if (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)) {
              this.mErrorCode = 9004;
            }
          }
          if ((this.mBuzCmdId != 1) && (this.mBuzCmdId != 2) && (this.mBuzCmdId != 4)) {
            break label531;
          }
          if ((this.mTransReport.bHasNet) && (!BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
            break label481;
          }
          this.mErrorCode = 9004;
        }
      }
      for (;;)
      {
        this.mReport = updateAndGetReporter();
        if ((!this.mTransReport.bHasNet) || ((paramInt1 != -1002) && (paramInt1 != -1005) && (paramInt1 != -1003) && (paramInt1 != -1014))) {
          break label564;
        }
        boolean bool = this.mTransWorker.startNetDetection(this);
        finishAndDetachFromWorker(false);
        if ((bool) || (this.cb == null)) {
          break;
        }
        this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
        return;
        if (paramInt2 == 0) {
          break label118;
        }
        this.mErrorCode = paramInt2;
        break label118;
        if ((this.mErrorCode <= 0) && ((!this.mTransReport.bHasNet) || (!this.mTransReport.isConnected) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))))
        {
          this.mErrorCode = 9004;
          continue;
          if ((!this.mTransReport.bHasNet) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
            this.mErrorCode = 9004;
          }
        }
      }
      finishAndDetachFromWorker(false);
    } while (this.cb == null);
    label481:
    this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
    label531:
    label564:
    return;
  }
  
  public void onTransProgress(DataTransInfo paramDataTransInfo)
  {
    if (this.isFinish.get()) {}
    do
    {
      do
      {
        int m;
        int n;
        do
        {
          return;
          extendTimeExceedLimit();
          this.mTransReport.updateRetryInfo(paramDataTransInfo.retryTimes);
          if (paramDataTransInfo != null)
          {
            localObject = this.mTransReport;
            ((TransReport)localObject).timeCost_Send = ((int)(((TransReport)localObject).timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
            localObject = this.mTransReport;
            ((TransReport)localObject).timeCost_Ht = ((int)(((TransReport)localObject).timeCost_Ht + paramDataTransInfo.timeCost_hw));
            localObject = this.mTransReport;
            ((TransReport)localObject).timeCost_Cache = ((int)(((TransReport)localObject).timeCost_Cache + paramDataTransInfo.timeCost_cache));
          }
          m = paramDataTransInfo.bitmapS;
          n = paramDataTransInfo.bitmapE;
        } while (n >= this.bitmap.length);
        i = m;
        while (i <= n)
        {
          this.bitmap[i] = 3;
          i += 1;
        }
        int j = 0;
        i = 0;
        while (i < this.bitmap.length)
        {
          int k = j;
          if (this.bitmap[i] == 3) {
            k = j + 1;
          }
          i += 1;
          j = k;
        }
        this.transferedSize = (j * 4096);
        if (this.bitmap[(this.bitmap.length - 1)] == 3) {
          this.transferedSize -= this.bitmap.length * 4096 - this.totalLength;
        }
        if (this.transferedSize >= this.totalLength)
        {
          BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "NotifySegmentProgress Error : Finish flag is lost.");
          this.mTransReport.bFINLost = true;
        }
        if (this.cb != null)
        {
          BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentProgress" + " Total:" + this.totalLength + " TransSize:" + this.transferedSize + " allHoles:" + this.bitmap.length + " [" + m + ":" + n + "]");
          this.cb.onUpdateProgress(this.transferedSize);
        }
        this.TRACKER.logStep("PRGRS", "TransProgress Start:" + m + " End:" + n);
      } while ((!this.mTransReport.bFINLost) || (this.bQueryForFIN));
      this.bQueryForFIN = true;
      paramDataTransInfo = this.mTransWorker;
    } while (paramDataTransInfo == null);
    Object localObject = new byte[this.bitmap.length];
    int i = 0;
    while (i <= this.bitmap.length - 1)
    {
      localObject[i] = 2;
      i += 1;
    }
    paramDataTransInfo.queryTransaction(this, (byte[])localObject);
    this.TRACKER.logStep("QUERY", "FinFlagLost  Bitmap:" + Arrays.toString(this.bitmap));
  }
  
  public void onTransSuccess(DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentSuccess");
    if (!this.isFinish.compareAndSet(false, true)) {}
    do
    {
      return;
      this.isSuccess.set(true);
      stopTimeoutTimer();
      if (paramDataTransInfo != null) {
        this.mTransReport.updateRetryInfo(paramDataTransInfo.retryTimes);
      }
      if (paramDataTransInfo != null)
      {
        TransReport localTransReport = this.mTransReport;
        localTransReport.timeCost_Send = ((int)(localTransReport.timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
        localTransReport = this.mTransReport;
        localTransReport.timeCost_Ht = ((int)(localTransReport.timeCost_Ht + paramDataTransInfo.timeCost_hw));
        localTransReport = this.mTransReport;
        localTransReport.timeCost_Cache = ((int)(localTransReport.timeCost_Cache + paramDataTransInfo.timeCost_cache));
      }
      paramDataTransInfo = updateAndGetReporter();
      finishAndDetachFromWorker(true);
      this.mBuExtendinfo = paramArrayOfByte;
      this.transferedSize = this.totalLength;
    } while (this.cb == null);
    this.cb.onSuccess(this.mBuExtendinfo, paramDataTransInfo);
  }
  
  DataTransInfo peekNextSegment(HwNetSegConf paramHwNetSegConf)
  {
    int j = (int)paramHwNetSegConf.segSize;
    if ((this.isFinish.get()) || (isPause())) {
      paramHwNetSegConf = null;
    }
    DataTransInfo localDataTransInfo;
    label183:
    do
    {
      int i;
      int i1;
      int k;
      int m;
      do
      {
        do
        {
          return paramHwNetSegConf;
          if ((this.mTransReport.confSegSize == 0L) && (paramHwNetSegConf != null))
          {
            this.mTransReport.confSegSize = ((int)paramHwNetSegConf.segSize);
            this.mTransReport.confSegNum = ((int)paramHwNetSegConf.segNum);
            this.mTransReport.confConnNum = ((int)paramHwNetSegConf.curConnNum);
          }
          i = j / 4096;
          int n = i;
          if (j % 4096 > 0) {
            n = i + 1;
          }
          localDataTransInfo = null;
          j = -1;
          i1 = -1;
          i = 0;
          k = i1;
          m = j;
          if (i < this.bitmap.length)
          {
            if (this.bitmap[i] != 0) {
              break;
            }
            k = j;
            if (j == -1) {
              k = i;
            }
            if (i != this.bitmap.length - 1)
            {
              m = k;
              if (n != i + 1 - k) {
                break label384;
              }
            }
            m = k;
            k = i;
          }
          paramHwNetSegConf = localDataTransInfo;
        } while (m == -1);
        paramHwNetSegConf = localDataTransInfo;
      } while (k == -1);
      paramHwNetSegConf = this.mTransReport;
      paramHwNetSegConf.sliceNum += 1;
      localDataTransInfo = new DataTransInfo(this);
      localDataTransInfo.fileSize = this.totalLength;
      localDataTransInfo.offset = (m * 4096);
      localDataTransInfo.bitmapS = m;
      localDataTransInfo.bitmapE = k;
      if (k == this.bitmap.length - 1) {}
      for (localDataTransInfo.length = ((k - m) * 4096 + (this.totalLength - (this.bitmap.length - 1) * 4096));; localDataTransInfo.length = ((k - m + 1) * 4096))
      {
        i = m;
        while (i <= k)
        {
          this.bitmap[i] = 1;
          i += 1;
        }
        if ((this.isOpenUpEnable) && (this.bitmap[i] == 4))
        {
          k = i1;
          if (j != -1) {
            k = i - 1;
          }
          stopTimeoutTimer();
          m = j;
          break label183;
        }
        m = j;
        if (j != -1)
        {
          k = i;
          m = j;
          break label183;
        }
        i += 1;
        j = m;
        break;
      }
      this.TRACKER.logStep("SLICE", "Start:" + m + " End:" + k + " Length:" + localDataTransInfo.length);
      paramHwNetSegConf = localDataTransInfo;
    } while (!this.TimerStarted.compareAndSet(false, true));
    label384:
    startTimeoutTimer();
    return localDataTransInfo;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause.set(paramBoolean);
    if (isPause()) {
      stopTimeoutTimer();
    }
  }
  
  public static abstract interface HwBuzType
  {
    public static final int COMMON = 0;
    public static final int PIC = 0;
    public static final int PIC_SUBBUZ_COMMON = 1;
    public static final int PIC_SUBBUZ_OPENUP = 4;
    public static final int SHORT_VIDEO = 1;
    public static final int SHORT_VIDEO_SUBBUZ = 12;
  }
  
  class TransTimeOutMonitor
    implements Runnable
  {
    public volatile boolean isKilled = false;
    public long mStartTime = 0L;
    
    public TransTimeOutMonitor() {}
    
    public boolean needExtendTimeExceedLimit()
    {
      return SystemClock.uptimeMillis() - this.mStartTime >= 60000L;
    }
    
    public void run()
    {
      if (!this.isKilled) {
        Transaction.this.onTransFailed(-1002, "TransTimeOut", -1002, -1002, 0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Transaction
 * JD-Core Version:    0.7.0.1
 */