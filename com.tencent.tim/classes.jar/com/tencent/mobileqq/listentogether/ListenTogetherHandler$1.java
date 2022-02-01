package com.tencent.mobileqq.listentogether;

import aink;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class ListenTogetherHandler$1
  implements Runnable
{
  public ListenTogetherHandler$1(aink paramaink, long paramLong1, long paramLong2, int paramInt, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("server_request", String.valueOf(this.abM - this.abN));
    localHashMap.put("serverInterval", String.valueOf(this.abM));
    localHashMap.put("requestInterval", String.valueOf(this.abN));
    localHashMap.put("reportType", String.valueOf(this.dee));
    localHashMap.put("interval", String.valueOf(this.le));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "listen_together_seek_adjust", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHandler.1
 * JD-Core Version:    0.7.0.1
 */