package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import com.tencent.mobileqq.app.QQAppInterface;
import mhm;

public class KandianOx210MsgInfo$4
  implements Runnable
{
  public KandianOx210MsgInfo$4(mhm parammhm, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.a(this.val$app, true, false).edit();
    localEditor.putString("kandian_push_0x210_msg_for_follow", this.this$0.jO());
    localEditor.putLong("kandian_push_0x210_c5_msg_time", this.this$0.msgTime);
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.4
 * JD-Core Version:    0.7.0.1
 */