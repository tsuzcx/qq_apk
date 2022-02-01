package com.tencent.qqmail.search.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AttachFolderSearchListFragment$12
  implements View.OnTouchListener
{
  AttachFolderSearchListFragment$12(AttachFolderSearchListFragment paramAttachFolderSearchListFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((AttachFolderSearchListFragment.access$1400(this.this$0) != null) && (AttachFolderSearchListFragment.access$1400(this.this$0) != paramView)) {
        AttachFolderSearchListFragment.access$1400(this.this$0).setSelected(false);
      }
      if (AttachFolderSearchListFragment.access$1400(this.this$0) != paramView)
      {
        AttachFolderSearchListFragment.access$1402(this.this$0, paramView);
        paramView.setSelected(true);
        if (AttachFolderSearchListFragment.access$800(this.this$0))
        {
          AttachFolderSearchListFragment.access$600(this.this$0);
          AttachFolderSearchListFragment.access$300(this.this$0, true);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment.12
 * JD-Core Version:    0.7.0.1
 */