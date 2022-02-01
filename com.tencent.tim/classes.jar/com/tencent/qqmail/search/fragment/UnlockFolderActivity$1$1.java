package com.tencent.qqmail.search.fragment;

import android.widget.ImageView;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.ArrayList;
import java.util.HashMap;

class UnlockFolderActivity$1$1
  implements Runnable
{
  UnlockFolderActivity$1$1(UnlockFolderActivity.1 param1, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    UnlockFolderActivity.access$000(this.this$1.this$0).cancelDialog();
    UnlockFolderActivity.access$000(this.this$1.this$0).dismissTips();
    if (UnlockFolderActivity.access$100(this.this$1.this$0).containsKey(Integer.valueOf(this.val$accountId)))
    {
      ((UITableItemView)UnlockFolderActivity.access$100(this.this$1.this$0).get(Integer.valueOf(this.val$accountId))).getTailImage().setVisibility(0);
      while (i < UnlockFolderActivity.access$200(this.this$1.this$0).size())
      {
        if (((LockInfo)UnlockFolderActivity.access$200(this.this$1.this$0).get(i)).getAccountId() == this.val$accountId) {
          ((LockInfo)UnlockFolderActivity.access$200(this.this$1.this$0).get(i)).setUnLock(true);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.UnlockFolderActivity.1.1
 * JD-Core Version:    0.7.0.1
 */