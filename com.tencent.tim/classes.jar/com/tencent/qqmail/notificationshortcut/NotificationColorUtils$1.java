package com.tencent.qqmail.notificationshortcut;

import android.view.View;
import android.widget.TextView;

final class NotificationColorUtils$1
  implements NotificationColorUtils.Filter
{
  public void filter(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ("notification_title".equals(paramView.getText().toString())) {
        NotificationColorUtils.access$002(paramView.getCurrentTextColor());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.NotificationColorUtils.1
 * JD-Core Version:    0.7.0.1
 */