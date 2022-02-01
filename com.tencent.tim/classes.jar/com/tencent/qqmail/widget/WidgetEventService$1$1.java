package com.tencent.qqmail.widget;

import com.tencent.qqmail.launcher.base.WelcomeLoader.Callback;
import com.tencent.qqmail.utilities.log.QMLog;

class WidgetEventService$1$1
  implements WelcomeLoader.Callback
{
  WidgetEventService$1$1(WidgetEventService.1 param1) {}
  
  public void finish()
  {
    QMLog.log(4, "WidgetEventService", "WelcomeLoader finish for widget");
    WidgetEventService.access$000(this.this$1.this$0, this.this$1.val$bundle, this.this$1.val$widgetEventFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetEventService.1.1
 * JD-Core Version:    0.7.0.1
 */