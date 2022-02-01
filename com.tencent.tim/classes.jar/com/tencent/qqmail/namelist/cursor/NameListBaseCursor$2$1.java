package com.tencent.qqmail.namelist.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class NameListBaseCursor$2$1
  implements Runnable
{
  NameListBaseCursor$2$1(NameListBaseCursor.2 param2) {}
  
  public void run()
  {
    if (NameListBaseCursor.access$000(this.this$1.this$0) != null) {
      NameListBaseCursor.access$000(this.this$1.this$0).run();
    }
    if (this.this$1.val$refreshCallback != null) {
      this.this$1.val$refreshCallback.onRefreshComplete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListBaseCursor.2.1
 * JD-Core Version:    0.7.0.1
 */