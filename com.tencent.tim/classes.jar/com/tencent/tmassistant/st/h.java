package com.tencent.tmassistant.st;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.notification.g;
import java.util.ArrayList;
import java.util.Iterator;

public class h
  extends PostHttpRequest
{
  protected static h a = null;
  protected d b = null;
  private StatReportRequest c;
  
  public int a(ArrayList<StatItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        StatItem localStatItem = (StatItem)localIterator.next();
        ab.c("SDKREPORT", ">>sendRequest type = " + localStatItem.type + " data = " + g.a(localStatItem.records));
      }
      if (this.c == null) {
        this.c = new StatReportRequest();
      }
      this.c.data = paramArrayList;
      paramArrayList = ProtocolPackage.buildRequest(this.c);
      int i = paramArrayList.head.requestId;
      ab.c("StatReportEngine", "selfUpdateReport sendStatReportRequest ret = " + i);
      paramArrayList = ProtocolPackage.buildPostData(paramArrayList);
      ab.c("StatReportEngine", "selfUpdateReport sendStatReportRequest");
      super.sendRequest(paramArrayList);
      return i;
    }
    return -1;
  }
  
  public void a(d paramd)
  {
    this.b = paramd;
  }
  
  public void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    ab.c("StatReportEngine", "errorCode: " + paramInt);
    Response localResponse = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    paramArrayOfByte1 = (Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.head != null)) {}
    for (int i = paramArrayOfByte1.head.requestId;; i = 0)
    {
      if (paramArrayOfByte2 == null)
      {
        ab.c("StatReportEngine", "response is null");
        this.b.onStatReportFinish(i, null, null, paramInt);
        return;
      }
      if ((localResponse != null) && (localResponse.body != null))
      {
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(localResponse.body, StatReportResponse.class);
        if (paramArrayOfByte1 != null) {
          if ((this.b != null) && (paramInt == 0)) {
            if ((paramArrayOfByte1 instanceof StatReportResponse))
            {
              paramArrayOfByte1 = (StatReportResponse)paramArrayOfByte1;
              if (paramArrayOfByte1.ret != 0) {
                break label166;
              }
              this.b.onStatReportFinish(i, null, paramArrayOfByte1, 0);
            }
          }
        }
      }
      for (;;)
      {
        ab.c("StatReportEngine", "exit");
        return;
        label166:
        this.b.onStatReportFinish(i, null, paramArrayOfByte1, paramArrayOfByte1.ret);
        continue;
        this.b.onStatReportFinish(i, null, null, paramInt);
        continue;
        this.b.onStatReportFinish(i, null, null, paramInt);
        continue;
        this.b.onStatReportFinish(i, null, null, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.st.h
 * JD-Core Version:    0.7.0.1
 */