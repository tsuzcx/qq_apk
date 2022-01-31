package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.db;

final class xe
  implements View.OnClickListener
{
  xe(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity) {}
  
  public final void onClick(View paramView)
  {
    this.a.sendUpSmsBySMSAPP(db.c, db.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xe
 * JD-Core Version:    0.7.0.1
 */