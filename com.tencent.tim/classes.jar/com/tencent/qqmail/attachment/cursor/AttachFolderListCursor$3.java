package com.tencent.qqmail.attachment.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class AttachFolderListCursor$3
  implements Runnable
{
  AttachFolderListCursor$3(AttachFolderListCursor paramAttachFolderListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onRefreshComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListCursor.3
 * JD-Core Version:    0.7.0.1
 */