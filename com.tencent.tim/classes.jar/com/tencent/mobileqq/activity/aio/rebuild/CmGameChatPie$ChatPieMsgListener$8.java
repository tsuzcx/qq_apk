package com.tencent.mobileqq.activity.aio.rebuild;

import abmf;
import xxh;
import xxh.a;

public class CmGameChatPie$ChatPieMsgListener$8
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$8(xxh.a parama, xxh paramxxh, int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    this.a.f(this.val$gameId, this.kT, this.aWS);
    if (xxh.a(this.a) != null) {
      xxh.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.8
 * JD-Core Version:    0.7.0.1
 */