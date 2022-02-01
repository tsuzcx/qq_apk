package com.tencent.qqmail.view;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener;

class QMAdvertiseView$2
  implements QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener
{
  QMAdvertiseView$2(QMAdvertiseView paramQMAdvertiseView) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new QMAdvertiseView.2.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMAdvertiseView.2
 * JD-Core Version:    0.7.0.1
 */