import com.tencent.mobileqq.activity.LoginActivity;

public class ctm
  implements Runnable
{
  public ctm(LoginActivity paramLoginActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.showDialog(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctm
 * JD-Core Version:    0.7.0.1
 */