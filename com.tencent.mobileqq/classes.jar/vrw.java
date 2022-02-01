import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;

public class vrw
  implements TypeEvaluator<PointF>
{
  PointF jdField_a_of_type_AndroidGraphicsPointF;
  PointF b = new PointF();
  
  public vrw(QCirclePolyLikeAniView paramQCirclePolyLikeAniView, PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
  }
  
  private PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, float paramFloat)
  {
    this.b.x = ((1.0F - paramFloat) * (1.0F - paramFloat) * paramPointF1.x + 2.0F * paramFloat * (1.0F - paramFloat) * paramPointF3.x + paramFloat * paramFloat * paramPointF2.x);
    this.b.y = ((1.0F - paramFloat) * (1.0F - paramFloat) * paramPointF1.y + 2.0F * paramFloat * (1.0F - paramFloat) * paramPointF3.y + paramFloat * paramFloat * paramPointF2.y);
    return this.b;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    return a(paramPointF1, paramPointF2, this.jdField_a_of_type_AndroidGraphicsPointF, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrw
 * JD-Core Version:    0.7.0.1
 */