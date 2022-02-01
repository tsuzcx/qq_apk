package com.tencent.mobileqq.structmsg;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.TextView;
import ansr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import wja;

class StructMsgForImageShare$2
  implements Runnable
{
  StructMsgForImageShare$2(StructMsgForImageShare paramStructMsgForImageShare, Drawable paramDrawable, Resources paramResources, TextView paramTextView) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(ansr.e(this.fz));
    localBitmapDrawable.setBounds(0, 0, wja.dp2px(14.0F, this.g), wja.dp2px(14.0F, this.g));
    ThreadManagerV2.getUIHandlerV2().post(new StructMsgForImageShare.2.1(this, localBitmapDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.2
 * JD-Core Version:    0.7.0.1
 */