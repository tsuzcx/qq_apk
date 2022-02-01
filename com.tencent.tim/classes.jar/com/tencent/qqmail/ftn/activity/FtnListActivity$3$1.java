package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.utilities.ui.PtrListView;

class FtnListActivity$3$1
  implements Runnable
{
  FtnListActivity$3$1(FtnListActivity.3 param3, FtnUI paramFtnUI) {}
  
  public void run()
  {
    FtnListActivity.access$600(this.this$1.this$0, this.val$ftnUI);
    if (FtnListActivity.access$700(this.this$1.this$0).isRefreshing()) {
      FtnListActivity.access$700(this.this$1.this$0).onRefreshComplete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */