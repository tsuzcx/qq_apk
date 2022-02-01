import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class ahbd
  implements ahal.a
{
  ahbd(ahbc paramahbc, Activity paramActivity) {}
  
  public void aD()
  {
    anot.a(null, "dc00898", "", "", "0X800AE48", "0X800AE48", 0, 0, "", "", "", "");
    try
    {
      Intent localIntent = new Intent(this.u, QQBrowserActivity.class);
      localIntent.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
      this.u.startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileManagerUtil<FileAssistant>", 1, "startActivity error", localThrowable);
    }
  }
  
  public void aE()
  {
    anot.a(null, "dc00898", "", "", "0X800AE49", "0X800AE49", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbd
 * JD-Core Version:    0.7.0.1
 */