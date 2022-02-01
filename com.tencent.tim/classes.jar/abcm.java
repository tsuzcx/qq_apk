import android.app.Activity;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abcm
  implements acsl
{
  public abcm(SessionClearFragment paramSessionClearFragment) {}
  
  public void hQ(List<acsf> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onLoadFinish");
    }
    SessionClearFragment.a(this.a).runOnUiThread(new SessionClearFragment.1.1(this, paramList));
  }
  
  public void onLoadStart()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SessionClearFragment", 2, "onLoadStart");
      this.a.showProgressDialog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcm
 * JD-Core Version:    0.7.0.1
 */