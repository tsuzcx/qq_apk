package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import kxm;

class KandianMergeManager$25
  implements Runnable
{
  KandianMergeManager$25(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = awit.b(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.remove("kandian_push_msg_xml").remove("kandian_push_msg_time");
    awit.a(localEditor, true);
    kxm.af("kandian_lock_screen_push_info", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.25
 * JD-Core Version:    0.7.0.1
 */