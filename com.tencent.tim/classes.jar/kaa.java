import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;

public class kaa
  implements View.OnClickListener
{
  public kaa(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void onClick(View paramView)
  {
    PublicAccountBrowser.a(this.this$0).callOnClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kaa
 * JD-Core Version:    0.7.0.1
 */