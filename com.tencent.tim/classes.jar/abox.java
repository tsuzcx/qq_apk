import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class abox
{
  private CopyOnWriteArrayList<abow> H = new CopyOnWriteArrayList();
  private int cqy = -1;
  
  public void HI(int paramInt)
  {
    if ((abmt.hP(paramInt)) || (abmt.hQ(paramInt))) {}
    abow localabow;
    do
    {
      do
      {
        return;
      } while (this.H == null);
      if (this.H.size() == 1)
      {
        QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "curGame:" + paramInt);
        this.cqy = paramInt;
        return;
      }
      localabow = b(paramInt);
    } while ((localabow == null) || (!this.H.remove(localabow)));
    this.H.add(0, localabow);
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "curGame:" + paramInt);
    this.cqy = paramInt;
  }
  
  public abow a(int paramInt)
  {
    if (this.H == null) {
      localObject = null;
    }
    abow localabow;
    do
    {
      return localObject;
      localabow = b(paramInt);
      localObject = localabow;
    } while (localabow != null);
    Object localObject = new abow(paramInt);
    this.H.add(0, localObject);
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "[add] size of cycles:" + this.H.size());
    return localObject;
  }
  
  public abow a(int paramInt1, int paramInt2)
  {
    if (this.H == null) {
      return null;
    }
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      abow localabow = (abow)localIterator.next();
      if ((localabow != null) && (localabow.getGameId() == paramInt1) && (localabow.cpN == paramInt2)) {
        return localabow;
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    int i = 0;
    Object localObject2 = b(paramInt1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramInt2 == 1)
      {
        localObject2 = a(paramInt1);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (paramStartCheckParam != null)
          {
            ((abow)localObject2).cpN = paramInt3;
            if (BaseActivity.sTopActivity == null) {
              break label133;
            }
            ((abow)localObject2).a(BaseActivity.sTopActivity, paramStartCheckParam);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, "[handleActLifeCycle] rebuild game");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    if (paramInt2 == 1) {
      if (localObject1 != null)
      {
        if (localObject1.cpN != 0) {
          break label144;
        }
        localObject1.cpN = paramInt3;
        localObject2 = localObject1;
        label125:
        ((abow)localObject2).gH(paramInt1, paramInt2);
      }
    }
    label133:
    label144:
    do
    {
      do
      {
        return;
        QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "[handleActLifeCycle] context is null");
        break;
        localObject2 = localObject1;
        if (localObject1.cpN == paramInt3) {
          break label125;
        }
        localObject1.gH(paramInt1, 5);
        if (this.H != null) {
          this.H.remove(localObject1);
        }
        QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "handleActLifeCycle remove last same gameId activity");
        localObject2 = new abow(paramInt1);
        ((abow)localObject2).cpN = paramInt3;
        if ((BaseActivity.sTopActivity != null) && (paramStartCheckParam != null)) {
          ((abow)localObject2).a(BaseActivity.sTopActivity, paramStartCheckParam);
        }
        this.H.add(0, localObject2);
        QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "handleActLifeCycle [add] size of cycles:" + this.H.size());
        break label125;
        if (paramInt2 == 5)
        {
          paramStartCheckParam = a(paramInt1, paramInt3);
          if (paramStartCheckParam == null)
          {
            QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "findLifeCycleByActivityId not found ON_DESTROY");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, "findLifeCycleByActivityId found ON_DESTROY lifeCycle:" + paramStartCheckParam);
          }
          paramStartCheckParam.gH(paramInt1, paramInt2);
          paramInt1 = i;
          if (this.H != null)
          {
            this.H.remove(paramStartCheckParam);
            paramInt1 = i;
          }
          for (;;)
          {
            if (paramInt1 < this.H.size())
            {
              paramStartCheckParam = (abow)this.H.get(paramInt1);
              if ((!abmt.hP(paramStartCheckParam.getGameId())) && (!abmt.hQ(paramStartCheckParam.getGameId())))
              {
                paramStartCheckParam.cDJ();
                this.cqy = paramStartCheckParam.getGameId();
              }
            }
            else
            {
              QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "[remove], size of cycles:" + this.H.size());
              return;
            }
            paramInt1 += 1;
          }
        }
      } while (localObject1 == null);
      localObject1.gH(paramInt1, paramInt2);
    } while (paramInt2 != 2);
    HI(paramInt1);
  }
  
  public abow b(int paramInt)
  {
    if (this.H == null) {
      return null;
    }
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      abow localabow = (abow)localIterator.next();
      if ((localabow != null) && (localabow.getGameId() == paramInt)) {
        return localabow;
      }
    }
    return null;
  }
  
  public List<abow> dF()
  {
    return this.H;
  }
  
  public void onDestroy()
  {
    if (this.H == null) {
      return;
    }
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      abow localabow = (abow)localIterator.next();
      if (localabow != null) {
        localabow.onDestroy();
      }
    }
    this.H.clear();
    this.cqy = -1;
  }
  
  public int zE()
  {
    return this.cqy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abox
 * JD-Core Version:    0.7.0.1
 */