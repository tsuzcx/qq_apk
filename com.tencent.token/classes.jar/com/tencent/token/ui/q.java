package com.tencent.token.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.utils.w;

class q
  implements View.OnClickListener
{
  q(AccountPageActivity paramAccountPageActivity, EvalAccountResult paramEvalAccountResult) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mSubStatus == 0)
    {
      if (!TextUtils.isEmpty(this.a.mUrl)) {
        w.a(this.b, this.a.mUrl, this.b.getString(2131230924));
      }
      return;
    }
    paramView = new Intent(this.b, ModifyQQPwdActivity.class);
    pg.a().a(this.b, paramView, pg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.q
 * JD-Core Version:    0.7.0.1
 */