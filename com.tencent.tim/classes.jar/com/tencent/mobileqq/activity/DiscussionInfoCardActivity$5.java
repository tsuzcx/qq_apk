package com.tencent.mobileqq.activity;

import acdt;
import acdt.c;
import acdu;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class DiscussionInfoCardActivity$5
  implements Runnable
{
  DiscussionInfoCardActivity$5(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = DiscussionInfoCardActivity.a(this.this$0).z(DiscussionInfoCardActivity.a(this.this$0));
    this.this$0.fO(localArrayList);
    if (this.aVC) {}
    try
    {
      acdt.c localc = new acdt.c();
      localc.uin = String.valueOf(DiscussionInfoCardActivity.a(this.this$0));
      localc.memberCount = localArrayList.size();
      DiscussionInfoCardActivity.a(this.this$0).a(localc);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView getDiscussInfo error disUin=" + DiscussionInfoCardActivity.a(this.this$0), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.5
 * JD-Core Version:    0.7.0.1
 */