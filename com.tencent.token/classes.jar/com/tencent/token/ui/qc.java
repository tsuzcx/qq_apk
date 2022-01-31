package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tmsdk.TMSDKContext;

class qc
  implements View.OnClickListener
{
  qc(MyPswSubPageActivity paramMyPswSubPageActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().e() == null) {
      this.a.showNoAccountTipDialog(this.a, 10, 0);
    }
    for (;;)
    {
      TMSDKContext.SaveStringData(1150066, "");
      return;
      if (!do.a().e().mIsBinded)
      {
        this.a.showNoAccountTipDialog(this.a, 10, 1);
      }
      else
      {
        paramView = new Intent(this.a, ModifyQQPwdActivity.class);
        pg.a().a(this.a, paramView, pg.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qc
 * JD-Core Version:    0.7.0.1
 */