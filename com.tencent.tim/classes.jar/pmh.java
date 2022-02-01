import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class pmh
  implements ThreadExcutor.IThreadListener
{
  pmh(pmf.a parama, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    pmf.a.a(this.a).decrementAndGet();
    ram.d(pmf.a.a(this.a), "threshold after running current task is " + pmf.a.a(this.a).get());
    if (this.dm != null) {
      ram.d(pmf.a.a(this.a), "threshold after running current task is:" + this.dm.hashCode());
    }
  }
  
  public void onPreRun()
  {
    pmf.a.a(this.a).incrementAndGet();
    ram.b(pmf.a.a(this.a), "execute %s", this.dm);
    if (this.dm != null) {
      ram.d(pmf.a.a(this.a), "execute hashcode:" + this.dm.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmh
 * JD-Core Version:    0.7.0.1
 */