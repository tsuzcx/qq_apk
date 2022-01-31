package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.push.a;
import com.tencent.token.db;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

final class wy
  extends bo
{
  wy(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity)
  {
    super(paramRealNameStep0VerifyMobileUpActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    Handler localHandler;
    do
    {
      return;
      e.c("mHandler " + paramMessage.what + paramMessage.arg1);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        RealNameStep0VerifyMobileUpActivity.access$302(this.a, 0);
        this.a.showProDialogWithoutShutDown(this.a, this.a.getString(2131361844));
        postDelayed(this.a.mVrySMSRunnable, 10000L);
        return;
      case 4000: 
        if (paramMessage.arg1 == 0)
        {
          af.a().f(0L, 3, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
          return;
        }
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new wz(this));
        return;
      case 3072: 
        if (paramMessage.arg1 == 0)
        {
          af.a().d(RealNameStep0VerifyMobileUpActivity.access$200(this.a));
          this.a.dismissDialog();
          return;
        }
        paramMessage = (d)paramMessage.obj;
        this.a.showUserDialog(paramMessage.c);
        return;
      case 3071: 
        if (paramMessage.arg1 != 0) {
          break label431;
        }
        paramMessage = (QueryCaptchaResult)paramMessage.obj;
        if (!paramMessage.mNeedCaptcha) {
          break label416;
        }
        localObject = this.a;
        localHandler = RealNameStep0VerifyMobileUpActivity.access$200(this.a);
      }
    } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
    new CaptchaDialog((BaseActivity)localObject, localHandler, paramMessage).show();
    return;
    label416:
    af.a().d(RealNameStep0VerifyMobileUpActivity.access$200(this.a));
    return;
    label431:
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      paramMessage = ag.c();
      paramMessage.i();
      paramMessage.n();
      af.a().a(0L, RealNameStep0VerifyMobileUpActivity.access$100(this.a), 2, "", "", this.a.mFaceData, RealNameStep0VerifyMobileUpActivity.access$400(this.a, this.a.mFrontData), RealNameStep0VerifyMobileUpActivity.access$400(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new xa(this));
    return;
    if (paramMessage.arg1 == 0)
    {
      ax.a().f(RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      af.a().b(RealNameStep0VerifyMobileUpActivity.access$200(this.a));
      this.a.dismissDialog();
      RealNameStep0VerifyMobileUpActivity.access$502(this.a, true);
      this.a.setContentView(2130903050);
      this.a.setBackArrowHide();
      localObject = (TextView)this.a.findViewById(2131296396);
      paramMessage = (TextView)this.a.findViewById(2131296397);
      ((TextView)localObject).setText(2131362582);
      paramMessage.setVisibility(0);
      localObject = (Button)this.a.findViewById(2131296398);
      if (this.a.mSourceId == 1)
      {
        ((Button)localObject).setText(2131361901);
        paramMessage.setText(2131362584);
      }
      for (;;)
      {
        ((Button)localObject).setOnClickListener(new xb(this));
        this.a.setTitle(2131361842);
        ((ImageView)this.a.findViewById(2131296395)).setImageDrawable(k.a(RealNameStep0VerifyMobileUpActivity.access$100(this.a) + "", s.f(RealNameStep0VerifyMobileUpActivity.access$100(this.a)) + " "));
        a.a().a(8);
        return;
        ((Button)localObject).setText(2131361840);
        paramMessage.setText(2131362583);
      }
    }
    this.a.dismissDialog();
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    Object localObject = new Intent(this.a, RealNameFindFailActivity.class);
    ((Intent)localObject).putExtra("err_info", paramMessage.c);
    ((Intent)localObject).putExtra("source_id", this.a.mSourceId);
    ((Intent)localObject).putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
    ((Intent)localObject).putExtra("canchange_uin", this.a.canchange_uin);
    this.a.startActivity((Intent)localObject);
    return;
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362230), 2131361800, null);
    this.a.sendUpSmsBySMSAPP(db.c, db.d);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1001)
      {
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        paramMessage.putExtra("realname_result", RealNameStep0VerifyMobileUpActivity.access$700(this.a));
        paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1003)
      {
        af.a().g(RealNameStep0VerifyMobileUpActivity.access$100(this.a), 3, RealNameStep0VerifyMobileUpActivity.access$200(this.a));
        return;
      }
      this.a.dismissDialog();
      if (t.l() == 0) {}
      for (paramMessage = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramMessage = new Intent(this.a, FaceRecognitionCameraActivity.class))
      {
        paramMessage.putExtra("flag", 2);
        paramMessage.putExtra("istry", 3);
        paramMessage.putExtra("scene", 4);
        paramMessage.putExtra("ish5zzb", RealNameStep0VerifyMobileUpActivity.access$600(this.a));
        paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
    }
    if (paramMessage.arg1 == 176)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      paramMessage = paramMessage.c;
      this.a.showUserDialog(2131361808, paramMessage, 2131361800, new xc(this), new xd(this));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (RealNameStep0VerifyMobileUpActivity.access$300(this.a) < 4))
    {
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wy
 * JD-Core Version:    0.7.0.1
 */