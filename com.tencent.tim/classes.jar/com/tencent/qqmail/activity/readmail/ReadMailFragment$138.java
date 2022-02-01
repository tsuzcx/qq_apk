package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$138
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$138(ReadMailFragment paramReadMailFragment, int paramInt, Attach paramAttach) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    if (paramString.equals(this.this$0.getString(2131690582))) {
      ReadMailFragment.access$21800(this.this$0, this.val$index);
    }
    while (!paramString.equals(this.this$0.getString(2131690554))) {
      return;
    }
    ReadMailFragment.access$21900(this.this$0, this.val$attach);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.138
 * JD-Core Version:    0.7.0.1
 */