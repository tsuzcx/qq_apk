import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aucx
  implements View.OnClickListener
{
  aucx(aucv paramaucv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mContext.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucx
 * JD-Core Version:    0.7.0.1
 */