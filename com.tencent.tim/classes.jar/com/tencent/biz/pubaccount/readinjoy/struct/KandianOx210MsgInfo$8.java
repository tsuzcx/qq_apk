package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import mhm;
import mqq.app.AppRuntime;

public class KandianOx210MsgInfo$8
  implements Runnable
{
  public KandianOx210MsgInfo$8(mhm parammhm, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.a(this.val$app, true, false).edit();
    localEditor.remove("kandian_push_ox210_msg");
    localEditor.remove("kandian_push_ox210_c5_msg_count");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.8
 * JD-Core Version:    0.7.0.1
 */