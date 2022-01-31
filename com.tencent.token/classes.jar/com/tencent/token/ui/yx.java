package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;

final class yx
  implements View.OnClickListener
{
  yx(ScanLoginBindActivity paramScanLoginBindActivity, QQUser paramQQUser, UpgradeDeterminResult paramUpgradeDeterminResult) {}
  
  public final void onClick(View paramView)
  {
    af.a().c(this.a.mRealUin, this.b.a(), "", "", this.c.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yx
 * JD-Core Version:    0.7.0.1
 */