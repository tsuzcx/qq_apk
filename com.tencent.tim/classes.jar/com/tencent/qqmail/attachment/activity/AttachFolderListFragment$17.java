package com.tencent.qqmail.attachment.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AttachFolderListFragment$17
  implements View.OnTouchListener
{
  AttachFolderListFragment$17(AttachFolderListFragment paramAttachFolderListFragment, boolean[] paramArrayOfBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() & 0xFF) == 1) && (this.val$hasLongClick[0] != 0))
    {
      this.val$hasLongClick[0] = false;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.17
 * JD-Core Version:    0.7.0.1
 */