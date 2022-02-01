package com.tencent.mobileqq.activity.qwallet.fragment;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

final class QzoneHbFragment$8
  implements Runnable
{
  QzoneHbFragment$8(EditText paramEditText) {}
  
  public void run()
  {
    MotionEvent localMotionEvent1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0F, 0.0F, 0);
    this.ba.dispatchTouchEvent(localMotionEvent1);
    MotionEvent localMotionEvent2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0);
    this.ba.dispatchTouchEvent(localMotionEvent2);
    localMotionEvent1.recycle();
    localMotionEvent2.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment.8
 * JD-Core Version:    0.7.0.1
 */