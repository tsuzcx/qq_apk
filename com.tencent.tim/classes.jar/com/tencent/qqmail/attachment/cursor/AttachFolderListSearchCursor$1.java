package com.tencent.qqmail.attachment.cursor;

import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.model.mail.QMMailListCursor.IRunOnMainThreadWithContext;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

class AttachFolderListSearchCursor$1
  implements Runnable
{
  AttachFolderListSearchCursor$1(AttachFolderListSearchCursor paramAttachFolderListSearchCursor, Runnable paramRunnable) {}
  
  public void run()
  {
    if (AttachFolderListSearchCursor.access$000(this.this$0) != null)
    {
      AttachFolderListSearchCursor.access$102(this.this$0, AttachFolderListSearchCursor.access$200(this.this$0));
      AttachFolderListSearchCursor.access$302(this.this$0, AttachFolderListSearchCursor.access$400(this.this$0).attach.getSearchAttachIds(AttachFolderListSearchCursor.access$400(this.this$0).getReadableDatabase(), AttachFolderListSearchCursor.access$000(this.this$0)));
      AttachFolderListSearchCursor.access$600(this.this$0).runOnMainThreadWithContext(new AttachFolderListSearchCursor.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListSearchCursor.1
 * JD-Core Version:    0.7.0.1
 */