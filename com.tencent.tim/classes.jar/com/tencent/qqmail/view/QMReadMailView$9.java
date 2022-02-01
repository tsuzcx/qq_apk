package com.tencent.qqmail.view;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

class QMReadMailView$9
  implements DropdownWebViewLayout.OnPullListener
{
  private boolean statusReleaseToReply;
  
  QMReadMailView$9(QMReadMailView paramQMReadMailView) {}
  
  public void onPullStatus(boolean paramBoolean)
  {
    TextView localTextView;
    if ((QMReadMailView.access$800(this.this$0)) && (QMReadMailView.access$900(this.this$0) != 2) && (QMReadMailView.access$900(this.this$0) != 6) && (paramBoolean != this.statusReleaseToReply))
    {
      this.statusReleaseToReply = paramBoolean;
      localTextView = (TextView)QMReadMailView.access$400(this.this$0).findViewById(2131373842);
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 2131718734;; i = 2131697499)
    {
      localTextView.setText(i);
      QMReadMailView.access$1000(this.this$0, this.statusReleaseToReply);
      return;
    }
  }
  
  public int onPulled(View paramView, WebView paramWebView, int paramInt)
  {
    int i = 0;
    paramInt = i;
    if (QMReadMailView.access$800(this.this$0))
    {
      paramInt = i;
      if (QMReadMailView.access$900(this.this$0) != 2)
      {
        paramInt = i;
        if (QMReadMailView.access$900(this.this$0) != 6)
        {
          if (QMReadMailView.access$1100(this.this$0))
          {
            QMReadMailView.access$1200(this.this$0);
            QMReadMailView.access$400(this.this$0).setAbleToPull(false);
          }
          if (QMReadMailView.access$700(this.this$0) != null) {
            QMReadMailView.access$700(this.this$0).onQuickReply();
          }
          paramInt = i;
          if (QMReadMailView.access$1100(this.this$0))
          {
            QMReadMailView.access$600(this.this$0).measure(0, 0);
            paramInt = QMReadMailView.access$600(this.this$0).getMeasuredHeight();
            QMReadMailView.access$1300(this.this$0);
          }
        }
      }
    }
    return paramInt;
  }
  
  public void onStartPull(View paramView)
  {
    if (QMReadMailView.access$700(this.this$0) != null) {
      QMReadMailView.access$700(this.this$0).onStartQuickReply();
    }
    paramView = (TextView)QMReadMailView.access$400(this.this$0).findViewById(2131373842);
    View localView = QMReadMailView.access$400(this.this$0).findViewById(2131373840);
    if ((!QMReadMailView.access$800(this.this$0)) || (QMReadMailView.access$900(this.this$0) == 2) || (QMReadMailView.access$900(this.this$0) == 6))
    {
      paramView.setText("");
      paramView.setPadding(paramView.getPaddingLeft(), 0, paramView.getPaddingLeft(), 0);
      localView.setVisibility(4);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      localView.clearAnimation();
      this.statusReleaseToReply = false;
      return;
      paramView.setText(2131697499);
      paramView.setPadding(paramView.getPaddingLeft(), 0, 0, 0);
      localView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.9
 * JD-Core Version:    0.7.0.1
 */