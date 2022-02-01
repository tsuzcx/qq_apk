package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import msg;

class ReadInJoySelfActivity$1
  implements Runnable
{
  ReadInJoySelfActivity$1(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void run()
  {
    this.this$0.a.aLh();
    msg localmsg;
    String str;
    if (this.this$0.b != null)
    {
      localmsg = msg.a();
      str = this.this$0.mApp.getCurrentAccountUin();
      if (!this.this$0.b.BD()) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = 1)
    {
      localmsg.aN(str, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity.1
 * JD-Core Version:    0.7.0.1
 */