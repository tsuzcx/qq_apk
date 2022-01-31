package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cg;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.ui.base.ProDialog;

class nr
  implements View.OnClickListener
{
  nr(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity) {}
  
  public void onClick(View paramView)
  {
    LoginMsgReportLocationActivity.access$202(this.a, LoginMsgReportLocationActivity.access$500(this.a).a());
    paramView = cg.a();
    if ((LoginMsgReportLocationActivity.access$200(this.a) == -1) || (LoginMsgReportLocationActivity.access$200(this.a) > paramView.e.length) || (LoginMsgReportLocationActivity.access$000(this.a) == null))
    {
      paramView = this.a.mHandler.obtainMessage(3032);
      paramView.arg1 = 10000;
      String str = this.a.getResources().getString(2131231183);
      paramView.obj = new f(10000, str, str);
      this.a.mHandler.sendMessage(paramView);
      return;
    }
    this.a.mDialogPro = new ProDialog(this.a, 2131362182, this.a.getString(2131231392));
    this.a.mDialogPro.show();
    cw.a().a(0L, paramView.e[LoginMsgReportLocationActivity.access$200(this.a)], paramView.d[LoginMsgReportLocationActivity.access$200(this.a)], 0, LoginMsgReportLocationActivity.access$000(this.a), this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nr
 * JD-Core Version:    0.7.0.1
 */