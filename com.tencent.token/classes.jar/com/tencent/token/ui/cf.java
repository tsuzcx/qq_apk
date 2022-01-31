package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;

final class cf
  implements View.OnClickListener
{
  cf(CommonVerifyActivity paramCommonVerifyActivity, QQUser paramQQUser, UpgradeDeterminResult paramUpgradeDeterminResult) {}
  
  public final void onClick(View paramView)
  {
    af.a().c(this.a.mRealUin, this.b.a(), "", "", CommonVerifyActivity.access$500(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cf
 * JD-Core Version:    0.7.0.1
 */