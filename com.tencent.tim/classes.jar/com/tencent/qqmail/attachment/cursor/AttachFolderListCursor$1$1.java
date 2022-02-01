package com.tencent.qqmail.attachment.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;

class AttachFolderListCursor$1$1
  implements Runnable
{
  AttachFolderListCursor$1$1(AttachFolderListCursor.1 param1) {}
  
  public void run()
  {
    AttachFolderListCursor.access$102(this.this$1.this$0, AttachFolderListCursor.access$200(this.this$1.this$0));
    if (AttachFolderListCursor.access$300(this.this$1.this$0) != null) {
      AttachFolderListCursor.access$300(this.this$1.this$0).run();
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListCursor.1.1
 * JD-Core Version:    0.7.0.1
 */