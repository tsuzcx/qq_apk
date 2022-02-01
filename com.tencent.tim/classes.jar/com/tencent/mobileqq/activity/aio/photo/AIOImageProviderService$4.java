package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AccountNotMatchException;

class AIOImageProviderService$4
  implements Runnable
{
  AIOImageProviderService$4(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.sn;
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      do
      {
        return;
        localObject = AIOImageProviderService.a(this.this$0, this.Jz, this.bXa);
      } while ((localObject == null) || (!MessageForPic.class.isInstance(localObject)));
      localObject = (MessageForPic)localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "payFlow,id:" + this.Jz + ",subId:" + this.bXa);
        }
        AIOImageProviderService.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.myUin), (MessageForPic)localObject);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "no appRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.4
 * JD-Core Version:    0.7.0.1
 */