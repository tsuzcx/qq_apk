package com.tencent.qqmail.ftn.activity;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class FtnListActivity$33$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FtnListActivity$33$1(FtnListActivity.33 param33) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new FtnListActivity.33.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.33.1
 * JD-Core Version:    0.7.0.1
 */