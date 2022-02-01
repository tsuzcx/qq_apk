import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

public final class arbd
  implements ThreadExcutor.IThreadListener
{
  long auo = 0L;
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "Web_qqbrowser_pre_get_key, cost=" + (System.currentTimeMillis() - this.auo));
    }
    this.auo = 0L;
  }
  
  public void onPreRun()
  {
    this.auo = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbd
 * JD-Core Version:    0.7.0.1
 */