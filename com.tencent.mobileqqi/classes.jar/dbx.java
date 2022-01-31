import android.content.Intent;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dbx
  implements Runnable
{
  public dbx(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (!QQLSActivity.a(this.a))
    {
      ReportController.b(QQLSActivity.a(this.a), "CliOper", "", "", "0X800444B", "0X800444B", 0, 0, "", "", "", "");
      Intent localIntent = new Intent(this.a, QQLSUnlockActivity.class);
      this.a.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbx
 * JD-Core Version:    0.7.0.1
 */