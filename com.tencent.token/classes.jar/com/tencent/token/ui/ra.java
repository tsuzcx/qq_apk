package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;

class ra
  implements View.OnClickListener
{
  ra(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public void onClick(View paramView)
  {
    NetActiveVryQQTokenActivity.access$700(this.a);
    paramView = (EditText)this.a.findViewById(2131559085);
    String str = paramView.getText().toString();
    if (paramView != null) {
      paramView.clearFocus();
    }
    if ((str != null) && (str.length() == 6))
    {
      NetActiveVryQQTokenActivity.access$700(this.a);
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      NetActiveVryQQTokenActivity.access$800(this.a).a(NetActiveVryQQTokenActivity.access$500(this.a).mRealUin, str, NetActiveVryQQTokenActivity.access$100(this.a).a(), NetActiveVryQQTokenActivity.access$300(this.a));
      return;
    }
    if ((str == null) || (str.length() == 0))
    {
      this.a.showToast(2131230958);
      return;
    }
    this.a.showToast(2131230967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ra
 * JD-Core Version:    0.7.0.1
 */