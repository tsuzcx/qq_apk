package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ContactDetailFragment$11$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ContactDetailFragment$11$1(ContactDetailFragment.11 param11) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$1.this$0.getString(2131692000)))
    {
      paramView = new ContactEditFragment(ContactDetailFragment.access$100(this.this$1.this$0), ContactDetailFragment.access$100(this.this$1.this$0), true, this.this$1.this$0.from);
      this.this$1.this$0.startFragmentForResult(paramView, 100);
      paramQMBottomDialog.dismiss();
    }
    while (!paramString.equals(this.this$1.this$0.getString(2131692008))) {
      return;
    }
    paramView = new ContactsListFragment(ContactDetailFragment.access$100(this.this$1.this$0));
    this.this$1.this$0.startFragmentForResult(paramView, 100);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.11.1
 * JD-Core Version:    0.7.0.1
 */