package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.global.e;

final class rv
  implements View.OnClickListener
{
  rv(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public final void onClick(View paramView)
  {
    NetActiveVryQQTokenActivity.access$1000(this.a);
    NetActiveVryQQTokenActivity.access$1102(this.a, NetActiveVryQQTokenActivity.access$700(this.a).getText().toString());
    e.a("mobile " + NetActiveVryQQTokenActivity.access$1100(this.a));
    if ((NetActiveVryQQTokenActivity.access$1100(this.a) != null) && (NetActiveVryQQTokenActivity.access$1100(this.a).length() != 0))
    {
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      NetActiveVryQQTokenActivity.access$100(this.a);
      return;
    }
    this.a.showToast(2131361947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rv
 * JD-Core Version:    0.7.0.1
 */