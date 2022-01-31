package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.global.h;

class qj
  implements DialogInterface.OnClickListener
{
  qj(qh paramqh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.dismissDialog();
    h.b("dir bind token cofirm");
    this.a.a.showProDialog(this.a.a, 2131230843, 2131231298, null);
    cw.a().b(NetActiveSetDirBySeqActivity.access$300(this.a.a).mRealUin, NetActiveSetDirBySeqActivity.access$400(this.a.a), NetActiveSetDirBySeqActivity.access$200(this.a.a), NetActiveSetDirBySeqActivity.access$500(this.a.a), NetActiveSetDirBySeqActivity.access$600(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qj
 * JD-Core Version:    0.7.0.1
 */