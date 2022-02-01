package dov.com.qq.im.ae;

import acfp;
import android.app.Activity;
import awtq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class AEPituCameraUnit$10
  implements Runnable
{
  public AEPituCameraUnit$10(awtq paramawtq, int paramInt) {}
  
  public void run()
  {
    switch (this.val$errorCode)
    {
    default: 
    case 101: 
    case 104: 
      Activity localActivity;
      do
      {
        return;
        QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131689944), 1).show();
        localActivity = this.this$0.getActivity();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131689945), 0).show();
      this.this$0.cox();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131689943), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.10
 * JD-Core Version:    0.7.0.1
 */