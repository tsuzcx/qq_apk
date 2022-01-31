package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;

final class sa
  implements View.OnClickListener
{
  sa(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public final void onClick(View paramView)
  {
    t.a(this.a);
    NetActiveVryQuesActivity.access$902(this.a, NetActiveVryQuesActivity.access$700(this.a).getText().toString());
    e.a("mobile " + NetActiveVryQuesActivity.access$900(this.a));
    if ((NetActiveVryQuesActivity.access$900(this.a) != null) && (NetActiveVryQuesActivity.access$900(this.a).length() != 0))
    {
      NetActiveVryQuesActivity.access$100(this.a);
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    }
    this.a.showToast(2131361946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sa
 * JD-Core Version:    0.7.0.1
 */