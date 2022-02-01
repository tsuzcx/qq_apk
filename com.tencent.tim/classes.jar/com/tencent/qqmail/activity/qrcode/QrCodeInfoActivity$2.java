package com.tencent.qqmail.activity.qrcode;

import android.text.Selection;
import android.text.Spannable;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class QrCodeInfoActivity$2
  implements GestureDetector.OnGestureListener
{
  QrCodeInfoActivity$2(QrCodeInfoActivity paramQrCodeInfoActivity) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = QrCodeInfoActivity.access$100(this.this$0).getText();
    if ((paramMotionEvent instanceof Spannable)) {
      Selection.selectAll((Spannable)paramMotionEvent);
    }
    QrCodeInfoActivity.access$100(this.this$0).hideCuror();
    QrCodeInfoActivity.access$100(this.this$0).showCursor();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    QrCodeInfoActivity.access$000(this.this$0);
    QrCodeInfoActivity.access$100(this.this$0).hideCuror();
    paramMotionEvent = QrCodeInfoActivity.access$100(this.this$0).getText();
    if ((paramMotionEvent instanceof Spannable)) {
      Selection.removeSelection((Spannable)paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.qrcode.QrCodeInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */