package com.tencent.qqmail.note;

import android.view.View;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.register.view.TouchableSpan;
import com.tencent.qqmail.view.FolderLockDialog;

class NoteListActivity$31
  extends TouchableSpan
{
  NoteListActivity$31(NoteListActivity paramNoteListActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onClick(View paramView)
  {
    NoteListActivity.access$202(this.this$0, new FolderLockDialog(this.this$0.getActivity(), -4, NoteListActivity.access$800(this.this$0).mCurAccountId, NoteListActivity.access$3400(this.this$0)));
    NoteListActivity.access$200(this.this$0).createDialog(1);
    NoteListActivity.access$200(this.this$0).showDialogTouchOutsideFalse();
    NoteListActivity.access$702(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.31
 * JD-Core Version:    0.7.0.1
 */