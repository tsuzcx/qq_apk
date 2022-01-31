package com.tencent.token.ui;

import android.content.Intent;
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
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

final class wn
  extends bo
{
  wn(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity)
  {
    super(paramRealNameStep0VerifyMobileDownActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    label745:
    label760:
    do
    {
      Object localObject;
      Handler localHandler;
      do
      {
        return;
        e.c("realname  msg.what=" + paramMessage.what + ", msg.arg1=" + paramMessage.arg1);
        switch (paramMessage.what)
        {
        default: 
          return;
        case -100: 
          RealNameStep0VerifyMobileDownActivity.access$100(this.a);
          return;
        case 3074: 
          if (paramMessage.arg1 == 0)
          {
            ax.a().f(RealNameStep0VerifyMobileDownActivity.access$400(this.a));
            af.a().b(RealNameStep0VerifyMobileDownActivity.access$500(this.a));
            this.a.dismissDialog();
            RealNameStep0VerifyMobileDownActivity.access$602(this.a, true);
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
              ((Button)localObject).setOnClickListener(new wo(this));
              this.a.setTitle(2131361842);
              ((ImageView)this.a.findViewById(2131296395)).setImageDrawable(k.a(RealNameStep0VerifyMobileDownActivity.access$400(this.a) + "", s.f(RealNameStep0VerifyMobileDownActivity.access$400(this.a)) + " "));
              a.a().a(8);
              return;
              ((Button)localObject).setText(2131361840);
              paramMessage.setText(2131362583);
            }
          }
          paramMessage = (d)paramMessage.obj;
          d.a(this.a.getResources(), paramMessage);
          localObject = new Intent(this.a, RealNameFindFailActivity.class);
          ((Intent)localObject).putExtra("err_info", paramMessage.c);
          ((Intent)localObject).putExtra("source_id", this.a.mSourceId);
          ((Intent)localObject).putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$400(this.a));
          ((Intent)localObject).putExtra("canchange_uin", RealNameStep0VerifyMobileDownActivity.access$800(this.a));
          this.a.startActivity((Intent)localObject);
          return;
        case 4000: 
          if (paramMessage.arg1 == 0)
          {
            af.a().f(0L, 3, RealNameStep0VerifyMobileDownActivity.access$500(this.a));
            return;
          }
          paramMessage = (d)paramMessage.obj;
          e.c("err " + paramMessage.a);
          d.a(this.a.getResources(), paramMessage);
          e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
          this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new wp(this));
          return;
        case 3072: 
          if (paramMessage.arg1 == 0)
          {
            af.a().d(RealNameStep0VerifyMobileDownActivity.access$500(this.a));
            this.a.dismissDialog();
            return;
          }
          paramMessage = (d)paramMessage.obj;
          this.a.showUserDialog(paramMessage.c);
          return;
        case 3071: 
          if (paramMessage.arg1 != 0) {
            break label760;
          }
          paramMessage = (QueryCaptchaResult)paramMessage.obj;
          if (!paramMessage.mNeedCaptcha) {
            break label745;
          }
          localObject = this.a;
          localHandler = RealNameStep0VerifyMobileDownActivity.access$500(this.a);
        }
      } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
      new CaptchaDialog((BaseActivity)localObject, localHandler, paramMessage).show();
      return;
      af.a().d(RealNameStep0VerifyMobileDownActivity.access$500(this.a));
      return;
      paramMessage = (d)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
      if (paramMessage.arg1 == 0)
      {
        paramMessage = ag.c();
        paramMessage.i();
        paramMessage.n();
        af.a().a(0L, RealNameStep0VerifyMobileDownActivity.access$400(this.a), 2, "", "", this.a.mFaceData, RealNameStep0VerifyMobileDownActivity.access$900(this.a, this.a.mFrontData), RealNameStep0VerifyMobileDownActivity.access$900(this.a, this.a.mBackData), this.a.frontphotoinfo, this.a.backphotoinfo, RealNameStep0VerifyMobileDownActivity.access$500(this.a));
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new wq(this));
      return;
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    } while (paramMessage.arg1 == 0);
    if (paramMessage.arg1 == 124)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      RealNameStep0VerifyMobileDownActivity.access$500(this.a).removeMessages(-100);
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, new wr(this));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    RealNameStep0VerifyMobileDownActivity.access$500(this.a).removeMessages(-100);
    this.a.showUserDialog(paramMessage.c);
    return;
    RealNameStep0VerifyMobileDownActivity.access$1302(this.a, false);
    if (paramMessage.arg1 == 0)
    {
      if (RealNameStep0VerifyMobileDownActivity.access$1100(this.a) == 1001)
      {
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        paramMessage.putExtra("realname_result", RealNameStep0VerifyMobileDownActivity.access$1200(this.a));
        paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$400(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      if (RealNameStep0VerifyMobileDownActivity.access$1100(this.a) == 1003)
      {
        af.a().g(RealNameStep0VerifyMobileDownActivity.access$400(this.a), 3, RealNameStep0VerifyMobileDownActivity.access$500(this.a));
        return;
      }
      this.a.dismissDialog();
      if (t.l() == 0) {}
      for (paramMessage = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramMessage = new Intent(this.a, FaceRecognitionCameraActivity.class))
      {
        paramMessage.putExtra("flag", 2);
        paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$400(this.a));
        paramMessage.putExtra("ish5zzb", RealNameStep0VerifyMobileDownActivity.access$700(this.a));
        paramMessage.putExtra("istry", 3);
        paramMessage.putExtra("scene", 4);
        this.a.startActivity(paramMessage);
        this.a.finish();
        return;
      }
    }
    if (paramMessage.arg1 == 176)
    {
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      RealNameStep0VerifyMobileDownActivity.access$1400(this.a, paramMessage.c);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wn
 * JD-Core Version:    0.7.0.1
 */