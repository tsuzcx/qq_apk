package com.tencent.token.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.e;

final class qy
  implements DialogInterface.OnClickListener
{
  qy(qx paramqx) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NetActiveSetDirBySeqActivity.access$300(this.a.a).dismiss();
    e.b("dir bind token cofirm");
    this.a.a.showProDialog(this.a.a, 2131361808, 2131361817, null);
    af.a().c(NetActiveSetDirBySeqActivity.access$400(this.a.a).mRealUin, NetActiveSetDirBySeqActivity.access$500(this.a.a), NetActiveSetDirBySeqActivity.access$100(this.a.a), NetActiveSetDirBySeqActivity.access$600(this.a.a), NetActiveSetDirBySeqActivity.access$700(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qy
 * JD-Core Version:    0.7.0.1
 */