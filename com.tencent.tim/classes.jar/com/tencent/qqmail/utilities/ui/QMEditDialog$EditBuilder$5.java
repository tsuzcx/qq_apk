package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;

class QMEditDialog$EditBuilder$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QMEditDialog$EditBuilder$5(QMEditDialog.EditBuilder paramEditBuilder) {}
  
  public void onGlobalLayout()
  {
    Object localObject2 = QMEditDialog.EditBuilder.access$300(this.this$0).getWindow().getDecorView();
    Object localObject1 = new Rect();
    ((View)localObject2).getWindowVisibleDisplayFrame((Rect)localObject1);
    if (((Rect)localObject1).bottom == QMEditDialog.EditBuilder.access$600(this.this$0)) {
      QMEditDialog.EditBuilder.access$702(this.this$0, QMEditDialog.EditBuilder.access$600(this.this$0));
    }
    for (int i = 1;; i = 0)
    {
      QMEditDialog.EditBuilder.access$602(this.this$0, ((Rect)localObject1).right);
      QMEditDialog.EditBuilder.access$702(this.this$0, Math.max(QMEditDialog.EditBuilder.access$700(this.this$0), ((Rect)localObject1).bottom));
      int j = QMEditDialog.EditBuilder.access$700(this.this$0) - ((Rect)localObject1).bottom;
      if ((j != QMEditDialog.EditBuilder.access$800(this.this$0)) && (i == 0) && (Build.VERSION.SDK_INT < 24))
      {
        QMEditDialog.EditBuilder.access$802(this.this$0, j);
        localObject1 = (LinearLayout.LayoutParams)QMEditDialog.EditBuilder.access$900(this.this$0).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = QMEditDialog.EditBuilder.access$800(this.this$0);
        QMEditDialog.EditBuilder.access$900(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (LinearLayout.LayoutParams)QMEditDialog.EditBuilder.access$1000(this.this$0).getLayoutParams();
        QMEditDialog.EditBuilder.access$1102(this.this$0, Math.max(QMEditDialog.EditBuilder.access$1100(this.this$0), QMEditDialog.EditBuilder.access$1000(this.this$0).getMeasuredHeight()));
        if (QMEditDialog.EditBuilder.access$800(this.this$0) == 0)
        {
          ((LinearLayout.LayoutParams)localObject1).height = QMEditDialog.EditBuilder.access$1100(this.this$0);
          QMEditDialog.EditBuilder.access$1000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      do
      {
        return;
        QMEditDialog.EditBuilder.access$1000(this.this$0).getChildAt(0).requestFocus();
        ((LinearLayout.LayoutParams)localObject1).height = (QMEditDialog.EditBuilder.access$1100(this.this$0) - QMEditDialog.EditBuilder.access$800(this.this$0));
        break;
        localObject2 = (LinearLayout.LayoutParams)QMEditDialog.EditBuilder.access$1200(this.this$0).getLayoutParams();
        j = QMEditDialog.EditBuilder.access$700(this.this$0);
        int k = ((LinearLayout.LayoutParams)localObject2).bottomMargin;
        int m = ((LinearLayout.LayoutParams)localObject2).topMargin;
        int n = ((Rect)localObject1).top;
        i = QMEditDialog.EditBuilder.access$1000(this.this$0).getMeasuredHeight();
        j = j - k - m - n - this.this$0.mContext.getResources().getDimensionPixelSize(2131299664);
      } while (i <= j);
      QMEditDialog.EditBuilder.access$1102(this.this$0, j);
      localObject1 = (LinearLayout.LayoutParams)QMEditDialog.EditBuilder.access$1000(this.this$0).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).height = QMEditDialog.EditBuilder.access$1100(this.this$0);
      QMEditDialog.EditBuilder.access$1000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMEditDialog.EditBuilder.5
 * JD-Core Version:    0.7.0.1
 */