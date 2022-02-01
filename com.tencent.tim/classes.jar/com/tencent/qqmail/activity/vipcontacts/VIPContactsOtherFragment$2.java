package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class VIPContactsOtherFragment$2
  implements UITableView.ClickListener
{
  VIPContactsOtherFragment$2(VIPContactsOtherFragment paramVIPContactsOtherFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = new VIPContactsFragment(1, 0, 0);
    this.this$0.startFragmentForResult(paramUITableItemView, 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.2
 * JD-Core Version:    0.7.0.1
 */