package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import mhm;

public class KandianOx210MsgInfo$3
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.a(this.val$app, true, false).edit();
    localEditor.putString("kandian_push_0x210_msg_sys", this.this$0.jO());
    localEditor.putInt("kandian_push_0x210_msg_sys_count", this.this$0.msgCount);
    localEditor.putLong("kandian_push_0x210_c5_msg_time", this.this$0.msgTime);
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.3
 * JD-Core Version:    0.7.0.1
 */