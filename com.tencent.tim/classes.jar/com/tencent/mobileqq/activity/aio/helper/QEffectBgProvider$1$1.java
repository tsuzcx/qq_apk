package com.tencent.mobileqq.activity.aio.helper;

import aher;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;
import wwl;
import wwm;

public class QEffectBgProvider$1$1
  implements Runnable
{
  public QEffectBgProvider$1$1(wwm paramwwm, aher paramaher) {}
  
  public void run()
  {
    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + this.a.bRQ);
    wwl.a(this.a.a, System.currentTimeMillis());
    wwl.a(this.a.a).setSrc(QEffectLottieImageView.a(this.b.bKj, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
 * JD-Core Version:    0.7.0.1
 */