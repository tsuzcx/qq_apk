package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$30
  implements QMUnlockFolderPwdWatcher
{
  ReadMailFragment$30(ReadMailFragment paramReadMailFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2)
  {
    if ((!ReadMailFragment.access$9400(this.this$0)) && (FolderLockDialog.isFolderLock(ReadMailFragment.access$000(this.this$0).getInformation().getFolderId())) && (ReadMailFragment.access$2400(this.this$0) != null)) {
      ReadMailFragment.access$2400(this.this$0).setStatus(5);
    }
    ReadMailFragment.access$9402(this.this$0, false);
    if (ReadMailFragment.access$2400(this.this$0) != null) {
      KeyBoardHelper.hideKeyBoard(ReadMailFragment.access$2400(this.this$0));
    }
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    ReadMailFragment.access$9300(this.this$0, new ReadMailFragment.30.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    ReadMailFragment.access$9200(this.this$0, new ReadMailFragment.30.1(this, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.30
 * JD-Core Version:    0.7.0.1
 */