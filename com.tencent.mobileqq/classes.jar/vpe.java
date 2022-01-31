import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class vpe
  implements vpd
{
  private List<vpb> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((vpb)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((vpb)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(vpb paramvpb)
  {
    if (paramvpb == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramvpb)) {
      throw new IllegalStateException("Observer " + paramvpb + " is already registered.");
    }
    this.a.add(paramvpb);
  }
  
  public void b(vpb paramvpb)
  {
    if (paramvpb == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramvpb);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramvpb + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpe
 * JD-Core Version:    0.7.0.1
 */