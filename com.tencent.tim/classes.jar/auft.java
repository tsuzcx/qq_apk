import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.SendBottomBar;

public class auft
  implements View.OnClickListener
{
  public auft(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.this$0).isChecked())
    {
      SendBottomBar.a(this.this$0).dfP();
      SendBottomBar.a(this.this$0).setText("取消选择");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.this$0).dfQ();
      SendBottomBar.a(this.this$0).setText("批量选择");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auft
 * JD-Core Version:    0.7.0.1
 */