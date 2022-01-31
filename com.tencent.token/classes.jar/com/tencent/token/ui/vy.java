package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class vy
  extends cb
{
  vy(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity)
  {
    super(paramRealNameStep0VerifyMobileDownActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      h.c("realname  msg.what=" + paramMessage.what + ", msg.arg1=" + paramMessage.arg1);
      switch (paramMessage.what)
      {
      default: 
        return;
      case -100: 
        RealNameStep0VerifyMobileDownActivity.access$500(this.a);
        return;
      case 3003: 
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, VerifySuccActivity.class);
        paramMessage.putExtra("ish5zzb", RealNameStep0VerifyMobileDownActivity.access$000(this.a));
        paramMessage.putExtra("mSourceId", this.a.mSourceId);
        paramMessage.putExtra("mRealUin", RealNameStep0VerifyMobileDownActivity.access$100(this.a));
        this.a.startActivity(paramMessage);
        this.a.finish();
        return;
      case 3074: 
        if (paramMessage.arg1 == 0)
        {
          do.a().f(RealNameStep0VerifyMobileDownActivity.access$100(this.a));
          cw.a().b(RealNameStep0VerifyMobileDownActivity.access$200(this.a));
          return;
        }
        paramMessage = (f)paramMessage.obj;
        f.a(this.a.getResources(), paramMessage);
        Intent localIntent = new Intent(this.a, RealNameFindFailActivity.class);
        localIntent.putExtra("err_info", paramMessage.c);
        localIntent.putExtra("source_id", this.a.mSourceId);
        localIntent.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$100(this.a));
        localIntent.putExtra("canchange_uin", RealNameStep0VerifyMobileDownActivity.access$300(this.a));
        this.a.startActivity(localIntent);
        return;
      case 4000: 
        if (paramMessage.arg1 == 0)
        {
          cw.a().d(0L, 3, RealNameStep0VerifyMobileDownActivity.access$200(this.a));
          return;
        }
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new vz(this));
        return;
      case 3072: 
        if (paramMessage.arg1 == 0)
        {
          cw.a().d(RealNameStep0VerifyMobileDownActivity.access$200(this.a));
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
          cw.a().d(RealNameStep0VerifyMobileDownActivity.access$200(this.a));
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
          cw.a().a(0L, RealNameStep0VerifyMobileDownActivity.access$100(this.a), 2, "", "", this.a.mFaceData, RealNameStep0VerifyMobileDownActivity.access$400(this.a, this.a.mFrontData), RealNameStep0VerifyMobileDownActivity.access$400(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, RealNameStep0VerifyMobileDownActivity.access$200(this.a));
          return;
        }
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new wa(this));
        return;
      case 100: 
        this.a.showProDialog(this.a, 2131230843, 2131231298, null);
        return;
      }
    } while (paramMessage.arg1 == 0);
    if (paramMessage.arg1 == 124)
    {
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      RealNameStep0VerifyMobileDownActivity.access$200(this.a).removeMessages(-100);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, new wb(this));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    RealNameStep0VerifyMobileDownActivity.access$200(this.a).removeMessages(-100);
    this.a.showUserDialog(paramMessage.c);
    return;
    RealNameStep0VerifyMobileDownActivity.access$902(this.a, false);
    if (paramMessage.arg1 == 0)
    {
      if (RealNameStep0VerifyMobileDownActivity.access$700(this.a) == 1001)
      {
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        paramMessage.putExtra("realname_result", RealNameStep0VerifyMobileDownActivity.access$800(this.a));
        paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$100(this.a));
        paramMessage.putExtra("zzb_recommend_view", RealNameStep0VerifyMobileDownActivity.access$1000(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      if (RealNameStep0VerifyMobileDownActivity.access$700(this.a) == 1003)
      {
        cw.a().e(RealNameStep0VerifyMobileDownActivity.access$100(this.a), 3, RealNameStep0VerifyMobileDownActivity.access$200(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, FaceRecognitionCameraActivity.class);
      paramMessage.putExtra("flag", 2);
      paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$100(this.a));
      paramMessage.putExtra("ish5zzb", RealNameStep0VerifyMobileDownActivity.access$000(this.a));
      paramMessage.putExtra("istry", 3);
      paramMessage.putExtra("scene", 4);
      this.a.startActivity(paramMessage);
      this.a.finish();
      return;
    }
    if (paramMessage.arg1 == 176)
    {
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      RealNameStep0VerifyMobileDownActivity.access$1100(this.a, paramMessage.c);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vy
 * JD-Core Version:    0.7.0.1
 */