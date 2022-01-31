package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cw;

class rm
  implements View.OnClickListener
{
  rm(NoCheckWithAuthActivity paramNoCheckWithAuthActivity) {}
  
  public void onClick(View paramView)
  {
    cw.a().c(NoCheckWithAuthActivity.access$100(this.a).mRealUin, NoCheckWithAuthActivity.access$200(this.a).f(), "", "", NoCheckWithAuthActivity.access$300(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rm
 * JD-Core Version:    0.7.0.1
 */