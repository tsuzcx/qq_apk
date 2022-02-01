package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;

class CalendarChooseAccountFragment$2
  implements UITableView.ClickListener
{
  CalendarChooseAccountFragment$2(CalendarChooseAccountFragment paramCalendarChooseAccountFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    Account localAccount = (Account)CalendarChooseAccountFragment.access$000(this.this$0).get(paramInt);
    String str = QMComposeDataManager.sharedInstance().getQMDefaultAlias(localAccount.getId());
    paramUITableItemView = str;
    if (StringExtention.isNullOrEmpty(str)) {
      paramUITableItemView = localAccount.getEmail();
    }
    CalendarChooseAccountFragment.access$200(this.this$0, localAccount.getId(), CalendarChooseAccountFragment.access$100(this.this$0), paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarChooseAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */