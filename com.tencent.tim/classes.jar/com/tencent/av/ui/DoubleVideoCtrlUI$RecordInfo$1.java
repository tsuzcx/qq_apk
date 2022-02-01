package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;

class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  DoubleVideoCtrlUI$RecordInfo$1(DoubleVideoCtrlUI.a parama) {}
  
  public void run()
  {
    int i = 2130843051;
    if ((DoubleVideoCtrlUI.a.a(this.this$0) == null) || (DoubleVideoCtrlUI.a.a(this.this$0) == null) || (DoubleVideoCtrlUI.a.a(this.this$0).mControlUI == null)) {}
    while (DoubleVideoCtrlUI.a.a(this.this$0) != 1) {
      return;
    }
    DoubleVideoCtrlUI.a.b(this.this$0);
    if (DoubleVideoCtrlUI.a.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (DoubleVideoCtrlUI.a.c(this.this$0) == 1) {
        i = 2130843052;
      }
      DoubleVideoCtrlUI.a.a((DoubleVideoCtrlUI.a)localObject, i);
      DoubleVideoCtrlUI.a.a(this.this$0).mControlUI.O(-1025L, 65535);
      DoubleVideoCtrlUI.a.a(this.this$0).getHandler().postDelayed(this.this$0.bP, 1000L);
      return;
    }
    DoubleVideoCtrlUI.a.b(this.this$0, 2);
    DoubleVideoCtrlUI.a.a(this.this$0, 2130843051);
    DoubleVideoCtrlUI.a.a(this.this$0).mControlUI.O(-1026L, 65535);
    Object localObject = (QavRecordButtonView)DoubleVideoCtrlUI.a.a(this.this$0).findViewById(2131376957);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    DoubleVideoCtrlUI.a.a(this.this$0).l(new Object[] { Integer.valueOf(8001), "OnRecord" });
    DoubleVideoCtrlUI.a.c(this.this$0, 0);
    DoubleVideoCtrlUI.a.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */