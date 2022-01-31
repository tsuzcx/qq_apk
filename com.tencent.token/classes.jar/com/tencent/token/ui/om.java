package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.global.b;
import com.tencent.token.o;

final class om
  implements View.OnClickListener
{
  om(ol paramol, o paramo) {}
  
  public final void onClick(View paramView)
  {
    this.b.a.showOrangeToast(2131362050, 2130837966);
    af.a().a(0L, this.a.e[LoginMsgReportLocationActivity.access$200(this.b.a)], this.a.d[LoginMsgReportLocationActivity.access$200(this.b.a)], 1, LoginMsgReportLocationActivity.access$000(this.b.a), this.b.a.mHandler);
    this.b.a.finish();
    paramView = new Intent(b.e(), LoginMsgActivity.class);
    this.b.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.om
 * JD-Core Version:    0.7.0.1
 */