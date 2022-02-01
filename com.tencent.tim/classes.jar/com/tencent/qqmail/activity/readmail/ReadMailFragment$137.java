package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$137
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$137(ReadMailFragment paramReadMailFragment, int paramInt) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    if (paramString.equals(this.this$0.getString(2131690555)))
    {
      paramQMBottomDialog = DownloadActivity.createIntent();
      this.this$0.startActivityForResult(paramQMBottomDialog, 107);
      DataCollector.logEvent("Event_Enter_DownloadManager");
    }
    while (!paramString.equals(this.this$0.getString(2131690563))) {
      return;
    }
    ReadMailFragment.access$8800(this.this$0, this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.137
 * JD-Core Version:    0.7.0.1
 */