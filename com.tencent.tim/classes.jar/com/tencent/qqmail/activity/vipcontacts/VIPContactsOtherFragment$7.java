package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;

class VIPContactsOtherFragment$7
  implements UITableView.ClickListener
{
  VIPContactsOtherFragment$7(VIPContactsOtherFragment paramVIPContactsOtherFragment, ArrayList paramArrayList) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt -= 1;
    if (paramInt < this.val$groups.size())
    {
      paramUITableItemView = (ContactGroup)this.val$groups.get(paramInt);
      if (paramUITableItemView != null)
      {
        paramUITableItemView = new VIPContactsFragment(3, paramUITableItemView.getAccountId(), paramUITableItemView.getId());
        this.this$0.startFragmentForResult(paramUITableItemView, 500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.7
 * JD-Core Version:    0.7.0.1
 */