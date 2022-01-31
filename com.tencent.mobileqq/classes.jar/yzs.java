import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView;

public class yzs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public yzs(GdtCanvasFormComponentView paramGdtCanvasFormComponentView) {}
  
  public void onGlobalLayout()
  {
    GdtCanvasFormComponentView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzs
 * JD-Core Version:    0.7.0.1
 */