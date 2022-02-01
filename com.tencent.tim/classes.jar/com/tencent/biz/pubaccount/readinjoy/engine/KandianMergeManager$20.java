package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;

class KandianMergeManager$20
  implements Runnable
{
  KandianMergeManager$20(KandianMergeManager paramKandianMergeManager, long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.b(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putLong("subscribe_push_msg_time", this.val$time);
    localEditor.putString("subscribe_push_msg_uin", this.aem);
    localEditor.putInt("subscribe_push_msg_status", this.aMX);
    localEditor.putString("subscribe_push_msg_xml", this.aen);
    localEditor.putInt("subscribe_push_msg_msgtype", this.aBm);
    awit.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.20
 * JD-Core Version:    0.7.0.1
 */