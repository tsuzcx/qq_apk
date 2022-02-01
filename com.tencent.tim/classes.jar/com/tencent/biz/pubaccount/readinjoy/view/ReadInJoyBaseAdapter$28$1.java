package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import ndi;
import wja;

class ReadInJoyBaseAdapter$28$1
  implements Runnable
{
  ReadInJoyBaseAdapter$28$1(ReadInJoyBaseAdapter.28 param28, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "scroll " + this.val$pos + " to top");
    }
    View localView = this.a.this$0.a.getChildAt(this.val$pos - this.a.this$0.a.getFirstVisiblePosition());
    if (localView != null)
    {
      ndi.a(this.a.this$0).removeMessages(1001);
      this.a.this$0.a.smoothScrollBy(localView.getBottom() - wja.dp2px(175.0F, this.a.this$0.mContext.getResources()), 800);
      ndi.c(this.a.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28.1
 * JD-Core Version:    0.7.0.1
 */