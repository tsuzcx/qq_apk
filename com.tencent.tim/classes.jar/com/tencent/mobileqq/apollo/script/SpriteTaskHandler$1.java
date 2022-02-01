package com.tencent.mobileqq.apollo.script;

import abqz;
import abrc;
import abrh;
import abrj;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingDeque;

public class SpriteTaskHandler$1
  implements Runnable
{
  public SpriteTaskHandler$1(abrh paramabrh) {}
  
  public void run()
  {
    SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)abrh.a(this.this$0).pollLast();
    abqz localabqz = abrj.a(abrh.a(this.this$0).getApp());
    if ((localabqz != null) && (localSpriteTaskParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask] not play current task, actionId:", Integer.valueOf(localSpriteTaskParam.mActionId), ",but delay play" });
      }
      localabqz.a(localSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1
 * JD-Core Version:    0.7.0.1
 */