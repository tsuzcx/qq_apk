package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cw;
import com.tencent.token.ds;
import com.tmsdk.TMSDKContext;

class qb
  implements View.OnClickListener
{
  qb(MyPswSubPageActivity paramMyPswSubPageActivity) {}
  
  public void onClick(View paramView)
  {
    cw.a().a(0L, ds.e, 1, MyPswSubPageActivity.access$300(this.a));
    this.a.showUserDialog(12);
    TMSDKContext.SaveStringData(1150066, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qb
 * JD-Core Version:    0.7.0.1
 */