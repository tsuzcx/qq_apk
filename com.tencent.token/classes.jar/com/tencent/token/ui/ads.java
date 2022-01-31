package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.cw;

class ads
  implements DialogInterface.OnClickListener
{
  ads(adr paramadr, UtilsMbInfoItemActivity paramUtilsMbInfoItemActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cw.a().b(0L, UtilsMbInfoItemActivity.access$300(this.b.d).mId, UtilsMbInfoItemActivity.access$600(this.b.d));
    this.a.showProDialog(this.a, 2131230843, 2131231567, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ads
 * JD-Core Version:    0.7.0.1
 */