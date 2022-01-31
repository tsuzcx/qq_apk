package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.x;

final class abk
  implements View.OnClickListener
{
  abk(StartPwdGestureForgetActivity paramStartPwdGestureForgetActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = StartPwdGestureForgetActivity.access$000(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0))
    {
      this.a.showToast(2131361929);
      return;
    }
    x.a(this.a).b("" + StartPwdGestureForgetActivity.access$400(this.a).mRealUin, StartPwdGestureForgetActivity.access$000(this.a).getText().toString(), StartPwdGestureForgetActivity.access$500(this.a), StartPwdGestureForgetActivity.access$300(this.a));
    this.a.showProDialog(this.a, 2131361808, 2131361817, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abk
 * JD-Core Version:    0.7.0.1
 */