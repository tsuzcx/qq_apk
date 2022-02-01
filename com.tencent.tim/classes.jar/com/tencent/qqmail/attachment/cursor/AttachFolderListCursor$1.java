package com.tencent.qqmail.attachment.cursor;

import android.database.Cursor;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.Callable;

class AttachFolderListCursor$1
  implements Callable<Cursor>
{
  AttachFolderListCursor$1(AttachFolderListCursor paramAttachFolderListCursor, Cursor paramCursor) {}
  
  public Cursor call()
  {
    Cursor localCursor = AttachFolderListCursor.access$000(this.this$0);
    if (localCursor != null) {
      localCursor.getCount();
    }
    Threads.runOnMainThread(new AttachFolderListCursor.1.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListCursor.1
 * JD-Core Version:    0.7.0.1
 */