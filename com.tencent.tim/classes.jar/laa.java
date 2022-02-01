import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyActivityDAUInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mobileqq.statistics.UEC.UECItem;
import com.tencent.mobileqq.statistics.UEC.a;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class laa
  implements Handler.Callback, UEC.a, Manager
{
  private QQAppInterface app;
  private MqqHandler b;
  private HashMap<String, ReadInJoyActivityDAUInfo> mCache;
  private EntityManager mEntityManager;
  
  public laa(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mCache = new HashMap(4);
    this.b = new aqgw(ThreadManager.getSubThreadLooper(), this);
  }
  
  private String getCurrentDate()
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }
  
  public String Q(String paramString1, String paramString2)
  {
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null) {
        return paramString1;
      }
      i = 0;
    }
    catch (Exception localException1)
    {
      try
      {
        String[] arrayOfString;
        int i;
        if (i >= arrayOfString.length) {
          break label165;
        }
        String str1 = arrayOfString[i];
        int j = str1.indexOf("+");
        int k = str1.indexOf(":");
        paramString2 = paramString1;
        if (j > 0)
        {
          paramString2 = paramString1;
          if (k > 0)
          {
            paramString2 = str1.substring(0, j);
            String str2 = str1.substring(j + 1, k);
            str1 = str1.substring(k + 1);
            paramString2 = UEC.a(paramString1, paramString2, Integer.valueOf(str2).intValue(), Integer.valueOf(str1).intValue());
          }
        }
        i += 1;
        paramString1 = paramString2;
      }
      catch (Exception localException2)
      {
        label129:
        break label129;
      }
      localException1 = localException1;
      paramString2 = paramString1;
      if (!QLog.isColorLevel()) {
        break label165;
      }
      QLog.d("Q.activity_dau", 2, "saveToDB|preActivityList error:" + localException1);
      paramString2 = paramString1;
    }
    paramString2 = paramString1;
    label165:
    return paramString2;
    return paramString1;
  }
  
  public void bR(ArrayList<UEC.UECItem> paramArrayList)
  {
    if (aqmj.bY(this.app.getApp()))
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.b.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    Object localObject3;
    if (paramMessage.what == 0)
    {
      paramMessage = (ArrayList)paramMessage.obj;
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        label308:
        while (paramMessage.hasNext())
        {
          localObject2 = (UEC.UECItem)paramMessage.next();
          localObject1 = ((UEC.UECItem)localObject2).mKey;
          if (this.mCache.containsKey(localObject1))
          {
            localObject3 = (ReadInJoyActivityDAUInfo)this.mCache.get(localObject1);
            ((ReadInJoyActivityDAUInfo)localObject3).count += 1;
            ((ReadInJoyActivityDAUInfo)localObject3).showTime += ((UEC.UECItem)localObject2).anB;
            ((ReadInJoyActivityDAUInfo)localObject3).displayCount += ((UEC.UECItem)localObject2).dLb;
            ((ReadInJoyActivityDAUInfo)localObject3).preActivityList = Q(((ReadInJoyActivityDAUInfo)localObject3).preActivityList, ((UEC.UECItem)localObject2).cgf);
            ((ReadInJoyActivityDAUInfo)localObject3).activeDate = getCurrentDate();
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label308;
            }
            localObject2 = (ReadInJoyActivityDAUInfo)this.mCache.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            QLog.d("Q.activity_dau", 2, "reportInternal|activityName:" + (String)localObject1 + " count:" + ((ReadInJoyActivityDAUInfo)localObject2).count + " time:" + ((ReadInJoyActivityDAUInfo)localObject2).showTime + " dis:" + ((ReadInJoyActivityDAUInfo)localObject2).displayCount + " pre:" + ((ReadInJoyActivityDAUInfo)localObject2).preActivityList);
            break;
            localObject3 = new ReadInJoyActivityDAUInfo();
            ((ReadInJoyActivityDAUInfo)localObject3).count = 1;
            ((ReadInJoyActivityDAUInfo)localObject3).activityName = ((String)localObject1);
            ((ReadInJoyActivityDAUInfo)localObject3).showTime = ((UEC.UECItem)localObject2).anB;
            ((ReadInJoyActivityDAUInfo)localObject3).displayCount = ((UEC.UECItem)localObject2).dLb;
            ((ReadInJoyActivityDAUInfo)localObject3).preActivityList = ((UEC.UECItem)localObject2).cgf;
            ((ReadInJoyActivityDAUInfo)localObject3).activeDate = getCurrentDate();
            this.mCache.put(localObject1, localObject3);
          }
        }
      }
      if (this.mCache.size() >= 4)
      {
        this.b.removeMessages(1);
        this.b.sendEmptyMessage(1);
      }
    }
    while (paramMessage.what != 1)
    {
      do
      {
        return false;
      } while (this.b.hasMessages(1));
      this.b.sendEmptyMessageDelayed(1, 120000L);
      return false;
    }
    try
    {
      if (this.mEntityManager != null) {
        break label418;
      }
      if (!this.app.isLogin()) {
        return false;
      }
    }
    finally {}
    this.mEntityManager = this.app.a().createEntityManager();
    label418:
    paramMessage = this.mCache.keySet();
    Object localObject1 = this.mEntityManager.getTransaction();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject1).begin();
        localObject2 = paramMessage.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label745;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        localReadInJoyActivityDAUInfo = (ReadInJoyActivityDAUInfo)this.mCache.get(localObject3);
        paramMessage = (ReadInJoyActivityDAUInfo)this.mEntityManager.find(ReadInJoyActivityDAUInfo.class, (String)localObject3);
        if (paramMessage != null) {
          continue;
        }
        paramMessage = new ReadInJoyActivityDAUInfo();
        paramMessage.activityName = ((String)localObject3);
        paramMessage.count = localReadInJoyActivityDAUInfo.count;
        paramMessage.showTime = localReadInJoyActivityDAUInfo.showTime;
        paramMessage.displayCount = localReadInJoyActivityDAUInfo.displayCount;
        paramMessage.preActivityList = localReadInJoyActivityDAUInfo.preActivityList;
        paramMessage.activeDate = getCurrentDate();
      }
      catch (Exception paramMessage)
      {
        ReadInJoyActivityDAUInfo localReadInJoyActivityDAUInfo;
        paramMessage.printStackTrace();
        ((EntityTransaction)localObject1).end();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.activity_dau", 2, "saveToDB|cache size:" + this.mCache.size());
        this.mCache.clear();
        return false;
        paramMessage.count += localReadInJoyActivityDAUInfo.count;
        paramMessage.showTime += localReadInJoyActivityDAUInfo.showTime;
        paramMessage.displayCount += localReadInJoyActivityDAUInfo.displayCount;
        paramMessage.preActivityList = Q(paramMessage.preActivityList, localReadInJoyActivityDAUInfo.preActivityList);
        paramMessage.activeDate = getCurrentDate();
        continue;
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
      if (paramMessage.getStatus() == 1000)
      {
        this.mEntityManager.persistOrReplace(paramMessage);
      }
      else if ((paramMessage.getStatus() == 1001) || (paramMessage.getStatus() == 1002))
      {
        this.mEntityManager.update(paramMessage);
        continue;
        label745:
        ((EntityTransaction)localObject1).commit();
        ((EntityTransaction)localObject1).end();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.mEntityManager != null) {}
    try
    {
      this.mEntityManager.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     laa
 * JD-Core Version:    0.7.0.1
 */