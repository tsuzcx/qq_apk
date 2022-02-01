package dov.com.qq.im;

import axov;
import axpr;
import aycb;
import ayva;
import ayva.a;
import ayva.b;
import ayzs;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class QIMEffectCameraCaptureUnit$7
  implements Runnable
{
  QIMEffectCameraCaptureUnit$7(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager begin");
    }
    VideoFilterViewPager localVideoFilterViewPager = this.this$0.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
    if (localVideoFilterViewPager == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload filterPager null ");
      }
    }
    do
    {
      return;
      localVideoFilterViewPager.setCaptureScene(0);
      Object localObject = ((axpr)axov.a(5)).a;
      ayzs localayzs = (ayzs)axov.a(3);
      if (localObject != null)
      {
        localObject = ((ayva.a)localObject).a(0);
        if (localObject != null)
        {
          localVideoFilterViewPager.bD(((ayva.b)localObject).filterList);
          localVideoFilterViewPager.eTR();
        }
      }
      ayva.a().setCurrentId(null);
      ayva.a().a(null, this.this$0.jdField_a_of_type_Aycb.getActivity(), 0);
      axpa.eGt = 0;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */