package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$77
  implements QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$77(ReadMailFragment paramReadMailFragment, int paramInt, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new ReadMailFragment.77.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.77
 * JD-Core Version:    0.7.0.1
 */