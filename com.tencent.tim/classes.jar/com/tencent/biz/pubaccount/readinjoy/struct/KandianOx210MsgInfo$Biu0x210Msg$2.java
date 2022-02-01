package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;

public class KandianOx210MsgInfo$Biu0x210Msg$2
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.a(this.val$app, true, false).edit();
    localEditor.remove("kandian_biu_0x210_seq");
    localEditor.remove("kandian_biu_0x210_uin");
    localEditor.remove("kandian_biu_0x210_status");
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.2
 * JD-Core Version:    0.7.0.1
 */