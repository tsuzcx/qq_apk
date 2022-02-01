import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahdy
  implements View.OnClickListener
{
  public ahdy(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.this$0) != null) {
      SendBottomBar.a(this.this$0).dfJ();
    }
    ahav.a(SendBottomBar.a(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdy
 * JD-Core Version:    0.7.0.1
 */