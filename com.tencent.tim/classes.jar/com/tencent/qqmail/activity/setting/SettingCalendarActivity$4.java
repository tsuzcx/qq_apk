package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;
import rx.Observable;

class SettingCalendarActivity$4
  implements UITableView.ClickListener
{
  SettingCalendarActivity$4(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingCalendarActivity.access$600(this.this$0))
    {
      if (!paramUITableItemView.isChecked()) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        RxPermissions.getInstance(this.this$0.getActivity()).request(new String[] { "android.permission.WRITE_CALENDAR" }).subscribe(new SettingCalendarActivity.4.1(this, paramUITableItemView));
        return;
      }
      if (SettingCalendarActivity.access$100(this.this$0).getDefaultAccountId() == 0)
      {
        SettingCalendarActivity.access$800(this.this$0, SettingCalendarActivity.access$100(this.this$0).getLocalAccount(), new SettingCalendarActivity.4.2(this, paramUITableItemView));
        return;
      }
      SettingCalendarActivity.access$700(this.this$0, paramUITableItemView, false);
      return;
    }
    paramInt -= 1;
    boolean bool = ((Boolean)SettingCalendarActivity.access$900(this.this$0).get(paramInt)).booleanValue();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(((Integer)SettingCalendarActivity.access$1000(this.this$0).get(paramInt)).intValue());
    if ((bool) && (localAccount != null) && (localAccount.getId() == SettingCalendarActivity.access$100(this.this$0).getDefaultAccountId()))
    {
      SettingCalendarActivity.access$800(this.this$0, localAccount, new SettingCalendarActivity.4.3(this, paramUITableItemView, paramInt));
      return;
    }
    SettingCalendarActivity.access$1100(this.this$0, paramUITableItemView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.4
 * JD-Core Version:    0.7.0.1
 */