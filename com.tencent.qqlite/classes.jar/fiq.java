import android.view.animation.Interpolator;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class fiq
  implements Interpolator
{
  private fiq(ListView paramListView) {}
  
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fiq
 * JD-Core Version:    0.7.0.1
 */