package com.tencent.qqmail.activity.qrcode;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QrCodeInfoActivity$3
  implements View.OnTouchListener
{
  QrCodeInfoActivity$3(QrCodeInfoActivity paramQrCodeInfoActivity, GestureDetector paramGestureDetector) {}
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.val$detector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.qrcode.QrCodeInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */