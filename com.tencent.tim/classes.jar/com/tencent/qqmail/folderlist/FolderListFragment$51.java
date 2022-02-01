package com.tencent.qqmail.folderlist;

import android.content.Intent;
import com.tencent.qqmail.activity.setting.SettingActivity;
import com.tencent.qqmail.activity.setting.SettingCacheClearActivity.ClickRemindClearCache;

class FolderListFragment$51
  implements SettingCacheClearActivity.ClickRemindClearCache
{
  FolderListFragment$51(FolderListFragment paramFolderListFragment) {}
  
  public void click()
  {
    Intent localIntent = SettingActivity.createIntentToClearCache("from_account_list");
    this.this$0.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.51
 * JD-Core Version:    0.7.0.1
 */