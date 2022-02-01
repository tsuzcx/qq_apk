import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.EffectSettingUi.2.1;
import com.tencent.av.ui.EffectSettingUi.2.2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class iyv
  implements jht.a
{
  public iyv(EffectSettingUi paramEffectSettingUi) {}
  
  public void h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.hG();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.a.TAG, 1, "onStatusChanged, seq[" + l + "]");
    }
    if (this.a.mApp == null) {
      return;
    }
    this.a.mApp.getHandler().post(new EffectSettingUi.2.2(this, l, paramBoolean3, paramBoolean1, paramBoolean2));
  }
  
  public void jG(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.a.TAG, 4, "onGetConfig, enable[" + paramBoolean + "]");
    }
    if (paramBoolean)
    {
      Object localObject = this.a.mContext;
      if (localObject != null)
      {
        localObject = (AVActivity)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AVActivity)localObject).runOnUiThread(new EffectSettingUi.2.1(this));
        }
      }
      return;
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyv
 * JD-Core Version:    0.7.0.1
 */