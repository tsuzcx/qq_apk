package com.tencent.qqmail.ftn.activity;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class FtnAttachmentActivity$14
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FtnAttachmentActivity$14(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new FtnAttachmentActivity.14.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.14
 * JD-Core Version:    0.7.0.1
 */