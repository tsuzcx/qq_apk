package dov.com.qq.im;

import acfp;
import android.app.Activity;
import awrq;
import ayca;
import aycb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$7
  implements Runnable
{
  public QIMCameraCaptureUnit$7(awrq paramawrq, int paramInt) {}
  
  public void run()
  {
    switch (this.val$errorCode)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131711180), 1).show();
          Activity localActivity = this.this$0.jdField_a_of_type_Aycb.getActivity();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.this$0.jdField_a_of_type_Ayca.acX(2);
          }
        } while (!this.this$0.cAD);
        this.this$0.eFl();
        return;
        if ((this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.aRv()) && (this.this$0.cAD))
        {
          this.this$0.a(null, false);
          return;
        }
        QQToast.a(BaseApplicationImpl.getContext(), this.this$0.cSo, 0).show();
        this.this$0.cox();
        this.this$0.eFm();
      } while (!this.this$0.cAD);
      this.this$0.eFk();
      return;
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131711182), 0).show();
    } while (!this.this$0.cAD);
    this.this$0.eFk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */