package com.tencent.mobileqq.activity;

import acfp;
import android.text.format.DateFormat;
import android.widget.TextView;
import aqmr;
import java.util.List;

class JoinDiscussionActivity$3
  implements Runnable
{
  JoinDiscussionActivity$3(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  public void run()
  {
    String str1 = aqmr.substring(this.this$0.aNK, 0, 32);
    String str2 = aqmr.substring(this.this$0.mOwnerName, 0, 32);
    if (this.this$0.qG != null) {
      this.this$0.DO.setText(str1 + String.format("(%d人)", new Object[] { Integer.valueOf(this.this$0.qG.size()) }));
    }
    for (;;)
    {
      this.this$0.DP.setText(str2 + acfp.m(2131707522) + DateFormat.format("yy-M-d", this.this$0.mCreateTime));
      return;
      this.this$0.DO.setText(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.3
 * JD-Core Version:    0.7.0.1
 */