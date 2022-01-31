package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.token.af;
import com.tencent.token.core.bean.f;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class qh
  implements View.OnClickListener
{
  qh(qf paramqf, f paramf, ProgressBar paramProgressBar) {}
  
  public final void onClick(View paramView)
  {
    af.a().a(0L, this.a.a, this.a.d, this.a.e, this.a.f, this.a.g, s.a(x.a(RqdApplication.i()).c()), "com.tencent.token", LoginMsgActivity.mSkey, qf.a(this.c).mHandler);
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qh
 * JD-Core Version:    0.7.0.1
 */