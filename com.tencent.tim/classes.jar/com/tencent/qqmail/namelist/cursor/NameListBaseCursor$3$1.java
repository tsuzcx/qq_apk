package com.tencent.qqmail.namelist.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class NameListBaseCursor$3$1
  implements Runnable
{
  NameListBaseCursor$3$1(NameListBaseCursor.3 param3) {}
  
  public void run()
  {
    this.this$1.this$0.currentCursor = this.this$1.this$0.nextCursor;
    if (NameListBaseCursor.access$000(this.this$1.this$0) != null) {
      NameListBaseCursor.access$000(this.this$1.this$0).run();
    }
    if (this.this$1.val$refreshCallback != null) {
      this.this$1.val$refreshCallback.onRefreshComplete();
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListBaseCursor.3.1
 * JD-Core Version:    0.7.0.1
 */