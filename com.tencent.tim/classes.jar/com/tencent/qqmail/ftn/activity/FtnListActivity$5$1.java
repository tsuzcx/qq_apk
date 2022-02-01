package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;

class FtnListActivity$5$1
  implements Runnable
{
  FtnListActivity$5$1(FtnListActivity.5 param5) {}
  
  public void run()
  {
    if (this.this$1.this$0.isEditing())
    {
      FtnListActivity.access$600(this.this$1.this$0, FtnListActivity.access$500(this.this$1.this$0).getFtnList());
      if (this.this$1.this$0.isEditing())
      {
        FtnListActivity.access$1300(this.this$1.this$0);
        FtnListActivity.access$1400(this.this$1.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.5.1
 * JD-Core Version:    0.7.0.1
 */