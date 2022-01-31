package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.RspBody;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Arrays;

public class RequestInfoQuery
  extends HwRequest
{
  public Transaction mTrans;
  public byte[] sentBitmap;
  
  public RequestInfoQuery(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte1, Transaction paramTransaction, long paramLong, byte[] paramArrayOfByte2)
  {
    super(paramString1, paramString2, paramInt, paramArrayOfByte1, paramTransaction.getTransationId(), paramLong);
    this.sentBitmap = paramArrayOfByte2;
    this.mTrans = paramTransaction;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_INFOQUERY] Info: ");
    localStringBuilder.append(super.dumpBaseInfo());
    return localStringBuilder.toString();
  }
  
  public int getPriority()
  {
    return 1;
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = new CSDataHighwayHead.SegHead();
    if ((this.ticket != null) && (getTicket().length > 0)) {
      localSegHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
    }
    if (this.mTrans.MD5 != null) {
      localSegHead.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mTrans.MD5));
    }
    localSegHead.uint64_filesize.set(this.mTrans.totalLength);
    return localSegHead;
  }
  
  public void handleError(int paramInt)
  {
    this.mTrans.onQuertHoleError(this.sentBitmap);
  }
  
  public void handleResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    boolean bool;
    Transaction localTransaction;
    if ((paramHwResponse.segmentResp.has()) && (paramHwResponse.segmentResp.uint32_flag.has()))
    {
      if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) == 1)
      {
        bool = true;
        paramHwResponse.isFinish = bool;
      }
    }
    else
    {
      BdhLogUtil.LogEvent("R", "QueryDebug Query HandleResponse : retResp.hwRetCode:" + paramHwResponse.hwRetCode + " : TransId:" + this.mTrans.getTransationId() + " CopyBitmap:" + Arrays.toString(this.sentBitmap) + " CurrentBitmap:" + Arrays.toString(this.mTrans.bitmap));
      if (paramHwResponse.hwRetCode != 0) {
        break label348;
      }
      if (!paramHwResponse.isFinish) {
        break label294;
      }
      if (this.sentEndpoint != null)
      {
        this.mTrans.ipAddr = (this.sentEndpoint.host + ":" + this.sentEndpoint.port);
        this.mTrans.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
        this.mTrans.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
      }
      localTransaction = this.mTrans;
      if (this.protoType != 1) {
        break label282;
      }
      paramRequestWorker = "TCP";
      label235:
      localTransaction.protoType = paramRequestWorker;
      localTransaction = this.mTrans;
      if (this.connType != 1) {
        break label288;
      }
    }
    label282:
    label288:
    for (paramRequestWorker = "LongConn";; paramRequestWorker = "ShortConn")
    {
      localTransaction.connType = paramRequestWorker;
      this.mTrans.onTransSuccess(null, paramHwResponse.mBuExtendinfo);
      return;
      bool = false;
      break;
      paramRequestWorker = "HTTP";
      break label235;
    }
    label294:
    paramHwResponse = paramHwResponse.mRespData;
    paramRequestWorker = new CSDataHighwayHead.RspBody();
    try
    {
      paramRequestWorker.mergeFrom(paramHwResponse);
      this.mTrans.onQueryHoleResp((CSDataHighwayHead.QueryHoleRsp)paramRequestWorker.msg_query_hole_rsp.get(), this.sentBitmap, false);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramHwResponse)
    {
      for (;;)
      {
        BdhLogUtil.LogEvent("R", "HandleResp ParseError.");
      }
    }
    label348:
    this.mTrans.onQuertHoleError(this.sentBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestInfoQuery
 * JD-Core Version:    0.7.0.1
 */