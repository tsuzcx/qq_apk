package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$150
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$150(ReadMailFragment paramReadMailFragment, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131696621)))
    {
      this.this$0.openUrl(this.val$urlAddress);
      paramQMBottomDialog.dismiss();
    }
    while (!paramString.equals(this.this$0.getString(2131692324))) {
      return;
    }
    this.this$0.copy(this.val$urlAddress);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.150
 * JD-Core Version:    0.7.0.1
 */