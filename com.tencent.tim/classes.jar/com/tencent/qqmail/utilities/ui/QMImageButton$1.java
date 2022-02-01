package com.tencent.qqmail.utilities.ui;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QMImageButton$1
  implements View.OnTouchListener
{
  QMImageButton$1(QMImageButton paramQMImageButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.this$0.isEnabled()) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      this.this$0.setBackgroundResource(QMImageButton.access$000(this.this$0));
      this.this$0.setImageDrawable(this.this$0.getResources().getDrawable(QMImageButton.access$100(this.this$0)));
      continue;
      if (!this.this$0.isPressed())
      {
        this.this$0.setBackgroundResource(QMImageButton.access$200(this.this$0));
        this.this$0.setImageDrawable(this.this$0.getResources().getDrawable(QMImageButton.access$300(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMImageButton.1
 * JD-Core Version:    0.7.0.1
 */