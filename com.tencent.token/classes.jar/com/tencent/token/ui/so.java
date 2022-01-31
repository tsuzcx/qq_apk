package com.tencent.token.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.token.core.bean.SafeMsgItem;

class so
  implements View.OnTouchListener
{
  so(sn paramsn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131558539);
    TextView localTextView2 = (TextView)paramView.findViewById(2131558540);
    TextView localTextView3 = (TextView)paramView.findViewById(2131558541);
    SafeMsgItem localSafeMsgItem = (SafeMsgItem)paramView.getTag();
    if ((localSafeMsgItem.b() & 0x80) == 128) {}
    for (int i = 1;; i = 0) {
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      }
    }
    localTextView1.setTextColor(this.a.e);
    localTextView2.setTextColor(this.a.e);
    localTextView3.setTextColor(this.a.e);
    return false;
    if (paramView.isPressed())
    {
      localTextView1.setTextColor(this.a.e);
      localTextView2.setTextColor(this.a.e);
      localTextView3.setTextColor(this.a.e);
      return false;
    }
    if ((localSafeMsgItem != null) && (!localSafeMsgItem.mIsRead))
    {
      if (i != 0) {
        localTextView1.setTextColor(this.a.g);
      }
      for (;;)
      {
        localTextView3.setTextColor(this.a.c);
        localTextView2.setTextColor(this.a.d);
        return false;
        localTextView1.setTextColor(this.a.c);
      }
    }
    localTextView1.setTextColor(this.a.f);
    localTextView3.setTextColor(this.a.f);
    localTextView2.setTextColor(this.a.f);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.so
 * JD-Core Version:    0.7.0.1
 */