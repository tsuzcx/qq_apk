package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.cv;
import com.tencent.token.utils.w;

class qx
  implements View.OnClickListener
{
  qx(qv paramqv) {}
  
  public void onClick(View paramView)
  {
    NetActiveVryOtherListActivity.access$302(this.a.a, true);
    if (NetActiveVryOtherListActivity.access$200(this.a.a).a())
    {
      w.a(this.a.a, String.format(this.a.a.getString(2131230845), new Object[] { cv.a().b() }), this.a.a.getString(2131231449), false, 10);
      return;
    }
    w.a(this.a.a, String.format(this.a.a.getString(2131230846), new Object[] { cv.a().b() }), this.a.a.getString(2131231449), false, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qx
 * JD-Core Version:    0.7.0.1
 */