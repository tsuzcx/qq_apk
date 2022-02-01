package com.tencent.qqmail.note;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.movenote.MoveNoteActivity;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class NoteListActivity$25
  implements View.OnClickListener
{
  NoteListActivity$25(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mCheckedNoteIds.size() == 0) {
      this.this$0.getTips().showInfo(this.this$0.getString(2131696422));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.this$0, MoveNoteActivity.class);
      localIntent.putExtra("NoteIds", NoteListActivity.access$2700(this.this$0));
      localIntent.putExtra("CurrCatalogId", NoteListActivity.access$2500(this.this$0));
      localIntent.putExtra("fromBatchOp", true);
      this.this$0.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.25
 * JD-Core Version:    0.7.0.1
 */