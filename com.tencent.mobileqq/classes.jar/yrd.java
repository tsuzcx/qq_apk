import android.graphics.PointF;
import android.support.annotation.NonNull;

public class yrd
{
  public final float a;
  public final int a;
  public final PointF a;
  public final String a;
  public final float b;
  public final int b;
  public final float c;
  public final int c;
  public final float d;
  public final int d;
  
  public yrd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Float = paramFloat5;
    this.jdField_d_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
  }
  
  public yrd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Float = paramFloat5;
    this.jdField_d_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
  }
  
  public static yrd a(@NonNull yrd paramyrd)
  {
    return new yrd(paramyrd.jdField_a_of_type_AndroidGraphicsPointF.x, paramyrd.jdField_a_of_type_AndroidGraphicsPointF.y, paramyrd.jdField_a_of_type_Float, paramyrd.jdField_b_of_type_Float, paramyrd.jdField_c_of_type_Float, paramyrd.jdField_d_of_type_Float, paramyrd.jdField_a_of_type_Int, paramyrd.jdField_b_of_type_Int, paramyrd.jdField_a_of_type_JavaLangString, paramyrd.jdField_c_of_type_Int, paramyrd.jdField_d_of_type_Int);
  }
  
  public String toString()
  {
    return "LayerParams{centerP=" + this.jdField_a_of_type_AndroidGraphicsPointF + ", scale=" + this.jdField_a_of_type_Float + ", rotate=" + this.jdField_b_of_type_Float + ", translateXValue=" + this.jdField_c_of_type_Float + ", translateYValue=" + this.jdField_d_of_type_Float + ", width=" + this.jdField_a_of_type_Int + ", height=" + this.jdField_b_of_type_Int + ", text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", textColor=" + this.jdField_c_of_type_Int + ", textSize=" + this.jdField_d_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrd
 * JD-Core Version:    0.7.0.1
 */