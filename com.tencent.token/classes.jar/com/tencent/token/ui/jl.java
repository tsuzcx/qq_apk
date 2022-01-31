package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.af;
import com.tencent.token.ge;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.ArrayList;

final class jl
  extends bo
{
  jl(FaceStartVryCameraActivity paramFaceStartVryCameraActivity)
  {
    super(paramFaceStartVryCameraActivity);
  }
  
  private void a()
  {
    byte[] arrayOfByte = FaceStartVryCameraActivity.access$300(this.a).mUploadData;
    if (arrayOfByte == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(arrayOfByte);
    FaceStartVryCameraActivity.access$1402(this.a, ge.a(localArrayList));
    if (FaceStartVryCameraActivity.access$1400(this.a) != null)
    {
      long l = t.e();
      int i = FaceStartVryCameraActivity.access$1500(this.a);
      FaceStartVryCameraActivity.access$1602(this.a, true);
      af.a().a(0L, l, FaceStartVryCameraActivity.access$1700(this.a), FaceStartVryCameraActivity.access$1400(this.a), i, FaceStartVryCameraActivity.access$1800(this.a), FaceStartVryCameraActivity.access$1900(this.a));
      return;
    }
    e.a("OPTYPE_VALIDATION serverData == null");
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 2131362494;
    int j = 0;
    e.a("facepwd msg.what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 3082: 
    case 2: 
    case 13: 
    case 11: 
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
                FaceStartVryCameraActivity.access$002(this.a, new int[paramMessage.length]);
                i = j;
                while (i < paramMessage.length)
                {
                  FaceStartVryCameraActivity.access$000(this.a)[i] = paramMessage[i];
                  i += 1;
                }
                FaceStartVryCameraActivity.access$102(this.a, true);
                return;
              }
              FaceStartVryCameraActivity.access$102(this.a, false);
              return;
            }
            FaceStartVryCameraActivity.access$102(this.a, false);
            return;
          } while (FaceStartVryCameraActivity.access$200(this.a));
          FaceStartVryCameraActivity.access$202(this.a, true);
          this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362118), 2131361800, new jn(this), new jo(this));
          return;
          paramMessage = (TextView)this.a.findViewById(2131296625);
        } while (paramMessage == null);
        paramMessage.setText(2131362486);
        return;
        FaceStartVryCameraActivity.access$302(this.a, (FaceData)paramMessage.obj);
      } while (FaceStartVryCameraActivity.access$300(this.a).mUploadData == null);
      if (FaceStartVryCameraActivity.access$100(this.a))
      {
        FaceStartVryCameraActivity.access$400(this.a).c(3);
        if (FaceStartVryCameraActivity.access$500(this.a) != null) {
          FaceStartVryCameraActivity.access$600(this.a, FaceStartVryCameraActivity.access$000(this.a)[0]);
        }
        FaceStartVryCameraActivity.access$400(this.a).a(FaceStartVryCameraActivity.access$000(this.a)[0]);
        FaceStartVryCameraActivity.access$700(this.a).a(false, true, FaceStartVryCameraActivity.access$000(this.a)[0], 0);
        FaceStartVryCameraActivity.access$400(this.a).c(7);
        return;
      }
      FaceStartVryCameraActivity.access$400(this.a).c(3);
      FaceStartVryCameraActivity.access$500(this.a).setText(2131361844);
      a();
      return;
    case 71: 
      FaceStartVryCameraActivity.access$400(this.a).c(9);
      FaceStartVryCameraActivity.access$500(this.a).setText(2131361844);
      a();
      return;
    }
    e.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
    if (paramMessage.arg1 == 0)
    {
      RqdApplication.f();
      s.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
      FaceStartVryCameraActivity.access$400(this.a).c(3);
      if (FaceStartVryCameraActivity.access$100(this.a))
      {
        FaceStartVryCameraActivity.access$800(this.a).setVisibility(0);
        FaceStartVryCameraActivity.access$900(this.a).setVisibility(0);
        paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        paramMessage.setDuration(700L);
        localObject = new RotateAnimation(360.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(700L);
        paramMessage.setAnimationListener(new jm(this));
        FaceStartVryCameraActivity.access$800(this.a).startAnimation(paramMessage);
        FaceStartVryCameraActivity.access$900(this.a).startAnimation((Animation)localObject);
        return;
      }
      this.a.startAnimation();
      return;
    }
    FaceStartVryCameraActivity.access$800(this.a).setVisibility(4);
    FaceStartVryCameraActivity.access$900(this.a).setVisibility(4);
    Object localObject = (d)paramMessage.obj;
    d.a(this.a.getResources(), (d)localObject);
    e.c("faceRe ret.mErrCode=" + ((d)localObject).a);
    switch (((d)localObject).a)
    {
    default: 
      if (RqdApplication.d()) {
        break;
      }
    }
    for (i = 2131362494;; i = 2131362495)
    {
      this.a.showUserDialog(2131362104, ((d)localObject).c, 2131361914, i, new ju(this), new jv(this), new jw(this));
      return;
      FaceStartVryCameraActivity.access$1000(this.a, this.a, 2131362161, 2131362144);
      return;
      FaceStartVryCameraActivity.access$1108(this.a);
      if (!RqdApplication.d())
      {
        paramMessage = this.a.getResources().getString(2131362507);
        i = 2131362494;
      }
      while (FaceStartVryCameraActivity.access$1100(this.a) < 5)
      {
        s.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, FaceStartVryCameraActivity.access$1100(this.a));
        this.a.showUserDialog(2131362489, ((d)localObject).c, 2131362496, i, new jp(this), new jq(this), new jr(this));
        return;
        i = 2131362495;
        paramMessage = this.a.getResources().getString(2131362506);
      }
      s.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
      this.a.showUserDialog(2131362491, paramMessage, i, new js(this));
      return;
      t.b(0L);
      if (!RqdApplication.d()) {}
      for (paramMessage = this.a.getResources().getString(2131362505);; paramMessage = this.a.getResources().getString(2131362504))
      {
        this.a.showUserDialog(2131362104, ((d)localObject).c + "，" + paramMessage, i, new jt(this));
        return;
        i = 2131362495;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jl
 * JD-Core Version:    0.7.0.1
 */