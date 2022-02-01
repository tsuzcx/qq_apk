import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aewx
{
  private volatile long WU = -1L;
  private final aeyp jdField_a_of_type_Aeyp;
  private final aeyq<aexe> jdField_a_of_type_Aeyq;
  private final List<aexe> mDrawingDanmakuList;
  private final AtomicBoolean mIsUsingSortedQueue;
  
  public aewx(aeyp paramaeyp, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Aeyp = paramaeyp;
    this.jdField_a_of_type_Aeyq = new aeyq(paramDanmakuComparator, new aewy(this));
    this.mDrawingDanmakuList = new LinkedList();
    this.mIsUsingSortedQueue = new AtomicBoolean(false);
  }
  
  private void cXD()
  {
    while (!this.mIsUsingSortedQueue.compareAndSet(false, true))
    {
      aeyw.d("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void cXE()
  {
    while (!this.mIsUsingSortedQueue.compareAndSet(true, false))
    {
      aeyw.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  private void jP(List<aexe> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      aexe localaexe = (aexe)paramList.get(i);
      if (localaexe.getTime() <= this.WU) {
        localaexe.cXT();
      }
      i -= 1;
    }
  }
  
  public int CI()
  {
    return this.jdField_a_of_type_Aeyq.size();
  }
  
  public aexe a()
  {
    return (aexe)this.jdField_a_of_type_Aeyq.peekFirst();
  }
  
  public boolean agC()
  {
    if ((this.mDrawingDanmakuList != null) && (this.mDrawingDanmakuList.size() > 0)) {}
    while ((this.jdField_a_of_type_Aeyq != null) && (this.jdField_a_of_type_Aeyq.size() > 0)) {
      return true;
    }
    return false;
  }
  
  public void cXC()
  {
    cXD();
    aexe localaexe = (aexe)this.jdField_a_of_type_Aeyq.peekLast();
    if (localaexe == null) {}
    for (this.WU = -1L;; this.WU = localaexe.getTime())
    {
      cXE();
      return;
    }
  }
  
  public void clear()
  {
    aeyw.v("DanmakuDataSource", "clear danmaku queue");
    cXD();
    this.jdField_a_of_type_Aeyq.clear();
    cXE();
  }
  
  public void e(aexe paramaexe)
  {
    cXD();
    aeyw.i("DanmakuDataSource", "addNow: danmaku = " + paramaexe);
    this.jdField_a_of_type_Aeyq.o(paramaexe);
    cXE();
  }
  
  public void f(aexe paramaexe)
  {
    cXD();
    aeyw.i("DanmakuDataSource", "addLast: danmaku = " + paramaexe);
    this.jdField_a_of_type_Aeyq.n(paramaexe);
    cXE();
  }
  
  public List<aexe> getDrawingDanmakuList()
  {
    cXD();
    this.jdField_a_of_type_Aeyq.a(this.jdField_a_of_type_Aeyp.get(), this.mDrawingDanmakuList, 3);
    jP(this.mDrawingDanmakuList);
    cXE();
    return this.mDrawingDanmakuList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewx
 * JD-Core Version:    0.7.0.1
 */