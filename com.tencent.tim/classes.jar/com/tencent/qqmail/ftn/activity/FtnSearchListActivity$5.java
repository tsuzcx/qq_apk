package com.tencent.qqmail.ftn.activity;

import android.widget.ListView;
import com.tencent.qqmail.search.view.SearchToggleView;
import com.tencent.qqmail.search.view.SearchToggleView.SearchToggleViewCallback;
import com.tencent.qqmail.utilities.thread.Threads;

class FtnSearchListActivity$5
  implements SearchToggleView.SearchToggleViewCallback
{
  FtnSearchListActivity$5(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public void didDismiss(SearchToggleView paramSearchToggleView)
  {
    FtnSearchListActivity.access$600(this.this$0).setPadding(0, 0, 0, 0);
    Threads.runOnMainThread(new FtnSearchListActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.5
 * JD-Core Version:    0.7.0.1
 */