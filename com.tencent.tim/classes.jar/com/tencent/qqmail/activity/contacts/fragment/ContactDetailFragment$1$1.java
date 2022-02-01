package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ContactDetailFragment$1$1
  implements QMUIDialogAction.ActionListener
{
  ContactDetailFragment$1$1(ContactDetailFragment.1 param1, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setData(Uri.parse("tel:" + this.val$phone));
    this.this$1.this$0.startActivity(localIntent);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.1.1
 * JD-Core Version:    0.7.0.1
 */