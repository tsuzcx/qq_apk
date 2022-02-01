package com.tencent.qqmail.search.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;

class AttachFolderSearchListFragment$7
  implements TextWatcher
{
  AttachFolderSearchListFragment$7(AttachFolderSearchListFragment paramAttachFolderSearchListFragment, ImageButton paramImageButton) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    String str = AttachFolderSearchListFragment.access$500(this.this$0);
    AttachFolderSearchListFragment.access$502(this.this$0, paramCharSequence.toString());
    AttachFolderSearchListFragment.access$700(this.this$0, new AttachFolderSearchListFragment.7.1(this));
    if (AttachFolderSearchListFragment.access$500(this.this$0).length() > 0) {
      this.val$mSearchBarCleaner.setVisibility(0);
    }
    for (;;)
    {
      paramCharSequence = this.this$0;
      boolean bool1;
      if (AttachFolderSearchListFragment.access$500(this.this$0).length() <= 0)
      {
        bool1 = bool2;
        if (str != null)
        {
          bool1 = bool2;
          if (str.length() == 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      AttachFolderSearchListFragment.access$802(paramCharSequence, bool1);
      return;
      this.val$mSearchBarCleaner.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment.7
 * JD-Core Version:    0.7.0.1
 */