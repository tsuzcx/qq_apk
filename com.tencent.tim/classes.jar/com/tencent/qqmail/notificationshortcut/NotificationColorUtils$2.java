package com.tencent.qqmail.notificationshortcut;

import android.view.View;
import android.widget.TextView;
import java.util.List;

final class NotificationColorUtils$2
  implements NotificationColorUtils.Filter
{
  NotificationColorUtils$2(List paramList) {}
  
  public void filter(View paramView)
  {
    if ((paramView instanceof TextView)) {
      this.val$textViews.add((TextView)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.NotificationColorUtils.2
 * JD-Core Version:    0.7.0.1
 */