package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmail.utilities.ui.QMUIKit;

class QMTopBar$3
  implements Runnable
{
  QMTopBar$3(QMTopBar paramQMTopBar, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    int i = 0;
    if (QMTopBar.access$100(this.this$0) == null)
    {
      Object localObject2;
      View localView;
      if (this.val$shown)
      {
        QMTopBar.access$102(this.this$0, new View(QMTopBar.access$200(this.this$0)));
        localObject1 = QMTopBar.access$200(this.this$0).getResources().getDrawable(2130840969);
        i = ((Drawable)localObject1).getIntrinsicWidth();
        localObject2 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = QMUIKit.dpToPx(10);
        if (!this.val$isTextBtn) {
          break label186;
        }
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = QMUIKit.dpToPx(16);
        QMTopBar.access$100(this.this$0).setBackgroundDrawable((Drawable)localObject1);
        this.this$0.addView(QMTopBar.access$100(this.this$0), (ViewGroup.LayoutParams)localObject2);
        localObject2 = new Rect(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        localView = QMTopBar.access$100(this.this$0);
        if (!this.val$isTextBtn) {
          break label198;
        }
      }
      label186:
      label198:
      for (localObject1 = QMTopBar.access$300(this.this$0);; localObject1 = QMTopBar.access$400(this.this$0))
      {
        localView.setTouchDelegate(new TouchDelegate((Rect)localObject2, (View)localObject1));
        return;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = QMUIKit.dpToPx(10);
        break;
      }
    }
    Object localObject1 = QMTopBar.access$100(this.this$0);
    if (this.val$shown) {}
    for (;;)
    {
      ((View)localObject1).setVisibility(i);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMTopBar.3
 * JD-Core Version:    0.7.0.1
 */