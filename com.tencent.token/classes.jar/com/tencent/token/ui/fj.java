package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.c;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

class fj
  extends cb
{
  fj(FaceRecognitionCameraActivity paramFaceRecognitionCameraActivity)
  {
    super(paramFaceRecognitionCameraActivity);
  }
  
  private void a(f paramf, int paramInt)
  {
    this.a.showUserDialog(paramInt, paramf.c, 2131231034, new ga(this), new gb(this));
  }
  
  private void a(boolean paramBoolean)
  {
    FaceRecognitionCameraActivity.access$202(this.a, true);
    this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231281), 2131230897, new fy(this), new fz(this, paramBoolean));
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    h.a("facepwd msg.what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 3082: 
    case 2: 
    case 13: 
    case 73: 
    case 11: 
    case 71: 
    case 3003: 
    case 3074: 
    case 4004: 
    case 3058: 
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (paramMessage.arg1 != 0);
                if (paramMessage.arg2 == 1)
                {
                  paramMessage = (int[])paramMessage.obj;
                  if ((paramMessage != null) && (paramMessage.length >= 1))
                  {
                    FaceRecognitionCameraActivity.access$002(this.a, new int[paramMessage.length]);
                    while (i < paramMessage.length)
                    {
                      FaceRecognitionCameraActivity.access$000(this.a)[i] = paramMessage[i];
                      i += 1;
                    }
                    FaceRecognitionCameraActivity.access$102(this.a, true);
                    return;
                  }
                  FaceRecognitionCameraActivity.access$102(this.a, false);
                  return;
                }
                FaceRecognitionCameraActivity.access$102(this.a, false);
                return;
              } while (FaceRecognitionCameraActivity.access$200(this.a));
              if ((FaceRecognitionCameraActivity.access$300(this.a) == 8) || (FaceRecognitionCameraActivity.access$300(this.a) == 9) || (FaceRecognitionCameraActivity.access$300(this.a) == 10) || (FaceRecognitionCameraActivity.access$300(this.a) == 11))
              {
                a(true);
                return;
              }
              a(false);
              return;
              paramMessage = (TextView)this.a.findViewById(2131558913);
            } while (paramMessage == null);
            paramMessage.setText(2131231031);
            return;
            try
            {
              FaceRecognitionCameraActivity.access$400(this.a).setStop(false);
              FaceRecognitionCameraActivity.access$500(this.a);
              return;
            }
            catch (Exception paramMessage)
            {
              paramMessage.printStackTrace();
              return;
            }
            FaceRecognitionCameraActivity.access$602(this.a, (FaceData)paramMessage.obj);
            if (FaceRecognitionCameraActivity.access$100(this.a))
            {
              FaceRecognitionCameraActivity.access$700(this.a).setStatus(3);
              FaceRecognitionCameraActivity.access$800(this.a, FaceRecognitionCameraActivity.access$000(this.a)[0]);
              FaceRecognitionCameraActivity.access$400(this.a).a(false, true, FaceRecognitionCameraActivity.access$000(this.a)[0], 0);
              if (FaceRecognitionCameraActivity.access$000(this.a)[0] <= 4)
              {
                FaceRecognitionCameraActivity.access$700(this.a).setVryNodDirection(FaceRecognitionCameraActivity.access$000(this.a)[0]);
                FaceRecognitionCameraActivity.access$700(this.a).setStatus(7);
                return;
              }
              FaceRecognitionCameraActivity.access$700(this.a).setStatus(4);
              return;
            }
            FaceRecognitionCameraActivity.access$900(this.a);
            return;
            if (FaceRecognitionCameraActivity.access$000(this.a)[0] <= 4) {
              FaceRecognitionCameraActivity.access$700(this.a).setStatus(9);
            }
            for (;;)
            {
              FaceRecognitionCameraActivity.access$1000(this.a).setVisibility(0);
              FaceRecognitionCameraActivity.access$1100(this.a).setVisibility(0);
              paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
              paramMessage.setDuration(700L);
              localObject = new RotateAnimation(360.0F, 0.0F, 1, 0.5F, 1, 0.5F);
              ((Animation)localObject).setDuration(700L);
              paramMessage.setAnimationListener(new fk(this));
              FaceRecognitionCameraActivity.access$1000(this.a).startAnimation(paramMessage);
              FaceRecognitionCameraActivity.access$1100(this.a).startAnimation((Animation)localObject);
              return;
              FaceRecognitionCameraActivity.access$700(this.a).setStatus(6);
            }
            this.a.dismissDialog();
            paramMessage = new Intent(this.a, VerifySuccActivity.class);
            paramMessage.putExtra("mRealUin", FaceRecognitionCameraActivity.access$1200(this.a));
            paramMessage.putExtra("ish5zzb", this.a.ish5zzb);
            if ((FaceRecognitionCameraActivity.access$1300(this.a) != null) && (FaceRecognitionCameraActivity.access$1300(this.a).c() == 2)) {
              paramMessage.putExtra("mSourceId", 1);
            }
            this.a.startActivity(paramMessage);
            this.a.finish();
            return;
            if (paramMessage.arg1 == 0)
            {
              if (FaceRecognitionCameraActivity.access$400(this.a) != null) {
                FaceRecognitionCameraActivity.access$400(this.a).setStop(true);
              }
              do.a().f(FaceRecognitionCameraActivity.access$1200(this.a));
              cw.a().b(FaceRecognitionCameraActivity.access$1400(this.a));
              return;
            }
            FaceRecognitionCameraActivity.access$1000(this.a).setVisibility(4);
            FaceRecognitionCameraActivity.access$1100(this.a).setVisibility(4);
            paramMessage = (f)paramMessage.obj;
            f.a(this.a.getResources(), paramMessage);
            this.a.showUserDialog(2131230843, paramMessage.c, 2131230881, new fv(this));
            return;
            h.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
            if (paramMessage.arg1 != 0) {
              break label1189;
            }
            i = paramMessage.arg2;
            if (i != 2) {
              break;
            }
            if (FaceRecognitionCameraActivity.access$300(this.a) == 6)
            {
              paramMessage = new Intent(this.a, FaceRecognitionDefaultActivity.class);
              paramMessage.putExtra("toastflag", 2);
              paramMessage.addFlags(67108864);
              this.a.startActivity(paramMessage);
              this.a.finish();
              return;
            }
            if (FaceRecognitionCameraActivity.access$300(this.a) == 8)
            {
              FaceRecognitionCameraActivity.access$700(this.a).postDelayed(new gc(this), 0L);
              return;
            }
            if (FaceRecognitionCameraActivity.access$300(this.a) == 10)
            {
              FaceRecognitionCameraActivity.access$700(this.a).postDelayed(new gd(this), 0L);
              return;
            }
            if (FaceRecognitionCameraActivity.access$300(this.a) == 9)
            {
              this.a.setResult(-1);
              this.a.finish();
              return;
            }
            if (FaceRecognitionCameraActivity.access$300(this.a) == 11)
            {
              this.a.setResult(-1);
              this.a.finish();
              return;
            }
            if (FaceRecognitionCameraActivity.access$300(this.a) == 4)
            {
              cw.a().e(FaceRecognitionCameraActivity.access$1200(this.a), 2, FaceRecognitionCameraActivity.access$1400(this.a));
              return;
            }
          } while (FaceRecognitionCameraActivity.access$300(this.a) != 12);
          this.a.goNextVerify();
          return;
        } while (i != 4);
        paramMessage = new Intent(this.a, FaceRecognitionDefaultActivity.class);
        paramMessage.addFlags(67108864);
        this.a.startActivity(paramMessage);
        this.a.finish();
        return;
        FaceRecognitionCameraActivity.access$1000(this.a).setVisibility(4);
        FaceRecognitionCameraActivity.access$1100(this.a).setVisibility(4);
        localObject = (f)paramMessage.obj;
        paramMessage = (c)((f)localObject).d;
        i = FaceRecognitionCameraActivity.access$1600(this.a);
        try
        {
          int j = paramMessage.a();
          i = j;
        }
        catch (Exception paramMessage)
        {
          break label1244;
          this.a.showUserDialog(2131230834, this.a.getResources().getString(2131230831), 2131230886, 2131231507, new ge(this), new gf(this));
          return;
        }
        f.a(this.a.getResources(), (f)localObject);
        h.c("faceRe ret.mErrCode=" + ((f)localObject).a + "opType" + i);
        if (i == 4) {
          switch (((f)localObject).a)
          {
          case 222: 
          default: 
            this.a.showUserDialog(2131230935, ((f)localObject).c, 2131230886, 2131230881, new gh(this), new gi(this));
            return;
          }
        }
      } while (i != 2);
      if ((FaceRecognitionCameraActivity.access$300(this.a) == 6) || (FaceRecognitionCameraActivity.access$300(this.a) == 12) || (FaceRecognitionCameraActivity.access$300(this.a) == 13))
      {
        if (((f)localObject).a == 221) {}
        for (i = 2131231035;; i = 2131230935)
        {
          this.a.showUserDialog(i, ((f)localObject).c, 2131231388, 2131231034, new gj(this), new fl(this), new fm(this));
          return;
        }
      }
      if ((FaceRecognitionCameraActivity.access$300(this.a) == 8) || (FaceRecognitionCameraActivity.access$300(this.a) == 9) || (FaceRecognitionCameraActivity.access$300(this.a) == 10) || (FaceRecognitionCameraActivity.access$300(this.a) == 11))
      {
        switch (((f)localObject).a)
        {
        default: 
          a((f)localObject, 2131230843);
          return;
        }
        a((f)localObject, 2131231035);
        return;
      }
      switch (((f)localObject).a)
      {
      default: 
        if (RqdApplication.g()) {
          break;
        }
      }
      for (i = 2131231033;; i = 2131231032)
      {
        this.a.showUserDialog(2131230935, ((f)localObject).c, 2131230881, i, new fu(this), new fw(this), new fx(this));
        return;
        FaceRecognitionCameraActivity.access$2108(this.a);
        if (FaceRecognitionCameraActivity.access$300(this.a) == 4)
        {
          this.a.showUserDialog(2131231035, ((f)localObject).c, 2131231034, new fn(this), new fo(this));
          return;
        }
        if (!RqdApplication.g()) {
          i = 2131231033;
        }
        for (paramMessage = this.a.getResources().getString(2131231038); FaceRecognitionCameraActivity.access$2100(this.a) < 5; paramMessage = this.a.getResources().getString(2131231037))
        {
          w.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, FaceRecognitionCameraActivity.access$2100(this.a));
          this.a.showUserDialog(2131231035, ((f)localObject).c, 2131231034, i, new fp(this), new fq(this), new fr(this));
          return;
          i = 2131231032;
        }
        w.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
        this.a.showUserDialog(2131231036, paramMessage, i, new fs(this));
        return;
        x.b(0L);
        if (!RqdApplication.g()) {
          i = 2131231033;
        }
        for (paramMessage = this.a.getResources().getString(2131231029);; paramMessage = this.a.getResources().getString(2131231028))
        {
          this.a.showUserDialog(2131230935, ((f)localObject).c + "，" + paramMessage, i, new ft(this));
          return;
          i = 2131231032;
        }
      }
    case 4104: 
      label1189:
      label1244:
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showToast(2131231411);
      return;
    }
    FaceRecognitionCameraActivity.access$2300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fj
 * JD-Core Version:    0.7.0.1
 */