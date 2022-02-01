import android.animation.TypeEvaluator;
import android.graphics.Rect;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class nrs
  implements TypeEvaluator<Rect>
{
  public nrs(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    return new Rect(interpolate(paramRect1.left, paramRect2.left, paramFloat), interpolate(paramRect1.top, paramRect2.top, paramFloat), interpolate(paramRect1.right, paramRect2.right, paramFloat), interpolate(paramRect1.bottom, paramRect2.bottom, paramFloat));
  }
  
  public int interpolate(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrs
 * JD-Core Version:    0.7.0.1
 */