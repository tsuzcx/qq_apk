package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.global.h;
import com.tencent.token.utils.x;

class rf
  implements View.OnClickListener
{
  rf(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public void onClick(View paramView)
  {
    x.a(this.a);
    NetActiveVryQuesActivity.access$702(this.a, NetActiveVryQuesActivity.access$800(this.a).getText().toString());
    h.a("mobile " + NetActiveVryQuesActivity.access$700(this.a));
    if ((NetActiveVryQuesActivity.access$700(this.a) != null) && (NetActiveVryQuesActivity.access$700(this.a).length() != 0))
    {
      NetActiveVryQuesActivity.access$400(this.a);
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    this.a.showToast(2131230956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rf
 * JD-Core Version:    0.7.0.1
 */