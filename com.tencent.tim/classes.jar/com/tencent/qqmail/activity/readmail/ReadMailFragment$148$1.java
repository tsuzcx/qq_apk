package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$148$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$148$1(ReadMailFragment.148 param148) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$1.this$0.getString(2131692000)))
    {
      paramView = ContactsFragmentActivity.createContactCreateIntent("", this.this$1.val$mailAddress);
      this.this$1.this$0.startActivity(paramView);
      paramQMBottomDialog.dismiss();
    }
    while (!paramString.equals(this.this$1.this$0.getString(2131692008))) {
      return;
    }
    paramView = ContactsFragmentActivity.createUpdateListIntent(ReadMailFragment.access$200(this.this$1.this$0), this.this$1.val$mailAddress);
    this.this$1.this$0.startActivity(paramView);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.148.1
 * JD-Core Version:    0.7.0.1
 */