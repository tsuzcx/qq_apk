package com.tencent.mobileqq.utils;

import acff;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

final class VipUtils$3
  implements Runnable
{
  public void run()
  {
    this.d.e(this.val$uin);
    ThreadManagerV2.getUIHandlerV2().post(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.3
 * JD-Core Version:    0.7.0.1
 */