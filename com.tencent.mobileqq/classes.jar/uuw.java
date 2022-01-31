import java.util.concurrent.atomic.AtomicBoolean;

public class uuw
  implements uvi
{
  protected AtomicBoolean c = new AtomicBoolean(false);
  
  public void a() {}
  
  public void b()
  {
    this.c.set(true);
  }
  
  public boolean b()
  {
    return this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuw
 * JD-Core Version:    0.7.0.1
 */