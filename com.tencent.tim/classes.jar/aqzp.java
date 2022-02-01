import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;

class aqzp
  implements aqnc.a<Integer>
{
  aqzp(aqzl paramaqzl, View paramView, int paramInt) {}
  
  public void a(aqnc<Integer> paramaqnc, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.this$0.a.mIsAnimating) {}
    do
    {
      return;
      this.Jr.getBackground().mutate().setAlpha(paramInteger.intValue());
      this.this$0.a.bPY = paramInteger.intValue();
    } while (this.this$0.a.bPY != this.edV);
    this.this$0.a.mIsAnimating = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzp
 * JD-Core Version:    0.7.0.1
 */