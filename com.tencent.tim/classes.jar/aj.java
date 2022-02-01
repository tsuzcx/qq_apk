import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aj
  implements View.OnClickListener
{
  public aj(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    dl localdl = (dl)((dl)paramView.getTag()).clone();
    this.this$0.a(localdl);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aj
 * JD-Core Version:    0.7.0.1
 */