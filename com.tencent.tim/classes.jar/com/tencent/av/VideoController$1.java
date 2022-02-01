package com.tencent.av;

import android.content.Context;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;
import igy;
import iiv;

public class VideoController$1
  implements Runnable
{
  VideoController$1(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.TAG, 2, "networkBrokenRunnable");
    }
    if (this.this$0.sw())
    {
      Context localContext = this.this$0.getAppContext();
      PopupDialog.b(localContext, 230, null, localContext.getString(2131721704), 0, 2131721737, new igy(this), null);
    }
    for (;;)
    {
      VideoController.a(this.this$0, false);
      return;
      if ((this.this$0.b().state > 0) && (this.this$0.b().state <= 4))
      {
        this.this$0.O(this.this$0.b().peerUin, 215);
        this.this$0.ko(215);
        this.this$0.P(this.this$0.b().peerUin, 9);
      }
      else
      {
        this.this$0.a(this.this$0.alr, this.this$0.kJ, 15, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.1
 * JD-Core Version:    0.7.0.1
 */