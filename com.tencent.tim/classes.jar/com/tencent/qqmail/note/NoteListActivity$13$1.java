package com.tencent.qqmail.note;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;

class NoteListActivity$13$1
  implements DialogInterface.OnDismissListener
{
  NoteListActivity$13$1(NoteListActivity.13 param13, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131695669))) {
      if (!QMNetworkUtils.isNetworkConnected(this.this$1.this$0)) {
        Threads.runOnMainThread(NoteListActivity.access$1300(this.this$1.this$0));
      }
    }
    while (!this.val$tag.equals(this.this$1.this$0.getString(2131695672)))
    {
      return;
      NoteListActivity.access$800(this.this$1.this$0).starNotesWithNotification(this.this$1.val$idlist, true);
      NoteListActivity.access$1400(this.this$1.this$0);
      return;
    }
    if (!QMNetworkUtils.isNetworkConnected(this.this$1.this$0))
    {
      Threads.runOnMainThread(NoteListActivity.access$1300(this.this$1.this$0));
      return;
    }
    NoteListActivity.access$800(this.this$1.this$0).starNotesWithNotification(this.this$1.val$idlist, false);
    NoteListActivity.access$1400(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.13.1
 * JD-Core Version:    0.7.0.1
 */