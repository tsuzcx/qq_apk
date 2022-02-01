package com.tencent.qqmail.note;

import android.widget.TextView;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class NoteListActivity$4
  implements QMUnlockFolderPwdWatcher
{
  NoteListActivity$4(NoteListActivity paramNoteListActivity) {}
  
  public void onCancel(int paramInt1, int paramInt2)
  {
    NoteListActivity.access$602(this.this$0, true);
    if (NoteListActivity.access$500(this.this$0) != null) {
      NoteListActivity.access$500(this.this$0).setVisibility(0);
    }
  }
  
  public void onDismiss(int paramInt1, int paramInt2)
  {
    NoteListActivity.access$702(this.this$0, false);
    if ((!NoteListActivity.access$600(this.this$0)) && (NoteListActivity.access$500(this.this$0) != null)) {
      NoteListActivity.access$500(this.this$0).setVisibility(8);
    }
    NoteListActivity.access$602(this.this$0, false);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    NoteListActivity.access$400(this.this$0, new NoteListActivity.4.2(this));
    if (NoteListActivity.access$500(this.this$0) != null) {
      NoteListActivity.access$500(this.this$0).setVisibility(0);
    }
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    NoteListActivity.access$300(this.this$0, new NoteListActivity.4.1(this, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.4
 * JD-Core Version:    0.7.0.1
 */