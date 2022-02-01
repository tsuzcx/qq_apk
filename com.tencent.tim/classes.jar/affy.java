import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public abstract class affy<T extends CustomEmotionBase>
  implements Manager
{
  protected CopyOnWriteArrayList<WeakReference<afic>> Z = new CopyOnWriteArrayList();
  protected AtomicBoolean cR = new AtomicBoolean(false);
  protected QQAppInterface mApp;
  protected String uin;
  
  public affy(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.uin = paramQQAppInterface.getCurrentAccountUin();
  }
  
  protected abstract int CR();
  
  protected abstract acdd<T> a();
  
  protected abstract affx<T> a();
  
  public void a(afic paramafic)
  {
    Iterator localIterator = this.Z.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramafic) {
        return;
      }
    }
    paramafic = new WeakReference(paramafic);
    this.Z.add(paramafic);
  }
  
  public boolean ajh()
  {
    return this.cR.compareAndSet(false, true);
  }
  
  public void b(afic paramafic)
  {
    if (paramafic == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.Z.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramafic);
    this.Z.remove(localWeakReference);
  }
  
  public void cYY()
  {
    this.cR.set(false);
  }
  
  public void cYZ()
  {
    if (this.mApp == null) {}
    acdd localacdd;
    do
    {
      return;
      localacdd = a();
    } while (localacdd == null);
    if (QLog.isColorLevel()) {
      QLog.d("CustomEmotionRoamingManagerBase", 2, "------------start syncRoaming----------");
    }
    localacdd.cHj();
  }
  
  public void onDestroy()
  {
    this.Z.clear();
    this.cR.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affy
 * JD-Core Version:    0.7.0.1
 */