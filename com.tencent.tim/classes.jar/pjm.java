import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class pjm
{
  public static void checkZoomLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
  }
  
  static int getPointerIndex(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
  
  public static boolean hasDrawable(ImageView paramImageView)
  {
    return paramImageView.getDrawable() != null;
  }
  
  public static boolean isSupportedScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (pjn.$SwitchMap$android$widget$ImageView$ScaleType[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalStateException("Matrix scale type is not supported");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjm
 * JD-Core Version:    0.7.0.1
 */