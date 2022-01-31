package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.p;

final class xi
  implements View.OnClickListener
{
  xi(xg paramxg) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.dismiss();
    p.a().a(System.currentTimeMillis(), 92);
    this.a.a.showProDialogWithoutShutDown(this.a.a, this.a.a.getResources().getString(2131361817));
    af.a().a(0L, RealNameStep1InputNameIdActivity.access$1500(this.a.a), 3, RealNameStep1InputNameIdActivity.access$1600(this.a.a).getText().toString(), RealNameStep1InputNameIdActivity.access$1700(this.a.a).getText().toString(), null, null, null, RealNameStep1InputNameIdActivity.access$1800(this.a.a), RealNameStep1InputNameIdActivity.access$1900(this.a.a), RealNameStep1InputNameIdActivity.access$2000(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xi
 * JD-Core Version:    0.7.0.1
 */