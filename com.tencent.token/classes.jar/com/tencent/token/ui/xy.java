package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.cm;

class xy
  extends cb
{
  xy(RealNameTakeIDPhotoActivity paramRealNameTakeIDPhotoActivity)
  {
    super(paramRealNameTakeIDPhotoActivity);
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
        return;
        Intent localIntent = new Intent(this.a, TakeIDPhotoComfirmActivity.class);
        localIntent.putExtra("data", (String)paramMessage.obj);
        localIntent.putExtra("flag", paramMessage.arg1);
        localIntent.putExtra("scene", RealNameTakeIDPhotoActivity.access$600(this.a));
        this.a.startActivityForResult(localIntent, 300);
        h.a("startActivity msg.arg1=" + paramMessage.arg1 + "msg.what=" + paramMessage.what);
        return;
        this.a.showToast(2131231281);
        this.a.finish();
        return;
      } while (RealNameTakeIDPhotoActivity.access$500(this.a) == null);
      RealNameTakeIDPhotoActivity.access$500(this.a).b();
      return;
    } while ((RealNameTakeIDPhotoActivity.access$100(this.a) != 2) || (RealNameTakeIDPhotoActivity.access$700(this.a) == null));
    RealNameTakeIDPhotoActivity.access$700(this.a).setImageResource(2130837902);
    paramMessage = new cm(270.0F, 360.0F, this.a.width / 2, this.a.height / 2, 310.0F, false);
    paramMessage.setDuration(400L);
    paramMessage.setFillAfter(true);
    paramMessage.setAnimationListener(new xz(this));
    RealNameTakeIDPhotoActivity.access$700(this.a).startAnimation(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xy
 * JD-Core Version:    0.7.0.1
 */