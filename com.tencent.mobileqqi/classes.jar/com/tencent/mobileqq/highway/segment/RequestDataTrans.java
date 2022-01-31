package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class RequestDataTrans
  extends HwRequest
{
  public DataTransInfo mInfo;
  
  public RequestDataTrans(String paramString1, String paramString2, int paramInt1, DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    super(paramString1, paramString2, paramInt1, paramArrayOfByte, paramInt2, paramLong);
    this.mInfo = paramDataTransInfo;
    this.isOpenUpEnable = paramDataTransInfo.parent.isOpenUpEnable;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_DATA] Info: ");
    localStringBuilder.append(super.dumpBaseInfo()).append("\tFsize:").append(this.mInfo.fileSize).append("\tOffset:").append(this.mInfo.offset).append("\tBitS:").append(this.mInfo.bitmapS).append("\tBitE:").append(this.mInfo.bitmapE).append("\tLen:").append(this.mInfo.length).append("\tMD5:").append(this.mInfo.md5Str);
    return localStringBuilder.toString();
  }
  
  public byte[] getExtendInfo()
  {
    return this.mInfo.parent.extendInfo;
  }
  
  public CSDataHighwayHead.LoginSigHead getLoginSigHead()
  {
    return this.mInfo.parent.loginSigHead;
  }
  
  public byte[] getRequestBody()
  {
    return this.mInfo.getData();
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = new CSDataHighwayHead.SegHead();
    localSegHead.uint32_datalength.set(this.mInfo.length);
    localSegHead.uint64_dataoffset.set(this.mInfo.offset);
    localSegHead.uint64_filesize.set(this.mInfo.fileSize);
    if ((this.ticket != null) && (getTicket().length > 0)) {
      localSegHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
    }
    if (this.mInfo.md5 != null) {
      localSegHead.bytes_md5.set(ByteStringMicro.copyFrom(this.mInfo.md5));
    }
    if (this.mInfo.parent.MD5 != null) {
      localSegHead.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mInfo.parent.MD5));
    }
    return localSegHead;
  }
  
  public boolean hasRequestBody()
  {
    return true;
  }
  
  public void onCancle()
  {
    this.mInfo.parent.TRACKER.logStep("CANCL", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
    this.mInfo.handleCancle();
  }
  
  public void onError(int paramInt)
  {
    this.mInfo.parent.TRACKER.logStep("SND_E", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramInt);
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    boolean bool = false;
    this.mInfo.parent.TRACKER.logStep("RESPN", " Data Resp Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramHwResponse.retCode);
    BdhLogUtil.LogEvent("R", " Data Resp Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramHwResponse.retCode);
    Transaction localTransaction = paramRequestWorker.engine.mTransWorker.getTransactionById(this.transId);
    if (localTransaction != null)
    {
      this.mInfo.timeCost_req = paramHwResponse.reqCost;
      this.mInfo.timeCost_hw = paramHwResponse.htCost;
      this.mInfo.timeCost_cache = paramHwResponse.cacheCost;
      this.mInfo.retryTimes = this.retryCount;
      if (this.endpoint != null)
      {
        localTransaction.mTransReport.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
        localTransaction.mTransReport.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
        localTransReport = localTransaction.mTransReport;
        if (this.protoType != 1) {
          break label365;
        }
      }
    }
    label365:
    for (paramRequestWorker = "TCP";; paramRequestWorker = "HTTP")
    {
      localTransReport.protoType = paramRequestWorker;
      localTransaction.mTransReport.ipIndex = this.endpoint.ipIndex;
      if (paramHwResponse.retCode != 0) {
        break label382;
      }
      if (paramHwResponse.segmentResp.uint32_flag.has())
      {
        if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) == 1) {
          bool = true;
        }
        paramHwResponse.isFinish = bool;
      }
      if (!paramHwResponse.isFinish) {
        break;
      }
      localTransaction.onTransSuccess(this.mInfo, paramHwResponse.mBuExtendinfo);
      return;
    }
    localTransaction.onTransProgress(this.mInfo);
    return;
    label382:
    BdhLogUtil.LogEvent("R", "HandleResp : RespError :" + dumpBaseInfo());
    TransReport localTransReport = localTransaction.mTransReport;
    if (this.protoType == 1) {}
    for (paramRequestWorker = "TCP";; paramRequestWorker = "HTTP")
    {
      localTransReport.protoType = paramRequestWorker;
      localTransaction.onTransFailed(0, "BadResponse", paramHwResponse.retCode, paramHwResponse.buzRetCode, this.retryCount, paramHwResponse.mBuExtendinfo);
      return;
    }
  }
  
  public void onRetry(int paramInt)
  {
    this.mInfo.parent.mTransReport.mRetryCode = paramInt;
    this.mInfo.parent.TRACKER.logStep("SND_R", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramInt);
  }
  
  public void onSendBegin()
  {
    this.mInfo.parent.TRACKER.logStep("SND_S", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
  }
  
  public void onSendEnd()
  {
    this.mInfo.parent.TRACKER.logStep("SND_F", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestDataTrans
 * JD-Core Version:    0.7.0.1
 */