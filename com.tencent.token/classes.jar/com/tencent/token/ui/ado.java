package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.token.eq;
import com.tencent.token.global.f;

class ado
  extends cb
{
  ado(UtilsMbInfoItemActivity paramUtilsMbInfoItemActivity)
  {
    super(paramUtilsMbInfoItemActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3011: 
      if (paramMessage.arg1 == 0)
      {
        UtilsMbInfoItemActivity.access$000(this.a).setVisibility(8);
        UtilsMbInfoItemActivity.access$100(this.a).setVisibility(0);
        this.a.mBackArrow.setVisibility(4);
        UtilsMbInfoItemActivity.access$202(this.a, true);
        eq.a().b();
        AccountPageActivity.mNeedRefreshEval = true;
      }
      break;
    }
    while (paramMessage.arg1 == 0)
    {
      paramMessage = new Intent(this.a, UtilsMbInfoFeedbackMobileUsingSuccActivity.class);
      this.a.startActivity(paramMessage);
      eq.a().b();
      AccountPageActivity.mNeedRefreshEval = true;
      this.a.finish();
      return;
      UtilsMbInfoItemActivity.access$000(this.a).setVisibility(0);
      UtilsMbInfoItemActivity.access$100(this.a).setVisibility(8);
      f localf = (f)paramMessage.obj;
      if ((localf.c == null) || (localf.c.length() == 0)) {
        f.a(this.a.getResources(), localf);
      }
      this.a.showUserDialog(2131230843, localf.c, 2131230897, null);
    }
    paramMessage = (f)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      f.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ado
 * JD-Core Version:    0.7.0.1
 */