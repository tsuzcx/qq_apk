package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;

class ReadNoteActivity$27
  implements View.OnClickListener
{
  ReadNoteActivity$27(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.confirmStarNote(ReadNoteActivity.access$100(this.this$0).information.noteId, ReadNoteActivity.access$100(this.this$0).status.starred, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.27
 * JD-Core Version:    0.7.0.1
 */