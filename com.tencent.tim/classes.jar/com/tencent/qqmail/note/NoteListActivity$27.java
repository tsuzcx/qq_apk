package com.tencent.qqmail.note;

import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMToggleView;
import com.tencent.qqmail.utilities.ui.QMToggleView.QMToggleViewCallback;
import com.tencent.qqmail.view.QMTopBar;

class NoteListActivity$27
  implements QMToggleView.QMToggleViewCallback
{
  NoteListActivity$27(NoteListActivity paramNoteListActivity) {}
  
  public void didDismiss(QMToggleView paramQMToggleView) {}
  
  public void onDismiss(QMToggleView paramQMToggleView)
  {
    if ((this.this$0.mNoteListListView != null) && (this.this$0.mNoteListListView.getParent() != null))
    {
      this.this$0.mNoteListListView.scrollBy(0, 1);
      this.this$0.mNoteListListView.scrollBy(0, -1);
    }
  }
  
  public void onShow(QMToggleView paramQMToggleView)
  {
    this.this$0.renderToggleTypes();
    if (paramQMToggleView.isHidden())
    {
      NoteListActivity.access$3100(this.this$0).setArrowStatus(1);
      return;
    }
    NoteListActivity.access$3100(this.this$0).setArrowStatus(0);
  }
  
  public boolean willSelectRow(QMToggleView paramQMToggleView, int paramInt, String paramString)
  {
    NoteListActivity.access$3100(this.this$0).setTitle(paramString);
    NoteListActivity.access$3200(this.this$0, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.27
 * JD-Core Version:    0.7.0.1
 */