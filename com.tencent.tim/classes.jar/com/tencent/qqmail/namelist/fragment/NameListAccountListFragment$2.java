package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;

class NameListAccountListFragment$2
  implements UITableView.ClickListener
{
  NameListAccountListFragment$2(NameListAccountListFragment paramNameListAccountListFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (NameListAccountListFragment.access$000(this.this$0) == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (paramUITableItemView = NameListAccountListFragment.access$100(this.this$0).get(paramInt);; paramUITableItemView = (Account)NameListAccountListFragment.access$200(this.this$0).get(paramInt))
    {
      paramUITableItemView = new NameListMainFragment(paramUITableItemView.getId(), NameListAccountListFragment.access$000(this.this$0));
      this.this$0.startFragment(paramUITableItemView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAccountListFragment.2
 * JD-Core Version:    0.7.0.1
 */