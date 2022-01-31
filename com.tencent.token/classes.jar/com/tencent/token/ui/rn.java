package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.UpgradeDeterminResult;

class rn
  implements View.OnClickListener
{
  rn(NoCheckWithAuthActivity paramNoCheckWithAuthActivity) {}
  
  public void onClick(View paramView)
  {
    if (NoCheckWithAuthActivity.access$200(this.a).c())
    {
      paramView = new Intent(this.a, NetActiveVryMobileNoSmsActivity.class);
      paramView.putExtra("intent.qquser", NoCheckWithAuthActivity.access$100(this.a));
      paramView.putExtra("page_id", 7);
      paramView.putExtra("intent.upgradedetermin", NoCheckWithAuthActivity.access$200(this.a));
      this.a.startActivity(paramView);
    }
    while ((!NoCheckWithAuthActivity.access$200(this.a).d()) && (!NoCheckWithAuthActivity.access$200(this.a).e()) && (!NoCheckWithAuthActivity.access$200(this.a).a())) {
      return;
    }
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", NoCheckWithAuthActivity.access$100(this.a));
    paramView.putExtra("page_id", 7);
    paramView.putExtra("intent.upgradedetermin", NoCheckWithAuthActivity.access$200(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rn
 * JD-Core Version:    0.7.0.1
 */