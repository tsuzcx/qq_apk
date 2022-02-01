import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageAlphaSwitchView;

public class akzu
  implements aqnc.a<Float>
{
  public akzu(ImageAlphaSwitchView paramImageAlphaSwitchView) {}
  
  public void a(aqnc<Float> paramaqnc, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.b.alpha = paramFloat1.floatValue();
    if (paramFloat1.floatValue() >= 255.0F)
    {
      this.b.fG = this.b.fH;
      this.b.fH = null;
      this.b.alpha = 0.0F;
      if (this.b.a != null)
      {
        this.b.a.cancel();
        this.b.a = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzu
 * JD-Core Version:    0.7.0.1
 */