package com.tencent.qqmail.search.fragment;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderSearchListFragment$4
  implements View.OnClickListener
{
  AttachFolderSearchListFragment$4(AttachFolderSearchListFragment paramAttachFolderSearchListFragment) {}
  
  public void onClick(View paramView)
  {
    Editable localEditable = AttachFolderSearchListFragment.access$200(this.this$0).getText();
    Selection.setSelection(localEditable, localEditable.length());
    AttachFolderSearchListFragment.access$200(this.this$0).setText("");
    AttachFolderSearchListFragment.access$300(this.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment.4
 * JD-Core Version:    0.7.0.1
 */