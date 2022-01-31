package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.cm;

class dq
  extends cb
{
  dq(DetectIDPhotoActivity paramDetectIDPhotoActivity)
  {
    super(paramDetectIDPhotoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          DetectIDPhotoActivity.access$302(this.a, System.currentTimeMillis());
          DetectIDPhotoActivity.access$400(this.a).setText(2131231348);
          return;
        } while (System.currentTimeMillis() - DetectIDPhotoActivity.access$300(this.a) < 3000L);
        if (DetectIDPhotoActivity.access$500(this.a) == 1)
        {
          DetectIDPhotoActivity.access$400(this.a).setText(2131231347);
          return;
        }
        DetectIDPhotoActivity.access$400(this.a).setText(2131231346);
        return;
        DetectIDPhotoActivity.access$602(this.a, false);
      } while ((DetectIDPhotoActivity.access$700(this.a)) || (DetectIDPhotoActivity.access$100(this.a) == null));
      h.c("show overtimedialog");
      if (DetectIDPhotoActivity.access$100(this.a) != null) {
        DetectIDPhotoActivity.access$100(this.a).setStop(true);
      }
      DetectIDPhotoActivity.access$200(this.a);
      return;
      Intent localIntent = new Intent(this.a, TakeIDPhotoComfirmActivity.class);
      Bundle localBundle;
      if (paramMessage.arg1 == 1)
      {
        DetectIDPhotoActivity.access$802(this.a, (String)paramMessage.obj);
        localBundle = paramMessage.getData();
        if (localBundle != null) {
          DetectIDPhotoActivity.access$902(this.a, localBundle.getByteArray("info"));
        }
      }
      for (;;)
      {
        localIntent.putExtra("data", (String)paramMessage.obj);
        localIntent.putExtra("flag", paramMessage.arg1);
        this.a.startActivityForResult(localIntent, 300);
        h.a("startActivity msg.arg1=" + paramMessage.arg1 + "msg.what=" + paramMessage.what);
        return;
        if (paramMessage.arg1 == 2)
        {
          DetectIDPhotoActivity.access$702(this.a, true);
          DetectIDPhotoActivity.access$1002(this.a, (String)paramMessage.obj);
          localBundle = paramMessage.getData();
          if (localBundle != null) {
            DetectIDPhotoActivity.access$1102(this.a, localBundle.getByteArray("info"));
          }
        }
      }
      this.a.showToast(2131231281);
      this.a.finish();
      return;
    } while ((DetectIDPhotoActivity.access$500(this.a) != 2) || (DetectIDPhotoActivity.access$1200(this.a) == null));
    DetectIDPhotoActivity.access$1200(this.a).setImageResource(2130837902);
    paramMessage = new cm(270.0F, 360.0F, DetectIDPhotoActivity.access$1300(this.a) / 2, DetectIDPhotoActivity.access$1400(this.a) / 2, 310.0F, false);
    paramMessage.setDuration(400L);
    paramMessage.setFillAfter(true);
    paramMessage.setAnimationListener(new dr(this));
    DetectIDPhotoActivity.access$1200(this.a).startAnimation(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dq
 * JD-Core Version:    0.7.0.1
 */