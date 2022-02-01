package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class ContactsOtherFragment$2
  implements UITableView.ClickListener
{
  ContactsOtherFragment$2(ContactsOtherFragment paramContactsOtherFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = new ContactsListFragment(1, 0, 0, ContactsOtherFragment.access$100(this.this$0));
    this.this$0.startFragment(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsOtherFragment.2
 * JD-Core Version:    0.7.0.1
 */