package com.tencent.mobileqq.apollo;

import abin;
import abrg;
import abwh;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$5
  implements Runnable
{
  public ChatPieApolloViewController$5(abin paramabin, int paramInt, BaseChatPie paramBaseChatPie, abrg paramabrg) {}
  
  public void run()
  {
    abwh.a(this.cpe, 101, 0, new Object[] { "parallel surfaceReady" });
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start preLoad Js");
    if ((this.d != null) && (this.a != null) && (this.d.sessionInfo != null))
    {
      this.a.d(this.d.sessionInfo);
      this.a.dj(this.d.sessionInfo.aTl, this.d.sessionInfo.cZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.5
 * JD-Core Version:    0.7.0.1
 */