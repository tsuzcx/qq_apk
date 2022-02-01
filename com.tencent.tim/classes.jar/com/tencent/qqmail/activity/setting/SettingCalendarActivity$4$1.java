package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import moai.oss.KvHelper;
import rx.functions.Action1;

class SettingCalendarActivity$4$1
  implements Action1<Boolean>
{
  SettingCalendarActivity$4$1(SettingCalendarActivity.4 param4, UITableItemView paramUITableItemView) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptCalendar(new double[0]);
      SharedPreferenceUtil.setSyncSystemCalendarTipCount(1);
      SettingCalendarActivity.access$700(this.this$1.this$0, this.val$itemView, true);
      return;
    }
    KvHelper.eventPermissionDenyCalendar(new double[0]);
    PermissionUtils.permissionWarn(this.this$1.this$0.getActivity(), 2131718902, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.4.1
 * JD-Core Version:    0.7.0.1
 */