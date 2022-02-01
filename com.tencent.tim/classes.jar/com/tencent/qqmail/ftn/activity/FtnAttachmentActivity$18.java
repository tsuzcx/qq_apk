package com.tencent.qqmail.ftn.activity;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class FtnAttachmentActivity$18
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FtnAttachmentActivity$18(FtnAttachmentActivity paramFtnAttachmentActivity, String paramString1, String paramString2) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new FtnAttachmentActivity.18.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.18
 * JD-Core Version:    0.7.0.1
 */