package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderListFragment$8
  implements View.OnClickListener
{
  AttachFolderListFragment$8(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AttachFolderListFragment.access$1200(this.this$0)) {
      this.this$0.popBackStack();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AttachFolderListFragment.access$1300(this.this$0))
      {
        AttachFolderListFragment localAttachFolderListFragment = this.this$0;
        if (!this.this$0.isSelectAll()) {}
        for (boolean bool = true;; bool = false)
        {
          AttachFolderListFragment.access$1400(localAttachFolderListFragment, bool);
          break;
        }
      }
      this.this$0.popBackStack();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.8
 * JD-Core Version:    0.7.0.1
 */