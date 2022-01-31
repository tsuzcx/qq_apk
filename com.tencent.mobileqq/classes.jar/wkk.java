import com.tencent.mobileqq.activity.bless.BlessManager;

public class wkk
  implements Runnable
{
  public wkk(BlessManager paramBlessManager) {}
  
  public void run()
  {
    if (BlessManager.a(this.a) != null)
    {
      if (!BlessManager.a(this.a))
      {
        BlessManager.b(this.a, BlessManager.a(this.a, BlessManager.a(this.a), false));
        BlessManager.a(this.a, BlessManager.a(this.a));
        BlessManager.a(this.a, BlessManager.a(this.a), true);
      }
      return;
    }
    BlessManager.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkk
 * JD-Core Version:    0.7.0.1
 */