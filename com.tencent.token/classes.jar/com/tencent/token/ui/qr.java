package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.bb;

final class qr
  implements View.OnClickListener
{
  qr(MyPswSubPageActivity paramMyPswSubPageActivity) {}
  
  public final void onClick(View paramView)
  {
    af.a().a(0L, bb.e, MyPswSubPageActivity.access$300(this.a));
    this.a.showUserDialog(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qr
 * JD-Core Version:    0.7.0.1
 */