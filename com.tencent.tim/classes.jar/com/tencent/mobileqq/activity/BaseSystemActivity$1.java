package com.tencent.mobileqq.activity;

import android.widget.CursorAdapter;

class BaseSystemActivity$1
  implements Runnable
{
  BaseSystemActivity$1(BaseSystemActivity paramBaseSystemActivity) {}
  
  public void run()
  {
    if (this.this$0.a.getCursor() != null) {
      this.this$0.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseSystemActivity.1
 * JD-Core Version:    0.7.0.1
 */