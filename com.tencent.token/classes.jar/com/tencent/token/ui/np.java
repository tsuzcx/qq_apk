package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cg;
import com.tencent.token.cw;
import com.tencent.token.global.c;

class np
  implements View.OnClickListener
{
  np(no paramno, cg paramcg) {}
  
  public void onClick(View paramView)
  {
    this.b.a.showOrangeToast(2131231181, 2130838018);
    cw.a().a(0L, this.a.e[LoginMsgReportLocationActivity.access$200(this.b.a)], this.a.d[LoginMsgReportLocationActivity.access$200(this.b.a)], 1, LoginMsgReportLocationActivity.access$000(this.b.a), this.b.a.mHandler);
    this.b.a.finish();
    paramView = new Intent(c.g(), LoginMsgActivity.class);
    this.b.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.np
 * JD-Core Version:    0.7.0.1
 */