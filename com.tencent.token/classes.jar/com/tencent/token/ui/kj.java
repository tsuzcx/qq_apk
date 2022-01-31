package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class kj
  extends Handler
{
  kj(GeneralVerifyMobileUpActivity paramGeneralVerifyMobileUpActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      GeneralVerifyMobileUpActivity.access$302(this.a, 0);
      this.a.showProDialogWithoutShutDown(this.a, this.a.getString(2131230787));
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    case 4: 
      this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231588), 2131230897, null);
      return;
    case 15: 
      this.a.dismissDialog();
      this.a.removeTimeTask();
      paramMessage = this.a.getString(2131230964);
      GeneralVerifyMobileUpActivity.access$400(this.a, paramMessage);
      return;
    case 3003: 
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, VerifySuccActivity.class);
      paramMessage.putExtra("mRealUin", GeneralVerifyMobileUpActivity.access$100(this.a).mRealUin);
      if ((GeneralVerifyMobileUpActivity.access$500(this.a) != null) && (GeneralVerifyMobileUpActivity.access$500(this.a).c() == 2)) {
        paramMessage.putExtra("mSourceId", 1);
      }
      this.a.startActivity(paramMessage);
      this.a.finish();
      return;
    case 4004: 
      if (paramMessage.arg1 == 0)
      {
        GeneralVerifyMobileUpActivity.access$600(this.a);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      GeneralVerifyMobileUpActivity.access$700(this.a, paramMessage.c);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      if (!GeneralVerifyMobileUpActivity.access$000(this.a).a(Integer.valueOf(GeneralVerifyMobileUpActivity.access$800(this.a))))
      {
        abi.a().a(this.a, GeneralVerifyMobileUpActivity.access$500(this.a), GeneralVerifyMobileUpActivity.access$000(this.a), GeneralVerifyMobileUpActivity.access$000(this.a).a(GeneralVerifyMobileUpActivity.access$800(this.a)), false, GeneralVerifyMobileUpActivity.access$200(this.a));
        return;
      }
      if (GeneralVerifyMobileUpActivity.access$500(this.a).b())
      {
        cw.a().b(GeneralVerifyMobileUpActivity.access$100(this.a).mRealUin, GeneralVerifyMobileUpActivity.access$000(this.a).a(), GeneralVerifyMobileUpActivity.access$900(this.a), GeneralVerifyMobileUpActivity.access$1000(this.a), GeneralVerifyMobileUpActivity.access$200(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, NetActiveSetDirBySeqActivity.class);
      paramMessage.putExtra("intent.qquser", GeneralVerifyMobileUpActivity.access$100(this.a));
      paramMessage.putExtra("intent.determin_factors_result", GeneralVerifyMobileUpActivity.access$500(this.a));
      paramMessage.putExtra("intent.determin_verify_type", GeneralVerifyMobileUpActivity.access$000(this.a));
      paramMessage.putExtra("intent.determin_verify_factor_id", 3);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (GeneralVerifyMobileUpActivity.access$300(this.a) < 4))
    {
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kj
 * JD-Core Version:    0.7.0.1
 */