package com.tencent.token.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;

class ql
  implements View.OnClickListener
{
  ql(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NetActiveVryMobileNoSmsActivity.access$100(this.a) != null) && (NetActiveVryMobileNoSmsActivity.access$300(this.a) == 3) && (!NetActiveVryMobileNoSmsActivity.access$100(this.a).i()) && (!NetActiveVryMobileNoSmsActivity.access$100(this.a).j()))
    {
      String str = NetActiveVryMobileNoSmsActivity.access$100(this.a).f();
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = this.a.getResources().getString(2131231273);
      }
      this.a.showUserDialog(2131230843, paramView, 2131230897, null);
      return;
    }
    NetActiveVryMobileNoSmsActivity.access$400(this.a);
    NetActiveVryMobileNoSmsActivity.access$500(this.a, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ql
 * JD-Core Version:    0.7.0.1
 */