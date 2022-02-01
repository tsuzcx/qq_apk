import com.tencent.mobileqq.activity.LoginActivity;

public class csy
  implements Runnable
{
  public csy(LoginActivity paramLoginActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.showDialog(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csy
 * JD-Core Version:    0.7.0.1
 */