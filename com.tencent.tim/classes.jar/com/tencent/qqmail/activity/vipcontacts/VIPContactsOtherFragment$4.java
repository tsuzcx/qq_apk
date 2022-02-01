package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;

class VIPContactsOtherFragment$4
  implements UITableView.ClickListener
{
  VIPContactsOtherFragment$4(VIPContactsOtherFragment paramVIPContactsOtherFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt -= 1;
    if (paramInt < VIPContactsOtherFragment.access$200(this.this$0).size())
    {
      paramUITableItemView = (ContactGroup)VIPContactsOtherFragment.access$200(this.this$0).get(paramInt);
      if (paramUITableItemView != null)
      {
        paramUITableItemView = new VIPContactsFragment(3, paramUITableItemView.getAccountId(), paramUITableItemView.getId());
        this.this$0.startFragmentForResult(paramUITableItemView, 500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.4
 * JD-Core Version:    0.7.0.1
 */