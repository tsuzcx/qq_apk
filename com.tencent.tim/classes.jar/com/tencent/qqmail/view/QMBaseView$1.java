package com.tencent.qqmail.view;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class QMBaseView$1
  implements TextView.OnEditorActionListener
{
  QMBaseView$1(QMBaseView paramQMBaseView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 3) || (paramInt == 6) || (paramKeyEvent == null) || ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 66))) && ((paramKeyEvent == null) || (!paramKeyEvent.isShiftPressed())))
    {
      QMBaseView.access$002(this.this$0, false);
      QMBaseView.access$100(this.this$0).onComplete();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMBaseView.1
 * JD-Core Version:    0.7.0.1
 */