package com.tencent.qqmail.widget;

import android.os.Bundle;
import com.tencent.qqmail.launcher.base.WelcomeLoader;

class WidgetEventService$1
  implements Runnable
{
  WidgetEventService$1(WidgetEventService paramWidgetEventService, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    if (WelcomeLoader.getInstance().isFinish())
    {
      WidgetEventService.access$000(this.this$0, this.val$bundle, this.val$widgetEventFrom);
      return;
    }
    WelcomeLoader.getInstance().registerCallback(new WidgetEventService.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetEventService.1
 * JD-Core Version:    0.7.0.1
 */