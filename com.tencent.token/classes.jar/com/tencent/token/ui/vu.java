package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

final class vu
  extends bo
{
  vu(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity)
  {
    super(paramRealNameSmsContentTipActivity);
  }
  
  private void a()
  {
    RealNameSmsContentTipActivity.access$1200(this.a).setVisibility(4);
    RealNameSmsContentTipActivity.access$1300(this.a).setClickable(true);
    RealNameSmsContentTipActivity.access$1400(this.a).setText(this.a.getResources().getString(2131361880));
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
        RealNameSmsContentTipActivity.access$202(this.a, 0);
        postDelayed(this.a.mVrySMSRunnable, 10000L);
        return;
      case 4000: 
        if (paramMessage.arg1 == 0)
        {
          af.a().f(0L, 3, this.a.mHandler);
          return;
        }
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new vv(this));
        return;
      case 3072: 
        if (paramMessage.arg1 == 0)
        {
          af.a().d(this.a.mHandler);
          this.a.dismissDialog();
          return;
        }
        paramMessage = (d)paramMessage.obj;
        this.a.showUserDialog(paramMessage.c);
        return;
      case 3071: 
        if (paramMessage.arg1 != 0) {
          break label419;
        }
        paramMessage = (QueryCaptchaResult)paramMessage.obj;
        if (!paramMessage.mNeedCaptcha) {
          break label404;
        }
        localObject = this.a;
        localHandler = this.a.mHandler;
      }
    } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
    new CaptchaDialog((BaseActivity)localObject, localHandler, paramMessage).show();
    return;
    label404:
    af.a().d(this.a.mHandler);
    return;
    label419:
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      paramMessage = ag.c();
      paramMessage.i();
      paramMessage.n();
      af.a().a(0L, RealNameSmsContentTipActivity.access$100(this.a), 2, "", "", this.a.mFaceData, RealNameSmsContentTipActivity.access$300(this.a, this.a.mFrontData), RealNameSmsContentTipActivity.access$300(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, this.a.mHandler);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new vw(this));
    return;
    if (paramMessage.arg1 == 0)
    {
      postDelayed(this.a.mVrySMSRunnable, 10000L);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 169)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      localObject = new Intent(this.a, RealNameFindFailActivity.class);
      ((Intent)localObject).putExtra("err_info", paramMessage.c);
      ((Intent)localObject).putExtra("source_id", RealNameSmsContentTipActivity.access$400(this.a));
      ((Intent)localObject).putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
      ((Intent)localObject).putExtra("canchange_uin", this.a.canchange_uin);
      this.a.startActivity((Intent)localObject);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, 2131361804, new vx(this), new vz(this));
    return;
    if (paramMessage.arg1 == 0)
    {
      ax.a().f(RealNameSmsContentTipActivity.access$100(this.a));
      af.a().b(this.a.mHandler);
      this.a.dismissDialog();
      RealNameSmsContentTipActivity.access$702(this.a, true);
      this.a.setContentView(2130903050);
      this.a.setBackArrowHide();
      localObject = (TextView)this.a.findViewById(2131296396);
      paramMessage = (TextView)this.a.findViewById(2131296397);
      ((TextView)localObject).setText(2131362582);
      paramMessage.setVisibility(0);
      localObject = (Button)this.a.findViewById(2131296398);
      if (RealNameSmsContentTipActivity.access$400(this.a) == 1)
      {
        ((Button)localObject).setText(2131361901);
        paramMessage.setText(2131362584);
      }
      for (;;)
      {
        ((Button)localObject).setOnClickListener(new wa(this));
        this.a.setTitle(2131361842);
        ((ImageView)this.a.findViewById(2131296395)).setImageDrawable(k.a(RealNameSmsContentTipActivity.access$100(this.a) + "", s.f(RealNameSmsContentTipActivity.access$100(this.a)) + " "));
        a.a().a(8);
        return;
        ((Button)localObject).setText(2131361840);
        paramMessage.setText(2131362583);
      }
    }
    a();
    this.a.dismissDialog();
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    Object localObject = new Intent(this.a, RealNameFindFailActivity.class);
    ((Intent)localObject).putExtra("err_info", paramMessage.c);
    ((Intent)localObject).putExtra("source_id", RealNameSmsContentTipActivity.access$400(this.a));
    ((Intent)localObject).putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
    ((Intent)localObject).putExtra("canchange_uin", this.a.canchange_uin);
    this.a.startActivity((Intent)localObject);
    return;
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362230), 2131361800, null);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (RealNameSmsContentTipActivity.access$000(this.a) == 1001)
      {
        this.a.dismissDialog();
        a();
        paramMessage = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        paramMessage.putExtra("realname_result", RealNameSmsContentTipActivity.access$800(this.a));
        paramMessage.putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      if (RealNameSmsContentTipActivity.access$000(this.a) == 1003)
      {
        af.a().g(RealNameSmsContentTipActivity.access$100(this.a), 3, this.a.mHandler);
        return;
      }
      this.a.dismissDialog();
      a();
      if (t.l() == 0) {}
      for (paramMessage = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramMessage = new Intent(this.a, FaceRecognitionCameraActivity.class))
      {
        paramMessage.putExtra("ish5zzb", RealNameSmsContentTipActivity.access$900(this.a));
        paramMessage.putExtra("flag", 2);
        paramMessage.putExtra("istry", 3);
        paramMessage.putExtra("scene", 4);
        paramMessage.putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
    }
    if (paramMessage.arg1 == 176)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      paramMessage = paramMessage.c;
      this.a.showUserDialog(2131361808, paramMessage, 2131361800, new wb(this), new wc(this));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
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
 * Qualified Name:     com.tencent.token.ui.vu
 * JD-Core Version:    0.7.0.1
 */