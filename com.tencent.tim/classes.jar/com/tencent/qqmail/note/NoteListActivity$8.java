package com.tencent.qqmail.note;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.view.QMListItemView;
import java.util.HashMap;

class NoteListActivity$8
  implements AdapterView.OnItemClickListener
{
  NoteListActivity$8(NoteListActivity paramNoteListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    boolean bool;
    if ((paramView instanceof QMListItemView))
    {
      localObject = (QMListItemView)paramView;
      NoteListActivity.NoteListItemViewHolder localNoteListItemViewHolder = (NoteListActivity.NoteListItemViewHolder)((QMListItemView)localObject).getTag();
      if (!this.this$0.mIsEditing) {
        break label191;
      }
      if (this.this$0.mNoteListListView.isItemChecked(paramInt)) {
        break label155;
      }
      this.this$0.mCheckedNoteIds.put(Integer.valueOf(paramInt), localNoteListItemViewHolder.noteId);
      this.this$0.mNoteListListView.setItemChecked(paramInt, true);
      int i = this.this$0.mCheckedNoteIds.size();
      int j = this.this$0.mArrayAdapter.getCount();
      localObject = this.this$0;
      if (i != j) {
        break label185;
      }
      bool = true;
      label119:
      NoteListActivity.access$900((NoteListActivity)localObject, bool);
      NoteListActivity.access$1000(this.this$0, i);
      Log.e("check", "checkcheck click trigger in notelist");
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label155:
      this.this$0.mCheckedNoteIds.remove(Integer.valueOf(paramInt));
      this.this$0.mNoteListListView.setItemChecked(paramInt, false);
      break;
      label185:
      bool = false;
      break label119;
      label191:
      ((QMListItemView)localObject).setPressedCustom(true);
      NoteListActivity.access$1100(this.this$0, paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.8
 * JD-Core Version:    0.7.0.1
 */