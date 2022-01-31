package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;

public class RequestHeartBreak
  extends HwRequest
{
  public int connId;
  public boolean isUrgent = false;
  
  public RequestHeartBreak(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramInt1, null, -1, paramLong);
    this.connId = paramInt2;
    this.isUrgent = paramBoolean;
    if (this.isUrgent) {
      this.timeOut = 10000L;
    }
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_HEARTBREAK] Info: ");
    localStringBuilder.append(super.dumpBaseInfo());
    localStringBuilder.append(" ConnId:" + this.connId);
    localStringBuilder.append(" Urgent:" + this.isUrgent);
    return localStringBuilder.toString();
  }
  
  public int getPriority()
  {
    return 0;
  }
  
  public byte[] getRequestBody()
  {
    return super.getRequestBody();
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    return null;
  }
  
  public void handleResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    if (this.isUrgent) {
      paramRequestWorker.engine.mConnManager.onHeartBreakResp(this.sendConnId, this.sentEndpoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestHeartBreak
 * JD-Core Version:    0.7.0.1
 */