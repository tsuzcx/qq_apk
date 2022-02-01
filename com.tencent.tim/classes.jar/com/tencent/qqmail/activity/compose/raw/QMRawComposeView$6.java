package com.tencent.qqmail.activity.compose.raw;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeCommUI.QMSendType;
import com.tencent.qqmail.activity.compose.ComposeViewCallback;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.richeditor.EditTextHelper;
import com.tencent.qqmail.utilities.richeditor.QMAudioSpan;
import com.tencent.qqmail.utilities.richeditor.QMEditText;

class QMRawComposeView$6
  implements View.OnTouchListener
{
  private boolean keyboardState;
  private int touchType = -1;
  private float y = 0.0F;
  
  QMRawComposeView$6(QMRawComposeView paramQMRawComposeView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.touchType = 0;
      this.y = paramMotionEvent.getY();
      this.keyboardState = QMRawComposeView.access$400(this.this$0);
    }
    while ((paramMotionEvent.getAction() == 2) && (Math.abs(paramMotionEvent.getY() - this.y) < 1.0F)) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 1) && (this.touchType == 0))
    {
      int j = EditTextHelper.getOffsetForPosition(QMRawComposeView.access$300(this.this$0), paramMotionEvent.getX(), paramMotionEvent.getY());
      paramView = QMRawComposeView.access$300(this.this$0).getText();
      Object localObject1 = (QMAudioSpan[])paramView.getSpans(0, paramView.length(), QMAudioSpan.class);
      int k = localObject1.length;
      int i = 0;
      Object localObject2;
      int m;
      int n;
      if (i < k)
      {
        localObject2 = localObject1[i];
        m = paramView.getSpanStart(localObject2);
        n = paramView.getSpanEnd(localObject2);
        if ((j >= m) && (j <= n))
        {
          paramMotionEvent.setAction(3);
          localObject2.setPlayState(true);
          QMRawComposeView.access$300(this.this$0).invalidate();
          QMRawComposeView.access$100(this.this$0).onClickAudioSpan(localObject2);
        }
      }
      else
      {
        localObject1 = (ImageSpan[])paramView.getSpans(0, paramView.length(), ImageSpan.class);
        k = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          localObject2 = localObject1[i];
          m = paramView.getSpanStart(localObject2);
          n = paramView.getSpanEnd(localObject2);
          int i1 = ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getWidth();
          if ((j >= m) && (j <= n) && (localObject2.getDrawable().getBounds().width() == i1 - 10) && (paramMotionEvent.getX() > i1 / 2)) {
            QMRawComposeView.access$300(this.this$0).postDelayed(new QMRawComposeView.6.1(this, n), 200L);
          }
        }
        else
        {
          if (QMRawComposeView.access$100(this.this$0) != null)
          {
            QMRawComposeView.access$502(this.this$0, 0);
            QMRawComposeView.access$100(this.this$0).onEditorClick();
          }
          if (QMRawComposeView.access$600(this.this$0) == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) {
            QMNotification.postNotification("focus_addr_edittext", Boolean.valueOf(false));
          }
          QMRawComposeView.access$300(this.this$0).postDelayed(new QMRawComposeView.6.2(this), 100L);
          return false;
          i += 1;
          break;
        }
        i += 1;
      }
    }
    this.touchType = -1;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.6
 * JD-Core Version:    0.7.0.1
 */