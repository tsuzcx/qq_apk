package com.tencent.qqmail.calendar.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import moai.fragment.app.FragmentActivity;

class CalendarMainFragment$3
  implements View.OnClickListener
{
  CalendarMainFragment$3(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getActivity().getIntent().getBooleanExtra("fromCalendarShortcutAppFolderAndCalendarInAppFolder", false))
    {
      QMActivityManager.shareInstance().finishAllActivity();
      Intent localIntent = MailFragmentActivity.createIntentFromShortcut();
      localIntent.putExtra("fromCalendarShortcutAppFolderAndCalendarInAppFolder", true);
      this.this$0.startActivity(localIntent);
      this.this$0.overridePendingTransition(2130772421, 2130772420);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.3
 * JD-Core Version:    0.7.0.1
 */