package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class NoteListActivity$24
  implements View.OnClickListener
{
  NoteListActivity$24(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mCheckedNoteIds.size() == 0) {
      this.this$0.getTips().showInfo(this.this$0.getString(2131696422));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NoteListActivity.access$2600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.24
 * JD-Core Version:    0.7.0.1
 */