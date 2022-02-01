package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;

class ContactsOtherFragment$3
  implements UITableView.ClickListener
{
  ContactsOtherFragment$3(ContactsOtherFragment paramContactsOtherFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt -= 1;
    if (paramInt < ContactsOtherFragment.access$200(this.this$0).size())
    {
      paramUITableItemView = (Account)ContactsOtherFragment.access$200(this.this$0).get(paramInt);
      if (paramUITableItemView != null)
      {
        paramUITableItemView = new ContactsListFragment(2, paramUITableItemView.getId(), 0, ContactsOtherFragment.access$100(this.this$0));
        this.this$0.startFragment(paramUITableItemView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsOtherFragment.3
 * JD-Core Version:    0.7.0.1
 */