package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fn;

final class sx
  implements View.OnClickListener
{
  sx(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = ax.a().e();
    if ((fn.a().c() == null) && (paramView != null) && (paramView.mIsBinded))
    {
      af.a().e(0L, OpMsgDisplayActivity.access$300(this.a));
      OpMsgDisplayActivity.access$002(this.a, 52);
      this.a.showUserDialog(12);
      return;
    }
    OpMsgDisplayActivity.access$100(this.a, 52);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sx
 * JD-Core Version:    0.7.0.1
 */