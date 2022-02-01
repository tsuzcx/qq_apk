import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView.ScaleType;

public class vvo
{
  public float a;
  public PointF a;
  public RectF a;
  public ImageView.ScaleType a;
  public RectF b = new RectF();
  public RectF c = new RectF();
  public RectF d = new RectF();
  
  public vvo(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramRectF4, PointF paramPointF, float paramFloat, ImageView.ScaleType paramScaleType)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF1);
    this.b.set(paramRectF2);
    this.c.set(paramRectF3);
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
    this.d.set(paramRectF4);
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("mRect:");
    if (this.jdField_a_of_type_AndroidGraphicsRectF != null)
    {
      str = this.jdField_a_of_type_AndroidGraphicsRectF.toString();
      localStringBuilder = localStringBuilder.append(str).append(" mImgRect:");
      if (this.b == null) {
        break label159;
      }
      str = this.b.toString();
      label54:
      localStringBuilder = localStringBuilder.append(str).append(" mWidgetRect:");
      if (this.c == null) {
        break label165;
      }
      str = this.c.toString();
      label80:
      localStringBuilder = localStringBuilder.append(str).append(" mBaseRect:");
      if (this.d == null) {
        break label171;
      }
      str = this.d.toString();
      label106:
      localStringBuilder = localStringBuilder.append(str).append(" mWidgetCenter:");
      if (this.jdField_a_of_type_AndroidGraphicsPointF == null) {
        break label177;
      }
    }
    label159:
    label165:
    label171:
    label177:
    for (String str = this.jdField_a_of_type_AndroidGraphicsPointF.toString();; str = "null")
    {
      return str + " mScale:" + this.jdField_a_of_type_Float;
      str = "null";
      break;
      str = "null";
      break label54;
      str = "null";
      break label80;
      str = "null";
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvo
 * JD-Core Version:    0.7.0.1
 */