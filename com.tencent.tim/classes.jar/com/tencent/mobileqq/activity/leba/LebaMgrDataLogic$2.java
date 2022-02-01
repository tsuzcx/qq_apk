package com.tencent.mobileqq.activity.leba;

import acgw;
import aimc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import zjp;

public class LebaMgrDataLogic$2
  implements Runnable
{
  public LebaMgrDataLogic$2(zjp paramzjp, List paramList) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "handleData AppRuntime error ");
      return;
    }
    localObject = (QQAppInterface)localObject;
    long l = NetConnInfoCenter.getServerTime();
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "saveUserSortInfo " + this.uw + ", time" + l + ", type" + this.this$0.cdu);
    acgw.a(((QQAppInterface)localObject).getPreferences(), this.uw, Long.valueOf(l), this.this$0.cdu);
    ((aimc)((QQAppInterface)localObject).getBusinessHandler(128)).d(this.uw, l, this.this$0.cdu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.2
 * JD-Core Version:    0.7.0.1
 */