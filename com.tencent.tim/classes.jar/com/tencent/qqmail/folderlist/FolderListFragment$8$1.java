package com.tencent.qqmail.folderlist;

import android.content.Intent;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment.NullFolderException;
import com.tencent.qqmail.maillist.view.MailListBarHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.fragment.base.BaseFragment;

class FolderListFragment$8$1
  implements Runnable
{
  FolderListFragment$8$1(FolderListFragment.8 param8, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    FolderListFragment.access$100(this.this$1.this$0).cancelDialog();
    FolderListFragment.access$100(this.this$1.this$0).dismissTips();
    Object localObject;
    if (this.val$fid == -4)
    {
      if (FolderListFragment.access$400(this.this$1.this$0)) {}
      for (localObject = ComposeNoteActivity.createIntentFromFolderList();; localObject = NoteListActivity.createIntent())
      {
        this.this$1.this$0.startActivity((Intent)localObject);
        return;
      }
    }
    try
    {
      localObject = QMFolderManager.sharedInstance().getFolder(this.val$folderId);
      if (FolderListFragment.access$800(this.this$1.this$0).getChildPositionByFolderId(FolderListFragment.access$000(this.this$1.this$0), this.val$folderId) > FolderListFragment.access$600(this.this$1.this$0)) {
        MailListBarHelper.isNeedFolderTopTip((QMFolder)localObject, FolderListFragment.access$200(this.this$1.this$0), FolderListFragment.access$700(this.this$1.this$0));
      }
      MailListBarHelper.isNeedFolderShowHomeTip((QMFolder)localObject, FolderListFragment.access$200(this.this$1.this$0), FolderListFragment.access$700(this.this$1.this$0), FolderListFragment.access$800(this.this$1.this$0).isShowHomeFolderId((QMFolder)localObject));
      localObject = new MailListFragment(this.val$aid, this.val$fid);
      this.this$1.this$0.startFragment((BaseFragment)localObject);
    }
    catch (MailListFragment.NullFolderException localNullFolderException)
    {
      label215:
      break label215;
    }
    DataCollector.logPerformanceBegin("Performance_Click_Maillist", this.val$accountId, "Performance_Click_Maillist" + this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.8.1
 * JD-Core Version:    0.7.0.1
 */