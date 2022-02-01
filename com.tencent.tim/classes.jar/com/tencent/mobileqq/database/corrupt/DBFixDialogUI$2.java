package com.tencent.mobileqq.database.corrupt;

import afat;
import android.app.Activity;
import android.app.Dialog;

public class DBFixDialogUI$2
  implements Runnable
{
  public DBFixDialogUI$2(afat paramafat, Dialog paramDialog) {}
  
  public void run()
  {
    if (((this.this$0.mContext instanceof Activity)) && (((Activity)this.this$0.mContext).isFinishing())) {
      return;
    }
    this.val$dialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.2
 * JD-Core Version:    0.7.0.1
 */