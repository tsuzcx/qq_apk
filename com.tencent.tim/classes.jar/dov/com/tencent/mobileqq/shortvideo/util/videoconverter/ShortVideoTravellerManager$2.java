package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.text.TextUtils;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ShortVideoTravellerManager$2
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        localList = ShortVideoTravellerManager.a(this.this$0).query(ShortVideoTravellerManager.TravellerVideoItem.class);
        if ((localList == null) || (localList.size() <= 0)) {
          break label140;
        }
      }
      catch (Exception localException)
      {
        List localList;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ShortVideoTravellerManager", 2, "readVideoListFromDB", localException);
        return;
      }
      synchronized (ShortVideoTravellerManager.a(this.this$0))
      {
        this.this$0.mS.addAll(localList);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "readTravellerVideoItem from DB success");
        }
        if (this.this$0.eU.compareAndSet(true, false))
        {
          if ((this.this$0.mS != null) && (this.this$0.mS.size() > 0)) {
            break;
          }
          this.this$0.a(null, this.this$0.bR);
        }
        return;
      }
      label140:
      String str = aqmj.ak(ShortVideoTravellerManager.a(this.this$0).getApp(), ShortVideoTravellerManager.a(this.this$0).getCurrentAccountUin());
      int i = aqmj.bq(ShortVideoTravellerManager.a(this.this$0).getApp(), ShortVideoTravellerManager.a(this.this$0).getCurrentAccountUin());
      if (!TextUtils.isEmpty(str)) {
        this.this$0.ho(str, i);
      }
    }
    this.this$0.a(this.this$0.mS, this.this$0.bR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager.2
 * JD-Core Version:    0.7.0.1
 */