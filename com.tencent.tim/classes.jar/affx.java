import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.1;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.2;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.3;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public abstract class affx<T extends CustomEmotionBase>
  implements Manager
{
  public QQAppInterface app;
  protected List<T> zz = new CopyOnWriteArrayList();
  
  public affx(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  protected void S(List<T> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    a(new CustomEmotionRoamingDBManagerBase.1(this, paramList, paramInt), 8);
  }
  
  public abstract afmi a(T paramT);
  
  public T a(String paramString)
  {
    if (this.app == null) {}
    do
    {
      EntityManager localEntityManager;
      do
      {
        return null;
        localEntityManager = this.app.a().createEntityManager();
      } while (localEntityManager == null);
      paramString = localEntityManager.query(h(), false, "url=?", new String[] { paramString }, null, null, null, null);
      localEntityManager.close();
    } while ((paramString == null) || (paramString.size() != 1));
    return (CustomEmotionBase)paramString.get(0);
  }
  
  public void a(affx.a parama)
  {
    if (parama == null) {
      return;
    }
    ThreadManager.post(new CustomEmotionRoamingDBManagerBase.3(this, parama), 5, null, true);
  }
  
  public void a(T paramT)
  {
    if (paramT != null)
    {
      b(paramT, 4);
      a(paramT, 4);
    }
  }
  
  public void a(T paramT, int paramInt)
  {
    if (paramT == null) {
      return;
    }
    a(new CustomEmotionRoamingDBManagerBase.2(this, paramInt, paramT), 8);
  }
  
  public void a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    ThreadManager.post(paramRunnable, paramInt, null, true);
  }
  
  public List<String> ar(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getCustomEmoticonResIdsByType.");
    }
    Object localObject = ez();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
        String str = localCustomEmotionBase.resid;
        if ((localCustomEmotionBase.RomaingType.equals(paramString)) && (str != null) && (!"".equals(str))) {
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  public List<T> as(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getEmoticonDatasByType.");
      }
      localList = ez();
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localList.get(i);
      if (localCustomEmotionBase.RomaingType.equals(paramString)) {
        localArrayList.add(localCustomEmotionBase);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<T> at(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from findMagicEmosById.");
    }
    List localList = ez();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localList.get(i);
        if ((localCustomEmotionBase != null) && (localCustomEmotionBase.emoPath.equals(paramString))) {
          localArrayList.add(localCustomEmotionBase);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void b(T paramT)
  {
    if (paramT != null)
    {
      b(paramT, 2);
      a(paramT, 2);
    }
  }
  
  protected void b(T paramT, int paramInt)
  {
    if (paramT == null) {}
    CustomEmotionBase localCustomEmotionBase;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          switch (paramInt)
          {
          }
        } while (!QLog.isColorLevel());
        QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not update fav emoticon cache data, type:" + paramInt);
        return;
        this.zz.add(paramT);
        return;
        localIterator = this.zz.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
        } while (localCustomEmotionBase.emoId != paramT.emoId);
        localCustomEmotionBase.replace(paramT);
        return;
        localIterator = this.zz.iterator();
      }
      localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
    } while (localCustomEmotionBase.emoId != paramT.emoId);
    this.zz.remove(localCustomEmotionBase);
  }
  
  public void c(T paramT)
  {
    if (paramT != null)
    {
      b(paramT, 1);
      a(paramT, 1);
    }
  }
  
  public abstract List<afmi> eA();
  
  public abstract List<afmi> eB();
  
  public abstract List<T> ez();
  
  public abstract Class h();
  
  public void jT(List<T> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      b((CustomEmotionBase)paramList.get(i), 4);
      i += 1;
    }
    S(paramList, 4);
  }
  
  public void onDestroy()
  {
    this.zz.clear();
    this.app = null;
  }
  
  public void trimCache()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zz.iterator();
    while (localIterator.hasNext())
    {
      CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
      if (localCustomEmotionBase.RomaingType.equals("failed")) {
        localArrayList.add(localCustomEmotionBase);
      }
    }
    this.zz.removeAll(localArrayList);
    this.zz.addAll(localArrayList);
  }
  
  public static abstract interface a
  {
    public abstract void jS(List<afmi> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affx
 * JD-Core Version:    0.7.0.1
 */