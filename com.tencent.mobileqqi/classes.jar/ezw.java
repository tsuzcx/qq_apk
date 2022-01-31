import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class ezw
  implements Runnable
{
  public ezw(CircleManager paramCircleManager) {}
  
  public void run()
  {
    if (this.a.b != null)
    {
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IGroupObserver)localIterator.next()).a(true, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezw
 * JD-Core Version:    0.7.0.1
 */