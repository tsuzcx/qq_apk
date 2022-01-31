package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.SecurityReporterResult;
import java.util.ArrayList;

final class oe
  implements View.OnClickListener
{
  oe(LoginMsgActivity paramLoginMsgActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null)
    {
      this.a.showNoAccountTipDialog(this.a, 7, 0);
      return;
    }
    if ((!this.a.isValid()) || (LoginMsgActivity.access$700(this.a) == null) || (LoginMsgActivity.access$700(this.a).chart == null) || (LoginMsgActivity.access$700(this.a).chart.size() == 0))
    {
      this.a.showProDialog(this.a, 2131361808, 2131362203, null);
      af.a().k(0L, this.a.mHandler);
      return;
    }
    paramView = new Intent(this.a, SecurityReporterActivity.class);
    paramView.putExtra("result", LoginMsgActivity.access$700(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.oe
 * JD-Core Version:    0.7.0.1
 */