import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar.a;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhu
  implements View.OnClickListener
{
  public arhu(PublicMenuBar paramPublicMenuBar, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (PublicMenuBar.a(this.c) != null) {
      PublicMenuBar.b(this.c).B(this.Be, this.RY, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhu
 * JD-Core Version:    0.7.0.1
 */