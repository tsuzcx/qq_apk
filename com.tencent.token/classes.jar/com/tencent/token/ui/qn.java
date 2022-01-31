package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class qn
  implements View.OnClickListener
{
  qn(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetActiveVryMobileNoSmsActivity.access$800(this.a)) {
      return;
    }
    NetActiveVryMobileNoSmsActivity.access$900(this.a);
    paramView = (EditText)this.a.findViewById(2131559080);
    String str = paramView.getText().toString();
    if (paramView != null) {
      paramView.clearFocus();
    }
    if ((str != null) && (str.length() > 0))
    {
      NetActiveVryMobileNoSmsActivity.access$1000(this.a, str);
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    this.a.showToast(2131230959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qn
 * JD-Core Version:    0.7.0.1
 */