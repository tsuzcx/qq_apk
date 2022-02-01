package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class AccountListFragment$26$1
  implements Action1<Boolean>
{
  AccountListFragment$26$1(AccountListFragment.26 param26) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptCalendar(new double[0]);
      paramBoolean = CalendarFragmentActivity.createIntent();
      this.this$1.this$0.startActivity(paramBoolean);
      return;
    }
    KvHelper.eventPermissionDenyCalendar(new double[0]);
    PermissionUtils.permissionWarn(this.this$1.this$0.getActivity(), 2131718902, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.26.1
 * JD-Core Version:    0.7.0.1
 */