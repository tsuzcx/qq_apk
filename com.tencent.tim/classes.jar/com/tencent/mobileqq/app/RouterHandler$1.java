package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.ProtocolHelper;
import java.util.List;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

class RouterHandler$1
  implements Runnable
{
  RouterHandler$1(RouterHandler paramRouterHandler, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    MsgCSBody localMsgCSBody = this.this$0.a.MsgCSBodyFromNFCNotify(0, this.a, this.xS, this.cY);
    this.this$0.b.OnPbMsgReceive(localMsgCSBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.1
 * JD-Core Version:    0.7.0.1
 */