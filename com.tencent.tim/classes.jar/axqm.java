import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateSet.1;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class axqm
  extends axpw
  implements axpo
{
  float Er = 1.0F;
  public ArrayList<axpn> FV = new ArrayList();
  public long aCu;
  public boolean hasError;
  public WeakReference<Activity> jl;
  private final CopyOnWriteArraySet<axpn> l = new CopyOnWriteArraySet();
  
  public axqm(Object paramObject)
  {
    super(paramObject);
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "unApply " + toString() + ", " + paramInt);
    }
    Object localObject1 = this.FV.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (axpn)((Iterator)localObject1).next();
      if (((localObject2 instanceof axrd)) && ((paramInt == 2) || (paramInt == 4))) {
        ((axrd)localObject2).E(paramActivity, paramInt);
      } else {
        ((axpn)localObject2).A(paramActivity, paramInt);
      }
    }
    ayva.a().b(null, paramActivity, paramInt);
    localObject1 = (axpx)axov.a(15);
    Object localObject2 = localObject1.a[paramInt];
    if ((localObject2 != null) && (((axqm)localObject2).getUniqueId().equals(getUniqueId()))) {
      ((axpx)localObject1).a(null, paramActivity, paramInt);
    }
  }
  
  public void B(Activity paramActivity, int paramInt)
  {
    super.B(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "select " + toString());
    }
    QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)this.target;
    ((axpx)axov.a(15)).a(localQIMTemplateItem, paramActivity, paramInt);
    ((axpr)axov.a(5)).a(paramInt).c(this);
  }
  
  public int Rq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "download " + toString());
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      aeD(6);
      return 2;
    }
    this.aCu = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new TemplateSet.1(this));
    return 1;
  }
  
  public int Rr()
  {
    Object localObject = this.FV.iterator();
    int j = 0;
    int i = 0;
    axpn localaxpn;
    if (((Iterator)localObject).hasNext())
    {
      localaxpn = (axpn)((Iterator)localObject).next();
      if (localaxpn.getState() == 2)
      {
        localaxpn.a(this);
        this.l.add(localaxpn);
        localaxpn.Rq();
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "download " + toString() + "  " + localaxpn.toString());
        }
        i = j;
        j = 1;
      }
    }
    for (;;)
    {
      int k = j;
      j = i;
      i = k;
      break;
      if (localaxpn.getState() == 1)
      {
        this.l.add(localaxpn);
        localaxpn.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "downloading " + toString() + ":" + localaxpn.toString());
        }
        k = 1;
        j = i;
        i = k;
        continue;
        if (this.l.size() > 0)
        {
          aeE(1);
          eNI();
          localObject = (axpr)axov.b(5);
          if (localObject != null) {
            ((axpr)localObject).b(this);
          }
        }
        if ((i != 0) || (j != 0))
        {
          aeE(1);
          return 1;
        }
        aeE(3);
        eNJ();
        return 3;
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public void a(axpn paramaxpn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadStart " + toString() + ", count=" + this.l.size());
    }
  }
  
  public void a(axpn paramaxpn, int paramInt)
  {
    this.hasError = true;
    this.l.remove(paramaxpn);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadError " + toString() + ":" + paramaxpn.toString() + ", count=" + this.l.size());
    }
    if (this.l.isEmpty())
    {
      aeE(2);
      aeD(paramInt);
    }
  }
  
  public void aeD(int paramInt)
  {
    super.aeD(paramInt);
    axpr localaxpr = (axpr)axov.b(5);
    if (localaxpr != null) {
      localaxpr.a(this, paramInt);
    }
  }
  
  public void aeE(int paramInt)
  {
    this.outState = paramInt;
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    Object localObject1;
    if ((this instanceof axqm))
    {
      localObject1 = (axpx)axov.a(15);
      if (((axpx)localObject1).a(this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "apply already" + toString());
        }
        ((axpx)localObject1).a(this, paramActivity, paramInt);
      }
    }
    label344:
    do
    {
      Object localObject3;
      do
      {
        do
        {
          do
          {
            return 0;
            localObject3 = (QIMTemplateItem)this.target;
            if ((localObject3 != null) && (paramInt == 0))
            {
              localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
              if ("back".equals(((QIMTemplateItem)localObject3).ceV))
              {
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(anij.TAG, 2);
                ((AppRuntime)localObject2).notifyObservers(axpu.class, 970, true, (Bundle)localObject3);
              }
            }
            else
            {
              localObject2 = localObject1.a[paramInt];
              if (localObject2 != null) {
                ((axqm)localObject2).A(paramActivity, paramInt);
              }
              ((axpx)localObject1).a(this, paramActivity, paramInt);
              if (QLog.isColorLevel()) {
                QLog.i("QTemplate", 2, "apply " + toString() + ", " + paramInt);
              }
              localObject1 = new ArrayList();
              localObject2 = this.FV.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label344;
              }
              localObject3 = (axpn)((Iterator)localObject2).next();
              if ((localObject3 instanceof axpp))
              {
                ((List)localObject1).add(((axpp)localObject3).d);
                continue;
                if ((!"front".equals(((QIMTemplateItem)localObject3).ceV)) || (!anih.agb())) {
                  break;
                }
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(anij.TAG, 1);
                ((AppRuntime)localObject2).notifyObservers(axpu.class, 970, true, (Bundle)localObject3);
                break;
              }
              ((axpn)localObject3).b(paramActivity, paramInt);
            }
          } while (!(this instanceof axqm));
          localObject2 = (axpr)axov.a(5);
          if (((axpr)localObject2).a(paramInt).aPu()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject3 = ((axpr)localObject2).a;
      } while (localObject3 == null);
      Object localObject2 = ((axpr)localObject2).a(this, ((ayva.a)localObject3).a(paramInt).filterList);
      if (localObject2 != null) {
        ayva.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      }
      ayva.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      axpp.a(paramActivity, (List)localObject1, this, paramInt);
      paramActivity = this.target;
    } while ((!(this.target instanceof QIMTemplateItem)) || (!((QIMTemplateItem)this.target).auG()) || (paramInt == 1) || (paramInt == 3));
    ((axro)axov.a().c(8)).aeH(paramInt);
    return 0;
  }
  
  public void b(axpn paramaxpn)
  {
    this.l.remove(paramaxpn);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadSuccess= " + toString() + ":" + paramaxpn.toString() + ", count=" + this.l.size());
    }
    if (this.l.isEmpty())
    {
      if (this.hasError)
      {
        aeE(2);
        aeD(4);
      }
    }
    else {
      return;
    }
    aeE(3);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadFinish= " + toString() + ", count=" + this.l.size());
    }
    eNJ();
  }
  
  public void d(axpn paramaxpn)
  {
    this.FV.add(paramaxpn);
    paramaxpn.mTemplateId = (this.FV.size() - 1);
    this.Er = (1.0F / this.FV.size());
  }
  
  public void eNJ()
  {
    super.eNJ();
    axpr localaxpr = (axpr)axov.b(5);
    if (localaxpr != null) {
      localaxpr.a(this);
    }
  }
  
  public float getProgress()
  {
    try
    {
      Iterator localIterator = this.FV.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        axpn localaxpn = (axpn)localIterator.next();
        f2 = localaxpn.getProgress();
        if (QLog.isDevelopLevel()) {
          QLog.i("QTemplate", 2, "getProgress " + localaxpn.toString() + " progress =" + f2);
        }
        f3 = this.Er;
      }
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  public int getState()
  {
    int j = 0;
    int k = 1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("getState = ");
      localStringBuilder.append(toString());
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      Iterator localIterator = this.FV.iterator();
      int i;
      if (localIterator.hasNext())
      {
        axpn localaxpn = (axpn)localIterator.next();
        i = localaxpn.getState();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localaxpn.toString());
          localStringBuilder.append("   ");
        }
        if (i == 2)
        {
          i = 0;
          j = 1;
        }
      }
      for (;;)
      {
        label128:
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, localStringBuilder.toString());
        }
        if (j != 0)
        {
          aeE(2);
          i = 2;
        }
        do
        {
          return i;
          if (i != 1) {
            break;
          }
          i = 1;
          break label128;
          if (i == 0) {
            break label214;
          }
          if (this.outState != 1) {
            Rq();
          }
          i = k;
        } while (System.currentTimeMillis() - this.aCu <= 15000L);
        aeE(2);
        aeD(5);
        return 2;
        label214:
        aeE(3);
        return 3;
        i = 0;
      }
      localStringBuilder = null;
    }
  }
  
  public String getUniqueId()
  {
    if (this.target != null) {
      return ((QIMTemplateItem)this.target).id;
    }
    return "unknown" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqm
 * JD-Core Version:    0.7.0.1
 */