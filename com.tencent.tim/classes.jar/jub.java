import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.1;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class jub
  implements Manager
{
  QQAppInterface app;
  private MQLruCache<Long, jtr> d = new MQLruCache(50);
  private EntityManager em;
  
  public jub(QQAppInterface paramQQAppInterface)
  {
    this.em = paramQQAppInterface.a().createEntityManager();
    this.app = paramQQAppInterface;
  }
  
  public static jub a(QQAppInterface paramQQAppInterface)
  {
    return (jub)paramQQAppInterface.getManager(173);
  }
  
  public int a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    try
    {
      jtr localjtr1 = new jtr();
      localjtr1.puin = paramLong1;
      localjtr1.qI = paramLong3;
      localjtr1.qH = paramLong2;
      localjtr1.isFirstEnter = paramBoolean1;
      jtr localjtr2 = (jtr)this.d.get(Long.valueOf(paramLong1));
      if (localjtr2 != null)
      {
        if (paramLong3 == 0L) {
          localjtr1.qH = localjtr2.qH;
        }
        if (!paramBoolean1) {
          localjtr1.bK(localjtr2.aZ());
        }
      }
      localjtr1.bL(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoCache puin:" + paramLong1 + " last_msg_id:" + localjtr1.qH + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      this.d.put(Long.valueOf(paramLong1), localjtr1);
      return 0;
    }
    finally {}
  }
  
  public int a(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    a(paramBoolean1, paramLong1, paramLong2, paramLong3, paramArrayList, paramBoolean2);
    if ((!paramBoolean2) && (paramBoolean1) && (paramArrayOfByte != null) && (paramLong3 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB puin:" + paramLong1 + " last_msg_id:" + paramLong2 + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      ThreadManager.post(new AccountDetailDynamicDataManager.1(this, paramLong1, paramArrayOfByte), 8, null, true);
    }
    return 0;
  }
  
  public jtr a(long paramLong)
  {
    return (jtr)this.d.get(Long.valueOf(paramLong));
  }
  
  public jtr a(String paramString)
  {
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      return a(l1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("AccountDetailDynamicDataManager", 2, "getAccountDetailDynamicInfoFromCache puin:" + paramString);
          l1 = l2;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, acje paramacje)
  {
    ArrayList localArrayList = j(paramLong);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {
      ThreadManager.post(new AccountDetailDynamicDataManager.2(this, paramLong, paramQQAppInterface, paramacje), 8, null, true);
    }
  }
  
  public boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    DynamicInfoEntity localDynamicInfoEntity2 = (DynamicInfoEntity)this.em.find(DynamicInfoEntity.class, paramLong);
    DynamicInfoEntity localDynamicInfoEntity1 = localDynamicInfoEntity2;
    if (localDynamicInfoEntity2 == null) {
      localDynamicInfoEntity1 = new DynamicInfoEntity();
    }
    localDynamicInfoEntity1.puin = String.valueOf(paramLong);
    localDynamicInfoEntity1.dynamicInfoData = paramArrayOfByte;
    return a(localDynamicInfoEntity1);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.em.update(paramEntity);
  }
  
  public ArrayList<jts> j(long paramLong)
  {
    jtr localjtr = a(paramLong);
    if (localjtr == null) {
      return null;
    }
    return localjtr.aZ();
  }
  
  public void onDestroy()
  {
    this.d.evictAll();
    this.em.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jub
 * JD-Core Version:    0.7.0.1
 */