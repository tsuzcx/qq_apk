import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.form.GdtFormView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tlx
  implements View.OnClickListener
{
  public tlx(GdtFormView paramGdtFormView) {}
  
  public void onClick(View paramView)
  {
    if (GdtFormView.a(this.b)) {
      GdtFormView.a(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlx
 * JD-Core Version:    0.7.0.1
 */