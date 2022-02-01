import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.ContainerView;

public class arey
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public arey(ContainerView paramContainerView) {}
  
  public void onGlobalLayout()
  {
    if (!ContainerView.a(this.this$0))
    {
      ContainerView.a(this.this$0, ContainerView.Bg);
      ContainerView.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arey
 * JD-Core Version:    0.7.0.1
 */