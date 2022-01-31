import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;

public class uod
  implements Runnable
{
  public uod(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      this.a.setResult(-1);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uod
 * JD-Core Version:    0.7.0.1
 */