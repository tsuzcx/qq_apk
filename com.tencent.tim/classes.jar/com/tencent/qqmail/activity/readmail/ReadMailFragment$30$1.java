package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.NoteSender;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.view.FolderLockDialog;

class ReadMailFragment$30$1
  implements Runnable
{
  ReadMailFragment$30$1(ReadMailFragment.30 param30, int paramInt) {}
  
  public void run()
  {
    ReadMailFragment.access$9000(this.this$1.this$0).cancelDialog();
    ReadMailFragment.access$9000(this.this$1.this$0).dismissTips();
    if (this.val$folderId == -4)
    {
      QMNotification.registNotification("save_mail_as_note_done", this.this$1.this$0.mSaveMailSucc);
      Toast.makeText(QMApplicationContext.sharedInstance(), this.this$1.this$0.getString(2131718967), 0).show();
      new NoteSender(ReadMailFragment.access$400(this.this$1.this$0), "", "", "folder").buildData();
      return;
    }
    ReadMailFragment.access$9100(this.this$1.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.30.1
 * JD-Core Version:    0.7.0.1
 */