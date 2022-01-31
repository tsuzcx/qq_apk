package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;

class rx
  implements View.OnClickListener
{
  rx(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if ((paramView != null) && (paramView.mIsBinded))
    {
      cw.a().j(0L, OpMsgDisplayActivity.access$300(this.a));
      this.a.showUserDialog(12);
      return;
    }
    paramView = new Intent(this.a, CommonVerifyActivity.class);
    paramView.putExtra("name", this.a.getString(2131231331));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rx
 * JD-Core Version:    0.7.0.1
 */