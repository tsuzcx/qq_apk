import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mjy
  implements View.OnClickListener
{
  public mjy(ReadInJoyPrivacyListView paramReadInJoyPrivacyListView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPrivacyListView.a(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjy
 * JD-Core Version:    0.7.0.1
 */