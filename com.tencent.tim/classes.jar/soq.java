import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar.a;
import com.tencent.biz.ui.PopupMenu.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class soq
  implements View.OnClickListener
{
  soq(sop paramsop, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b.a != null) {
      this.b.a.B(this.Be, this.RY, 2);
    }
    paramView.post(new PopupMenu.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     soq
 * JD-Core Version:    0.7.0.1
 */