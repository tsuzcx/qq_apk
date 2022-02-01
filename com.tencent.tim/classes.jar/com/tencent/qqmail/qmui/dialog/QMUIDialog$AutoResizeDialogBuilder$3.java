package com.tencent.qqmail.qmui.dialog;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.qqmail.utilities.ui.QMUIKit;

class QMUIDialog$AutoResizeDialogBuilder$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QMUIDialog$AutoResizeDialogBuilder$3(QMUIDialog.AutoResizeDialogBuilder paramAutoResizeDialogBuilder) {}
  
  public void onGlobalLayout()
  {
    Object localObject2 = this.this$0.mDialog.getWindow().getDecorView();
    Object localObject1 = new Rect();
    ((View)localObject2).getWindowVisibleDisplayFrame((Rect)localObject1);
    QMUIDialog.AutoResizeDialogBuilder.access$102(this.this$0, QMUIKit.getScreenHeight(this.this$0.mContext));
    int i = QMUIDialog.AutoResizeDialogBuilder.access$100(this.this$0) - ((Rect)localObject1).bottom;
    if (i != QMUIDialog.AutoResizeDialogBuilder.access$200(this.this$0))
    {
      QMUIDialog.AutoResizeDialogBuilder.access$202(this.this$0, i);
      localObject1 = (LinearLayout.LayoutParams)this.this$0.mAnchorBottomView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).height = QMUIDialog.AutoResizeDialogBuilder.access$200(this.this$0);
      this.this$0.mAnchorBottomView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (LinearLayout.LayoutParams)QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).getLayoutParams();
      if (this.this$0.onGetScrollHeight() == -2)
      {
        QMUIDialog.AutoResizeDialogBuilder.access$402(this.this$0, Math.max(QMUIDialog.AutoResizeDialogBuilder.access$400(this.this$0), QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).getMeasuredHeight()));
        if (QMUIDialog.AutoResizeDialogBuilder.access$200(this.this$0) != 0) {
          break label219;
        }
        ((LinearLayout.LayoutParams)localObject1).height = QMUIDialog.AutoResizeDialogBuilder.access$400(this.this$0);
        label189:
        QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    label219:
    do
    {
      return;
      QMUIDialog.AutoResizeDialogBuilder.access$402(this.this$0, this.this$0.onGetScrollHeight());
      break;
      QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).getChildAt(0).requestFocus();
      ((LinearLayout.LayoutParams)localObject1).height = (QMUIDialog.AutoResizeDialogBuilder.access$400(this.this$0) - QMUIDialog.AutoResizeDialogBuilder.access$200(this.this$0));
      break label189;
      localObject2 = (LinearLayout.LayoutParams)this.this$0.mDialogWrapper.getLayoutParams();
      i = QMUIDialog.AutoResizeDialogBuilder.access$100(this.this$0) - ((LinearLayout.LayoutParams)localObject2).bottomMargin - ((LinearLayout.LayoutParams)localObject2).topMargin - ((Rect)localObject1).top;
    } while (QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).getMeasuredHeight() <= i * 0.8D);
    QMUIDialog.AutoResizeDialogBuilder.access$402(this.this$0, (int)(i * 0.8D));
    localObject1 = (LinearLayout.LayoutParams)QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).height = QMUIDialog.AutoResizeDialogBuilder.access$400(this.this$0);
    QMUIDialog.AutoResizeDialogBuilder.access$300(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialog.AutoResizeDialogBuilder.3
 * JD-Core Version:    0.7.0.1
 */