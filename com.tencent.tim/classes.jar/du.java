import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Map;

public abstract class du
  extends BaseAdapter
{
  long lastShowTime = 0L;
  private Map<Long, Long> q = new HashMap();
  
  public abstract int af();
  
  public abstract long c(int paramInt);
  
  public void cj()
  {
    this.lastShowTime = 0L;
    this.q.clear();
    int j = af();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        long l = c(i);
        if (l > this.lastShowTime + 180L)
        {
          this.lastShowTime = l;
          this.q.put(Long.valueOf(d(i)), Long.valueOf(this.lastShowTime));
        }
        i += 1;
      }
    }
  }
  
  public void ck()
  {
    int i = af();
    if (i == 0) {}
    long l;
    do
    {
      return;
      l = c(i - 1);
    } while (l <= this.lastShowTime + 180L);
    this.lastShowTime = l;
    this.q.put(Long.valueOf(d(i - 1)), Long.valueOf(this.lastShowTime));
  }
  
  public abstract long d(int paramInt);
  
  public boolean e(long paramLong)
  {
    return this.q.containsKey(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     du
 * JD-Core Version:    0.7.0.1
 */