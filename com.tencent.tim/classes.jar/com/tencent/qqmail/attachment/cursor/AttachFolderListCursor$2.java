package com.tencent.qqmail.attachment.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class AttachFolderListCursor$2
  implements Runnable
{
  AttachFolderListCursor$2(AttachFolderListCursor paramAttachFolderListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onBeforeRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListCursor.2
 * JD-Core Version:    0.7.0.1
 */