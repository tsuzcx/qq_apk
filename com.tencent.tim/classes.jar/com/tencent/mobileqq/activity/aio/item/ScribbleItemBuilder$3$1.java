package com.tencent.mobileqq.activity.aio.item;

import arht;
import com.tencent.qphone.base.util.QLog;
import xmo;

public class ScribbleItemBuilder$3$1
  implements Runnable
{
  public ScribbleItemBuilder$3$1(xmo paramxmo, arht paramarht) {}
  
  public void run()
  {
    this.c.setVisible(false, true);
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] set ProgressPieDrawable invisible,ppd = " + this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1
 * JD-Core Version:    0.7.0.1
 */