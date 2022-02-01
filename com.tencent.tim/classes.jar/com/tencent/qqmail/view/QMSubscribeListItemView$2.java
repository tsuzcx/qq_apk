package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnLongClickListener;

class QMSubscribeListItemView$2
  implements View.OnLongClickListener
{
  QMSubscribeListItemView$2(QMSubscribeListItemView paramQMSubscribeListItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (QMSubscribeListItemView.access$100(this.this$0) != null) {
      QMSubscribeListItemView.access$100(this.this$0).onLongClick(this.this$0.getTag(), this.this$0.indexOfChild(paramView) - 1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMSubscribeListItemView.2
 * JD-Core Version:    0.7.0.1
 */