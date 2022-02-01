import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class czb
  implements Runnable
{
  public czb(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    boolean bool = this.a.b.q();
    this.a.runOnUiThread(new czc(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czb
 * JD-Core Version:    0.7.0.1
 */