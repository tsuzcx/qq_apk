package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class vj
  extends cb
{
  vj(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity)
  {
    super(paramRealNameSmsContentTipActivity);
  }
  
  private void a()
  {
    RealNameSmsContentTipActivity.access$1200(this.a).setVisibility(4);
    RealNameSmsContentTipActivity.access$1300(this.a).setClickable(true);
    RealNameSmsContentTipActivity.access$1400(this.a).setText(this.a.getResources().getString(2131231121));
  }
  
  private void a(String paramString)
  {
    this.a.showUserDialog(2131230843, paramString, 2131230897, new vq(this), new vr(this));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    h.c("mHandler " + paramMessage.what + paramMessage.arg1);
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      RealNameSmsContentTipActivity.access$202(this.a, 0);
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    case 4000: 
      if (paramMessage.arg1 == 0)
      {
        cw.a().d(0L, 3, this.a.mHandler);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new vk(this));
      return;
    case 3072: 
      if (paramMessage.arg1 == 0)
      {
        cw.a().d(this.a.mHandler);
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
        cw.a().d(this.a.mHandler);
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
        cw.a().a(0L, RealNameSmsContentTipActivity.access$100(this.a), 2, "", "", this.a.mFaceData, RealNameSmsContentTipActivity.access$300(this.a, this.a.mFrontData), RealNameSmsContentTipActivity.access$300(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, this.a.mHandler);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new vl(this));
      return;
    case 3067: 
      if (paramMessage.arg1 == 0)
      {
        postDelayed(this.a.mVrySMSRunnable, 10000L);
        return;
      }
      this.a.dismissDialog();
      localObject = (f)paramMessage.obj;
      f.a(this.a.getResources(), (f)localObject);
      if ((paramMessage.arg1 == 193) || (paramMessage.arg1 == 194))
      {
        this.a.showUserDialog(2131230843, ((f)localObject).c, 2131231276, new vm(this));
        return;
      }
      this.a.showUserDialog(2131230843, ((f)localObject).c, 2131230881, 2131230886, new vn(this), new vp(this));
      return;
    case 3003: 
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, VerifySuccActivity.class);
      paramMessage.putExtra("mRealUin", RealNameSmsContentTipActivity.access$100(this.a));
      paramMessage.putExtra("mSourceId", RealNameSmsContentTipActivity.access$600(this.a));
      paramMessage.putExtra("ish5zzb", RealNameSmsContentTipActivity.access$700(this.a));
      this.a.startActivity(paramMessage);
      this.a.finish();
      return;
    case 3074: 
      if (paramMessage.arg1 == 0)
      {
        do.a().f(RealNameSmsContentTipActivity.access$100(this.a));
        cw.a().b(this.a.mHandler);
        return;
      }
      a();
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      localObject = new Intent(this.a, RealNameFindFailActivity.class);
      ((Intent)localObject).putExtra("err_info", paramMessage.c);
      ((Intent)localObject).putExtra("source_id", RealNameSmsContentTipActivity.access$600(this.a));
      ((Intent)localObject).putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
      ((Intent)localObject).putExtra("canchange_uin", this.a.canchange_uin);
      this.a.startActivity((Intent)localObject);
      return;
    case 4: 
      this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231588), 2131230897, null);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      if (RealNameSmsContentTipActivity.access$000(this.a) == 1001)
      {
        this.a.dismissDialog();
        a();
        paramMessage = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        paramMessage.putExtra("realname_result", RealNameSmsContentTipActivity.access$800(this.a));
        paramMessage.putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
        paramMessage.putExtra("zzb_recommend_view", RealNameSmsContentTipActivity.access$900(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      if (RealNameSmsContentTipActivity.access$000(this.a) == 1003)
      {
        cw.a().e(RealNameSmsContentTipActivity.access$100(this.a), 3, this.a.mHandler);
        return;
      }
      this.a.dismissDialog();
      a();
      paramMessage = new Intent(this.a, FaceRecognitionCameraActivity.class);
      paramMessage.putExtra("ish5zzb", RealNameSmsContentTipActivity.access$700(this.a));
      paramMessage.putExtra("flag", 2);
      paramMessage.putExtra("istry", 3);
      paramMessage.putExtra("scene", 4);
      paramMessage.putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
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
    if ((paramMessage.a == 146) && (RealNameSmsContentTipActivity.access$200(this.a) < 4))
    {
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    }
    RealNameSmsContentTipActivity.access$1000(this.a).setVisibility(0);
    RealNameSmsContentTipActivity.access$1000(this.a).setText(paramMessage.c);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vj
 * JD-Core Version:    0.7.0.1
 */