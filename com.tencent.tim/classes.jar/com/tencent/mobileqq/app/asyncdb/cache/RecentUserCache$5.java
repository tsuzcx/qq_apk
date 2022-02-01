package com.tencent.mobileqq.app.asyncdb.cache;

import aaiv;
import aajt;
import aako;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class RecentUserCache$5
  implements Runnable
{
  RecentUserCache$5(RecentUserCache paramRecentUserCache, String paramString, RecentUser paramRecentUser, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = aajt.a().a(this.val$key);
    Object localObject1;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "getBaseItemDataFromCache is null!");
      }
      localObject2 = aaiv.a(this.c, RecentUserCache.a(this.this$0), RecentUserCache.a(this.this$0).getApp());
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        aajt.a().c((RecentBaseData)localObject2, this.val$key);
        localObject1 = localObject2;
      }
      if (!(localObject1 instanceof RecentUserBaseData)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject2 = ParcelHelper.c(localObject1);
          if (localObject2 == null) {
            continue;
          }
          this.c.parceledRecentBaseData = ((byte[])localObject2);
        }
        catch (ParcelHelper.UnsupportedFieldTypeException localUnsupportedFieldTypeException)
        {
          QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because UnsupportedFieldTypeException, class=", localThrowable1.getClass().getName() });
          continue;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("Q.db.Cache.RecentUserCache", 1, "saveParcelDataToRecentData fail, 请对应的开发检查是否使用了不该使用的字段", localThrowable2);
          aako.a(RecentUserCache.a(this.this$0).getApp(), false, localThrowable2);
          continue;
        }
        RecentUserCache.k(this.this$0).put(this.val$key, Long.valueOf(this.QZ));
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData success, key=", this.val$key, " lastRealOPTime=", Long.valueOf(this.QZ) });
        }
        this.this$0.e(this.c);
        return;
        localObject1 = localObject2;
        if (!(localObject2 instanceof RecentUserBaseData)) {
          break;
        }
        ((RecentUserBaseData)localObject2).d(this.c);
        try
        {
          ((RecentBaseData)localObject2).c(RecentUserCache.a(this.this$0), RecentUserCache.a(this.this$0).getApp());
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable1)
        {
          aako.a(RecentUserCache.a(this.this$0).getApp(), false, localThrowable1);
          throw new RuntimeException(localThrowable1);
        }
      }
      QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because result is null, class=", localThrowable1.getClass().getName() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.5
 * JD-Core Version:    0.7.0.1
 */