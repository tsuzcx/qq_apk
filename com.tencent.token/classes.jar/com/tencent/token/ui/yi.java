package com.tencent.token.ui;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Message;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.cu;

final class yi
  extends bo
{
  yi(RealNameTakeIDPhotoActivity paramRealNameTakeIDPhotoActivity)
  {
    super(paramRealNameTakeIDPhotoActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
          Intent localIntent = new Intent(this.a, TakeIDPhotoComfirmActivity.class);
          localIntent.putExtra("data", (String)paramMessage.obj);
          localIntent.putExtra("flag", paramMessage.arg1);
          localIntent.putExtra("scene", RealNameTakeIDPhotoActivity.access$600(this.a));
          this.a.startActivityForResult(localIntent, 300);
          e.a("startActivity msg.arg1=" + paramMessage.arg1 + "msg.what=" + paramMessage.what);
          return;
          this.a.showToast(2131362118);
          this.a.finish();
          return;
        } while (RealNameTakeIDPhotoActivity.access$500(this.a) == null);
        paramMessage = RealNameTakeIDPhotoActivity.access$500(this.a);
      } while (paramMessage.a == null);
      try
      {
        paramMessage.a.autoFocus(paramMessage);
        return;
      }
      catch (RuntimeException paramMessage)
      {
        paramMessage.printStackTrace();
        e.d("camera auto focus " + paramMessage.toString());
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        e.d("camera auto focus " + paramMessage.toString());
        return;
      }
    } while ((RealNameTakeIDPhotoActivity.access$100(this.a) != 2) || (RealNameTakeIDPhotoActivity.access$700(this.a) == null));
    RealNameTakeIDPhotoActivity.access$700(this.a).setImageResource(2130837821);
    paramMessage = new cu(270.0F, 360.0F, this.a.width / 2, this.a.height / 2, false);
    paramMessage.setDuration(400L);
    paramMessage.setFillAfter(true);
    paramMessage.setAnimationListener(new yj(this));
    RealNameTakeIDPhotoActivity.access$700(this.a).startAnimation(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yi
 * JD-Core Version:    0.7.0.1
 */