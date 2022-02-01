package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import EncounterSvc.RespEncounterInfo;
import akkv;
import aqdf;

public class ChatPushCarrierHelper$1
  implements Runnable
{
  public ChatPushCarrierHelper$1(akkv paramakkv, String paramString, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    aqdf localaqdf = this.this$0.a;
    String str = this.bTH;
    if (this.a.stranger_face_timestamp > 0) {}
    for (long l = this.a.stranger_face_timestamp;; l = this.a.common_face_timestamp)
    {
      localaqdf.c(32, str, 202, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.1
 * JD-Core Version:    0.7.0.1
 */