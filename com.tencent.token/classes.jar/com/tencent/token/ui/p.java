package com.tencent.token.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.utils.s;

final class p
  implements View.OnClickListener
{
  p(AccountPageActivity paramAccountPageActivity, EvalAccountResult paramEvalAccountResult) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.mSubStatus == 0)
    {
      if (!TextUtils.isEmpty(this.a.mUrl)) {
        s.a(this.b, this.a.mUrl, this.b.getString(2131362296));
      }
      return;
    }
    paramView = new Intent(this.b, ModifyQQPwdActivity.class);
    pv.a().a(this.b, paramView, pv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.p
 * JD-Core Version:    0.7.0.1
 */