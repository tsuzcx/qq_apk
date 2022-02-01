import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.qphone.base.util.QLog;

public class axjb
{
  private static final String TAG = axjb.class.getSimpleName();
  private Activity activity;
  private aqju ad;
  
  public axjb(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private void aG(Runnable paramRunnable)
  {
    if (this.ad != null) {
      return;
    }
    String str = this.activity.getString(2131701579);
    this.ad = aqha.a(this.activity, 230).setMessage(str).setPositiveButton(this.activity.getString(2131695681), new axjc(this, paramRunnable));
  }
  
  public void aF(Runnable paramRunnable)
  {
    try
    {
      aG(paramRunnable);
      if (!this.ad.isShowing())
      {
        this.ad.setCancelable(false);
        this.ad.show();
      }
      return;
    }
    catch (WindowManager.BadTokenException paramRunnable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(TAG, 2, "", paramRunnable);
    }
  }
  
  public void hide()
  {
    if (this.ad != null) {
      this.ad.hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjb
 * JD-Core Version:    0.7.0.1
 */