import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.ContainerView;

public class hkd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public hkd(ContainerView paramContainerView) {}
  
  public void onGlobalLayout()
  {
    if (!ContainerView.a(this.a))
    {
      ContainerView.a(this.a, ContainerView.a);
      ContainerView.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hkd
 * JD-Core Version:    0.7.0.1
 */