package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.global.d;
import com.tencent.token.o;
import com.tencent.token.ui.base.ProDialog;

final class oo
  implements View.OnClickListener
{
  oo(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity) {}
  
  public final void onClick(View paramView)
  {
    LoginMsgReportLocationActivity.access$202(this.a, LoginMsgReportLocationActivity.access$500(this.a).a());
    paramView = o.a();
    if ((LoginMsgReportLocationActivity.access$200(this.a) == -1) || (LoginMsgReportLocationActivity.access$200(this.a) > paramView.e.length) || (LoginMsgReportLocationActivity.access$000(this.a) == null))
    {
      paramView = this.a.mHandler.obtainMessage(3032);
      paramView.arg1 = 10000;
      String str = this.a.getResources().getString(2131362049);
      paramView.obj = new d(str, str);
      this.a.mHandler.sendMessage(paramView);
      return;
    }
    this.a.mDialogPro = new ProDialog(this.a, this.a.getString(2131361918));
    this.a.mDialogPro.show();
    af.a().a(0L, paramView.e[LoginMsgReportLocationActivity.access$200(this.a)], paramView.d[LoginMsgReportLocationActivity.access$200(this.a)], 0, LoginMsgReportLocationActivity.access$000(this.a), this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.oo
 * JD-Core Version:    0.7.0.1
 */