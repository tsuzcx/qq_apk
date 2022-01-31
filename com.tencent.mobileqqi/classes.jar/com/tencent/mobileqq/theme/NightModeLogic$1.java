package com.tencent.mobileqq.theme;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class NightModeLogic$1
  implements View.OnClickListener
{
  NightModeLogic$1(NightModeLogic paramNightModeLogic) {}
  
  public void onClick(View paramView)
  {
    if (NightModeLogic.access$000(this.this$0) != null)
    {
      paramView = new Bundle();
      paramView.putInt("start_status", 2);
      NightModeLogic.access$000(this.this$0).c(paramView);
    }
    if ((NightModeLogic.access$100(this.this$0) != null) && (NightModeLogic.access$100(this.this$0).isShowing())) {
      NightModeLogic.access$100(this.this$0).dismiss();
    }
    NightModeLogic.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.1
 * JD-Core Version:    0.7.0.1
 */