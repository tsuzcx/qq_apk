import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class wfg
{
  static int a(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
  
  public static void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
  }
  
  public static boolean a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (wfh.a[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalStateException("Matrix scale type is not supported");
  }
  
  public static boolean a(ImageView paramImageView)
  {
    return paramImageView.getDrawable() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfg
 * JD-Core Version:    0.7.0.1
 */