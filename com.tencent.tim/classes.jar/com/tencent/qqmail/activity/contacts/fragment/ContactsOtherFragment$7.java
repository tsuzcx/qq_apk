package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;

class ContactsOtherFragment$7
  implements UITableView.ClickListener
{
  ContactsOtherFragment$7(ContactsOtherFragment paramContactsOtherFragment, ArrayList paramArrayList) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt -= 1;
    if (paramInt < this.val$groups.size())
    {
      paramUITableItemView = (ContactGroup)this.val$groups.get(paramInt);
      if (paramUITableItemView != null)
      {
        paramUITableItemView = new ContactsListFragment(3, paramUITableItemView.getAccountId(), paramUITableItemView.getId(), ContactsOtherFragment.access$100(this.this$0));
        this.this$0.startFragment(paramUITableItemView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsOtherFragment.7
 * JD-Core Version:    0.7.0.1
 */