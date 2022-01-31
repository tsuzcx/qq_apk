package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
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
  public DataTransInfo reqInfo;
  
  public RequestDataTrans(String paramString1, String paramString2, int paramInt1, DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    super(paramString1, paramString2, paramInt1, paramArrayOfByte, paramInt2, paramLong);
    this.reqInfo = paramDataTransInfo;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_DATA] Info: ");
    localStringBuilder.append(super.dumpBaseInfo()).append("\tFsize:").append(this.reqInfo.fileSize).append("\tOffset:").append(this.reqInfo.offset).append("\tBitS:").append(this.reqInfo.bitmapStart).append("\tBitE:").append(this.reqInfo.bitmapEnd).append("\tLen:").append(this.reqInfo.length).append("\tMD5:").append(this.reqInfo.md5Str);
    return localStringBuilder.toString();
  }
  
  public byte[] getRequestBody()
  {
    return this.reqInfo.getData();
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = new CSDataHighwayHead.SegHead();
    if ((this.ticket != null) && (getTicket().length > 0)) {
      localSegHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
    }
    localSegHead.uint32_datalength.set(this.reqInfo.length);
    localSegHead.uint64_dataoffset.set(this.reqInfo.offset);
    localSegHead.uint64_filesize.set(this.reqInfo.fileSize);
    if (this.reqInfo.md5 != null) {
      localSegHead.bytes_md5.set(ByteStringMicro.copyFrom(this.reqInfo.md5));
    }
    if (this.reqInfo.parent.MD5 != null) {
      localSegHead.bytes_file_md5.set(ByteStringMicro.copyFrom(this.reqInfo.parent.MD5));
    }
    return localSegHead;
  }
  
  public void handleCancle()
  {
    this.reqInfo.handleCancle();
  }
  
  public void handleResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    boolean bool = false;
    Transaction localTransaction;
    if (paramHwResponse.hwRetCode == 0)
    {
      if (paramHwResponse.segmentResp.uint32_flag.has())
      {
        if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) == 1) {
          bool = true;
        }
        paramHwResponse.isFinish = bool;
      }
      localTransaction = paramRequestWorker.engine.mTransWorker.getTransactionById(this.transId);
      if (localTransaction != null)
      {
        this.reqInfo.timeCost_req = paramHwResponse.reqCost;
        this.reqInfo.timeCost_hw = paramHwResponse.htCost;
        this.reqInfo.timeCost_cache = paramHwResponse.cacheCost;
        this.reqInfo.retryTimes = this.retryCount;
        if (this.sentEndpoint != null)
        {
          localTransaction.ipAddr = (this.sentEndpoint.host + ":" + this.sentEndpoint.port);
          localTransaction.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
          localTransaction.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
          if (this.protoType != 1) {
            break label244;
          }
          paramRequestWorker = "TCP";
          localTransaction.protoType = paramRequestWorker;
          if (this.connType != 1) {
            break label251;
          }
          paramRequestWorker = "LongConn";
          label217:
          localTransaction.connType = paramRequestWorker;
        }
        if (!paramHwResponse.isFinish) {
          break label258;
        }
        localTransaction.onTransSuccess(this.reqInfo, paramHwResponse.mBuExtendinfo);
      }
    }
    label244:
    label251:
    do
    {
      return;
      paramRequestWorker = "HTTP";
      break;
      paramRequestWorker = "ShortConn";
      break label217;
      localTransaction.onTransProgress(this.reqInfo);
      return;
      BdhLogUtil.LogEvent("R", "HandleResp : RespError :" + dumpBaseInfo());
      paramRequestWorker = paramRequestWorker.engine.mTransWorker.getTransactionById(this.transId);
    } while (paramRequestWorker == null);
    label258:
    paramRequestWorker.onTransFailed(0, paramHwResponse.hwRetCode, paramHwResponse.buzRetCode, this.retryCount, paramHwResponse.mBuExtendinfo);
  }
  
  public boolean hasRequestBody()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestDataTrans
 * JD-Core Version:    0.7.0.1
 */