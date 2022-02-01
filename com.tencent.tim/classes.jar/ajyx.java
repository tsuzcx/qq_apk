import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajyx
  implements View.OnClickListener
{
  public ajyx(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dAe();
    ShortVideoCommentsView.a(this.this$0).setVisibility(8);
    ShortVideoCommentsView.a(this.this$0, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyx
 * JD-Core Version:    0.7.0.1
 */