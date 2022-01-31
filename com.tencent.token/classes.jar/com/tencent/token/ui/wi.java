package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class wi
  extends cb
{
  wi(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity)
  {
    super(paramRealNameStep0VerifyMobileUpActivity);
  }
  
  private void a(String paramString)
  {
    this.a.showUserDialog(2131230843, paramString, 2131230897, new wl(this), new wm(this));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    h.c("mHandler " + paramMessage.what + paramMessage.arg1);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      RealNameStep0VerifyMobileUpActivity.access$302(this.a, 0);
      this.a.showProDialogWithoutShutDown(this.a, this.a.getString(2131230787));
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    case 4000: 
      if (paramMessage.arg1 == 0)
      {
        cw.a().d(0L, 3, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new wj(this));
      return;
    case 3072: 
      if (paramMessage.arg1 == 0)
      {
        cw.a().d(RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3071: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (QueryCaptchaResult)paramMessage.obj;
        if (paramMessage.mNeedCaptcha)
        {
          this.a.gotoVerifyActivity(paramMessage);
          return;
        }
        cw.a().d(RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3025: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = cx.c();
        paramMessage.i();
        paramMessage.n();
        cw.a().a(0L, RealNameStep0VerifyMobileUpActivity.access$100(this.a), 2, "", "", this.a.mFaceData, RealNameStep0VerifyMobileUpActivity.access$400(this.a, this.a.mFrontData), RealNameStep0VerifyMobileUpActivity.access$400(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new wk(this));
      return;
    case 3003: 
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, VerifySuccActivity.class);
      paramMessage.putExtra("mRealUin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      paramMessage.putExtra("mSourceId", this.a.mSourceId);
      paramMessage.putExtra("ish5zzb", RealNameStep0VerifyMobileUpActivity.access$500(this.a));
      this.a.startActivity(paramMessage);
      this.a.finish();
      return;
    case 3074: 
      if (paramMessage.arg1 == 0)
      {
        do.a().f(RealNameStep0VerifyMobileUpActivity.access$100(this.a));
        cw.a().b(RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      Intent localIntent = new Intent(this.a, RealNameFindFailActivity.class);
      localIntent.putExtra("err_info", paramMessage.c);
      localIntent.putExtra("source_id", this.a.mSourceId);
      localIntent.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      localIntent.putExtra("canchange_uin", this.a.canchange_uin);
      this.a.startActivity(localIntent);
      return;
    case 4: 
      this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231588), 2131230897, null);
      this.a.sendUpSmsBySMSAPP(ProtoGeneralGetMobileCode.d, ProtoGeneralGetMobileCode.e);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1001)
      {
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        paramMessage.putExtra("realname_result", RealNameStep0VerifyMobileUpActivity.access$600(this.a));
        paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
        paramMessage.putExtra("zzb_recommend_view", RealNameStep0VerifyMobileUpActivity.access$700(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1003)
      {
        cw.a().e(RealNameStep0VerifyMobileUpActivity.access$100(this.a), 3, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, FaceRecognitionCameraActivity.class);
      paramMessage.putExtra("flag", 2);
      paramMessage.putExtra("istry", 3);
      paramMessage.putExtra("scene", 4);
      paramMessage.putExtra("ish5zzb", RealNameStep0VerifyMobileUpActivity.access$500(this.a));
      paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      this.a.startActivity(paramMessage);
      return;
    }
    if (paramMessage.arg1 == 176)
    {
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      a(paramMessage.c);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (RealNameStep0VerifyMobileUpActivity.access$300(this.a) < 4))
    {
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wi
 * JD-Core Version:    0.7.0.1
 */