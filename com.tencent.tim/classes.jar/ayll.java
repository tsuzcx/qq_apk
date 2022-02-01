import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class ayll
  extends ValueAnimator
{
  private aylm a;
  private boolean isRotate;
  
  public ayll()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void b(aylk paramaylk1, aylk paramaylk2)
  {
    setObjectValues(new Object[] { paramaylk1, paramaylk2 });
    this.isRotate = aylk.a(paramaylk1, paramaylk2);
  }
  
  public boolean isRotate()
  {
    return this.isRotate;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.a == null) {
      this.a = new aylm();
    }
    setEvaluator(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayll
 * JD-Core Version:    0.7.0.1
 */