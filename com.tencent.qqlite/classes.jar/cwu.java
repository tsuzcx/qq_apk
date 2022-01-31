import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class cwu
  implements Runnable
{
  public cwu(RecentUserCache paramRecentUserCache, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | start");
    }
    Object localObject1 = null;
    label381:
    for (;;)
    {
      synchronized (RecentUserCache.a(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache))
      {
        Iterator localIterator = RecentUserCache.b(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).values().iterator();
        if (localIterator.hasNext())
        {
          Entity localEntity = (Entity)localIterator.next();
          if ((localEntity == null) || (!AppConstants.V.equals(((RecentUser)localEntity).uin))) {
            break label381;
          }
          localObject1 = (RecentUser)localEntity;
          break label381;
        }
      }
      try
      {
        ??? = RecentUserCache.b(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).a();
        if (localObject1 != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache.a((Entity)localObject1);
          if (RecentUserCache.c(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).containsKey(localObject1)) {
            RecentUserCache.d(this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRecentUserCache).remove(localObject1);
          }
        }
        int i = ((SQLiteDatabase)???).a("recent", "uin=?", new String[] { AppConstants.V });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | RecentUser delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { AppConstants.V });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | conversationinfo delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(MessageRecord.getTableName(AppConstants.V, 4000), "frienduin=?", new String[] { AppConstants.V });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | MessageRecord.RecommendMsg delCount = " + i);
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | delete recommend error~");
        return;
      }
      finally
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("check_newfriend_when_upgrade", false).commit();
      }
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwu
 * JD-Core Version:    0.7.0.1
 */