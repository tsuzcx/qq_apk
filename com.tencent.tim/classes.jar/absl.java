import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class absl
{
  private CopyOnWriteArrayList<absc> L = new CopyOnWriteArrayList();
  private AtomicBoolean ax = new AtomicBoolean(true);
  private abrk jdField_b_of_type_Abrk;
  private absa jdField_b_of_type_Absa;
  private abse d;
  
  public absl(abse paramabse, abrk paramabrk, absa paramabsa)
  {
    this.jdField_b_of_type_Abrk = paramabrk;
    this.d = paramabse;
    this.jdField_b_of_type_Absa = paramabsa;
  }
  
  public absc a(int paramInt)
  {
    Iterator localIterator = this.L.iterator();
    while (localIterator.hasNext())
    {
      absc localabsc = (absc)localIterator.next();
      if (localabsc.zL() == paramInt) {
        return localabsc;
      }
    }
    return null;
  }
  
  public absc a(int paramInt1, int paramInt2)
  {
    if (this.d == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.ax.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("CmShow_SpriteCreator", 1, "createScript init load but has last script");
        this.L.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      default: 
        localObject = new absd(paramInt1, paramInt2, this.d, this.jdField_b_of_type_Absa);
      }
    }
    while ((localObject != null) && (((absc)localObject).YY()))
    {
      ((absc)localObject).cEs();
      ((absc)localObject).a(this.jdField_b_of_type_Abrk);
      ((absc)localObject).cEr();
      this.L.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new absb(paramInt1, this.d, this.jdField_b_of_type_Absa);
      continue;
      localObject = new absb(paramInt1, "cmshow_base.js", this.d, this.jdField_b_of_type_Absa);
    }
  }
  
  public void cED()
  {
    if (this.d == null) {
      return;
    }
    if (this.d.a() == null)
    {
      QLog.w("CmShow_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
      return;
    }
    a(100, -1);
    this.ax.set(false);
  }
  
  public void clear()
  {
    if ((this.L == null) || (this.L.size() == 0)) {
      return;
    }
    Iterator localIterator = this.L.iterator();
    while (localIterator.hasNext()) {
      ((absc)localIterator.next()).onDestroy();
    }
    this.L.clear();
    this.ax.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absl
 * JD-Core Version:    0.7.0.1
 */