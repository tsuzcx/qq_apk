package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ContactEditFragment$8
  implements QMUIDialogAction.ActionListener
{
  ContactEditFragment$8(ContactEditFragment paramContactEditFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.this$0.getBaseFragmentActivity() != null) {
      this.this$0.popBackStack();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.8
 * JD-Core Version:    0.7.0.1
 */