package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;

final class st
  implements View.OnClickListener
{
  st(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = ax.a().e();
    if ((paramView != null) && (paramView.mIsBinded))
    {
      af.a().l(0L, OpMsgDisplayActivity.access$300(this.a));
      this.a.showUserDialog(12);
      return;
    }
    paramView = new Intent(this.a, CommonVerifyActivity.class);
    paramView.putExtra("name", this.a.getString(2131362513));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.st
 * JD-Core Version:    0.7.0.1
 */