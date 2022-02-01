package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class PokePanel$1
  implements Runnable
{
  PokePanel$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "checkAllSourceDowned onShow First");
    }
    PokePanel.x(this.val$app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel.1
 * JD-Core Version:    0.7.0.1
 */