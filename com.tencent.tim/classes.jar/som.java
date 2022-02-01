import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.CustomMenuBar.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class som
  implements View.OnClickListener
{
  public som(CustomMenuBar paramCustomMenuBar, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a != null) {
      this.this$0.a.B(this.Be, this.RY, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     som
 * JD-Core Version:    0.7.0.1
 */