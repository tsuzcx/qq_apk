import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ashq
  implements View.OnClickListener
{
  public ashq(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashq
 * JD-Core Version:    0.7.0.1
 */