import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqme
  implements View.OnClickListener
{
  public aqme(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.an.isShowing())
    {
      this.this$0.an.cancel();
      this.this$0.an.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqme
 * JD-Core Version:    0.7.0.1
 */