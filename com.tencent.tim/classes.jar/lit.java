import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository.1;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class lit
{
  private ReadInJoyUserInfoModule a;
  private ConcurrentHashMap<String, ReadInJoyUserInfo> bp = new ConcurrentHashMap();
  private EntityManager mEntityManager;
  private ExecutorService mExecutorService;
  
  public lit(ExecutorService paramExecutorService, ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, EntityManager paramEntityManager)
  {
    this.mExecutorService = paramExecutorService;
    this.a = paramReadInJoyUserInfoModule;
    this.mEntityManager = paramEntityManager;
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "saveReadInJoyUserInfoToDB, \n  userInfo = ", paramReadInJoyUserInfo });
    if (paramReadInJoyUserInfo != null) {
      kxm.a("saveReadInJoyUserInfoToDB", new ReadInJoyUserInfoRepository.1(this, paramReadInJoyUserInfo), this.mExecutorService);
    }
  }
  
  public List<ReadInJoyUserInfo> D(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return null;
      localList = this.mEntityManager.query(ReadInJoyUserInfo.class, true, "uin = ?", new String[] { paramString }, null, null, null, "1");
    } while ((localList == null) || (localList.size() <= 0));
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadSingleReadInJoyUserInfoFromDB, userInfo = ", localList.get(0) });
    a(paramString, (ReadInJoyUserInfo)localList.get(0), false, true);
    return localList;
  }
  
  public ReadInJoyUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)this.bp.get(paramString);
    if ((localReadInJoyUserInfo != null) && (!localReadInJoyUserInfo.requestFlag))
    {
      localReadInJoyUserInfo.requestFlag = true;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      if (this.a != null) {
        this.a.a(localArrayList, 1, 1, 0);
      }
    }
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "getReadInJoyUserInfoByUin, \n ", "userInfo = ", localReadInJoyUserInfo });
    return localReadInJoyUserInfo;
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback.");
    } while (this.a == null);
    Object localObject = this.a.f();
    if ((localObject != null) && (((ConcurrentHashMap)localObject).get(paramString) != null))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = (List)((ConcurrentHashMap)localObject).get(paramString);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyUserInfoModule.a locala = (ReadInJoyUserInfoModule.a)localIterator.next();
        if (locala != null)
        {
          locala.onLoadUserInfoSucceed(paramString, paramReadInJoyUserInfo);
          localArrayList.add(locala);
        }
      }
      if (localArrayList.size() > 0) {
        ((List)localObject).removeAll(localArrayList);
      }
    }
    for (;;)
    {
      paramReadInJoyUserInfo = this.a.h();
      if (paramReadInJoyUserInfo == null) {
        break;
      }
      paramReadInJoyUserInfo.remove(paramString);
      return;
      QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback tempList is null.");
      continue;
      QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback callbackList is null.");
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramReadInJoyUserInfo == null)) {
      QLog.d("ReadInJoyUserInfoRepository", 2, "updateReadInJoyUserInfo failed, uin is null or empty, or userInfo is null");
    }
    do
    {
      return;
      this.bp.put(paramString, paramReadInJoyUserInfo);
      QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "updateReadInJoyUserInfo, \n uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo, Character.valueOf('\n'), "saveToDB = ", Boolean.valueOf(paramBoolean1), Character.valueOf('\n'), "notifyCallback = ", Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        a(paramString, paramReadInJoyUserInfo);
      }
    } while (!paramBoolean1);
    a(paramReadInJoyUserInfo);
  }
  
  public void aMz()
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, "resetRequestFlag.");
    if (this.bp != null)
    {
      Iterator localIterator = this.bp.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyUserInfo)((Map.Entry)localIterator.next()).getValue()).requestFlag = false;
      }
    }
  }
  
  public void clear()
  {
    this.bp.clear();
  }
  
  public void rq(int paramInt)
  {
    try
    {
      kxm.a("loadReadInJoyUserInfoFromDB", new ReadInJoyUserInfoRepository.2(this, paramInt), this.mExecutorService);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.d("ReadInJoyUserInfoRepository", 1, "loadReadInJoyUserInfoFromDB exception.");
      localRejectedExecutionException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lit
 * JD-Core Version:    0.7.0.1
 */