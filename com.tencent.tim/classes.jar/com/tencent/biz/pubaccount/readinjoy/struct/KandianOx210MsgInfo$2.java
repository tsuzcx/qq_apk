package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import com.tencent.mobileqq.app.QQAppInterface;
import mhm;

public class KandianOx210MsgInfo$2
  implements Runnable
{
  public KandianOx210MsgInfo$2(mhm parammhm, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.a(this.val$app, true, false).edit();
    localEditor.putString("kandian_0x210_c5_normal_item_body", this.this$0.jO());
    localEditor.putInt("kandian_0x210_c5_normal_item_msg_count", this.this$0.msgCount);
    localEditor.putLong("kandian_0x210_c5_normal_item_msg_time", this.this$0.msgTime);
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.2
 * JD-Core Version:    0.7.0.1
 */