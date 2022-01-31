import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class tzd
  implements TypeEvaluator<PointF>
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private PointF b;
  
  public tzd(tyz paramtyz, PointF paramPointF1, PointF paramPointF2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF1;
    this.b = paramPointF2;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    PointF localPointF = new PointF();
    localPointF.x = (paramPointF1.x * (1.0F - paramFloat) * (1.0F - paramFloat) * (1.0F - paramFloat) + this.jdField_a_of_type_AndroidGraphicsPointF.x * 3.0F * paramFloat * (1.0F - paramFloat) * (1.0F - paramFloat) + this.b.x * 3.0F * paramFloat * paramFloat * (1.0F - paramFloat) + paramPointF2.x * paramFloat * paramFloat * paramFloat);
    localPointF.y = (paramPointF1.y * (1.0F - paramFloat) * (1.0F - paramFloat) * (1.0F - paramFloat) + this.jdField_a_of_type_AndroidGraphicsPointF.y * 3.0F * paramFloat * (1.0F - paramFloat) * (1.0F - paramFloat) + this.b.y * 3.0F * paramFloat * paramFloat * (1.0F - paramFloat) + paramPointF2.y * paramFloat * paramFloat * paramFloat);
    return localPointF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzd
 * JD-Core Version:    0.7.0.1
 */