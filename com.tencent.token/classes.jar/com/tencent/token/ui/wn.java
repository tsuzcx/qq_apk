package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;

class wn
  implements View.OnClickListener
{
  wn(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.sendUpSmsBySMSAPP(ProtoGeneralGetMobileCode.d, ProtoGeneralGetMobileCode.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wn
 * JD-Core Version:    0.7.0.1
 */