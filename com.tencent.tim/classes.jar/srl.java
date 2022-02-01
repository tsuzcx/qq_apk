import com.tencent.oskplayer.util.Singleton;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class srl
{
  private static final srl.a a = new srl.a(null);
  private boolean aMD;
  private CopyOnWriteArrayList<srd> z = new CopyOnWriteArrayList();
  
  public static srl a()
  {
    return (srl)a.getInstance();
  }
  
  public void a(srd paramsrd)
  {
    this.z.add(paramsrd);
  }
  
  public void b(srd paramsrd)
  {
    this.z.remove(paramsrd);
  }
  
  public void bAb()
  {
    if (this.z != null)
    {
      Iterator localIterator = this.z.iterator();
      while (localIterator.hasNext()) {
        ((srd)localIterator.next()).onPlay();
      }
    }
  }
  
  public void fx(long paramLong)
  {
    if ((this.z != null) && (!this.aMD))
    {
      Iterator localIterator = this.z.iterator();
      while (localIterator.hasNext()) {
        ((srd)localIterator.next()).fw(paramLong);
      }
    }
  }
  
  public void onVideoStop()
  {
    if (this.z != null)
    {
      Iterator localIterator = this.z.iterator();
      while (localIterator.hasNext()) {
        ((srd)localIterator.next()).onStop();
      }
    }
  }
  
  static class a
    extends Singleton<srl>
  {
    protected srl b()
    {
      return new srl(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srl
 * JD-Core Version:    0.7.0.1
 */