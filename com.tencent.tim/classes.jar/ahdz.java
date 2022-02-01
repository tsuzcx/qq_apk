import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahdz
  implements View.OnClickListener
{
  public ahdz(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.this$0).isChecked())
    {
      SendBottomBar.a(this.this$0).dfP();
      SendBottomBar.a(this.this$0).setText(acfp.m(2131714279));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.this$0).dfQ();
      SendBottomBar.a(this.this$0).setText(acfp.m(2131714291));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdz
 * JD-Core Version:    0.7.0.1
 */