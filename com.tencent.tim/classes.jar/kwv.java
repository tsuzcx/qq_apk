import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kwv
  implements View.OnClickListener
{
  kwv(kwu paramkwu, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    kwu.a(this.a).bz(this.val$id, this.val$title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwv
 * JD-Core Version:    0.7.0.1
 */