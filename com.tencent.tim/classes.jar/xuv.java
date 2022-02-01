import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

public class xuv
  implements View.OnClickListener
{
  public xuv(PhotoListPanel.e parame, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ((PhotoListPanel)this.this$0.ag.get()).onItemClick(paramView, this.val$position);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuv
 * JD-Core Version:    0.7.0.1
 */