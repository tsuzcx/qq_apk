import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class armj
  implements View.OnClickListener
{
  public armj(ShareActionSheetV2 paramShareActionSheetV2) {}
  
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
 * Qualified Name:     armj
 * JD-Core Version:    0.7.0.1
 */