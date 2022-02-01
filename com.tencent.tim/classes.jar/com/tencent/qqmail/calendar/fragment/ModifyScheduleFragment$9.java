package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ModifyScheduleFragment$9
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ModifyScheduleFragment$9(ModifyScheduleFragment paramModifyScheduleFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    if (this.val$fragmentRootView.getRootView().getHeight() - this.val$fragmentRootView.getHeight() > 100) {
      if (!ModifyScheduleFragment.access$1700(this.this$0))
      {
        ModifyScheduleFragment.access$1702(this.this$0, true);
        ModifyScheduleFragment.access$1800(this.this$0, true);
      }
    }
    while (!ModifyScheduleFragment.access$1700(this.this$0)) {
      return;
    }
    ModifyScheduleFragment.access$1702(this.this$0, false);
    ModifyScheduleFragment.access$1800(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.9
 * JD-Core Version:    0.7.0.1
 */