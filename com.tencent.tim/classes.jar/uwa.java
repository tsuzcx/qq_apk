import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uwa
  implements View.OnClickListener
{
  public uwa(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bNC();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwa
 * JD-Core Version:    0.7.0.1
 */