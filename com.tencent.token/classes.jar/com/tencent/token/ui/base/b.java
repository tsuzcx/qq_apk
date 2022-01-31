package com.tencent.token.ui.base;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.ui.BaseActivity;

final class b
  implements View.OnClickListener
{
  b(CaptchaDialog paramCaptchaDialog) {}
  
  public final void onClick(View paramView)
  {
    if ((CaptchaDialog.h(this.a)) || (CaptchaDialog.a(this.a) == null)) {
      return;
    }
    paramView = CaptchaDialog.i(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0))
    {
      CaptchaDialog.a(this.a).showToast(2131362169);
      return;
    }
    CaptchaDialog.a(this.a, true);
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    this.a.a = new ProDialog(CaptchaDialog.a(this.a), CaptchaDialog.a(this.a).getResources().getString(2131361918));
    this.a.a.show();
    paramView = paramView.trim();
    af.a().a(CaptchaDialog.g(this.a).mRealUin, CaptchaDialog.g(this.a).mSceneId, paramView, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.b
 * JD-Core Version:    0.7.0.1
 */