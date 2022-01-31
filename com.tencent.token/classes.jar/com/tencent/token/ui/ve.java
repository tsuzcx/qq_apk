package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ve
  implements View.OnClickListener
{
  ve(RealNameFindFailActivity paramRealNameFindFailActivity) {}
  
  public void onClick(View paramView)
  {
    if (RealNameFindFailActivity.access$000(this.a) == 1)
    {
      paramView = new Intent(this.a, FindPasswdActivity.class);
      paramView.addFlags(67108864);
      paramView.putExtra("real_uin", RealNameFindFailActivity.access$100(this.a));
      paramView.putExtra("not_showLockVerify", true);
      paramView.putExtra("canchange_uin", RealNameFindFailActivity.access$200(this.a));
      this.a.startActivity(paramView);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ve
 * JD-Core Version:    0.7.0.1
 */