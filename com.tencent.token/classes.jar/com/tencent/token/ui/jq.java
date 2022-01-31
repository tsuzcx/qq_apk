package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;

class jq
  implements View.OnClickListener
{
  jq(FreezeStatusActivity paramFreezeStatusActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if ((paramView == null) || (FreezeStatusActivity.access$000(this.a) == null))
    {
      this.a.finish();
      return;
    }
    if ((paramView != null) && (!paramView.mIsBinded))
    {
      this.a.showNoAccountTipDialog(this.a, 25, 1);
      return;
    }
    paramView = new Intent(this.a, ModifyQQPwdActivity.class);
    paramView.putExtra("source_id", 1);
    pg.a().a(this.a, paramView, pg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jq
 * JD-Core Version:    0.7.0.1
 */