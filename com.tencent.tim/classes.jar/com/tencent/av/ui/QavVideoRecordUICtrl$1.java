package com.tencent.av.ui;

import android.os.Handler;
import jdh;
import jgn;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(jdh paramjdh) {}
  
  public void run()
  {
    jdh.a(this.this$0, this.this$0.bP());
    jdh.b(this.this$0, jgn.bS());
    if (jdh.a(this.this$0) < 31457280L) {
      jdh.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!jdh.XP) {
      return;
    }
    jdh.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */