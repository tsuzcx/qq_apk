package com.tencent.qqmail.activity.compose;

import android.util.Log;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor;

class QMComposeMailView$6
  implements View.OnLayoutChangeListener
{
  QMComposeMailView$6(QMComposeMailView paramQMComposeMailView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Log.i("QMComposeMailView", "Listen layout change in header " + paramView.getHeight() + " " + QMComposeMailView.access$700(this.this$0).getScale());
    QMComposeMailView.access$700(this.this$0).setCardHeadHeight((int)(paramView.getHeight() / QMComposeMailView.access$700(this.this$0).getScale()) + 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.6
 * JD-Core Version:    0.7.0.1
 */