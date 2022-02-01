package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadNoteActivity$30
  implements View.OnClickListener
{
  ReadNoteActivity$30(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onClick(View paramView)
  {
    ReadNoteActivity.access$2300(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.30
 * JD-Core Version:    0.7.0.1
 */