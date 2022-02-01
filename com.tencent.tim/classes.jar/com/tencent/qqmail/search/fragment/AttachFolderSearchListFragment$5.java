package com.tencent.qqmail.search.fragment;

import android.text.Editable;
import android.text.Selection;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class AttachFolderSearchListFragment$5
  implements View.OnTouchListener
{
  AttachFolderSearchListFragment$5(AttachFolderSearchListFragment paramAttachFolderSearchListFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = AttachFolderSearchListFragment.access$200(this.this$0).getText();
      Selection.setSelection(paramView, paramView.length());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment.5
 * JD-Core Version:    0.7.0.1
 */