package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.x;

final class aej
  implements View.OnClickListener
{
  aej(UtilsMailProtectActivity paramUtilsMailProtectActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = ax.a().e();
    if (paramView == null) {
      return;
    }
    x.a(RqdApplication.i()).a(this.a, "" + paramView.mRealUin, UtilsMailProtectActivity.access$000(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aej
 * JD-Core Version:    0.7.0.1
 */