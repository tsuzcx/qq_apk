import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aixb
{
  private List<aixb.a> CI = Collections.synchronizedList(new ArrayList());
  
  void kd(long paramLong)
  {
    Iterator localIterator = this.CI.iterator();
    while (localIterator.hasNext()) {
      ((aixb.a)localIterator.next()).kd(paramLong);
    }
  }
  
  void ke(long paramLong)
  {
    Iterator localIterator = this.CI.iterator();
    while (localIterator.hasNext()) {
      ((aixb.a)localIterator.next()).ke(paramLong);
    }
  }
  
  public static abstract interface a
  {
    public abstract void kd(long paramLong);
    
    public abstract void ke(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixb
 * JD-Core Version:    0.7.0.1
 */