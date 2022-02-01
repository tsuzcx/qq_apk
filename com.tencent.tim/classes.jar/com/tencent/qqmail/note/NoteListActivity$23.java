package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class NoteListActivity$23
  implements View.OnClickListener
{
  NoteListActivity$23(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.savePostion();
    if (!QMNetworkUtils.isNetworkConnected(this.this$0)) {
      Threads.runOnMainThread(NoteListActivity.access$1300(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.mCheckedNoteIds.size() == 0) {
        this.this$0.getTips().showInfo(this.this$0.getString(2131696422));
      } else {
        this.this$0.showDeleteConfirmDialog();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.23
 * JD-Core Version:    0.7.0.1
 */