package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener;

class ReadVirtualAdsMailFragment$2$1
  implements QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener
{
  ReadVirtualAdsMailFragment$2$1(ReadVirtualAdsMailFragment.2 param2) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new ReadVirtualAdsMailFragment.2.1.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.2.1
 * JD-Core Version:    0.7.0.1
 */