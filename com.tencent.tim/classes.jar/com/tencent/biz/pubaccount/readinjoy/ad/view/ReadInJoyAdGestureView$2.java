package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.qphone.base.util.QLog;
import knd;

class ReadInJoyAdGestureView$2
  implements Runnable
{
  ReadInJoyAdGestureView$2(ReadInJoyAdGestureView paramReadInJoyAdGestureView, String paramString) {}
  
  public void run()
  {
    try
    {
      ReadInJoyAdGestureView.a(this.this$0, knd.j(this.val$url, (int)this.this$0.iR, (int)this.this$0.iS));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdGestureView", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView.2
 * JD-Core Version:    0.7.0.1
 */