package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;

class QMSearchCursor$2
  implements Runnable
{
  QMSearchCursor$2(QMSearchCursor paramQMSearchCursor, boolean paramBoolean1, Cursor paramCursor1, boolean paramBoolean2, Cursor paramCursor2, boolean paramBoolean3, Cursor paramCursor3, Runnable paramRunnable) {}
  
  public void run()
  {
    if (this.val$canRefreshDraftCursor) {
      QMSearchCursor.access$600(this.this$0, this.val$draftCursor);
    }
    if (this.val$canRefreshLocalCursor) {
      QMSearchCursor.access$700(this.this$0, this.val$localCursor);
    }
    if (this.val$canRefreshRemoteCursor) {
      QMSearchCursor.access$800(this.this$0, this.val$remoteCursor);
    }
    if (this.val$afterRefresh != null) {
      this.val$afterRefresh.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSearchCursor.2
 * JD-Core Version:    0.7.0.1
 */