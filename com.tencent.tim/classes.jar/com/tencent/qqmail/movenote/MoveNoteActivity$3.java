package com.tencent.qqmail.movenote;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import moai.oss.KvHelper;

class MoveNoteActivity$3
  implements View.OnClickListener
{
  MoveNoteActivity$3(MoveNoteActivity paramMoveNoteActivity) {}
  
  public void onClick(View paramView)
  {
    KvHelper.eventAddNoteCategoryFromMoveNote(new double[0]);
    Intent localIntent = AddNoteCatalogActivity.createIntent();
    this.this$0.startActivityForResult(localIntent, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.MoveNoteActivity.3
 * JD-Core Version:    0.7.0.1
 */