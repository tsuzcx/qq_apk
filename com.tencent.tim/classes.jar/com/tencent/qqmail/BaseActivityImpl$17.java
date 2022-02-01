package com.tencent.qqmail;

import android.content.Intent;
import android.view.View;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Queue;

class BaseActivityImpl$17
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$17(BaseActivityImpl paramBaseActivityImpl, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Object localObject;
    if (this.this$0.canEnterOtherActivity())
    {
      localObject = QMActivityManager.shareInstance().getFirstInvisibleActivity();
      if ((localObject != null) && ((localObject instanceof CalendarFragmentActivity)))
      {
        QMBaseFragment localQMBaseFragment = CalendarFragmentActivity.getReadScheduleFragmentByReminderId(this.val$remindId);
        ((CalendarFragmentActivity)localObject).startFragment(localQMBaseFragment);
        if (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0)
        {
          QMRemindererBroadcast.calendarRemindIdQueue.remove();
          QMRemindererBroadcast.calendarSubjectQueue.remove();
        }
      }
    }
    for (;;)
    {
      paramQMUIDialog.dismiss();
      return;
      QMActivityManager.shareInstance().finishAllActivity();
      localObject = CalendarFragmentActivity.createIntentToReadSchedule(this.val$remindId);
      this.this$0.startActivity((Intent)localObject);
      break;
      if ((BaseActivityImpl.access$000(this.this$0) != null) && (BaseActivityImpl.access$000(this.this$0).getTopBar() != null) && (BaseActivityImpl.access$000(this.this$0).getTopBar().getButtonLeft() != null)) {
        BaseActivityImpl.access$000(this.this$0).getTopBar().getButtonLeft().performClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.17
 * JD-Core Version:    0.7.0.1
 */