package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;

class eu
  implements View.OnClickListener
{
  eu(FaceChangePwdIndexActivity paramFaceChangePwdIndexActivity) {}
  
  public void onClick(View paramView)
  {
    if (!do.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 10, 1);
      return;
    }
    paramView = new Intent(this.a, ModifyQQPwdActivity.class);
    pg.a().a(this.a, paramView, pg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.eu
 * JD-Core Version:    0.7.0.1
 */