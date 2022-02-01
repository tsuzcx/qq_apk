package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import com.tencent.mobileqq.app.QQAppInterface;
import mhm.a;

public class KandianOx210MsgInfo$Biu0x210Msg$1
  implements Runnable
{
  public KandianOx210MsgInfo$Biu0x210Msg$1(mhm.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.a(this.val$app, true, false).edit();
    localEditor.putLong("kandian_biu_0x210_seq", this.this$0.msgSeq);
    localEditor.putLong("kandian_biu_0x210_uin", this.this$0.vj);
    localEditor.putInt("kandian_biu_0x210_status", this.this$0.status);
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1
 * JD-Core Version:    0.7.0.1
 */