package com.tencent.qqmail.paintpad;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener;

class MailPaintPadActivity$5
  implements QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener
{
  MailPaintPadActivity$5(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new MailPaintPadActivity.5.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.5
 * JD-Core Version:    0.7.0.1
 */