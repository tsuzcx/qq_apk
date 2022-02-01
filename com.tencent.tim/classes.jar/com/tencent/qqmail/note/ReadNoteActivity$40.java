package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.qmui.popup.QMUIListPopup;

class ReadNoteActivity$40
  implements View.OnClickListener
{
  ReadNoteActivity$40(ReadNoteActivity paramReadNoteActivity, QMNNoteInformation paramQMNNoteInformation, TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    if (ReadNoteActivity.access$3400(this.this$0) == null) {
      ReadNoteActivity.access$3600(this.this$0, new ReadNoteActivity.40.1(this));
    }
    if (ReadNoteActivity.access$3400(this.this$0) != null) {
      ReadNoteActivity.access$3400(this.this$0).show(ReadNoteActivity.access$1400(this.this$0), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.40
 * JD-Core Version:    0.7.0.1
 */