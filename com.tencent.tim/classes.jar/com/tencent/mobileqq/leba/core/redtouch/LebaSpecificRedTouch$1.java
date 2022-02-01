package com.tencent.mobileqq.leba.core.redtouch;

import aimp;
import akjt;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import jnv;

public class LebaSpecificRedTouch$1
  implements Runnable
{
  public LebaSpecificRedTouch$1(aimp paramaimp, QQAppInterface paramQQAppInterface, Handler paramHandler, RedTouch paramRedTouch, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = (jnv)this.val$app.getManager(70);
    localObject = ((jnv)localObject).a(((jnv)localObject).ye(), false);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "updateNearbyRedPointAsync, getNearbyRedPoint costTime=" + (System.currentTimeMillis() - l));
    }
    this.val$handler.post(new LebaSpecificRedTouch.1.1(this, (akjt)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.1
 * JD-Core Version:    0.7.0.1
 */