package com.tencent.qqmail.activity.readmail;

import android.util.Log;
import android.view.View;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadMailFragment$85
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$85(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    int i = 1;
    int j;
    if (paramInt != 0)
    {
      j = 1;
      switch (paramInt)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      Log.i("ReadMailFragment", "popupJourneyRemindDialog position = " + paramInt + " open = " + j + " ahead = " + i);
      QMMailManager.sharedInstance().setMailReminder(ReadMailFragment.access$000(this.this$0), "journey", i, j);
      paramQMBottomDialog.dismiss();
      return;
      j = 0;
      break;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.85
 * JD-Core Version:    0.7.0.1
 */