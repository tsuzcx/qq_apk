import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.gdtad.views.form.framework.GdtFormTableView.1.1;

public class tmb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public tmb(GdtFormTableView paramGdtFormTableView) {}
  
  public void onGlobalLayout()
  {
    this.b.showError(-1);
    this.b.post(new GdtFormTableView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmb
 * JD-Core Version:    0.7.0.1
 */