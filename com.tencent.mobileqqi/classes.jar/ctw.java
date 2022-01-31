import com.tencent.mobileqq.activity.LoginActivity;

public class ctw
  implements Runnable
{
  public ctw(LoginActivity paramLoginActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.showDialog(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctw
 * JD-Core Version:    0.7.0.1
 */