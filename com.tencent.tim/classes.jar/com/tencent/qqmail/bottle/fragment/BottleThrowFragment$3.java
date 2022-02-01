package com.tencent.qqmail.bottle.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

class BottleThrowFragment$3
  extends Handler
{
  private int index = 0;
  
  BottleThrowFragment$3(BottleThrowFragment paramBottleThrowFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = new String[4];
    paramMessage[0] = "";
    paramMessage[1] = ".";
    paramMessage[2] = "..";
    paramMessage[3] = "...";
    TextView localTextView = BottleThrowFragment.access$400(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder().append(BottleThrowFragment.access$300(this.this$0));
    int i = this.index;
    this.index = (i + 1);
    localTextView.setText(paramMessage[(i % paramMessage.length)]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.3
 * JD-Core Version:    0.7.0.1
 */