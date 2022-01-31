package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.fi;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.ArrayList;

class ij
  extends Handler
{
  ij(FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  private void a()
  {
    byte[] arrayOfByte = FaceStartVryCameraActivity.access$500(this.a).mUploadData;
    if (arrayOfByte == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(arrayOfByte);
    FaceStartVryCameraActivity.access$1502(this.a, fi.a(localArrayList));
    if (FaceStartVryCameraActivity.access$1500(this.a) != null)
    {
      long l = x.e();
      int i = FaceStartVryCameraActivity.access$1600(this.a);
      FaceStartVryCameraActivity.access$1702(this.a, true);
      cw.a().a(0L, l, FaceStartVryCameraActivity.access$1800(this.a), FaceStartVryCameraActivity.access$1500(this.a), i, FaceStartVryCameraActivity.access$1900(this.a), FaceStartVryCameraActivity.access$600(this.a).getBrightModeIntValue(), FaceStartVryCameraActivity.access$1400(this.a));
      return;
    }
    h.a("OPTYPE_VALIDATION serverData == null");
  }
  
  private void a(boolean paramBoolean)
  {
    FaceStartVryCameraActivity.access$202(this.a, true);
    this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231281), 2131230897, new it(this), new il(this, paramBoolean));
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    h.a("facepwd msg.what=" + paramMessage.what);
    long l;
    switch (paramMessage.what)
    {
    default: 
    case 3082: 
    case 2: 
    case 13: 
    case 73: 
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
              if ((paramMessage != null) && (paramMessage.length >= 1))
              {
                FaceStartVryCameraActivity.access$002(this.a, new int[paramMessage.length]);
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
          a(true);
          return;
          paramMessage = (TextView)this.a.findViewById(2131558913);
        } while (paramMessage == null);
        paramMessage.setText(2131231031);
        return;
        try
        {
          FaceStartVryCameraActivity.access$300(this.a).setStop(false);
          FaceStartVryCameraActivity.access$400(this.a);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
        FaceStartVryCameraActivity.access$502(this.a, (FaceData)paramMessage.obj);
      } while (FaceStartVryCameraActivity.access$500(this.a).mUploadData == null);
      if (FaceStartVryCameraActivity.access$100(this.a))
      {
        FaceStartVryCameraActivity.access$600(this.a).setStatus(3);
        if (FaceStartVryCameraActivity.access$700(this.a) != null) {
          FaceStartVryCameraActivity.access$800(this.a, FaceStartVryCameraActivity.access$000(this.a)[0]);
        }
        FaceStartVryCameraActivity.access$300(this.a).a(false, true, FaceStartVryCameraActivity.access$000(this.a)[0], 0);
        if (FaceStartVryCameraActivity.access$000(this.a)[0] > 4)
        {
          FaceStartVryCameraActivity.access$600(this.a).setStatus(4);
          return;
        }
        FaceStartVryCameraActivity.access$600(this.a).setVryNodDirection(FaceStartVryCameraActivity.access$000(this.a)[0]);
        FaceStartVryCameraActivity.access$600(this.a).setStatus(7);
        return;
      }
      FaceStartVryCameraActivity.access$600(this.a).setStatus(3);
      FaceStartVryCameraActivity.access$700(this.a).setText(2131230787);
      a();
      return;
    case 71: 
      if (FaceStartVryCameraActivity.access$000(this.a)[0] <= 4) {
        FaceStartVryCameraActivity.access$600(this.a).setStatus(9);
      }
      for (;;)
      {
        FaceStartVryCameraActivity.access$700(this.a).setText(2131230787);
        a();
        return;
        FaceStartVryCameraActivity.access$600(this.a).setStatus(6);
      }
    case 3058: 
      h.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
      if (paramMessage.arg1 == 0)
      {
        RqdApplication.d();
        i = paramMessage.arg2;
        RqdApplication.i();
        w.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
        FaceStartVryCameraActivity.access$600(this.a).setStatus(3);
        this.a.startAnimation();
        return;
      }
      FaceStartVryCameraActivity.access$900(this.a).setVisibility(4);
      FaceStartVryCameraActivity.access$1000(this.a).setVisibility(4);
      f localf = (f)paramMessage.obj;
      f.a(this.a.getResources(), localf);
      h.c("faceRe ret.mErrCode=" + localf.a);
      switch (localf.a)
      {
      default: 
        if (RqdApplication.g()) {
          break;
        }
      }
      for (i = 2131231033;; i = 2131231032)
      {
        this.a.showUserDialog(2131230935, localf.c, 2131230881, i, new iq(this), new ir(this), new is(this));
        return;
        FaceStartVryCameraActivity.access$1100(this.a, this.a, 2131231100, 2131231094);
        return;
        FaceStartVryCameraActivity.access$1208(this.a);
        if (!RqdApplication.g()) {
          i = 2131231033;
        }
        for (paramMessage = this.a.getResources().getString(2131231038); FaceStartVryCameraActivity.access$1200(this.a) < 5; paramMessage = this.a.getResources().getString(2131231037))
        {
          w.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, FaceStartVryCameraActivity.access$1200(this.a));
          this.a.showUserDialog(2131231035, localf.c, 2131231034, i, new ik(this), new im(this), new in(this));
          return;
          i = 2131231032;
        }
        w.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
        this.a.showUserDialog(2131231036, paramMessage, i, new io(this));
        return;
        x.b(0L);
        if (!RqdApplication.g()) {
          i = 2131231033;
        }
        for (paramMessage = this.a.getResources().getString(2131231029);; paramMessage = this.a.getResources().getString(2131231028))
        {
          this.a.showUserDialog(2131230935, localf.c + "，" + paramMessage, i, new ip(this));
          return;
          i = 2131231032;
        }
      }
    case 1008: 
      if (paramMessage.arg1 == 0)
      {
        this.a.dismissDialog();
        paramMessage = do.a().e();
        if (paramMessage == null)
        {
          ch.a().a(System.currentTimeMillis(), 23);
          FaceStartVryCameraActivity.access$1100(this.a, this.a, 2131231099, 2131231101);
          return;
        }
        this.a.dismissDialog();
        l = x.e();
        if (l > 0L) {
          break label1311;
        }
        l = paramMessage.mRealUin;
      }
      break;
    }
    label1311:
    for (;;)
    {
      cp.a(this.a.getApplicationContext()).a(this.a, 523005419L, FaceStartVryCameraActivity.access$1400(this.a), l + "");
      return;
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showToast(2131231411);
      return;
      RqdApplication.d();
      RqdApplication.i();
      w.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
      FaceStartVryCameraActivity.access$600(this.a).setStatus(3);
      this.a.startAnimation();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ij
 * JD-Core Version:    0.7.0.1
 */