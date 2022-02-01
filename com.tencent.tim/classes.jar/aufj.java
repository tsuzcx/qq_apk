import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.SendBottomBar;

public class aufj
  implements View.OnClickListener
{
  public aufj(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.this$0) != null) {
      SendBottomBar.a(this.this$0).dfJ();
    }
    audx.a(SendBottomBar.a(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufj
 * JD-Core Version:    0.7.0.1
 */