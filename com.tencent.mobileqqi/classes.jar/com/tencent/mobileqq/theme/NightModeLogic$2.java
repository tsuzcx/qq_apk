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
    ReportController.b((QQAppInterface)NightModeLogic.access$200(this.this$0), "CliOper", "", "", "Setting_tab", "Night_mode_dl", 0, 0, "", "", "", "");
    if ((NightModeLogic.access$000(this.this$0) != null) && (!ThemeSwitchManager.isDownloadingInProgress))
    {
      paramView = new Bundle();
      paramView.putInt("start_status", 1);
      NightModeLogic.access$000(this.this$0).c(paramView);
    }
    this.this$0.downLoadNightTheme();
    if ((NightModeLogic.access$100(this.this$0) != null) && (NightModeLogic.access$100(this.this$0).isShowing()))
    {
      NightModeLogic.access$100(this.this$0).dismiss();
      NightModeLogic.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.2
 * JD-Core Version:    0.7.0.1
 */