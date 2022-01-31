import android.view.animation.Interpolator;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class hwl
  implements Interpolator
{
  private hwl(ListView paramListView) {}
  
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hwl
 * JD-Core Version:    0.7.0.1
 */