package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class HwRequest
{
  public static final int REQ_2SEND = 2;
  public static final int REQ_FINISHED = 4;
  public static final int REQ_INITED = 1;
  public static final int REQ_SENDING = 3;
  public static final int buzTryCountLimit = 3;
  public static final int fixTryCountLimit = 5;
  public static final int mContinuErrorLimit = 10;
  public static final int mContinueConnClosedLimit = 3;
  public static final long mExcuteTimeLimit = 600000L;
  public String account;
  public int bodyLength = 0;
  public int buzRetryCount;
  public int connType = 1;
  public int continueConnClose = 0;
  public int continueErrCount = 0;
  public int dataFlag = 4096;
  public int headLength = 0;
  public String hwCmd = null;
  private int hwSeq = -1;
  public AtomicBoolean isCancel = new AtomicBoolean(false);
  public long lastSendStartTime;
  public String lastUseAddress = null;
  public int mBuCmdId = -1;
  public int protoType = 1;
  public IRequestListener reqListener;
  public int retryCount;
  public long sendComsume;
  public int sendConnId;
  public long sendTime;
  public EndPoint sentEndpoint = null;
  public AtomicInteger status = new AtomicInteger(1);
  protected byte[] ticket;
  public long timeComsume;
  public long timeOut;
  public int transId;
  
  public HwRequest(String paramString1, String paramString2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    this.account = paramString1;
    this.hwCmd = paramString2;
    this.ticket = paramArrayOfByte;
    this.transId = paramInt2;
    this.mBuCmdId = paramInt1;
    this.hwSeq = RequestWorker.getNextSeq();
    if (paramLong == -1L)
    {
      this.timeOut = 45000L;
      return;
    }
    this.timeOut = paramLong;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder(" REQTRACE_REQ ");
    localStringBuilder.append(" B_ID:").append(this.mBuCmdId).append(" T_ID:").append(this.transId).append(" Seq:").append(this.hwSeq).append(" Cmd:").append(this.hwCmd).append(" Uin:").append(this.account).append(" TimeOut:").append(this.timeOut).append(" RetryNum:").append(this.retryCount).append(" Comsume:").append(this.timeComsume).append(" SendCost:").append(this.sendComsume).append(" ContinueErr:").append(this.continueErrCount).append(" Status:").append(this.status.get()).append(" Cancel:").append(this.isCancel.get()).append(" HeadLen:").append(this.headLength).append(" BodyLen:").append(this.bodyLength);
    return localStringBuilder.toString();
  }
  
  public int getHwSeq()
  {
    return this.hwSeq;
  }
  
  public int getPriority()
  {
    return 2;
  }
  
  public byte[] getRequestBody()
  {
    return null;
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = new CSDataHighwayHead.SegHead();
    if ((this.ticket != null) && (getTicket().length > 0)) {
      localSegHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
    }
    return localSegHead;
  }
  
  public byte[] getTicket()
  {
    return this.ticket;
  }
  
  public void handleCancle() {}
  
  public void handleError(int paramInt) {}
  
  public void handleResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse) {}
  
  public boolean hasRequestBody()
  {
    return false;
  }
  
  public void setHwSeq(int paramInt)
  {
    this.hwSeq = paramInt;
  }
  
  public void updateStaus(int paramInt)
  {
    this.status.set(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.HwRequest
 * JD-Core Version:    0.7.0.1
 */