package com.tencent.qqmail.note;

import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.ui.PtrListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NoteListActivity$3$1
  implements Runnable
{
  NoteListActivity$3$1(NoteListActivity.3 param3) {}
  
  public void run()
  {
    if (!this.this$1.this$0.mIsLoading)
    {
      ArrayList localArrayList = Lists.newArrayList();
      int i = this.this$1.this$0.mNoteListListView.getHeaderViewsCount();
      Iterator localIterator = this.this$1.this$0.mCheckedNoteIds.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Integer.valueOf(((Integer)localIterator.next()).intValue() - i));
      }
      ListViewRemoveItemAnimator.animateRemoval(this.this$1.this$0.mNoteListListView, localArrayList, new NoteListActivity.3.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */