package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import xxh;
import xxh.a;
import xxh.b;

public class CmGameChatPie$ChatPieMsgListener$3
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$3(xxh.a parama, xxh paramxxh, String paramString) {}
  
  public void run()
  {
    xxh.a(this.a, this.SO, null, 1);
    if ((this.a.sessionInfo != null) && (this.a.getApp() != null)) {
      this.a.l(this.a.sessionInfo.aTl, this.a.getApp().getCurrentUin(), xxh.a(this.a).nickName, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.3
 * JD-Core Version:    0.7.0.1
 */