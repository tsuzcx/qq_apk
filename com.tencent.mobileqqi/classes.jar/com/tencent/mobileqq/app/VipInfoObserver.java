package com.tencent.mobileqq.app;

import VIP.VipUserInfo;
import com.tencent.qphone.base.util.QLog;

public class VipInfoObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipInfoObserver", 2, "onUpdate-isSuccess:" + paramBoolean);
    }
    if (paramInt == VipInfoHandler.a)
    {
      int i = -1;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (VipUserInfo)paramObject;
        paramInt = i;
        if (paramObject != null) {
          paramInt = paramObject.iGrowthValue;
        }
      }
      a(paramBoolean, paramInt);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoObserver
 * JD-Core Version:    0.7.0.1
 */