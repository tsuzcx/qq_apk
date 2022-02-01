import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uia
  implements View.OnClickListener
{
  public uia(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.z != null) && (this.this$0.z.isShowing()) && (this.this$0.z.getWindow() != null)) {}
    try
    {
      this.this$0.z.dismiss();
      label46:
      this.this$0.z = null;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uia
 * JD-Core Version:    0.7.0.1
 */