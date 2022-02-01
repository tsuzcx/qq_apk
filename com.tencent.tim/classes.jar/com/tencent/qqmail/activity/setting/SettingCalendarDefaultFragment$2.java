package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

class SettingCalendarDefaultFragment$2
  implements QMRadioGroup.OnCheckedChangeListener
{
  SettingCalendarDefaultFragment$2(SettingCalendarDefaultFragment paramSettingCalendarDefaultFragment) {}
  
  public void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt)
  {
    SettingCalendarDefaultFragment.access$102(this.this$0, paramInt);
    paramQMRadioGroup = SettingCalendarDefaultFragment.access$200(this.this$0).iterator();
    while (paramQMRadioGroup.hasNext()) {
      ((QMRadioGroup)paramQMRadioGroup.next()).resetSelectdItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultFragment.2
 * JD-Core Version:    0.7.0.1
 */