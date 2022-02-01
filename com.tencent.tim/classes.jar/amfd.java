import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amfd
  implements View.OnClickListener
{
  public amfd(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dNb();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfd
 * JD-Core Version:    0.7.0.1
 */