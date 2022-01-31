package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.eq;

class se
  implements View.OnClickListener
{
  se(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if ((eq.a().c() == null) && (paramView != null) && (paramView.mIsBinded))
    {
      cw.a().e(0L, OpMsgDisplayActivity.access$300(this.a));
      OpMsgDisplayActivity.access$002(this.a, 53);
      this.a.showUserDialog(12);
      return;
    }
    OpMsgDisplayActivity.access$100(this.a, 53);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.se
 * JD-Core Version:    0.7.0.1
 */