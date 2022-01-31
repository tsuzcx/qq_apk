package com.tencent.mobileqq.theme;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class NightModeLogic$2
  implements View.OnClickListener
{
  NightModeLogic$2(NightModeLogic paramNightModeLogic) {}
  
  public void onClick(View paramView)
  {
    ReportController.b((QQAppInterface)this.this$0.mRuntime, "CliOper", "", "", "Setting_tab", "Night_mode_dl", 0, 0, "", "", "", "");
    if ((this.this$0.mCallback != null) && (!ThemeSwitchManager.isDownloadingInProgress))
    {
      paramView = new Bundle();
      paramView.putInt("start_status", 1);
      this.this$0.mCallback.c(paramView);
    }
    this.this$0.downLoadNightTheme();
    if ((this.this$0.downloadDialog != null) && (this.this$0.downloadDialog.isShowing()))
    {
      this.this$0.downloadDialog.dismiss();
      this.this$0.downloadDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.2
 * JD-Core Version:    0.7.0.1
 */