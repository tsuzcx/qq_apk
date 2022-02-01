package com.tencent.mobileqq.activity.leba;

import ackq;
import aevs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import zjp;
import zjq;

public class LebaMgrDataLogic$1
  implements Runnable
{
  public LebaMgrDataLogic$1(zjp paramzjp, aevs paramaevs, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "handleData AppRuntime error ");
      return;
    }
    localObject = (QQAppInterface)localObject;
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginItem name: " + this.b.a.strResName + "  cCurFlag:" + this.b.bo);
    long l = NetConnInfoCenter.getServerTimeMillis();
    zjq.a().a((QQAppInterface)localObject, this.b.a.uiResId, this.val$isOpen, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    ((ackq)((QQAppInterface)localObject).getBusinessHandler(31)).f(String.valueOf(this.b.a.uiResId), this.val$isOpen, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.1
 * JD-Core Version:    0.7.0.1
 */