import android.animation.TypeEvaluator;
import android.graphics.Rect;
import com.tencent.widget.DynamicGridView;

public class autg
  implements TypeEvaluator<Rect>
{
  public autg(DynamicGridView paramDynamicGridView) {}
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    return new Rect(interpolate(paramRect1.left, paramRect2.left, paramFloat), interpolate(paramRect1.top, paramRect2.top, paramFloat), interpolate(paramRect1.right, paramRect2.right, paramFloat), interpolate(paramRect1.bottom, paramRect2.bottom, paramFloat));
  }
  
  public int interpolate(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autg
 * JD-Core Version:    0.7.0.1
 */