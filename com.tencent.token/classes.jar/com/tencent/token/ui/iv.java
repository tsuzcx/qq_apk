package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.co;

final class iv
  extends bo
{
  iv(FaceRegCameraActivity paramFaceRegCameraActivity)
  {
    super(paramFaceRegCameraActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 0;
    e.a("facepwd msg.what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    label1106:
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
              if ((paramMessage != null) && (paramMessage.length >= 2))
              {
                FaceRegCameraActivity.access$002(this.a, new int[paramMessage.length]);
                while (i < paramMessage.length)
                {
                  FaceRegCameraActivity.access$000(this.a)[i] = paramMessage[i];
                  i += 1;
                }
                FaceRegCameraActivity.access$102(this.a, true);
                return;
              }
              FaceRegCameraActivity.access$102(this.a, false);
              return;
            }
            FaceRegCameraActivity.access$102(this.a, false);
            return;
          } while (FaceRegCameraActivity.access$200(this.a));
          FaceRegCameraActivity.access$202(this.a, true);
          this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362118), 2131361800, new je(this), new jf(this));
          return;
          paramMessage = (TextView)this.a.findViewById(2131296625);
        } while (paramMessage == null);
        paramMessage.setText(2131362486);
        return;
        try
        {
          FaceRegCameraActivity.access$400(this.a).a(FaceRegCameraActivity.access$300(this.a));
          FaceRegCameraActivity.access$500(this.a).c(0);
          FaceRegCameraActivity.access$600(this.a).setText(2131362782);
          FaceRegCameraActivity.access$700(this.a).setImageResource(2130837712);
          return;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        e.a("OPTYPE_REGIST step=" + FaceRegCameraActivity.access$300(this.a));
        paramMessage = (FaceData)paramMessage.obj;
        if (FaceRegCameraActivity.access$300(this.a) <= 0)
        {
          FaceRegCameraActivity.access$802(this.a, paramMessage);
          if (FaceRegCameraActivity.access$100(this.a))
          {
            FaceRegCameraActivity.access$500(this.a).c(3);
            if (FaceRegCameraActivity.access$000(this.a) != null) {
              FaceRegCameraActivity.access$900(this.a, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)]);
            }
            FaceRegCameraActivity.access$1100(this.a).startAnimation(FaceRegCameraActivity.access$1000(this.a));
            FaceRegCameraActivity.access$400(this.a).a(false, true, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)], FaceRegCameraActivity.access$300(this.a));
            FaceRegCameraActivity.access$500(this.a).c(4);
            return;
          }
          FaceRegCameraActivity.access$500(this.a).c(3);
          paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
          paramMessage.putExtra("data", FaceRegCameraActivity.access$800(this.a).mUploadData);
          paramMessage.putExtra("origindata", FaceRegCameraActivity.access$800(this.a).mOriginDataPath);
          this.a.startActivityForResult(paramMessage, 100);
          return;
        }
        FaceRegCameraActivity.access$1202(this.a, paramMessage);
        if (FaceRegCameraActivity.access$100(this.a))
        {
          FaceRegCameraActivity.access$500(this.a).c(3);
          if (FaceRegCameraActivity.access$000(this.a) != null) {
            FaceRegCameraActivity.access$900(this.a, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)]);
          }
          FaceRegCameraActivity.access$1100(this.a).startAnimation(FaceRegCameraActivity.access$1000(this.a));
          FaceRegCameraActivity.access$400(this.a).a(false, true, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)], FaceRegCameraActivity.access$300(this.a));
          FaceRegCameraActivity.access$500(this.a).c(4);
          return;
        }
        FaceRegCameraActivity.access$500(this.a).c(3);
        paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
        paramMessage.putExtra("data", FaceRegCameraActivity.access$1200(this.a).mUploadData);
        paramMessage.putExtra("origindata", FaceRegCameraActivity.access$1200(this.a).mOriginDataPath);
        this.a.startActivityForResult(paramMessage, 100);
        return;
        FaceRegCameraActivity.access$308(this.a);
        if (FaceRegCameraActivity.access$300(this.a) < 2)
        {
          FaceRegCameraActivity.access$400(this.a).a(true, false, 0, FaceRegCameraActivity.access$300(this.a));
          FaceRegCameraActivity.access$500(this.a).c(6);
          FaceRegCameraActivity.access$600(this.a).setText(2131362782);
          FaceRegCameraActivity.access$1100(this.a).startAnimation(FaceRegCameraActivity.access$1000(this.a));
          FaceRegCameraActivity.access$700(this.a).setImageResource(2130837712);
          return;
        }
        FaceRegCameraActivity.access$500(this.a).c(6);
        paramMessage = new Intent(this.a, FaceRegConfirmActivity.class);
        paramMessage.putExtra("data1", FaceRegCameraActivity.access$800(this.a).mUploadData);
        paramMessage.putExtra("data2", FaceRegCameraActivity.access$1200(this.a).mUploadData);
        this.a.startActivityForResult(paramMessage, 200);
        return;
        e.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
        if (paramMessage.arg1 != 0) {
          break;
        }
      } while (paramMessage.arg2 != 1);
      FaceRegCameraActivity.access$1300(this.a).a();
      if (ax.a().e() != null)
      {
        ax.a().e().mIsRegisterFacePwd = true;
        ax.a().c(ax.a().e());
        e.c(" K_MSG_POST_FACERECOGNITION getCurrentUser = " + ax.a().e().mIsRegisterFacePwd);
      }
      FaceRegCameraActivity.access$1400(this.a).postDelayed(new iw(this), 1000L);
      return;
      paramMessage = (d)paramMessage.obj;
      i = FaceRegCameraActivity.access$1500(this.a);
      try
      {
        int j = ((Integer)paramMessage.d).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        break label1106;
        this.a.showUserDialog(2131362104, paramMessage.c, 2131361804, 2131361914, new jb(this), new jc(this), new jd(this));
      }
      d.a(this.a.getResources(), paramMessage);
      e.c("faceret.mErrCode=" + paramMessage.a + "optype=" + i);
    } while (i != 1);
    if (paramMessage.a == 228)
    {
      this.a.showUserDialog(2131362104, paramMessage.c, 2131361804, 2131362500, new ix(this), new iy(this), new ja(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iv
 * JD-Core Version:    0.7.0.1
 */