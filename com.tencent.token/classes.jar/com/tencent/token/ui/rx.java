package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;

final class rx
  implements View.OnClickListener
{
  rx(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public final void onClick(View paramView)
  {
    NetActiveVryQQTokenActivity.access$1000(this.a);
    paramView = ((EditText)this.a.findViewById(2131296891)).getText().toString();
    if ((paramView != null) && (paramView.length() == 6))
    {
      NetActiveVryQQTokenActivity.access$1000(this.a);
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      NetActiveVryQQTokenActivity.access$1300(this.a).b(NetActiveVryQQTokenActivity.access$1200(this.a).mRealUin, paramView, NetActiveVryQQTokenActivity.access$900(this.a));
      return;
    }
    if ((paramView == null) || (paramView.length() == 0))
    {
      this.a.showToast(2131361949);
      return;
    }
    this.a.showToast(2131361950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rx
 * JD-Core Version:    0.7.0.1
 */