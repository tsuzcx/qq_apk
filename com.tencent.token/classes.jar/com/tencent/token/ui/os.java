package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;

class os
  implements View.OnClickListener
{
  os(or paramor, MbInfoResult.MbInfoItem paramMbInfoItem, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mId == 51) && (this.a.mDetail.mBtnType == 1))
    {
      paramView = new Intent(or.a(this.d), UtilsModSetMobileStep1Activity.class);
      paramView.putExtra("title", or.a(this.d).getResources().getString(2131231428) + this.a.mName);
      paramView.putExtra("op_type", 1);
      paramView.putExtra("position", this.b);
      or.a(this.d).startActivity(paramView);
      return;
    }
    paramView = new Intent(or.a(this.d), UtilsMbInfoItemActivity.class);
    paramView.putExtra("position", this.c);
    or.a(this.d).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.os
 * JD-Core Version:    0.7.0.1
 */