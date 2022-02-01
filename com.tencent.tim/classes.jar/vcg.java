import android.os.Bundle;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class vcg
  implements aogs.a
{
  public vcg(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void bp(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.this$0.bPz();
    }
    do
    {
      do
      {
        return;
        if (i == 2)
        {
          this.this$0.bPz();
          return;
        }
      } while (i != 3);
      i = paramBundle.getInt("percent");
    } while (!QLog.isDevelopLevel());
    QLog.d("GeneralSettingActivity", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
  }
  
  public void bq(Bundle paramBundle)
  {
    this.this$0.bPz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcg
 * JD-Core Version:    0.7.0.1
 */