package com.tencent.mobileqq.nearby.profilecard.moment;

import akio;
import akis;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class NearbyMomentManager$4$1
  implements Runnable
{
  public NearbyMomentManager$4$1(akis paramakis, List paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    List localList = akio.a(this.a.this$0, this.hD);
    Object localObject;
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyMomentManager", 2, "momentFeedInfoList is null");
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.4.1.1(this, (List)localObject));
      return;
      localObject = localList;
      if (QLog.isColorLevel())
      {
        QLog.i("NearbyMomentManager", 2, "momentFeedInfoList, size=" + this.hD.size());
        localObject = localList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.4.1
 * JD-Core Version:    0.7.0.1
 */