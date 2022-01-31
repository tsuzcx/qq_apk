import android.view.animation.Interpolator;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class ibf
  implements Interpolator
{
  private ibf(ListView paramListView) {}
  
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibf
 * JD-Core Version:    0.7.0.1
 */