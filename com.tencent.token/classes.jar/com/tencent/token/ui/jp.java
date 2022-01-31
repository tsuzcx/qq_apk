package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.core.bean.FreezeStatusResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.ui.base.FreezeUinDialog;

class jp
  implements View.OnClickListener
{
  jp(FreezeStatusActivity paramFreezeStatusActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if ((paramView == null) || (FreezeStatusActivity.access$000(this.a) == null))
    {
      this.a.finish();
      return;
    }
    ch.a().a(System.currentTimeMillis(), 221);
    new FreezeUinDialog(this.a, 2131362182, paramView.mUinMask, FreezeStatusActivity.access$000(this.a).mAutoFreezeIntervalTime, this.a.mHandler).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jp
 * JD-Core Version:    0.7.0.1
 */