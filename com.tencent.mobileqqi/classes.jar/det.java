import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class det
  implements Runnable
{
  public det(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    boolean bool = this.a.b.p();
    this.a.runOnUiThread(new deu(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     det
 * JD-Core Version:    0.7.0.1
 */