package com.tencent.qqmail.folderlist;

import android.view.View;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.SyncErrorActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.SyncErrorBar;
import com.tencent.qqmail.view.SyncErrorBar.onBarItemClickListener;
import moai.oss.KvHelper;

class FolderListFragment$15
  implements SyncErrorBar.onBarItemClickListener
{
  FolderListFragment$15(FolderListFragment paramFolderListFragment) {}
  
  public void onItemClick(View paramView)
  {
    int i = FolderListFragment.access$3300(this.this$0).getCode();
    QMLog.log(4, "FolderListFragment", "click sync error bar:" + i);
    if (i == 3)
    {
      KvHelper.syncUnauthClick(new double[0]);
      if ((FolderListFragment.access$2000(this.this$0).isQQMail()) || (FolderListFragment.access$2000(this.this$0).isGMail()))
      {
        paramView = LoginFragmentActivity.createIntentForVerifyPswError(FolderListFragment.access$2000(this.this$0).getId(), FolderListFragment.access$2000(this.this$0).getEmail());
        this.this$0.startActivity(paramView);
        return;
      }
      paramView = LoginFragmentActivity.createIntentForSettingProtocol(FolderListFragment.access$2000(this.this$0).getId(), true);
      this.this$0.startActivity(paramView);
      return;
    }
    paramView = SyncErrorActivity.createIntent(this.this$0.getActivity(), i);
    this.this$0.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.15
 * JD-Core Version:    0.7.0.1
 */