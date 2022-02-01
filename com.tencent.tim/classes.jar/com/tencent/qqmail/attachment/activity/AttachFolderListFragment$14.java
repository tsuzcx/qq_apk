package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment;

class AttachFolderListFragment$14
  implements View.OnClickListener
{
  AttachFolderListFragment$14(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    AttachFolderSearchListFragment localAttachFolderSearchListFragment = new AttachFolderSearchListFragment(AttachFolderListFragment.access$1900(this.this$0), AttachFolderListFragment.access$2000(this.this$0), AttachFolderListFragment.access$000(this.this$0).getItemIds());
    this.this$0.startFragment(localAttachFolderSearchListFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.14
 * JD-Core Version:    0.7.0.1
 */