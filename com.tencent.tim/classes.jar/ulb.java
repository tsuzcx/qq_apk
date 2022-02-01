import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class ulb
  implements View.OnClickListener
{
  public ulb(Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    this.val$toast.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulb
 * JD-Core Version:    0.7.0.1
 */