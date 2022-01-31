package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.push.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

final class es
  extends bo
{
  es(FaceRecognitionCameraActivity paramFaceRecognitionCameraActivity)
  {
    super(paramFaceRecognitionCameraActivity);
  }
  
  private void a(boolean paramBoolean)
  {
    FaceRecognitionCameraActivity.access$202(this.a, true);
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362118), 2131361800, new fg(this), new fh(this, paramBoolean));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    e.a("facepwd msg.what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    Object localObject;
    label1078:
    label1131:
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
                if ((paramMessage != null) && (paramMessage.length > 0))
                {
                  FaceRecognitionCameraActivity.access$002(this.a, new int[paramMessage.length]);
                  i = 0;
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
            if ((FaceRecognitionCameraActivity.access$300(this.a) == 8) || (FaceRecognitionCameraActivity.access$300(this.a) == 9))
            {
              a(true);
              return;
            }
            a(false);
            return;
            paramMessage = (TextView)this.a.findViewById(2131296625);
          } while (paramMessage == null);
          paramMessage.setText(2131362486);
          return;
          FaceRecognitionCameraActivity.access$402(this.a, (FaceData)paramMessage.obj);
          if (FaceRecognitionCameraActivity.access$100(this.a))
          {
            FaceRecognitionCameraActivity.access$500(this.a).c(3);
            FaceRecognitionCameraActivity.access$600(this.a, FaceRecognitionCameraActivity.access$000(this.a)[0]);
            FaceRecognitionCameraActivity.access$700(this.a).a(false, true, FaceRecognitionCameraActivity.access$000(this.a)[0], 0);
            FaceRecognitionCameraActivity.access$500(this.a).a(FaceRecognitionCameraActivity.access$000(this.a)[0]);
            FaceRecognitionCameraActivity.access$500(this.a).c(7);
            return;
          }
          FaceRecognitionCameraActivity.access$800(this.a);
          return;
          FaceRecognitionCameraActivity.access$500(this.a).c(9);
          FaceRecognitionCameraActivity.access$900(this.a).setVisibility(0);
          FaceRecognitionCameraActivity.access$1000(this.a).setVisibility(0);
          paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
          paramMessage.setDuration(700L);
          localObject = new RotateAnimation(360.0F, 0.0F, 1, 0.5F, 1, 0.5F);
          ((Animation)localObject).setDuration(700L);
          paramMessage.setAnimationListener(new et(this));
          FaceRecognitionCameraActivity.access$900(this.a).startAnimation(paramMessage);
          FaceRecognitionCameraActivity.access$1000(this.a).startAnimation((Animation)localObject);
          return;
          if (paramMessage.arg1 == 0)
          {
            if (FaceRecognitionCameraActivity.access$700(this.a) != null) {
              FaceRecognitionCameraActivity.access$700(this.a).a(true);
            }
            ax.a().f(FaceRecognitionCameraActivity.access$1100(this.a));
            af.a().b(FaceRecognitionCameraActivity.access$1200(this.a));
            this.a.dismissDialog();
            FaceRecognitionCameraActivity.access$1302(this.a, true);
            this.a.setContentView(2130903050);
            this.a.setBackArrowHide();
            localObject = (TextView)this.a.findViewById(2131296396);
            paramMessage = (TextView)this.a.findViewById(2131296397);
            ((TextView)localObject).setText(2131362582);
            paramMessage.setVisibility(0);
            localObject = (Button)this.a.findViewById(2131296398);
            ((Button)localObject).setText(2131361840);
            paramMessage.setText(2131362583);
            ((Button)localObject).setOnClickListener(new fe(this));
            this.a.setTitle(2131361842);
            ((ImageView)this.a.findViewById(2131296395)).setImageDrawable(k.a(FaceRecognitionCameraActivity.access$1100(this.a) + "", s.f(FaceRecognitionCameraActivity.access$1100(this.a)) + " "));
            a.a().a(8);
            return;
          }
          FaceRecognitionCameraActivity.access$900(this.a).setVisibility(4);
          FaceRecognitionCameraActivity.access$1000(this.a).setVisibility(4);
          paramMessage = (d)paramMessage.obj;
          d.a(this.a.getResources(), paramMessage);
          this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, new fk(this));
          return;
          e.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
          if (paramMessage.arg1 != 0) {
            break label1078;
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
            FaceRecognitionCameraActivity.access$500(this.a).postDelayed(new fl(this), 0L);
            return;
          }
          if (FaceRecognitionCameraActivity.access$300(this.a) == 9)
          {
            this.a.setResult(-1);
            this.a.finish();
            return;
          }
        } while (FaceRecognitionCameraActivity.access$300(this.a) != 4);
        af.a().g(FaceRecognitionCameraActivity.access$1100(this.a), 2, FaceRecognitionCameraActivity.access$1200(this.a));
        return;
      } while (i != 4);
      paramMessage = new Intent(this.a, FaceRecognitionDefaultActivity.class);
      paramMessage.putExtra("toastflag", 4);
      paramMessage.addFlags(67108864);
      this.a.startActivity(paramMessage);
      this.a.finish();
      return;
      FaceRecognitionCameraActivity.access$900(this.a).setVisibility(4);
      FaceRecognitionCameraActivity.access$1000(this.a).setVisibility(4);
      localObject = (d)paramMessage.obj;
      i = FaceRecognitionCameraActivity.access$1400(this.a);
      try
      {
        int j = ((Integer)((d)localObject).d).intValue();
        i = j;
      }
      catch (Exception paramMessage)
      {
        break label1131;
        this.a.showUserDialog(2131362547, this.a.getResources().getString(2131362548), 2131361804, 2131361868, new fm(this), new fn(this));
        return;
      }
      d.a(this.a.getResources(), (d)localObject);
      e.c("faceRe ret.mErrCode=" + ((d)localObject).a + "opType" + i);
      if (i == 4) {
        switch (((d)localObject).a)
        {
        case 222: 
        default: 
          this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361804, 2131361914, new fp(this), new fq(this));
          return;
        }
      }
    } while (i != 2);
    if (FaceRecognitionCameraActivity.access$300(this.a) == 6)
    {
      if (((d)localObject).a == 221) {}
      for (i = 2131362489;; i = 2131362104)
      {
        this.a.showUserDialog(i, ((d)localObject).c, 2131361802, 2131362496, new fr(this), new eu(this));
        return;
      }
    }
    if ((FaceRecognitionCameraActivity.access$300(this.a) == 8) || (FaceRecognitionCameraActivity.access$300(this.a) == 9))
    {
      switch (((d)localObject).a)
      {
      default: 
        this.a.showUserDialog(2131361808, ((d)localObject).c, 2131362496, new fi(this), new fj(this));
        return;
      }
      this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, new fi(this), new fj(this));
      return;
    }
    switch (((d)localObject).a)
    {
    default: 
      if (RqdApplication.d()) {
        break;
      }
    }
    for (int i = 2131362494;; i = 2131362495)
    {
      this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361914, i, new fc(this), new fd(this), new ff(this));
      return;
      FaceRecognitionCameraActivity.access$2008(this.a);
      if (FaceRecognitionCameraActivity.access$300(this.a) == 4)
      {
        this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, new ev(this), new ew(this));
        return;
      }
      if (!RqdApplication.d()) {
        i = 2131362494;
      }
      for (paramMessage = this.a.getResources().getString(2131362507); FaceRecognitionCameraActivity.access$2000(this.a) < 5; paramMessage = this.a.getResources().getString(2131362506))
      {
        s.a(FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, FaceRecognitionCameraActivity.access$2000(this.a));
        this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, i, new ex(this), new ey(this), new ez(this));
        return;
        i = 2131362495;
      }
      s.a(FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
      this.a.showUserDialog(2131362491, paramMessage, i, new fa(this));
      return;
      t.b(0L);
      if (!RqdApplication.d()) {
        i = 2131362494;
      }
      for (paramMessage = this.a.getResources().getString(2131362505);; paramMessage = this.a.getResources().getString(2131362504))
      {
        this.a.showUserDialog(2131362104, ((d)localObject).c + "，" + paramMessage, i, new fb(this));
        return;
        i = 2131362495;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.es
 * JD-Core Version:    0.7.0.1
 */