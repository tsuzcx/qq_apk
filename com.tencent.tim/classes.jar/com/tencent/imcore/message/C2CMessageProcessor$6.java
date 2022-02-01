package com.tencent.imcore.message;

import anpc;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;
import tob;

public class C2CMessageProcessor$6
  implements Runnable
{
  public C2CMessageProcessor$6(tob paramtob, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromUin", this.My);
    localHashMap.put("toUin", this.Lw);
    localHashMap.put("msgId", this.val$msgId);
    localHashMap.put("createTime", String.valueOf(this.xN));
    localHashMap.put("recvTime", String.valueOf(this.EJ));
    localHashMap.put("sendFlag", this.aJF);
    localHashMap.put("nodeNo", String.valueOf(3000));
    long l2 = this.EJ - this.xN;
    long l1;
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= 86400L) {}
    }
    else
    {
      l1 = 0L;
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPubAccMsgReceipt", true, l1, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.6
 * JD-Core Version:    0.7.0.1
 */