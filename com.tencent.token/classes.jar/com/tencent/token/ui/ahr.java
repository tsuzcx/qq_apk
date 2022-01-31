package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.ax;
import com.tencent.token.utils.t;
import com.tencent.token.x;

final class ahr
  implements View.OnClickListener
{
  ahr(WtloginSigExpireActivity paramWtloginSigExpireActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null) {
      return;
    }
    WtloginSigExpireActivity.access$302(this.a, WtloginSigExpireActivity.access$600(this.a).getText().toString());
    if ((WtloginSigExpireActivity.access$300(this.a) == null) || (WtloginSigExpireActivity.access$300(this.a).length() == 0))
    {
      this.a.showToast(2131362367);
      return;
    }
    t.a(this.a);
    x.a(this.a).a("" + WtloginSigExpireActivity.access$200(this.a), WtloginSigExpireActivity.access$300(this.a), WtloginSigExpireActivity.access$400(this.a), WtloginSigExpireActivity.access$000(this.a));
    this.a.showProDialog(this.a, 2131361808, 2131361817, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahr
 * JD-Core Version:    0.7.0.1
 */