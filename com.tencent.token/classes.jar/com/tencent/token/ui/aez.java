package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.token.fn;
import com.tencent.token.global.d;

final class aez
  extends bo
{
  aez(UtilsMbInfoItemActivity paramUtilsMbInfoItemActivity)
  {
    super(paramUtilsMbInfoItemActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
        fn.a().b();
        AccountPageActivity.mNeedRefreshEval = true;
      }
      break;
    }
    while (paramMessage.arg1 == 0)
    {
      paramMessage = new Intent(this.a, UtilsMbInfoFeedbackMobileUsingSuccActivity.class);
      this.a.startActivity(paramMessage);
      fn.a().b();
      AccountPageActivity.mNeedRefreshEval = true;
      this.a.finish();
      return;
      UtilsMbInfoItemActivity.access$000(this.a).setVisibility(0);
      UtilsMbInfoItemActivity.access$100(this.a).setVisibility(8);
      d locald = (d)paramMessage.obj;
      if ((locald.c == null) || (locald.c.length() == 0)) {
        d.a(this.a.getResources(), locald);
      }
      this.a.showUserDialog(2131361808, locald.c, 2131361800, null);
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aez
 * JD-Core Version:    0.7.0.1
 */