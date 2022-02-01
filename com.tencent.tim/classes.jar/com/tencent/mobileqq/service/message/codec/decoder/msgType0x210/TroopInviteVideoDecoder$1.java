package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import andb;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody;

public final class TroopInviteVideoDecoder$1
  implements Runnable
{
  public TroopInviteVideoDecoder$1(QQAppInterface paramQQAppInterface, submsgtype0xb1.MsgBody paramMsgBody, boolean paramBoolean) {}
  
  public void run()
  {
    andb.b(this.val$app, this.a.invite_info, this.cER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TroopInviteVideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */