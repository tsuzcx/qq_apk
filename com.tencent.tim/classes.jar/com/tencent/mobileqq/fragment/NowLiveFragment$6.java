package com.tencent.mobileqq.fragment;

import ajvd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class NowLiveFragment$6
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby");
    if ((localObject instanceof NearbyAppInterface))
    {
      localObject = (ajvd)((NearbyAppInterface)localObject).getManager(214);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowLiveFragment", 2, "pre login now plugin!");
        }
        ((ajvd)localObject).dzA();
      }
    }
    while (!QLog.isColorLevel())
    {
      NowLiveFragment.access$002(true);
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("NowLiveFragment", 2, "pre login now plugin! err npb null;");
      return;
    }
    QLog.d("NowLiveFragment", 2, "pre login now plugin! err runtime null or wrong! app = " + localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.6
 * JD-Core Version:    0.7.0.1
 */