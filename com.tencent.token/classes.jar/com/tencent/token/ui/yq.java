package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

class yq
  extends UserTask
{
  yq(yp paramyp) {}
  
  public f a(String... paramVarArgs)
  {
    return do.a().a(ScanLoginConfirmLoginActivity.access$000(this.a.a), ScanLoginConfirmLoginActivity.access$100(this.a.a).a());
  }
  
  public void a(f paramf)
  {
    Message localMessage = ScanLoginConfirmLoginActivity.access$300(this.a.a).obtainMessage(4103);
    localMessage.arg1 = paramf.a;
    ScanLoginConfirmLoginActivity.access$300(this.a.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yq
 * JD-Core Version:    0.7.0.1
 */