package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;

class VIPContactsOtherFragment$3
  implements UITableView.ClickListener
{
  VIPContactsOtherFragment$3(VIPContactsOtherFragment paramVIPContactsOtherFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt -= 1;
    if (paramInt < VIPContactsOtherFragment.access$100(this.this$0).size())
    {
      paramUITableItemView = (Account)VIPContactsOtherFragment.access$100(this.this$0).get(paramInt);
      if (paramUITableItemView != null)
      {
        paramUITableItemView = new VIPContactsFragment(2, paramUITableItemView.getId(), 0);
        this.this$0.startFragmentForResult(paramUITableItemView, 500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.3
 * JD-Core Version:    0.7.0.1
 */