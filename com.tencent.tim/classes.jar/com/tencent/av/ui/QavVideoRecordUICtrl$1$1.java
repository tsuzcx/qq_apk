package com.tencent.av.ui;

import iwu;
import java.lang.ref.WeakReference;
import jdh;

class QavVideoRecordUICtrl$1$1
  implements Runnable
{
  QavVideoRecordUICtrl$1$1(QavVideoRecordUICtrl.1 param1) {}
  
  public void run()
  {
    this.a.this$0.aur();
    if (((AVActivity)jdh.a(this.a.this$0).get()).mApp != null) {
      iwu.b(((AVActivity)jdh.a(this.a.this$0).get()).mApp, 1023, 2131697992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1.1
 * JD-Core Version:    0.7.0.1
 */