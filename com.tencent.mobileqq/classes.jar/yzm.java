import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentView;

public class yzm
  implements View.OnClickListener
{
  public yzm(GdtCanvasAppBtnComponentView paramGdtCanvasAppBtnComponentView) {}
  
  public void onClick(View paramView)
  {
    GdtCanvasAppBtnComponentView.a(this.a).canShowProgress = true;
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzm
 * JD-Core Version:    0.7.0.1
 */