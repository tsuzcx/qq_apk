import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

public class atjm
  extends GradientDrawable
{
  private int mColor;
  private float mRadius;
  private int mStrokeColor;
  private int mStrokeWidth;
  
  public ColorStateList getColor()
  {
    return ColorStateList.valueOf(this.mColor);
  }
  
  public void setColor(int paramInt)
  {
    super.setColor(paramInt);
    this.mColor = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    setCornerRadius(paramFloat);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.mStrokeColor = paramInt;
    setStroke(this.mStrokeWidth, paramInt);
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = paramInt;
    setStroke(paramInt, this.mStrokeColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjm
 * JD-Core Version:    0.7.0.1
 */