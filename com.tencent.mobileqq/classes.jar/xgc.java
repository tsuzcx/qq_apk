import java.util.TimerTask;

public abstract class xgc
  extends TimerTask
{
  private boolean a;
  
  public abstract void a();
  
  public boolean a()
  {
    return this.a;
  }
  
  public void run()
  {
    a();
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgc
 * JD-Core Version:    0.7.0.1
 */