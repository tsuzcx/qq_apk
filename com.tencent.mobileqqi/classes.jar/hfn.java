import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy;
import com.tencent.qphone.base.util.QLog;

public class hfn
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public hfn(CameraFrameLayoutProxy paramCameraFrameLayoutProxy) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "onSharedPreferenceChanged begin");
    }
    if ((paramSharedPreferences == null) || (CameraFrameLayoutProxy.a(this.a) == null)) {}
    do
    {
      do
      {
        QQAppInterface localQQAppInterface;
        do
        {
          return;
          localQQAppInterface = (QQAppInterface)((BaseActivity)CameraFrameLayoutProxy.a(this.a)).getAppRuntime();
        } while ((!CameraUtil.a(localQQAppInterface, paramString)) || (!CameraUtil.a(localQQAppInterface, CameraFrameLayoutProxy.a(this.a))) || (!CameraUtil.b(localQQAppInterface)));
        boolean bool = paramSharedPreferences.getBoolean(paramString, false);
        if (QLog.isColorLevel()) {
          QLog.d("CameraFrameLayoutProxy", 2, "onSharedPreferenceChanged isOpen:" + bool + "  mIsOpen:" + this.a.b);
        }
        if (!bool) {
          break;
        }
        if ((CameraFrameLayoutProxy.a(this.a) != null) && (CameraFrameLayoutProxy.a(this.a).b())) {
          this.a.b = false;
        }
      } while (this.a.b);
      CameraFrameLayoutProxy.a(this.a);
      return;
    } while (!this.a.b);
    CameraFrameLayoutProxy.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfn
 * JD-Core Version:    0.7.0.1
 */