package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.PtrListView;

class NoteListActivity$StandardArrayAdapter$2
  implements View.OnClickListener
{
  NoteListActivity$StandardArrayAdapter$2(NoteListActivity.StandardArrayAdapter paramStandardArrayAdapter, int paramInt, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.this$1.this$0.mNoteListListView.getOnItemClickListener() != null)
    {
      AdapterView.OnItemClickListener localOnItemClickListener = this.this$1.this$0.mNoteListListView.getOnItemClickListener();
      PtrListView localPtrListView = this.this$1.this$0.mNoteListListView;
      int i = this.val$position;
      localOnItemClickListener.onItemClick(localPtrListView, paramView, this.this$1.this$0.mNoteListListView.getHeaderViewsCount() + i, this.val$id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.StandardArrayAdapter.2
 * JD-Core Version:    0.7.0.1
 */