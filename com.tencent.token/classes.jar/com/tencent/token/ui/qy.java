package com.tencent.token.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.global.h;
import java.util.List;

class qy
  implements View.OnClickListener
{
  qy(qv paramqv, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem) {}
  
  public void onClick(View paramView)
  {
    NetActiveVryOtherListActivity.access$302(this.b.a, false);
    if (NetActiveVryOtherListActivity.access$400(this.b.a).a() == this.a.a())
    {
      this.b.a.finish();
      return;
    }
    int i = ((Integer)this.a.c().get(0)).intValue();
    abi.a().a((Activity)qv.a(this.b), NetActiveVryOtherListActivity.access$200(this.b.a), this.a, i, true, null);
    h.a("verify infoclick:id1=" + NetActiveVryOtherListActivity.access$400(this.b.a).a() + ",id2=" + this.a.a() + "factorid=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qy
 * JD-Core Version:    0.7.0.1
 */