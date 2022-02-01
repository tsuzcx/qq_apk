package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.utilities.ui.PtrListView;

class FtnListActivity$4$1
  implements Runnable
{
  FtnListActivity$4$1(FtnListActivity.4 param4, int paramInt) {}
  
  public void run()
  {
    if ((FtnListActivity.access$800(this.this$1.this$0) != null) && (FtnListActivity.access$900(this.this$1.this$0).getCount() == 0))
    {
      if (this.val$cgiException != -131) {
        break label81;
      }
      FtnListActivity.access$1000(this.this$1.this$0, 5);
    }
    for (;;)
    {
      if (FtnListActivity.access$700(this.this$1.this$0).isRefreshing()) {
        FtnListActivity.access$700(this.this$1.this$0).onRefreshComplete();
      }
      return;
      label81:
      FtnListActivity.access$1100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.4.1
 * JD-Core Version:    0.7.0.1
 */