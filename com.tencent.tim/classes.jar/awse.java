import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class awse
  implements CosFunHelper.CountDownListener
{
  public awse(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onCountDownEnd()
  {
    QIMEffectCameraCaptureUnit.a(this.this$0);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    QIMEffectCameraCaptureUnit.a(this.this$0, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awse
 * JD-Core Version:    0.7.0.1
 */