package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.Face;
import com.tencent.jni.Face.ImgData;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.push.a;
import com.tencent.token.cx;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceImageView;
import com.tencent.token.ui.base.co;
import com.tencent.token.utils.k;
import com.tencent.token.utils.n;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

final class fz
  extends Handler
{
  fz(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  private void a(boolean paramBoolean)
  {
    FaceRecognitionCameraActivityOld.access$002(this.a, true);
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362118), 2131361800, new gp(this), new gq(this, paramBoolean));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    e.a("facepwd msg.what=" + paramMessage.what);
    long l;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 12: 
    case 13: 
    case 10: 
    case 11: 
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
              } while (FaceRecognitionCameraActivityOld.access$000(this.a));
              if (FaceRecognitionCameraActivityOld.access$100(this.a) == 2)
              {
                if ((FaceRecognitionCameraActivityOld.access$200(this.a) == 0) || (FaceRecognitionCameraActivityOld.access$200(this.a) == 4))
                {
                  a(true);
                  return;
                }
                a(false);
                return;
              }
              a(false);
              return;
              FaceRecognitionCameraActivityOld.access$300(this.a).a(1);
              return;
              paramMessage = (TextView)this.a.findViewById(2131296625);
            } while (paramMessage == null);
            paramMessage.setText(2131362486);
            return;
          } while (paramMessage.arg1 == 0);
          e.b("msg.arg1 = " + paramMessage.arg1 + ",msg.arg2=" + paramMessage.arg2);
          FaceRecognitionCameraActivityOld.access$300(this.a).a(paramMessage.arg1, paramMessage.arg2);
          FaceRecognitionCameraActivityOld.access$300(this.a).invalidate();
          return;
          e.a("flag=" + FaceRecognitionCameraActivityOld.access$100(this.a));
          if (FaceRecognitionCameraActivityOld.access$100(this.a) == 1)
          {
            e.a("OPTYPE_REGIST step=" + FaceRecognitionCameraActivityOld.access$400(this.a));
            if (FaceRecognitionCameraActivityOld.access$400(this.a) <= 0)
            {
              FaceRecognitionCameraActivityOld.access$502(this.a, (Face.ImgData)paramMessage.obj);
              FaceRecognitionCameraActivityOld.access$300(this.a).a(0);
              paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
              paramMessage.putExtra("data", FaceRecognitionCameraActivityOld.access$500(this.a).img_data);
              this.a.startActivityForResult(paramMessage, 100);
              return;
            }
            FaceRecognitionCameraActivityOld.access$602(this.a, (Face.ImgData)paramMessage.obj);
            FaceRecognitionCameraActivityOld.access$300(this.a).a(0);
            paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
            paramMessage.putExtra("data", FaceRecognitionCameraActivityOld.access$600(this.a).img_data);
            this.a.startActivityForResult(paramMessage, 100);
            return;
          }
          if (FaceRecognitionCameraActivityOld.access$100(this.a) != 2) {
            break;
          }
          paramMessage = (Face.ImgData)paramMessage.obj;
        } while (paramMessage == null);
        FaceRecognitionCameraActivityOld.access$702(this.a, Face.EncodeData(new Face.ImgData[] { paramMessage }));
        if (FaceRecognitionCameraActivityOld.access$700(this.a) == null) {
          break label835;
        }
        if (FaceRecognitionCameraActivityOld.access$200(this.a) != 2) {
          break;
        }
        e.c("startRecord");
      } while (FaceRecognitionCameraActivityOld.access$300(this.a).b() == 2);
      FaceRecognitionCameraActivityOld.access$802(this.a, true);
      if (FaceRecognitionCameraActivityOld.access$900(this.a))
      {
        n.a().a(FaceRecognitionCameraActivityOld.access$1000(this.a), FaceRecognitionCameraActivityOld.access$1000(this.a).a, FaceRecognitionCameraActivityOld.access$1100(this.a));
        return;
      }
      af.a().a(0L, FaceRecognitionCameraActivityOld.access$700(this.a), FaceRecognitionCameraActivityOld.access$1100(this.a), null);
      FaceRecognitionCameraActivityOld.access$300(this.a).a(2);
      return;
      if (FaceRecognitionCameraActivityOld.access$200(this.a) == 3) {
        l = FaceRecognitionCameraActivityOld.access$1200(this.a);
      }
      break;
    }
    for (;;)
    {
      int i = FaceRecognitionCameraActivityOld.access$1300(this.a);
      FaceRecognitionCameraActivityOld.access$802(this.a, true);
      af.a().a(0L, l, FaceRecognitionCameraActivityOld.access$100(this.a), FaceRecognitionCameraActivityOld.access$700(this.a), i, FaceRecognitionCameraActivityOld.access$1400(this.a), FaceRecognitionCameraActivityOld.access$1100(this.a));
      FaceRecognitionCameraActivityOld.access$1502(this.a, FaceRecognitionCameraActivityOld.access$100(this.a));
      if ((FaceRecognitionCameraActivityOld.access$200(this.a) != 0) && (FaceRecognitionCameraActivityOld.access$200(this.a) != 1)) {
        break;
      }
      FaceRecognitionCameraActivityOld.access$300(this.a).a(2);
      return;
      if (FaceRecognitionCameraActivityOld.access$200(this.a) > 0)
      {
        if (ax.a().e() != null) {
          l = ax.a().e().mRealUin;
        }
      }
      else
      {
        l = t.e();
        continue;
        label835:
        e.a("face OPTYPE_VALIDATION serverData == null,validationType=" + FaceRecognitionCameraActivityOld.access$200(this.a));
        return;
        if (FaceRecognitionCameraActivityOld.access$100(this.a) == 3)
        {
          e.a("OPTYPE_REALNAME_REG step=" + FaceRecognitionCameraActivityOld.access$400(this.a));
          if (FaceRecognitionCameraActivityOld.access$400(this.a) <= 0)
          {
            FaceRecognitionCameraActivityOld.access$502(this.a, (Face.ImgData)paramMessage.obj);
            FaceRecognitionCameraActivityOld.access$300(this.a).a(0);
            paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
            paramMessage.putExtra("data", FaceRecognitionCameraActivityOld.access$500(this.a).img_data);
            this.a.startActivityForResult(paramMessage, 100);
            return;
          }
          FaceRecognitionCameraActivityOld.access$602(this.a, (Face.ImgData)paramMessage.obj);
          FaceRecognitionCameraActivityOld.access$300(this.a).a(0);
          paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
          paramMessage.putExtra("data", FaceRecognitionCameraActivityOld.access$600(this.a).img_data);
          this.a.startActivityForResult(paramMessage, 100);
          return;
        }
        if (FaceRecognitionCameraActivityOld.access$100(this.a) != 4) {
          break;
        }
        FaceRecognitionCameraActivityOld.access$502(this.a, (Face.ImgData)paramMessage.obj);
        FaceRecognitionCameraActivityOld.access$300(this.a).a(0);
        paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
        paramMessage.putExtra("data", FaceRecognitionCameraActivityOld.access$500(this.a).img_data);
        paramMessage.putExtra("flag", 4);
        this.a.startActivityForResult(paramMessage, 100);
        return;
        e.c("RECORD_ERROR");
        af.a().a(0L, FaceRecognitionCameraActivityOld.access$700(this.a), FaceRecognitionCameraActivityOld.access$1100(this.a), null);
        FaceRecognitionCameraActivityOld.access$300(this.a).a(2);
        return;
        e.c("RECORD_END");
        n.a().c();
        af.a().a(0L, FaceRecognitionCameraActivityOld.access$700(this.a), FaceRecognitionCameraActivityOld.access$1100(this.a), n.a().b());
        FaceRecognitionCameraActivityOld.access$300(this.a).a(2);
        return;
        if (paramMessage.arg1 == 0)
        {
          if (FaceRecognitionCameraActivityOld.access$1000(this.a) != null) {
            FaceRecognitionCameraActivityOld.access$1000(this.a).d();
          }
          ax.a().f(FaceRecognitionCameraActivityOld.access$1200(this.a));
          af.a().b(FaceRecognitionCameraActivityOld.access$1100(this.a));
          this.a.dismissDialog();
          FaceRecognitionCameraActivityOld.access$1602(this.a, true);
          this.a.setContentView(2130903050);
          this.a.setBackArrowHide();
          localObject = (TextView)this.a.findViewById(2131296396);
          paramMessage = (TextView)this.a.findViewById(2131296397);
          ((TextView)localObject).setText(2131362582);
          paramMessage.setVisibility(0);
          localObject = (Button)this.a.findViewById(2131296398);
          ((Button)localObject).setText(2131361840);
          paramMessage.setText(2131362583);
          ((Button)localObject).setOnClickListener(new ga(this));
          this.a.setTitle(2131361842);
          ((ImageView)this.a.findViewById(2131296395)).setImageDrawable(k.a(FaceRecognitionCameraActivityOld.access$1200(this.a) + "", s.f(FaceRecognitionCameraActivityOld.access$1200(this.a)) + " "));
          a.a().a(8);
          return;
        }
        paramMessage = (d)paramMessage.obj;
        d.a(this.a.getResources(), paramMessage);
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, new gm(this));
        return;
        e.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
        if (paramMessage.arg1 == 0)
        {
          i = paramMessage.arg2;
          if (i == 1)
          {
            FaceRecognitionCameraActivityOld.access$1700(this.a).a();
            if (ax.a().e() != null)
            {
              ax.a().e().mIsRegisterFacePwd = true;
              ax.a().c(ax.a().e());
              e.c(" K_MSG_POST_FACERECOGNITION getCurrentUser = " + ax.a().e().mIsRegisterFacePwd);
            }
            FaceRecognitionCameraActivityOld.access$1800(this.a).postDelayed(new gt(this), 1000L);
            return;
          }
          if (i == 2)
          {
            if (FaceRecognitionCameraActivityOld.access$200(this.a) == 1)
            {
              paramMessage = new Intent(this.a, FaceRecognitionDefaultActivity.class);
              paramMessage.putExtra("toastflag", 2);
              paramMessage.addFlags(67108864);
              this.a.startActivity(paramMessage);
              this.a.finish();
              return;
            }
            if (FaceRecognitionCameraActivityOld.access$200(this.a) == 4)
            {
              FaceRecognitionCameraActivityOld.access$300(this.a).a(2);
              FaceRecognitionCameraActivityOld.access$300(this.a).postDelayed(new gu(this), 0L);
              return;
            }
            if (FaceRecognitionCameraActivityOld.access$200(this.a) == 2) {
              break;
            }
            if (FaceRecognitionCameraActivityOld.access$200(this.a) == 3)
            {
              af.a().g(FaceRecognitionCameraActivityOld.access$1200(this.a), 2, FaceRecognitionCameraActivityOld.access$1100(this.a));
              return;
            }
            RqdApplication.f();
            s.a(FaceRecognitionCameraActivityOld.LANUCH_RETRY_COUNT, 0);
            FaceRecognitionCameraActivityOld.access$300(this.a).a(3);
            this.a.startAnimation();
            return;
          }
          if (i != 4) {
            break;
          }
          paramMessage = new Intent(this.a, FaceRecognitionDefaultActivity.class);
          paramMessage.putExtra("toastflag", 4);
          paramMessage.addFlags(67108864);
          this.a.startActivity(paramMessage);
          this.a.finish();
          return;
        }
        Object localObject = (d)paramMessage.obj;
        i = FaceRecognitionCameraActivityOld.access$1500(this.a);
        try
        {
          int j = ((Integer)((d)localObject).d).intValue();
          i = j;
        }
        catch (Exception paramMessage)
        {
          label1945:
          break label1945;
          this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361804, 2131361914, new gy(this), new gz(this));
          return;
        }
        d.a(this.a.getResources(), (d)localObject);
        e.c("faceRe ret.mErrCode=" + ((d)localObject).a);
        if (i == 1) {
          if (((d)localObject).a == 228)
          {
            this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361804, 2131362500, new gv(this), new gw(this));
            return;
          }
        }
        if (i == 4)
        {
          switch (((d)localObject).a)
          {
          case 222: 
          default: 
            this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361804, 2131361914, new gd(this), new ge(this));
            return;
          }
          this.a.showUserDialog(2131362547, this.a.getResources().getString(2131362548), 2131361804, 2131361868, new ha(this), new gb(this));
          return;
        }
        if (i != 2) {
          break;
        }
        if (FaceRecognitionCameraActivityOld.access$200(this.a) == 1)
        {
          if (((d)localObject).a == 221) {}
          for (i = 2131362489;; i = 2131362104)
          {
            this.a.showUserDialog(i, ((d)localObject).c, 2131361802, 2131362496, new gf(this), new gg(this));
            return;
          }
        }
        if (FaceRecognitionCameraActivityOld.access$200(this.a) == 2) {
          break;
        }
        if (FaceRecognitionCameraActivityOld.access$200(this.a) == 4)
        {
          switch (((d)localObject).a)
          {
          default: 
            this.a.showUserDialog(2131361808, ((d)localObject).c, 2131362496, new gr(this), new gs(this));
            return;
          }
          this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, new gr(this), new gs(this));
          return;
        }
        switch (((d)localObject).a)
        {
        default: 
          if (RqdApplication.d()) {
            break;
          }
        }
        for (i = 2131362494;; i = 2131362495)
        {
          this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361914, i, new gn(this), new go(this));
          return;
          FaceRecognitionCameraActivityOld.access$2008(this.a);
          if (FaceRecognitionCameraActivityOld.access$200(this.a) == 3)
          {
            this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, new gh(this));
            return;
          }
          if (!RqdApplication.d()) {
            i = 2131362494;
          }
          for (paramMessage = this.a.getResources().getString(2131362507); FaceRecognitionCameraActivityOld.access$2000(this.a) < 5; paramMessage = this.a.getResources().getString(2131362506))
          {
            s.a(FaceRecognitionCameraActivityOld.LANUCH_RETRY_COUNT, FaceRecognitionCameraActivityOld.access$2000(this.a));
            this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, i, new gi(this), new gj(this));
            return;
            i = 2131362495;
          }
          s.a(FaceRecognitionCameraActivityOld.LANUCH_RETRY_COUNT, 0);
          this.a.showUserDialog(2131362491, paramMessage, i, new gk(this));
          return;
          t.b(0L);
          if (!RqdApplication.d()) {
            i = 2131362494;
          }
          for (paramMessage = this.a.getResources().getString(2131362505);; paramMessage = this.a.getResources().getString(2131362504))
          {
            this.a.showUserDialog(2131362104, ((d)localObject).c + "，" + paramMessage, i, new gl(this));
            return;
            i = 2131362495;
          }
        }
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (cx)paramMessage.obj;
          localObject = new Intent(this.a, FacePKActivity.class);
          ((Intent)localObject).putExtra("help_url", paramMessage.a);
          ((Intent)localObject).putExtra("share_desc", paramMessage.c);
          ((Intent)localObject).putExtra("share_title", paramMessage.b);
          this.a.startActivity((Intent)localObject);
        }
        for (;;)
        {
          this.a.finish();
          return;
          paramMessage = (d)paramMessage.obj;
          if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
            d.a(this.a.getResources(), paramMessage);
          }
          this.a.showToast(paramMessage.c);
        }
      }
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fz
 * JD-Core Version:    0.7.0.1
 */