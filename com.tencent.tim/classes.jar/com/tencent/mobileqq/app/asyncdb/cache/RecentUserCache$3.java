package com.tencent.mobileqq.app.asyncdb.cache;

import acbn;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class RecentUserCache$3
  implements Runnable
{
  RecentUserCache$3(RecentUserCache paramRecentUserCache, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | start");
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = RecentUserCache.a(this.this$0).getWritableDatabase();
      String str = RecentUserCache.a(this.this$0, acbn.bkA, 4000);
      if (RecentUserCache.e(this.this$0).containsKey(str)) {
        RecentUserCache.f(this.this$0).remove(str);
      }
      int i = localSQLiteDatabase.delete("recent", "uin=?", new String[] { acbn.bkA });
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | RecentUser delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | delete recommend error~");
      return;
    }
    finally
    {
      this.val$sp.edit().putBoolean("check_newfriend_when_upgrade_V2", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.3
 * JD-Core Version:    0.7.0.1
 */