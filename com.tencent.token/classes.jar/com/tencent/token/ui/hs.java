package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.c;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.cd;
import org.json.JSONArray;

class hs
  extends cb
{
  hs(FaceRegCameraActivity paramFaceRegCameraActivity)
  {
    super(paramFaceRegCameraActivity);
  }
  
  private void a(boolean paramBoolean)
  {
    FaceRegCameraActivity.access$202(this.a, true);
    this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231281), 2131230897, new ib(this), new ic(this, paramBoolean));
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    h.a("facepwd msg.what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    label1119:
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
          a(false);
          return;
          paramMessage = (TextView)this.a.findViewById(2131558913);
        } while (paramMessage == null);
        paramMessage.setText(2131231031);
        return;
        try
        {
          FaceRegCameraActivity.access$400(this.a).b(true, false, 0, FaceRegCameraActivity.access$300(this.a));
          FaceRegCameraActivity.access$500(this.a).setStatus(0);
          FaceRegCameraActivity.access$600(this.a).setText(2131231151);
          FaceRegCameraActivity.access$700(this.a).setImageResource(2130837790);
          return;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        h.a("OPTYPE_REGIST step=" + FaceRegCameraActivity.access$300(this.a));
        paramMessage = (FaceData)paramMessage.obj;
        if (FaceRegCameraActivity.access$300(this.a) < 1)
        {
          FaceRegCameraActivity.access$802(this.a, paramMessage);
          if (FaceRegCameraActivity.access$100(this.a))
          {
            FaceRegCameraActivity.access$500(this.a).setStatus(3);
            if (FaceRegCameraActivity.access$000(this.a) != null) {
              FaceRegCameraActivity.access$900(this.a, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)]);
            }
            FaceRegCameraActivity.access$1100(this.a).startAnimation(FaceRegCameraActivity.access$1000(this.a));
            FaceRegCameraActivity.access$400(this.a).a(false, true, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)], FaceRegCameraActivity.access$300(this.a));
            FaceRegCameraActivity.access$500(this.a).setStatus(4);
            return;
          }
          FaceRegCameraActivity.access$500(this.a).setStatus(3);
          paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
          paramMessage.putExtra("data", FaceRegCameraActivity.access$800(this.a).mUploadData);
          paramMessage.putExtra("origindata", FaceRegCameraActivity.access$800(this.a).mOriginDataPath);
          this.a.startActivityForResult(paramMessage, 100);
          return;
        }
        FaceRegCameraActivity.access$1202(this.a, paramMessage);
        if (FaceRegCameraActivity.access$100(this.a))
        {
          FaceRegCameraActivity.access$500(this.a).setStatus(3);
          if (FaceRegCameraActivity.access$000(this.a) != null) {
            FaceRegCameraActivity.access$900(this.a, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)]);
          }
          FaceRegCameraActivity.access$1100(this.a).startAnimation(FaceRegCameraActivity.access$1000(this.a));
          FaceRegCameraActivity.access$400(this.a).a(false, true, FaceRegCameraActivity.access$000(this.a)[FaceRegCameraActivity.access$300(this.a)], FaceRegCameraActivity.access$300(this.a));
          FaceRegCameraActivity.access$500(this.a).setStatus(4);
          return;
        }
        FaceRegCameraActivity.access$500(this.a).setStatus(3);
        paramMessage = new Intent(this.a, FaceRecognitionComfirmActivity.class);
        paramMessage.putExtra("data", FaceRegCameraActivity.access$1200(this.a).mUploadData);
        paramMessage.putExtra("origindata", FaceRegCameraActivity.access$1200(this.a).mOriginDataPath);
        this.a.startActivityForResult(paramMessage, 100);
        return;
        FaceRegCameraActivity.access$308(this.a);
        if (FaceRegCameraActivity.access$300(this.a) < 2)
        {
          FaceRegCameraActivity.access$400(this.a).a(true, false, 0, FaceRegCameraActivity.access$300(this.a));
          FaceRegCameraActivity.access$500(this.a).setStatus(6);
          FaceRegCameraActivity.access$600(this.a).setText(2131231151);
          FaceRegCameraActivity.access$1100(this.a).startAnimation(FaceRegCameraActivity.access$1000(this.a));
          FaceRegCameraActivity.access$700(this.a).setImageResource(2130837790);
          return;
        }
        FaceRegCameraActivity.access$500(this.a).setStatus(6);
        paramMessage = new Intent(this.a, FaceRegConfirmActivity.class);
        paramMessage.putExtra("data1", FaceRegCameraActivity.access$800(this.a).mUploadData);
        paramMessage.putExtra("data2", FaceRegCameraActivity.access$1200(this.a).mUploadData);
        paramMessage.putExtra("origindata1", FaceRegCameraActivity.access$800(this.a).mOriginDataPath);
        paramMessage.putExtra("origindata2", FaceRegCameraActivity.access$1200(this.a).mOriginDataPath);
        this.a.startActivityForResult(paramMessage, 200);
        return;
        h.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
        if (paramMessage.arg1 != 0) {
          break;
        }
        i = paramMessage.arg2;
        paramMessage = (JSONArray)paramMessage.obj;
      } while (i != 1);
      FaceRegCameraActivity.access$1300(this.a).a();
      if (do.a().e() != null)
      {
        do.a().e().mIsRegisterFacePwd = true;
        do.a().c(do.a().e());
        h.c(" K_MSG_POST_FACERECOGNITION getCurrentUser = " + do.a().e().mIsRegisterFacePwd);
      }
      FaceRegCameraActivity.access$1400(this.a).postDelayed(new ht(this, paramMessage), 1000L);
      return;
      paramMessage = (f)paramMessage.obj;
      c localc = (c)paramMessage.d;
      i = FaceRegCameraActivity.access$1500(this.a);
      try
      {
        int j = localc.a();
        i = j;
      }
      catch (Exception localException)
      {
        break label1119;
        this.a.showUserDialog(2131230935, paramMessage.c, 2131230886, 2131230881, new hy(this), new hz(this), new ia(this));
      }
      f.a(this.a.getResources(), paramMessage);
      h.c("faceret.mErrCode=" + paramMessage.a + "optype=" + i);
    } while (i != 1);
    if (paramMessage.a == 228)
    {
      this.a.showUserDialog(2131230935, paramMessage.c, 2131230886, 2131231384, new hu(this), new hv(this), new hx(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hs
 * JD-Core Version:    0.7.0.1
 */