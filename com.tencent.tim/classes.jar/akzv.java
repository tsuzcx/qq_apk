import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageShakeAnimView;

public class akzv
  implements aqnc.a<Float>
{
  public akzv(ImageShakeAnimView paramImageShakeAnimView) {}
  
  public void a(aqnc<Float> paramaqnc, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (this.b.cvx)
    {
      if (paramFloat1.floatValue() < 180.0F)
      {
        this.b.ym = (1.0F - paramFloat1.floatValue() * 0.01F / 180.0F);
        this.b.yn = (0.02F * paramFloat1.floatValue() / 180.0F + 1.0F);
        return;
      }
      if (paramFloat1.floatValue() < 360.0F)
      {
        paramaqnc = Float.valueOf(paramFloat1.floatValue() - 180.0F);
        this.b.ym = (0.99F + 0.03F * paramaqnc.floatValue() / 180.0F);
        this.b.yn = (1.02F - paramaqnc.floatValue() * 0.04F / 180.0F);
        return;
      }
      if (paramFloat1.floatValue() < 540.0F)
      {
        paramaqnc = Float.valueOf(paramFloat1.floatValue() - 360.0F);
        this.b.ym = (1.02F - 0.03F * paramaqnc.floatValue() / 180.0F);
        this.b.yn = (paramaqnc.floatValue() * 0.03F / 180.0F + 0.98F);
        return;
      }
      paramaqnc = Float.valueOf(paramFloat1.floatValue() - 540.0F);
      this.b.ym = (0.99F + paramaqnc.floatValue() * 0.01F / 180.0F);
      this.b.yn = (1.01F - paramaqnc.floatValue() * 0.01F / 180.0F);
      return;
    }
    if (paramFloat1.floatValue() < 120.0F)
    {
      this.b.ym = (1.0F - 0.02F * paramFloat1.floatValue() / 120.0F);
      this.b.yn = (paramFloat1.floatValue() * 0.04F / 120.0F + 1.0F);
      return;
    }
    if (paramFloat1.floatValue() < 380.0F)
    {
      paramaqnc = Float.valueOf(paramFloat1.floatValue() - 120.0F);
      this.b.ym = (0.98F + paramaqnc.floatValue() * 0.04F / 260.0F);
      this.b.yn = (1.04F - paramaqnc.floatValue() * 0.08F / 260.0F);
      return;
    }
    paramaqnc = Float.valueOf(paramFloat1.floatValue() - 380.0F);
    this.b.ym = (1.02F - 0.02F * paramaqnc.floatValue() / 120.0F);
    this.b.yn = (paramaqnc.floatValue() * 0.04F / 120.0F + 0.96F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzv
 * JD-Core Version:    0.7.0.1
 */