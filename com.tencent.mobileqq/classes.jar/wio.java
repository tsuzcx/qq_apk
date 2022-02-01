import java.util.concurrent.atomic.AtomicBoolean;

public class wio
  implements wja
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wio
 * JD-Core Version:    0.7.0.1
 */