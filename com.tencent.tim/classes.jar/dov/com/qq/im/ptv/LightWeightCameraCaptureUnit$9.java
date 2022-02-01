package dov.com.qq.im.ptv;

import acfp;
import android.app.Activity;
import ayan;
import ayca;
import aycb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(ayan paramayan, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131707732), 1).show();
        localActivity = this.this$0.jdField_a_of_type_Aycb.getActivity();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Ayca.acX(2);
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131707730), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131707716), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */