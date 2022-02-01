import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager.2;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager.3;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class afhj
  implements Manager
{
  private Handler.Callback b = new afhk(this);
  public volatile boolean bYd;
  public boolean bYe;
  private boolean bYf;
  public volatile int cQT = 0;
  public volatile int cQU;
  private ConcurrentHashMap<String, EmoticonFromGroupEntity> ff = new ConcurrentHashMap(600);
  private ConcurrentHashMap<String, EmoticonFromGroupEntity> fg = new ConcurrentHashMap(20);
  private QQAppInterface mApp;
  public EntityManager mEntityManager;
  private List<EmoticonFromGroupEntity> zF;
  public List<URLDrawable> zG = new ArrayList(20);
  
  public afhj(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mEntityManager = this.mApp.a().createEntityManager();
    this.zF = new CopyOnWriteArrayList();
  }
  
  private boolean ajl()
  {
    return this.ff.size() >= 400;
  }
  
  private void c(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if ((paramEmoticonFromGroupEntity == null) || (paramEmoticonFromGroupEntity.md5 == null) || (paramEmoticonFromGroupEntity.md5.equals("")) || (paramEmoticonFromGroupEntity.thumbURL == null) || (paramEmoticonFromGroupEntity.thumbURL.equals("")) || (paramEmoticonFromGroupEntity.bigURL == null) || (paramEmoticonFromGroupEntity.bigURL.equals(""))) {}
    do
    {
      return;
      f(paramEmoticonFromGroupEntity);
      switch (this.cQT)
      {
      case 1: 
      default: 
        return;
      case 0: 
        cZz();
        return;
      }
    } while ((!this.bYe) || (this.fg.size() < 10));
    paramEmoticonFromGroupEntity = new ArrayList(this.fg.values());
    this.fg.clear();
    T(paramEmoticonFromGroupEntity, 1);
  }
  
  private List<EmoticonFromGroupEntity> eC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_DBManager", 2, "sortAndSyncData start.");
    }
    ArrayList localArrayList1 = new ArrayList(this.ff.values());
    Collections.sort(localArrayList1);
    if (this.bYe)
    {
      ArrayList localArrayList2 = new ArrayList(100);
      int j = localArrayList1.size();
      if (j > 300)
      {
        int i = 300;
        while (i < j)
        {
          String str = ((EmoticonFromGroupEntity)localArrayList1.get(i)).md5;
          EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.ff.remove(str);
          if (this.fg.containsKey(str)) {
            this.fg.remove(str);
          }
          if (localEmoticonFromGroupEntity != null) {
            localArrayList2.add(localEmoticonFromGroupEntity);
          }
          i += 1;
        }
        T(localArrayList2, 2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_DBManager", 2, "sortAndSyncData end.");
    }
    return localArrayList1;
  }
  
  public int CW()
  {
    return this.ff.size();
  }
  
  public int CX()
  {
    return this.fg.size();
  }
  
  public void T(List<EmoticonFromGroupEntity> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = new EmoticonFromGroupDBManager.3(this, paramInt, paramList);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramList.run();
      return;
    }
    ThreadManager.post(paramList, 5, null, true);
  }
  
  public void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    paramEmoticonFromGroupEntity = new EmoticonFromGroupDBManager.2(this, paramInt, paramEmoticonFromGroupEntity);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramEmoticonFromGroupEntity.run();
      return;
    }
    ThreadManager.post(paramEmoticonFromGroupEntity, 5, null, true);
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.mEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.mEntityManager.update(paramEntity);
  }
  
  public void af(MessageRecord paramMessageRecord)
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if ((paramMessageRecord instanceof MessageForPic)) {
      c(((aqrc)this.mApp.getManager(235)).c.a(paramMessageRecord));
    }
    for (;;)
    {
      if (!this.bYd)
      {
        this.bYd = true;
        if (ajl())
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_DBManager", 2, "clean data start.");
          }
          eC();
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_DBManager", 2, "clean data end.");
          }
        }
        this.bYd = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StressTesting.Emoticon.EmoticonFromGroup", 2, "EmoticonFromGroup deal with per msg=" + (Calendar.getInstance().getTimeInMillis() - l));
      }
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        Iterator localIterator = paramMessageRecord.msgElemList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          if ((localObject instanceof MessageForPic))
          {
            localObject = (MessageForPic)localObject;
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject, paramMessageRecord);
            c(((aqrc)this.mApp.getManager(235)).c.a((MessageRecord)localObject));
          }
        }
      }
    }
  }
  
  public void ag(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      if (this.ff.containsKey(((MessageForPic)paramMessageRecord).md5)) {
        a((EmoticonFromGroupEntity)this.ff.remove(((MessageForPic)paramMessageRecord).md5), 2);
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (!(paramMessageRecord instanceof MessageForMixedMsg));
      paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
      localArrayList = new ArrayList(20);
      Iterator localIterator = paramMessageRecord.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MessageRecord)localIterator.next();
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject, paramMessageRecord);
          localObject = ((aqrc)this.mApp.getManager(235)).c.a((MessageRecord)localObject);
          localObject = (EmoticonFromGroupEntity)this.ff.remove(((EmoticonFromGroupEntity)localObject).md5);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    } while (localArrayList.isEmpty());
    T(localArrayList, 2);
  }
  
  public void cZy()
  {
    if (!this.bYf)
    {
      this.bYf = true;
      new Handler(ThreadManager.getSubThreadLooper(), this.b).sendEmptyMessageDelayed(1, 10000L);
    }
  }
  
  public void cZz()
  {
    if (this.cQT == 0)
    {
      this.cQT = 1;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db start.");
      }
      Object localObject = eD();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db mid.");
      }
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          e((EmoticonFromGroupEntity)((Iterator)localObject).next());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db end.");
      }
      this.cQT = 2;
    }
  }
  
  public void d(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity != null)
    {
      if (this.ff.containsKey(paramEmoticonFromGroupEntity.md5)) {
        this.ff.remove(paramEmoticonFromGroupEntity.md5);
      }
      if (this.fg.containsKey(paramEmoticonFromGroupEntity.md5)) {
        this.fg.remove(paramEmoticonFromGroupEntity.md5);
      }
    }
  }
  
  public void e(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {}
    label149:
    for (;;)
    {
      return;
      if ((!this.ff.isEmpty()) && (this.ff.containsKey(paramEmoticonFromGroupEntity.md5)))
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.ff.get(paramEmoticonFromGroupEntity.md5);
        if (localEmoticonFromGroupEntity != null)
        {
          if (paramEmoticonFromGroupEntity.timestamp < localEmoticonFromGroupEntity.timestamp) {
            paramEmoticonFromGroupEntity.replaceEntity(localEmoticonFromGroupEntity);
          }
          this.ff.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
        }
      }
      for (;;)
      {
        if (((this.ff.size() < 600) && (this.fg.size() < 300)) || (!QLog.isColorLevel())) {
          break label149;
        }
        QLog.e("EmoticonFromGroup_DBManager", 1, "replaceDBToCache over max limit.");
        return;
        this.ff.remove(paramEmoticonFromGroupEntity.md5);
        break;
        this.ff.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
      }
    }
  }
  
  public List<EmoticonFromGroupEntity> eD()
  {
    if (this.mEntityManager == null) {
      return null;
    }
    return this.mEntityManager.query(EmoticonFromGroupEntity.class);
  }
  
  public List<EmoticonFromGroupEntity> eE()
  {
    return this.zF;
  }
  
  public List<EmoticonFromGroupEntity> eF()
  {
    this.zF.clear();
    List localList = eC();
    if (localList != null)
    {
      if (localList.size() <= 300) {
        break label57;
      }
      localList = localList.subList(0, 300);
      this.zF.addAll(localList);
    }
    for (;;)
    {
      return this.zF;
      label57:
      this.zF.addAll(localList);
    }
  }
  
  public void f(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {}
    for (;;)
    {
      return;
      if ((!this.ff.isEmpty()) && (this.ff.containsKey(paramEmoticonFromGroupEntity.md5)))
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.ff.get(paramEmoticonFromGroupEntity.md5);
        if (localEmoticonFromGroupEntity != null) {
          if (paramEmoticonFromGroupEntity.timestamp > localEmoticonFromGroupEntity.timestamp)
          {
            localEmoticonFromGroupEntity.replaceEntity(paramEmoticonFromGroupEntity);
            this.fg.put(localEmoticonFromGroupEntity.md5, localEmoticonFromGroupEntity);
          }
        }
      }
      while (((this.ff.size() >= 600) || (this.fg.size() >= 300)) && (QLog.isColorLevel()))
      {
        QLog.e("EmoticonFromGroup_DBManager", 1, "add2cache over max limit.");
        return;
        this.ff.remove(paramEmoticonFromGroupEntity.md5);
        continue;
        this.ff.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
        this.fg.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
      }
    }
  }
  
  public void jZ(List<EmoticonFromGroupEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
        if (this.ff.containsKey(localEmoticonFromGroupEntity.md5)) {
          this.ff.remove(localEmoticonFromGroupEntity.md5);
        }
        if (this.fg.containsKey(localEmoticonFromGroupEntity.md5)) {
          this.fg.remove(localEmoticonFromGroupEntity.md5);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (!this.fg.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.fg.values());
      this.fg.clear();
      T(localArrayList, 1);
    }
    this.ff.clear();
    if (this.mEntityManager != null) {
      this.mEntityManager.close();
    }
    this.zF.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhj
 * JD-Core Version:    0.7.0.1
 */