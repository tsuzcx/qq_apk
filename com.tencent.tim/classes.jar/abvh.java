import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class abvh
{
  private static abvh a;
  public AtomicInteger aY = new AtomicInteger(0);
  public String bic;
  private ReentrantLock mLock;
  public int mSessionType = 0;
  
  public static abvh a()
  {
    try
    {
      if (a == null) {
        a = new abvh();
      }
      abvh localabvh = a;
      return localabvh;
    }
    finally {}
  }
  
  public abvh a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionManager", 2, "[setAppInterface] app:" + paramQQAppInterface);
    }
    return this;
  }
  
  public ReentrantLock a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[getLock].");
      }
      if (this.mLock == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionManager", 2, "create lock.");
        }
        this.mLock = new ReentrantLock();
      }
      ReentrantLock localReentrantLock = this.mLock;
      return localReentrantLock;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionManager", 2, "[onDestroy]");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvh
 * JD-Core Version:    0.7.0.1
 */