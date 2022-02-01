package dov.com.qq.im;

import axov;
import axpr;
import ayva.a;
import ayva.b;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class QIMEffectCameraCaptureUnit$8
  implements Runnable
{
  QIMEffectCameraCaptureUnit$8(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    Object localObject = ((axpr)axov.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = this.this$0.a;
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      localObject = ((ayva.a)localObject).a(0);
      if (localObject != null)
      {
        localVideoFilterViewPager.bD(((ayva.b)localObject).filterList);
        localVideoFilterViewPager.eTR();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.8
 * JD-Core Version:    0.7.0.1
 */