package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class lm
  implements View.OnClickListener
{
  lm(GetOtherBarcodeActivity paramGetOtherBarcodeActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = GetOtherBarcodeActivity.access$000(this.a).getText().toString();
    QQUser localQQUser = ax.a().e();
    if ((localQQUser != null) && (paramView.contains("qq.com")))
    {
      x.a(RqdApplication.i()).a("" + localQQUser.mRealUin, GetOtherBarcodeActivity.access$100(this.a));
      return;
    }
    s.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lm
 * JD-Core Version:    0.7.0.1
 */