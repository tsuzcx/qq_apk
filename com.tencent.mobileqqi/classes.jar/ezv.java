import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class ezv
  implements Runnable
{
  public ezv(CircleManager paramCircleManager) {}
  
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
 * Qualified Name:     ezv
 * JD-Core Version:    0.7.0.1
 */