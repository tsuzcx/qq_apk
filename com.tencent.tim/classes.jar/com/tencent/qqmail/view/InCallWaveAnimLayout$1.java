package com.tencent.qqmail.view;

import android.os.Handler;
import android.os.Message;

class InCallWaveAnimLayout$1
  extends Handler
{
  private boolean mPaused = false;
  
  InCallWaveAnimLayout$1(InCallWaveAnimLayout paramInCallWaveAnimLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      if (this.mPaused)
      {
        InCallWaveAnimLayout.access$002(this.this$0, 0);
        return;
      }
      InCallWaveAnimLayout.access$002(this.this$0, InCallWaveAnimLayout.access$100(this.this$0) * 2);
      InCallWaveAnimLayout.access$200(this.this$0);
      return;
    }
    this.mPaused = true;
    InCallWaveAnimLayout.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.InCallWaveAnimLayout.1
 * JD-Core Version:    0.7.0.1
 */