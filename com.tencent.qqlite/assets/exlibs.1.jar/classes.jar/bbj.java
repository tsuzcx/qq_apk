import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bbj
  implements Runnable
{
  public bbj(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    try
    {
      i = ProfileCardMoreActivity.a(this.a, this.a.a.a);
      ProfileCardMoreActivity.a(this.a, false);
      this.a.app.runOnUiThread(new bbk(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbj
 * JD-Core Version:    0.7.0.1
 */