package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;

class ek
  implements View.OnClickListener
{
  ek(FaceChangeMobileActivity paramFaceChangeMobileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!do.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 10, 1);
      return;
    }
    cw.a().e(0L, FaceChangeMobileActivity.access$000(this.a));
    this.a.showProDialog(this.a, 2131230843, 2131231299, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ek
 * JD-Core Version:    0.7.0.1
 */