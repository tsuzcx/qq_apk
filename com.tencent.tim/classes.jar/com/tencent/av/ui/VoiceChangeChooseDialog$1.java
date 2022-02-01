package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import jfo;

public class VoiceChangeChooseDialog$1
  implements Runnable
{
  public void run()
  {
    if ((jfo.a(this.this$0) == 1) && (!this.this$0.YS))
    {
      this.this$0.mTitleText.setText(2131698190);
      jfo.a(this.this$0, 2);
      this.this$0.a.b().Rl = true;
      this.this$0.mHandler.postDelayed(this.this$0.mRunnable, 10000L);
    }
    while (jfo.a(this.this$0) != 2) {
      return;
    }
    this.this$0.mTitleText.setText(2131698192);
    jfo.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.1
 * JD-Core Version:    0.7.0.1
 */