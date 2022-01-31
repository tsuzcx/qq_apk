package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;

final class dp
  implements View.OnClickListener
{
  dp(FaceChangeMobileActivity paramFaceChangeMobileActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null)
    {
      this.a.showNoAccountTipDialog(this.a, 3, 0);
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 3, 1);
      return;
    }
    this.a.showProDialog(this.a, 2131361808, 2131362203, null);
    af.a().l(0L, FaceChangeMobileActivity.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dp
 * JD-Core Version:    0.7.0.1
 */