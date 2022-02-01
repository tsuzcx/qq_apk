import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivityDAUInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mobileqq.statistics.UEC.UECItem;
import com.tencent.mobileqq.statistics.UEC.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class annv
  implements Handler.Callback, UEC.a, Manager
{
  public static boolean cxy;
  private QQAppInterface app;
  private MqqHandler b;
  private HashMap<String, ActivityDAUInfo> mCache;
  private EntityManager mEntityManager;
  
  public annv(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mCache = new HashMap(4);
    this.b = new aqgw(ThreadManager.getSubThreadLooper(), this);
    dSb();
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
    if (cxy)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.b.sendMessage(localMessage);
    }
  }
  
  public void dSb()
  {
    try
    {
      String str = this.app.getCurrentUin();
      if (Long.valueOf(str).longValue() / 1000L % 1000L < 50L) {
        cxy = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UEC", 2, "dau uin=" + str + " result=" + cxy);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
        label367:
        while (paramMessage.hasNext())
        {
          localObject2 = (UEC.UECItem)paramMessage.next();
          localObject1 = ((UEC.UECItem)localObject2).mKey;
          if (this.mCache.containsKey(localObject1))
          {
            localObject3 = (ActivityDAUInfo)this.mCache.get(localObject1);
            ((ActivityDAUInfo)localObject3).count += 1;
            ((ActivityDAUInfo)localObject3).showTime += ((UEC.UECItem)localObject2).anB;
            ((ActivityDAUInfo)localObject3).displayCount += ((UEC.UECItem)localObject2).dLb;
            ((ActivityDAUInfo)localObject3).preActivityList = Q(((ActivityDAUInfo)localObject3).preActivityList, ((UEC.UECItem)localObject2).cgf);
            ((ActivityDAUInfo)localObject3).webTitle = ((UEC.UECItem)localObject2).cgg;
            ((ActivityDAUInfo)localObject3).domain = ((UEC.UECItem)localObject2).mDomain;
            ((ActivityDAUInfo)localObject3).reportVersion = ((UEC.UECItem)localObject2).mVersion;
            ((ActivityDAUInfo)localObject3).pageName = ((UEC.UECItem)localObject2).aKU;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label367;
            }
            localObject2 = (ActivityDAUInfo)this.mCache.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            QLog.d("Q.activity_dau", 2, "reportInternal|activityName:" + (String)localObject1 + " count:" + ((ActivityDAUInfo)localObject2).count + " time:" + ((ActivityDAUInfo)localObject2).showTime + " v:" + ((ActivityDAUInfo)localObject2).reportVersion + " page:" + ((ActivityDAUInfo)localObject2).pageName);
            break;
            localObject3 = new ActivityDAUInfo();
            ((ActivityDAUInfo)localObject3).count = 1;
            ((ActivityDAUInfo)localObject3).activityName = ((String)localObject1);
            ((ActivityDAUInfo)localObject3).showTime = ((UEC.UECItem)localObject2).anB;
            ((ActivityDAUInfo)localObject3).displayCount = ((UEC.UECItem)localObject2).dLb;
            ((ActivityDAUInfo)localObject3).preActivityList = ((UEC.UECItem)localObject2).cgf;
            ((ActivityDAUInfo)localObject3).webTitle = ((UEC.UECItem)localObject2).cgg;
            ((ActivityDAUInfo)localObject3).domain = ((UEC.UECItem)localObject2).mDomain;
            ((ActivityDAUInfo)localObject3).reportVersion = ((UEC.UECItem)localObject2).mVersion;
            ((ActivityDAUInfo)localObject3).pageName = ((UEC.UECItem)localObject2).aKU;
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
        break label477;
      }
      if (!this.app.isLogin()) {
        return false;
      }
    }
    finally {}
    this.mEntityManager = this.app.a().createEntityManager();
    label477:
    paramMessage = this.mCache.keySet();
    Object localObject1 = this.mEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)localObject1).begin();
      localObject2 = paramMessage.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label909;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localActivityDAUInfo = (ActivityDAUInfo)this.mCache.get(localObject3);
      paramMessage = (ActivityDAUInfo)this.mEntityManager.find(ActivityDAUInfo.class, (String)localObject3);
      if (paramMessage != null) {
        break label808;
      }
      paramMessage = new ActivityDAUInfo();
      paramMessage.activityName = ((String)localObject3);
      paramMessage.count = localActivityDAUInfo.count;
      paramMessage.showTime = localActivityDAUInfo.showTime;
      paramMessage.displayCount = localActivityDAUInfo.displayCount;
      paramMessage.preActivityList = localActivityDAUInfo.preActivityList;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        ActivityDAUInfo localActivityDAUInfo;
        paramMessage.printStackTrace();
        ((EntityTransaction)localObject1).end();
        if (QLog.isColorLevel()) {
          QLog.d("Q.activity_dau", 2, "saveToDB|cache size:" + this.mCache.size());
        }
        this.mCache.clear();
        return false;
        paramMessage.count += localActivityDAUInfo.count;
        paramMessage.showTime += localActivityDAUInfo.showTime;
        paramMessage.displayCount += localActivityDAUInfo.displayCount;
        paramMessage.preActivityList = Q(paramMessage.preActivityList, localActivityDAUInfo.preActivityList);
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).end();
    }
    paramMessage.webTitle = localActivityDAUInfo.webTitle;
    paramMessage.domain = localActivityDAUInfo.domain;
    paramMessage.reportVersion = localActivityDAUInfo.reportVersion;
    paramMessage.pageName = localActivityDAUInfo.pageName;
    if (paramMessage.getStatus() == 1000) {
      this.mEntityManager.persistOrReplace(paramMessage);
    }
    label661:
    label918:
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.activity_dau", 2, "MSG_SAVE_TO_DB|activityName:" + (String)localObject3 + " count:" + paramMessage.count + " time:" + paramMessage.showTime + " v:" + paramMessage.reportVersion + " page:" + paramMessage.pageName);
        break;
      }
      for (;;)
      {
        label808:
        if ((paramMessage.getStatus() != 1001) && (paramMessage.getStatus() != 1002)) {
          break label918;
        }
        this.mEntityManager.update(paramMessage);
        break label661;
        break;
        ((EntityTransaction)localObject1).commit();
        ((EntityTransaction)localObject1).end();
      }
    }
  }
  
  public void onDestroy()
  {
    cxy = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annv
 * JD-Core Version:    0.7.0.1
 */